package com.google.android.gms.internal.measurement;

final class zzuy {
    private static final Class<?> zzbvi = zzvk();

    private static Class<?> zzvk() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzuz zzvl() {
        if (zzbvi != null) {
            try {
                return zzfz("getEmptyRegistry");
            } catch (Exception e) {
            }
        }
        return zzuz.zzbvm;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.measurement.zzuz zzvm() {
        /*
            java.lang.Class<?> r0 = zzbvi
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = "loadGeneratedRegistry"
            com.google.android.gms.internal.measurement.zzuz r0 = zzfz(r0)     // Catch:{ Exception -> 0x000c }
            goto L_0x000e
        L_0x000c:
            r0 = move-exception
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 != 0) goto L_0x0014
            com.google.android.gms.internal.measurement.zzuz r0 = com.google.android.gms.internal.measurement.zzuz.zzvm()
        L_0x0014:
            if (r0 != 0) goto L_0x001a
            com.google.android.gms.internal.measurement.zzuz r0 = zzvl()
        L_0x001a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzuy.zzvm():com.google.android.gms.internal.measurement.zzuz");
    }

    private static final zzuz zzfz(String str) throws Exception {
        return (zzuz) zzbvi.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
