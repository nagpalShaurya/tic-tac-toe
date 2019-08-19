package com.google.android.gms.internal.firebase_auth;

final class zzgy {
    private static final zzgw zzzh = zzil();
    private static final zzgw zzzi = new zzgx();

    static zzgw zzij() {
        return zzzh;
    }

    static zzgw zzik() {
        return zzzi;
    }

    private static zzgw zzil() {
        try {
            return (zzgw) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
