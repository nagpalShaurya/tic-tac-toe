package com.google.firebase.auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class FirebaseAuthUserCollisionException extends FirebaseAuthException {
    @Nullable
    private String zzgh;
    @Nullable
    private AuthCredential zzhi;

    public FirebaseAuthUserCollisionException(@NonNull String str, @NonNull String str2) {
        super(str, str2);
    }

    public final FirebaseAuthUserCollisionException zzbo(String str) {
        this.zzgh = str;
        return this;
    }

    public final FirebaseAuthUserCollisionException zza(AuthCredential authCredential) {
        this.zzhi = authCredential;
        return this;
    }

    @Nullable
    public final AuthCredential getUpdatedCredential() {
        return this.zzhi;
    }
}
