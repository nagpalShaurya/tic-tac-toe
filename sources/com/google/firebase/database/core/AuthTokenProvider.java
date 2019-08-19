package com.google.firebase.database.core;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public interface AuthTokenProvider {

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public interface GetTokenCompletionListener {
        void onError(String str);

        void onSuccess(String str);
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public interface TokenChangeListener {
        void onTokenChange();

        void onTokenChange(String str);
    }

    void addTokenChangeListener(TokenChangeListener tokenChangeListener);

    void getToken(boolean z, GetTokenCompletionListener getTokenCompletionListener);

    void removeTokenChangeListener(TokenChangeListener tokenChangeListener);
}
