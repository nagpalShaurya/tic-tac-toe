package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.support.annotation.BinderThread;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public final class zzbv extends zzah {
    /* access modifiers changed from: private */
    public final zzfa zzamz;
    private Boolean zzaql;
    @Nullable
    private String zzaqm;

    public zzbv(zzfa zzfa) {
        this(zzfa, null);
    }

    private zzbv(zzfa zzfa, @Nullable String str) {
        Preconditions.checkNotNull(zzfa);
        this.zzamz = zzfa;
        this.zzaqm = null;
    }

    @BinderThread
    public final void zzb(zzh zzh) {
        zzb(zzh, false);
        zze(new zzbw(this, zzh));
    }

    @BinderThread
    public final void zza(zzad zzad, zzh zzh) {
        Preconditions.checkNotNull(zzad);
        zzb(zzh, false);
        zze(new zzcg(this, zzad, zzh));
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public final zzad zzb(zzad zzad, zzh zzh) {
        boolean z = false;
        if (!(!"_cmp".equals(zzad.name) || zzad.zzaid == null || zzad.zzaid.size() == 0)) {
            String string = zzad.zzaid.getString("_cis");
            if (!TextUtils.isEmpty(string) && (("referrer broadcast".equals(string) || "referrer API".equals(string)) && this.zzamz.zzgq().zzbg(zzh.packageName))) {
                z = true;
            }
        }
        if (!z) {
            return zzad;
        }
        this.zzamz.zzgo().zzjj().zzg("Event has been filtered ", zzad.toString());
        zzad zzad2 = new zzad("_cmpx", zzad.zzaid, zzad.origin, zzad.zzaip);
        return zzad2;
    }

    @BinderThread
    public final void zza(zzad zzad, String str, String str2) {
        Preconditions.checkNotNull(zzad);
        Preconditions.checkNotEmpty(str);
        zzc(str, true);
        zze(new zzch(this, zzad, str));
    }

    @BinderThread
    public final byte[] zza(zzad zzad, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzad);
        zzc(str, true);
        this.zzamz.zzgo().zzjk().zzg("Log and bundle. event", this.zzamz.zzgl().zzbs(zzad.name));
        long nanoTime = this.zzamz.zzbx().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zzamz.zzgn().zzc((Callable<V>) new zzci<V>(this, zzad, str)).get();
            if (bArr == null) {
                this.zzamz.zzgo().zzjd().zzg("Log and bundle returned null. appId", zzap.zzbv(str));
                bArr = new byte[0];
            }
            this.zzamz.zzgo().zzjk().zzd("Log and bundle processed. event, size, time_ms", this.zzamz.zzgl().zzbs(zzad.name), Integer.valueOf(bArr.length), Long.valueOf((this.zzamz.zzbx().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zzamz.zzgo().zzjd().zzd("Failed to log and bundle. appId, event, error", zzap.zzbv(str), this.zzamz.zzgl().zzbs(zzad.name), e);
            return null;
        }
    }

    @BinderThread
    public final void zza(zzfh zzfh, zzh zzh) {
        Preconditions.checkNotNull(zzfh);
        zzb(zzh, false);
        if (zzfh.getValue() == null) {
            zze(new zzcj(this, zzfh, zzh));
        } else {
            zze(new zzck(this, zzfh, zzh));
        }
    }

    @BinderThread
    public final List<zzfh> zza(zzh zzh, boolean z) {
        zzb(zzh, false);
        try {
            List<zzfj> list = (List) this.zzamz.zzgn().zzb((Callable<V>) new zzcl<V>(this, zzh)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzfj zzfj : list) {
                if (z || !zzfk.zzcv(zzfj.name)) {
                    arrayList.add(new zzfh(zzfj));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzamz.zzgo().zzjd().zze("Failed to get user attributes. appId", zzap.zzbv(zzh.packageName), e);
            return null;
        }
    }

    @BinderThread
    public final void zza(zzh zzh) {
        zzb(zzh, false);
        zze(new zzcm(this, zzh));
    }

    @BinderThread
    private final void zzb(zzh zzh, boolean z) {
        Preconditions.checkNotNull(zzh);
        zzc(zzh.packageName, false);
        this.zzamz.zzgm().zzt(zzh.zzafx, zzh.zzagk);
    }

    @BinderThread
    private final void zzc(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzaql == null) {
                        if (!"com.google.android.gms".equals(this.zzaqm) && !UidVerifier.isGooglePlayServicesUid(this.zzamz.getContext(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zzamz.getContext()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzaql = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzaql = Boolean.valueOf(z2);
                    }
                    if (this.zzaql.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zzamz.zzgo().zzjd().zzg("Measurement Service called with invalid calling package. appId", zzap.zzbv(str));
                    throw e;
                }
            }
            if (this.zzaqm == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zzamz.getContext(), Binder.getCallingUid(), str)) {
                this.zzaqm = str;
            }
            if (!str.equals(this.zzaqm)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        String str2 = "Measurement Service called without app package";
        this.zzamz.zzgo().zzjd().zzbx(str2);
        throw new SecurityException(str2);
    }

    @BinderThread
    public final void zza(long j, String str, String str2, String str3) {
        zzcn zzcn = new zzcn(this, str2, str3, str, j);
        zze(zzcn);
    }

    @BinderThread
    public final String zzc(zzh zzh) {
        zzb(zzh, false);
        return this.zzamz.zzh(zzh);
    }

    @BinderThread
    public final void zza(zzl zzl, zzh zzh) {
        Preconditions.checkNotNull(zzl);
        Preconditions.checkNotNull(zzl.zzahb);
        zzb(zzh, false);
        zzl zzl2 = new zzl(zzl);
        zzl2.packageName = zzh.packageName;
        if (zzl.zzahb.getValue() == null) {
            zze(new zzbx(this, zzl2, zzh));
        } else {
            zze(new zzby(this, zzl2, zzh));
        }
    }

    @BinderThread
    public final void zzb(zzl zzl) {
        Preconditions.checkNotNull(zzl);
        Preconditions.checkNotNull(zzl.zzahb);
        zzc(zzl.packageName, true);
        zzl zzl2 = new zzl(zzl);
        if (zzl.zzahb.getValue() == null) {
            zze(new zzbz(this, zzl2));
        } else {
            zze(new zzca(this, zzl2));
        }
    }

    @BinderThread
    public final List<zzfh> zza(String str, String str2, boolean z, zzh zzh) {
        zzb(zzh, false);
        try {
            List<zzfj> list = (List) this.zzamz.zzgn().zzb((Callable<V>) new zzcb<V>(this, zzh, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzfj zzfj : list) {
                if (z || !zzfk.zzcv(zzfj.name)) {
                    arrayList.add(new zzfh(zzfj));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzamz.zzgo().zzjd().zze("Failed to get user attributes. appId", zzap.zzbv(zzh.packageName), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzfh> zza(String str, String str2, String str3, boolean z) {
        zzc(str, true);
        try {
            List<zzfj> list = (List) this.zzamz.zzgn().zzb((Callable<V>) new zzcc<V>(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzfj zzfj : list) {
                if (z || !zzfk.zzcv(zzfj.name)) {
                    arrayList.add(new zzfh(zzfj));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzamz.zzgo().zzjd().zze("Failed to get user attributes. appId", zzap.zzbv(str), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzl> zza(String str, String str2, zzh zzh) {
        zzb(zzh, false);
        try {
            return (List) this.zzamz.zzgn().zzb((Callable<V>) new zzcd<V>(this, zzh, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zzamz.zzgo().zzjd().zzg("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzl> zze(String str, String str2, String str3) {
        zzc(str, true);
        try {
            return (List) this.zzamz.zzgn().zzb((Callable<V>) new zzce<V>(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zzamz.zzgo().zzjd().zzg("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final void zzd(zzh zzh) {
        zzc(zzh.packageName, false);
        zze(new zzcf(this, zzh));
    }

    @VisibleForTesting
    private final void zze(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (!((Boolean) zzaf.zzakv.get()).booleanValue() || !this.zzamz.zzgn().zzkb()) {
            this.zzamz.zzgn().zzc(runnable);
        } else {
            runnable.run();
        }
    }
}
