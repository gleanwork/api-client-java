package examples;

import com.glean.api_client.glean_api_client.Glean;
import com.glean.api_client.glean_api_client.models.components.AgentRunCreate;
import com.glean.api_client.glean_api_client.models.components.ChatFile;
import com.glean.api_client.glean_api_client.models.components.UploadChatFilesRequest;
import com.glean.api_client.glean_api_client.models.components.UploadChatFilesResponse;
import com.glean.api_client.glean_api_client.models.operations.CreateAndWaitRunResponse;
import com.glean.api_client.glean_api_client.models.operations.UploadchatfilesResponse;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Example demonstrating the correct workflow for uploading files and using them with agent runs.
 *
 * This example shows the two-step process required:
 * 1. Upload the file using chat.uploadFiles() to get a file ID
 * 2. Pass the file ID (as a string) to agents.run() in the input map
 */
public class AgentWithFileUpload {

    public static void main(String[] args) throws Exception {
        // Initialize the SDK client
        Glean sdk = Glean.builder()
                .apiToken(System.getenv().getOrDefault("GLEAN_API_TOKEN", ""))
                .build();

        // Step 1: Upload a file to get a file ID
        File sampleFile = new File("sample_data.csv");

        UploadchatfilesResponse uploadResponse = sdk.client().chat().uploadFiles(
                UploadChatFilesRequest.builder()
                        .files(List.of(sampleFile))
                        .build());

        // Extract the file ID from the response
        String fileId = uploadResponse.uploadChatFilesResponse()
                .flatMap(UploadChatFilesResponse::files)
                .map(files -> {
                    if (files.isEmpty()) {
                        throw new RuntimeException("No files returned from upload");
                    }
                    return files.get(0);
                })
                .flatMap(ChatFile::id)
                .orElseThrow(() -> new RuntimeException("File ID not found in upload response"));

        System.out.println("File uploaded successfully. File ID: " + fileId);

        // Step 2: Create an agent run with the file ID in the input map
        // Note: The file ID must be passed as a string, not as a file object
        Map<String, Object> input = new HashMap<>();
        input.put("fileId", fileId);
        // Add any other input parameters your agent requires
        input.put("query", "Analyze this file");

        AgentRunCreate runRequest = AgentRunCreate.builder()
                .agentId("your-agent-id")
                .input(Optional.of(input))
                .build();

        CreateAndWaitRunResponse response = sdk.client().agents().run(runRequest);

        // Handle the response
        if (response.agentRunWaitResponse().isPresent()) {
            System.out.println("Agent run completed successfully");
            // Process the response as needed
        }
    }
}
