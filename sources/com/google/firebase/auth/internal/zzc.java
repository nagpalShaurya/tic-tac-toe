package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.auth.ActionCodeResult;

public final class zzc implements ActionCodeResult {
    private final String zzgh;
    private final int zzqk;
    private final String zzql;

    public zzc(@NonNull zzdg zzdg) {
        if (TextUtils.isEmpty(zzdg.zzad())) {
            this.zzgh = zzdg.getEmail();
        } else {
            this.zzgh = zzdg.zzad();
        }
        this.zzql = zzdg.getEmail();
        if (TextUtils.isEmpty(zzdg.zzea())) {
            this.zzqk = 3;
        } else if (zzdg.zzea().equals("PASSWORD_RESET")) {
            this.zzqk = 0;
        } else if (zzdg.zzea().equals("VERIFY_EMAIL")) {
            this.zzqk = 1;
        } else if (zzdg.zzea().equals("RECOVER_EMAIL")) {
            this.zzqk = 2;
        } else if (zzdg.zzea().equals("EMAIL_SIGNIN")) {
            this.zzqk = 4;
        } else {
            this.zzqk = 3;
        }
    }

    public final int getOperation() {
        return this.zzqk;
    }

    @Nullable
    public final String getData(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.zzql;
        } else if (this.zzqk == 4) {
            return null;
        } else {
            return this.zzgh;
        }
    }
}
