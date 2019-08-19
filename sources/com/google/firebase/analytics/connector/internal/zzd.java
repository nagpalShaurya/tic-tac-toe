package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import java.util.HashSet;
import java.util.Set;

public final class zzd implements zza {
    private AppMeasurement zzbsg;
    Set<String> zzbss;
    /* access modifiers changed from: private */
    public AnalyticsConnectorListener zzbst;
    private zze zzbsu = new zze(this);

    public zzd(AppMeasurement appMeasurement, AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzbst = analyticsConnectorListener;
        this.zzbsg = appMeasurement;
        this.zzbsg.registerOnMeasurementEventListener(this.zzbsu);
        this.zzbss = new HashSet();
    }

    public final AnalyticsConnectorListener zztl() {
        return this.zzbst;
    }

    public final void registerEventNames(Set<String> set) {
        this.zzbss.clear();
        Set<String> set2 = this.zzbss;
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (hashSet.size() >= 50) {
                break;
            } else if (zzc.zzfr(str) && zzc.zzfq(str)) {
                hashSet.add(zzc.zzft(str));
            }
        }
        set2.addAll(hashSet);
    }

    public final void unregisterEventNames() {
        this.zzbss.clear();
    }
}
