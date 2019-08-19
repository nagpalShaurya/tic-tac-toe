package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

@VisibleForTesting
final class zzak implements zzan {
    private final int zzju;
    private final int zzjv;
    private final Map<String, Integer> zzjw;

    public zzak(int i, int i2, @NonNull Map<String, Integer> map) {
        this.zzju = i;
        this.zzjv = i2;
        this.zzjw = (Map) Preconditions.checkNotNull(map);
    }

    public final boolean zzbr(String str) {
        int i = this.zzju;
        if (i == 0) {
            return true;
        }
        if (this.zzjv <= i) {
            return false;
        }
        Integer num = (Integer) this.zzjw.get(str);
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (num.intValue() <= this.zzju || this.zzjv < num.intValue()) {
            return false;
        }
        return true;
    }
}
