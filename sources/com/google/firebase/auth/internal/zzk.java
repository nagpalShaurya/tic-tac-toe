package com.google.firebase.auth.internal;

import android.support.annotation.Nullable;
import com.google.firebase.auth.FirebaseAuthSettings;

public final class zzk extends FirebaseAuthSettings {
    private String zzho;
    private String zzhq;

    @Nullable
    public final String getPhoneNumber() {
        return this.zzhq;
    }

    @Nullable
    public final String getSmsCode() {
        return this.zzho;
    }

    public final boolean zzee() {
        return (this.zzhq == null || this.zzho == null) ? false : true;
    }

    public final void setAutoRetrievedSmsCodeForPhoneNumber(@Nullable String str, @Nullable String str2) {
        this.zzhq = str;
        this.zzho = str2;
    }
}
