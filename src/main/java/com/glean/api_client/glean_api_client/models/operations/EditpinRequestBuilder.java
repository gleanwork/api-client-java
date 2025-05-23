/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.glean.api_client.glean_api_client.models.components.EditPinRequest;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Exception;

public class EditpinRequestBuilder {

    private EditPinRequest request;
    private final SDKMethodInterfaces.MethodCallEditpin sdk;

    public EditpinRequestBuilder(SDKMethodInterfaces.MethodCallEditpin sdk) {
        this.sdk = sdk;
    }

    public EditpinRequestBuilder request(EditPinRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public EditpinResponse call() throws Exception {

        return sdk.update(
            request);
    }
}
