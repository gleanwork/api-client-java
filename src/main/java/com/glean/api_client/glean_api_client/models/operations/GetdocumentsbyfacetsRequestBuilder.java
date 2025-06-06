/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.glean.api_client.glean_api_client.models.components.GetDocumentsByFacetsRequest;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Exception;
import java.util.Optional;

public class GetdocumentsbyfacetsRequestBuilder {

    private Optional<? extends GetDocumentsByFacetsRequest> request = Optional.empty();
    private final SDKMethodInterfaces.MethodCallGetdocumentsbyfacets sdk;

    public GetdocumentsbyfacetsRequestBuilder(SDKMethodInterfaces.MethodCallGetdocumentsbyfacets sdk) {
        this.sdk = sdk;
    }
                
    public GetdocumentsbyfacetsRequestBuilder request(GetDocumentsByFacetsRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = Optional.of(request);
        return this;
    }

    public GetdocumentsbyfacetsRequestBuilder request(Optional<? extends GetDocumentsByFacetsRequest> request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public GetdocumentsbyfacetsResponse call() throws Exception {

        return sdk.retrieveByFacets(
            request);
    }
}
