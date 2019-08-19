package com.google.firebase.database.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class GAuthToken {
    private static final String AUTH_KEY = "auth";
    private static final String TOKEN_KEY = "token";
    private static final String TOKEN_PREFIX = "gauth|";
    private final Map<String, Object> auth;
    private final String token;

    public GAuthToken(String token2, Map<String, Object> auth2) {
        this.token = token2;
        this.auth = auth2;
    }

    public static GAuthToken tryParseFromString(String rawToken) {
        String str = TOKEN_PREFIX;
        if (!rawToken.startsWith(str)) {
            return null;
        }
        try {
            Map<String, Object> tokenMap = JsonMapper.parseJson(rawToken.substring(str.length()));
            return new GAuthToken((String) tokenMap.get(TOKEN_KEY), (Map) tokenMap.get(AUTH_KEY));
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse gauth token", e);
        }
    }

    public String serializeToString() {
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put(TOKEN_KEY, this.token);
        tokenMap.put(AUTH_KEY, this.auth);
        try {
            String json = JsonMapper.serializeJson(tokenMap);
            StringBuilder sb = new StringBuilder();
            sb.append(TOKEN_PREFIX);
            sb.append(json);
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to serialize gauth token", e);
        }
    }

    public String getToken() {
        return this.token;
    }

    public Map<String, Object> getAuth() {
        return this.auth;
    }
}
