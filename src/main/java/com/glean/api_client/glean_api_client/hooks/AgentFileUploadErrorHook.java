package com.glean.api_client.glean_api_client.hooks;

import com.glean.api_client.glean_api_client.models.errors.APIException;
import com.glean.api_client.glean_api_client.models.errors.AsyncAPIException;
import com.glean.api_client.glean_api_client.utils.AsyncHook;
import com.glean.api_client.glean_api_client.utils.Hook;
import com.glean.api_client.glean_api_client.utils.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Hook that provides helpful error messages when developers incorrectly pass file objects
 * directly to agent run operations instead of using the two-step upload process.
 */
public final class AgentFileUploadErrorHook {

    private AgentFileUploadErrorHook() {
        // prevent instantiation
    }

    /**
     * Creates a synchronous AfterError hook for agent file upload errors.
     */
    public static Hook.AfterError createSyncHook() {
        return (context, response, error) -> {
            if (response.isPresent()) {
                HttpResponse<InputStream> httpResponse = response.get();
                String operationId = context.operationId();

                if (("createAndWaitRun".equals(operationId) || "createAndStreamRun".equals(operationId))
                        && httpResponse.statusCode() == 400) {
                    try {
                        byte[] bodyBytes = Utils.extractByteArrayFromBody(httpResponse);
                        String bodyText = new String(bodyBytes, StandardCharsets.UTF_8).toLowerCase();

                        if (bodyText.contains("permission")) {
                            String helpfulMessage = buildFileUploadErrorMessage();
                            throw APIException.from(helpfulMessage, httpResponse);
                        }
                    } catch (IOException e) {
                        // If we can't read the body, fall through to original error handling
                    }
                }
            }

            if (error.isPresent()) {
                throw error.get();
            }
            return response.get();
        };
    }

    /**
     * Creates an asynchronous AfterError hook for agent file upload errors.
     */
    public static AsyncHook.AfterError createAsyncHook() {
        return (context, response, error) -> {
            if (response != null) {
                String operationId = context.operationId();

                if (("createAndWaitRun".equals(operationId) || "createAndStreamRun".equals(operationId))
                        && response.statusCode() == 400) {
                    return response.body().toByteArray()
                            .thenApply(bodyBytes -> {
                                String bodyText = new String(bodyBytes, StandardCharsets.UTF_8).toLowerCase();

                                if (bodyText.contains("permission")) {
                                    String helpfulMessage = buildFileUploadErrorMessage();
                                    throw new AsyncAPIException(
                                            helpfulMessage,
                                            response.statusCode(),
                                            bodyBytes,
                                            response,
                                            null);
                                }

                                return response;
                            })
                            .exceptionally(ex -> {
                                if (ex instanceof AsyncAPIException) {
                                    throw (AsyncAPIException) ex;
                                }
                                return response;
                            });
                }
            }

            if (error != null) {
                return CompletableFuture.failedFuture(error);
            }
            return CompletableFuture.completedFuture(response);
        };
    }

    private static String buildFileUploadErrorMessage() {
        return "File upload error: Agent runs require a two-step process for file inputs.\n\n" +
               "Step 1: Upload the file using chat.uploadFiles() to get a file ID:\n" +
               "  UploadchatfilesResponse uploadResponse = sdk.client().chat().uploadFiles(\n" +
               "      UploadChatFilesRequest.builder()\n" +
               "          .files(List.of(new File(\"path/to/file.csv\")))\n" +
               "          .build());\n" +
               "  String fileId = uploadResponse.uploadChatFilesResponse()\n" +
               "      .flatMap(UploadChatFilesResponse::files)\n" +
               "      .map(files -> files.get(0))\n" +
               "      .flatMap(ChatFile::id)\n" +
               "      .orElseThrow();\n\n" +
               "Step 2: Pass the file ID (as a string) to agents.run() in the input map:\n" +
               "  AgentRunCreate runRequest = AgentRunCreate.builder()\n" +
               "      .agentId(\"your-agent-id\")\n" +
               "      .input(Map.of(\"fileId\", fileId))\n" +
               "      .build();\n" +
               "  CreateAndWaitRunResponse response = sdk.client().agents().run(runRequest);\n\n" +
               "See examples/AgentWithFileUpload.java for a complete working example.";
    }
}
