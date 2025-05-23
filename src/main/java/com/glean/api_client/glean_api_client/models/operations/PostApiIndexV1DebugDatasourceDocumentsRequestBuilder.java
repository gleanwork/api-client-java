/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.glean.api_client.glean_api_client.models.components.DebugDocumentsRequest;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Exception;
import java.lang.String;

public class PostApiIndexV1DebugDatasourceDocumentsRequestBuilder {

    private String datasource;
    private DebugDocumentsRequest debugDocumentsRequest;
    private final SDKMethodInterfaces.MethodCallPostApiIndexV1DebugDatasourceDocuments sdk;

    public PostApiIndexV1DebugDatasourceDocumentsRequestBuilder(SDKMethodInterfaces.MethodCallPostApiIndexV1DebugDatasourceDocuments sdk) {
        this.sdk = sdk;
    }

    public PostApiIndexV1DebugDatasourceDocumentsRequestBuilder datasource(String datasource) {
        Utils.checkNotNull(datasource, "datasource");
        this.datasource = datasource;
        return this;
    }

    public PostApiIndexV1DebugDatasourceDocumentsRequestBuilder debugDocumentsRequest(DebugDocumentsRequest debugDocumentsRequest) {
        Utils.checkNotNull(debugDocumentsRequest, "debugDocumentsRequest");
        this.debugDocumentsRequest = debugDocumentsRequest;
        return this;
    }

    public PostApiIndexV1DebugDatasourceDocumentsResponse call() throws Exception {

        return sdk.debugMany(
            datasource,
            debugDocumentsRequest);
    }
}
