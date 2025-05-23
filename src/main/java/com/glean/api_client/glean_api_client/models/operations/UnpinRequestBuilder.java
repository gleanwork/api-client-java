/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.glean.api_client.glean_api_client.models.components.Unpin;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Exception;

public class UnpinRequestBuilder {

    private Unpin request;
    private final SDKMethodInterfaces.MethodCallUnpin sdk;

    public UnpinRequestBuilder(SDKMethodInterfaces.MethodCallUnpin sdk) {
        this.sdk = sdk;
    }

    public UnpinRequestBuilder request(Unpin request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public UnpinResponse call() throws Exception {

        return sdk.remove(
            request);
    }
}
