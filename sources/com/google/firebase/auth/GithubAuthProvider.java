package com.google.firebase.auth;

import android.support.annotation.NonNull;

public class GithubAuthProvider {
    public static final String GITHUB_SIGN_IN_METHOD = "github.com";
    public static final String PROVIDER_ID = "github.com";

    private GithubAuthProvider() {
    }

    public static AuthCredential getCredential(@NonNull String str) {
        return new GithubAuthCredential(str);
    }
}
