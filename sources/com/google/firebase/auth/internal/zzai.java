package com.google.firebase.auth.internal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.HashMap;
import java.util.Map;

public final class zzai {
    private static String EXTRA_STATUS = "com.google.firebase.auth.internal.STATUS";
    @VisibleForTesting
    private static final Map<String, String> zzse;

    public static void zza(@NonNull Intent intent, @NonNull Status status) {
        SafeParcelableSerializer.serializeToIntentExtra(status, intent, EXTRA_STATUS);
    }

    public static boolean zza(@NonNull Intent intent) {
        Preconditions.checkNotNull(intent);
        return intent.hasExtra(EXTRA_STATUS);
    }

    public static Status zzb(@NonNull Intent intent) {
        Preconditions.checkNotNull(intent);
        Preconditions.checkArgument(zza(intent));
        return (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, EXTRA_STATUS, Status.CREATOR);
    }

    static {
        HashMap hashMap = new HashMap();
        zzse = hashMap;
        hashMap.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        zzse.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
        zzse.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        zzse.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
    }
}
