/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Exception;

public class ListpinsRequestBuilder {

    private ListpinsRequest request;
    private final SDKMethodInterfaces.MethodCallListpins sdk;

    public ListpinsRequestBuilder(SDKMethodInterfaces.MethodCallListpins sdk) {
        this.sdk = sdk;
    }

    public ListpinsRequestBuilder request(ListpinsRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public ListpinsResponse call() throws Exception {

        return sdk.list(
            request);
    }
}
