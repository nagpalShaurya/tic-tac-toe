package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.internal.view.SupportMenu;
import com.google.android.gms.internal.firebase_auth.zzfs.zzd;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzff {
    private static volatile boolean zztu = false;
    private static final Class<?> zztv = zzgo();
    private static volatile zzff zztw;
    static final zzff zztx = new zzff(true);
    private final Map<zza, zzd<?, ?>> zzty;

    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * SupportMenu.USER_MASK) + this.number;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }
    }

    private static Class<?> zzgo() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzff zzgp() {
        return zzfe.zzgm();
    }

    public static zzff zzgq() {
        zzff zzff = zztw;
        if (zzff == null) {
            synchronized (zzff.class) {
                zzff = zztw;
                if (zzff == null) {
                    zzff = zzfe.zzgn();
                    zztw = zzff;
                }
            }
        }
        return zzff;
    }

    static zzff zzgn() {
        return zzfq.zza(zzff.class);
    }

    public final <ContainingType extends zzhb> zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzd) this.zzty.get(new zza(containingtype, i));
    }

    zzff() {
        this.zzty = new HashMap();
    }

    private zzff(boolean z) {
        this.zzty = Collections.emptyMap();
    }
}
