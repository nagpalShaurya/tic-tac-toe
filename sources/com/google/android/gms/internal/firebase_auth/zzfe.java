package com.google.android.gms.internal.firebase_auth;

final class zzfe {
    private static final Class<?> zztt = zzgl();

    private static Class<?> zzgl() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzff zzgm() {
        if (zztt != null) {
            try {
                return zzdb("getEmptyRegistry");
            } catch (Exception e) {
            }
        }
        return zzff.zztx;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.firebase_auth.zzff zzgn() {
        /*
            java.lang.Class<?> r0 = zztt
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = "loadGeneratedRegistry"
            com.google.android.gms.internal.firebase_auth.zzff r0 = zzdb(r0)     // Catch:{ Exception -> 0x000c }
            goto L_0x000e
        L_0x000c:
            r0 = move-exception
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 != 0) goto L_0x0014
            com.google.android.gms.internal.firebase_auth.zzff r0 = com.google.android.gms.internal.firebase_auth.zzff.zzgn()
        L_0x0014:
            if (r0 != 0) goto L_0x001a
            com.google.android.gms.internal.firebase_auth.zzff r0 = zzgm()
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzfe.zzgn():com.google.android.gms.internal.firebase_auth.zzff");
    }

    private static final zzff zzdb(String str) throws Exception {
        return (zzff) zztt.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
