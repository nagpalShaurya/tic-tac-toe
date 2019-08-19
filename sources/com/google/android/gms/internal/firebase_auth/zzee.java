package com.google.android.gms.internal.firebase_auth;

final class zzee {
    private static final Class<?> zzsk = zzcx("libcore.io.Memory");
    private static final boolean zzsl = (zzcx("org.robolectric.Robolectric") != null);

    static boolean zzex() {
        return zzsk != null && !zzsl;
    }

    static Class<?> zzey() {
        return zzsk;
    }

    private static <T> Class<T> zzcx(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }
}
