package com.google.android.gms.internal.measurement;

import android.support.p000v4.internal.view.SupportMenu;
import com.google.android.gms.internal.measurement.zzvm.zzd;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzuz {
    private static volatile boolean zzbvj = false;
    private static final Class<?> zzbvk = zzvn();
    private static volatile zzuz zzbvl;
    static final zzuz zzbvm = new zzuz(true);
    private final Map<zza, zzd<?, ?>> zzbvn;

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

    private static Class<?> zzvn() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzuz zzvo() {
        return zzuy.zzvl();
    }

    public static zzuz zzvp() {
        zzuz zzuz = zzbvl;
        if (zzuz == null) {
            synchronized (zzuz.class) {
                zzuz = zzbvl;
                if (zzuz == null) {
                    zzuz = zzuy.zzvm();
                    zzbvl = zzuz;
                }
            }
        }
        return zzuz;
    }

    static zzuz zzvm() {
        return zzvk.zzd(zzuz.class);
    }

    public final <ContainingType extends zzwt> zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzd) this.zzbvn.get(new zza(containingtype, i));
    }

    zzuz() {
        this.zzbvn = new HashMap();
    }

    private zzuz(boolean z) {
        this.zzbvn = Collections.emptyMap();
    }
}
