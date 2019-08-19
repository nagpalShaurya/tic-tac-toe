package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.p000v4.app.NotificationCompat;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.EventInterceptor;
import com.google.android.gms.measurement.AppMeasurement.OnEventListener;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcs extends zzf {
    @VisibleForTesting
    protected zzdm zzaqv;
    private EventInterceptor zzaqw;
    private final Set<OnEventListener> zzaqx = new CopyOnWriteArraySet();
    private boolean zzaqy;
    private final AtomicReference<String> zzaqz = new AtomicReference<>();
    @VisibleForTesting
    protected boolean zzara = true;

    protected zzcs(zzbt zzbt) {
        super(zzbt);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgt() {
        return false;
    }

    public final void zzks() {
        if (getContext().getApplicationContext() instanceof Application) {
            ((Application) getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzaqv);
        }
    }

    public final Boolean zzkt() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzgn().zza(atomicReference, 15000, "boolean test flag value", new zzct(this, atomicReference));
    }

    public final String zzku() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzgn().zza(atomicReference, 15000, "String test flag value", new zzdd(this, atomicReference));
    }

    public final Long zzkv() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzgn().zza(atomicReference, 15000, "long test flag value", new zzdf(this, atomicReference));
    }

    public final Integer zzkw() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzgn().zza(atomicReference, 15000, "int test flag value", new zzdg(this, atomicReference));
    }

    public final Double zzkx() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzgn().zza(atomicReference, 15000, "double test flag value", new zzdh(this, atomicReference));
    }

    public final void setMeasurementEnabled(boolean z) {
        zzcl();
        zzgb();
        zzgn().zzc((Runnable) new zzdi(this, z));
    }

    public final void zzd(boolean z) {
        zzcl();
        zzgb();
        zzgn().zzc((Runnable) new zzdj(this, z));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzk(boolean z) {
        zzaf();
        zzgb();
        zzcl();
        zzgo().zzjk().zzg("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzgp().setMeasurementEnabled(z);
        zzky();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzky() {
        if (zzgq().zze(zzgf().zzal(), zzaf.zzalj)) {
            this.zzadj.zzj(false);
        }
        if (!zzgq().zzbd(zzgf().zzal()) || !this.zzadj.isEnabled() || !this.zzara) {
            zzgo().zzjk().zzbx("Updating Scion state (FE)");
            zzgg().zzlc();
            return;
        }
        zzgo().zzjk().zzbx("Recording app launch after enabling measurement for the first time (FE)");
        zzkz();
    }

    public final void setMinimumSessionDuration(long j) {
        zzgb();
        zzgn().zzc((Runnable) new zzdk(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzgb();
        zzgn().zzc((Runnable) new zzdl(this, j));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        logEvent(str, str2, bundle, false, true, zzbx().currentTimeMillis());
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        logEvent(str, str2, bundle, true, true, zzbx().currentTimeMillis());
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zza(String str, String str2, Bundle bundle) {
        zzgb();
        zzaf();
        zza(str, str2, zzbx().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzgb();
        zzaf();
        zza(str, str2, j, bundle, true, this.zzaqw == null || zzfk.zzcv(str2), false, null);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzdn zzdn;
        String str4;
        String str5;
        List list;
        String[] strArr;
        String str6;
        zzdn zzdn2;
        int i;
        int i2;
        long j2;
        int i3;
        String str7 = str;
        String str8 = str2;
        Bundle bundle2 = bundle;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(bundle);
        zzaf();
        zzcl();
        if (!this.zzadj.isEnabled()) {
            zzgo().zzjk().zzbx("Event not sent since app measurement is disabled");
            return;
        }
        int i4 = 0;
        if (!this.zzaqy) {
            this.zzaqy = true;
            try {
                try {
                    Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", new Class[]{Context.class}).invoke(null, new Object[]{getContext()});
                } catch (Exception e) {
                    zzgo().zzjg().zzg("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException e2) {
                zzgo().zzjj().zzbx("Tag Manager is not found and thus will not be used");
            }
        }
        if (z3) {
            zzgr();
            if (!"_iap".equals(str8)) {
                zzfk zzgm = this.zzadj.zzgm();
                String str9 = NotificationCompat.CATEGORY_EVENT;
                if (!zzgm.zzr(str9, str8)) {
                    i3 = 2;
                } else if (!zzgm.zza(str9, Event.zzadk, str8)) {
                    i3 = 13;
                } else if (!zzgm.zza(str9, 40, str8)) {
                    i3 = 2;
                } else {
                    i3 = 0;
                }
                if (i3 != 0) {
                    zzgo().zzjf().zzg("Invalid public event name. Event will not be logged (FE)", zzgl().zzbs(str8));
                    this.zzadj.zzgm();
                    this.zzadj.zzgm().zza(i3, "_ev", zzfk.zza(str8, 40, true), str8 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        zzgr();
        zzdn zzla = zzgh().zzla();
        String str10 = "_sc";
        if (zzla != null && !bundle2.containsKey(str10)) {
            zzla.zzarn = true;
        }
        zzdo.zza(zzla, bundle2, z && z3);
        boolean equals = "am".equals(str7);
        boolean zzcv = zzfk.zzcv(str2);
        if (z && this.zzaqw != null && !zzcv && !equals) {
            zzgo().zzjk().zze("Passing event to registered event handler (FE)", zzgl().zzbs(str8), zzgl().zzd(bundle2));
            this.zzaqw.interceptEvent(str, str2, bundle, j);
        } else if (this.zzadj.zzkr()) {
            int zzcr = zzgm().zzcr(str8);
            if (zzcr != 0) {
                zzgo().zzjf().zzg("Invalid event name. Event will not be logged (FE)", zzgl().zzbs(str8));
                zzgm();
                String zza = zzfk.zza(str8, 40, true);
                if (str8 != null) {
                    i4 = str2.length();
                }
                this.zzadj.zzgm().zza(str3, zzcr, "_ev", zza, i4);
                return;
            }
            String str11 = "_o";
            String str12 = "_sn";
            String str13 = "_si";
            List listOf = CollectionUtils.listOf((T[]) new String[]{str11, str12, str10, str13});
            String str14 = str13;
            String str15 = str12;
            String str16 = str11;
            zzdn zzdn3 = zzla;
            String str17 = str10;
            Bundle zza2 = zzgm().zza(str3, str2, bundle, listOf, z3, true);
            if (zza2 == null || !zza2.containsKey(str17) || !zza2.containsKey(str14)) {
                zzdn = null;
            } else {
                zzdn = new zzdn(zza2.getString(str15), zza2.getString(str17), Long.valueOf(zza2.getLong(str14)).longValue());
            }
            if (zzdn == null) {
                zzdn = zzdn3;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza2);
            long nextLong = zzgm().zzmd().nextLong();
            String[] strArr2 = (String[]) zza2.keySet().toArray(new String[bundle.size()]);
            Arrays.sort(strArr2);
            int length = strArr2.length;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                str4 = "_eid";
                if (i6 >= length) {
                    break;
                }
                String str18 = strArr2[i6];
                Object obj = zza2.get(str18);
                zzgm();
                Bundle[] zze = zzfk.zze(obj);
                if (zze != null) {
                    strArr = strArr2;
                    zza2.putInt(str18, zze.length);
                    int i7 = 0;
                    while (true) {
                        i = length;
                        if (i7 >= zze.length) {
                            break;
                        }
                        Bundle bundle3 = zze[i7];
                        long j3 = nextLong;
                        zzdo.zza(zzdn, bundle3, true);
                        Bundle[] bundleArr = zze;
                        String str19 = str4;
                        int i8 = i5;
                        Bundle bundle4 = bundle3;
                        int i9 = i6;
                        List list2 = listOf;
                        List list3 = listOf;
                        String str20 = str16;
                        long j4 = j3;
                        zzdn zzdn4 = zzdn;
                        String str21 = str18;
                        Bundle zza3 = zzgm().zza(str3, "_ep", bundle4, list2, z3, false);
                        zza3.putString("_en", str8);
                        String str22 = str19;
                        zza3.putLong(str22, j4);
                        zza3.putString("_gn", str21);
                        Bundle[] bundleArr2 = bundleArr;
                        zza3.putInt("_ll", bundleArr2.length);
                        zza3.putInt("_i", i7);
                        arrayList.add(zza3);
                        i7++;
                        nextLong = j4;
                        i6 = i9;
                        zze = bundleArr2;
                        length = i;
                        str16 = str20;
                        i5 = i8;
                        listOf = list3;
                        str4 = str22;
                        str18 = str21;
                        zzdn = zzdn4;
                    }
                    list = listOf;
                    str6 = str16;
                    zzdn2 = zzdn;
                    i2 = i6;
                    j2 = nextLong;
                    i5 += zze.length;
                } else {
                    list = listOf;
                    str6 = str16;
                    strArr = strArr2;
                    zzdn2 = zzdn;
                    i = length;
                    int i10 = i5;
                    i2 = i6;
                    j2 = nextLong;
                }
                i6 = i2 + 1;
                strArr2 = strArr;
                nextLong = j2;
                length = i;
                zzdn = zzdn2;
                str16 = str6;
                listOf = list;
            }
            String str23 = str16;
            String str24 = str4;
            int i11 = i5;
            long j5 = nextLong;
            if (i11 != 0) {
                zza2.putLong(str24, j5);
                zza2.putInt("_epc", i11);
            }
            int i12 = 0;
            while (i12 < arrayList.size()) {
                Bundle bundle5 = (Bundle) arrayList.get(i12);
                String str25 = i12 != 0 ? "_ep" : str8;
                String str26 = str23;
                bundle5.putString(str26, str7);
                if (z2) {
                    bundle5 = zzgm().zze(bundle5);
                }
                zzgo().zzjk().zze("Logging event (FE)", zzgl().zzbs(str8), zzgl().zzd(bundle5));
                String str27 = str8;
                ArrayList arrayList2 = arrayList;
                zzad zzad = new zzad(str25, new zzaa(bundle5), str, j);
                zzgg().zzb(zzad, str3);
                if (!equals) {
                    str5 = str26;
                    for (OnEventListener onEvent : this.zzaqx) {
                        onEvent.onEvent(str, str2, new Bundle(bundle5), j);
                    }
                } else {
                    str5 = str26;
                }
                i12++;
                str23 = str5;
                str8 = str27;
                arrayList = arrayList2;
            }
            String str28 = str8;
            zzgr();
            if (zzgh().zzla() != null && Event.APP_EXCEPTION.equals(str28)) {
                zzgj().zzn(true);
            }
        }
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3;
        Bundle bundle2;
        boolean z3;
        zzgb();
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        if (z2) {
            if (this.zzaqw != null && !zzfk.zzcv(str2)) {
                z3 = false;
                zzb(str3, str2, j, bundle2, z2, z3, !z, null);
            }
        }
        z3 = true;
        zzb(str3, str2, j, bundle2, z2, z3, !z, null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle zzf = zzfk.zzf(bundle);
        zzbo zzgn = zzgn();
        zzcu zzcu = new zzcu(this, str, str2, j, zzf, z, z2, z3, str3);
        zzgn.zzc((Runnable) zzcu);
    }

    public final void zzb(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzbx().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        String str3;
        if (str == null) {
            str3 = "app";
        } else {
            str3 = str;
        }
        int i = 6;
        int i2 = 0;
        if (z || "_ap".equals(str2)) {
            i = zzgm().zzcs(str2);
        } else {
            zzfk zzgm = zzgm();
            String str4 = "user property";
            if (zzgm.zzr(str4, str2)) {
                if (!zzgm.zza(str4, UserProperty.zzado, str2)) {
                    i = 15;
                } else if (zzgm.zza(str4, 24, str2)) {
                    i = 0;
                }
            }
        }
        String str5 = "_ev";
        if (i != 0) {
            zzgm();
            String zza = zzfk.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzadj.zzgm().zza(i, str5, zza, i2);
        } else if (obj != null) {
            int zzi = zzgm().zzi(str2, obj);
            if (zzi != 0) {
                zzgm();
                String zza2 = zzfk.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzadj.zzgm().zza(zzi, str5, zza2, i2);
                return;
            }
            Object zzj = zzgm().zzj(str2, obj);
            if (zzj != null) {
                zza(str3, str2, j, zzj);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzbo zzgn = zzgn();
        zzcv zzcv = new zzcv(this, str, str2, obj, j);
        zzgn.zzc((Runnable) zzcv);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b2  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r8, java.lang.String r9, java.lang.Object r10, long r11) {
        /*
            r7 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            r7.zzaf()
            r7.zzgb()
            r7.zzcl()
            com.google.android.gms.measurement.internal.zzn r0 = r7.zzgq()
            com.google.android.gms.measurement.internal.zzaj r1 = r7.zzgf()
            java.lang.String r1 = r1.zzal()
            com.google.android.gms.measurement.internal.zzaf$zza<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzaf.zzalj
            boolean r0 = r0.zze(r1, r2)
            java.lang.String r1 = "_ap"
            if (r0 == 0) goto L_0x0094
            boolean r0 = r1.equals(r9)
            if (r0 == 0) goto L_0x009b
            java.lang.String r0 = "auto"
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x009b
            boolean r0 = r10 instanceof java.lang.String
            if (r0 == 0) goto L_0x007a
            r0 = r10
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x007a
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toLowerCase(r1)
            java.lang.String r1 = "true"
            boolean r0 = r1.equals(r0)
            r2 = 1
            if (r0 != 0) goto L_0x005c
            java.lang.String r0 = "1"
            boolean r10 = r0.equals(r10)
            if (r10 == 0) goto L_0x0059
            goto L_0x005c
        L_0x0059:
            r4 = 0
            goto L_0x005d
        L_0x005c:
            r4 = r2
        L_0x005d:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzba r0 = r7.zzgp()
            com.google.android.gms.measurement.internal.zzbf r0 = r0.zzans
            r4 = r10
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            java.lang.String r1 = "false"
        L_0x0075:
            r0.zzcc(r1)
            r5 = r10
            goto L_0x009c
        L_0x007a:
            if (r10 != 0) goto L_0x009b
            com.google.android.gms.measurement.internal.zzba r0 = r7.zzgp()
            com.google.android.gms.measurement.internal.zzbf r0 = r0.zzans
            java.lang.String r1 = "unset"
            r0.zzcc(r1)
            com.google.android.gms.measurement.internal.zzbo r0 = r7.zzgn()
            com.google.android.gms.measurement.internal.zzcw r1 = new com.google.android.gms.measurement.internal.zzcw
            r1.<init>(r7)
            r0.zzc(r1)
            goto L_0x009b
        L_0x0094:
            boolean r0 = r1.equals(r9)
            if (r0 == 0) goto L_0x009b
            return
        L_0x009b:
            r5 = r10
        L_0x009c:
            com.google.android.gms.measurement.internal.zzbt r10 = r7.zzadj
            boolean r10 = r10.isEnabled()
            if (r10 != 0) goto L_0x00b2
            com.google.android.gms.measurement.internal.zzap r8 = r7.zzgo()
            com.google.android.gms.measurement.internal.zzar r8 = r8.zzjk()
            java.lang.String r9 = "User property not set since app measurement is disabled"
            r8.zzbx(r9)
            return
        L_0x00b2:
            com.google.android.gms.measurement.internal.zzbt r10 = r7.zzadj
            boolean r10 = r10.zzkr()
            if (r10 != 0) goto L_0x00bb
            return
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzap r10 = r7.zzgo()
            com.google.android.gms.measurement.internal.zzar r10 = r10.zzjk()
            com.google.android.gms.measurement.internal.zzan r0 = r7.zzgl()
            java.lang.String r0 = r0.zzbs(r9)
            java.lang.String r1 = "Setting user property (FE)"
            r10.zze(r1, r0, r5)
            com.google.android.gms.measurement.internal.zzfh r10 = new com.google.android.gms.measurement.internal.zzfh
            r1 = r10
            r2 = r9
            r3 = r11
            r6 = r8
            r1.<init>(r2, r3, r5, r6)
            com.google.android.gms.measurement.internal.zzdr r8 = r7.zzgg()
            r8.zzb(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzcs.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzfh> zzl(boolean z) {
        zzgb();
        zzcl();
        zzgo().zzjk().zzbx("Fetching user attributes (FE)");
        if (zzgn().zzkb()) {
            zzgo().zzjd().zzbx("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzk.isMainThread()) {
            zzgo().zzjd().zzbx("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzadj.zzgn().zzc((Runnable) new zzcx(this, atomicReference, z));
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzgo().zzjg().zzg("Interrupted waiting for get user properties", e);
                }
            }
            List<zzfh> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzgo().zzjg().zzbx("Timed out waiting for get user properties");
            return Collections.emptyList();
        }
    }

    @Nullable
    public final String zzfx() {
        zzgb();
        return (String) this.zzaqz.get();
    }

    @Nullable
    public final String zzaj(long j) {
        if (zzgn().zzkb()) {
            zzgo().zzjd().zzbx("Cannot retrieve app instance id from analytics worker thread");
            return null;
        } else if (zzk.isMainThread()) {
            zzgo().zzjd().zzbx("Cannot retrieve app instance id from main thread");
            return null;
        } else {
            long elapsedRealtime = zzbx().elapsedRealtime();
            String zzak = zzak(120000);
            long elapsedRealtime2 = zzbx().elapsedRealtime() - elapsedRealtime;
            if (zzak == null && elapsedRealtime2 < 120000) {
                zzak = zzak(120000 - elapsedRealtime2);
            }
            return zzak;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzcm(@Nullable String str) {
        this.zzaqz.set(str);
    }

    @Nullable
    private final String zzak(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            zzgn().zzc((Runnable) new zzcy(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException e) {
                zzgo().zzjg().zzbx("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    public final void resetAnalyticsData(long j) {
        if (zzgq().zza(zzaf.zzalk)) {
            zzcm(null);
        }
        zzgn().zzc((Runnable) new zzcz(this, j));
    }

    @WorkerThread
    public final void zzkz() {
        zzaf();
        zzgb();
        zzcl();
        if (this.zzadj.zzkr()) {
            zzgg().zzkz();
            this.zzara = false;
            String zzjw = zzgp().zzjw();
            if (!TextUtils.isEmpty(zzjw)) {
                zzgk().zzcl();
                if (!zzjw.equals(VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzjw);
                    logEvent("auto", "_ou", bundle);
                }
            }
        }
    }

    @WorkerThread
    public final void setEventInterceptor(EventInterceptor eventInterceptor) {
        zzaf();
        zzgb();
        zzcl();
        if (eventInterceptor != null) {
            EventInterceptor eventInterceptor2 = this.zzaqw;
            if (eventInterceptor != eventInterceptor2) {
                Preconditions.checkState(eventInterceptor2 == null, "EventInterceptor already set.");
            }
        }
        this.zzaqw = eventInterceptor;
    }

    public final void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        zzgb();
        zzcl();
        Preconditions.checkNotNull(onEventListener);
        if (!this.zzaqx.add(onEventListener)) {
            zzgo().zzjg().zzbx("OnEventListener already registered");
        }
    }

    public final void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        zzgb();
        zzcl();
        Preconditions.checkNotNull(onEventListener);
        if (!this.zzaqx.remove(onEventListener)) {
            zzgo().zzjg().zzbx("OnEventListener had not been registered");
        }
    }

    public final void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        zzgb();
        ConditionalUserProperty conditionalUserProperty2 = new ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzgo().zzjg().zzbx("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
    }

    public final void setConditionalUserPropertyAs(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mAppId);
        zzga();
        zza(new ConditionalUserProperty(conditionalUserProperty));
    }

    private final void zza(ConditionalUserProperty conditionalUserProperty) {
        long currentTimeMillis = zzbx().currentTimeMillis();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzgm().zzcs(str) != 0) {
            zzgo().zzjd().zzg("Invalid conditional user property name", zzgl().zzbu(str));
        } else if (zzgm().zzi(str, obj) != 0) {
            zzgo().zzjd().zze("Invalid conditional user property value", zzgl().zzbu(str), obj);
        } else {
            Object zzj = zzgm().zzj(str, obj);
            if (zzj == null) {
                zzgo().zzjd().zze("Unable to normalize conditional user property value", zzgl().zzbu(str), obj);
                return;
            }
            conditionalUserProperty.mValue = zzj;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= 15552000000L && j >= 1)) {
                long j2 = conditionalUserProperty.mTimeToLive;
                if (j2 > 15552000000L || j2 < 1) {
                    zzgo().zzjd().zze("Invalid conditional user property time to live", zzgl().zzbu(str), Long.valueOf(j2));
                    return;
                }
                zzgn().zzc((Runnable) new zzda(this, conditionalUserProperty));
                return;
            }
            zzgo().zzjd().zze("Invalid conditional user property timeout", zzgl().zzbu(str), Long.valueOf(j));
        }
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzgb();
        zza((String) null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zzga();
        zza(str, str2, str3, bundle);
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzbx().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzgn().zzc((Runnable) new zzdb(this, conditionalUserProperty));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(ConditionalUserProperty conditionalUserProperty) {
        ConditionalUserProperty conditionalUserProperty2 = conditionalUserProperty;
        zzaf();
        zzcl();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty2.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty2.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty2.mValue);
        if (!this.zzadj.isEnabled()) {
            zzgo().zzjk().zzbx("Conditional property not sent since collection is disabled");
            return;
        }
        zzfh zzfh = new zzfh(conditionalUserProperty2.mName, conditionalUserProperty2.mTriggeredTimestamp, conditionalUserProperty2.mValue, conditionalUserProperty2.mOrigin);
        try {
            zzad zza = zzgm().zza(conditionalUserProperty2.mAppId, conditionalUserProperty2.mTriggeredEventName, conditionalUserProperty2.mTriggeredEventParams, conditionalUserProperty2.mOrigin, 0, true, false);
            zzad zza2 = zzgm().zza(conditionalUserProperty2.mAppId, conditionalUserProperty2.mTimedOutEventName, conditionalUserProperty2.mTimedOutEventParams, conditionalUserProperty2.mOrigin, 0, true, false);
            zzad zza3 = zzgm().zza(conditionalUserProperty2.mAppId, conditionalUserProperty2.mExpiredEventName, conditionalUserProperty2.mExpiredEventParams, conditionalUserProperty2.mOrigin, 0, true, false);
            String str = conditionalUserProperty2.mAppId;
            String str2 = conditionalUserProperty2.mOrigin;
            long j = conditionalUserProperty2.mCreationTimestamp;
            String str3 = conditionalUserProperty2.mTriggerEventName;
            long j2 = conditionalUserProperty2.mTriggerTimeout;
            zzl zzl = r3;
            zzl zzl2 = new zzl(str, str2, zzfh, j, false, str3, zza2, j2, zza, conditionalUserProperty2.mTimeToLive, zza3);
            zzgg().zzd(zzl);
        } catch (IllegalArgumentException e) {
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc(ConditionalUserProperty conditionalUserProperty) {
        ConditionalUserProperty conditionalUserProperty2 = conditionalUserProperty;
        zzaf();
        zzcl();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty2.mName);
        if (!this.zzadj.isEnabled()) {
            zzgo().zzjk().zzbx("Conditional property not cleared since collection is disabled");
            return;
        }
        zzfh zzfh = new zzfh(conditionalUserProperty2.mName, 0, null, null);
        try {
            zzad zza = zzgm().zza(conditionalUserProperty2.mAppId, conditionalUserProperty2.mExpiredEventName, conditionalUserProperty2.mExpiredEventParams, conditionalUserProperty2.mOrigin, conditionalUserProperty2.mCreationTimestamp, true, false);
            String str = conditionalUserProperty2.mAppId;
            String str2 = conditionalUserProperty2.mOrigin;
            long j = conditionalUserProperty2.mCreationTimestamp;
            boolean z = conditionalUserProperty2.mActive;
            String str3 = conditionalUserProperty2.mTriggerEventName;
            long j2 = conditionalUserProperty2.mTriggerTimeout;
            zzl zzl = r3;
            zzl zzl2 = new zzl(str, str2, zzfh, j, z, str3, null, j2, null, conditionalUserProperty2.mTimeToLive, zza);
            zzgg().zzd(zzl);
        } catch (IllegalArgumentException e) {
        }
    }

    public final List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        zzgb();
        return zzf(null, str, str2);
    }

    public final List<ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzga();
        return zzf(str, str2, str3);
    }

    @VisibleForTesting
    private final List<ConditionalUserProperty> zzf(String str, String str2, String str3) {
        if (zzgn().zzkb()) {
            zzgo().zzjd().zzbx("Cannot get conditional user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzk.isMainThread()) {
            zzgo().zzjd().zzbx("Cannot get conditional user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                zzbo zzgn = this.zzadj.zzgn();
                zzdc zzdc = new zzdc(this, atomicReference, str, str2, str3);
                zzgn.zzc((Runnable) zzdc);
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzgo().zzjg().zze("Interrupted waiting for get conditional user properties", str, e);
                }
            }
            List<zzl> list = (List) atomicReference.get();
            if (list == null) {
                zzgo().zzjg().zzg("Timed out waiting for get conditional user properties", str);
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (zzl zzl : list) {
                ConditionalUserProperty conditionalUserProperty = new ConditionalUserProperty();
                conditionalUserProperty.mAppId = zzl.packageName;
                conditionalUserProperty.mOrigin = zzl.origin;
                conditionalUserProperty.mCreationTimestamp = zzl.creationTimestamp;
                conditionalUserProperty.mName = zzl.zzahb.name;
                conditionalUserProperty.mValue = zzl.zzahb.getValue();
                conditionalUserProperty.mActive = zzl.active;
                conditionalUserProperty.mTriggerEventName = zzl.triggerEventName;
                if (zzl.zzahc != null) {
                    conditionalUserProperty.mTimedOutEventName = zzl.zzahc.name;
                    if (zzl.zzahc.zzaid != null) {
                        conditionalUserProperty.mTimedOutEventParams = zzl.zzahc.zzaid.zziv();
                    }
                }
                conditionalUserProperty.mTriggerTimeout = zzl.triggerTimeout;
                if (zzl.zzahd != null) {
                    conditionalUserProperty.mTriggeredEventName = zzl.zzahd.name;
                    if (zzl.zzahd.zzaid != null) {
                        conditionalUserProperty.mTriggeredEventParams = zzl.zzahd.zzaid.zziv();
                    }
                }
                conditionalUserProperty.mTriggeredTimestamp = zzl.zzahb.zzaue;
                conditionalUserProperty.mTimeToLive = zzl.timeToLive;
                if (zzl.zzahe != null) {
                    conditionalUserProperty.mExpiredEventName = zzl.zzahe.name;
                    if (zzl.zzahe.zzaid != null) {
                        conditionalUserProperty.mExpiredEventParams = zzl.zzahe.zzaid.zziv();
                    }
                }
                arrayList.add(conditionalUserProperty);
            }
            return arrayList;
        }
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzgb();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zzga();
        return zzb(str, str2, str3, z);
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzgn().zzkb()) {
            zzgo().zzjd().zzbx("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzk.isMainThread()) {
            zzgo().zzjd().zzbx("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                zzbo zzgn = this.zzadj.zzgn();
                zzde zzde = new zzde(this, atomicReference, str, str2, str3, z);
                zzgn.zzc((Runnable) zzde);
                try {
                    atomicReference.wait(5000);
                } catch (InterruptedException e) {
                    zzgo().zzjg().zzg("Interrupted waiting for get user properties", e);
                }
            }
            List<zzfh> list = (List) atomicReference.get();
            if (list == null) {
                zzgo().zzjg().zzbx("Timed out waiting for get user properties");
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzfh zzfh : list) {
                arrayMap.put(zzfh.name, zzfh.getValue());
            }
            return arrayMap;
        }
    }

    @Nullable
    public final String getCurrentScreenName() {
        zzdn zzlb = this.zzadj.zzgh().zzlb();
        if (zzlb != null) {
            return zzlb.zzuw;
        }
        return null;
    }

    @Nullable
    public final String getCurrentScreenClass() {
        zzdn zzlb = this.zzadj.zzgh().zzlb();
        if (zzlb != null) {
            return zzlb.zzarl;
        }
        return null;
    }

    @Nullable
    public final String getGmpAppId() {
        if (this.zzadj.zzkk() != null) {
            return this.zzadj.zzkk();
        }
        try {
            return GoogleServices.getGoogleAppId();
        } catch (IllegalStateException e) {
            this.zzadj.zzgo().zzjd().zzg("getGoogleAppId failed with exception", e);
            return null;
        }
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
