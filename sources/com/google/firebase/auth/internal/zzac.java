package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.android.gms.internal.firebase_auth.zzz;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public final class zzac {
    @VisibleForTesting
    private static long zzrr = 3600000;
    private static final zzz<String> zzrs = zzz.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", Param.TIMESTAMP);
    private static final zzac zzrt = new zzac();
    private Task<AuthResult> zzru;
    private long zzrv = 0;

    private zzac() {
    }

    public static zzac zzen() {
        return zzrt;
    }

    public static void zza(@NonNull Context context, @NonNull zzdr zzdr, @NonNull String str, @Nullable String str2) {
        Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("verifyAssertionRequest", SafeParcelableSerializer.serializeToString(zzdr));
        edit.putString("operation", str);
        edit.putString("tenantId", str2);
        edit.putLong(Param.TIMESTAMP, DefaultClock.getInstance().currentTimeMillis());
        edit.commit();
    }

    public static void zza(@NonNull Context context, @NonNull Status status) {
        Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putInt("statusCode", status.getStatusCode());
        edit.putString("statusMessage", status.getStatusMessage());
        edit.putLong(Param.TIMESTAMP, DefaultClock.getInstance().currentTimeMillis());
        edit.commit();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007e, code lost:
        if (r4.equals("com.google.firebase.auth.internal.SIGN_IN") == false) goto L_0x0095;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(@android.support.annotation.NonNull com.google.firebase.auth.FirebaseAuth r12) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)
            com.google.firebase.FirebaseApp r0 = r12.zzcc()
            android.content.Context r0 = r0.getApplicationContext()
            r1 = 0
            java.lang.String r2 = "com.google.firebase.auth.internal.ProcessDeathHelper"
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r2, r1)
            java.lang.String r2 = ""
            java.lang.String r3 = "firebaseAppName"
            java.lang.String r3 = r0.getString(r3, r2)
            com.google.firebase.FirebaseApp r4 = r12.zzcc()
            java.lang.String r4 = r4.getName()
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x002a
            return
        L_0x002a:
            java.lang.String r3 = "verifyAssertionRequest"
            boolean r4 = r0.contains(r3)
            r5 = 0
            java.lang.String r7 = "timestamp"
            if (r4 == 0) goto L_0x00f1
            java.lang.String r3 = r0.getString(r3, r2)
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdr> r4 = com.google.android.gms.internal.firebase_auth.zzdr.CREATOR
            com.google.android.gms.common.internal.safeparcel.SafeParcelable r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.deserializeFromString(r3, r4)
            com.google.android.gms.internal.firebase_auth.zzdr r3 = (com.google.android.gms.internal.firebase_auth.zzdr) r3
            java.lang.String r4 = "operation"
            java.lang.String r4 = r0.getString(r4, r2)
            r8 = 0
            java.lang.String r9 = "tenantId"
            java.lang.String r9 = r0.getString(r9, r8)
            long r5 = r0.getLong(r7, r5)
            r11.zzrv = r5
            java.lang.String r5 = "firebaseUserUid"
            java.lang.String r2 = r0.getString(r5, r2)
            if (r9 == 0) goto L_0x0061
            r12.zzc(r9)
        L_0x0061:
            r5 = -1
            int r6 = r4.hashCode()
            r7 = -1843829902(0xffffffff92196372, float:-4.8400863E-28)
            r9 = 2
            r10 = 1
            if (r6 == r7) goto L_0x008b
            r7 = -286760092(0xffffffffeee86364, float:-3.596034E28)
            if (r6 == r7) goto L_0x0081
            r7 = 1731327805(0x6731f73d, float:8.404196E23)
            if (r6 == r7) goto L_0x0078
        L_0x0077:
            goto L_0x0095
        L_0x0078:
            java.lang.String r6 = "com.google.firebase.auth.internal.SIGN_IN"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0077
            goto L_0x0096
        L_0x0081:
            java.lang.String r1 = "com.google.firebase.auth.internal.LINK"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0077
            r1 = 1
            goto L_0x0096
        L_0x008b:
            java.lang.String r1 = "com.google.firebase.auth.internal.REAUTHENTICATE"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L_0x0077
            r1 = 2
            goto L_0x0096
        L_0x0095:
            r1 = -1
        L_0x0096:
            if (r1 == 0) goto L_0x00e1
            if (r1 == r10) goto L_0x00c0
            if (r1 == r9) goto L_0x009f
            r11.zzru = r8
            goto L_0x00ed
        L_0x009f:
            com.google.firebase.auth.FirebaseUser r1 = r12.getCurrentUser()
            java.lang.String r1 = r1.getUid()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00bd
            com.google.firebase.auth.FirebaseUser r12 = r12.getCurrentUser()
            com.google.firebase.auth.zzd r1 = com.google.firebase.auth.zzd.zza(r3)
            com.google.android.gms.tasks.Task r12 = r12.reauthenticateAndRetrieveData(r1)
            r11.zzru = r12
            goto L_0x00ed
        L_0x00bd:
            r11.zzru = r8
            goto L_0x00ed
        L_0x00c0:
            com.google.firebase.auth.FirebaseUser r1 = r12.getCurrentUser()
            java.lang.String r1 = r1.getUid()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00de
            com.google.firebase.auth.FirebaseUser r12 = r12.getCurrentUser()
            com.google.firebase.auth.zzd r1 = com.google.firebase.auth.zzd.zza(r3)
            com.google.android.gms.tasks.Task r12 = r12.linkWithCredential(r1)
            r11.zzru = r12
            goto L_0x00ed
        L_0x00de:
            r11.zzru = r8
            goto L_0x00ed
        L_0x00e1:
            com.google.firebase.auth.zzd r1 = com.google.firebase.auth.zzd.zza(r3)
            com.google.android.gms.tasks.Task r12 = r12.signInWithCredential(r1)
            r11.zzru = r12
        L_0x00ed:
            zza(r0)
            return
        L_0x00f1:
            java.lang.String r12 = "statusCode"
            boolean r1 = r0.contains(r12)
            if (r1 == 0) goto L_0x011f
            r1 = 17062(0x42a6, float:2.3909E-41)
            int r12 = r0.getInt(r12, r1)
            java.lang.String r1 = "statusMessage"
            java.lang.String r1 = r0.getString(r1, r2)
            com.google.android.gms.common.api.Status r2 = new com.google.android.gms.common.api.Status
            r2.<init>(r12, r1)
            long r3 = r0.getLong(r7, r5)
            r11.zzrv = r3
            zza(r0)
            com.google.firebase.FirebaseException r12 = com.google.firebase.auth.api.internal.zzds.zzb(r2)
            com.google.android.gms.tasks.Task r12 = com.google.android.gms.tasks.Tasks.forException(r12)
            r11.zzru = r12
            return
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzac.zzh(com.google.firebase.auth.FirebaseAuth):void");
    }

    public final void zza(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        zza(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.zzru = null;
        this.zzrv = 0;
    }

    private static void zza(@NonNull SharedPreferences sharedPreferences) {
        Editor edit = sharedPreferences.edit();
        zzz zzz = zzrs;
        int size = zzz.size();
        int i = 0;
        while (i < size) {
            Object obj = zzz.get(i);
            i++;
            edit.remove((String) obj);
        }
        edit.commit();
    }
}
