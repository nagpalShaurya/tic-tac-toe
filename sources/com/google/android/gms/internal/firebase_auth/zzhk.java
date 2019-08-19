package com.google.android.gms.internal.firebase_auth;

final class zzhk {
    private static final zzhi zzaac = zzis();
    private static final zzhi zzaad = new zzhj();

    static zzhi zziq() {
        return zzaac;
    }

    static zzhi zzir() {
        return zzaad;
    }

    private static zzhi zzis() {
        try {
            return (zzhi) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
