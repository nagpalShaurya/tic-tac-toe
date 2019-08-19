package com.google.firebase.database.connection;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public interface ConnectionAuthTokenProvider {

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public interface GetTokenCallback {
        void onError(String str);

        void onSuccess(String str);
    }

    void getToken(boolean z, GetTokenCallback getTokenCallback);
}
