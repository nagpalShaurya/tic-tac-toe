package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzu;
import java.util.List;

public final class zzbg {
    final zzbt zzadj;

    zzbg(zzbt zzbt) {
        this.zzadj = zzbt;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzcd(String str) {
        if (str == null || str.isEmpty()) {
            this.zzadj.zzgo().zzjj().zzbx("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.zzadj.zzgn().zzaf();
        if (!zzka()) {
            this.zzadj.zzgo().zzjj().zzbx("Install Referrer Reporter is not available");
            return;
        }
        this.zzadj.zzgo().zzjj().zzbx("Install Referrer Reporter is initializing");
        zzbh zzbh = new zzbh(this, str);
        this.zzadj.zzgn().zzaf();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        String str2 = "com.android.vending";
        intent.setComponent(new ComponentName(str2, "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.zzadj.getContext().getPackageManager();
        if (packageManager == null) {
            this.zzadj.zzgo().zzjg().zzbx("Failed to obtain Package Manager to verify binding conditions");
            return;
        }
        List queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.zzadj.zzgo().zzjj().zzbx("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
        if (resolveInfo.serviceInfo != null) {
            String str3 = resolveInfo.serviceInfo.packageName;
            if (resolveInfo.serviceInfo.name == null || !str2.equals(str3) || !zzka()) {
                this.zzadj.zzgo().zzjj().zzbx("Play Store missing or incompatible. Version 8.3.73 or later required");
            } else {
                try {
                    this.zzadj.zzgo().zzjj().zzg("Install Referrer Service is", ConnectionTracker.getInstance().bindService(this.zzadj.getContext(), new Intent(intent), zzbh, 1) ? "available" : "not available");
                } catch (Exception e) {
                    this.zzadj.zzgo().zzjd().zzg("Exception occurred while binding to Install Referrer Service", e.getMessage());
                }
            }
        }
    }

    @VisibleForTesting
    private final boolean zzka() {
        boolean z = false;
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.zzadj.getContext());
            if (packageManager == null) {
                this.zzadj.zzgo().zzjj().zzbx("Failed to retrieve Package Manager to check Play Store compatibility");
                return false;
            }
            if (packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            this.zzadj.zzgo().zzjj().zzg("Failed to retrieve Play Store version", e);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    @Nullable
    @WorkerThread
    @VisibleForTesting
    public final Bundle zza(String str, zzu zzu) {
        this.zzadj.zzgn().zzaf();
        if (zzu == null) {
            this.zzadj.zzgo().zzjg().zzbx("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle zza = zzu.zza(bundle);
            if (zza != null) {
                return zza;
            }
            this.zzadj.zzgo().zzjd().zzbx("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.zzadj.zzgo().zzjd().zzg("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }
}
