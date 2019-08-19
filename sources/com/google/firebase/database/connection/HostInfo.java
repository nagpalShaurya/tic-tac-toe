package com.google.firebase.database.connection;

import java.net.URI;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class HostInfo {
    private static final String LAST_SESSION_ID_PARAM = "ls";
    private static final String VERSION_PARAM = "v";
    private final String host;
    private final String namespace;
    private final boolean secure;

    public HostInfo(String host2, String namespace2, boolean secure2) {
        this.host = host2;
        this.namespace = namespace2;
        this.secure = secure2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("http");
        sb.append(this.secure ? "s" : "");
        sb.append("://");
        sb.append(this.host);
        return sb.toString();
    }

    public static URI getConnectionUrl(String host2, boolean secure2, String namespace2, String optLastSessionId) {
        String scheme = secure2 ? "wss" : "ws";
        StringBuilder sb = new StringBuilder();
        sb.append(scheme);
        sb.append("://");
        sb.append(host2);
        sb.append("/.ws?ns=");
        sb.append(namespace2);
        sb.append("&");
        sb.append(VERSION_PARAM);
        sb.append("=");
        sb.append("5");
        String url = sb.toString();
        if (optLastSessionId != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(url);
            sb2.append("&ls=");
            sb2.append(optLastSessionId);
            url = sb2.toString();
        }
        return URI.create(url);
    }

    public String getHost() {
        return this.host;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public boolean isSecure() {
        return this.secure;
    }
}
