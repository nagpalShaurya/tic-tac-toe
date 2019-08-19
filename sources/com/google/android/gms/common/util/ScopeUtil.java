package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

@KeepForSdk
public final class ScopeUtil {
    private ScopeUtil() {
    }

    @KeepForSdk
    public static String[] toScopeString(Set<Scope> set) {
        String str = "scopes can't be null.";
        Preconditions.checkNotNull(set, str);
        Scope[] scopeArr = (Scope[]) set.toArray(new Scope[set.size()]);
        Preconditions.checkNotNull(scopeArr, str);
        String[] strArr = new String[scopeArr.length];
        for (int i = 0; i < scopeArr.length; i++) {
            strArr[i] = scopeArr[i].getScopeUri();
        }
        return strArr;
    }
}
