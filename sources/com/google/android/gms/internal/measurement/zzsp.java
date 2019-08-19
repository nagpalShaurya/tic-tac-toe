package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzsp extends zzsl<Long> {
    zzsp(zzsv zzsv, String str, Long l) {
        super(zzsv, str, l, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzfk */
    public final Long zzfj(String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e) {
            String str2 = this.zzbrc;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 25 + String.valueOf(str).length());
            sb.append("Invalid long value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
