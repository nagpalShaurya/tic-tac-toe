package com.google.firebase.database.core;

import java.net.URI;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class RepoInfo {
    private static final String LAST_SESSION_ID_PARAM = "ls";
    private static final String VERSION_PARAM = "v";
    public String host;
    public String internalHost;
    public String namespace;
    public boolean secure;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("http");
        sb.append(this.secure ? "s" : "");
        sb.append("://");
        sb.append(this.host);
        return sb.toString();
    }

    public String toDebugString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(host=");
        sb.append(this.host);
        sb.append(", secure=");
        sb.append(this.secure);
        sb.append(", ns=");
        sb.append(this.namespace);
        sb.append(" internal=");
        sb.append(this.internalHost);
        sb.append(")");
        return sb.toString();
    }

    public URI getConnectionURL(String optLastSessionId) {
        String scheme = this.secure ? "wss" : "ws";
        StringBuilder sb = new StringBuilder();
        sb.append(scheme);
        sb.append("://");
        sb.append(this.internalHost);
        sb.append("/.ws?ns=");
        sb.append(this.namespace);
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

    public boolean isCacheableHost() {
        return this.internalHost.startsWith("s-");
    }

    public boolean isSecure() {
        return this.secure;
    }

    public boolean isDemoHost() {
        return this.host.contains(".firebaseio-demo.com");
    }

    public boolean isCustomHost() {
        return !this.host.contains(".firebaseio.com") && !this.host.contains(".firebaseio-demo.com");
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RepoInfo repoInfo = (RepoInfo) o;
        if (this.secure == repoInfo.secure && this.host.equals(repoInfo.host)) {
            return this.namespace.equals(repoInfo.namespace);
        }
        return false;
    }

    public int hashCode() {
        return (((this.host.hashCode() * 31) + (this.secure ? 1 : 0)) * 31) + this.namespace.hashCode();
    }
}
