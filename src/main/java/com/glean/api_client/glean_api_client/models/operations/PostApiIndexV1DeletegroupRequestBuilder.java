/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.models.operations;

import com.glean.api_client.glean_api_client.models.components.DeleteGroupRequest;
import com.glean.api_client.glean_api_client.utils.Utils;
import java.lang.Exception;

public class PostApiIndexV1DeletegroupRequestBuilder {

    private DeleteGroupRequest request;
    private final SDKMethodInterfaces.MethodCallPostApiIndexV1Deletegroup sdk;

    public PostApiIndexV1DeletegroupRequestBuilder(SDKMethodInterfaces.MethodCallPostApiIndexV1Deletegroup sdk) {
        this.sdk = sdk;
    }

    public PostApiIndexV1DeletegroupRequestBuilder request(DeleteGroupRequest request) {
        Utils.checkNotNull(request, "request");
        this.request = request;
        return this;
    }

    public PostApiIndexV1DeletegroupResponse call() throws Exception {

        return sdk.deleteGroup(
            request);
    }
}
