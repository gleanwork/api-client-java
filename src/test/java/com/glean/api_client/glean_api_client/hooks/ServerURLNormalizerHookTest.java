package com.glean.api_client.glean_api_client.hooks;

import com.glean.api_client.glean_api_client.utils.Hook;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ServerURLNormalizerHookTest {

    @ParameterizedTest
    @CsvSource({
        "example.glean.com,             https://example.glean.com",
        "https://example.glean.com,     https://example.glean.com",
        "http://localhost:8080,          http://localhost:8080",
        "https://example.glean.com///,  https://example.glean.com",
        "https://example.glean.com/api/v1, https://example.glean.com/api/v1",
        "example.glean.com/,            https://example.glean.com",
        "HTTP://EXAMPLE.COM,            HTTP://EXAMPLE.COM",
        "HTTPS://EXAMPLE.COM,           HTTPS://EXAMPLE.COM",
    })
    void normalize(String input, String expected) {
        assertEquals(expected, ServerURLNormalizerHook.normalize(input));
    }

    @ParameterizedTest
    @CsvSource({
        "example.glean.com,             https://example.glean.com",
        "https://example.glean.com///,  https://example.glean.com",
        "http://localhost:8080,          http://localhost:8080",
    })
    void createSyncHook(String input, String expected) {
        Hook.SdkInit hook = ServerURLNormalizerHook.createSyncHook();
        Hook.SdkInitData data = new Hook.SdkInitData(input, null);
        Hook.SdkInitData result = hook.sdkInit(data);
        assertEquals(expected, result.baseUrl());
        assertNull(result.client());
    }
}
