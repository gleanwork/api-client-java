/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Exception;
import java.lang.String;

public class GetreportstatusRequestBuilder {

    private String id;
    private final SDKMethodInterfaces.MethodCallGetreportstatus sdk;

    public GetreportstatusRequestBuilder(SDKMethodInterfaces.MethodCallGetreportstatus sdk) {
        this.sdk = sdk;
    }

    public GetreportstatusRequestBuilder id(String id) {
        Utils.checkNotNull(id, "id");
        this.id = id;
        return this;
    }

    public GetreportstatusResponse call() throws Exception {

        return sdk.status(
            id);
    }
}
