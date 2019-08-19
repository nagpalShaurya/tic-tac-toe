package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zzh;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.api.internal.zzff;

public final class zzcx implements zzff<zzh> {
    private String zzgc;
    private String zzgh;
    @Nullable
    private String zzgw;
    private ActionCodeSettings zzig;
    private String zzpf;

    public zzcx(@NonNull zzjn zzjn) {
        String str;
        int i = zzcy.zzpg[zzjn.ordinal()];
        if (i == 1) {
            str = "PASSWORD_RESET";
        } else if (i == 2) {
            str = "VERIFY_EMAIL";
        } else if (i != 3) {
            str = "REQUEST_TYPE_UNSET_ENUM_VALUE";
        } else {
            str = "EMAIL_SIGNIN";
        }
        this.zzpf = str;
    }

    public final zzcx zzcb(@NonNull String str) {
        this.zzgh = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzcx zzcc(@NonNull String str) {
        this.zzgc = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzcx zza(@NonNull ActionCodeSettings actionCodeSettings) {
        this.zzig = (ActionCodeSettings) Preconditions.checkNotNull(actionCodeSettings);
        return this;
    }

    public final zzcx zzcd(@Nullable String str) {
        this.zzgw = str;
        return this;
    }

    public final ActionCodeSettings zzcq() {
        return this.zzig;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.firebase_auth.zzhb zzds() {
        /*
            r6 = this;
            com.google.android.gms.internal.firebase_auth.zzj$zzh$zza r0 = com.google.android.gms.internal.firebase_auth.zzj.zzh.zzz()
            java.lang.String r1 = r6.zzpf
            int r2 = r1.hashCode()
            r3 = -1452371317(0xffffffffa96e928b, float:-5.2973722E-14)
            r4 = 2
            r5 = 1
            if (r2 == r3) goto L_0x0031
            r3 = -1341836234(0xffffffffb0053436, float:-4.8459314E-10)
            if (r2 == r3) goto L_0x0027
            r3 = 870738373(0x33e669c5, float:1.0729449E-7)
            if (r2 == r3) goto L_0x001d
        L_0x001c:
            goto L_0x003b
        L_0x001d:
            java.lang.String r2 = "EMAIL_SIGNIN"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x001c
            r1 = 2
            goto L_0x003c
        L_0x0027:
            java.lang.String r2 = "VERIFY_EMAIL"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x001c
            r1 = 1
            goto L_0x003c
        L_0x0031:
            java.lang.String r2 = "PASSWORD_RESET"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x001c
            r1 = 0
            goto L_0x003c
        L_0x003b:
            r1 = -1
        L_0x003c:
            if (r1 == 0) goto L_0x004b
            if (r1 == r5) goto L_0x0048
            if (r1 == r4) goto L_0x0045
            com.google.android.gms.internal.firebase_auth.zzjn r1 = com.google.android.gms.internal.firebase_auth.zzjn.OOB_REQ_TYPE_UNSPECIFIED
            goto L_0x004d
        L_0x0045:
            com.google.android.gms.internal.firebase_auth.zzjn r1 = com.google.android.gms.internal.firebase_auth.zzjn.EMAIL_SIGNIN
            goto L_0x004d
        L_0x0048:
            com.google.android.gms.internal.firebase_auth.zzjn r1 = com.google.android.gms.internal.firebase_auth.zzjn.VERIFY_EMAIL
            goto L_0x004d
        L_0x004b:
            com.google.android.gms.internal.firebase_auth.zzjn r1 = com.google.android.gms.internal.firebase_auth.zzjn.PASSWORD_RESET
        L_0x004d:
            com.google.android.gms.internal.firebase_auth.zzj$zzh$zza r0 = r0.zzb(r1)
            java.lang.String r1 = r6.zzgh
            if (r1 == 0) goto L_0x0058
            r0.zzv(r1)
        L_0x0058:
            java.lang.String r1 = r6.zzgc
            if (r1 == 0) goto L_0x005f
            r0.zzw(r1)
        L_0x005f:
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zzig
            if (r1 == 0) goto L_0x00db
            boolean r1 = r1.getAndroidInstallApp()
            com.google.android.gms.internal.firebase_auth.zzj$zzh$zza r1 = r0.zzc(r1)
            com.google.firebase.auth.ActionCodeSettings r2 = r6.zzig
            boolean r2 = r2.canHandleCodeInApp()
            r1.zzd(r2)
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zzig
            java.lang.String r1 = r1.getUrl()
            if (r1 == 0) goto L_0x0086
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zzig
            java.lang.String r1 = r1.getUrl()
            r0.zzx(r1)
        L_0x0086:
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zzig
            java.lang.String r1 = r1.getIOSBundle()
            if (r1 == 0) goto L_0x0097
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zzig
            java.lang.String r1 = r1.getIOSBundle()
            r0.zzy(r1)
        L_0x0097:
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zzig
            java.lang.String r1 = r1.zzbt()
            if (r1 == 0) goto L_0x00a8
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zzig
            java.lang.String r1 = r1.zzbt()
            r0.zzz(r1)
        L_0x00a8:
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zzig
            java.lang.String r1 = r1.getAndroidPackageName()
            if (r1 == 0) goto L_0x00b9
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zzig
            java.lang.String r1 = r1.getAndroidPackageName()
            r0.zzaa(r1)
        L_0x00b9:
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zzig
            java.lang.String r1 = r1.getAndroidMinimumVersion()
            if (r1 == 0) goto L_0x00ca
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zzig
            java.lang.String r1 = r1.getAndroidMinimumVersion()
            r0.zzab(r1)
        L_0x00ca:
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zzig
            java.lang.String r1 = r1.zzbv()
            if (r1 == 0) goto L_0x00db
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zzig
            java.lang.String r1 = r1.zzbv()
            r0.zzad(r1)
        L_0x00db:
            java.lang.String r1 = r6.zzgw
            if (r1 == 0) goto L_0x00e2
            r0.zzac(r1)
        L_0x00e2:
            com.google.android.gms.internal.firebase_auth.zzhb r0 = r0.zzhm()
            com.google.android.gms.internal.firebase_auth.zzfs r0 = (com.google.android.gms.internal.firebase_auth.zzfs) r0
            com.google.android.gms.internal.firebase_auth.zzj$zzh r0 = (com.google.android.gms.internal.firebase_auth.zzj.zzh) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzcx.zzds():com.google.android.gms.internal.firebase_auth.zzhb");
    }
}
