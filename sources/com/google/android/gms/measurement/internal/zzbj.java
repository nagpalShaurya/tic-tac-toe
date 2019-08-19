package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbj {
    private final zzbm zzaoi;

    public zzbj(zzbm zzbm) {
        Preconditions.checkNotNull(zzbm);
        this.zzaoi = zzbm;
    }

    public static boolean zza(Context context) {
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ActivityInfo receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0);
            if (receiverInfo != null && receiverInfo.enabled) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
        }
    }

    @MainThread
    public final void onReceive(Context context, Intent intent) {
        zzbt zza = zzbt.zza(context, (zzak) null);
        zzap zzgo = zza.zzgo();
        if (intent == null) {
            zzgo.zzjg().zzbx("Receiver called with null intent");
            return;
        }
        zza.zzgr();
        String action = intent.getAction();
        zzgo.zzjl().zzg("Local receiver got", action);
        String str = "com.google.android.gms.measurement.UPLOAD";
        if (str.equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction(str);
            zzgo.zzjl().zzbx("Starting wakeful intent.");
            this.zzaoi.doStartService(context, className);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                zza.zzgn().zzc((Runnable) new zzbk(this, zza, zzgo));
            } catch (Exception e) {
                zzgo.zzjg().zzg("Install Referrer Reporter encountered a problem", e);
            }
            PendingResult doGoAsync = this.zzaoi.doGoAsync();
            String stringExtra = intent.getStringExtra("referrer");
            if (stringExtra == null) {
                zzgo.zzjl().zzbx("Install referrer extras are null");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                }
                return;
            }
            zzgo.zzjj().zzg("Install referrer extras are", stringExtra);
            String str2 = "?";
            if (!stringExtra.contains(str2)) {
                String valueOf = String.valueOf(stringExtra);
                stringExtra = valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2);
            }
            Bundle zza2 = zza.zzgm().zza(Uri.parse(stringExtra));
            if (zza2 == null) {
                zzgo.zzjl().zzbx("No campaign defined in install referrer broadcast");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                }
            } else {
                long longExtra = intent.getLongExtra("referrer_timestamp_seconds", 0) * 1000;
                if (longExtra == 0) {
                    zzgo.zzjg().zzbx("Install referrer is missing timestamp");
                }
                zzbo zzgn = zza.zzgn();
                zzbl zzbl = new zzbl(this, zza, longExtra, zza2, context, zzgo, doGoAsync);
                zzgn.zzc((Runnable) zzbl);
            }
        }
    }
}
