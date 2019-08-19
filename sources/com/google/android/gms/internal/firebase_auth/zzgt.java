package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

public final class zzgt<K, V> {
    static <K, V> void zza(zzez zzez, zzgu<K, V> zzgu, K k, V v) throws IOException {
        zzfj.zza(zzez, zzgu.zzzc, 1, k);
        zzfj.zza(zzez, zzgu.zzze, 2, v);
    }

    static <K, V> int zza(zzgu<K, V> zzgu, K k, V v) {
        return zzfj.zza(zzgu.zzzc, 1, k) + zzfj.zza(zzgu.zzze, 2, v);
    }
}
