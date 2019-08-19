package com.google.android.gms.internal.firebase_auth;

import java.util.Comparator;

final class zzej implements Comparator<zzeh> {
    zzej() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzeh zzeh = (zzeh) obj;
        zzeh zzeh2 = (zzeh) obj2;
        zzen zzen = (zzen) zzeh.iterator();
        zzen zzen2 = (zzen) zzeh2.iterator();
        while (zzen.hasNext() && zzen2.hasNext()) {
            int compare = Integer.compare(zzeh.zza(zzen.nextByte()), zzeh.zza(zzen2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzeh.size(), zzeh2.size());
    }
}
