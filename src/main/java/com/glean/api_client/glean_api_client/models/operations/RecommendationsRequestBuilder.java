/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.glean.api_client.glean_api_client.models.components.RecommendationsRequest;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Exception;

public class RecommendationsRequestBuilder {

    private RecommendationsRequest request;
    private final SDKMethodInterfaces.MethodCallRecommendations sdk;

    public RecommendationsRequestBuilder(SDKMethodInterfaces.MethodCallRecommendations sdk) {
        this.sdk = sdk;
    }

    public RecommendationsRequestBuilder request(RecommendationsRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public RecommendationsResponse call() throws Exception {

        return sdk.recommendations(
            request);
    }
}
