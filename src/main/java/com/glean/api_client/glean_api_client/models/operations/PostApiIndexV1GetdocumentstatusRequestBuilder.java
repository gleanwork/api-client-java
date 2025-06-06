/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.glean.api_client.glean_api_client.models.components.GetDocumentStatusRequest;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Exception;

public class PostApiIndexV1GetdocumentstatusRequestBuilder {

    private GetDocumentStatusRequest request;
    private final SDKMethodInterfaces.MethodCallPostApiIndexV1Getdocumentstatus sdk;

    public PostApiIndexV1GetdocumentstatusRequestBuilder(SDKMethodInterfaces.MethodCallPostApiIndexV1Getdocumentstatus sdk) {
        this.sdk = sdk;
    }

    public PostApiIndexV1GetdocumentstatusRequestBuilder request(GetDocumentStatusRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public PostApiIndexV1GetdocumentstatusResponse call() throws Exception {

        return sdk.status(
            request);
    }
}
