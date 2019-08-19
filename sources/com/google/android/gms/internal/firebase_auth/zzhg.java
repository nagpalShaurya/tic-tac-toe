package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzhg<T> implements zzhv<T> {
    private final zzfg<?> zzaaa;
    private final zzhb zzzp;
    private final boolean zzzq;
    private final zzip<?, ?> zzzz;

    private zzhg(zzip<?, ?> zzip, zzfg<?> zzfg, zzhb zzhb) {
        this.zzzz = zzip;
        this.zzzq = zzfg.zzf(zzhb);
        this.zzaaa = zzfg;
        this.zzzp = zzhb;
    }

    static <T> zzhg<T> zza(zzip<?, ?> zzip, zzfg<?> zzfg, zzhb zzhb) {
        return new zzhg<>(zzip, zzfg, zzhb);
    }

    public final T newInstance() {
        return this.zzzp.zzhg().zzhl();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzzz.zzs(t).equals(this.zzzz.zzs(t2))) {
            return false;
        }
        if (this.zzzq) {
            return this.zzaaa.zzd(t).equals(this.zzaaa.zzd(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzzz.zzs(t).hashCode();
        if (this.zzzq) {
            return (hashCode * 53) + this.zzaaa.zzd(t).hashCode();
        }
        return hashCode;
    }

    public final void zzc(T t, T t2) {
        zzhx.zza(this.zzzz, t, t2);
        if (this.zzzq) {
            zzhx.zza(this.zzaaa, t, t2);
        }
    }

    public final void zza(T t, zzjk zzjk) throws IOException {
        Iterator it = this.zzaaa.zzd(t).iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzfl zzfl = (zzfl) entry.getKey();
            if (zzfl.zzgy() != zzjj.MESSAGE || zzfl.zzgz() || zzfl.zzha()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof zzgg) {
                zzjk.zza(zzfl.zzbi(), (Object) ((zzgg) entry).zzia().zzer());
            } else {
                zzjk.zza(zzfl.zzbi(), entry.getValue());
            }
        }
        zzip<?, ?> zzip = this.zzzz;
        zzip.zzc(zzip.zzs(t), zzjk);
    }

    public final void zza(T t, zzhq zzhq, zzff zzff) throws IOException {
        boolean z;
        zzip<?, ?> zzip = this.zzzz;
        zzfg<?> zzfg = this.zzaaa;
        Object zzt = zzip.zzt(t);
        zzfj zze = zzfg.zze(t);
        do {
            try {
                if (zzhq.zzgf() == Integer.MAX_VALUE) {
                    zzip.zzf(t, zzt);
                    return;
                }
                int tag = zzhq.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzeh zzeh = null;
                    while (zzhq.zzgf() != Integer.MAX_VALUE) {
                        int tag2 = zzhq.getTag();
                        if (tag2 == 16) {
                            i = zzhq.zzfq();
                            obj = zzfg.zza(zzff, this.zzzp, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzfg.zza(zzhq, obj, zzff, zze);
                            } else {
                                zzeh = zzhq.zzfp();
                            }
                        } else if (!zzhq.zzgg()) {
                            break;
                        }
                    }
                    if (zzhq.getTag() != 12) {
                        throw zzgb.zzht();
                    } else if (zzeh != null) {
                        if (obj != null) {
                            zzfg.zza(zzeh, obj, zzff, zze);
                        } else {
                            zzip.zza(zzt, i, zzeh);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzfg.zza(zzff, this.zzzp, tag >>> 3);
                    if (zza != null) {
                        zzfg.zza(zzhq, zza, zzff, zze);
                    } else {
                        z = zzip.zza(zzt, zzhq);
                        continue;
                    }
                } else {
                    z = zzhq.zzgg();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzip.zzf(t, zzt);
            }
        } while (z);
    }

    public final void zzf(T t) {
        this.zzzz.zzf(t);
        this.zzaaa.zzf((Object) t);
    }

    public final boolean zzq(T t) {
        return this.zzaaa.zzd(t).isInitialized();
    }

    public final int zzp(T t) {
        zzip<?, ?> zzip = this.zzzz;
        int zzu = zzip.zzu(zzip.zzs(t)) + 0;
        if (this.zzzq) {
            return zzu + this.zzaaa.zzd(t).zzgw();
        }
        return zzu;
    }
}
