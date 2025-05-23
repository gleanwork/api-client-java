/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.glean.api_client.glean_api_client.models.components.ChatRequest;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Exception;
import java.lang.Long;
import java.util.Optional;

public class ChatRequestBuilder {

    private Optional<Long> timezoneOffset = Optional.empty();
    private ChatRequest chatRequest;
    private final SDKMethodInterfaces.MethodCallChat sdk;

    public ChatRequestBuilder(SDKMethodInterfaces.MethodCallChat sdk) {
        this.sdk = sdk;
    }
                
    public ChatRequestBuilder timezoneOffset(long timezoneOffset) {
        Utils.checkNotNull(timezoneOffset, "timezoneOffset");
        this.timezoneOffset = Optional.of(timezoneOffset);
        return this;
    }

    public ChatRequestBuilder timezoneOffset(Optional<Long> timezoneOffset) {
        Utils.checkNotNull(timezoneOffset, "timezoneOffset");
        this.timezoneOffset = timezoneOffset;
        return this;
    }

    public ChatRequestBuilder chatRequest(ChatRequest chatRequest) {
        Utils.checkNotNull(chatRequest, "chatRequest");
        this.chatRequest = chatRequest;
        return this;
    }

    public ChatResponse call() throws Exception {

        return sdk.create(
            timezoneOffset,
            chatRequest);
    }
}
