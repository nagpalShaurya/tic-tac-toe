package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzsq extends zzsl<Integer> {
    zzsq(zzsv zzsv, String str, Integer num) {
        super(zzsv, str, num, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzfl */
    public final Integer zzfj(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            String str2 = this.zzbrc;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
            sb.append("Invalid integer value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
