package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzsr extends zzsl<Boolean> {
    zzsr(zzsv zzsv, String str, Boolean bool) {
        super(zzsv, str, bool, null);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzfj(String str) {
        if (zzsg.zzbqe.matcher(str).matches()) {
            return Boolean.valueOf(true);
        }
        if (zzsg.zzbqf.matcher(str).matches()) {
            return Boolean.valueOf(false);
        }
        String str2 = this.zzbrc;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
        sb.append("Invalid boolean value for ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
