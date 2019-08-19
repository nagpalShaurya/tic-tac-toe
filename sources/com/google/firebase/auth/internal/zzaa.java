package com.google.firebase.auth.internal;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzaf;
import com.google.firebase.auth.GetTokenResult;
import java.util.Collections;
import java.util.Map;

public final class zzaa {
    private static final Logger zzgg = new Logger("GetTokenResultFactory", new String[0]);

    public static GetTokenResult zzcu(String str) {
        Map map;
        try {
            map = zzab.zzcv(str);
        } catch (zzaf e) {
            zzgg.mo7716e("Error parsing token claims", e, new Object[0]);
            map = Collections.EMPTY_MAP;
        }
        return new GetTokenResult(str, map);
    }
}
