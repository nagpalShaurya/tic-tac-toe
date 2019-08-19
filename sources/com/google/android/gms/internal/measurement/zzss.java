package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzss extends zzsl<Double> {
    zzss(zzsv zzsv, String str, Double d) {
        super(zzsv, str, d, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzfm */
    public final Double zzfj(String str) {
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            String str2 = this.zzbrc;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str).length());
            sb.append("Invalid double value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}
