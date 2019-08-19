package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.text.TextUtils;

@TargetApi(14)
@MainThread
final class zzdm implements ActivityLifecycleCallbacks {
    private final /* synthetic */ zzcs zzarc;

    private zzdm(zzcs zzcs) {
        this.zzarc = zzcs;
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        String str;
        try {
            this.zzarc.zzgo().zzjl().zzbx("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    String str2 = "auto";
                    if (bundle == null) {
                        Bundle zza = this.zzarc.zzgm().zza(data);
                        this.zzarc.zzgm();
                        if (zzfk.zzd(intent)) {
                            str = "gs";
                        } else {
                            str = str2;
                        }
                        if (zza != null) {
                            this.zzarc.logEvent(str, "_cmp", zza);
                        }
                    }
                    String queryParameter = data.getQueryParameter("referrer");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        if (!(queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content")))) {
                            this.zzarc.zzgo().zzjk().zzbx("Activity created with data 'referrer' param without gclid and at least one utm field");
                            return;
                        }
                        this.zzarc.zzgo().zzjk().zzg("Activity created with referrer", queryParameter);
                        if (!TextUtils.isEmpty(queryParameter)) {
                            this.zzarc.zzb(str2, "_ldl", (Object) queryParameter, true);
                        }
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e) {
            this.zzarc.zzgo().zzjd().zzg("Throwable caught in onActivityCreated", e);
        }
        this.zzarc.zzgh().onActivityCreated(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zzarc.zzgh().onActivityDestroyed(activity);
    }

    @MainThread
    public final void onActivityPaused(Activity activity) {
        this.zzarc.zzgh().onActivityPaused(activity);
        zzeq zzgj = this.zzarc.zzgj();
        zzgj.zzgn().zzc((Runnable) new zzeu(zzgj, zzgj.zzbx().elapsedRealtime()));
    }

    @MainThread
    public final void onActivityResumed(Activity activity) {
        this.zzarc.zzgh().onActivityResumed(activity);
        zzeq zzgj = this.zzarc.zzgj();
        zzgj.zzgn().zzc((Runnable) new zzet(zzgj, zzgj.zzbx().elapsedRealtime()));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zzarc.zzgh().onActivitySaveInstanceState(activity, bundle);
    }

    /* synthetic */ zzdm(zzcs zzcs, zzct zzct) {
        this(zzcs);
    }
}
