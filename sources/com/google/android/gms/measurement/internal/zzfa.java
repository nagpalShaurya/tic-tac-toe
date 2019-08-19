package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzfa implements zzcq {
    private static volatile zzfa zzatc;
    private final zzbt zzadj;
    private zzbn zzatd;
    private zzat zzate;
    private zzq zzatf;
    private zzay zzatg;
    private zzew zzath;
    private zzj zzati;
    private final zzfg zzatj;
    private boolean zzatk;
    @VisibleForTesting
    private long zzatl;
    private List<Runnable> zzatm;
    private int zzatn;
    private int zzato;
    private boolean zzatp;
    private boolean zzatq;
    private boolean zzatr;
    private FileLock zzats;
    private FileChannel zzatt;
    private List<Long> zzatu;
    private List<Long> zzatv;
    private long zzatw;
    private boolean zzvz;

    class zza implements zzs {
        zzgi zzaua;
        List<Long> zzaub;
        List<zzgf> zzauc;
        private long zzaud;

        private zza() {
        }

        public final void zzb(zzgi zzgi) {
            Preconditions.checkNotNull(zzgi);
            this.zzaua = zzgi;
        }

        public final boolean zza(long j, zzgf zzgf) {
            Preconditions.checkNotNull(zzgf);
            if (this.zzauc == null) {
                this.zzauc = new ArrayList();
            }
            if (this.zzaub == null) {
                this.zzaub = new ArrayList();
            }
            if (this.zzauc.size() > 0 && zza((zzgf) this.zzauc.get(0)) != zza(zzgf)) {
                return false;
            }
            long zzvu = this.zzaud + ((long) zzgf.zzvu());
            if (zzvu >= ((long) Math.max(0, ((Integer) zzaf.zzajl.get()).intValue()))) {
                return false;
            }
            this.zzaud = zzvu;
            this.zzauc.add(zzgf);
            this.zzaub.add(Long.valueOf(j));
            if (this.zzauc.size() >= Math.max(1, ((Integer) zzaf.zzajm.get()).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzgf zzgf) {
            return ((zzgf.zzawu.longValue() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzfa zzfa, zzfb zzfb) {
            this();
        }
    }

    public static zzfa zzm(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzatc == null) {
            synchronized (zzfa.class) {
                if (zzatc == null) {
                    zzatc = new zzfa(new zzff(context));
                }
            }
        }
        return zzatc;
    }

    private zzfa(zzff zzff) {
        this(zzff, null);
    }

    private zzfa(zzff zzff, zzbt zzbt) {
        this.zzvz = false;
        Preconditions.checkNotNull(zzff);
        this.zzadj = zzbt.zza(zzff.zzri, (zzak) null);
        this.zzatw = -1;
        zzfg zzfg = new zzfg(this);
        zzfg.zzq();
        this.zzatj = zzfg;
        zzat zzat = new zzat(this);
        zzat.zzq();
        this.zzate = zzat;
        zzbn zzbn = new zzbn(this);
        zzbn.zzq();
        this.zzatd = zzbn;
        this.zzadj.zzgn().zzc((Runnable) new zzfb(this, zzff));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzff zzff) {
        this.zzadj.zzgn().zzaf();
        zzq zzq = new zzq(this);
        zzq.zzq();
        this.zzatf = zzq;
        this.zzadj.zzgq().zza((zzp) this.zzatd);
        zzj zzj = new zzj(this);
        zzj.zzq();
        this.zzati = zzj;
        zzew zzew = new zzew(this);
        zzew.zzq();
        this.zzath = zzew;
        this.zzatg = new zzay(this);
        if (this.zzatn != this.zzato) {
            this.zzadj.zzgo().zzjd().zze("Not all upload components initialized", Integer.valueOf(this.zzatn), Integer.valueOf(this.zzato));
        }
        this.zzvz = true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void start() {
        this.zzadj.zzgn().zzaf();
        zzjq().zzif();
        if (this.zzadj.zzgp().zzane.get() == 0) {
            this.zzadj.zzgp().zzane.set(this.zzadj.zzbx().currentTimeMillis());
        }
        zzlv();
    }

    public final zzk zzgr() {
        return this.zzadj.zzgr();
    }

    public final zzn zzgq() {
        return this.zzadj.zzgq();
    }

    public final zzap zzgo() {
        return this.zzadj.zzgo();
    }

    public final zzbo zzgn() {
        return this.zzadj.zzgn();
    }

    private final zzbn zzln() {
        zza((zzez) this.zzatd);
        return this.zzatd;
    }

    public final zzat zzlo() {
        zza((zzez) this.zzate);
        return this.zzate;
    }

    public final zzq zzjq() {
        zza((zzez) this.zzatf);
        return this.zzatf;
    }

    private final zzay zzlp() {
        zzay zzay = this.zzatg;
        if (zzay != null) {
            return zzay;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzew zzlq() {
        zza((zzez) this.zzath);
        return this.zzath;
    }

    public final zzj zzjp() {
        zza((zzez) this.zzati);
        return this.zzati;
    }

    public final zzfg zzjo() {
        zza((zzez) this.zzatj);
        return this.zzatj;
    }

    public final zzan zzgl() {
        return this.zzadj.zzgl();
    }

    public final Context getContext() {
        return this.zzadj.getContext();
    }

    public final Clock zzbx() {
        return this.zzadj.zzbx();
    }

    public final zzfk zzgm() {
        return this.zzadj.zzgm();
    }

    @WorkerThread
    private final void zzaf() {
        this.zzadj.zzgn().zzaf();
    }

    /* access modifiers changed from: 0000 */
    public final void zzlr() {
        if (!this.zzvz) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zza(zzez zzez) {
        if (zzez == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzez.isInitialized()) {
            String valueOf = String.valueOf(zzez.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zze(zzh zzh) {
        zzaf();
        zzlr();
        Preconditions.checkNotEmpty(zzh.packageName);
        zzg(zzh);
    }

    private final long zzls() {
        long currentTimeMillis = this.zzadj.zzbx().currentTimeMillis();
        zzba zzgp = this.zzadj.zzgp();
        zzgp.zzcl();
        zzgp.zzaf();
        long j = zzgp.zzani.get();
        if (j == 0) {
            j = 1 + ((long) zzgp.zzgm().zzmd().nextInt(86400000));
            zzgp.zzani.set(j);
        }
        return ((((currentTimeMillis + j) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzc(zzad zzad, String str) {
        zzad zzad2 = zzad;
        String str2 = str;
        zzg zzbl = zzjq().zzbl(str2);
        if (zzbl == null || TextUtils.isEmpty(zzbl.zzak())) {
            this.zzadj.zzgo().zzjk().zzg("No app data available; dropping event", str2);
            return;
        }
        Boolean zzc = zzc(zzbl);
        if (zzc == null) {
            if (!"_ui".equals(zzad2.name)) {
                this.zzadj.zzgo().zzjg().zzg("Could not find package. appId", zzap.zzbv(str));
            }
        } else if (!zzc.booleanValue()) {
            this.zzadj.zzgo().zzjd().zzg("App version does not match; dropping event. appId", zzap.zzbv(str));
            return;
        }
        zzh zzh = r2;
        zzg zzg = zzbl;
        zzh zzh2 = new zzh(str, zzbl.getGmpAppId(), zzbl.zzak(), zzbl.zzha(), zzbl.zzhb(), zzbl.zzhc(), zzbl.zzhd(), (String) null, zzbl.isMeasurementEnabled(), false, zzg.getFirebaseInstanceId(), zzg.zzhq(), 0, 0, zzg.zzhr(), zzg.zzhs(), false, zzg.zzgw());
        zzc(zzad2, zzh);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzc(zzad zzad, zzh zzh) {
        List<zzl> list;
        List<zzl> list2;
        List<zzl> list3;
        zzad zzad2 = zzad;
        zzh zzh2 = zzh;
        Preconditions.checkNotNull(zzh);
        Preconditions.checkNotEmpty(zzh2.packageName);
        zzaf();
        zzlr();
        String str = zzh2.packageName;
        long j = zzad2.zzaip;
        if (zzjo().zze(zzad2, zzh2)) {
            if (!zzh2.zzagg) {
                zzg(zzh2);
                return;
            }
            zzjq().beginTransaction();
            try {
                zzq zzjq = zzjq();
                Preconditions.checkNotEmpty(str);
                zzjq.zzaf();
                zzjq.zzcl();
                if (j < 0) {
                    zzjq.zzgo().zzjg().zze("Invalid time querying timed out conditional properties", zzap.zzbv(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzjq.zzb("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzl zzl : list) {
                    if (zzl != null) {
                        this.zzadj.zzgo().zzjk().zzd("User property timed out", zzl.packageName, this.zzadj.zzgl().zzbu(zzl.zzahb.name), zzl.zzahb.getValue());
                        if (zzl.zzahc != null) {
                            zzd(new zzad(zzl.zzahc, j), zzh2);
                        }
                        zzjq().zzk(str, zzl.zzahb.name);
                    }
                }
                zzq zzjq2 = zzjq();
                Preconditions.checkNotEmpty(str);
                zzjq2.zzaf();
                zzjq2.zzcl();
                if (j < 0) {
                    zzjq2.zzgo().zzjg().zze("Invalid time querying expired conditional properties", zzap.zzbv(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzjq2.zzb("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzl zzl2 : list2) {
                    if (zzl2 != null) {
                        this.zzadj.zzgo().zzjk().zzd("User property expired", zzl2.packageName, this.zzadj.zzgl().zzbu(zzl2.zzahb.name), zzl2.zzahb.getValue());
                        zzjq().zzh(str, zzl2.zzahb.name);
                        if (zzl2.zzahe != null) {
                            arrayList.add(zzl2.zzahe);
                        }
                        zzjq().zzk(str, zzl2.zzahb.name);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zzd(new zzad((zzad) obj, j), zzh2);
                }
                zzq zzjq3 = zzjq();
                String str2 = zzad2.name;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzjq3.zzaf();
                zzjq3.zzcl();
                if (j < 0) {
                    zzjq3.zzgo().zzjg().zzd("Invalid time querying triggered conditional properties", zzap.zzbv(str), zzjq3.zzgl().zzbs(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzjq3.zzb("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzl zzl3 : list3) {
                    if (zzl3 != null) {
                        zzfh zzfh = zzl3.zzahb;
                        zzfj zzfj = r4;
                        zzfj zzfj2 = new zzfj(zzl3.packageName, zzl3.origin, zzfh.name, j, zzfh.getValue());
                        if (zzjq().zza(zzfj)) {
                            this.zzadj.zzgo().zzjk().zzd("User property triggered", zzl3.packageName, this.zzadj.zzgl().zzbu(zzfj.name), zzfj.value);
                        } else {
                            this.zzadj.zzgo().zzjd().zzd("Too many active user properties, ignoring", zzap.zzbv(zzl3.packageName), this.zzadj.zzgl().zzbu(zzfj.name), zzfj.value);
                        }
                        if (zzl3.zzahd != null) {
                            arrayList3.add(zzl3.zzahd);
                        }
                        zzl3.zzahb = new zzfh(zzfj);
                        zzl3.active = true;
                        zzjq().zza(zzl3);
                    }
                }
                zzd(zzad, zzh);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    zzd(new zzad((zzad) obj2, j), zzh2);
                }
                zzjq().setTransactionSuccessful();
            } finally {
                zzjq().endTransaction();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:149:0x05f9 A[Catch:{ IOException -> 0x05fc, all -> 0x0671 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0629 A[Catch:{ IOException -> 0x05fc, all -> 0x0671 }] */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzd(com.google.android.gms.measurement.internal.zzad r27, com.google.android.gms.measurement.internal.zzh r28) {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            r2 = r28
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r28)
            java.lang.String r3 = r2.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            long r3 = java.lang.System.nanoTime()
            r26.zzaf()
            r26.zzlr()
            java.lang.String r15 = r2.packageName
            com.google.android.gms.measurement.internal.zzfg r5 = r26.zzjo()
            boolean r5 = r5.zze(r0, r2)
            if (r5 != 0) goto L_0x0025
            return
        L_0x0025:
            boolean r5 = r2.zzagg
            if (r5 != 0) goto L_0x002d
            r1.zzg(r2)
            return
        L_0x002d:
            com.google.android.gms.measurement.internal.zzbn r5 = r26.zzln()
            java.lang.String r6 = r0.name
            boolean r5 = r5.zzo(r15, r6)
            java.lang.String r6 = "_err"
            r20 = 1
            if (r5 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj
            com.google.android.gms.measurement.internal.zzap r2 = r2.zzgo()
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjg()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzap.zzbv(r15)
            com.google.android.gms.measurement.internal.zzbt r4 = r1.zzadj
            com.google.android.gms.measurement.internal.zzan r4 = r4.zzgl()
            java.lang.String r5 = r0.name
            java.lang.String r4 = r4.zzbs(r5)
            java.lang.String r5 = "Dropping blacklisted event. appId"
            r2.zze(r5, r3, r4)
            com.google.android.gms.measurement.internal.zzbn r2 = r26.zzln()
            boolean r2 = r2.zzck(r15)
            if (r2 != 0) goto L_0x0075
            com.google.android.gms.measurement.internal.zzbn r2 = r26.zzln()
            boolean r2 = r2.zzcl(r15)
            if (r2 == 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r14 = 0
            goto L_0x0076
        L_0x0075:
            r14 = 1
        L_0x0076:
            if (r14 != 0) goto L_0x0092
            java.lang.String r2 = r0.name
            boolean r2 = r6.equals(r2)
            if (r2 != 0) goto L_0x0092
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj
            com.google.android.gms.measurement.internal.zzfk r5 = r2.zzgm()
            r7 = 11
            java.lang.String r9 = r0.name
            r10 = 0
            java.lang.String r8 = "_ev"
            r6 = r15
            r5.zza(r6, r7, r8, r9, r10)
        L_0x0092:
            if (r14 == 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()
            com.google.android.gms.measurement.internal.zzg r0 = r0.zzbl(r15)
            if (r0 == 0) goto L_0x00de
            long r2 = r0.zzhg()
            long r4 = r0.zzhf()
            long r2 = java.lang.Math.max(r2, r4)
            com.google.android.gms.measurement.internal.zzbt r4 = r1.zzadj
            com.google.android.gms.common.util.Clock r4 = r4.zzbx()
            long r4 = r4.currentTimeMillis()
            long r4 = r4 - r2
            long r2 = java.lang.Math.abs(r4)
            com.google.android.gms.measurement.internal.zzaf$zza<java.lang.Long> r4 = com.google.android.gms.measurement.internal.zzaf.zzakc
            java.lang.Object r4 = r4.get()
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj
            com.google.android.gms.measurement.internal.zzap r2 = r2.zzgo()
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjk()
            java.lang.String r3 = "Fetching config for blacklisted app"
            r2.zzbx(r3)
            r1.zzb(r0)
        L_0x00de:
            return
        L_0x00df:
            com.google.android.gms.measurement.internal.zzbt r5 = r1.zzadj
            com.google.android.gms.measurement.internal.zzap r5 = r5.zzgo()
            r13 = 2
            boolean r5 = r5.isLoggable(r13)
            if (r5 == 0) goto L_0x0107
            com.google.android.gms.measurement.internal.zzbt r5 = r1.zzadj
            com.google.android.gms.measurement.internal.zzap r5 = r5.zzgo()
            com.google.android.gms.measurement.internal.zzar r5 = r5.zzjl()
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj
            com.google.android.gms.measurement.internal.zzan r7 = r7.zzgl()
            java.lang.String r7 = r7.zzb(r0)
            java.lang.String r8 = "Logging event"
            r5.zzg(r8, r7)
        L_0x0107:
            com.google.android.gms.measurement.internal.zzq r5 = r26.zzjq()
            r5.beginTransaction()
            r1.zzg(r2)     // Catch:{ all -> 0x0671 }
            java.lang.String r5 = "_iap"
            java.lang.String r7 = r0.name     // Catch:{ all -> 0x0671 }
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x0671 }
            if (r5 != 0) goto L_0x0125
            java.lang.String r5 = "ecommerce_purchase"
            java.lang.String r7 = r0.name     // Catch:{ all -> 0x0671 }
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x0671 }
            if (r5 == 0) goto L_0x013a
        L_0x0125:
            boolean r5 = r1.zza(r15, r0)     // Catch:{ all -> 0x0671 }
            if (r5 != 0) goto L_0x013a
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()
            r0.endTransaction()
            return
        L_0x013a:
            java.lang.String r5 = r0.name     // Catch:{ all -> 0x0671 }
            boolean r16 = com.google.android.gms.measurement.internal.zzfk.zzcq(r5)     // Catch:{ all -> 0x0671 }
            java.lang.String r5 = r0.name     // Catch:{ all -> 0x0671 }
            boolean r17 = r6.equals(r5)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzq r5 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            long r6 = r26.zzls()     // Catch:{ all -> 0x0671 }
            r9 = 1
            r11 = 0
            r18 = 0
            r8 = r15
            r10 = r16
            r12 = r17
            r13 = r18
            com.google.android.gms.measurement.internal.zzr r5 = r5.zza(r6, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0671 }
            long r6 = r5.zzahr     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzaf$zza<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzaf.zzajn     // Catch:{ all -> 0x0671 }
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x0671 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x0671 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0671 }
            long r8 = (long) r8     // Catch:{ all -> 0x0671 }
            long r6 = r6 - r8
            r8 = 1000(0x3e8, double:4.94E-321)
            r10 = 1
            r12 = 0
            int r18 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r18 <= 0) goto L_0x01a6
            long r6 = r6 % r8
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x0197
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzap r0 = r0.zzgo()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjd()     // Catch:{ all -> 0x0671 }
            java.lang.String r2 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzap.zzbv(r15)     // Catch:{ all -> 0x0671 }
            long r4 = r5.zzahr     // Catch:{ all -> 0x0671 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0671 }
            r0.zze(r2, r3, r4)     // Catch:{ all -> 0x0671 }
        L_0x0197:
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()
            r0.endTransaction()
            return
        L_0x01a6:
            if (r16 == 0) goto L_0x01fe
            long r6 = r5.zzahq     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzaf$zza<java.lang.Integer> r18 = com.google.android.gms.measurement.internal.zzaf.zzajp     // Catch:{ all -> 0x0671 }
            java.lang.Object r18 = r18.get()     // Catch:{ all -> 0x0671 }
            java.lang.Integer r18 = (java.lang.Integer) r18     // Catch:{ all -> 0x0671 }
            int r14 = r18.intValue()     // Catch:{ all -> 0x0671 }
            long r10 = (long) r14     // Catch:{ all -> 0x0671 }
            long r6 = r6 - r10
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 <= 0) goto L_0x01fe
            long r6 = r6 % r8
            r2 = 1
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x01dd
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzap r2 = r2.zzgo()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjd()     // Catch:{ all -> 0x0671 }
            java.lang.String r3 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzap.zzbv(r15)     // Catch:{ all -> 0x0671 }
            long r5 = r5.zzahq     // Catch:{ all -> 0x0671 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0671 }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x0671 }
        L_0x01dd:
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzfk r5 = r2.zzgm()     // Catch:{ all -> 0x0671 }
            r7 = 16
            java.lang.String r8 = "_ev"
            java.lang.String r9 = r0.name     // Catch:{ all -> 0x0671 }
            r10 = 0
            r6 = r15
            r5.zza(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()
            r0.endTransaction()
            return
        L_0x01fe:
            if (r17 == 0) goto L_0x0251
            long r6 = r5.zzaht     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r8 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzn r8 = r8.zzgq()     // Catch:{ all -> 0x0671 }
            java.lang.String r9 = r2.packageName     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzaf$zza<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzaf.zzajo     // Catch:{ all -> 0x0671 }
            int r8 = r8.zzb(r9, r10)     // Catch:{ all -> 0x0671 }
            r9 = 1000000(0xf4240, float:1.401298E-39)
            int r8 = java.lang.Math.min(r9, r8)     // Catch:{ all -> 0x0671 }
            r14 = 0
            int r8 = java.lang.Math.max(r14, r8)     // Catch:{ all -> 0x0671 }
            long r8 = (long) r8     // Catch:{ all -> 0x0671 }
            long r6 = r6 - r8
            int r8 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r8 <= 0) goto L_0x0252
            r2 = 1
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0242
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzap r0 = r0.zzgo()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjd()     // Catch:{ all -> 0x0671 }
            java.lang.String r2 = "Too many error events logged. appId, count"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzap.zzbv(r15)     // Catch:{ all -> 0x0671 }
            long r4 = r5.zzaht     // Catch:{ all -> 0x0671 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0671 }
            r0.zze(r2, r3, r4)     // Catch:{ all -> 0x0671 }
        L_0x0242:
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()
            r0.endTransaction()
            return
        L_0x0251:
            r14 = 0
        L_0x0252:
            com.google.android.gms.measurement.internal.zzaa r5 = r0.zzaid     // Catch:{ all -> 0x0671 }
            android.os.Bundle r10 = r5.zziv()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r5 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzfk r5 = r5.zzgm()     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = "_o"
            java.lang.String r7 = r0.origin     // Catch:{ all -> 0x0671 }
            r5.zza(r10, r6, r7)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r5 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzfk r5 = r5.zzgm()     // Catch:{ all -> 0x0671 }
            boolean r5 = r5.zzcw(r15)     // Catch:{ all -> 0x0671 }
            java.lang.String r11 = "_r"
            if (r5 == 0) goto L_0x0297
            com.google.android.gms.measurement.internal.zzbt r5 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzfk r5 = r5.zzgm()     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = "_dbg"
            r7 = 1
            java.lang.Long r9 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0671 }
            r5.zza(r10, r6, r9)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r5 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzfk r5 = r5.zzgm()     // Catch:{ all -> 0x0671 }
            r6 = 1
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0671 }
            r5.zza(r10, r11, r6)     // Catch:{ all -> 0x0671 }
        L_0x0297:
            com.google.android.gms.measurement.internal.zzq r5 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            long r5 = r5.zzbm(r15)     // Catch:{ all -> 0x0671 }
            int r7 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r7 <= 0) goto L_0x02bb
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzap r7 = r7.zzgo()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzar r7 = r7.zzjg()     // Catch:{ all -> 0x0671 }
            java.lang.String r8 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzap.zzbv(r15)     // Catch:{ all -> 0x0671 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0671 }
            r7.zze(r8, r9, r5)     // Catch:{ all -> 0x0671 }
        L_0x02bb:
            com.google.android.gms.measurement.internal.zzy r9 = new com.google.android.gms.measurement.internal.zzy     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0671 }
            java.lang.String r7 = r0.origin     // Catch:{ all -> 0x0671 }
            java.lang.String r8 = r0.name     // Catch:{ all -> 0x0671 }
            long r12 = r0.zzaip     // Catch:{ all -> 0x0671 }
            r21 = 0
            r5 = r9
            r0 = r8
            r8 = r15
            r23 = r3
            r3 = r9
            r9 = r0
            r0 = r10
            r4 = r11
            r10 = r12
            r12 = r21
            r21 = 0
            r14 = r0
            r5.<init>(r6, r7, r8, r9, r10, r12, r14)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            java.lang.String r5 = r3.name     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzz r0 = r0.zzg(r15, r5)     // Catch:{ all -> 0x0671 }
            if (r0 != 0) goto L_0x0357
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            long r5 = r0.zzbp(r15)     // Catch:{ all -> 0x0671 }
            r7 = 500(0x1f4, double:2.47E-321)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x0333
            if (r16 == 0) goto L_0x0333
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzap r0 = r0.zzgo()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjd()     // Catch:{ all -> 0x0671 }
            java.lang.String r2 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzap.zzbv(r15)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r5 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzan r5 = r5.zzgl()     // Catch:{ all -> 0x0671 }
            java.lang.String r3 = r3.name     // Catch:{ all -> 0x0671 }
            java.lang.String r3 = r5.zzbs(r3)     // Catch:{ all -> 0x0671 }
            r5 = 500(0x1f4, float:7.0E-43)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0671 }
            r0.zzd(r2, r4, r3, r5)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzfk r5 = r0.zzgm()     // Catch:{ all -> 0x0671 }
            r7 = 8
            r8 = 0
            r9 = 0
            r10 = 0
            r6 = r15
            r5.zza(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()
            r0.endTransaction()
            return
        L_0x0333:
            com.google.android.gms.measurement.internal.zzz r0 = new com.google.android.gms.measurement.internal.zzz     // Catch:{ all -> 0x0671 }
            java.lang.String r7 = r3.name     // Catch:{ all -> 0x0671 }
            r8 = 0
            r10 = 0
            long r12 = r3.timestamp     // Catch:{ all -> 0x0671 }
            r16 = 0
            r18 = 0
            r19 = 0
            r22 = 0
            r25 = 0
            r5 = r0
            r6 = r15
            r14 = r16
            r16 = r18
            r17 = r19
            r18 = r22
            r19 = r25
            r5.<init>(r6, r7, r8, r10, r12, r14, r16, r17, r18, r19)     // Catch:{ all -> 0x0671 }
            goto L_0x0366
        L_0x0357:
            com.google.android.gms.measurement.internal.zzbt r5 = r1.zzadj     // Catch:{ all -> 0x0671 }
            long r6 = r0.zzaig     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzy r9 = r3.zza(r5, r6)     // Catch:{ all -> 0x0671 }
            long r5 = r9.timestamp     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzz r0 = r0.zzai(r5)     // Catch:{ all -> 0x0671 }
            r3 = r9
        L_0x0366:
            com.google.android.gms.measurement.internal.zzq r5 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            r5.zza(r0)     // Catch:{ all -> 0x0671 }
            r26.zzaf()     // Catch:{ all -> 0x0671 }
            r26.zzlr()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r28)     // Catch:{ all -> 0x0671 }
            java.lang.String r0 = r3.zztt     // Catch:{ all -> 0x0671 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)     // Catch:{ all -> 0x0671 }
            java.lang.String r0 = r3.zztt     // Catch:{ all -> 0x0671 }
            java.lang.String r5 = r2.packageName     // Catch:{ all -> 0x0671 }
            boolean r0 = r0.equals(r5)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.internal.measurement.zzgi r5 = new com.google.android.gms.internal.measurement.zzgi     // Catch:{ all -> 0x0671 }
            r5.<init>()     // Catch:{ all -> 0x0671 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)     // Catch:{ all -> 0x0671 }
            r5.zzaxa = r0     // Catch:{ all -> 0x0671 }
            java.lang.String r0 = "android"
            r5.zzaxi = r0     // Catch:{ all -> 0x0671 }
            java.lang.String r0 = r2.packageName     // Catch:{ all -> 0x0671 }
            r5.zztt = r0     // Catch:{ all -> 0x0671 }
            java.lang.String r0 = r2.zzage     // Catch:{ all -> 0x0671 }
            r5.zzage = r0     // Catch:{ all -> 0x0671 }
            java.lang.String r0 = r2.zzts     // Catch:{ all -> 0x0671 }
            r5.zzts = r0     // Catch:{ all -> 0x0671 }
            long r6 = r2.zzagd     // Catch:{ all -> 0x0671 }
            r8 = -2147483648(0xffffffff80000000, double:NaN)
            r0 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x03b2
            r6 = r0
            goto L_0x03b9
        L_0x03b2:
            long r6 = r2.zzagd     // Catch:{ all -> 0x0671 }
            int r7 = (int) r6     // Catch:{ all -> 0x0671 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0671 }
        L_0x03b9:
            r5.zzaxu = r6     // Catch:{ all -> 0x0671 }
            long r6 = r2.zzadt     // Catch:{ all -> 0x0671 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0671 }
            r5.zzaxm = r6     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = r2.zzafx     // Catch:{ all -> 0x0671 }
            r5.zzafx = r6     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = r2.zzagk     // Catch:{ all -> 0x0671 }
            r5.zzawj = r6     // Catch:{ all -> 0x0671 }
            long r6 = r2.zzagf     // Catch:{ all -> 0x0671 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x03d5
            r6 = r0
            goto L_0x03db
        L_0x03d5:
            long r6 = r2.zzagf     // Catch:{ all -> 0x0671 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0671 }
        L_0x03db:
            r5.zzaxq = r6     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzba r6 = r6.zzgp()     // Catch:{ all -> 0x0671 }
            java.lang.String r7 = r2.packageName     // Catch:{ all -> 0x0671 }
            android.util.Pair r6 = r6.zzby(r7)     // Catch:{ all -> 0x0671 }
            if (r6 == 0) goto L_0x0407
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x0671 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x0671 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0671 }
            if (r7 != 0) goto L_0x0407
            boolean r7 = r2.zzagi     // Catch:{ all -> 0x0671 }
            if (r7 == 0) goto L_0x0469
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x0671 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0671 }
            r5.zzaxo = r7     // Catch:{ all -> 0x0671 }
            java.lang.Object r6 = r6.second     // Catch:{ all -> 0x0671 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x0671 }
            r5.zzaxp = r6     // Catch:{ all -> 0x0671 }
            goto L_0x0469
        L_0x0407:
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzgk()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj     // Catch:{ all -> 0x0671 }
            android.content.Context r7 = r7.getContext()     // Catch:{ all -> 0x0671 }
            boolean r6 = r6.zzl(r7)     // Catch:{ all -> 0x0671 }
            if (r6 != 0) goto L_0x0469
            boolean r6 = r2.zzagj     // Catch:{ all -> 0x0671 }
            if (r6 == 0) goto L_0x0469
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0671 }
            android.content.Context r6 = r6.getContext()     // Catch:{ all -> 0x0671 }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ all -> 0x0671 }
            java.lang.String r7 = "android_id"
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r7)     // Catch:{ all -> 0x0671 }
            if (r6 != 0) goto L_0x044b
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzap r6 = r6.zzgo()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzar r6 = r6.zzjg()     // Catch:{ all -> 0x0671 }
            java.lang.String r7 = "null secure ID. appId"
            java.lang.String r10 = r5.zztt     // Catch:{ all -> 0x0671 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzap.zzbv(r10)     // Catch:{ all -> 0x0671 }
            r6.zzg(r7, r10)     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = "null"
            goto L_0x0467
        L_0x044b:
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x0671 }
            if (r7 == 0) goto L_0x0467
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzap r7 = r7.zzgo()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzar r7 = r7.zzjg()     // Catch:{ all -> 0x0671 }
            java.lang.String r10 = "empty secure ID. appId"
            java.lang.String r11 = r5.zztt     // Catch:{ all -> 0x0671 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzap.zzbv(r11)     // Catch:{ all -> 0x0671 }
            r7.zzg(r10, r11)     // Catch:{ all -> 0x0671 }
        L_0x0467:
            r5.zzaxx = r6     // Catch:{ all -> 0x0671 }
        L_0x0469:
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzgk()     // Catch:{ all -> 0x0671 }
            r6.zzcl()     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ all -> 0x0671 }
            r5.zzaxk = r6     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzgk()     // Catch:{ all -> 0x0671 }
            r6.zzcl()     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0671 }
            r5.zzaxj = r6     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzgk()     // Catch:{ all -> 0x0671 }
            long r6 = r6.zzis()     // Catch:{ all -> 0x0671 }
            int r7 = (int) r6     // Catch:{ all -> 0x0671 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0671 }
            r5.zzaxl = r6     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzx r6 = r6.zzgk()     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = r6.zzit()     // Catch:{ all -> 0x0671 }
            r5.zzaia = r6     // Catch:{ all -> 0x0671 }
            r5.zzaxn = r0     // Catch:{ all -> 0x0671 }
            r5.zzaxd = r0     // Catch:{ all -> 0x0671 }
            r5.zzaxe = r0     // Catch:{ all -> 0x0671 }
            r5.zzaxf = r0     // Catch:{ all -> 0x0671 }
            long r6 = r2.zzagh     // Catch:{ all -> 0x0671 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0671 }
            r5.zzaxz = r6     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0671 }
            boolean r6 = r6.isEnabled()     // Catch:{ all -> 0x0671 }
            if (r6 == 0) goto L_0x04c4
            boolean r6 = com.google.android.gms.measurement.internal.zzn.zzhz()     // Catch:{ all -> 0x0671 }
            if (r6 == 0) goto L_0x04c4
            r5.zzaya = r0     // Catch:{ all -> 0x0671 }
        L_0x04c4:
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = r2.packageName     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzg r0 = r0.zzbl(r6)     // Catch:{ all -> 0x0671 }
            if (r0 != 0) goto L_0x0534
            com.google.android.gms.measurement.internal.zzg r0 = new com.google.android.gms.measurement.internal.zzg     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0671 }
            java.lang.String r7 = r2.packageName     // Catch:{ all -> 0x0671 }
            r0.<init>(r6, r7)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzfk r6 = r6.zzgm()     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = r6.zzmf()     // Catch:{ all -> 0x0671 }
            r0.zzam(r6)     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = r2.zzafz     // Catch:{ all -> 0x0671 }
            r0.zzaq(r6)     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = r2.zzafx     // Catch:{ all -> 0x0671 }
            r0.zzan(r6)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzba r6 = r6.zzgp()     // Catch:{ all -> 0x0671 }
            java.lang.String r7 = r2.packageName     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = r6.zzbz(r7)     // Catch:{ all -> 0x0671 }
            r0.zzap(r6)     // Catch:{ all -> 0x0671 }
            r0.zzx(r8)     // Catch:{ all -> 0x0671 }
            r0.zzs(r8)     // Catch:{ all -> 0x0671 }
            r0.zzt(r8)     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = r2.zzts     // Catch:{ all -> 0x0671 }
            r0.setAppVersion(r6)     // Catch:{ all -> 0x0671 }
            long r6 = r2.zzagd     // Catch:{ all -> 0x0671 }
            r0.zzu(r6)     // Catch:{ all -> 0x0671 }
            java.lang.String r6 = r2.zzage     // Catch:{ all -> 0x0671 }
            r0.zzar(r6)     // Catch:{ all -> 0x0671 }
            long r6 = r2.zzadt     // Catch:{ all -> 0x0671 }
            r0.zzv(r6)     // Catch:{ all -> 0x0671 }
            long r6 = r2.zzagf     // Catch:{ all -> 0x0671 }
            r0.zzw(r6)     // Catch:{ all -> 0x0671 }
            boolean r6 = r2.zzagg     // Catch:{ all -> 0x0671 }
            r0.setMeasurementEnabled(r6)     // Catch:{ all -> 0x0671 }
            long r6 = r2.zzagh     // Catch:{ all -> 0x0671 }
            r0.zzag(r6)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzq r6 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            r6.zza(r0)     // Catch:{ all -> 0x0671 }
        L_0x0534:
            java.lang.String r6 = r0.getAppInstanceId()     // Catch:{ all -> 0x0671 }
            r5.zzafw = r6     // Catch:{ all -> 0x0671 }
            java.lang.String r0 = r0.getFirebaseInstanceId()     // Catch:{ all -> 0x0671 }
            r5.zzafz = r0     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            java.lang.String r2 = r2.packageName     // Catch:{ all -> 0x0671 }
            java.util.List r0 = r0.zzbk(r2)     // Catch:{ all -> 0x0671 }
            int r2 = r0.size()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.internal.measurement.zzgl[] r2 = new com.google.android.gms.internal.measurement.zzgl[r2]     // Catch:{ all -> 0x0671 }
            r5.zzaxc = r2     // Catch:{ all -> 0x0671 }
            r2 = 0
        L_0x0553:
            int r6 = r0.size()     // Catch:{ all -> 0x0671 }
            if (r2 >= r6) goto L_0x058c
            com.google.android.gms.internal.measurement.zzgl r6 = new com.google.android.gms.internal.measurement.zzgl     // Catch:{ all -> 0x0671 }
            r6.<init>()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.internal.measurement.zzgl[] r7 = r5.zzaxc     // Catch:{ all -> 0x0671 }
            r7[r2] = r6     // Catch:{ all -> 0x0671 }
            java.lang.Object r7 = r0.get(r2)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzfj r7 = (com.google.android.gms.measurement.internal.zzfj) r7     // Catch:{ all -> 0x0671 }
            java.lang.String r7 = r7.name     // Catch:{ all -> 0x0671 }
            r6.name = r7     // Catch:{ all -> 0x0671 }
            java.lang.Object r7 = r0.get(r2)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzfj r7 = (com.google.android.gms.measurement.internal.zzfj) r7     // Catch:{ all -> 0x0671 }
            long r10 = r7.zzaue     // Catch:{ all -> 0x0671 }
            java.lang.Long r7 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0671 }
            r6.zzayl = r7     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzfg r7 = r26.zzjo()     // Catch:{ all -> 0x0671 }
            java.lang.Object r10 = r0.get(r2)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzfj r10 = (com.google.android.gms.measurement.internal.zzfj) r10     // Catch:{ all -> 0x0671 }
            java.lang.Object r10 = r10.value     // Catch:{ all -> 0x0671 }
            r7.zza(r6, r10)     // Catch:{ all -> 0x0671 }
            int r2 = r2 + 1
            goto L_0x0553
        L_0x058c:
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()     // Catch:{ IOException -> 0x05fc }
            long r5 = r0.zza(r5)     // Catch:{ IOException -> 0x05fc }
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzaa r2 = r3.zzaid     // Catch:{ all -> 0x0671 }
            if (r2 == 0) goto L_0x05f2
            com.google.android.gms.measurement.internal.zzaa r2 = r3.zzaid     // Catch:{ all -> 0x0671 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0671 }
        L_0x05a3:
            boolean r7 = r2.hasNext()     // Catch:{ all -> 0x0671 }
            if (r7 == 0) goto L_0x05b8
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x0671 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0671 }
            boolean r7 = r4.equals(r7)     // Catch:{ all -> 0x0671 }
            if (r7 == 0) goto L_0x05b7
            r2 = 1
            goto L_0x05f3
        L_0x05b7:
            goto L_0x05a3
        L_0x05b8:
            com.google.android.gms.measurement.internal.zzbn r2 = r26.zzln()     // Catch:{ all -> 0x0671 }
            java.lang.String r4 = r3.zztt     // Catch:{ all -> 0x0671 }
            java.lang.String r7 = r3.name     // Catch:{ all -> 0x0671 }
            boolean r2 = r2.zzp(r4, r7)     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzq r10 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            long r11 = r26.zzls()     // Catch:{ all -> 0x0671 }
            java.lang.String r13 = r3.zztt     // Catch:{ all -> 0x0671 }
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            com.google.android.gms.measurement.internal.zzr r4 = r10.zza(r11, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x0671 }
            if (r2 == 0) goto L_0x05f2
            long r10 = r4.zzahu     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzn r2 = r2.zzgq()     // Catch:{ all -> 0x0671 }
            java.lang.String r4 = r3.zztt     // Catch:{ all -> 0x0671 }
            int r2 = r2.zzat(r4)     // Catch:{ all -> 0x0671 }
            long r12 = (long) r2     // Catch:{ all -> 0x0671 }
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r2 >= 0) goto L_0x05f2
            r2 = 1
            goto L_0x05f3
        L_0x05f2:
            r2 = 0
        L_0x05f3:
            boolean r0 = r0.zza(r3, r5, r2)     // Catch:{ all -> 0x0671 }
            if (r0 == 0) goto L_0x0614
            r1.zzatl = r8     // Catch:{ all -> 0x0671 }
            goto L_0x0614
        L_0x05fc:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzap r2 = r2.zzgo()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjd()     // Catch:{ all -> 0x0671 }
            java.lang.String r4 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r5 = r5.zztt     // Catch:{ all -> 0x0671 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzap.zzbv(r5)     // Catch:{ all -> 0x0671 }
            r2.zze(r4, r5, r0)     // Catch:{ all -> 0x0671 }
        L_0x0614:
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()     // Catch:{ all -> 0x0671 }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzap r0 = r0.zzgo()     // Catch:{ all -> 0x0671 }
            r2 = 2
            boolean r0 = r0.isLoggable(r2)     // Catch:{ all -> 0x0671 }
            if (r0 == 0) goto L_0x0643
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzap r0 = r0.zzgo()     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjl()     // Catch:{ all -> 0x0671 }
            java.lang.String r2 = "Event recorded"
            com.google.android.gms.measurement.internal.zzbt r4 = r1.zzadj     // Catch:{ all -> 0x0671 }
            com.google.android.gms.measurement.internal.zzan r4 = r4.zzgl()     // Catch:{ all -> 0x0671 }
            java.lang.String r3 = r4.zza(r3)     // Catch:{ all -> 0x0671 }
            r0.zzg(r2, r3)     // Catch:{ all -> 0x0671 }
        L_0x0643:
            com.google.android.gms.measurement.internal.zzq r0 = r26.zzjq()
            r0.endTransaction()
            r26.zzlv()
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj
            com.google.android.gms.measurement.internal.zzap r0 = r0.zzgo()
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjl()
            long r2 = java.lang.System.nanoTime()
            long r2 = r2 - r23
            r4 = 500000(0x7a120, double:2.47033E-318)
            long r2 = r2 + r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r2 / r4
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "Background event processing time, ms"
            r0.zzg(r3, r2)
            return
        L_0x0671:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzq r2 = r26.zzjq()
            r2.endTransaction()
            goto L_0x067b
        L_0x067a:
            throw r0
        L_0x067b:
            goto L_0x067a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfa.zzd(com.google.android.gms.measurement.internal.zzad, com.google.android.gms.measurement.internal.zzh):void");
    }

    private final boolean zza(String str, zzad zzad) {
        long j;
        zzfj zzfj;
        String string = zzad.zzaid.getString(Param.CURRENCY);
        boolean equals = Event.ECOMMERCE_PURCHASE.equals(zzad.name);
        String str2 = Param.VALUE;
        if (equals) {
            double doubleValue = zzad.zzaid.zzbq(str2).doubleValue() * 1000000.0d;
            if (doubleValue == 0.0d) {
                double longValue = (double) zzad.zzaid.getLong(str2).longValue();
                Double.isNaN(longValue);
                doubleValue = longValue * 1000000.0d;
            }
            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                this.zzadj.zzgo().zzjg().zze("Data lost. Currency value is too big. appId", zzap.zzbv(str), Double.valueOf(doubleValue));
                return false;
            }
            j = Math.round(doubleValue);
        } else {
            j = zzad.zzaid.getLong(str2).longValue();
        }
        if (!TextUtils.isEmpty(string)) {
            String upperCase = string.toUpperCase(Locale.US);
            if (upperCase.matches("[A-Z]{3}")) {
                String valueOf = String.valueOf("_ltv_");
                String valueOf2 = String.valueOf(upperCase);
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                zzfj zzi = zzjq().zzi(str, concat);
                if (zzi == null || !(zzi.value instanceof Long)) {
                    zzq zzjq = zzjq();
                    int zzb = this.zzadj.zzgq().zzb(str, zzaf.zzakh) - 1;
                    Preconditions.checkNotEmpty(str);
                    zzjq.zzaf();
                    zzjq.zzcl();
                    try {
                        zzjq.getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(zzb)});
                    } catch (SQLiteException e) {
                        zzjq.zzgo().zzjd().zze("Error pruning currencies. appId", zzap.zzbv(str), e);
                    }
                    zzfj = new zzfj(str, zzad.origin, concat, this.zzadj.zzbx().currentTimeMillis(), Long.valueOf(j));
                } else {
                    zzfj zzfj2 = new zzfj(str, zzad.origin, concat, this.zzadj.zzbx().currentTimeMillis(), Long.valueOf(((Long) zzi.value).longValue() + j));
                    zzfj = zzfj2;
                }
                if (!zzjq().zza(zzfj)) {
                    this.zzadj.zzgo().zzjd().zzd("Too many unique user properties are set. Ignoring user property. appId", zzap.zzbv(str), this.zzadj.zzgl().zzbu(zzfj.name), zzfj.value);
                    this.zzadj.zzgm().zza(str, 9, (String) null, (String) null, 0);
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzlt() {
        String zzid;
        String str;
        String str2;
        zzaf();
        zzlr();
        this.zzatr = true;
        try {
            this.zzadj.zzgr();
            Boolean zzle = this.zzadj.zzgg().zzle();
            if (zzle == null) {
                this.zzadj.zzgo().zzjg().zzbx("Upload data called on the client side before use of service was decided");
                this.zzatr = false;
                zzlw();
            } else if (zzle.booleanValue()) {
                this.zzadj.zzgo().zzjd().zzbx("Upload called in the client side when service should be used");
                this.zzatr = false;
                zzlw();
            } else if (this.zzatl > 0) {
                zzlv();
                this.zzatr = false;
                zzlw();
            } else {
                zzaf();
                if (this.zzatu != null) {
                    this.zzadj.zzgo().zzjl().zzbx("Uploading requested multiple times");
                    this.zzatr = false;
                    zzlw();
                } else if (!zzlo().zzfb()) {
                    this.zzadj.zzgo().zzjl().zzbx("Network not connected, ignoring upload request");
                    zzlv();
                    this.zzatr = false;
                    zzlw();
                } else {
                    long currentTimeMillis = this.zzadj.zzbx().currentTimeMillis();
                    String str3 = null;
                    zzd((String) null, currentTimeMillis - zzn.zzhx());
                    long j = this.zzadj.zzgp().zzane.get();
                    if (j != 0) {
                        this.zzadj.zzgo().zzjk().zzg("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
                    }
                    zzid = zzjq().zzid();
                    if (!TextUtils.isEmpty(zzid)) {
                        if (this.zzatw == -1) {
                            this.zzatw = zzjq().zzik();
                        }
                        List zzb = zzjq().zzb(zzid, this.zzadj.zzgq().zzb(zzid, zzaf.zzajj), Math.max(0, this.zzadj.zzgq().zzb(zzid, zzaf.zzajk)));
                        if (!zzb.isEmpty()) {
                            Iterator it = zzb.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    str = null;
                                    break;
                                }
                                zzgi zzgi = (zzgi) ((Pair) it.next()).first;
                                if (!TextUtils.isEmpty(zzgi.zzaxo)) {
                                    str = zzgi.zzaxo;
                                    break;
                                }
                            }
                            if (str != null) {
                                int i = 0;
                                while (true) {
                                    if (i >= zzb.size()) {
                                        break;
                                    }
                                    zzgi zzgi2 = (zzgi) ((Pair) zzb.get(i)).first;
                                    if (!TextUtils.isEmpty(zzgi2.zzaxo) && !zzgi2.zzaxo.equals(str)) {
                                        zzb = zzb.subList(0, i);
                                        break;
                                    }
                                    i++;
                                }
                            }
                            zzgh zzgh = new zzgh();
                            zzgh.zzawy = new zzgi[zzb.size()];
                            ArrayList arrayList = new ArrayList(zzb.size());
                            boolean z = zzn.zzhz() && this.zzadj.zzgq().zzav(zzid);
                            for (int i2 = 0; i2 < zzgh.zzawy.length; i2++) {
                                zzgh.zzawy[i2] = (zzgi) ((Pair) zzb.get(i2)).first;
                                arrayList.add((Long) ((Pair) zzb.get(i2)).second);
                                zzgh.zzawy[i2].zzaxn = Long.valueOf(this.zzadj.zzgq().zzhc());
                                zzgh.zzawy[i2].zzaxd = Long.valueOf(currentTimeMillis);
                                zzgi zzgi3 = zzgh.zzawy[i2];
                                this.zzadj.zzgr();
                                zzgi3.zzaxs = Boolean.valueOf(false);
                                if (!z) {
                                    zzgh.zzawy[i2].zzaya = null;
                                }
                            }
                            if (this.zzadj.zzgo().isLoggable(2)) {
                                str3 = zzjo().zzb(zzgh);
                            }
                            byte[] zza2 = zzjo().zza(zzgh);
                            str2 = (String) zzaf.zzajt.get();
                            URL url = new URL(str2);
                            Preconditions.checkArgument(!arrayList.isEmpty());
                            if (this.zzatu != null) {
                                this.zzadj.zzgo().zzjd().zzbx("Set uploading progress before finishing the previous upload");
                            } else {
                                this.zzatu = new ArrayList(arrayList);
                            }
                            this.zzadj.zzgp().zzanf.set(currentTimeMillis);
                            String str4 = "?";
                            if (zzgh.zzawy.length > 0) {
                                str4 = zzgh.zzawy[0].zztt;
                            }
                            this.zzadj.zzgo().zzjl().zzd("Uploading data. app, uncompressed size, data", str4, Integer.valueOf(zza2.length), str3);
                            this.zzatq = true;
                            zzat zzlo = zzlo();
                            zzfc zzfc = new zzfc(this, zzid);
                            zzlo.zzaf();
                            zzlo.zzcl();
                            Preconditions.checkNotNull(url);
                            Preconditions.checkNotNull(zza2);
                            Preconditions.checkNotNull(zzfc);
                            zzbo zzgn = zzlo.zzgn();
                            zzax zzax = new zzax(zzlo, zzid, url, zza2, null, zzfc);
                            zzgn.zzd((Runnable) zzax);
                        }
                    } else {
                        this.zzatw = -1;
                        String zzah = zzjq().zzah(currentTimeMillis - zzn.zzhx());
                        if (!TextUtils.isEmpty(zzah)) {
                            zzg zzbl = zzjq().zzbl(zzah);
                            if (zzbl != null) {
                                zzb(zzbl);
                            }
                        }
                    }
                    this.zzatr = false;
                    zzlw();
                }
            }
        } catch (MalformedURLException e) {
            this.zzadj.zzgo().zzjd().zze("Failed to parse upload URL. Not uploading. appId", zzap.zzbv(zzid), str2);
        } catch (Throwable th) {
            this.zzatr = false;
            zzlw();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:117:0x025e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x025f, code lost:
        r9 = r4;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        r9 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        r8 = null;
        r9 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0280 A[SYNTHETIC, Splitter:B:127:0x0280] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0046 A[ExcHandler: all (th java.lang.Throwable), PHI: r4 
      PHI: (r4v63 android.database.Cursor) = (r4v58 android.database.Cursor), (r4v58 android.database.Cursor), (r4v58 android.database.Cursor), (r4v66 android.database.Cursor), (r4v66 android.database.Cursor), (r4v66 android.database.Cursor), (r4v66 android.database.Cursor), (r4v1 android.database.Cursor), (r4v1 android.database.Cursor) binds: [B:47:0x00e8, B:53:0x00f5, B:54:?, B:25:0x0087, B:31:0x0094, B:33:0x0098, B:34:?, B:10:0x0037, B:11:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:10:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0288 A[Catch:{ IOException -> 0x0241, all -> 0x0d13 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0296 A[Catch:{ IOException -> 0x0241, all -> 0x0d13 }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x03a3 A[Catch:{ IOException -> 0x0241, all -> 0x0d13 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x03ae A[Catch:{ IOException -> 0x0241, all -> 0x0d13 }] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x03af A[Catch:{ IOException -> 0x0241, all -> 0x0d13 }] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0681 A[Catch:{ IOException -> 0x0241, all -> 0x0d13 }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0779 A[Catch:{ IOException -> 0x0241, all -> 0x0d13 }] */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x0792 A[Catch:{ IOException -> 0x0241, all -> 0x0d13 }] */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x07b2 A[Catch:{ IOException -> 0x0241, all -> 0x0d13 }] */
    /* JADX WARNING: Removed duplicated region for block: B:383:0x091a A[Catch:{ IOException -> 0x0241, all -> 0x0d13 }] */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x092a A[Catch:{ IOException -> 0x0241, all -> 0x0d13 }] */
    /* JADX WARNING: Removed duplicated region for block: B:386:0x092d A[Catch:{ IOException -> 0x0241, all -> 0x0d13 }] */
    /* JADX WARNING: Removed duplicated region for block: B:388:0x094e A[SYNTHETIC, Splitter:B:388:0x094e] */
    /* JADX WARNING: Removed duplicated region for block: B:526:0x0cf6  */
    /* JADX WARNING: Removed duplicated region for block: B:534:0x0d0d A[SYNTHETIC, Splitter:B:534:0x0d0d] */
    /* JADX WARNING: Removed duplicated region for block: B:564:0x078f A[SYNTHETIC] */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzd(java.lang.String r43, long r44) {
        /*
            r42 = this;
            r1 = r42
            java.lang.String r2 = "_lte"
            com.google.android.gms.measurement.internal.zzq r3 = r42.zzjq()
            r3.beginTransaction()
            com.google.android.gms.measurement.internal.zzfa$zza r3 = new com.google.android.gms.measurement.internal.zzfa$zza     // Catch:{ all -> 0x0d13 }
            r4 = 0
            r3.<init>(r1, r4)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzq r5 = r42.zzjq()     // Catch:{ all -> 0x0d13 }
            long r6 = r1.zzatw     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0d13 }
            r5.zzaf()     // Catch:{ all -> 0x0d13 }
            r5.zzcl()     // Catch:{ all -> 0x0d13 }
            r9 = -1
            r11 = 2
            r12 = 0
            r13 = 1
            android.database.sqlite.SQLiteDatabase r15 = r5.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            boolean r14 = android.text.TextUtils.isEmpty(r4)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            java.lang.String r16 = ""
            if (r14 == 0) goto L_0x00a6
            int r14 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r14 == 0) goto L_0x0050
            java.lang.String[] r14 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x004a, all -> 0x0046 }
            java.lang.String r17 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x004a, all -> 0x0046 }
            r14[r12] = r17     // Catch:{ SQLiteException -> 0x004a, all -> 0x0046 }
            java.lang.String r17 = java.lang.String.valueOf(r44)     // Catch:{ SQLiteException -> 0x004a, all -> 0x0046 }
            r14[r13] = r17     // Catch:{ SQLiteException -> 0x004a, all -> 0x0046 }
            goto L_0x0058
        L_0x0046:
            r0 = move-exception
            r9 = r4
            goto L_0x0d08
        L_0x004a:
            r0 = move-exception
            r8 = r4
            r9 = r8
        L_0x004d:
            r4 = r0
            goto L_0x026d
        L_0x0050:
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            java.lang.String r17 = java.lang.String.valueOf(r44)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            r14[r12] = r17     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
        L_0x0058:
            int r17 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r17 == 0) goto L_0x005f
            java.lang.String r16 = "rowid <= ? and "
        L_0x005f:
            r43 = r16
            java.lang.String r16 = java.lang.String.valueOf(r43)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            int r8 = r16.length()     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            int r8 = r8 + 148
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            r4.<init>(r8)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            java.lang.String r8 = "select app_id, metadata_fingerprint from raw_events where "
            r4.append(r8)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            r8 = r43
            r4.append(r8)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            java.lang.String r8 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r4.append(r8)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            java.lang.String r4 = r4.toString()     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            android.database.Cursor r4 = r15.rawQuery(r4, r14)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            boolean r8 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x025e, all -> 0x0046 }
            if (r8 != 0) goto L_0x0094
            if (r4 == 0) goto L_0x0092
            r4.close()     // Catch:{ all -> 0x0d13 }
        L_0x0092:
            goto L_0x0283
        L_0x0094:
            java.lang.String r8 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x025e, all -> 0x0046 }
            java.lang.String r14 = r4.getString(r13)     // Catch:{ SQLiteException -> 0x00a3, all -> 0x0046 }
            r4.close()     // Catch:{ SQLiteException -> 0x00a3, all -> 0x0046 }
            r9 = r4
            r4 = r8
            r8 = r14
            goto L_0x00ff
        L_0x00a3:
            r0 = move-exception
            r9 = r4
            goto L_0x004d
        L_0x00a6:
            int r4 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r4 == 0) goto L_0x00b6
            java.lang.String[] r4 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            r8 = 0
            r4[r12] = r8     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            r4[r13] = r8     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            goto L_0x00bb
        L_0x00b6:
            java.lang.String[] r4 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            r8 = 0
            r4[r12] = r8     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
        L_0x00bb:
            int r8 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r8 == 0) goto L_0x00c2
            java.lang.String r16 = " and rowid <= ?"
        L_0x00c2:
            r8 = r16
            java.lang.String r14 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            int r14 = r14.length()     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            int r14 = r14 + 84
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            r9.<init>(r14)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            java.lang.String r10 = "select metadata_fingerprint from raw_events where app_id = ?"
            r9.append(r10)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            r9.append(r8)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            java.lang.String r8 = " order by rowid limit 1;"
            r9.append(r8)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            java.lang.String r8 = r9.toString()     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            android.database.Cursor r4 = r15.rawQuery(r8, r4)     // Catch:{ SQLiteException -> 0x0269, all -> 0x0263 }
            boolean r8 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x025e, all -> 0x0046 }
            if (r8 != 0) goto L_0x00f5
            if (r4 == 0) goto L_0x00f3
            r4.close()     // Catch:{ all -> 0x0d13 }
        L_0x00f3:
            goto L_0x0283
        L_0x00f5:
            java.lang.String r14 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x025e, all -> 0x0046 }
            r4.close()     // Catch:{ SQLiteException -> 0x025e, all -> 0x0046 }
            r9 = r4
            r8 = r14
            r4 = 0
        L_0x00ff:
            java.lang.String r10 = "raw_events_metadata"
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x025a }
            java.lang.String r16 = "metadata"
            r14[r12] = r16     // Catch:{ SQLiteException -> 0x025a }
            java.lang.String r17 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r13 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x025a }
            r13[r12] = r4     // Catch:{ SQLiteException -> 0x025a }
            r16 = 1
            r13[r16] = r8     // Catch:{ SQLiteException -> 0x025a }
            r19 = 0
            r20 = 0
            java.lang.String r21 = "rowid"
            java.lang.String r22 = "2"
            r16 = r14
            r14 = r15
            r24 = r15
            r15 = r10
            r18 = r13
            android.database.Cursor r9 = r14.query(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ SQLiteException -> 0x025a }
            boolean r10 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x025a }
            if (r10 != 0) goto L_0x0143
            com.google.android.gms.measurement.internal.zzap r6 = r5.zzgo()     // Catch:{ SQLiteException -> 0x025a }
            com.google.android.gms.measurement.internal.zzar r6 = r6.zzjd()     // Catch:{ SQLiteException -> 0x025a }
            java.lang.String r7 = "Raw event metadata record is missing. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzap.zzbv(r4)     // Catch:{ SQLiteException -> 0x025a }
            r6.zzg(r7, r8)     // Catch:{ SQLiteException -> 0x025a }
            if (r9 == 0) goto L_0x0141
            r9.close()     // Catch:{ all -> 0x0d13 }
        L_0x0141:
            goto L_0x0283
        L_0x0143:
            byte[] r10 = r9.getBlob(r12)     // Catch:{ SQLiteException -> 0x025a }
            int r13 = r10.length     // Catch:{ SQLiteException -> 0x025a }
            com.google.android.gms.internal.measurement.zzyx r10 = com.google.android.gms.internal.measurement.zzyx.zzj(r10, r12, r13)     // Catch:{ SQLiteException -> 0x025a }
            com.google.android.gms.internal.measurement.zzgi r13 = new com.google.android.gms.internal.measurement.zzgi     // Catch:{ SQLiteException -> 0x025a }
            r13.<init>()     // Catch:{ SQLiteException -> 0x025a }
            r13.zza(r10)     // Catch:{ IOException -> 0x0241 }
            boolean r10 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x025a }
            if (r10 == 0) goto L_0x016e
            com.google.android.gms.measurement.internal.zzap r10 = r5.zzgo()     // Catch:{ SQLiteException -> 0x025a }
            com.google.android.gms.measurement.internal.zzar r10 = r10.zzjg()     // Catch:{ SQLiteException -> 0x025a }
            java.lang.String r14 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzap.zzbv(r4)     // Catch:{ SQLiteException -> 0x025a }
            r10.zzg(r14, r15)     // Catch:{ SQLiteException -> 0x025a }
        L_0x016e:
            r9.close()     // Catch:{ SQLiteException -> 0x025a }
            r3.zzb(r13)     // Catch:{ SQLiteException -> 0x025a }
            r13 = -1
            int r10 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r10 == 0) goto L_0x018f
            java.lang.String r10 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r13 = 3
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x025a }
            r14[r12] = r4     // Catch:{ SQLiteException -> 0x025a }
            r13 = 1
            r14[r13] = r8     // Catch:{ SQLiteException -> 0x025a }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x025a }
            r14[r11] = r6     // Catch:{ SQLiteException -> 0x025a }
            r17 = r10
            r18 = r14
            goto L_0x019c
        L_0x018f:
            java.lang.String r6 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r7 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x025a }
            r7[r12] = r4     // Catch:{ SQLiteException -> 0x025a }
            r10 = 1
            r7[r10] = r8     // Catch:{ SQLiteException -> 0x025a }
            r17 = r6
            r18 = r7
        L_0x019c:
            java.lang.String r15 = "raw_events"
            r6 = 4
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x025a }
            java.lang.String r7 = "rowid"
            r6[r12] = r7     // Catch:{ SQLiteException -> 0x025a }
            java.lang.String r7 = "name"
            r8 = 1
            r6[r8] = r7     // Catch:{ SQLiteException -> 0x025a }
            java.lang.String r7 = "timestamp"
            r6[r11] = r7     // Catch:{ SQLiteException -> 0x025a }
            java.lang.String r7 = "data"
            r8 = 3
            r6[r8] = r7     // Catch:{ SQLiteException -> 0x025a }
            r19 = 0
            r20 = 0
            java.lang.String r21 = "rowid"
            r22 = 0
            r14 = r24
            r16 = r6
            android.database.Cursor r6 = r14.query(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ SQLiteException -> 0x025a }
            boolean r7 = r6.moveToFirst()     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            if (r7 != 0) goto L_0x01e1
            com.google.android.gms.measurement.internal.zzap r7 = r5.zzgo()     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            com.google.android.gms.measurement.internal.zzar r7 = r7.zzjg()     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            java.lang.String r8 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzap.zzbv(r4)     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            r7.zzg(r8, r9)     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            if (r6 == 0) goto L_0x01df
            r6.close()     // Catch:{ all -> 0x0d13 }
        L_0x01df:
            goto L_0x0283
        L_0x01e1:
            long r7 = r6.getLong(r12)     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            r9 = 3
            byte[] r10 = r6.getBlob(r9)     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            int r9 = r10.length     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            com.google.android.gms.internal.measurement.zzyx r9 = com.google.android.gms.internal.measurement.zzyx.zzj(r10, r12, r9)     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            com.google.android.gms.internal.measurement.zzgf r10 = new com.google.android.gms.internal.measurement.zzgf     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            r10.<init>()     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            r10.zza(r9)     // Catch:{ IOException -> 0x0218 }
            r9 = 1
            java.lang.String r13 = r6.getString(r9)     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            r10.name = r13     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            long r13 = r6.getLong(r11)     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            java.lang.Long r9 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            r10.zzawu = r9     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            boolean r7 = r3.zza(r7, r10)     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            if (r7 != 0) goto L_0x022c
            if (r6 == 0) goto L_0x0216
            r6.close()     // Catch:{ all -> 0x0d13 }
        L_0x0216:
            goto L_0x0283
        L_0x0218:
            r0 = move-exception
            r7 = r0
            com.google.android.gms.measurement.internal.zzap r8 = r5.zzgo()     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            com.google.android.gms.measurement.internal.zzar r8 = r8.zzjd()     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            java.lang.String r9 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzap.zzbv(r4)     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            r8.zze(r9, r10, r7)     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
        L_0x022c:
            boolean r7 = r6.moveToNext()     // Catch:{ SQLiteException -> 0x023c, all -> 0x0238 }
            if (r7 != 0) goto L_0x01e1
            if (r6 == 0) goto L_0x0283
            r6.close()     // Catch:{ all -> 0x0d13 }
            goto L_0x0283
        L_0x0238:
            r0 = move-exception
            r4 = r1
            r9 = r6
            goto L_0x0266
        L_0x023c:
            r0 = move-exception
            r8 = r4
            r9 = r6
            goto L_0x004d
        L_0x0241:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzap r7 = r5.zzgo()     // Catch:{ SQLiteException -> 0x025a }
            com.google.android.gms.measurement.internal.zzar r7 = r7.zzjd()     // Catch:{ SQLiteException -> 0x025a }
            java.lang.String r8 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzap.zzbv(r4)     // Catch:{ SQLiteException -> 0x025a }
            r7.zze(r8, r10, r6)     // Catch:{ SQLiteException -> 0x025a }
            if (r9 == 0) goto L_0x0259
            r9.close()     // Catch:{ all -> 0x0d13 }
        L_0x0259:
            goto L_0x0283
        L_0x025a:
            r0 = move-exception
            r8 = r4
            goto L_0x004d
        L_0x025e:
            r0 = move-exception
            r9 = r4
            r8 = 0
            goto L_0x004d
        L_0x0263:
            r0 = move-exception
            r4 = r1
            r9 = 0
        L_0x0266:
            r1 = r0
            goto L_0x0d0b
        L_0x0269:
            r0 = move-exception
            r4 = r0
            r8 = 0
            r9 = 0
        L_0x026d:
            com.google.android.gms.measurement.internal.zzap r5 = r5.zzgo()     // Catch:{ all -> 0x0d07 }
            com.google.android.gms.measurement.internal.zzar r5 = r5.zzjd()     // Catch:{ all -> 0x0d07 }
            java.lang.String r6 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzap.zzbv(r8)     // Catch:{ all -> 0x0d07 }
            r5.zze(r6, r7, r4)     // Catch:{ all -> 0x0d07 }
            if (r9 == 0) goto L_0x0283
            r9.close()     // Catch:{ all -> 0x0d13 }
        L_0x0283:
            java.util.List<com.google.android.gms.internal.measurement.zzgf> r4 = r3.zzauc     // Catch:{ all -> 0x0d13 }
            if (r4 == 0) goto L_0x0293
            java.util.List<com.google.android.gms.internal.measurement.zzgf> r4 = r3.zzauc     // Catch:{ all -> 0x0d13 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0d13 }
            if (r4 == 0) goto L_0x0291
            goto L_0x0293
        L_0x0291:
            r4 = 0
            goto L_0x0294
        L_0x0293:
            r4 = 1
        L_0x0294:
            if (r4 != 0) goto L_0x0cf6
            com.google.android.gms.internal.measurement.zzgi r4 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.util.List<com.google.android.gms.internal.measurement.zzgf> r5 = r3.zzauc     // Catch:{ all -> 0x0d13 }
            int r5 = r5.size()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgf[] r5 = new com.google.android.gms.internal.measurement.zzgf[r5]     // Catch:{ all -> 0x0d13 }
            r4.zzaxb = r5     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzbt r5 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzn r5 = r5.zzgq()     // Catch:{ all -> 0x0d13 }
            java.lang.String r6 = r4.zztt     // Catch:{ all -> 0x0d13 }
            boolean r5 = r5.zzax(r6)     // Catch:{ all -> 0x0d13 }
            r8 = 0
            r9 = 0
            r13 = 0
            r14 = 0
        L_0x02b7:
            java.util.List<com.google.android.gms.internal.measurement.zzgf> r10 = r3.zzauc     // Catch:{ all -> 0x0d13 }
            int r10 = r10.size()     // Catch:{ all -> 0x0d13 }
            r16 = 1
            if (r8 >= r10) goto L_0x06df
            java.util.List<com.google.android.gms.internal.measurement.zzgf> r10 = r3.zzauc     // Catch:{ all -> 0x0d13 }
            java.lang.Object r10 = r10.get(r8)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgf r10 = (com.google.android.gms.internal.measurement.zzgf) r10     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzbn r6 = r42.zzln()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r7 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r7 = r7.zztt     // Catch:{ all -> 0x0d13 }
            java.lang.String r12 = r10.name     // Catch:{ all -> 0x0d13 }
            boolean r6 = r6.zzo(r7, r12)     // Catch:{ all -> 0x0d13 }
            java.lang.String r7 = "_err"
            if (r6 == 0) goto L_0x0350
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzap r6 = r6.zzgo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzar r6 = r6.zzjg()     // Catch:{ all -> 0x0d13 }
            java.lang.String r12 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzgi r11 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r11 = r11.zztt     // Catch:{ all -> 0x0d13 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzap.zzbv(r11)     // Catch:{ all -> 0x0d13 }
            r20 = r13
            com.google.android.gms.measurement.internal.zzbt r13 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzan r13 = r13.zzgl()     // Catch:{ all -> 0x0d13 }
            r21 = r2
            java.lang.String r2 = r10.name     // Catch:{ all -> 0x0d13 }
            java.lang.String r2 = r13.zzbs(r2)     // Catch:{ all -> 0x0d13 }
            r6.zze(r12, r11, r2)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzbn r2 = r42.zzln()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r6 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r6 = r6.zztt     // Catch:{ all -> 0x0d13 }
            boolean r2 = r2.zzck(r6)     // Catch:{ all -> 0x0d13 }
            if (r2 != 0) goto L_0x0324
            com.google.android.gms.measurement.internal.zzbn r2 = r42.zzln()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r6 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r6 = r6.zztt     // Catch:{ all -> 0x0d13 }
            boolean r2 = r2.zzcl(r6)     // Catch:{ all -> 0x0d13 }
            if (r2 == 0) goto L_0x0322
            goto L_0x0324
        L_0x0322:
            r2 = 0
            goto L_0x0325
        L_0x0324:
            r2 = 1
        L_0x0325:
            if (r2 != 0) goto L_0x0349
            java.lang.String r2 = r10.name     // Catch:{ all -> 0x0d13 }
            boolean r2 = r7.equals(r2)     // Catch:{ all -> 0x0d13 }
            if (r2 != 0) goto L_0x0349
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzfk r24 = r2.zzgm()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r2 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r2 = r2.zztt     // Catch:{ all -> 0x0d13 }
            r26 = 11
            java.lang.String r27 = "_ev"
            java.lang.String r6 = r10.name     // Catch:{ all -> 0x0d13 }
            r29 = 0
            r25 = r2
            r28 = r6
            r24.zza(r25, r26, r27, r28, r29)     // Catch:{ all -> 0x0d13 }
        L_0x0349:
            r26 = r8
            r13 = r20
            r11 = 3
            goto L_0x06d7
        L_0x0350:
            r21 = r2
            r20 = r13
            com.google.android.gms.measurement.internal.zzbn r2 = r42.zzln()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r6 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r6 = r6.zztt     // Catch:{ all -> 0x0d13 }
            java.lang.String r11 = r10.name     // Catch:{ all -> 0x0d13 }
            boolean r2 = r2.zzp(r6, r11)     // Catch:{ all -> 0x0d13 }
            java.lang.String r6 = "_c"
            if (r2 != 0) goto L_0x03b9
            r42.zzjo()     // Catch:{ all -> 0x0d13 }
            java.lang.String r12 = r10.name     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)     // Catch:{ all -> 0x0d13 }
            int r13 = r12.hashCode()     // Catch:{ all -> 0x0d13 }
            r11 = 94660(0x171c4, float:1.32647E-40)
            if (r13 == r11) goto L_0x0396
            r11 = 95025(0x17331, float:1.33158E-40)
            if (r13 == r11) goto L_0x038c
            r11 = 95027(0x17333, float:1.33161E-40)
            if (r13 == r11) goto L_0x0382
        L_0x0381:
            goto L_0x03a0
        L_0x0382:
            java.lang.String r11 = "_ui"
            boolean r11 = r12.equals(r11)     // Catch:{ all -> 0x0d13 }
            if (r11 == 0) goto L_0x0381
            r11 = 1
            goto L_0x03a1
        L_0x038c:
            java.lang.String r11 = "_ug"
            boolean r11 = r12.equals(r11)     // Catch:{ all -> 0x0d13 }
            if (r11 == 0) goto L_0x0381
            r11 = 2
            goto L_0x03a1
        L_0x0396:
            java.lang.String r11 = "_in"
            boolean r11 = r12.equals(r11)     // Catch:{ all -> 0x0d13 }
            if (r11 == 0) goto L_0x0381
            r11 = 0
            goto L_0x03a1
        L_0x03a0:
            r11 = -1
        L_0x03a1:
            if (r11 == 0) goto L_0x03ab
            r12 = 1
            if (r11 == r12) goto L_0x03ab
            r12 = 2
            if (r11 == r12) goto L_0x03ab
            r11 = 0
            goto L_0x03ac
        L_0x03ab:
            r11 = 1
        L_0x03ac:
            if (r11 == 0) goto L_0x03af
            goto L_0x03b9
        L_0x03af:
            r26 = r8
            r24 = r9
            r27 = r14
            r13 = r20
            goto L_0x05a9
        L_0x03b9:
            com.google.android.gms.internal.measurement.zzgg[] r11 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            if (r11 != 0) goto L_0x03c4
            r11 = 0
            com.google.android.gms.internal.measurement.zzgg[] r12 = new com.google.android.gms.internal.measurement.zzgg[r11]     // Catch:{ all -> 0x0d13 }
            r10.zzawt = r12     // Catch:{ all -> 0x0d13 }
        L_0x03c4:
            com.google.android.gms.internal.measurement.zzgg[] r11 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            int r12 = r11.length     // Catch:{ all -> 0x0d13 }
            r13 = 0
            r24 = 0
            r25 = 0
        L_0x03cc:
            r26 = r8
            java.lang.String r8 = "_r"
            if (r13 >= r12) goto L_0x0402
            r27 = r12
            r12 = r11[r13]     // Catch:{ all -> 0x0d13 }
            r28 = r11
            java.lang.String r11 = r12.name     // Catch:{ all -> 0x0d13 }
            boolean r11 = r6.equals(r11)     // Catch:{ all -> 0x0d13 }
            if (r11 == 0) goto L_0x03e9
            java.lang.Long r8 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0d13 }
            r12.zzawx = r8     // Catch:{ all -> 0x0d13 }
            r24 = 1
            goto L_0x03f9
        L_0x03e9:
            java.lang.String r11 = r12.name     // Catch:{ all -> 0x0d13 }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x0d13 }
            if (r8 == 0) goto L_0x03f9
            java.lang.Long r8 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0d13 }
            r12.zzawx = r8     // Catch:{ all -> 0x0d13 }
            r25 = 1
        L_0x03f9:
            int r13 = r13 + 1
            r8 = r26
            r12 = r27
            r11 = r28
            goto L_0x03cc
        L_0x0402:
            if (r24 != 0) goto L_0x0446
            if (r2 == 0) goto L_0x0446
            com.google.android.gms.measurement.internal.zzbt r11 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzap r11 = r11.zzgo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzar r11 = r11.zzjl()     // Catch:{ all -> 0x0d13 }
            java.lang.String r12 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzbt r13 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzan r13 = r13.zzgl()     // Catch:{ all -> 0x0d13 }
            r24 = r9
            java.lang.String r9 = r10.name     // Catch:{ all -> 0x0d13 }
            java.lang.String r9 = r13.zzbs(r9)     // Catch:{ all -> 0x0d13 }
            r11.zzg(r12, r9)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r9 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r11 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            int r11 = r11.length     // Catch:{ all -> 0x0d13 }
            r12 = 1
            int r11 = r11 + r12
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r11)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r9 = (com.google.android.gms.internal.measurement.zzgg[]) r9     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg r11 = new com.google.android.gms.internal.measurement.zzgg     // Catch:{ all -> 0x0d13 }
            r11.<init>()     // Catch:{ all -> 0x0d13 }
            r11.name = r6     // Catch:{ all -> 0x0d13 }
            java.lang.Long r12 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0d13 }
            r11.zzawx = r12     // Catch:{ all -> 0x0d13 }
            int r12 = r9.length     // Catch:{ all -> 0x0d13 }
            r13 = 1
            int r12 = r12 - r13
            r9[r12] = r11     // Catch:{ all -> 0x0d13 }
            r10.zzawt = r9     // Catch:{ all -> 0x0d13 }
            goto L_0x0448
        L_0x0446:
            r24 = r9
        L_0x0448:
            if (r25 != 0) goto L_0x0487
            com.google.android.gms.measurement.internal.zzbt r9 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzap r9 = r9.zzgo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzar r9 = r9.zzjl()     // Catch:{ all -> 0x0d13 }
            java.lang.String r11 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzbt r12 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzan r12 = r12.zzgl()     // Catch:{ all -> 0x0d13 }
            java.lang.String r13 = r10.name     // Catch:{ all -> 0x0d13 }
            java.lang.String r12 = r12.zzbs(r13)     // Catch:{ all -> 0x0d13 }
            r9.zzg(r11, r12)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r9 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r11 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            int r11 = r11.length     // Catch:{ all -> 0x0d13 }
            r12 = 1
            int r11 = r11 + r12
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r11)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r9 = (com.google.android.gms.internal.measurement.zzgg[]) r9     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg r11 = new com.google.android.gms.internal.measurement.zzgg     // Catch:{ all -> 0x0d13 }
            r11.<init>()     // Catch:{ all -> 0x0d13 }
            r11.name = r8     // Catch:{ all -> 0x0d13 }
            java.lang.Long r12 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0d13 }
            r11.zzawx = r12     // Catch:{ all -> 0x0d13 }
            int r12 = r9.length     // Catch:{ all -> 0x0d13 }
            r13 = 1
            int r12 = r12 - r13
            r9[r12] = r11     // Catch:{ all -> 0x0d13 }
            r10.zzawt = r9     // Catch:{ all -> 0x0d13 }
        L_0x0487:
            com.google.android.gms.measurement.internal.zzq r27 = r42.zzjq()     // Catch:{ all -> 0x0d13 }
            long r28 = r42.zzls()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r9 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r9 = r9.zztt     // Catch:{ all -> 0x0d13 }
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 1
            r30 = r9
            com.google.android.gms.measurement.internal.zzr r9 = r27.zza(r28, r30, r31, r32, r33, r34, r35)     // Catch:{ all -> 0x0d13 }
            long r11 = r9.zzahu     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzbt r9 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzn r9 = r9.zzgq()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r13 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r13 = r13.zztt     // Catch:{ all -> 0x0d13 }
            int r9 = r9.zzat(r13)     // Catch:{ all -> 0x0d13 }
            r27 = r14
            long r13 = (long) r9     // Catch:{ all -> 0x0d13 }
            int r9 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r9 <= 0) goto L_0x04f2
            r9 = 0
        L_0x04bd:
            com.google.android.gms.internal.measurement.zzgg[] r11 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            int r11 = r11.length     // Catch:{ all -> 0x0d13 }
            if (r9 >= r11) goto L_0x04ef
            com.google.android.gms.internal.measurement.zzgg[] r11 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            r11 = r11[r9]     // Catch:{ all -> 0x0d13 }
            java.lang.String r11 = r11.name     // Catch:{ all -> 0x0d13 }
            boolean r11 = r8.equals(r11)     // Catch:{ all -> 0x0d13 }
            if (r11 == 0) goto L_0x04ec
            com.google.android.gms.internal.measurement.zzgg[] r8 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            int r8 = r8.length     // Catch:{ all -> 0x0d13 }
            r11 = 1
            int r8 = r8 - r11
            com.google.android.gms.internal.measurement.zzgg[] r8 = new com.google.android.gms.internal.measurement.zzgg[r8]     // Catch:{ all -> 0x0d13 }
            if (r9 <= 0) goto L_0x04dd
            com.google.android.gms.internal.measurement.zzgg[] r11 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            r12 = 0
            java.lang.System.arraycopy(r11, r12, r8, r12, r9)     // Catch:{ all -> 0x0d13 }
        L_0x04dd:
            int r11 = r8.length     // Catch:{ all -> 0x0d13 }
            if (r9 >= r11) goto L_0x04e9
            com.google.android.gms.internal.measurement.zzgg[] r11 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            int r12 = r9 + 1
            int r13 = r8.length     // Catch:{ all -> 0x0d13 }
            int r13 = r13 - r9
            java.lang.System.arraycopy(r11, r12, r8, r9, r13)     // Catch:{ all -> 0x0d13 }
        L_0x04e9:
            r10.zzawt = r8     // Catch:{ all -> 0x0d13 }
            goto L_0x04ef
        L_0x04ec:
            int r9 = r9 + 1
            goto L_0x04bd
        L_0x04ef:
            r13 = r20
            goto L_0x04f3
        L_0x04f2:
            r13 = 1
        L_0x04f3:
            java.lang.String r8 = r10.name     // Catch:{ all -> 0x0d13 }
            boolean r8 = com.google.android.gms.measurement.internal.zzfk.zzcq(r8)     // Catch:{ all -> 0x0d13 }
            if (r8 == 0) goto L_0x05a9
            if (r2 == 0) goto L_0x05a9
            com.google.android.gms.measurement.internal.zzq r29 = r42.zzjq()     // Catch:{ all -> 0x0d13 }
            long r30 = r42.zzls()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r8 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r8 = r8.zztt     // Catch:{ all -> 0x0d13 }
            r33 = 0
            r34 = 0
            r35 = 1
            r36 = 0
            r37 = 0
            r32 = r8
            com.google.android.gms.measurement.internal.zzr r8 = r29.zza(r30, r32, r33, r34, r35, r36, r37)     // Catch:{ all -> 0x0d13 }
            long r8 = r8.zzahs     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzbt r11 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzn r11 = r11.zzgq()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r12 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r12 = r12.zztt     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzaf$zza<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzaf.zzajq     // Catch:{ all -> 0x0d13 }
            int r11 = r11.zzb(r12, r14)     // Catch:{ all -> 0x0d13 }
            long r11 = (long) r11     // Catch:{ all -> 0x0d13 }
            int r14 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r14 <= 0) goto L_0x05a9
            com.google.android.gms.measurement.internal.zzbt r8 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzap r8 = r8.zzgo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzar r8 = r8.zzjg()     // Catch:{ all -> 0x0d13 }
            java.lang.String r9 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzgi r11 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r11 = r11.zztt     // Catch:{ all -> 0x0d13 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzap.zzbv(r11)     // Catch:{ all -> 0x0d13 }
            r8.zzg(r9, r11)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r8 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            int r9 = r8.length     // Catch:{ all -> 0x0d13 }
            r11 = 0
            r12 = 0
            r14 = 0
        L_0x0551:
            if (r11 >= r9) goto L_0x056f
            r15 = r8[r11]     // Catch:{ all -> 0x0d13 }
            r16 = r8
            java.lang.String r8 = r15.name     // Catch:{ all -> 0x0d13 }
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x0d13 }
            if (r8 == 0) goto L_0x0561
            r14 = r15
            goto L_0x056a
        L_0x0561:
            java.lang.String r8 = r15.name     // Catch:{ all -> 0x0d13 }
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x0d13 }
            if (r8 == 0) goto L_0x056a
            r12 = 1
        L_0x056a:
            int r11 = r11 + 1
            r8 = r16
            goto L_0x0551
        L_0x056f:
            if (r12 == 0) goto L_0x0584
            if (r14 == 0) goto L_0x0584
            com.google.android.gms.internal.measurement.zzgg[] r7 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            r8 = 1
            com.google.android.gms.internal.measurement.zzgg[] r9 = new com.google.android.gms.internal.measurement.zzgg[r8]     // Catch:{ all -> 0x0d13 }
            r8 = 0
            r9[r8] = r14     // Catch:{ all -> 0x0d13 }
            java.lang.Object[] r7 = com.google.android.gms.common.util.ArrayUtils.removeAll(r7, r9)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r7 = (com.google.android.gms.internal.measurement.zzgg[]) r7     // Catch:{ all -> 0x0d13 }
            r10.zzawt = r7     // Catch:{ all -> 0x0d13 }
            goto L_0x05a9
        L_0x0584:
            if (r14 == 0) goto L_0x0591
            r14.name = r7     // Catch:{ all -> 0x0d13 }
            r7 = 10
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0d13 }
            r14.zzawx = r7     // Catch:{ all -> 0x0d13 }
            goto L_0x05a9
        L_0x0591:
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzap r7 = r7.zzgo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzar r7 = r7.zzjd()     // Catch:{ all -> 0x0d13 }
            java.lang.String r8 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzgi r9 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r9 = r9.zztt     // Catch:{ all -> 0x0d13 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzap.zzbv(r9)     // Catch:{ all -> 0x0d13 }
            r7.zzg(r8, r9)     // Catch:{ all -> 0x0d13 }
        L_0x05a9:
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzn r7 = r7.zzgq()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r8 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r8 = r8.zztt     // Catch:{ all -> 0x0d13 }
            boolean r7 = r7.zzbf(r8)     // Catch:{ all -> 0x0d13 }
            if (r7 == 0) goto L_0x0670
            if (r2 == 0) goto L_0x0670
            com.google.android.gms.internal.measurement.zzgg[] r2 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            r7 = 0
            r8 = -1
            r9 = -1
        L_0x05c3:
            int r11 = r2.length     // Catch:{ all -> 0x0d13 }
            if (r7 >= r11) goto L_0x05e4
            java.lang.String r11 = "value"
            r12 = r2[r7]     // Catch:{ all -> 0x0d13 }
            java.lang.String r12 = r12.name     // Catch:{ all -> 0x0d13 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0d13 }
            if (r11 == 0) goto L_0x05d4
            r8 = r7
            goto L_0x05e1
        L_0x05d4:
            java.lang.String r11 = "currency"
            r12 = r2[r7]     // Catch:{ all -> 0x0d13 }
            java.lang.String r12 = r12.name     // Catch:{ all -> 0x0d13 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0d13 }
            if (r11 == 0) goto L_0x05e1
            r9 = r7
        L_0x05e1:
            int r7 = r7 + 1
            goto L_0x05c3
        L_0x05e4:
            r7 = -1
            if (r8 == r7) goto L_0x066b
            r7 = r2[r8]     // Catch:{ all -> 0x0d13 }
            java.lang.Long r7 = r7.zzawx     // Catch:{ all -> 0x0d13 }
            if (r7 != 0) goto L_0x0615
            r7 = r2[r8]     // Catch:{ all -> 0x0d13 }
            java.lang.Double r7 = r7.zzauh     // Catch:{ all -> 0x0d13 }
            if (r7 != 0) goto L_0x0615
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzap r7 = r7.zzgo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzar r7 = r7.zzji()     // Catch:{ all -> 0x0d13 }
            java.lang.String r9 = "Value must be specified with a numeric type."
            r7.zzbx(r9)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r2 = zza(r2, r8)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r2 = zza(r2, r6)     // Catch:{ all -> 0x0d13 }
            r6 = 18
            java.lang.String r7 = "value"
            com.google.android.gms.internal.measurement.zzgg[] r2 = zza(r2, r6, r7)     // Catch:{ all -> 0x0d13 }
            r11 = 3
            goto L_0x066c
        L_0x0615:
            r7 = -1
            if (r9 != r7) goto L_0x061c
            r7 = 1
            r11 = 3
            goto L_0x0648
        L_0x061c:
            r7 = r2[r9]     // Catch:{ all -> 0x0d13 }
            java.lang.String r7 = r7.zzamp     // Catch:{ all -> 0x0d13 }
            if (r7 == 0) goto L_0x0646
            int r9 = r7.length()     // Catch:{ all -> 0x0d13 }
            r11 = 3
            if (r9 == r11) goto L_0x062a
            goto L_0x0647
        L_0x062a:
            r9 = 0
        L_0x062b:
            int r12 = r7.length()     // Catch:{ all -> 0x0d13 }
            if (r9 >= r12) goto L_0x0644
            int r12 = r7.codePointAt(r9)     // Catch:{ all -> 0x0d13 }
            boolean r14 = java.lang.Character.isLetter(r12)     // Catch:{ all -> 0x0d13 }
            if (r14 != 0) goto L_0x063e
            r7 = 1
            goto L_0x0648
        L_0x063e:
            int r12 = java.lang.Character.charCount(r12)     // Catch:{ all -> 0x0d13 }
            int r9 = r9 + r12
            goto L_0x062b
        L_0x0644:
            r7 = 0
            goto L_0x0648
        L_0x0646:
            r11 = 3
        L_0x0647:
            r7 = 1
        L_0x0648:
            if (r7 == 0) goto L_0x066c
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzap r7 = r7.zzgo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzar r7 = r7.zzji()     // Catch:{ all -> 0x0d13 }
            java.lang.String r9 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r7.zzbx(r9)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r2 = zza(r2, r8)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r2 = zza(r2, r6)     // Catch:{ all -> 0x0d13 }
            r6 = 19
            java.lang.String r7 = "currency"
            com.google.android.gms.internal.measurement.zzgg[] r2 = zza(r2, r6, r7)     // Catch:{ all -> 0x0d13 }
            goto L_0x066c
        L_0x066b:
            r11 = 3
        L_0x066c:
            r10.zzawt = r2     // Catch:{ all -> 0x0d13 }
            goto L_0x0671
        L_0x0670:
            r11 = 3
        L_0x0671:
            if (r5 == 0) goto L_0x06cf
            java.lang.String r2 = "_e"
            java.lang.String r6 = r10.name     // Catch:{ all -> 0x0d13 }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x0d13 }
            if (r2 == 0) goto L_0x06cf
            com.google.android.gms.internal.measurement.zzgg[] r2 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            if (r2 == 0) goto L_0x06b7
            com.google.android.gms.internal.measurement.zzgg[] r2 = r10.zzawt     // Catch:{ all -> 0x0d13 }
            int r2 = r2.length     // Catch:{ all -> 0x0d13 }
            if (r2 != 0) goto L_0x0687
            goto L_0x06b7
        L_0x0687:
            r42.zzjo()     // Catch:{ all -> 0x0d13 }
            java.lang.String r2 = "_et"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzfg.zzb(r10, r2)     // Catch:{ all -> 0x0d13 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0d13 }
            if (r2 != 0) goto L_0x06ae
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzap r2 = r2.zzgo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjg()     // Catch:{ all -> 0x0d13 }
            java.lang.String r6 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzgi r7 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r7 = r7.zztt     // Catch:{ all -> 0x0d13 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzap.zzbv(r7)     // Catch:{ all -> 0x0d13 }
            r2.zzg(r6, r7)     // Catch:{ all -> 0x0d13 }
            goto L_0x06cf
        L_0x06ae:
            long r6 = r2.longValue()     // Catch:{ all -> 0x0d13 }
            long r14 = r27 + r6
            r27 = r14
            goto L_0x06cf
        L_0x06b7:
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzap r2 = r2.zzgo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjg()     // Catch:{ all -> 0x0d13 }
            java.lang.String r6 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzgi r7 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r7 = r7.zztt     // Catch:{ all -> 0x0d13 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzap.zzbv(r7)     // Catch:{ all -> 0x0d13 }
            r2.zzg(r6, r7)     // Catch:{ all -> 0x0d13 }
        L_0x06cf:
            com.google.android.gms.internal.measurement.zzgf[] r2 = r4.zzaxb     // Catch:{ all -> 0x0d13 }
            int r9 = r24 + 1
            r2[r24] = r10     // Catch:{ all -> 0x0d13 }
            r14 = r27
        L_0x06d7:
            int r8 = r26 + 1
            r2 = r21
            r11 = 2
            r12 = 0
            goto L_0x02b7
        L_0x06df:
            r21 = r2
            r24 = r9
            r20 = r13
            r27 = r14
            java.util.List<com.google.android.gms.internal.measurement.zzgf> r2 = r3.zzauc     // Catch:{ all -> 0x0d13 }
            int r2 = r2.size()     // Catch:{ all -> 0x0d13 }
            r12 = r24
            if (r12 >= r2) goto L_0x06fb
            com.google.android.gms.internal.measurement.zzgf[] r2 = r4.zzaxb     // Catch:{ all -> 0x0d13 }
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r12)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgf[] r2 = (com.google.android.gms.internal.measurement.zzgf[]) r2     // Catch:{ all -> 0x0d13 }
            r4.zzaxb = r2     // Catch:{ all -> 0x0d13 }
        L_0x06fb:
            if (r5 == 0) goto L_0x07cb
            com.google.android.gms.measurement.internal.zzq r2 = r42.zzjq()     // Catch:{ all -> 0x0d13 }
            java.lang.String r5 = r4.zztt     // Catch:{ all -> 0x0d13 }
            r6 = r21
            com.google.android.gms.measurement.internal.zzfj r2 = r2.zzi(r5, r6)     // Catch:{ all -> 0x0d13 }
            if (r2 == 0) goto L_0x0737
            java.lang.Object r5 = r2.value     // Catch:{ all -> 0x0d13 }
            if (r5 != 0) goto L_0x0711
            goto L_0x0737
        L_0x0711:
            com.google.android.gms.measurement.internal.zzfj r5 = new com.google.android.gms.measurement.internal.zzfj     // Catch:{ all -> 0x0d13 }
            java.lang.String r8 = r4.zztt     // Catch:{ all -> 0x0d13 }
            java.lang.String r9 = "auto"
            java.lang.String r10 = "_lte"
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.common.util.Clock r7 = r7.zzbx()     // Catch:{ all -> 0x0d13 }
            long r11 = r7.currentTimeMillis()     // Catch:{ all -> 0x0d13 }
            java.lang.Object r2 = r2.value     // Catch:{ all -> 0x0d13 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0d13 }
            long r13 = r2.longValue()     // Catch:{ all -> 0x0d13 }
            long r13 = r13 + r27
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0d13 }
            r7 = r5
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x0d13 }
            r2 = r5
            goto L_0x0754
        L_0x0737:
            com.google.android.gms.measurement.internal.zzfj r2 = new com.google.android.gms.measurement.internal.zzfj     // Catch:{ all -> 0x0d13 }
            java.lang.String r5 = r4.zztt     // Catch:{ all -> 0x0d13 }
            java.lang.String r31 = "auto"
            java.lang.String r32 = "_lte"
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.common.util.Clock r7 = r7.zzbx()     // Catch:{ all -> 0x0d13 }
            long r33 = r7.currentTimeMillis()     // Catch:{ all -> 0x0d13 }
            java.lang.Long r35 = java.lang.Long.valueOf(r27)     // Catch:{ all -> 0x0d13 }
            r29 = r2
            r30 = r5
            r29.<init>(r30, r31, r32, r33, r35)     // Catch:{ all -> 0x0d13 }
        L_0x0754:
            com.google.android.gms.internal.measurement.zzgl r5 = new com.google.android.gms.internal.measurement.zzgl     // Catch:{ all -> 0x0d13 }
            r5.<init>()     // Catch:{ all -> 0x0d13 }
            r5.name = r6     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.common.util.Clock r7 = r7.zzbx()     // Catch:{ all -> 0x0d13 }
            long r7 = r7.currentTimeMillis()     // Catch:{ all -> 0x0d13 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0d13 }
            r5.zzayl = r7     // Catch:{ all -> 0x0d13 }
            java.lang.Object r7 = r2.value     // Catch:{ all -> 0x0d13 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0d13 }
            r5.zzawx = r7     // Catch:{ all -> 0x0d13 }
            r7 = 0
        L_0x0774:
            com.google.android.gms.internal.measurement.zzgl[] r8 = r4.zzaxc     // Catch:{ all -> 0x0d13 }
            int r8 = r8.length     // Catch:{ all -> 0x0d13 }
            if (r7 >= r8) goto L_0x078f
            com.google.android.gms.internal.measurement.zzgl[] r8 = r4.zzaxc     // Catch:{ all -> 0x0d13 }
            r8 = r8[r7]     // Catch:{ all -> 0x0d13 }
            java.lang.String r8 = r8.name     // Catch:{ all -> 0x0d13 }
            boolean r8 = r6.equals(r8)     // Catch:{ all -> 0x0d13 }
            if (r8 == 0) goto L_0x078c
            com.google.android.gms.internal.measurement.zzgl[] r6 = r4.zzaxc     // Catch:{ all -> 0x0d13 }
            r6[r7] = r5     // Catch:{ all -> 0x0d13 }
            r6 = 1
            goto L_0x0790
        L_0x078c:
            int r7 = r7 + 1
            goto L_0x0774
        L_0x078f:
            r6 = 0
        L_0x0790:
            if (r6 != 0) goto L_0x07ac
            com.google.android.gms.internal.measurement.zzgl[] r6 = r4.zzaxc     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgl[] r7 = r4.zzaxc     // Catch:{ all -> 0x0d13 }
            int r7 = r7.length     // Catch:{ all -> 0x0d13 }
            r8 = 1
            int r7 = r7 + r8
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r7)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgl[] r6 = (com.google.android.gms.internal.measurement.zzgl[]) r6     // Catch:{ all -> 0x0d13 }
            r4.zzaxc = r6     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgl[] r6 = r4.zzaxc     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r7 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgl[] r7 = r7.zzaxc     // Catch:{ all -> 0x0d13 }
            int r7 = r7.length     // Catch:{ all -> 0x0d13 }
            r8 = 1
            int r7 = r7 - r8
            r6[r7] = r5     // Catch:{ all -> 0x0d13 }
        L_0x07ac:
            r5 = 0
            int r7 = (r27 > r5 ? 1 : (r27 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x07cb
            com.google.android.gms.measurement.internal.zzq r5 = r42.zzjq()     // Catch:{ all -> 0x0d13 }
            r5.zza(r2)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzbt r5 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzap r5 = r5.zzgo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzar r5 = r5.zzjk()     // Catch:{ all -> 0x0d13 }
            java.lang.String r6 = "Updated lifetime engagement user property with value. Value"
            java.lang.Object r2 = r2.value     // Catch:{ all -> 0x0d13 }
            r5.zzg(r6, r2)     // Catch:{ all -> 0x0d13 }
        L_0x07cb:
            java.lang.String r2 = r4.zztt     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgl[] r5 = r4.zzaxc     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgf[] r6 = r4.zzaxb     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgd[] r2 = r1.zza(r2, r5, r6)     // Catch:{ all -> 0x0d13 }
            r4.zzaxt = r2     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzn r2 = r2.zzgq()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r5 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r5 = r5.zztt     // Catch:{ all -> 0x0d13 }
            boolean r2 = r2.zzaw(r5)     // Catch:{ all -> 0x0d13 }
            if (r2 == 0) goto L_0x0b26
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0cf2 }
            r2.<init>()     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.internal.measurement.zzgf[] r5 = r4.zzaxb     // Catch:{ all -> 0x0cf2 }
            int r5 = r5.length     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.internal.measurement.zzgf[] r5 = new com.google.android.gms.internal.measurement.zzgf[r5]     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.measurement.internal.zzfk r6 = r6.zzgm()     // Catch:{ all -> 0x0cf2 }
            java.security.SecureRandom r6 = r6.zzmd()     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.internal.measurement.zzgf[] r7 = r4.zzaxb     // Catch:{ all -> 0x0cf2 }
            int r8 = r7.length     // Catch:{ all -> 0x0cf2 }
            r9 = 0
            r10 = 0
        L_0x0803:
            if (r9 >= r8) goto L_0x0af1
            r11 = r7[r9]     // Catch:{ all -> 0x0cf2 }
            java.lang.String r12 = r11.name     // Catch:{ all -> 0x0cf2 }
            java.lang.String r13 = "_ep"
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x0cf2 }
            java.lang.String r13 = "_sr"
            if (r12 == 0) goto L_0x0892
            r42.zzjo()     // Catch:{ all -> 0x0d13 }
            java.lang.String r12 = "_en"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzfg.zzb(r11, r12)     // Catch:{ all -> 0x0d13 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0d13 }
            java.lang.Object r14 = r2.get(r12)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzz r14 = (com.google.android.gms.measurement.internal.zzz) r14     // Catch:{ all -> 0x0d13 }
            if (r14 != 0) goto L_0x0837
            com.google.android.gms.measurement.internal.zzq r14 = r42.zzjq()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r15 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r15 = r15.zztt     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzz r14 = r14.zzg(r15, r12)     // Catch:{ all -> 0x0d13 }
            r2.put(r12, r14)     // Catch:{ all -> 0x0d13 }
        L_0x0837:
            java.lang.Long r12 = r14.zzaij     // Catch:{ all -> 0x0d13 }
            if (r12 != 0) goto L_0x0884
            java.lang.Long r12 = r14.zzaik     // Catch:{ all -> 0x0d13 }
            long r21 = r12.longValue()     // Catch:{ all -> 0x0d13 }
            int r12 = (r21 > r16 ? 1 : (r21 == r16 ? 0 : -1))
            if (r12 <= 0) goto L_0x0853
            r42.zzjo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r12 = r11.zzawt     // Catch:{ all -> 0x0d13 }
            java.lang.Long r15 = r14.zzaik     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r12 = com.google.android.gms.measurement.internal.zzfg.zza(r12, r13, r15)     // Catch:{ all -> 0x0d13 }
            r11.zzawt = r12     // Catch:{ all -> 0x0d13 }
        L_0x0853:
            java.lang.Boolean r12 = r14.zzail     // Catch:{ all -> 0x0d13 }
            if (r12 == 0) goto L_0x0871
            java.lang.Boolean r12 = r14.zzail     // Catch:{ all -> 0x0d13 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x0d13 }
            if (r12 == 0) goto L_0x0871
            r42.zzjo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r12 = r11.zzawt     // Catch:{ all -> 0x0d13 }
            java.lang.String r13 = "_efs"
            java.lang.Long r14 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r12 = com.google.android.gms.measurement.internal.zzfg.zza(r12, r13, r14)     // Catch:{ all -> 0x0d13 }
            r11.zzawt = r12     // Catch:{ all -> 0x0d13 }
        L_0x0871:
            int r12 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0d13 }
            r23 = r4
            r27 = r6
            r21 = r7
            r22 = r8
            r24 = r9
            r10 = r12
            r4 = r2
            r6 = r3
            goto L_0x0ae1
        L_0x0884:
            r23 = r4
            r27 = r6
            r21 = r7
            r22 = r8
            r24 = r9
            r4 = r2
            r6 = r3
            goto L_0x0ae1
        L_0x0892:
            com.google.android.gms.measurement.internal.zzbn r12 = r42.zzln()     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.internal.measurement.zzgi r14 = r3.zzaua     // Catch:{ all -> 0x0cf2 }
            java.lang.String r14 = r14.zztt     // Catch:{ all -> 0x0cf2 }
            long r14 = r12.zzcj(r14)     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.measurement.internal.zzbt r12 = r1.zzadj     // Catch:{ all -> 0x0cf2 }
            r12.zzgm()     // Catch:{ all -> 0x0cf2 }
            java.lang.Long r12 = r11.zzawu     // Catch:{ all -> 0x0cf2 }
            r21 = r7
            r22 = r8
            long r7 = r12.longValue()     // Catch:{ all -> 0x0cf2 }
            long r7 = com.google.android.gms.measurement.internal.zzfk.zzc(r7, r14)     // Catch:{ all -> 0x0cf2 }
            java.lang.String r12 = "_dbg"
            r23 = r4
            java.lang.Long r4 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0cf2 }
            boolean r24 = android.text.TextUtils.isEmpty(r12)     // Catch:{ all -> 0x0cf2 }
            if (r24 != 0) goto L_0x0913
            if (r4 != 0) goto L_0x08c9
            r24 = r9
            r25 = r14
            goto L_0x0917
        L_0x08c9:
            r24 = r9
            com.google.android.gms.internal.measurement.zzgg[] r9 = r11.zzawt     // Catch:{ all -> 0x0d13 }
            r25 = r14
            int r14 = r9.length     // Catch:{ all -> 0x0d13 }
            r15 = 0
        L_0x08d1:
            if (r15 >= r14) goto L_0x0911
            r27 = r14
            r14 = r9[r15]     // Catch:{ all -> 0x0d13 }
            r28 = r9
            java.lang.String r9 = r14.name     // Catch:{ all -> 0x0d13 }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0d13 }
            if (r9 == 0) goto L_0x090a
            boolean r9 = r4 instanceof java.lang.Long     // Catch:{ all -> 0x0d13 }
            if (r9 == 0) goto L_0x08ed
            java.lang.Long r9 = r14.zzawx     // Catch:{ all -> 0x0d13 }
            boolean r9 = r4.equals(r9)     // Catch:{ all -> 0x0d13 }
            if (r9 != 0) goto L_0x0905
        L_0x08ed:
            boolean r9 = r4 instanceof java.lang.String     // Catch:{ all -> 0x0d13 }
            if (r9 == 0) goto L_0x08f9
            java.lang.String r9 = r14.zzamp     // Catch:{ all -> 0x0d13 }
            boolean r9 = r4.equals(r9)     // Catch:{ all -> 0x0d13 }
            if (r9 != 0) goto L_0x0905
        L_0x08f9:
            boolean r9 = r4 instanceof java.lang.Double     // Catch:{ all -> 0x0d13 }
            if (r9 == 0) goto L_0x0907
            java.lang.Double r9 = r14.zzauh     // Catch:{ all -> 0x0d13 }
            boolean r4 = r4.equals(r9)     // Catch:{ all -> 0x0d13 }
            if (r4 == 0) goto L_0x0907
        L_0x0905:
            r4 = 1
            goto L_0x0918
        L_0x0907:
            r4 = 0
            goto L_0x0918
        L_0x090a:
            int r15 = r15 + 1
            r14 = r27
            r9 = r28
            goto L_0x08d1
        L_0x0911:
            r4 = 0
            goto L_0x0918
        L_0x0913:
            r24 = r9
            r25 = r14
        L_0x0917:
            r4 = 0
        L_0x0918:
            if (r4 != 0) goto L_0x092a
            com.google.android.gms.measurement.internal.zzbn r4 = r42.zzln()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r9 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r9 = r9.zztt     // Catch:{ all -> 0x0d13 }
            java.lang.String r12 = r11.name     // Catch:{ all -> 0x0d13 }
            int r4 = r4.zzq(r9, r12)     // Catch:{ all -> 0x0d13 }
            goto L_0x092b
        L_0x092a:
            r4 = 1
        L_0x092b:
            if (r4 > 0) goto L_0x094e
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzap r7 = r7.zzgo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzar r7 = r7.zzjg()     // Catch:{ all -> 0x0d13 }
            java.lang.String r8 = "Sample rate must be positive. event, rate"
            java.lang.String r9 = r11.name     // Catch:{ all -> 0x0d13 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0d13 }
            r7.zze(r8, r9, r4)     // Catch:{ all -> 0x0d13 }
            int r4 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0d13 }
            r10 = r4
            r27 = r6
            r4 = r2
            r6 = r3
            goto L_0x0ae1
        L_0x094e:
            java.lang.String r9 = r11.name     // Catch:{ all -> 0x0cf2 }
            java.lang.Object r9 = r2.get(r9)     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.measurement.internal.zzz r9 = (com.google.android.gms.measurement.internal.zzz) r9     // Catch:{ all -> 0x0cf2 }
            if (r9 != 0) goto L_0x09a3
            com.google.android.gms.measurement.internal.zzq r9 = r42.zzjq()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r12 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r12 = r12.zztt     // Catch:{ all -> 0x0d13 }
            java.lang.String r14 = r11.name     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzz r9 = r9.zzg(r12, r14)     // Catch:{ all -> 0x0d13 }
            if (r9 != 0) goto L_0x09a3
            com.google.android.gms.measurement.internal.zzbt r9 = r1.zzadj     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzap r9 = r9.zzgo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzar r9 = r9.zzjg()     // Catch:{ all -> 0x0d13 }
            java.lang.String r12 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzgi r14 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r14 = r14.zztt     // Catch:{ all -> 0x0d13 }
            java.lang.String r15 = r11.name     // Catch:{ all -> 0x0d13 }
            r9.zze(r12, r14, r15)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzz r9 = new com.google.android.gms.measurement.internal.zzz     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgi r12 = r3.zzaua     // Catch:{ all -> 0x0d13 }
            java.lang.String r12 = r12.zztt     // Catch:{ all -> 0x0d13 }
            java.lang.String r14 = r11.name     // Catch:{ all -> 0x0d13 }
            r30 = 1
            r32 = 1
            java.lang.Long r15 = r11.zzawu     // Catch:{ all -> 0x0d13 }
            long r34 = r15.longValue()     // Catch:{ all -> 0x0d13 }
            r36 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r27 = r9
            r28 = r12
            r29 = r14
            r27.<init>(r28, r29, r30, r32, r34, r36, r38, r39, r40, r41)     // Catch:{ all -> 0x0d13 }
        L_0x09a3:
            r42.zzjo()     // Catch:{ all -> 0x0cf2 }
            java.lang.String r12 = "_eid"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzfg.zzb(r11, r12)     // Catch:{ all -> 0x0cf2 }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0cf2 }
            if (r12 == 0) goto L_0x09b3
            r14 = 1
            goto L_0x09b4
        L_0x09b3:
            r14 = 0
        L_0x09b4:
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)     // Catch:{ all -> 0x0cf2 }
            r15 = 1
            if (r4 != r15) goto L_0x09e2
            int r4 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0d13 }
            boolean r7 = r14.booleanValue()     // Catch:{ all -> 0x0d13 }
            if (r7 == 0) goto L_0x09db
            java.lang.Long r7 = r9.zzaij     // Catch:{ all -> 0x0d13 }
            if (r7 != 0) goto L_0x09d1
            java.lang.Long r7 = r9.zzaik     // Catch:{ all -> 0x0d13 }
            if (r7 != 0) goto L_0x09d1
            java.lang.Boolean r7 = r9.zzail     // Catch:{ all -> 0x0d13 }
            if (r7 == 0) goto L_0x09db
        L_0x09d1:
            r7 = 0
            com.google.android.gms.measurement.internal.zzz r8 = r9.zza(r7, r7, r7)     // Catch:{ all -> 0x0d13 }
            java.lang.String r7 = r11.name     // Catch:{ all -> 0x0d13 }
            r2.put(r7, r8)     // Catch:{ all -> 0x0d13 }
        L_0x09db:
            r10 = r4
            r27 = r6
            r4 = r2
            r6 = r3
            goto L_0x0ae1
        L_0x09e2:
            int r15 = r6.nextInt(r4)     // Catch:{ all -> 0x0cf2 }
            if (r15 != 0) goto L_0x0a24
            r42.zzjo()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r12 = r11.zzawt     // Catch:{ all -> 0x0d13 }
            r15 = r3
            long r3 = (long) r4     // Catch:{ all -> 0x0d13 }
            r27 = r6
            java.lang.Long r6 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.internal.measurement.zzgg[] r6 = com.google.android.gms.measurement.internal.zzfg.zza(r12, r13, r6)     // Catch:{ all -> 0x0d13 }
            r11.zzawt = r6     // Catch:{ all -> 0x0d13 }
            int r6 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0d13 }
            boolean r10 = r14.booleanValue()     // Catch:{ all -> 0x0d13 }
            if (r10 == 0) goto L_0x0a10
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0d13 }
            r4 = 0
            com.google.android.gms.measurement.internal.zzz r9 = r9.zza(r4, r3, r4)     // Catch:{ all -> 0x0d13 }
        L_0x0a10:
            java.lang.String r3 = r11.name     // Catch:{ all -> 0x0d13 }
            java.lang.Long r4 = r11.zzawu     // Catch:{ all -> 0x0d13 }
            long r10 = r4.longValue()     // Catch:{ all -> 0x0d13 }
            com.google.android.gms.measurement.internal.zzz r4 = r9.zza(r10, r7)     // Catch:{ all -> 0x0d13 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0d13 }
            r4 = r2
            r10 = r6
            r6 = r15
            goto L_0x0ae1
        L_0x0a24:
            r15 = r3
            r27 = r6
            com.google.android.gms.measurement.internal.zzbt r3 = r1.zzadj     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.measurement.internal.zzn r3 = r3.zzgq()     // Catch:{ all -> 0x0cf2 }
            r6 = r15
            com.google.android.gms.internal.measurement.zzgi r15 = r6.zzaua     // Catch:{ all -> 0x0cf2 }
            java.lang.String r15 = r15.zztt     // Catch:{ all -> 0x0cf2 }
            boolean r3 = r3.zzbh(r15)     // Catch:{ all -> 0x0cf2 }
            if (r3 == 0) goto L_0x0a64
            java.lang.Long r3 = r9.zzaii     // Catch:{ all -> 0x0cf2 }
            if (r3 == 0) goto L_0x0a46
            java.lang.Long r3 = r9.zzaii     // Catch:{ all -> 0x0d13 }
            long r25 = r3.longValue()     // Catch:{ all -> 0x0d13 }
            r28 = r2
            r3 = r14
            goto L_0x0a5c
        L_0x0a46:
            com.google.android.gms.measurement.internal.zzbt r3 = r1.zzadj     // Catch:{ all -> 0x0cf2 }
            r3.zzgm()     // Catch:{ all -> 0x0cf2 }
            java.lang.Long r3 = r11.zzawv     // Catch:{ all -> 0x0cf2 }
            r15 = r2
            long r1 = r3.longValue()     // Catch:{ all -> 0x0cf2 }
            r3 = r14
            r28 = r15
            r14 = r25
            long r25 = com.google.android.gms.measurement.internal.zzfk.zzc(r1, r14)     // Catch:{ all -> 0x0cf2 }
        L_0x0a5c:
            int r1 = (r25 > r7 ? 1 : (r25 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0a62
            r1 = 1
            goto L_0x0a63
        L_0x0a62:
            r1 = 0
        L_0x0a63:
            goto L_0x0a7e
        L_0x0a64:
            r28 = r2
            r3 = r14
            long r1 = r9.zzaih     // Catch:{ all -> 0x0cf2 }
            java.lang.Long r14 = r11.zzawu     // Catch:{ all -> 0x0cf2 }
            long r14 = r14.longValue()     // Catch:{ all -> 0x0cf2 }
            long r14 = r14 - r1
            long r1 = java.lang.Math.abs(r14)     // Catch:{ all -> 0x0cf2 }
            r14 = 86400000(0x5265c00, double:4.2687272E-316)
            int r25 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r25 < 0) goto L_0x0a7d
            r1 = 1
            goto L_0x0a7e
        L_0x0a7d:
            r1 = 0
        L_0x0a7e:
            if (r1 == 0) goto L_0x0acf
            r42.zzjo()     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.internal.measurement.zzgg[] r1 = r11.zzawt     // Catch:{ all -> 0x0cf2 }
            java.lang.String r2 = "_efs"
            java.lang.Long r12 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.internal.measurement.zzgg[] r1 = com.google.android.gms.measurement.internal.zzfg.zza(r1, r2, r12)     // Catch:{ all -> 0x0cf2 }
            r11.zzawt = r1     // Catch:{ all -> 0x0cf2 }
            r42.zzjo()     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.internal.measurement.zzgg[] r1 = r11.zzawt     // Catch:{ all -> 0x0cf2 }
            long r14 = (long) r4     // Catch:{ all -> 0x0cf2 }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.internal.measurement.zzgg[] r1 = com.google.android.gms.measurement.internal.zzfg.zza(r1, r13, r2)     // Catch:{ all -> 0x0cf2 }
            r11.zzawt = r1     // Catch:{ all -> 0x0cf2 }
            int r1 = r10 + 1
            r5[r10] = r11     // Catch:{ all -> 0x0cf2 }
            boolean r2 = r3.booleanValue()     // Catch:{ all -> 0x0cf2 }
            if (r2 == 0) goto L_0x0abc
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0cf2 }
            r3 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x0cf2 }
            r3 = 0
            com.google.android.gms.measurement.internal.zzz r9 = r9.zza(r3, r2, r4)     // Catch:{ all -> 0x0cf2 }
        L_0x0abc:
            java.lang.String r2 = r11.name     // Catch:{ all -> 0x0cf2 }
            java.lang.Long r3 = r11.zzawu     // Catch:{ all -> 0x0cf2 }
            long r3 = r3.longValue()     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.measurement.internal.zzz r3 = r9.zza(r3, r7)     // Catch:{ all -> 0x0cf2 }
            r4 = r28
            r4.put(r2, r3)     // Catch:{ all -> 0x0cf2 }
            r10 = r1
            goto L_0x0ae1
        L_0x0acf:
            r4 = r28
            boolean r1 = r3.booleanValue()     // Catch:{ all -> 0x0cf2 }
            if (r1 == 0) goto L_0x0ae1
            java.lang.String r1 = r11.name     // Catch:{ all -> 0x0cf2 }
            r2 = 0
            com.google.android.gms.measurement.internal.zzz r3 = r9.zza(r12, r2, r2)     // Catch:{ all -> 0x0cf2 }
            r4.put(r1, r3)     // Catch:{ all -> 0x0cf2 }
        L_0x0ae1:
            int r9 = r24 + 1
            r1 = r42
            r2 = r4
            r3 = r6
            r7 = r21
            r8 = r22
            r4 = r23
            r6 = r27
            goto L_0x0803
        L_0x0af1:
            r6 = r3
            r23 = r4
            r4 = r2
            r1 = r23
            com.google.android.gms.internal.measurement.zzgf[] r2 = r1.zzaxb     // Catch:{ all -> 0x0cf2 }
            int r2 = r2.length     // Catch:{ all -> 0x0cf2 }
            if (r10 >= r2) goto L_0x0b04
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r5, r10)     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.internal.measurement.zzgf[] r2 = (com.google.android.gms.internal.measurement.zzgf[]) r2     // Catch:{ all -> 0x0cf2 }
            r1.zzaxb = r2     // Catch:{ all -> 0x0cf2 }
        L_0x0b04:
            java.util.Set r2 = r4.entrySet()     // Catch:{ all -> 0x0cf2 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0cf2 }
        L_0x0b0c:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0cf2 }
            if (r3 == 0) goto L_0x0b28
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0cf2 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.measurement.internal.zzq r4 = r42.zzjq()     // Catch:{ all -> 0x0cf2 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.measurement.internal.zzz r3 = (com.google.android.gms.measurement.internal.zzz) r3     // Catch:{ all -> 0x0cf2 }
            r4.zza(r3)     // Catch:{ all -> 0x0cf2 }
            goto L_0x0b0c
        L_0x0b26:
            r6 = r3
            r1 = r4
        L_0x0b28:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0cf2 }
            r1.zzaxe = r2     // Catch:{ all -> 0x0cf2 }
            r2 = -9223372036854775808
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0cf2 }
            r1.zzaxf = r2     // Catch:{ all -> 0x0cf2 }
            r2 = 0
        L_0x0b3c:
            com.google.android.gms.internal.measurement.zzgf[] r3 = r1.zzaxb     // Catch:{ all -> 0x0cf2 }
            int r3 = r3.length     // Catch:{ all -> 0x0cf2 }
            if (r2 >= r3) goto L_0x0b70
            com.google.android.gms.internal.measurement.zzgf[] r3 = r1.zzaxb     // Catch:{ all -> 0x0cf2 }
            r3 = r3[r2]     // Catch:{ all -> 0x0cf2 }
            java.lang.Long r4 = r3.zzawu     // Catch:{ all -> 0x0cf2 }
            long r4 = r4.longValue()     // Catch:{ all -> 0x0cf2 }
            java.lang.Long r7 = r1.zzaxe     // Catch:{ all -> 0x0cf2 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0cf2 }
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x0b59
            java.lang.Long r4 = r3.zzawu     // Catch:{ all -> 0x0cf2 }
            r1.zzaxe = r4     // Catch:{ all -> 0x0cf2 }
        L_0x0b59:
            java.lang.Long r4 = r3.zzawu     // Catch:{ all -> 0x0cf2 }
            long r4 = r4.longValue()     // Catch:{ all -> 0x0cf2 }
            java.lang.Long r7 = r1.zzaxf     // Catch:{ all -> 0x0cf2 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0cf2 }
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0b6d
            java.lang.Long r3 = r3.zzawu     // Catch:{ all -> 0x0cf2 }
            r1.zzaxf = r3     // Catch:{ all -> 0x0cf2 }
        L_0x0b6d:
            int r2 = r2 + 1
            goto L_0x0b3c
        L_0x0b70:
            com.google.android.gms.internal.measurement.zzgi r2 = r6.zzaua     // Catch:{ all -> 0x0cf2 }
            java.lang.String r2 = r2.zztt     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.measurement.internal.zzq r3 = r42.zzjq()     // Catch:{ all -> 0x0cf2 }
            com.google.android.gms.measurement.internal.zzg r3 = r3.zzbl(r2)     // Catch:{ all -> 0x0cf2 }
            if (r3 != 0) goto L_0x0b99
            r4 = r42
            com.google.android.gms.measurement.internal.zzbt r3 = r4.zzadj     // Catch:{ all -> 0x0d11 }
            com.google.android.gms.measurement.internal.zzap r3 = r3.zzgo()     // Catch:{ all -> 0x0d11 }
            com.google.android.gms.measurement.internal.zzar r3 = r3.zzjd()     // Catch:{ all -> 0x0d11 }
            java.lang.String r5 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzgi r7 = r6.zzaua     // Catch:{ all -> 0x0d11 }
            java.lang.String r7 = r7.zztt     // Catch:{ all -> 0x0d11 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzap.zzbv(r7)     // Catch:{ all -> 0x0d11 }
            r3.zzg(r5, r7)     // Catch:{ all -> 0x0d11 }
            goto L_0x0bf7
        L_0x0b99:
            r4 = r42
            com.google.android.gms.internal.measurement.zzgf[] r5 = r1.zzaxb     // Catch:{ all -> 0x0d11 }
            int r5 = r5.length     // Catch:{ all -> 0x0d11 }
            if (r5 <= 0) goto L_0x0bf7
            long r7 = r3.zzgz()     // Catch:{ all -> 0x0d11 }
            r9 = 0
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x0baf
            java.lang.Long r5 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0d11 }
            goto L_0x0bb0
        L_0x0baf:
            r5 = 0
        L_0x0bb0:
            r1.zzaxh = r5     // Catch:{ all -> 0x0d11 }
            long r9 = r3.zzgy()     // Catch:{ all -> 0x0d11 }
            r11 = 0
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 != 0) goto L_0x0bbd
            goto L_0x0bbe
        L_0x0bbd:
            r7 = r9
        L_0x0bbe:
            int r5 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0bc7
            java.lang.Long r5 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0d11 }
            goto L_0x0bc8
        L_0x0bc7:
            r5 = 0
        L_0x0bc8:
            r1.zzaxg = r5     // Catch:{ all -> 0x0d11 }
            r3.zzhh()     // Catch:{ all -> 0x0d11 }
            long r7 = r3.zzhe()     // Catch:{ all -> 0x0d11 }
            int r5 = (int) r7     // Catch:{ all -> 0x0d11 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0d11 }
            r1.zzaxr = r5     // Catch:{ all -> 0x0d11 }
            java.lang.Long r5 = r1.zzaxe     // Catch:{ all -> 0x0d11 }
            long r7 = r5.longValue()     // Catch:{ all -> 0x0d11 }
            r3.zzs(r7)     // Catch:{ all -> 0x0d11 }
            java.lang.Long r5 = r1.zzaxf     // Catch:{ all -> 0x0d11 }
            long r7 = r5.longValue()     // Catch:{ all -> 0x0d11 }
            r3.zzt(r7)     // Catch:{ all -> 0x0d11 }
            java.lang.String r5 = r3.zzhp()     // Catch:{ all -> 0x0d11 }
            r1.zzagv = r5     // Catch:{ all -> 0x0d11 }
            com.google.android.gms.measurement.internal.zzq r5 = r42.zzjq()     // Catch:{ all -> 0x0d11 }
            r5.zza(r3)     // Catch:{ all -> 0x0d11 }
        L_0x0bf7:
            com.google.android.gms.internal.measurement.zzgf[] r3 = r1.zzaxb     // Catch:{ all -> 0x0d11 }
            int r3 = r3.length     // Catch:{ all -> 0x0d11 }
            if (r3 <= 0) goto L_0x0c51
            com.google.android.gms.measurement.internal.zzbt r3 = r4.zzadj     // Catch:{ all -> 0x0d11 }
            r3.zzgr()     // Catch:{ all -> 0x0d11 }
            com.google.android.gms.measurement.internal.zzbn r3 = r42.zzln()     // Catch:{ all -> 0x0d11 }
            com.google.android.gms.internal.measurement.zzgi r5 = r6.zzaua     // Catch:{ all -> 0x0d11 }
            java.lang.String r5 = r5.zztt     // Catch:{ all -> 0x0d11 }
            com.google.android.gms.internal.measurement.zzgb r3 = r3.zzcf(r5)     // Catch:{ all -> 0x0d11 }
            if (r3 == 0) goto L_0x0c1d
            java.lang.Long r5 = r3.zzawe     // Catch:{ all -> 0x0d11 }
            if (r5 != 0) goto L_0x0c18
            goto L_0x0c1d
        L_0x0c18:
            java.lang.Long r3 = r3.zzawe     // Catch:{ all -> 0x0d11 }
            r1.zzaxy = r3     // Catch:{ all -> 0x0d11 }
            goto L_0x0c48
        L_0x0c1d:
            com.google.android.gms.internal.measurement.zzgi r3 = r6.zzaua     // Catch:{ all -> 0x0d11 }
            java.lang.String r3 = r3.zzafx     // Catch:{ all -> 0x0d11 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0d11 }
            if (r3 == 0) goto L_0x0c30
            r7 = -1
            java.lang.Long r3 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0d11 }
            r1.zzaxy = r3     // Catch:{ all -> 0x0d11 }
            goto L_0x0c48
        L_0x0c30:
            com.google.android.gms.measurement.internal.zzbt r3 = r4.zzadj     // Catch:{ all -> 0x0d11 }
            com.google.android.gms.measurement.internal.zzap r3 = r3.zzgo()     // Catch:{ all -> 0x0d11 }
            com.google.android.gms.measurement.internal.zzar r3 = r3.zzjg()     // Catch:{ all -> 0x0d11 }
            java.lang.String r5 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzgi r7 = r6.zzaua     // Catch:{ all -> 0x0d11 }
            java.lang.String r7 = r7.zztt     // Catch:{ all -> 0x0d11 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzap.zzbv(r7)     // Catch:{ all -> 0x0d11 }
            r3.zzg(r5, r7)     // Catch:{ all -> 0x0d11 }
        L_0x0c48:
            com.google.android.gms.measurement.internal.zzq r3 = r42.zzjq()     // Catch:{ all -> 0x0d11 }
            r12 = r20
            r3.zza(r1, r12)     // Catch:{ all -> 0x0d11 }
        L_0x0c51:
            com.google.android.gms.measurement.internal.zzq r1 = r42.zzjq()     // Catch:{ all -> 0x0d11 }
            java.util.List<java.lang.Long> r3 = r6.zzaub     // Catch:{ all -> 0x0d11 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0d11 }
            r1.zzaf()     // Catch:{ all -> 0x0d11 }
            r1.zzcl()     // Catch:{ all -> 0x0d11 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0d11 }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0d11 }
            r6 = 0
        L_0x0c68:
            int r7 = r3.size()     // Catch:{ all -> 0x0d11 }
            if (r6 >= r7) goto L_0x0c85
            if (r6 == 0) goto L_0x0c75
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0d11 }
        L_0x0c75:
            java.lang.Object r7 = r3.get(r6)     // Catch:{ all -> 0x0d11 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0d11 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0d11 }
            r5.append(r7)     // Catch:{ all -> 0x0d11 }
            int r6 = r6 + 1
            goto L_0x0c68
        L_0x0c85:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0d11 }
            android.database.sqlite.SQLiteDatabase r6 = r1.getWritableDatabase()     // Catch:{ all -> 0x0d11 }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0d11 }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0d11 }
            int r6 = r3.size()     // Catch:{ all -> 0x0d11 }
            if (r5 == r6) goto L_0x0cb8
            com.google.android.gms.measurement.internal.zzap r1 = r1.zzgo()     // Catch:{ all -> 0x0d11 }
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()     // Catch:{ all -> 0x0d11 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0d11 }
            int r3 = r3.size()     // Catch:{ all -> 0x0d11 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0d11 }
            r1.zze(r6, r5, r3)     // Catch:{ all -> 0x0d11 }
        L_0x0cb8:
            com.google.android.gms.measurement.internal.zzq r1 = r42.zzjq()     // Catch:{ all -> 0x0d11 }
            android.database.sqlite.SQLiteDatabase r3 = r1.getWritableDatabase()     // Catch:{ all -> 0x0d11 }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0ccf }
            r7 = 0
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0ccf }
            r7 = 1
            r6[r7] = r2     // Catch:{ SQLiteException -> 0x0ccf }
            r3.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0ccf }
            goto L_0x0ce2
        L_0x0ccf:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzap r1 = r1.zzgo()     // Catch:{ all -> 0x0d11 }
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()     // Catch:{ all -> 0x0d11 }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzap.zzbv(r2)     // Catch:{ all -> 0x0d11 }
            r1.zze(r5, r2, r3)     // Catch:{ all -> 0x0d11 }
        L_0x0ce2:
            com.google.android.gms.measurement.internal.zzq r1 = r42.zzjq()     // Catch:{ all -> 0x0d11 }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x0d11 }
            com.google.android.gms.measurement.internal.zzq r1 = r42.zzjq()
            r1.endTransaction()
            r1 = 1
            return r1
        L_0x0cf2:
            r0 = move-exception
            r4 = r42
            goto L_0x0d15
        L_0x0cf6:
            r4 = r1
            com.google.android.gms.measurement.internal.zzq r1 = r42.zzjq()     // Catch:{ all -> 0x0d11 }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x0d11 }
            com.google.android.gms.measurement.internal.zzq r1 = r42.zzjq()
            r1.endTransaction()
            r1 = 0
            return r1
        L_0x0d07:
            r0 = move-exception
        L_0x0d08:
            r4 = r1
            goto L_0x0266
        L_0x0d0b:
            if (r9 == 0) goto L_0x0d10
            r9.close()     // Catch:{ all -> 0x0d11 }
        L_0x0d10:
            throw r1     // Catch:{ all -> 0x0d11 }
        L_0x0d11:
            r0 = move-exception
            goto L_0x0d15
        L_0x0d13:
            r0 = move-exception
            r4 = r1
        L_0x0d15:
            r1 = r0
            com.google.android.gms.measurement.internal.zzq r2 = r42.zzjq()
            r2.endTransaction()
            goto L_0x0d1f
        L_0x0d1e:
            throw r1
        L_0x0d1f:
            goto L_0x0d1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfa.zzd(java.lang.String, long):boolean");
    }

    @VisibleForTesting
    private static zzgg[] zza(zzgg[] zzggArr, @NonNull String str) {
        int i = 0;
        while (true) {
            if (i >= zzggArr.length) {
                i = -1;
                break;
            } else if (str.equals(zzggArr[i].name)) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return zzggArr;
        }
        return zza(zzggArr, i);
    }

    @VisibleForTesting
    private static zzgg[] zza(zzgg[] zzggArr, int i) {
        zzgg[] zzggArr2 = new zzgg[(zzggArr.length - 1)];
        if (i > 0) {
            System.arraycopy(zzggArr, 0, zzggArr2, 0, i);
        }
        if (i < zzggArr2.length) {
            System.arraycopy(zzggArr, i + 1, zzggArr2, i, zzggArr2.length - i);
        }
        return zzggArr2;
    }

    @VisibleForTesting
    private static zzgg[] zza(zzgg[] zzggArr, int i, String str) {
        int i2 = 0;
        while (true) {
            String str2 = "_err";
            if (i2 >= zzggArr.length) {
                zzgg[] zzggArr2 = new zzgg[(zzggArr.length + 2)];
                System.arraycopy(zzggArr, 0, zzggArr2, 0, zzggArr.length);
                zzgg zzgg = new zzgg();
                zzgg.name = str2;
                zzgg.zzawx = Long.valueOf((long) i);
                zzgg zzgg2 = new zzgg();
                zzgg2.name = "_ev";
                zzgg2.zzamp = str;
                zzggArr2[zzggArr2.length - 2] = zzgg;
                zzggArr2[zzggArr2.length - 1] = zzgg2;
                return zzggArr2;
            } else if (str2.equals(zzggArr[i2].name)) {
                return zzggArr;
            } else {
                i2++;
            }
        }
    }

    private final zzgd[] zza(String str, zzgl[] zzglArr, zzgf[] zzgfArr) {
        Preconditions.checkNotEmpty(str);
        return zzjp().zza(str, zzgfArr, zzglArr);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    @WorkerThread
    @VisibleForTesting
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzq zzjq;
        zzaf();
        zzlr();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzatq = false;
                zzlw();
                throw th2;
            }
        }
        List<Long> list = this.zzatu;
        this.zzatu = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzadj.zzgp().zzane.set(this.zzadj.zzbx().currentTimeMillis());
                this.zzadj.zzgp().zzanf.set(0);
                zzlv();
                this.zzadj.zzgo().zzjl().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzjq().beginTransaction();
                try {
                    for (Long l : list) {
                        try {
                            zzjq = zzjq();
                            long longValue = l.longValue();
                            zzjq.zzaf();
                            zzjq.zzcl();
                            if (zzjq.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzjq.zzgo().zzjd().zzg("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzatv == null || !this.zzatv.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zzjq().setTransactionSuccessful();
                    zzjq().endTransaction();
                    this.zzatv = null;
                    if (!zzlo().zzfb() || !zzlu()) {
                        this.zzatw = -1;
                        zzlv();
                    } else {
                        zzlt();
                    }
                    this.zzatl = 0;
                } catch (Throwable th3) {
                    zzjq().endTransaction();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzadj.zzgo().zzjd().zzg("Database error while trying to delete uploaded bundles", e3);
                this.zzatl = this.zzadj.zzbx().elapsedRealtime();
                this.zzadj.zzgo().zzjl().zzg("Disable upload, time", Long.valueOf(this.zzatl));
            }
        } else {
            this.zzadj.zzgo().zzjl().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzadj.zzgp().zzanf.set(this.zzadj.zzbx().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzadj.zzgp().zzang.set(this.zzadj.zzbx().currentTimeMillis());
            }
            if (this.zzadj.zzgq().zzaz(str)) {
                zzjq().zzc(list);
            }
            zzlv();
        }
        this.zzatq = false;
        zzlw();
    }

    private final boolean zzlu() {
        zzaf();
        zzlr();
        return zzjq().zzii() || !TextUtils.isEmpty(zzjq().zzid());
    }

    @WorkerThread
    private final void zzb(zzg zzg) {
        Map map;
        zzaf();
        if (!TextUtils.isEmpty(zzg.getGmpAppId()) || (zzn.zzic() && !TextUtils.isEmpty(zzg.zzgw()))) {
            zzn zzgq = this.zzadj.zzgq();
            Builder builder = new Builder();
            String gmpAppId = zzg.getGmpAppId();
            if (TextUtils.isEmpty(gmpAppId) && zzn.zzic()) {
                gmpAppId = zzg.zzgw();
            }
            Builder encodedAuthority = builder.scheme((String) zzaf.zzajh.get()).encodedAuthority((String) zzaf.zzaji.get());
            String str = "config/app/";
            String valueOf = String.valueOf(gmpAppId);
            encodedAuthority.path(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).appendQueryParameter("app_instance_id", zzg.getAppInstanceId()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zzgq.zzhc()));
            String uri = builder.build().toString();
            try {
                URL url = new URL(uri);
                this.zzadj.zzgo().zzjl().zzg("Fetching remote configuration", zzg.zzal());
                zzgb zzcf = zzln().zzcf(zzg.zzal());
                String zzcg = zzln().zzcg(zzg.zzal());
                if (zzcf == null || TextUtils.isEmpty(zzcg)) {
                    map = null;
                } else {
                    ArrayMap arrayMap = new ArrayMap();
                    arrayMap.put("If-Modified-Since", zzcg);
                    map = arrayMap;
                }
                this.zzatp = true;
                zzat zzlo = zzlo();
                String zzal = zzg.zzal();
                zzfd zzfd = new zzfd(this);
                zzlo.zzaf();
                zzlo.zzcl();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzfd);
                zzbo zzgn = zzlo.zzgn();
                zzax zzax = new zzax(zzlo, zzal, url, null, map, zzfd);
                zzgn.zzd((Runnable) zzax);
            } catch (MalformedURLException e) {
                this.zzadj.zzgo().zzjd().zze("Failed to parse config URL. Not fetching. appId", zzap.zzbv(zzg.zzal()), uri);
            }
        } else {
            zzb(zzg.zzal(), 204, null, null, null);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0141 A[Catch:{ all -> 0x0198, all -> 0x01a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0152 A[Catch:{ all -> 0x0198, all -> 0x01a1 }] */
    @android.support.annotation.WorkerThread
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzaf()
            r6.zzlr()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x01a1 }
        L_0x000e:
            com.google.android.gms.measurement.internal.zzbt r1 = r6.zzadj     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzap r1 = r1.zzgo()     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjl()     // Catch:{ all -> 0x01a1 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x01a1 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01a1 }
            r1.zzg(r2, r3)     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzq r1 = r6.zzjq()     // Catch:{ all -> 0x01a1 }
            r1.beginTransaction()     // Catch:{ all -> 0x01a1 }
            com.google.android.gms.measurement.internal.zzq r1 = r6.zzjq()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzg r1 = r1.zzbl(r7)     // Catch:{ all -> 0x0198 }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003f
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003f
            if (r8 != r3) goto L_0x0043
        L_0x003f:
            if (r9 != 0) goto L_0x0043
            r2 = 1
            goto L_0x0044
        L_0x0043:
            r2 = 0
        L_0x0044:
            if (r1 != 0) goto L_0x005c
            com.google.android.gms.measurement.internal.zzbt r8 = r6.zzadj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzap r8 = r8.zzgo()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzar r8 = r8.zzjg()     // Catch:{ all -> 0x0198 }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzap.zzbv(r7)     // Catch:{ all -> 0x0198 }
            r8.zzg(r9, r7)     // Catch:{ all -> 0x0198 }
            goto L_0x0183
        L_0x005c:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00d0
            if (r8 != r5) goto L_0x0063
            goto L_0x00d0
        L_0x0063:
            com.google.android.gms.measurement.internal.zzbt r10 = r6.zzadj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.common.util.Clock r10 = r10.zzbx()     // Catch:{ all -> 0x0198 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0198 }
            r1.zzz(r10)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzq r10 = r6.zzjq()     // Catch:{ all -> 0x0198 }
            r10.zza(r1)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzbt r10 = r6.zzadj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzap r10 = r10.zzgo()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzar r10 = r10.zzjl()     // Catch:{ all -> 0x0198 }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0198 }
            r10.zze(r11, r1, r9)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzbn r9 = r6.zzln()     // Catch:{ all -> 0x0198 }
            r9.zzch(r7)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzbt r7 = r6.zzadj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzba r7 = r7.zzgp()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzbd r7 = r7.zzanf     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzbt r9 = r6.zzadj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.common.util.Clock r9 = r9.zzbx()     // Catch:{ all -> 0x0198 }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x0198 }
            r7.set(r9)     // Catch:{ all -> 0x0198 }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00b3
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00b2
            goto L_0x00b3
        L_0x00b2:
            r4 = 0
        L_0x00b3:
            if (r4 == 0) goto L_0x00cb
            com.google.android.gms.measurement.internal.zzbt r7 = r6.zzadj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzba r7 = r7.zzgp()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzbd r7 = r7.zzang     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzbt r8 = r6.zzadj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.common.util.Clock r8 = r8.zzbx()     // Catch:{ all -> 0x0198 }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0198 }
            r7.set(r8)     // Catch:{ all -> 0x0198 }
        L_0x00cb:
            r6.zzlv()     // Catch:{ all -> 0x0198 }
            goto L_0x0183
        L_0x00d0:
            r9 = 0
            if (r11 == 0) goto L_0x00dc
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x0198 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x0198 }
            goto L_0x00dd
        L_0x00dc:
            r11 = r9
        L_0x00dd:
            if (r11 == 0) goto L_0x00ec
            int r2 = r11.size()     // Catch:{ all -> 0x0198 }
            if (r2 <= 0) goto L_0x00ec
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0198 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0198 }
            goto L_0x00ed
        L_0x00ec:
            r11 = r9
        L_0x00ed:
            if (r8 == r5) goto L_0x0109
            if (r8 != r3) goto L_0x00f2
            goto L_0x0109
        L_0x00f2:
            com.google.android.gms.measurement.internal.zzbn r9 = r6.zzln()     // Catch:{ all -> 0x0198 }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x0198 }
            if (r9 != 0) goto L_0x012a
            com.google.android.gms.measurement.internal.zzq r7 = r6.zzjq()     // Catch:{ all -> 0x01a1 }
            r7.endTransaction()     // Catch:{ all -> 0x01a1 }
            r6.zzatp = r0
            r6.zzlw()
            return
        L_0x0109:
            com.google.android.gms.measurement.internal.zzbn r11 = r6.zzln()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.internal.measurement.zzgb r11 = r11.zzcf(r7)     // Catch:{ all -> 0x0198 }
            if (r11 != 0) goto L_0x012a
            com.google.android.gms.measurement.internal.zzbn r11 = r6.zzln()     // Catch:{ all -> 0x0198 }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x0198 }
            if (r9 != 0) goto L_0x012a
            com.google.android.gms.measurement.internal.zzq r7 = r6.zzjq()     // Catch:{ all -> 0x01a1 }
            r7.endTransaction()     // Catch:{ all -> 0x01a1 }
            r6.zzatp = r0
            r6.zzlw()
            return
        L_0x012a:
            com.google.android.gms.measurement.internal.zzbt r9 = r6.zzadj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.common.util.Clock r9 = r9.zzbx()     // Catch:{ all -> 0x0198 }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x0198 }
            r1.zzy(r2)     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzq r9 = r6.zzjq()     // Catch:{ all -> 0x0198 }
            r9.zza(r1)     // Catch:{ all -> 0x0198 }
            if (r8 != r5) goto L_0x0152
            com.google.android.gms.measurement.internal.zzbt r8 = r6.zzadj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzap r8 = r8.zzgo()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzar r8 = r8.zzji()     // Catch:{ all -> 0x0198 }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zzg(r9, r7)     // Catch:{ all -> 0x0198 }
            goto L_0x016b
        L_0x0152:
            com.google.android.gms.measurement.internal.zzbt r7 = r6.zzadj     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzap r7 = r7.zzgo()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzar r7 = r7.zzjl()     // Catch:{ all -> 0x0198 }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0198 }
            int r10 = r10.length     // Catch:{ all -> 0x0198 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0198 }
            r7.zze(r9, r8, r10)     // Catch:{ all -> 0x0198 }
        L_0x016b:
            com.google.android.gms.measurement.internal.zzat r7 = r6.zzlo()     // Catch:{ all -> 0x0198 }
            boolean r7 = r7.zzfb()     // Catch:{ all -> 0x0198 }
            if (r7 == 0) goto L_0x017f
            boolean r7 = r6.zzlu()     // Catch:{ all -> 0x0198 }
            if (r7 == 0) goto L_0x017f
            r6.zzlt()     // Catch:{ all -> 0x0198 }
            goto L_0x0183
        L_0x017f:
            r6.zzlv()     // Catch:{ all -> 0x0198 }
        L_0x0183:
            com.google.android.gms.measurement.internal.zzq r7 = r6.zzjq()     // Catch:{ all -> 0x0198 }
            r7.setTransactionSuccessful()     // Catch:{ all -> 0x0198 }
            com.google.android.gms.measurement.internal.zzq r7 = r6.zzjq()     // Catch:{ all -> 0x01a1 }
            r7.endTransaction()     // Catch:{ all -> 0x01a1 }
            r6.zzatp = r0
            r6.zzlw()
            return
        L_0x0198:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzq r8 = r6.zzjq()     // Catch:{ all -> 0x01a1 }
            r8.endTransaction()     // Catch:{ all -> 0x01a1 }
            throw r7     // Catch:{ all -> 0x01a1 }
        L_0x01a1:
            r7 = move-exception
            r6.zzatp = r0
            r6.zzlw()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfa.zzb(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    @WorkerThread
    private final void zzlv() {
        long j;
        long j2;
        zzaf();
        zzlr();
        if (zzlz()) {
            if (this.zzatl > 0) {
                long abs = 3600000 - Math.abs(this.zzadj.zzbx().elapsedRealtime() - this.zzatl);
                if (abs > 0) {
                    this.zzadj.zzgo().zzjl().zzg("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    zzlp().unregister();
                    zzlq().cancel();
                    return;
                }
                this.zzatl = 0;
            }
            if (!this.zzadj.zzkr() || !zzlu()) {
                this.zzadj.zzgo().zzjl().zzbx("Nothing to upload or uploading impossible");
                zzlp().unregister();
                zzlq().cancel();
                return;
            }
            long currentTimeMillis = this.zzadj.zzbx().currentTimeMillis();
            long max = Math.max(0, ((Long) zzaf.zzakd.get()).longValue());
            boolean z = zzjq().zzij() || zzjq().zzie();
            if (z) {
                String zzhy = this.zzadj.zzgq().zzhy();
                if (TextUtils.isEmpty(zzhy) || ".none.".equals(zzhy)) {
                    j = Math.max(0, ((Long) zzaf.zzajx.get()).longValue());
                } else {
                    j = Math.max(0, ((Long) zzaf.zzajy.get()).longValue());
                }
            } else {
                j = Math.max(0, ((Long) zzaf.zzajw.get()).longValue());
            }
            long j3 = this.zzadj.zzgp().zzane.get();
            long j4 = this.zzadj.zzgp().zzanf.get();
            long j5 = j;
            long max2 = Math.max(zzjq().zzig(), zzjq().zzih());
            if (max2 == 0) {
                j2 = 0;
            } else {
                long abs2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
                long abs3 = currentTimeMillis - Math.abs(j3 - currentTimeMillis);
                long abs4 = currentTimeMillis - Math.abs(j4 - currentTimeMillis);
                long max3 = Math.max(abs3, abs4);
                j2 = max + abs2;
                if (z && max3 > 0) {
                    j2 = Math.min(abs2, max3) + j5;
                }
                long j6 = j5;
                if (!zzjo().zzb(max3, j6)) {
                    j2 = max3 + j6;
                }
                if (abs4 != 0 && abs4 >= abs2) {
                    int i = 0;
                    while (true) {
                        if (i >= Math.min(20, Math.max(0, ((Integer) zzaf.zzakf.get()).intValue()))) {
                            j2 = 0;
                            break;
                        }
                        j2 += Math.max(0, ((Long) zzaf.zzake.get()).longValue()) * (1 << i);
                        if (j2 > abs4) {
                            break;
                        }
                        i++;
                    }
                }
            }
            if (j2 == 0) {
                this.zzadj.zzgo().zzjl().zzbx("Next upload time is 0");
                zzlp().unregister();
                zzlq().cancel();
            } else if (!zzlo().zzfb()) {
                this.zzadj.zzgo().zzjl().zzbx("No network");
                zzlp().zzey();
                zzlq().cancel();
            } else {
                long j7 = this.zzadj.zzgp().zzang.get();
                long max4 = Math.max(0, ((Long) zzaf.zzaju.get()).longValue());
                if (!zzjo().zzb(j7, max4)) {
                    j2 = Math.max(j2, j7 + max4);
                }
                zzlp().unregister();
                long currentTimeMillis2 = j2 - this.zzadj.zzbx().currentTimeMillis();
                if (currentTimeMillis2 <= 0) {
                    currentTimeMillis2 = Math.max(0, ((Long) zzaf.zzajz.get()).longValue());
                    this.zzadj.zzgp().zzane.set(this.zzadj.zzbx().currentTimeMillis());
                }
                this.zzadj.zzgo().zzjl().zzg("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
                zzlq().zzh(currentTimeMillis2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzg(Runnable runnable) {
        zzaf();
        if (this.zzatm == null) {
            this.zzatm = new ArrayList();
        }
        this.zzatm.add(runnable);
    }

    @WorkerThread
    private final void zzlw() {
        zzaf();
        if (this.zzatp || this.zzatq || this.zzatr) {
            this.zzadj.zzgo().zzjl().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzatp), Boolean.valueOf(this.zzatq), Boolean.valueOf(this.zzatr));
            return;
        }
        this.zzadj.zzgo().zzjl().zzbx("Stopping uploading service(s)");
        List<Runnable> list = this.zzatm;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzatm.clear();
        }
    }

    @WorkerThread
    private final Boolean zzc(zzg zzg) {
        try {
            if (zzg.zzha() != -2147483648L) {
                if (zzg.zzha() == ((long) Wrappers.packageManager(this.zzadj.getContext()).getPackageInfo(zzg.zzal(), 0).versionCode)) {
                    return Boolean.valueOf(true);
                }
            } else {
                String str = Wrappers.packageManager(this.zzadj.getContext()).getPackageInfo(zzg.zzal(), 0).versionName;
                if (zzg.zzak() != null && zzg.zzak().equals(str)) {
                    return Boolean.valueOf(true);
                }
            }
            return Boolean.valueOf(false);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zzlx() {
        zzaf();
        try {
            this.zzatt = new RandomAccessFile(new File(this.zzadj.getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzats = this.zzatt.tryLock();
            if (this.zzats != null) {
                this.zzadj.zzgo().zzjl().zzbx("Storage concurrent access okay");
                return true;
            }
            this.zzadj.zzgo().zzjd().zzbx("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            this.zzadj.zzgo().zzjd().zzg("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            this.zzadj.zzgo().zzjd().zzg("Failed to access storage lock file", e2);
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        zzaf();
        int i = 0;
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzadj.zzgo().zzjd().zzbx("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzadj.zzgo().zzjg().zzg("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            i = allocate.getInt();
            return i;
        } catch (IOException e) {
            this.zzadj.zzgo().zzjd().zzg("Failed to read from channel", e);
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzaf();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzadj.zzgo().zzjd().zzbx("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzadj.zzgo().zzjd().zzg("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzadj.zzgo().zzjd().zzg("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzly() {
        zzaf();
        zzlr();
        if (!this.zzatk) {
            this.zzadj.zzgo().zzjj().zzbx("This instance being marked as an uploader");
            zzaf();
            zzlr();
            if (zzlz() && zzlx()) {
                int zza2 = zza(this.zzatt);
                int zzja = this.zzadj.zzgf().zzja();
                zzaf();
                if (zza2 > zzja) {
                    this.zzadj.zzgo().zzjd().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzja));
                } else if (zza2 < zzja) {
                    if (zza(zzja, this.zzatt)) {
                        this.zzadj.zzgo().zzjl().zze("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzja));
                    } else {
                        this.zzadj.zzgo().zzjd().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzja));
                    }
                }
            }
            this.zzatk = true;
            zzlv();
        }
    }

    @WorkerThread
    private final boolean zzlz() {
        zzaf();
        zzlr();
        return this.zzatk;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    @VisibleForTesting
    public final void zzd(zzh zzh) {
        String str = "app_id=?";
        if (this.zzatu != null) {
            this.zzatv = new ArrayList();
            this.zzatv.addAll(this.zzatu);
        }
        zzq zzjq = zzjq();
        String str2 = zzh.packageName;
        Preconditions.checkNotEmpty(str2);
        zzjq.zzaf();
        zzjq.zzcl();
        try {
            SQLiteDatabase writableDatabase = zzjq.getWritableDatabase();
            String[] strArr = {str2};
            int delete = writableDatabase.delete("apps", str, strArr) + 0 + writableDatabase.delete("events", str, strArr) + writableDatabase.delete("user_attributes", str, strArr) + writableDatabase.delete("conditional_properties", str, strArr) + writableDatabase.delete("raw_events", str, strArr) + writableDatabase.delete("raw_events_metadata", str, strArr) + writableDatabase.delete("queue", str, strArr) + writableDatabase.delete("audience_filter_values", str, strArr) + writableDatabase.delete("main_event_params", str, strArr);
            if (delete > 0) {
                zzjq.zzgo().zzjl().zze("Reset analytics data. app, records", str2, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzjq.zzgo().zzjd().zze("Error resetting analytics data. appId, error", zzap.zzbv(str2), e);
        }
        zzh zza2 = zza(this.zzadj.getContext(), zzh.packageName, zzh.zzafx, zzh.zzagg, zzh.zzagi, zzh.zzagj, zzh.zzagx, zzh.zzagk);
        if (!this.zzadj.zzgq().zzbd(zzh.packageName) || zzh.zzagg) {
            zzf(zza2);
        }
    }

    private final zzh zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3) {
        String str4;
        String str5;
        String str6;
        int i;
        long j2;
        String str7 = str;
        String str8 = "Unknown";
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.zzadj.zzgo().zzjd().zzbx("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str4 = packageManager.getInstallerPackageName(str7);
        } catch (IllegalArgumentException e) {
            this.zzadj.zzgo().zzjd().zzg("Error retrieving installer package name. appId", zzap.zzbv(str));
            str4 = str8;
        }
        if (str4 == null) {
            str5 = "manual_install";
        } else if ("com.android.vending".equals(str4)) {
            str5 = "";
        } else {
            str5 = str4;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str7, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str7);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    String charSequence = applicationLabel.toString();
                }
                str6 = packageInfo.versionName;
                i = packageInfo.versionCode;
            } else {
                i = Integer.MIN_VALUE;
                str6 = str8;
            }
            this.zzadj.zzgr();
            if (this.zzadj.zzgq().zzbe(str7)) {
                j2 = j;
            } else {
                j2 = 0;
            }
            zzh zzh = new zzh(str, str2, str6, (long) i, str5, this.zzadj.zzgq().zzhc(), this.zzadj.zzgm().zzd(context, str7), (String) null, z, false, "", 0, j2, 0, z2, z3, false, str3);
            return zzh;
        } catch (NameNotFoundException e2) {
            this.zzadj.zzgo().zzjd().zze("Error retrieving newly installed package info. appId, appName", zzap.zzbv(str), str8);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzb(zzfh zzfh, zzh zzh) {
        int i;
        zzaf();
        zzlr();
        if (TextUtils.isEmpty(zzh.zzafx) && TextUtils.isEmpty(zzh.zzagk)) {
            return;
        }
        if (!zzh.zzagg) {
            zzg(zzh);
            return;
        }
        if (this.zzadj.zzgq().zze(zzh.packageName, zzaf.zzalj)) {
            String str = "_ap";
            if (str.equals(zzfh.name)) {
                zzfj zzi = zzjq().zzi(zzh.packageName, str);
                if (zzi != null) {
                    String str2 = "auto";
                    if (str2.equals(zzfh.origin) && !str2.equals(zzi.origin)) {
                        this.zzadj.zzgo().zzjk().zzbx("Not setting lower priority ad personalization property");
                        return;
                    }
                }
            }
        }
        int zzcs = this.zzadj.zzgm().zzcs(zzfh.name);
        if (zzcs != 0) {
            this.zzadj.zzgm();
            this.zzadj.zzgm().zza(zzh.packageName, zzcs, "_ev", zzfk.zza(zzfh.name, 24, true), zzfh.name != null ? zzfh.name.length() : 0);
            return;
        }
        int zzi2 = this.zzadj.zzgm().zzi(zzfh.name, zzfh.getValue());
        if (zzi2 != 0) {
            this.zzadj.zzgm();
            String zza2 = zzfk.zza(zzfh.name, 24, true);
            Object value = zzfh.getValue();
            if (value == null || (!(value instanceof String) && !(value instanceof CharSequence))) {
                i = 0;
            } else {
                i = String.valueOf(value).length();
            }
            this.zzadj.zzgm().zza(zzh.packageName, zzi2, "_ev", zza2, i);
            return;
        }
        Object zzj = this.zzadj.zzgm().zzj(zzfh.name, zzfh.getValue());
        if (zzj != null) {
            zzfj zzfj = new zzfj(zzh.packageName, zzfh.origin, zzfh.name, zzfh.zzaue, zzj);
            this.zzadj.zzgo().zzjk().zze("Setting user property", this.zzadj.zzgl().zzbu(zzfj.name), zzj);
            zzjq().beginTransaction();
            try {
                zzg(zzh);
                boolean zza3 = zzjq().zza(zzfj);
                zzjq().setTransactionSuccessful();
                if (zza3) {
                    this.zzadj.zzgo().zzjk().zze("User property set", this.zzadj.zzgl().zzbu(zzfj.name), zzfj.value);
                } else {
                    this.zzadj.zzgo().zzjd().zze("Too many unique user properties are set. Ignoring user property", this.zzadj.zzgl().zzbu(zzfj.name), zzfj.value);
                    this.zzadj.zzgm().zza(zzh.packageName, 9, (String) null, (String) null, 0);
                }
            } finally {
                zzjq().endTransaction();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzc(zzfh zzfh, zzh zzh) {
        zzaf();
        zzlr();
        if (TextUtils.isEmpty(zzh.zzafx) && TextUtils.isEmpty(zzh.zzagk)) {
            return;
        }
        if (!zzh.zzagg) {
            zzg(zzh);
            return;
        }
        if (this.zzadj.zzgq().zze(zzh.packageName, zzaf.zzalj)) {
            String str = "_ap";
            if (str.equals(zzfh.name)) {
                zzfj zzi = zzjq().zzi(zzh.packageName, str);
                if (zzi != null) {
                    String str2 = "auto";
                    if (str2.equals(zzfh.origin) && !str2.equals(zzi.origin)) {
                        this.zzadj.zzgo().zzjk().zzbx("Not removing higher priority ad personalization property");
                        return;
                    }
                }
            }
        }
        this.zzadj.zzgo().zzjk().zzg("Removing user property", this.zzadj.zzgl().zzbu(zzfh.name));
        zzjq().beginTransaction();
        try {
            zzg(zzh);
            zzjq().zzh(zzh.packageName, zzfh.name);
            zzjq().setTransactionSuccessful();
            this.zzadj.zzgo().zzjk().zzg("User property removed", this.zzadj.zzgl().zzbu(zzfh.name));
        } finally {
            zzjq().endTransaction();
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzb(zzez zzez) {
        this.zzatn++;
    }

    /* access modifiers changed from: 0000 */
    public final void zzma() {
        this.zzato++;
    }

    /* access modifiers changed from: 0000 */
    public final zzbt zzmb() {
        return this.zzadj;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0332 A[Catch:{ SQLiteException -> 0x014c, all -> 0x041e }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0360 A[Catch:{ SQLiteException -> 0x014c, all -> 0x041e }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02e6 A[Catch:{ SQLiteException -> 0x014c, all -> 0x041e }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02eb A[Catch:{ SQLiteException -> 0x014c, all -> 0x041e }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02f2 A[Catch:{ SQLiteException -> 0x014c, all -> 0x041e }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02f4 A[Catch:{ SQLiteException -> 0x014c, all -> 0x041e }] */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(com.google.android.gms.measurement.internal.zzh r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "_uwa"
            java.lang.String r0 = "app_id=?"
            r21.zzaf()
            r21.zzlr()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r22)
            java.lang.String r7 = r2.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            java.lang.String r7 = r2.zzafx
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x002d
            java.lang.String r7 = r2.zzagk
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x002d
            return
        L_0x002d:
            com.google.android.gms.measurement.internal.zzq r7 = r21.zzjq()
            java.lang.String r8 = r2.packageName
            com.google.android.gms.measurement.internal.zzg r7 = r7.zzbl(r8)
            r8 = 0
            if (r7 == 0) goto L_0x0060
            java.lang.String r10 = r7.getGmpAppId()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0060
            java.lang.String r10 = r2.zzafx
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0060
            r7.zzy(r8)
            com.google.android.gms.measurement.internal.zzq r10 = r21.zzjq()
            r10.zza(r7)
            com.google.android.gms.measurement.internal.zzbn r7 = r21.zzln()
            java.lang.String r10 = r2.packageName
            r7.zzci(r10)
        L_0x0060:
            boolean r7 = r2.zzagg
            if (r7 != 0) goto L_0x0068
            r21.zzg(r22)
            return
        L_0x0068:
            long r10 = r2.zzagx
            int r7 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x0079
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj
            com.google.android.gms.common.util.Clock r7 = r7.zzbx()
            long r10 = r7.currentTimeMillis()
        L_0x0079:
            int r7 = r2.zzagy
            r14 = 1
            if (r7 == 0) goto L_0x009b
            if (r7 == r14) goto L_0x009b
            com.google.android.gms.measurement.internal.zzbt r12 = r1.zzadj
            com.google.android.gms.measurement.internal.zzap r12 = r12.zzgo()
            com.google.android.gms.measurement.internal.zzar r12 = r12.zzjg()
            java.lang.String r13 = r2.packageName
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzap.zzbv(r13)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r8 = "Incorrect app type, assuming installed app. appId, appType"
            r12.zze(r8, r13, r7)
            r7 = 0
        L_0x009b:
            com.google.android.gms.measurement.internal.zzq r8 = r21.zzjq()
            r8.beginTransaction()
            com.google.android.gms.measurement.internal.zzq r8 = r21.zzjq()     // Catch:{ all -> 0x041e }
            java.lang.String r9 = r2.packageName     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzg r8 = r8.zzbl(r9)     // Catch:{ all -> 0x041e }
            if (r8 == 0) goto L_0x015f
            com.google.android.gms.measurement.internal.zzbt r12 = r1.zzadj     // Catch:{ all -> 0x041e }
            r12.zzgm()     // Catch:{ all -> 0x041e }
            java.lang.String r12 = r2.zzafx     // Catch:{ all -> 0x041e }
            java.lang.String r13 = r8.getGmpAppId()     // Catch:{ all -> 0x041e }
            java.lang.String r9 = r2.zzagk     // Catch:{ all -> 0x041e }
            java.lang.String r15 = r8.zzgw()     // Catch:{ all -> 0x041e }
            boolean r9 = com.google.android.gms.measurement.internal.zzfk.zza(r12, r13, r9, r15)     // Catch:{ all -> 0x041e }
            if (r9 == 0) goto L_0x015f
            com.google.android.gms.measurement.internal.zzbt r9 = r1.zzadj     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzap r9 = r9.zzgo()     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzar r9 = r9.zzjg()     // Catch:{ all -> 0x041e }
            java.lang.String r12 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r8.zzal()     // Catch:{ all -> 0x041e }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzap.zzbv(r13)     // Catch:{ all -> 0x041e }
            r9.zzg(r12, r13)     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzq r9 = r21.zzjq()     // Catch:{ all -> 0x041e }
            java.lang.String r8 = r8.zzal()     // Catch:{ all -> 0x041e }
            r9.zzcl()     // Catch:{ all -> 0x041e }
            r9.zzaf()     // Catch:{ all -> 0x041e }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)     // Catch:{ all -> 0x041e }
            android.database.sqlite.SQLiteDatabase r12 = r9.getWritableDatabase()     // Catch:{ SQLiteException -> 0x014c }
            java.lang.String[] r13 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x014c }
            r15 = 0
            r13[r15] = r8     // Catch:{ SQLiteException -> 0x014c }
            java.lang.String r14 = "events"
            int r14 = r12.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x014c }
            int r14 = r14 + r15
            java.lang.String r15 = "user_attributes"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x014c }
            int r14 = r14 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x014c }
            int r14 = r14 + r15
            java.lang.String r15 = "apps"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x014c }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x014c }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x014c }
            int r14 = r14 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x014c }
            int r14 = r14 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x014c }
            int r14 = r14 + r15
            java.lang.String r15 = "audience_filter_values"
            int r0 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x014c }
            int r14 = r14 + r0
            if (r14 <= 0) goto L_0x014b
            com.google.android.gms.measurement.internal.zzap r0 = r9.zzgo()     // Catch:{ SQLiteException -> 0x014c }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjl()     // Catch:{ SQLiteException -> 0x014c }
            java.lang.String r12 = "Deleted application data. app, records"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x014c }
            r0.zze(r12, r8, r13)     // Catch:{ SQLiteException -> 0x014c }
        L_0x014b:
            goto L_0x015e
        L_0x014c:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzap r9 = r9.zzgo()     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzar r9 = r9.zzjd()     // Catch:{ all -> 0x041e }
            java.lang.String r12 = "Error deleting application data. appId, error"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzap.zzbv(r8)     // Catch:{ all -> 0x041e }
            r9.zze(r12, r8, r0)     // Catch:{ all -> 0x041e }
        L_0x015e:
            r8 = 0
        L_0x015f:
            if (r8 == 0) goto L_0x01d4
            long r12 = r8.zzha()     // Catch:{ all -> 0x041e }
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            java.lang.String r0 = "_pv"
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 == 0) goto L_0x019e
            long r12 = r8.zzha()     // Catch:{ all -> 0x041e }
            long r14 = r2.zzagd     // Catch:{ all -> 0x041e }
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 == 0) goto L_0x019b
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x041e }
            r9.<init>()     // Catch:{ all -> 0x041e }
            java.lang.String r8 = r8.zzak()     // Catch:{ all -> 0x041e }
            r9.putString(r0, r8)     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzad r0 = new com.google.android.gms.measurement.internal.zzad     // Catch:{ all -> 0x041e }
            java.lang.String r13 = "_au"
            com.google.android.gms.measurement.internal.zzaa r14 = new com.google.android.gms.measurement.internal.zzaa     // Catch:{ all -> 0x041e }
            r14.<init>(r9)     // Catch:{ all -> 0x041e }
            java.lang.String r15 = "auto"
            r12 = r0
            r9 = 1
            r8 = 0
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x041e }
            r1.zzc(r0, r2)     // Catch:{ all -> 0x041e }
            goto L_0x01d5
        L_0x019b:
            r8 = 0
            r9 = 1
            goto L_0x01d5
        L_0x019e:
            r9 = 1
            r15 = 0
            java.lang.String r12 = r8.zzak()     // Catch:{ all -> 0x041e }
            if (r12 == 0) goto L_0x01d5
            java.lang.String r12 = r8.zzak()     // Catch:{ all -> 0x041e }
            java.lang.String r13 = r2.zzts     // Catch:{ all -> 0x041e }
            boolean r12 = r12.equals(r13)     // Catch:{ all -> 0x041e }
            if (r12 != 0) goto L_0x01d5
            android.os.Bundle r12 = new android.os.Bundle     // Catch:{ all -> 0x041e }
            r12.<init>()     // Catch:{ all -> 0x041e }
            java.lang.String r8 = r8.zzak()     // Catch:{ all -> 0x041e }
            r12.putString(r0, r8)     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzad r0 = new com.google.android.gms.measurement.internal.zzad     // Catch:{ all -> 0x041e }
            java.lang.String r13 = "_au"
            com.google.android.gms.measurement.internal.zzaa r14 = new com.google.android.gms.measurement.internal.zzaa     // Catch:{ all -> 0x041e }
            r14.<init>(r12)     // Catch:{ all -> 0x041e }
            java.lang.String r8 = "auto"
            r12 = r0
            r15 = r8
            r16 = r10
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x041e }
            r1.zzc(r0, r2)     // Catch:{ all -> 0x041e }
            goto L_0x01d5
        L_0x01d4:
            r9 = 1
        L_0x01d5:
            r21.zzg(r22)     // Catch:{ all -> 0x041e }
            if (r7 != 0) goto L_0x01e9
            com.google.android.gms.measurement.internal.zzq r0 = r21.zzjq()     // Catch:{ all -> 0x041e }
            java.lang.String r8 = r2.packageName     // Catch:{ all -> 0x041e }
            java.lang.String r12 = "_f"
            com.google.android.gms.measurement.internal.zzz r0 = r0.zzg(r8, r12)     // Catch:{ all -> 0x041e }
            goto L_0x01fa
        L_0x01e9:
            if (r7 != r9) goto L_0x01f9
            com.google.android.gms.measurement.internal.zzq r0 = r21.zzjq()     // Catch:{ all -> 0x041e }
            java.lang.String r8 = r2.packageName     // Catch:{ all -> 0x041e }
            java.lang.String r12 = "_v"
            com.google.android.gms.measurement.internal.zzz r0 = r0.zzg(r8, r12)     // Catch:{ all -> 0x041e }
            goto L_0x01fa
        L_0x01f9:
            r0 = 0
        L_0x01fa:
            if (r0 != 0) goto L_0x03ed
            r12 = 3600000(0x36ee80, double:1.7786363E-317)
            long r14 = r10 / r12
            r18 = r10
            r9 = 1
            long r14 = r14 + r9
            long r14 = r14 * r12
            java.lang.String r0 = "_dac"
            java.lang.String r11 = "_r"
            java.lang.String r13 = "_c"
            if (r7 != 0) goto L_0x0378
            com.google.android.gms.measurement.internal.zzfh r7 = new com.google.android.gms.measurement.internal.zzfh     // Catch:{ all -> 0x041e }
            java.lang.String r16 = "_fot"
            java.lang.Long r17 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x041e }
            java.lang.String r20 = "auto"
            r12 = r7
            r14 = r13
            r13 = r16
            r8 = r14
            r14 = r18
            r16 = r17
            r17 = r20
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x041e }
            r1.zzb(r7, r2)     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzn r7 = r7.zzgq()     // Catch:{ all -> 0x041e }
            java.lang.String r12 = r2.zzafx     // Catch:{ all -> 0x041e }
            boolean r7 = r7.zzbg(r12)     // Catch:{ all -> 0x041e }
            if (r7 == 0) goto L_0x0249
            r21.zzaf()     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzbt r7 = r1.zzadj     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzbg r7 = r7.zzkg()     // Catch:{ all -> 0x041e }
            java.lang.String r12 = r2.packageName     // Catch:{ all -> 0x041e }
            r7.zzcd(r12)     // Catch:{ all -> 0x041e }
        L_0x0249:
            r21.zzaf()     // Catch:{ all -> 0x041e }
            r21.zzlr()     // Catch:{ all -> 0x041e }
            android.os.Bundle r7 = new android.os.Bundle     // Catch:{ all -> 0x041e }
            r7.<init>()     // Catch:{ all -> 0x041e }
            r7.putLong(r8, r9)     // Catch:{ all -> 0x041e }
            r7.putLong(r11, r9)     // Catch:{ all -> 0x041e }
            r11 = 0
            r7.putLong(r6, r11)     // Catch:{ all -> 0x041e }
            r7.putLong(r5, r11)     // Catch:{ all -> 0x041e }
            r7.putLong(r4, r11)     // Catch:{ all -> 0x041e }
            r7.putLong(r3, r11)     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzbt r8 = r1.zzadj     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzn r8 = r8.zzgq()     // Catch:{ all -> 0x041e }
            java.lang.String r11 = r2.packageName     // Catch:{ all -> 0x041e }
            boolean r8 = r8.zzbd(r11)     // Catch:{ all -> 0x041e }
            if (r8 == 0) goto L_0x027f
            boolean r8 = r2.zzagz     // Catch:{ all -> 0x041e }
            if (r8 == 0) goto L_0x027f
            r7.putLong(r0, r9)     // Catch:{ all -> 0x041e }
        L_0x027f:
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj     // Catch:{ all -> 0x041e }
            android.content.Context r0 = r0.getContext()     // Catch:{ all -> 0x041e }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x041e }
            if (r0 != 0) goto L_0x02a4
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzap r0 = r0.zzgo()     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjd()     // Catch:{ all -> 0x041e }
            java.lang.String r3 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r4 = r2.packageName     // Catch:{ all -> 0x041e }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzap.zzbv(r4)     // Catch:{ all -> 0x041e }
            r0.zzg(r3, r4)     // Catch:{ all -> 0x041e }
            goto L_0x0344
        L_0x02a4:
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj     // Catch:{ NameNotFoundException -> 0x02ba }
            android.content.Context r0 = r0.getContext()     // Catch:{ NameNotFoundException -> 0x02ba }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x02ba }
            java.lang.String r8 = r2.packageName     // Catch:{ NameNotFoundException -> 0x02ba }
            r11 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r8, r11)     // Catch:{ NameNotFoundException -> 0x02b8 }
            goto L_0x02d3
        L_0x02b8:
            r0 = move-exception
            goto L_0x02bc
        L_0x02ba:
            r0 = move-exception
            r11 = 0
        L_0x02bc:
            com.google.android.gms.measurement.internal.zzbt r8 = r1.zzadj     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzap r8 = r8.zzgo()     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzar r8 = r8.zzjd()     // Catch:{ all -> 0x041e }
            java.lang.String r12 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r13 = r2.packageName     // Catch:{ all -> 0x041e }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzap.zzbv(r13)     // Catch:{ all -> 0x041e }
            r8.zze(r12, r13, r0)     // Catch:{ all -> 0x041e }
            r0 = 0
        L_0x02d3:
            if (r0 == 0) goto L_0x0305
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x041e }
            r14 = 0
            int r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0305
            long r12 = r0.firstInstallTime     // Catch:{ all -> 0x041e }
            long r14 = r0.lastUpdateTime     // Catch:{ all -> 0x041e }
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x02eb
            r7.putLong(r6, r9)     // Catch:{ all -> 0x041e }
            r0 = 0
            goto L_0x02ec
        L_0x02eb:
            r0 = 1
        L_0x02ec:
            com.google.android.gms.measurement.internal.zzfh r6 = new com.google.android.gms.measurement.internal.zzfh     // Catch:{ all -> 0x041e }
            java.lang.String r13 = "_fi"
            if (r0 == 0) goto L_0x02f4
            r14 = r9
            goto L_0x02f6
        L_0x02f4:
            r14 = 0
        L_0x02f6:
            java.lang.Long r16 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x041e }
            java.lang.String r17 = "auto"
            r12 = r6
            r14 = r18
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x041e }
            r1.zzb(r6, r2)     // Catch:{ all -> 0x041e }
        L_0x0305:
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj     // Catch:{ NameNotFoundException -> 0x0318 }
            android.content.Context r0 = r0.getContext()     // Catch:{ NameNotFoundException -> 0x0318 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0318 }
            java.lang.String r6 = r2.packageName     // Catch:{ NameNotFoundException -> 0x0318 }
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r6, r11)     // Catch:{ NameNotFoundException -> 0x0318 }
            goto L_0x0330
        L_0x0318:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzbt r6 = r1.zzadj     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzap r6 = r6.zzgo()     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzar r6 = r6.zzjd()     // Catch:{ all -> 0x041e }
            java.lang.String r8 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r11 = r2.packageName     // Catch:{ all -> 0x041e }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzap.zzbv(r11)     // Catch:{ all -> 0x041e }
            r6.zze(r8, r11, r0)     // Catch:{ all -> 0x041e }
            r0 = 0
        L_0x0330:
            if (r0 == 0) goto L_0x0344
            int r6 = r0.flags     // Catch:{ all -> 0x041e }
            r8 = 1
            r6 = r6 & r8
            if (r6 == 0) goto L_0x033b
            r7.putLong(r4, r9)     // Catch:{ all -> 0x041e }
        L_0x033b:
            int r0 = r0.flags     // Catch:{ all -> 0x041e }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0344
            r7.putLong(r3, r9)     // Catch:{ all -> 0x041e }
        L_0x0344:
            com.google.android.gms.measurement.internal.zzq r0 = r21.zzjq()     // Catch:{ all -> 0x041e }
            java.lang.String r3 = r2.packageName     // Catch:{ all -> 0x041e }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x041e }
            r0.zzaf()     // Catch:{ all -> 0x041e }
            r0.zzcl()     // Catch:{ all -> 0x041e }
            java.lang.String r4 = "first_open_count"
            long r3 = r0.zzn(r3, r4)     // Catch:{ all -> 0x041e }
            r11 = 0
            int r0 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x0363
            r7.putLong(r5, r3)     // Catch:{ all -> 0x041e }
        L_0x0363:
            com.google.android.gms.measurement.internal.zzad r0 = new com.google.android.gms.measurement.internal.zzad     // Catch:{ all -> 0x041e }
            java.lang.String r13 = "_f"
            com.google.android.gms.measurement.internal.zzaa r14 = new com.google.android.gms.measurement.internal.zzaa     // Catch:{ all -> 0x041e }
            r14.<init>(r7)     // Catch:{ all -> 0x041e }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r18
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x041e }
            r1.zzc(r0, r2)     // Catch:{ all -> 0x041e }
            goto L_0x03cc
        L_0x0378:
            r8 = r13
            r3 = 1
            if (r7 != r3) goto L_0x03cc
            com.google.android.gms.measurement.internal.zzfh r3 = new com.google.android.gms.measurement.internal.zzfh     // Catch:{ all -> 0x041e }
            java.lang.String r13 = "_fvt"
            java.lang.Long r16 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x041e }
            java.lang.String r17 = "auto"
            r12 = r3
            r14 = r18
            r12.<init>(r13, r14, r16, r17)     // Catch:{ all -> 0x041e }
            r1.zzb(r3, r2)     // Catch:{ all -> 0x041e }
            r21.zzaf()     // Catch:{ all -> 0x041e }
            r21.zzlr()     // Catch:{ all -> 0x041e }
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x041e }
            r3.<init>()     // Catch:{ all -> 0x041e }
            r3.putLong(r8, r9)     // Catch:{ all -> 0x041e }
            r3.putLong(r11, r9)     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzbt r4 = r1.zzadj     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzn r4 = r4.zzgq()     // Catch:{ all -> 0x041e }
            java.lang.String r5 = r2.packageName     // Catch:{ all -> 0x041e }
            boolean r4 = r4.zzbd(r5)     // Catch:{ all -> 0x041e }
            if (r4 == 0) goto L_0x03b7
            boolean r4 = r2.zzagz     // Catch:{ all -> 0x041e }
            if (r4 == 0) goto L_0x03b7
            r3.putLong(r0, r9)     // Catch:{ all -> 0x041e }
        L_0x03b7:
            com.google.android.gms.measurement.internal.zzad r0 = new com.google.android.gms.measurement.internal.zzad     // Catch:{ all -> 0x041e }
            java.lang.String r13 = "_v"
            com.google.android.gms.measurement.internal.zzaa r14 = new com.google.android.gms.measurement.internal.zzaa     // Catch:{ all -> 0x041e }
            r14.<init>(r3)     // Catch:{ all -> 0x041e }
            java.lang.String r15 = "auto"
            r12 = r0
            r16 = r18
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x041e }
            r1.zzc(r0, r2)     // Catch:{ all -> 0x041e }
            goto L_0x03cd
        L_0x03cc:
        L_0x03cd:
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x041e }
            r0.<init>()     // Catch:{ all -> 0x041e }
            java.lang.String r3 = "_et"
            r0.putLong(r3, r9)     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzad r3 = new com.google.android.gms.measurement.internal.zzad     // Catch:{ all -> 0x041e }
            java.lang.String r13 = "_e"
            com.google.android.gms.measurement.internal.zzaa r14 = new com.google.android.gms.measurement.internal.zzaa     // Catch:{ all -> 0x041e }
            r14.<init>(r0)     // Catch:{ all -> 0x041e }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r18
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x041e }
            r1.zzc(r3, r2)     // Catch:{ all -> 0x041e }
            goto L_0x040e
        L_0x03ed:
            r18 = r10
            boolean r0 = r2.zzagw     // Catch:{ all -> 0x041e }
            if (r0 == 0) goto L_0x040e
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x041e }
            r0.<init>()     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzad r3 = new com.google.android.gms.measurement.internal.zzad     // Catch:{ all -> 0x041e }
            java.lang.String r13 = "_cd"
            com.google.android.gms.measurement.internal.zzaa r14 = new com.google.android.gms.measurement.internal.zzaa     // Catch:{ all -> 0x041e }
            r14.<init>(r0)     // Catch:{ all -> 0x041e }
            java.lang.String r15 = "auto"
            r12 = r3
            r16 = r18
            r12.<init>(r13, r14, r15, r16)     // Catch:{ all -> 0x041e }
            r1.zzc(r3, r2)     // Catch:{ all -> 0x041e }
            goto L_0x040f
        L_0x040e:
        L_0x040f:
            com.google.android.gms.measurement.internal.zzq r0 = r21.zzjq()     // Catch:{ all -> 0x041e }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x041e }
            com.google.android.gms.measurement.internal.zzq r0 = r21.zzjq()
            r0.endTransaction()
            return
        L_0x041e:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzq r2 = r21.zzjq()
            r2.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfa.zzf(com.google.android.gms.measurement.internal.zzh):void");
    }

    @WorkerThread
    private final zzh zzco(String str) {
        String str2 = str;
        zzg zzbl = zzjq().zzbl(str2);
        if (zzbl == null || TextUtils.isEmpty(zzbl.zzak())) {
            this.zzadj.zzgo().zzjk().zzg("No app data available; dropping", str2);
            return null;
        }
        Boolean zzc = zzc(zzbl);
        if (zzc == null || zzc.booleanValue()) {
            zzg zzg = zzbl;
            zzh zzh = new zzh(str, zzbl.getGmpAppId(), zzbl.zzak(), zzbl.zzha(), zzbl.zzhb(), zzbl.zzhc(), zzbl.zzhd(), (String) null, zzbl.isMeasurementEnabled(), false, zzbl.getFirebaseInstanceId(), zzg.zzhq(), 0, 0, zzg.zzhr(), zzg.zzhs(), false, zzg.zzgw());
            return zzh;
        }
        this.zzadj.zzgo().zzjd().zzg("App version does not match; dropping. appId", zzap.zzbv(str));
        return null;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zze(zzl zzl) {
        zzh zzco = zzco(zzl.packageName);
        if (zzco != null) {
            zzb(zzl, zzco);
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzb(zzl zzl, zzh zzh) {
        Preconditions.checkNotNull(zzl);
        Preconditions.checkNotEmpty(zzl.packageName);
        Preconditions.checkNotNull(zzl.origin);
        Preconditions.checkNotNull(zzl.zzahb);
        Preconditions.checkNotEmpty(zzl.zzahb.name);
        zzaf();
        zzlr();
        if (TextUtils.isEmpty(zzh.zzafx) && TextUtils.isEmpty(zzh.zzagk)) {
            return;
        }
        if (!zzh.zzagg) {
            zzg(zzh);
            return;
        }
        zzl zzl2 = new zzl(zzl);
        boolean z = false;
        zzl2.active = false;
        zzjq().beginTransaction();
        try {
            zzl zzj = zzjq().zzj(zzl2.packageName, zzl2.zzahb.name);
            if (zzj != null && !zzj.origin.equals(zzl2.origin)) {
                this.zzadj.zzgo().zzjg().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzadj.zzgl().zzbu(zzl2.zzahb.name), zzl2.origin, zzj.origin);
            }
            if (zzj != null && zzj.active) {
                zzl2.origin = zzj.origin;
                zzl2.creationTimestamp = zzj.creationTimestamp;
                zzl2.triggerTimeout = zzj.triggerTimeout;
                zzl2.triggerEventName = zzj.triggerEventName;
                zzl2.zzahd = zzj.zzahd;
                zzl2.active = zzj.active;
                zzfh zzfh = new zzfh(zzl2.zzahb.name, zzj.zzahb.zzaue, zzl2.zzahb.getValue(), zzj.zzahb.origin);
                zzl2.zzahb = zzfh;
            } else if (TextUtils.isEmpty(zzl2.triggerEventName)) {
                zzfh zzfh2 = new zzfh(zzl2.zzahb.name, zzl2.creationTimestamp, zzl2.zzahb.getValue(), zzl2.zzahb.origin);
                zzl2.zzahb = zzfh2;
                zzl2.active = true;
                z = true;
            }
            if (zzl2.active) {
                zzfh zzfh3 = zzl2.zzahb;
                zzfj zzfj = new zzfj(zzl2.packageName, zzl2.origin, zzfh3.name, zzfh3.zzaue, zzfh3.getValue());
                if (zzjq().zza(zzfj)) {
                    this.zzadj.zzgo().zzjk().zzd("User property updated immediately", zzl2.packageName, this.zzadj.zzgl().zzbu(zzfj.name), zzfj.value);
                } else {
                    this.zzadj.zzgo().zzjd().zzd("(2)Too many active user properties, ignoring", zzap.zzbv(zzl2.packageName), this.zzadj.zzgl().zzbu(zzfj.name), zzfj.value);
                }
                if (z && zzl2.zzahd != null) {
                    zzd(new zzad(zzl2.zzahd, zzl2.creationTimestamp), zzh);
                }
            }
            if (zzjq().zza(zzl2)) {
                this.zzadj.zzgo().zzjk().zzd("Conditional property added", zzl2.packageName, this.zzadj.zzgl().zzbu(zzl2.zzahb.name), zzl2.zzahb.getValue());
            } else {
                this.zzadj.zzgo().zzjd().zzd("Too many conditional properties, ignoring", zzap.zzbv(zzl2.packageName), this.zzadj.zzgl().zzbu(zzl2.zzahb.name), zzl2.zzahb.getValue());
            }
            zzjq().setTransactionSuccessful();
        } finally {
            zzjq().endTransaction();
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzf(zzl zzl) {
        zzh zzco = zzco(zzl.packageName);
        if (zzco != null) {
            zzc(zzl, zzco);
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final void zzc(zzl zzl, zzh zzh) {
        Bundle bundle;
        Preconditions.checkNotNull(zzl);
        Preconditions.checkNotEmpty(zzl.packageName);
        Preconditions.checkNotNull(zzl.zzahb);
        Preconditions.checkNotEmpty(zzl.zzahb.name);
        zzaf();
        zzlr();
        if (TextUtils.isEmpty(zzh.zzafx) && TextUtils.isEmpty(zzh.zzagk)) {
            return;
        }
        if (!zzh.zzagg) {
            zzg(zzh);
            return;
        }
        zzjq().beginTransaction();
        try {
            zzg(zzh);
            zzl zzj = zzjq().zzj(zzl.packageName, zzl.zzahb.name);
            if (zzj != null) {
                this.zzadj.zzgo().zzjk().zze("Removing conditional user property", zzl.packageName, this.zzadj.zzgl().zzbu(zzl.zzahb.name));
                zzjq().zzk(zzl.packageName, zzl.zzahb.name);
                if (zzj.active) {
                    zzjq().zzh(zzl.packageName, zzl.zzahb.name);
                }
                if (zzl.zzahe != null) {
                    if (zzl.zzahe.zzaid != null) {
                        bundle = zzl.zzahe.zzaid.zziv();
                    } else {
                        bundle = null;
                    }
                    zzd(this.zzadj.zzgm().zza(zzl.packageName, zzl.zzahe.name, bundle, zzj.origin, zzl.zzahe.zzaip, true, false), zzh);
                }
            } else {
                this.zzadj.zzgo().zzjg().zze("Conditional user property doesn't exist", zzap.zzbv(zzl.packageName), this.zzadj.zzgl().zzbu(zzl.zzahb.name));
            }
            zzjq().setTransactionSuccessful();
        } finally {
            zzjq().endTransaction();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final zzg zzg(zzh zzh) {
        boolean z;
        zzaf();
        zzlr();
        Preconditions.checkNotNull(zzh);
        Preconditions.checkNotEmpty(zzh.packageName);
        zzg zzbl = zzjq().zzbl(zzh.packageName);
        String zzbz = this.zzadj.zzgp().zzbz(zzh.packageName);
        if (zzbl == null) {
            zzbl = new zzg(this.zzadj, zzh.packageName);
            zzbl.zzam(this.zzadj.zzgm().zzmf());
            zzbl.zzap(zzbz);
            z = true;
        } else if (!zzbz.equals(zzbl.zzgx())) {
            zzbl.zzap(zzbz);
            zzbl.zzam(this.zzadj.zzgm().zzmf());
            z = true;
        } else {
            z = false;
        }
        if (!TextUtils.equals(zzh.zzafx, zzbl.getGmpAppId())) {
            zzbl.zzan(zzh.zzafx);
            z = true;
        }
        if (!TextUtils.equals(zzh.zzagk, zzbl.zzgw())) {
            zzbl.zzao(zzh.zzagk);
            z = true;
        }
        if (!TextUtils.isEmpty(zzh.zzafz) && !zzh.zzafz.equals(zzbl.getFirebaseInstanceId())) {
            zzbl.zzaq(zzh.zzafz);
            z = true;
        }
        if (!(zzh.zzadt == 0 || zzh.zzadt == zzbl.zzhc())) {
            zzbl.zzv(zzh.zzadt);
            z = true;
        }
        if (!TextUtils.isEmpty(zzh.zzts) && !zzh.zzts.equals(zzbl.zzak())) {
            zzbl.setAppVersion(zzh.zzts);
            z = true;
        }
        if (zzh.zzagd != zzbl.zzha()) {
            zzbl.zzu(zzh.zzagd);
            z = true;
        }
        if (zzh.zzage != null && !zzh.zzage.equals(zzbl.zzhb())) {
            zzbl.zzar(zzh.zzage);
            z = true;
        }
        if (zzh.zzagf != zzbl.zzhd()) {
            zzbl.zzw(zzh.zzagf);
            z = true;
        }
        if (zzh.zzagg != zzbl.isMeasurementEnabled()) {
            zzbl.setMeasurementEnabled(zzh.zzagg);
            z = true;
        }
        if (!TextUtils.isEmpty(zzh.zzagv) && !zzh.zzagv.equals(zzbl.zzho())) {
            zzbl.zzas(zzh.zzagv);
            z = true;
        }
        if (zzh.zzagh != zzbl.zzhq()) {
            zzbl.zzag(zzh.zzagh);
            z = true;
        }
        if (zzh.zzagi != zzbl.zzhr()) {
            zzbl.zze(zzh.zzagi);
            z = true;
        }
        if (zzh.zzagj != zzbl.zzhs()) {
            zzbl.zzf(zzh.zzagj);
            z = true;
        }
        if (z) {
            zzjq().zza(zzbl);
        }
        return zzbl;
    }

    /* JADX WARNING: type inference failed for: r27v1 */
    /* JADX WARNING: type inference failed for: r27v2 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zza(@android.support.annotation.NonNull com.google.android.gms.measurement.internal.zzad r31, @android.support.annotation.Size(min = 1) java.lang.String r32) {
        /*
            r30 = this;
            r1 = r30
            r0 = r31
            r15 = r32
            java.lang.String r2 = "_et"
            java.lang.String r3 = "_iap"
            r30.zzlr()
            r30.zzaf()
            com.google.android.gms.measurement.internal.zzbt r4 = r1.zzadj
            r4.zzga()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r31)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r32)
            com.google.android.gms.internal.measurement.zzgh r14 = new com.google.android.gms.internal.measurement.zzgh
            r14.<init>()
            com.google.android.gms.measurement.internal.zzq r4 = r30.zzjq()
            r4.beginTransaction()
            com.google.android.gms.measurement.internal.zzq r4 = r30.zzjq()     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzg r13 = r4.zzbl(r15)     // Catch:{ all -> 0x052b }
            r11 = 0
            if (r13 != 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzap r0 = r0.zzgo()     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjk()     // Catch:{ all -> 0x052b }
            java.lang.String r2 = "Log and bundle not available. package_name"
            r0.zzg(r2, r15)     // Catch:{ all -> 0x052b }
            byte[] r0 = new byte[r11]     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzq r2 = r30.zzjq()
            r2.endTransaction()
            return r0
        L_0x004c:
            boolean r4 = r13.isMeasurementEnabled()     // Catch:{ all -> 0x052b }
            if (r4 != 0) goto L_0x006c
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzap r0 = r0.zzgo()     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjk()     // Catch:{ all -> 0x052b }
            java.lang.String r2 = "Log and bundle disabled. package_name"
            r0.zzg(r2, r15)     // Catch:{ all -> 0x052b }
            byte[] r0 = new byte[r11]     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzq r2 = r30.zzjq()
            r2.endTransaction()
            return r0
        L_0x006c:
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x052b }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x052b }
            if (r4 != 0) goto L_0x007e
            java.lang.String r4 = "ecommerce_purchase"
            java.lang.String r5 = r0.name     // Catch:{ all -> 0x052b }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x052b }
            if (r4 == 0) goto L_0x0098
        L_0x007e:
            boolean r4 = r1.zza(r15, r0)     // Catch:{ all -> 0x052b }
            if (r4 != 0) goto L_0x0098
            com.google.android.gms.measurement.internal.zzbt r4 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzap r4 = r4.zzgo()     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzar r4 = r4.zzjg()     // Catch:{ all -> 0x052b }
            java.lang.String r5 = "Failed to handle purchase event at single event bundle creation. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzap.zzbv(r32)     // Catch:{ all -> 0x052b }
            r4.zzg(r5, r6)     // Catch:{ all -> 0x052b }
        L_0x0098:
            com.google.android.gms.measurement.internal.zzbt r4 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzn r4 = r4.zzgq()     // Catch:{ all -> 0x052b }
            boolean r4 = r4.zzax(r15)     // Catch:{ all -> 0x052b }
            r17 = 0
            java.lang.Long r5 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x052b }
            if (r4 == 0) goto L_0x00fa
            java.lang.String r6 = "_e"
            java.lang.String r7 = r0.name     // Catch:{ all -> 0x052b }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x052b }
            if (r6 == 0) goto L_0x00fa
            com.google.android.gms.measurement.internal.zzaa r6 = r0.zzaid     // Catch:{ all -> 0x052b }
            if (r6 == 0) goto L_0x00e6
            com.google.android.gms.measurement.internal.zzaa r6 = r0.zzaid     // Catch:{ all -> 0x052b }
            int r6 = r6.size()     // Catch:{ all -> 0x052b }
            if (r6 != 0) goto L_0x00c2
            goto L_0x00e6
        L_0x00c2:
            com.google.android.gms.measurement.internal.zzaa r6 = r0.zzaid     // Catch:{ all -> 0x052b }
            java.lang.Long r6 = r6.getLong(r2)     // Catch:{ all -> 0x052b }
            if (r6 != 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzap r2 = r2.zzgo()     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjg()     // Catch:{ all -> 0x052b }
            java.lang.String r6 = "The engagement event does not include duration. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzap.zzbv(r32)     // Catch:{ all -> 0x052b }
            r2.zzg(r6, r7)     // Catch:{ all -> 0x052b }
            goto L_0x00fa
        L_0x00df:
            com.google.android.gms.measurement.internal.zzaa r5 = r0.zzaid     // Catch:{ all -> 0x052b }
            java.lang.Long r5 = r5.getLong(r2)     // Catch:{ all -> 0x052b }
            goto L_0x00fa
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzap r2 = r2.zzgo()     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjg()     // Catch:{ all -> 0x052b }
            java.lang.String r6 = "The engagement event does not contain any parameters. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzap.zzbv(r32)     // Catch:{ all -> 0x052b }
            r2.zzg(r6, r7)     // Catch:{ all -> 0x052b }
        L_0x00fa:
            com.google.android.gms.internal.measurement.zzgi r12 = new com.google.android.gms.internal.measurement.zzgi     // Catch:{ all -> 0x052b }
            r12.<init>()     // Catch:{ all -> 0x052b }
            r9 = 1
            com.google.android.gms.internal.measurement.zzgi[] r2 = new com.google.android.gms.internal.measurement.zzgi[r9]     // Catch:{ all -> 0x052b }
            r2[r11] = r12     // Catch:{ all -> 0x052b }
            r14.zzawy = r2     // Catch:{ all -> 0x052b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x052b }
            r12.zzaxa = r2     // Catch:{ all -> 0x052b }
            java.lang.String r2 = "android"
            r12.zzaxi = r2     // Catch:{ all -> 0x052b }
            java.lang.String r2 = r13.zzal()     // Catch:{ all -> 0x052b }
            r12.zztt = r2     // Catch:{ all -> 0x052b }
            java.lang.String r2 = r13.zzhb()     // Catch:{ all -> 0x052b }
            r12.zzage = r2     // Catch:{ all -> 0x052b }
            java.lang.String r2 = r13.zzak()     // Catch:{ all -> 0x052b }
            r12.zzts = r2     // Catch:{ all -> 0x052b }
            long r6 = r13.zzha()     // Catch:{ all -> 0x052b }
            r19 = -2147483648(0xffffffff80000000, double:NaN)
            r10 = 0
            int r2 = (r6 > r19 ? 1 : (r6 == r19 ? 0 : -1))
            if (r2 != 0) goto L_0x0130
            r2 = r10
            goto L_0x0135
        L_0x0130:
            int r2 = (int) r6     // Catch:{ all -> 0x052b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x052b }
        L_0x0135:
            r12.zzaxu = r2     // Catch:{ all -> 0x052b }
            long r6 = r13.zzhc()     // Catch:{ all -> 0x052b }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x052b }
            r12.zzaxm = r2     // Catch:{ all -> 0x052b }
            java.lang.String r2 = r13.getGmpAppId()     // Catch:{ all -> 0x052b }
            r12.zzafx = r2     // Catch:{ all -> 0x052b }
            java.lang.String r2 = r12.zzafx     // Catch:{ all -> 0x052b }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x052b }
            if (r2 == 0) goto L_0x0155
            java.lang.String r2 = r13.zzgw()     // Catch:{ all -> 0x052b }
            r12.zzawj = r2     // Catch:{ all -> 0x052b }
        L_0x0155:
            long r6 = r13.zzhd()     // Catch:{ all -> 0x052b }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x052b }
            r12.zzaxq = r2     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x052b }
            boolean r2 = r2.isEnabled()     // Catch:{ all -> 0x052b }
            if (r2 == 0) goto L_0x017d
            boolean r2 = com.google.android.gms.measurement.internal.zzn.zzhz()     // Catch:{ all -> 0x052b }
            if (r2 == 0) goto L_0x017d
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzn r2 = r2.zzgq()     // Catch:{ all -> 0x052b }
            java.lang.String r6 = r12.zztt     // Catch:{ all -> 0x052b }
            boolean r2 = r2.zzav(r6)     // Catch:{ all -> 0x052b }
            if (r2 == 0) goto L_0x017d
            r12.zzaya = r10     // Catch:{ all -> 0x052b }
        L_0x017d:
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzba r2 = r2.zzgp()     // Catch:{ all -> 0x052b }
            java.lang.String r6 = r13.zzal()     // Catch:{ all -> 0x052b }
            android.util.Pair r2 = r2.zzby(r6)     // Catch:{ all -> 0x052b }
            boolean r6 = r13.zzhr()     // Catch:{ all -> 0x052b }
            if (r6 == 0) goto L_0x01aa
            if (r2 == 0) goto L_0x01aa
            java.lang.Object r6 = r2.first     // Catch:{ all -> 0x052b }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x052b }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x052b }
            if (r6 != 0) goto L_0x01aa
            java.lang.Object r6 = r2.first     // Catch:{ all -> 0x052b }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x052b }
            r12.zzaxo = r6     // Catch:{ all -> 0x052b }
            java.lang.Object r2 = r2.second     // Catch:{ all -> 0x052b }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x052b }
            r12.zzaxp = r2     // Catch:{ all -> 0x052b }
        L_0x01aa:
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzgk()     // Catch:{ all -> 0x052b }
            r2.zzcl()     // Catch:{ all -> 0x052b }
            java.lang.String r2 = android.os.Build.MODEL     // Catch:{ all -> 0x052b }
            r12.zzaxk = r2     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzgk()     // Catch:{ all -> 0x052b }
            r2.zzcl()     // Catch:{ all -> 0x052b }
            java.lang.String r2 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x052b }
            r12.zzaxj = r2     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzgk()     // Catch:{ all -> 0x052b }
            long r6 = r2.zzis()     // Catch:{ all -> 0x052b }
            int r2 = (int) r6     // Catch:{ all -> 0x052b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x052b }
            r12.zzaxl = r2     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzx r2 = r2.zzgk()     // Catch:{ all -> 0x052b }
            java.lang.String r2 = r2.zzit()     // Catch:{ all -> 0x052b }
            r12.zzaia = r2     // Catch:{ all -> 0x052b }
            java.lang.String r2 = r13.getAppInstanceId()     // Catch:{ all -> 0x052b }
            r12.zzafw = r2     // Catch:{ all -> 0x052b }
            java.lang.String r2 = r13.getFirebaseInstanceId()     // Catch:{ all -> 0x052b }
            r12.zzafz = r2     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzq r2 = r30.zzjq()     // Catch:{ all -> 0x052b }
            java.lang.String r6 = r13.zzal()     // Catch:{ all -> 0x052b }
            java.util.List r2 = r2.zzbk(r6)     // Catch:{ all -> 0x052b }
            int r6 = r2.size()     // Catch:{ all -> 0x052b }
            com.google.android.gms.internal.measurement.zzgl[] r6 = new com.google.android.gms.internal.measurement.zzgl[r6]     // Catch:{ all -> 0x052b }
            r12.zzaxc = r6     // Catch:{ all -> 0x052b }
            java.lang.String r6 = "_lte"
            if (r4 == 0) goto L_0x026d
            com.google.android.gms.measurement.internal.zzq r7 = r30.zzjq()     // Catch:{ all -> 0x052b }
            java.lang.String r8 = r12.zztt     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzfj r7 = r7.zzi(r8, r6)     // Catch:{ all -> 0x052b }
            if (r7 == 0) goto L_0x0251
            java.lang.Object r8 = r7.value     // Catch:{ all -> 0x052b }
            if (r8 != 0) goto L_0x021c
            goto L_0x0251
        L_0x021c:
            long r19 = r5.longValue()     // Catch:{ all -> 0x052b }
            int r8 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1))
            if (r8 <= 0) goto L_0x026e
            com.google.android.gms.measurement.internal.zzfj r8 = new com.google.android.gms.measurement.internal.zzfj     // Catch:{ all -> 0x052b }
            java.lang.String r10 = r12.zztt     // Catch:{ all -> 0x052b }
            java.lang.String r21 = "auto"
            java.lang.String r22 = "_lte"
            com.google.android.gms.measurement.internal.zzbt r11 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.common.util.Clock r11 = r11.zzbx()     // Catch:{ all -> 0x052b }
            long r23 = r11.currentTimeMillis()     // Catch:{ all -> 0x052b }
            java.lang.Object r7 = r7.value     // Catch:{ all -> 0x052b }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x052b }
            long r19 = r7.longValue()     // Catch:{ all -> 0x052b }
            long r26 = r5.longValue()     // Catch:{ all -> 0x052b }
            long r19 = r19 + r26
            java.lang.Long r25 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x052b }
            r19 = r8
            r20 = r10
            r19.<init>(r20, r21, r22, r23, r25)     // Catch:{ all -> 0x052b }
            r7 = r8
            goto L_0x026e
        L_0x0251:
            com.google.android.gms.measurement.internal.zzfj r7 = new com.google.android.gms.measurement.internal.zzfj     // Catch:{ all -> 0x052b }
            java.lang.String r8 = r12.zztt     // Catch:{ all -> 0x052b }
            java.lang.String r21 = "auto"
            java.lang.String r22 = "_lte"
            com.google.android.gms.measurement.internal.zzbt r10 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.common.util.Clock r10 = r10.zzbx()     // Catch:{ all -> 0x052b }
            long r23 = r10.currentTimeMillis()     // Catch:{ all -> 0x052b }
            r19 = r7
            r20 = r8
            r25 = r5
            r19.<init>(r20, r21, r22, r23, r25)     // Catch:{ all -> 0x052b }
            goto L_0x026e
        L_0x026d:
            r7 = 0
        L_0x026e:
            r8 = 0
            r10 = 0
        L_0x0271:
            int r11 = r2.size()     // Catch:{ all -> 0x052b }
            if (r8 >= r11) goto L_0x02d6
            com.google.android.gms.internal.measurement.zzgl r11 = new com.google.android.gms.internal.measurement.zzgl     // Catch:{ all -> 0x052b }
            r11.<init>()     // Catch:{ all -> 0x052b }
            com.google.android.gms.internal.measurement.zzgl[] r9 = r12.zzaxc     // Catch:{ all -> 0x052b }
            r9[r8] = r11     // Catch:{ all -> 0x052b }
            java.lang.Object r9 = r2.get(r8)     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzfj r9 = (com.google.android.gms.measurement.internal.zzfj) r9     // Catch:{ all -> 0x052b }
            java.lang.String r9 = r9.name     // Catch:{ all -> 0x052b }
            r11.name = r9     // Catch:{ all -> 0x052b }
            java.lang.Object r9 = r2.get(r8)     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzfj r9 = (com.google.android.gms.measurement.internal.zzfj) r9     // Catch:{ all -> 0x052b }
            r21 = r13
            r20 = r14
            long r13 = r9.zzaue     // Catch:{ all -> 0x052b }
            java.lang.Long r9 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x052b }
            r11.zzayl = r9     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzfg r9 = r30.zzjo()     // Catch:{ all -> 0x052b }
            java.lang.Object r13 = r2.get(r8)     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzfj r13 = (com.google.android.gms.measurement.internal.zzfj) r13     // Catch:{ all -> 0x052b }
            java.lang.Object r13 = r13.value     // Catch:{ all -> 0x052b }
            r9.zza(r11, r13)     // Catch:{ all -> 0x052b }
            if (r4 == 0) goto L_0x02ce
            java.lang.String r9 = r11.name     // Catch:{ all -> 0x052b }
            boolean r9 = r6.equals(r9)     // Catch:{ all -> 0x052b }
            if (r9 == 0) goto L_0x02ce
            java.lang.Object r9 = r7.value     // Catch:{ all -> 0x052b }
            java.lang.Long r9 = (java.lang.Long) r9     // Catch:{ all -> 0x052b }
            r11.zzawx = r9     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzbt r9 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.common.util.Clock r9 = r9.zzbx()     // Catch:{ all -> 0x052b }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x052b }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x052b }
            r11.zzayl = r9     // Catch:{ all -> 0x052b }
            r10 = r11
        L_0x02ce:
            int r8 = r8 + 1
            r14 = r20
            r13 = r21
            r9 = 1
            goto L_0x0271
        L_0x02d6:
            r21 = r13
            r20 = r14
            if (r4 == 0) goto L_0x0315
            if (r10 != 0) goto L_0x0315
            com.google.android.gms.internal.measurement.zzgl r2 = new com.google.android.gms.internal.measurement.zzgl     // Catch:{ all -> 0x052b }
            r2.<init>()     // Catch:{ all -> 0x052b }
            r2.name = r6     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzbt r4 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.common.util.Clock r4 = r4.zzbx()     // Catch:{ all -> 0x052b }
            long r8 = r4.currentTimeMillis()     // Catch:{ all -> 0x052b }
            java.lang.Long r4 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x052b }
            r2.zzayl = r4     // Catch:{ all -> 0x052b }
            java.lang.Object r4 = r7.value     // Catch:{ all -> 0x052b }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x052b }
            r2.zzawx = r4     // Catch:{ all -> 0x052b }
            com.google.android.gms.internal.measurement.zzgl[] r4 = r12.zzaxc     // Catch:{ all -> 0x052b }
            com.google.android.gms.internal.measurement.zzgl[] r6 = r12.zzaxc     // Catch:{ all -> 0x052b }
            int r6 = r6.length     // Catch:{ all -> 0x052b }
            r8 = 1
            int r6 = r6 + r8
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r6)     // Catch:{ all -> 0x052b }
            com.google.android.gms.internal.measurement.zzgl[] r4 = (com.google.android.gms.internal.measurement.zzgl[]) r4     // Catch:{ all -> 0x052b }
            r12.zzaxc = r4     // Catch:{ all -> 0x052b }
            com.google.android.gms.internal.measurement.zzgl[] r4 = r12.zzaxc     // Catch:{ all -> 0x052b }
            com.google.android.gms.internal.measurement.zzgl[] r6 = r12.zzaxc     // Catch:{ all -> 0x052b }
            int r6 = r6.length     // Catch:{ all -> 0x052b }
            r9 = 1
            int r6 = r6 - r9
            r4[r6] = r2     // Catch:{ all -> 0x052b }
            goto L_0x0316
        L_0x0315:
            r9 = 1
        L_0x0316:
            long r4 = r5.longValue()     // Catch:{ all -> 0x052b }
            int r2 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r2 <= 0) goto L_0x0325
            com.google.android.gms.measurement.internal.zzq r2 = r30.zzjq()     // Catch:{ all -> 0x052b }
            r2.zza(r7)     // Catch:{ all -> 0x052b }
        L_0x0325:
            com.google.android.gms.measurement.internal.zzaa r2 = r0.zzaid     // Catch:{ all -> 0x052b }
            android.os.Bundle r14 = r2.zziv()     // Catch:{ all -> 0x052b }
            java.lang.String r2 = r0.name     // Catch:{ all -> 0x052b }
            boolean r2 = r3.equals(r2)     // Catch:{ all -> 0x052b }
            java.lang.String r3 = "_r"
            r4 = 1
            if (r2 == 0) goto L_0x034f
            java.lang.String r2 = "_c"
            r14.putLong(r2, r4)     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzap r2 = r2.zzgo()     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjk()     // Catch:{ all -> 0x052b }
            java.lang.String r6 = "Marking in-app purchase as real-time"
            r2.zzbx(r6)     // Catch:{ all -> 0x052b }
            r14.putLong(r3, r4)     // Catch:{ all -> 0x052b }
        L_0x034f:
            java.lang.String r2 = "_o"
            java.lang.String r6 = r0.origin     // Catch:{ all -> 0x052b }
            r14.putString(r2, r6)     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzgm()     // Catch:{ all -> 0x052b }
            java.lang.String r6 = r12.zztt     // Catch:{ all -> 0x052b }
            boolean r2 = r2.zzcw(r6)     // Catch:{ all -> 0x052b }
            if (r2 == 0) goto L_0x0383
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzgm()     // Catch:{ all -> 0x052b }
            java.lang.String r6 = "_dbg"
            java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x052b }
            r2.zza(r14, r6, r7)     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzfk r2 = r2.zzgm()     // Catch:{ all -> 0x052b }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x052b }
            r2.zza(r14, r3, r4)     // Catch:{ all -> 0x052b }
        L_0x0383:
            com.google.android.gms.measurement.internal.zzq r2 = r30.zzjq()     // Catch:{ all -> 0x052b }
            java.lang.String r3 = r0.name     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzz r2 = r2.zzg(r15, r3)     // Catch:{ all -> 0x052b }
            if (r2 != 0) goto L_0x03cd
            com.google.android.gms.measurement.internal.zzz r13 = new com.google.android.gms.measurement.internal.zzz     // Catch:{ all -> 0x052b }
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x052b }
            r5 = 1
            r7 = 0
            long r10 = r0.zzaip     // Catch:{ all -> 0x052b }
            r22 = 0
            r19 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r2 = r13
            r3 = r32
            r27 = 0
            r9 = r10
            r28 = r12
            r11 = r22
            r29 = r13
            r22 = r21
            r13 = r19
            r19 = r20
            r20 = r14
            r14 = r24
            r15 = r25
            r16 = r26
            r2.<init>(r3, r4, r5, r7, r9, r11, r13, r14, r15, r16)     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzq r2 = r30.zzjq()     // Catch:{ all -> 0x052b }
            r3 = r29
            r2.zza(r3)     // Catch:{ all -> 0x052b }
            r9 = r17
            goto L_0x03eb
        L_0x03cd:
            r28 = r12
            r19 = r20
            r22 = r21
            r27 = 0
            r20 = r14
            long r3 = r2.zzaig     // Catch:{ all -> 0x052b }
            long r5 = r0.zzaip     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzz r2 = r2.zzai(r5)     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzz r2 = r2.zziu()     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzq r5 = r30.zzjq()     // Catch:{ all -> 0x052b }
            r5.zza(r2)     // Catch:{ all -> 0x052b }
            r9 = r3
        L_0x03eb:
            com.google.android.gms.measurement.internal.zzy r12 = new com.google.android.gms.measurement.internal.zzy     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzbt r3 = r1.zzadj     // Catch:{ all -> 0x052b }
            java.lang.String r4 = r0.origin     // Catch:{ all -> 0x052b }
            java.lang.String r6 = r0.name     // Catch:{ all -> 0x052b }
            long r7 = r0.zzaip     // Catch:{ all -> 0x052b }
            r2 = r12
            r5 = r32
            r11 = r20
            r2.<init>(r3, r4, r5, r6, r7, r9, r11)     // Catch:{ all -> 0x052b }
            com.google.android.gms.internal.measurement.zzgf r0 = new com.google.android.gms.internal.measurement.zzgf     // Catch:{ all -> 0x052b }
            r0.<init>()     // Catch:{ all -> 0x052b }
            r2 = 1
            com.google.android.gms.internal.measurement.zzgf[] r2 = new com.google.android.gms.internal.measurement.zzgf[r2]     // Catch:{ all -> 0x052b }
            r3 = 0
            r2[r3] = r0     // Catch:{ all -> 0x052b }
            r4 = r28
            r4.zzaxb = r2     // Catch:{ all -> 0x052b }
            long r5 = r12.timestamp     // Catch:{ all -> 0x052b }
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x052b }
            r0.zzawu = r2     // Catch:{ all -> 0x052b }
            java.lang.String r2 = r12.name     // Catch:{ all -> 0x052b }
            r0.name = r2     // Catch:{ all -> 0x052b }
            long r5 = r12.zzaic     // Catch:{ all -> 0x052b }
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x052b }
            r0.zzawv = r2     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzaa r2 = r12.zzaid     // Catch:{ all -> 0x052b }
            int r2 = r2.size()     // Catch:{ all -> 0x052b }
            com.google.android.gms.internal.measurement.zzgg[] r2 = new com.google.android.gms.internal.measurement.zzgg[r2]     // Catch:{ all -> 0x052b }
            r0.zzawt = r2     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzaa r2 = r12.zzaid     // Catch:{ all -> 0x052b }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x052b }
            r5 = 0
        L_0x0432:
            boolean r6 = r2.hasNext()     // Catch:{ all -> 0x052b }
            if (r6 == 0) goto L_0x045a
            java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x052b }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x052b }
            com.google.android.gms.internal.measurement.zzgg r7 = new com.google.android.gms.internal.measurement.zzgg     // Catch:{ all -> 0x052b }
            r7.<init>()     // Catch:{ all -> 0x052b }
            com.google.android.gms.internal.measurement.zzgg[] r8 = r0.zzawt     // Catch:{ all -> 0x052b }
            int r9 = r5 + 1
            r8[r5] = r7     // Catch:{ all -> 0x052b }
            r7.name = r6     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzaa r5 = r12.zzaid     // Catch:{ all -> 0x052b }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzfg r6 = r30.zzjo()     // Catch:{ all -> 0x052b }
            r6.zza(r7, r5)     // Catch:{ all -> 0x052b }
            r5 = r9
            goto L_0x0432
        L_0x045a:
            java.lang.String r2 = r22.zzal()     // Catch:{ all -> 0x052b }
            com.google.android.gms.internal.measurement.zzgl[] r5 = r4.zzaxc     // Catch:{ all -> 0x052b }
            com.google.android.gms.internal.measurement.zzgf[] r6 = r4.zzaxb     // Catch:{ all -> 0x052b }
            com.google.android.gms.internal.measurement.zzgd[] r2 = r1.zza(r2, r5, r6)     // Catch:{ all -> 0x052b }
            r4.zzaxt = r2     // Catch:{ all -> 0x052b }
            java.lang.Long r2 = r0.zzawu     // Catch:{ all -> 0x052b }
            r4.zzaxe = r2     // Catch:{ all -> 0x052b }
            java.lang.Long r0 = r0.zzawu     // Catch:{ all -> 0x052b }
            r4.zzaxf = r0     // Catch:{ all -> 0x052b }
            long r5 = r22.zzgz()     // Catch:{ all -> 0x052b }
            int r0 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x047e
            java.lang.Long r10 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x052b }
            goto L_0x0480
        L_0x047e:
            r10 = r27
        L_0x0480:
            r4.zzaxh = r10     // Catch:{ all -> 0x052b }
            long r7 = r22.zzgy()     // Catch:{ all -> 0x052b }
            int r0 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r0 != 0) goto L_0x048b
            goto L_0x048c
        L_0x048b:
            r5 = r7
        L_0x048c:
            int r0 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r0 == 0) goto L_0x0495
            java.lang.Long r10 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x052b }
            goto L_0x0497
        L_0x0495:
            r10 = r27
        L_0x0497:
            r4.zzaxg = r10     // Catch:{ all -> 0x052b }
            r22.zzhh()     // Catch:{ all -> 0x052b }
            long r5 = r22.zzhe()     // Catch:{ all -> 0x052b }
            int r0 = (int) r5     // Catch:{ all -> 0x052b }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x052b }
            r4.zzaxr = r0     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzn r0 = r0.zzgq()     // Catch:{ all -> 0x052b }
            long r5 = r0.zzhc()     // Catch:{ all -> 0x052b }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x052b }
            r4.zzaxn = r0     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzbt r0 = r1.zzadj     // Catch:{ all -> 0x052b }
            com.google.android.gms.common.util.Clock r0 = r0.zzbx()     // Catch:{ all -> 0x052b }
            long r5 = r0.currentTimeMillis()     // Catch:{ all -> 0x052b }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x052b }
            r4.zzaxd = r0     // Catch:{ all -> 0x052b }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x052b }
            r4.zzaxs = r0     // Catch:{ all -> 0x052b }
            java.lang.Long r0 = r4.zzaxe     // Catch:{ all -> 0x052b }
            long r5 = r0.longValue()     // Catch:{ all -> 0x052b }
            r0 = r22
            r0.zzs(r5)     // Catch:{ all -> 0x052b }
            java.lang.Long r2 = r4.zzaxf     // Catch:{ all -> 0x052b }
            long r4 = r2.longValue()     // Catch:{ all -> 0x052b }
            r0.zzt(r4)     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzq r2 = r30.zzjq()     // Catch:{ all -> 0x052b }
            r2.zza(r0)     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzq r0 = r30.zzjq()     // Catch:{ all -> 0x052b }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x052b }
            com.google.android.gms.measurement.internal.zzq r0 = r30.zzjq()
            r0.endTransaction()
            int r0 = r19.zzvu()     // Catch:{ IOException -> 0x0515 }
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0515 }
            int r2 = r0.length     // Catch:{ IOException -> 0x0515 }
            com.google.android.gms.internal.measurement.zzyy r2 = com.google.android.gms.internal.measurement.zzyy.zzk(r0, r3, r2)     // Catch:{ IOException -> 0x0515 }
            r3 = r19
            r3.zza(r2)     // Catch:{ IOException -> 0x0515 }
            r2.zzyt()     // Catch:{ IOException -> 0x0515 }
            com.google.android.gms.measurement.internal.zzfg r2 = r30.zzjo()     // Catch:{ IOException -> 0x0515 }
            byte[] r0 = r2.zzb(r0)     // Catch:{ IOException -> 0x0515 }
            return r0
        L_0x0515:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzbt r2 = r1.zzadj
            com.google.android.gms.measurement.internal.zzap r2 = r2.zzgo()
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjd()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzap.zzbv(r32)
            java.lang.String r4 = "Data loss. Failed to bundle and serialize. appId"
            r2.zze(r4, r3, r0)
            return r27
        L_0x052b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzq r2 = r30.zzjq()
            r2.endTransaction()
            goto L_0x0535
        L_0x0534:
            throw r0
        L_0x0535:
            goto L_0x0534
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfa.zza(com.google.android.gms.measurement.internal.zzad, java.lang.String):byte[]");
    }

    /* access modifiers changed from: 0000 */
    public final String zzh(zzh zzh) {
        try {
            return (String) this.zzadj.zzgn().zzb((Callable<V>) new zzfe<V>(this, zzh)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzadj.zzgo().zzjd().zze("Failed to get app instance id. appId", zzap.zzbv(zzh.packageName), e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zzo(boolean z) {
        zzlv();
    }
}
