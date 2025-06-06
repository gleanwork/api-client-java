/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.glean.api_client.glean_api_client.models.components.GetChatRequest;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Exception;
import java.lang.Long;
import java.util.Optional;

public class GetchatRequestBuilder {

    private Optional<Long> timezoneOffset = Optional.empty();
    private GetChatRequest getChatRequest;
    private final SDKMethodInterfaces.MethodCallGetchat sdk;

    public GetchatRequestBuilder(SDKMethodInterfaces.MethodCallGetchat sdk) {
        this.sdk = sdk;
    }
                
    public GetchatRequestBuilder timezoneOffset(long timezoneOffset) {
        Utils.checkNotNull(timezoneOffset, "timezoneOffset");
        this.timezoneOffset = Optional.of(timezoneOffset);
        return this;
    }

    public GetchatRequestBuilder timezoneOffset(Optional<Long> timezoneOffset) {
        Utils.checkNotNull(timezoneOffset, "timezoneOffset");
        this.timezoneOffset = timezoneOffset;
        return this;
    }

    public GetchatRequestBuilder getChatRequest(GetChatRequest getChatRequest) {
        Utils.checkNotNull(getChatRequest, "getChatRequest");
        this.getChatRequest = getChatRequest;
        return this;
    }

    public GetchatResponse call() throws Exception {

        return sdk.retrieve(
            timezoneOffset,
            getChatRequest);
    }
}
