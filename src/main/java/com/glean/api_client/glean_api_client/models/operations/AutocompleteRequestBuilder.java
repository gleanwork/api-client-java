/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.glean.api_client.glean_api_client.models.components.AutocompleteRequest;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Exception;

public class AutocompleteRequestBuilder {

    private AutocompleteRequest request;
    private final SDKMethodInterfaces.MethodCallAutocomplete sdk;

    public AutocompleteRequestBuilder(SDKMethodInterfaces.MethodCallAutocomplete sdk) {
        this.sdk = sdk;
    }

    public AutocompleteRequestBuilder request(AutocompleteRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public AutocompleteResponse call() throws Exception {

        return sdk.autocomplete(
            request);
    }
}
