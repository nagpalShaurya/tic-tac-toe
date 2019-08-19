package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzwy<T> implements zzxj<T> {
    private final zzwt zzcbd;
    private final boolean zzcbe;
    private final zzyb<?, ?> zzcbn;
    private final zzva<?> zzcbo;

    private zzwy(zzyb<?, ?> zzyb, zzva<?> zzva, zzwt zzwt) {
        this.zzcbn = zzyb;
        this.zzcbe = zzva.zze(zzwt);
        this.zzcbo = zzva;
        this.zzcbd = zzwt;
    }

    static <T> zzwy<T> zza(zzyb<?, ?> zzyb, zzva<?> zzva, zzwt zzwt) {
        return new zzwy<>(zzyb, zzva, zzwt);
    }

    public final T newInstance() {
        return this.zzcbd.zzwe().zzwi();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzcbn.zzah(t).equals(this.zzcbn.zzah(t2))) {
            return false;
        }
        if (this.zzcbe) {
            return this.zzcbo.zzs(t).equals(this.zzcbo.zzs(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzcbn.zzah(t).hashCode();
        if (this.zzcbe) {
            return (hashCode * 53) + this.zzcbo.zzs(t).hashCode();
        }
        return hashCode;
    }

    public final void zzd(T t, T t2) {
        zzxl.zza(this.zzcbn, t, t2);
        if (this.zzcbe) {
            zzxl.zza(this.zzcbo, t, t2);
        }
    }

    public final void zza(T t, zzyw zzyw) throws IOException {
        Iterator it = this.zzcbo.zzs(t).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzvf zzvf = (zzvf) entry.getKey();
            if (zzvf.zzvx() != zzyv.MESSAGE || zzvf.zzvy() || zzvf.zzvz()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof zzvy) {
                zzyw.zza(zzvf.zzc(), (Object) ((zzvy) entry).zzwu().zztt());
            } else {
                zzyw.zza(zzvf.zzc(), entry.getValue());
            }
        }
        zzyb<?, ?> zzyb = this.zzcbn;
        zzyb.zzc(zzyb.zzah(t), zzyw);
    }

    public final void zza(T t, zzxi zzxi, zzuz zzuz) throws IOException {
        boolean z;
        zzyb<?, ?> zzyb = this.zzcbn;
        zzva<?> zzva = this.zzcbo;
        Object zzai = zzyb.zzai(t);
        zzvd zzt = zzva.zzt(t);
        do {
            try {
                if (zzxi.zzve() == Integer.MAX_VALUE) {
                    zzyb.zzg(t, zzai);
                    return;
                }
                int tag = zzxi.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzud zzud = null;
                    while (zzxi.zzve() != Integer.MAX_VALUE) {
                        int tag2 = zzxi.getTag();
                        if (tag2 == 16) {
                            i = zzxi.zzup();
                            obj = zzva.zza(zzuz, this.zzcbd, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzva.zza(zzxi, obj, zzuz, zzt);
                            } else {
                                zzud = zzxi.zzuo();
                            }
                        } else if (!zzxi.zzvf()) {
                            break;
                        }
                    }
                    if (zzxi.getTag() != 12) {
                        throw zzvt.zzwn();
                    } else if (zzud != null) {
                        if (obj != null) {
                            zzva.zza(zzud, obj, zzuz, zzt);
                        } else {
                            zzyb.zza(zzai, i, zzud);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzva.zza(zzuz, this.zzcbd, tag >>> 3);
                    if (zza != null) {
                        zzva.zza(zzxi, zza, zzuz, zzt);
                    } else {
                        z = zzyb.zza(zzai, zzxi);
                        continue;
                    }
                } else {
                    z = zzxi.zzvf();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzyb.zzg(t, zzai);
            }
        } while (z);
    }

    public final void zzu(T t) {
        this.zzcbn.zzu(t);
        this.zzcbo.zzu(t);
    }

    public final boolean zzaf(T t) {
        return this.zzcbo.zzs(t).isInitialized();
    }

    public final int zzae(T t) {
        zzyb<?, ?> zzyb = this.zzcbn;
        int zzaj = zzyb.zzaj(zzyb.zzah(t)) + 0;
        if (this.zzcbe) {
            return zzaj + this.zzcbo.zzs(t).zzvv();
        }
        return zzaj;
    }
}
