/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */
package com.glean.api_client.glean_api_client.utils;

import java.lang.reflect.Field;

class RequestMetadata {

    String mediaType = "application/octet-stream";

    private RequestMetadata() {
    }

    // request:mediaType=multipart/form-data
    static RequestMetadata parse(Field field) throws IllegalArgumentException, IllegalAccessException {
        return Metadata.parse("request", new RequestMetadata(), field);
    }
}
