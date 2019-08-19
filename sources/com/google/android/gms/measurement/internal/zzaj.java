package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzaj extends zzf {
    private String zzafx;
    private String zzage;
    private long zzagh;
    private String zzagk;
    private int zzagy;
    private int zzalo;
    private long zzalp;
    private String zztr;
    private String zzts;
    private String zztt;

    zzaj(zzbt zzbt) {
        super(zzbt);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgt() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01ac A[Catch:{ IllegalStateException -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01ad A[Catch:{ IllegalStateException -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01b6 A[Catch:{ IllegalStateException -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01c9 A[Catch:{ IllegalStateException -> 0x01db }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzgu() {
        /*
            r13 = this;
            android.content.Context r0 = r13.getContext()
            java.lang.String r0 = r0.getPackageName()
            android.content.Context r1 = r13.getContext()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = "Unknown"
            java.lang.String r3 = ""
            r4 = 0
            java.lang.String r5 = "unknown"
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != 0) goto L_0x0033
            com.google.android.gms.measurement.internal.zzap r1 = r13.zzgo()
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzap.zzbv(r0)
            java.lang.String r8 = "PackageManager is null, app identity information might be inaccurate. appId"
            r1.zzg(r8, r7)
            r1 = r2
            goto L_0x009a
        L_0x0033:
            java.lang.String r5 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x0038 }
            goto L_0x004a
        L_0x0038:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzap r7 = r13.zzgo()
            com.google.android.gms.measurement.internal.zzar r7 = r7.zzjd()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzap.zzbv(r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.zzg(r9, r8)
        L_0x004a:
            if (r5 != 0) goto L_0x004f
            java.lang.String r5 = "manual_install"
            goto L_0x0058
        L_0x004f:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x0058
            r5 = r3
        L_0x0058:
            android.content.Context r7 = r13.getContext()     // Catch:{ NameNotFoundException -> 0x0084 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0084 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r4)     // Catch:{ NameNotFoundException -> 0x0084 }
            if (r7 == 0) goto L_0x0082
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0084 }
            java.lang.CharSequence r1 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0084 }
            boolean r8 = android.text.TextUtils.isEmpty(r1)     // Catch:{ NameNotFoundException -> 0x0084 }
            if (r8 != 0) goto L_0x0077
            java.lang.String r1 = r1.toString()     // Catch:{ NameNotFoundException -> 0x0084 }
            goto L_0x0078
        L_0x0077:
            r1 = r2
        L_0x0078:
            java.lang.String r2 = r7.versionName     // Catch:{ NameNotFoundException -> 0x007d }
            int r6 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x007d }
            goto L_0x0083
        L_0x007d:
            r7 = move-exception
            r12 = r2
            r2 = r1
            r1 = r12
            goto L_0x0086
        L_0x0082:
            r1 = r2
        L_0x0083:
            goto L_0x009a
        L_0x0084:
            r1 = move-exception
            r1 = r2
        L_0x0086:
            com.google.android.gms.measurement.internal.zzap r7 = r13.zzgo()
            com.google.android.gms.measurement.internal.zzar r7 = r7.zzjd()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzap.zzbv(r0)
            java.lang.String r9 = "Error retrieving package info. appId, appName"
            r7.zze(r9, r8, r2)
            r12 = r2
            r2 = r1
            r1 = r12
        L_0x009a:
            r13.zztt = r0
            r13.zzage = r5
            r13.zzts = r2
            r13.zzalo = r6
            r13.zztr = r1
            r1 = 0
            r13.zzalp = r1
            r13.zzgr()
            android.content.Context r5 = r13.getContext()
            com.google.android.gms.common.api.Status r5 = com.google.android.gms.common.api.internal.GoogleServices.initialize(r5)
            r6 = 1
            if (r5 == 0) goto L_0x00bf
            boolean r7 = r5.isSuccess()
            if (r7 == 0) goto L_0x00bf
            r7 = 1
            goto L_0x00c0
        L_0x00bf:
            r7 = 0
        L_0x00c0:
            com.google.android.gms.measurement.internal.zzbt r8 = r13.zzadj
            java.lang.String r8 = r8.zzkk()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r9 = "am"
            if (r8 != 0) goto L_0x00dc
            com.google.android.gms.measurement.internal.zzbt r8 = r13.zzadj
            java.lang.String r8 = r8.zzkl()
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x00dc
            r8 = 1
            goto L_0x00dd
        L_0x00dc:
            r8 = 0
        L_0x00dd:
            r7 = r7 | r8
            if (r7 != 0) goto L_0x010a
            if (r5 != 0) goto L_0x00f1
            com.google.android.gms.measurement.internal.zzap r5 = r13.zzgo()
            com.google.android.gms.measurement.internal.zzar r5 = r5.zzjd()
            java.lang.String r8 = "GoogleService failed to initialize (no status)"
            r5.zzbx(r8)
            goto L_0x010a
        L_0x00f1:
            com.google.android.gms.measurement.internal.zzap r8 = r13.zzgo()
            com.google.android.gms.measurement.internal.zzar r8 = r8.zzjd()
            int r10 = r5.getStatusCode()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r5 = r5.getStatusMessage()
            java.lang.String r11 = "GoogleService failed to initialize, status"
            r8.zze(r11, r10, r5)
        L_0x010a:
            if (r7 == 0) goto L_0x0178
            com.google.android.gms.measurement.internal.zzn r5 = r13.zzgq()
            java.lang.Boolean r5 = r5.zzhv()
            com.google.android.gms.measurement.internal.zzn r7 = r13.zzgq()
            boolean r7 = r7.zzhu()
            if (r7 == 0) goto L_0x0135
            com.google.android.gms.measurement.internal.zzbt r5 = r13.zzadj
            boolean r5 = r5.zzkj()
            if (r5 == 0) goto L_0x0178
            com.google.android.gms.measurement.internal.zzap r5 = r13.zzgo()
            com.google.android.gms.measurement.internal.zzar r5 = r5.zzjj()
            java.lang.String r6 = "Collection disabled with firebase_analytics_collection_deactivated=1"
            r5.zzbx(r6)
            goto L_0x0178
        L_0x0135:
            if (r5 == 0) goto L_0x0153
            boolean r7 = r5.booleanValue()
            if (r7 != 0) goto L_0x0153
            com.google.android.gms.measurement.internal.zzbt r5 = r13.zzadj
            boolean r5 = r5.zzkj()
            if (r5 == 0) goto L_0x0178
            com.google.android.gms.measurement.internal.zzap r5 = r13.zzgo()
            com.google.android.gms.measurement.internal.zzar r5 = r5.zzjj()
            java.lang.String r6 = "Collection disabled with firebase_analytics_collection_enabled=0"
            r5.zzbx(r6)
            goto L_0x0178
        L_0x0153:
            if (r5 != 0) goto L_0x0169
            boolean r5 = com.google.android.gms.common.api.internal.GoogleServices.isMeasurementExplicitlyDisabled()
            if (r5 == 0) goto L_0x0169
            com.google.android.gms.measurement.internal.zzap r5 = r13.zzgo()
            com.google.android.gms.measurement.internal.zzar r5 = r5.zzjj()
            java.lang.String r6 = "Collection disabled with google_app_measurement_enable=0"
            r5.zzbx(r6)
            goto L_0x0178
        L_0x0169:
            com.google.android.gms.measurement.internal.zzap r5 = r13.zzgo()
            com.google.android.gms.measurement.internal.zzar r5 = r5.zzjl()
            java.lang.String r7 = "Collection enabled"
            r5.zzbx(r7)
            goto L_0x0179
        L_0x0178:
            r6 = 0
        L_0x0179:
            r13.zzafx = r3
            r13.zzagk = r3
            r13.zzagh = r1
            r13.zzgr()
            com.google.android.gms.measurement.internal.zzbt r1 = r13.zzadj
            java.lang.String r1 = r1.zzkk()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x01a2
            com.google.android.gms.measurement.internal.zzbt r1 = r13.zzadj
            java.lang.String r1 = r1.zzkl()
            boolean r1 = r9.equals(r1)
            if (r1 == 0) goto L_0x01a2
            com.google.android.gms.measurement.internal.zzbt r1 = r13.zzadj
            java.lang.String r1 = r1.zzkk()
            r13.zzagk = r1
        L_0x01a2:
            java.lang.String r1 = com.google.android.gms.common.api.internal.GoogleServices.getGoogleAppId()     // Catch:{ IllegalStateException -> 0x01db }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ IllegalStateException -> 0x01db }
            if (r2 == 0) goto L_0x01ad
            goto L_0x01ae
        L_0x01ad:
            r3 = r1
        L_0x01ae:
            r13.zzafx = r3     // Catch:{ IllegalStateException -> 0x01db }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ IllegalStateException -> 0x01db }
            if (r1 != 0) goto L_0x01c7
            com.google.android.gms.common.internal.StringResourceValueReader r1 = new com.google.android.gms.common.internal.StringResourceValueReader     // Catch:{ IllegalStateException -> 0x01db }
            android.content.Context r2 = r13.getContext()     // Catch:{ IllegalStateException -> 0x01db }
            r1.<init>(r2)     // Catch:{ IllegalStateException -> 0x01db }
            java.lang.String r2 = "gma_app_id"
            java.lang.String r1 = r1.getString(r2)     // Catch:{ IllegalStateException -> 0x01db }
            r13.zzagk = r1     // Catch:{ IllegalStateException -> 0x01db }
        L_0x01c7:
            if (r6 == 0) goto L_0x01da
            com.google.android.gms.measurement.internal.zzap r1 = r13.zzgo()     // Catch:{ IllegalStateException -> 0x01db }
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjl()     // Catch:{ IllegalStateException -> 0x01db }
            java.lang.String r2 = "App package, google app id"
            java.lang.String r3 = r13.zztt     // Catch:{ IllegalStateException -> 0x01db }
            java.lang.String r5 = r13.zzafx     // Catch:{ IllegalStateException -> 0x01db }
            r1.zze(r2, r3, r5)     // Catch:{ IllegalStateException -> 0x01db }
        L_0x01da:
            goto L_0x01ee
        L_0x01db:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzap r2 = r13.zzgo()
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjd()
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzap.zzbv(r0)
            java.lang.String r3 = "getGoogleAppId or isMeasurementEnabled failed with exception. appId"
            r2.zze(r3, r0, r1)
        L_0x01ee:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            if (r0 < r1) goto L_0x01ff
            android.content.Context r0 = r13.getContext()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r13.zzagy = r0
            return
        L_0x01ff:
            r13.zzagy = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaj.zzgu():void");
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final zzh zzbr(String str) {
        String str2;
        zzaf();
        zzgb();
        String zzal = zzal();
        String gmpAppId = getGmpAppId();
        zzcl();
        String str3 = this.zzts;
        long zzja = (long) zzja();
        zzcl();
        String str4 = this.zzage;
        long zzhc = zzgq().zzhc();
        zzcl();
        zzaf();
        if (this.zzalp == 0) {
            this.zzalp = this.zzadj.zzgm().zzd(getContext(), getContext().getPackageName());
        }
        long j = this.zzalp;
        boolean isEnabled = this.zzadj.isEnabled();
        boolean z = !zzgp().zzanv;
        zzaf();
        zzgb();
        if (!zzgq().zzbc(this.zztt) || this.zzadj.isEnabled()) {
            str2 = zziz();
        } else {
            str2 = null;
        }
        zzcl();
        boolean z2 = z;
        String str5 = str2;
        long j2 = this.zzagh;
        long zzkp = this.zzadj.zzkp();
        int zzjb = zzjb();
        zzn zzgq = zzgq();
        zzgq.zzgb();
        Boolean zzau = zzgq.zzau("google_analytics_adid_collection_enabled");
        boolean booleanValue = Boolean.valueOf(zzau == null || zzau.booleanValue()).booleanValue();
        zzn zzgq2 = zzgq();
        zzgq2.zzgb();
        Boolean zzau2 = zzgq2.zzau("google_analytics_ssaid_collection_enabled");
        zzh zzh = new zzh(zzal, gmpAppId, str3, zzja, str4, zzhc, j, str, isEnabled, z2, str5, j2, zzkp, zzjb, booleanValue, Boolean.valueOf(zzau2 == null || zzau2.booleanValue()).booleanValue(), zzgp().zzjx(), zzgw());
        return zzh;
    }

    @WorkerThread
    @VisibleForTesting
    private final String zziz() {
        try {
            Class loadClass = getContext().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception e) {
                    zzgo().zzji().zzbx("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception e2) {
                zzgo().zzjh().zzbx("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException e3) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final String zzal() {
        zzcl();
        return this.zztt;
    }

    /* access modifiers changed from: 0000 */
    public final String getGmpAppId() {
        zzcl();
        return this.zzafx;
    }

    /* access modifiers changed from: 0000 */
    public final String zzgw() {
        zzcl();
        return this.zzagk;
    }

    /* access modifiers changed from: 0000 */
    public final int zzja() {
        zzcl();
        return this.zzalo;
    }

    /* access modifiers changed from: 0000 */
    public final int zzjb() {
        zzcl();
        return this.zzagy;
    }

    public final /* bridge */ /* synthetic */ void zzga() {
        super.zzga();
    }

    public final /* bridge */ /* synthetic */ void zzgb() {
        super.zzgb();
    }

    public final /* bridge */ /* synthetic */ void zzgc() {
        super.zzgc();
    }

    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    public final /* bridge */ /* synthetic */ zza zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzcs zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzaj zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzdr zzgg() {
        return super.zzgg();
    }

    public final /* bridge */ /* synthetic */ zzdo zzgh() {
        return super.zzgh();
    }

    public final /* bridge */ /* synthetic */ zzal zzgi() {
        return super.zzgi();
    }

    public final /* bridge */ /* synthetic */ zzeq zzgj() {
        return super.zzgj();
    }

    public final /* bridge */ /* synthetic */ zzx zzgk() {
        return super.zzgk();
    }

    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzan zzgl() {
        return super.zzgl();
    }

    public final /* bridge */ /* synthetic */ zzfk zzgm() {
        return super.zzgm();
    }

    public final /* bridge */ /* synthetic */ zzbo zzgn() {
        return super.zzgn();
    }

    public final /* bridge */ /* synthetic */ zzap zzgo() {
        return super.zzgo();
    }

    public final /* bridge */ /* synthetic */ zzba zzgp() {
        return super.zzgp();
    }

    public final /* bridge */ /* synthetic */ zzn zzgq() {
        return super.zzgq();
    }

    public final /* bridge */ /* synthetic */ zzk zzgr() {
        return super.zzgr();
    }
}
