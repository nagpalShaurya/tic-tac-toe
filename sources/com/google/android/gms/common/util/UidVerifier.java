package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
public final class UidVerifier {
    private UidVerifier() {
    }

    @KeepForSdk
    public static boolean isGooglePlayServicesUid(Context context, int i) {
        String str = "com.google.android.gms";
        if (!uidHasPackageName(context, i, str)) {
            return false;
        }
        try {
            return GoogleSignatureVerifier.getInstance(context).isGooglePublicSignedPackage(context.getPackageManager().getPackageInfo(str, 64));
        } catch (NameNotFoundException e) {
            String str2 = "UidVerifier";
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }

    @TargetApi(19)
    @KeepForSdk
    public static boolean uidHasPackageName(Context context, int i, String str) {
        return Wrappers.packageManager(context).zzb(i, str);
    }
}
