package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;

public final class zzfa {
    private final String packageName;
    private final String zzof;

    public zzfa(Context context) {
        this(context, context.getPackageName());
    }

    private zzfa(@NonNull Context context, @NonNull String str) {
        String str2 = "FBA-PackageInfo";
        Preconditions.checkNotNull(context);
        this.packageName = Preconditions.checkNotEmpty(str);
        try {
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, this.packageName);
            if (packageCertificateHashBytes == null) {
                String str3 = "single cert required: ";
                String valueOf = String.valueOf(str);
                Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                this.zzof = null;
                return;
            }
            this.zzof = Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
        } catch (NameNotFoundException e) {
            String str4 = "no pkg: ";
            String valueOf2 = String.valueOf(str);
            Log.e(str2, valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4));
            this.zzof = null;
        }
    }

    public final String getPackageName() {
        return this.packageName;
    }

    @Nullable
    public final String zzdq() {
        return this.zzof;
    }
}
