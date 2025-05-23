/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.glean.api_client.glean_api_client.models.components.BulkIndexEmployeesRequest;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Exception;

public class PostApiIndexV1BulkindexemployeesRequestBuilder {

    private BulkIndexEmployeesRequest request;
    private final SDKMethodInterfaces.MethodCallPostApiIndexV1Bulkindexemployees sdk;

    public PostApiIndexV1BulkindexemployeesRequestBuilder(SDKMethodInterfaces.MethodCallPostApiIndexV1Bulkindexemployees sdk) {
        this.sdk = sdk;
    }

    public PostApiIndexV1BulkindexemployeesRequestBuilder request(BulkIndexEmployeesRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public PostApiIndexV1BulkindexemployeesResponse call() throws Exception {

        return sdk.bulkIndex(
            request);
    }
}
