package com.glean.api_client.glean_api_client.hooks;

import com.glean.api_client.glean_api_client.utils.Hook;

import java.util.regex.Pattern;

public final class ServerURLNormalizerHook {

    private static final Pattern SCHEME_PATTERN = Pattern.compile("(?i)^https?://");

    private ServerURLNormalizerHook() {
        // prevent instantiation
    }

    static String normalize(String url) {
        String normalized = url;
        if (!SCHEME_PATTERN.matcher(normalized).find()) {
            normalized = "https://" + normalized;
        }
        normalized = normalized.replaceAll("/+$", "");
        return normalized;
    }

    public static Hook.SdkInit createSyncHook() {
        return data -> new Hook.SdkInitData(normalize(data.baseUrl()), data.client());
    }
}
