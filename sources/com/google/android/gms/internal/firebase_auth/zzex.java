package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzex implements zzhq {
    private int tag;
    private final zzes zztl;
    private int zztm;
    private int zztn = 0;

    public static zzex zza(zzes zzes) {
        if (zzes.zzta != null) {
            return zzes.zzta;
        }
        return new zzex(zzes);
    }

    private zzex(zzes zzes) {
        this.zztl = (zzes) zzfu.zza(zzes, "input");
        this.zztl.zzta = this;
    }

    public final int zzgf() throws IOException {
        int i = this.zztn;
        if (i != 0) {
            this.tag = i;
            this.zztn = 0;
        } else {
            this.tag = this.zztl.zzfh();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zztm) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final int getTag() {
        return this.tag;
    }

    public final boolean zzgg() throws IOException {
        if (!this.zztl.zzfx()) {
            int i = this.tag;
            if (i != this.zztm) {
                return this.zztl.zzn(i);
            }
        }
        return false;
    }

    private final void zzx(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzgb.zzhu();
        }
    }

    public final double readDouble() throws IOException {
        zzx(1);
        return this.zztl.readDouble();
    }

    public final float readFloat() throws IOException {
        zzx(5);
        return this.zztl.readFloat();
    }

    public final long zzfi() throws IOException {
        zzx(0);
        return this.zztl.zzfi();
    }

    public final long zzfj() throws IOException {
        zzx(0);
        return this.zztl.zzfj();
    }

    public final int zzfk() throws IOException {
        zzx(0);
        return this.zztl.zzfk();
    }

    public final long zzfl() throws IOException {
        zzx(1);
        return this.zztl.zzfl();
    }

    public final int zzfm() throws IOException {
        zzx(5);
        return this.zztl.zzfm();
    }

    public final boolean zzfn() throws IOException {
        zzx(0);
        return this.zztl.zzfn();
    }

    public final String readString() throws IOException {
        zzx(2);
        return this.zztl.readString();
    }

    public final String zzfo() throws IOException {
        zzx(2);
        return this.zztl.zzfo();
    }

    public final <T> T zza(zzhv<T> zzhv, zzff zzff) throws IOException {
        zzx(2);
        return zzc(zzhv, zzff);
    }

    public final <T> T zzb(zzhv<T> zzhv, zzff zzff) throws IOException {
        zzx(3);
        return zzd(zzhv, zzff);
    }

    private final <T> T zzc(zzhv<T> zzhv, zzff zzff) throws IOException {
        int zzfq = this.zztl.zzfq();
        if (this.zztl.zzsx < this.zztl.zzsy) {
            int zzo = this.zztl.zzo(zzfq);
            T newInstance = zzhv.newInstance();
            this.zztl.zzsx++;
            zzhv.zza(newInstance, this, zzff);
            zzhv.zzf(newInstance);
            this.zztl.zzm(0);
            this.zztl.zzsx--;
            this.zztl.zzp(zzo);
            return newInstance;
        }
        throw new zzgb("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzhv<T> zzhv, zzff zzff) throws IOException {
        int i = this.zztm;
        this.zztm = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzhv.newInstance();
            zzhv.zza(newInstance, this, zzff);
            zzhv.zzf(newInstance);
            if (this.tag == this.zztm) {
                return newInstance;
            }
            throw zzgb.zzhw();
        } finally {
            this.zztm = i;
        }
    }

    public final zzeh zzfp() throws IOException {
        zzx(2);
        return this.zztl.zzfp();
    }

    public final int zzfq() throws IOException {
        zzx(0);
        return this.zztl.zzfq();
    }

    public final int zzfr() throws IOException {
        zzx(0);
        return this.zztl.zzfr();
    }

    public final int zzfs() throws IOException {
        zzx(5);
        return this.zztl.zzfs();
    }

    public final long zzft() throws IOException {
        zzx(1);
        return this.zztl.zzft();
    }

    public final int zzfu() throws IOException {
        zzx(0);
        return this.zztl.zzfu();
    }

    public final long zzfv() throws IOException {
        zzx(0);
        return this.zztl.zzfv();
    }

    public final void zzd(List<Double> list) throws IOException {
        int zzfh;
        int zzfh2;
        if (list instanceof zzfc) {
            zzfc zzfc = (zzfc) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzfc.zzc(this.zztl.readDouble());
                    if (!this.zztl.zzfx()) {
                        zzfh2 = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh2 == this.tag);
                this.zztn = zzfh2;
            } else if (i == 2) {
                int zzfq = this.zztl.zzfq();
                zzy(zzfq);
                int zzfy = this.zztl.zzfy() + zzfq;
                do {
                    zzfc.zzc(this.zztl.readDouble());
                } while (this.zztl.zzfy() < zzfy);
            } else {
                throw zzgb.zzhu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zztl.readDouble()));
                    if (!this.zztl.zzfx()) {
                        zzfh = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh == this.tag);
                this.zztn = zzfh;
            } else if (i2 == 2) {
                int zzfq2 = this.zztl.zzfq();
                zzy(zzfq2);
                int zzfy2 = this.zztl.zzfy() + zzfq2;
                do {
                    list.add(Double.valueOf(this.zztl.readDouble()));
                } while (this.zztl.zzfy() < zzfy2);
            } else {
                throw zzgb.zzhu();
            }
        }
    }

    public final void zze(List<Float> list) throws IOException {
        int zzfh;
        int zzfh2;
        if (list instanceof zzfp) {
            zzfp zzfp = (zzfp) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzfq = this.zztl.zzfq();
                zzz(zzfq);
                int zzfy = this.zztl.zzfy() + zzfq;
                do {
                    zzfp.zzc(this.zztl.readFloat());
                } while (this.zztl.zzfy() < zzfy);
            } else if (i == 5) {
                do {
                    zzfp.zzc(this.zztl.readFloat());
                    if (!this.zztl.zzfx()) {
                        zzfh2 = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh2 == this.tag);
                this.zztn = zzfh2;
            } else {
                throw zzgb.zzhu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzfq2 = this.zztl.zzfq();
                zzz(zzfq2);
                int zzfy2 = this.zztl.zzfy() + zzfq2;
                do {
                    list.add(Float.valueOf(this.zztl.readFloat()));
                } while (this.zztl.zzfy() < zzfy2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zztl.readFloat()));
                    if (!this.zztl.zzfx()) {
                        zzfh = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh == this.tag);
                this.zztn = zzfh;
            } else {
                throw zzgb.zzhu();
            }
        }
    }

    public final void zzf(List<Long> list) throws IOException {
        int zzfh;
        int zzfh2;
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgp.zzl(this.zztl.zzfi());
                    if (!this.zztl.zzfx()) {
                        zzfh2 = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh2 == this.tag);
                this.zztn = zzfh2;
            } else if (i == 2) {
                int zzfy = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    zzgp.zzl(this.zztl.zzfi());
                } while (this.zztl.zzfy() < zzfy);
                zzaa(zzfy);
            } else {
                throw zzgb.zzhu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zztl.zzfi()));
                    if (!this.zztl.zzfx()) {
                        zzfh = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh == this.tag);
                this.zztn = zzfh;
            } else if (i2 == 2) {
                int zzfy2 = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    list.add(Long.valueOf(this.zztl.zzfi()));
                } while (this.zztl.zzfy() < zzfy2);
                zzaa(zzfy2);
            } else {
                throw zzgb.zzhu();
            }
        }
    }

    public final void zzg(List<Long> list) throws IOException {
        int zzfh;
        int zzfh2;
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgp.zzl(this.zztl.zzfj());
                    if (!this.zztl.zzfx()) {
                        zzfh2 = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh2 == this.tag);
                this.zztn = zzfh2;
            } else if (i == 2) {
                int zzfy = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    zzgp.zzl(this.zztl.zzfj());
                } while (this.zztl.zzfy() < zzfy);
                zzaa(zzfy);
            } else {
                throw zzgb.zzhu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zztl.zzfj()));
                    if (!this.zztl.zzfx()) {
                        zzfh = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh == this.tag);
                this.zztn = zzfh;
            } else if (i2 == 2) {
                int zzfy2 = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    list.add(Long.valueOf(this.zztl.zzfj()));
                } while (this.zztl.zzfy() < zzfy2);
                zzaa(zzfy2);
            } else {
                throw zzgb.zzhu();
            }
        }
    }

    public final void zzh(List<Integer> list) throws IOException {
        int zzfh;
        int zzfh2;
        if (list instanceof zzft) {
            zzft zzft = (zzft) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzft.zzar(this.zztl.zzfk());
                    if (!this.zztl.zzfx()) {
                        zzfh2 = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh2 == this.tag);
                this.zztn = zzfh2;
            } else if (i == 2) {
                int zzfy = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    zzft.zzar(this.zztl.zzfk());
                } while (this.zztl.zzfy() < zzfy);
                zzaa(zzfy);
            } else {
                throw zzgb.zzhu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zztl.zzfk()));
                    if (!this.zztl.zzfx()) {
                        zzfh = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh == this.tag);
                this.zztn = zzfh;
            } else if (i2 == 2) {
                int zzfy2 = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    list.add(Integer.valueOf(this.zztl.zzfk()));
                } while (this.zztl.zzfy() < zzfy2);
                zzaa(zzfy2);
            } else {
                throw zzgb.zzhu();
            }
        }
    }

    public final void zzi(List<Long> list) throws IOException {
        int zzfh;
        int zzfh2;
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzgp.zzl(this.zztl.zzfl());
                    if (!this.zztl.zzfx()) {
                        zzfh2 = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh2 == this.tag);
                this.zztn = zzfh2;
            } else if (i == 2) {
                int zzfq = this.zztl.zzfq();
                zzy(zzfq);
                int zzfy = this.zztl.zzfy() + zzfq;
                do {
                    zzgp.zzl(this.zztl.zzfl());
                } while (this.zztl.zzfy() < zzfy);
            } else {
                throw zzgb.zzhu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zztl.zzfl()));
                    if (!this.zztl.zzfx()) {
                        zzfh = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh == this.tag);
                this.zztn = zzfh;
            } else if (i2 == 2) {
                int zzfq2 = this.zztl.zzfq();
                zzy(zzfq2);
                int zzfy2 = this.zztl.zzfy() + zzfq2;
                do {
                    list.add(Long.valueOf(this.zztl.zzfl()));
                } while (this.zztl.zzfy() < zzfy2);
            } else {
                throw zzgb.zzhu();
            }
        }
    }

    public final void zzj(List<Integer> list) throws IOException {
        int zzfh;
        int zzfh2;
        if (list instanceof zzft) {
            zzft zzft = (zzft) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzfq = this.zztl.zzfq();
                zzz(zzfq);
                int zzfy = this.zztl.zzfy() + zzfq;
                do {
                    zzft.zzar(this.zztl.zzfm());
                } while (this.zztl.zzfy() < zzfy);
            } else if (i == 5) {
                do {
                    zzft.zzar(this.zztl.zzfm());
                    if (!this.zztl.zzfx()) {
                        zzfh2 = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh2 == this.tag);
                this.zztn = zzfh2;
            } else {
                throw zzgb.zzhu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzfq2 = this.zztl.zzfq();
                zzz(zzfq2);
                int zzfy2 = this.zztl.zzfy() + zzfq2;
                do {
                    list.add(Integer.valueOf(this.zztl.zzfm()));
                } while (this.zztl.zzfy() < zzfy2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zztl.zzfm()));
                    if (!this.zztl.zzfx()) {
                        zzfh = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh == this.tag);
                this.zztn = zzfh;
            } else {
                throw zzgb.zzhu();
            }
        }
    }

    public final void zzk(List<Boolean> list) throws IOException {
        int zzfh;
        int zzfh2;
        if (list instanceof zzef) {
            zzef zzef = (zzef) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzef.addBoolean(this.zztl.zzfn());
                    if (!this.zztl.zzfx()) {
                        zzfh2 = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh2 == this.tag);
                this.zztn = zzfh2;
            } else if (i == 2) {
                int zzfy = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    zzef.addBoolean(this.zztl.zzfn());
                } while (this.zztl.zzfy() < zzfy);
                zzaa(zzfy);
            } else {
                throw zzgb.zzhu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zztl.zzfn()));
                    if (!this.zztl.zzfx()) {
                        zzfh = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh == this.tag);
                this.zztn = zzfh;
            } else if (i2 == 2) {
                int zzfy2 = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    list.add(Boolean.valueOf(this.zztl.zzfn()));
                } while (this.zztl.zzfy() < zzfy2);
                zzaa(zzfy2);
            } else {
                throw zzgb.zzhu();
            }
        }
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzl(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzfh;
        int zzfh2;
        if ((this.tag & 7) != 2) {
            throw zzgb.zzhu();
        } else if (!(list instanceof zzgk) || z) {
            do {
                list.add(z ? zzfo() : readString());
                if (!this.zztl.zzfx()) {
                    zzfh = this.zztl.zzfh();
                } else {
                    return;
                }
            } while (zzfh == this.tag);
            this.zztn = zzfh;
        } else {
            zzgk zzgk = (zzgk) list;
            do {
                zzgk.zzc(zzfp());
                if (!this.zztl.zzfx()) {
                    zzfh2 = this.zztl.zzfh();
                } else {
                    return;
                }
            } while (zzfh2 == this.tag);
            this.zztn = zzfh2;
        }
    }

    public final <T> void zza(List<T> list, zzhv<T> zzhv, zzff zzff) throws IOException {
        int zzfh;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzhv, zzff));
                if (!this.zztl.zzfx() && this.zztn == 0) {
                    zzfh = this.zztl.zzfh();
                } else {
                    return;
                }
            } while (zzfh == i);
            this.zztn = zzfh;
            return;
        }
        throw zzgb.zzhu();
    }

    public final <T> void zzb(List<T> list, zzhv<T> zzhv, zzff zzff) throws IOException {
        int zzfh;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzhv, zzff));
                if (!this.zztl.zzfx() && this.zztn == 0) {
                    zzfh = this.zztl.zzfh();
                } else {
                    return;
                }
            } while (zzfh == i);
            this.zztn = zzfh;
            return;
        }
        throw zzgb.zzhu();
    }

    public final void zzm(List<zzeh> list) throws IOException {
        int zzfh;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzfp());
                if (!this.zztl.zzfx()) {
                    zzfh = this.zztl.zzfh();
                } else {
                    return;
                }
            } while (zzfh == this.tag);
            this.zztn = zzfh;
            return;
        }
        throw zzgb.zzhu();
    }

    public final void zzn(List<Integer> list) throws IOException {
        int zzfh;
        int zzfh2;
        if (list instanceof zzft) {
            zzft zzft = (zzft) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzft.zzar(this.zztl.zzfq());
                    if (!this.zztl.zzfx()) {
                        zzfh2 = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh2 == this.tag);
                this.zztn = zzfh2;
            } else if (i == 2) {
                int zzfy = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    zzft.zzar(this.zztl.zzfq());
                } while (this.zztl.zzfy() < zzfy);
                zzaa(zzfy);
            } else {
                throw zzgb.zzhu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zztl.zzfq()));
                    if (!this.zztl.zzfx()) {
                        zzfh = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh == this.tag);
                this.zztn = zzfh;
            } else if (i2 == 2) {
                int zzfy2 = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    list.add(Integer.valueOf(this.zztl.zzfq()));
                } while (this.zztl.zzfy() < zzfy2);
                zzaa(zzfy2);
            } else {
                throw zzgb.zzhu();
            }
        }
    }

    public final void zzo(List<Integer> list) throws IOException {
        int zzfh;
        int zzfh2;
        if (list instanceof zzft) {
            zzft zzft = (zzft) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzft.zzar(this.zztl.zzfr());
                    if (!this.zztl.zzfx()) {
                        zzfh2 = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh2 == this.tag);
                this.zztn = zzfh2;
            } else if (i == 2) {
                int zzfy = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    zzft.zzar(this.zztl.zzfr());
                } while (this.zztl.zzfy() < zzfy);
                zzaa(zzfy);
            } else {
                throw zzgb.zzhu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zztl.zzfr()));
                    if (!this.zztl.zzfx()) {
                        zzfh = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh == this.tag);
                this.zztn = zzfh;
            } else if (i2 == 2) {
                int zzfy2 = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    list.add(Integer.valueOf(this.zztl.zzfr()));
                } while (this.zztl.zzfy() < zzfy2);
                zzaa(zzfy2);
            } else {
                throw zzgb.zzhu();
            }
        }
    }

    public final void zzp(List<Integer> list) throws IOException {
        int zzfh;
        int zzfh2;
        if (list instanceof zzft) {
            zzft zzft = (zzft) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzfq = this.zztl.zzfq();
                zzz(zzfq);
                int zzfy = this.zztl.zzfy() + zzfq;
                do {
                    zzft.zzar(this.zztl.zzfs());
                } while (this.zztl.zzfy() < zzfy);
            } else if (i == 5) {
                do {
                    zzft.zzar(this.zztl.zzfs());
                    if (!this.zztl.zzfx()) {
                        zzfh2 = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh2 == this.tag);
                this.zztn = zzfh2;
            } else {
                throw zzgb.zzhu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzfq2 = this.zztl.zzfq();
                zzz(zzfq2);
                int zzfy2 = this.zztl.zzfy() + zzfq2;
                do {
                    list.add(Integer.valueOf(this.zztl.zzfs()));
                } while (this.zztl.zzfy() < zzfy2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zztl.zzfs()));
                    if (!this.zztl.zzfx()) {
                        zzfh = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh == this.tag);
                this.zztn = zzfh;
            } else {
                throw zzgb.zzhu();
            }
        }
    }

    public final void zzq(List<Long> list) throws IOException {
        int zzfh;
        int zzfh2;
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzgp.zzl(this.zztl.zzft());
                    if (!this.zztl.zzfx()) {
                        zzfh2 = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh2 == this.tag);
                this.zztn = zzfh2;
            } else if (i == 2) {
                int zzfq = this.zztl.zzfq();
                zzy(zzfq);
                int zzfy = this.zztl.zzfy() + zzfq;
                do {
                    zzgp.zzl(this.zztl.zzft());
                } while (this.zztl.zzfy() < zzfy);
            } else {
                throw zzgb.zzhu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zztl.zzft()));
                    if (!this.zztl.zzfx()) {
                        zzfh = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh == this.tag);
                this.zztn = zzfh;
            } else if (i2 == 2) {
                int zzfq2 = this.zztl.zzfq();
                zzy(zzfq2);
                int zzfy2 = this.zztl.zzfy() + zzfq2;
                do {
                    list.add(Long.valueOf(this.zztl.zzft()));
                } while (this.zztl.zzfy() < zzfy2);
            } else {
                throw zzgb.zzhu();
            }
        }
    }

    public final void zzr(List<Integer> list) throws IOException {
        int zzfh;
        int zzfh2;
        if (list instanceof zzft) {
            zzft zzft = (zzft) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzft.zzar(this.zztl.zzfu());
                    if (!this.zztl.zzfx()) {
                        zzfh2 = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh2 == this.tag);
                this.zztn = zzfh2;
            } else if (i == 2) {
                int zzfy = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    zzft.zzar(this.zztl.zzfu());
                } while (this.zztl.zzfy() < zzfy);
                zzaa(zzfy);
            } else {
                throw zzgb.zzhu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zztl.zzfu()));
                    if (!this.zztl.zzfx()) {
                        zzfh = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh == this.tag);
                this.zztn = zzfh;
            } else if (i2 == 2) {
                int zzfy2 = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    list.add(Integer.valueOf(this.zztl.zzfu()));
                } while (this.zztl.zzfy() < zzfy2);
                zzaa(zzfy2);
            } else {
                throw zzgb.zzhu();
            }
        }
    }

    public final void zzs(List<Long> list) throws IOException {
        int zzfh;
        int zzfh2;
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgp.zzl(this.zztl.zzfv());
                    if (!this.zztl.zzfx()) {
                        zzfh2 = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh2 == this.tag);
                this.zztn = zzfh2;
            } else if (i == 2) {
                int zzfy = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    zzgp.zzl(this.zztl.zzfv());
                } while (this.zztl.zzfy() < zzfy);
                zzaa(zzfy);
            } else {
                throw zzgb.zzhu();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zztl.zzfv()));
                    if (!this.zztl.zzfx()) {
                        zzfh = this.zztl.zzfh();
                    } else {
                        return;
                    }
                } while (zzfh == this.tag);
                this.zztn = zzfh;
            } else if (i2 == 2) {
                int zzfy2 = this.zztl.zzfy() + this.zztl.zzfq();
                do {
                    list.add(Long.valueOf(this.zztl.zzfv()));
                } while (this.zztl.zzfy() < zzfy2);
                zzaa(zzfy2);
            } else {
                throw zzgb.zzhu();
            }
        }
    }

    private static void zzy(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzgb.zzhw();
        }
    }

    public final <K, V> void zza(Map<K, V> map, zzgu<K, V> zzgu, zzff zzff) throws IOException {
        String str;
        zzx(2);
        int zzo = this.zztl.zzo(this.zztl.zzfq());
        K k = zzgu.zzzd;
        V v = zzgu.zzzf;
        while (true) {
            try {
                int zzgf = zzgf();
                if (zzgf == Integer.MAX_VALUE || this.zztl.zzfx()) {
                    map.put(k, v);
                } else {
                    str = "Unable to parse map entry.";
                    if (zzgf == 1) {
                        k = zza(zzgu.zzzc, null, (zzff) null);
                    } else if (zzgf == 2) {
                        v = zza(zzgu.zzze, zzgu.zzzf.getClass(), zzff);
                    } else if (!zzgg()) {
                        throw new zzgb(str);
                    }
                }
            } catch (zzgc e) {
                if (!zzgg()) {
                    throw new zzgb(str);
                }
            } catch (Throwable th) {
                this.zztl.zzp(zzo);
                throw th;
            }
        }
        map.put(k, v);
        this.zztl.zzp(zzo);
    }

    private final Object zza(zzje zzje, Class<?> cls, zzff zzff) throws IOException {
        switch (zzje) {
            case BOOL:
                return Boolean.valueOf(zzfn());
            case BYTES:
                return zzfp();
            case DOUBLE:
                return Double.valueOf(readDouble());
            case ENUM:
                return Integer.valueOf(zzfr());
            case FIXED32:
                return Integer.valueOf(zzfm());
            case FIXED64:
                return Long.valueOf(zzfl());
            case FLOAT:
                return Float.valueOf(readFloat());
            case INT32:
                return Integer.valueOf(zzfk());
            case INT64:
                return Long.valueOf(zzfj());
            case MESSAGE:
                zzx(2);
                return zzc(zzhn.zzit().zzf(cls), zzff);
            case SFIXED32:
                return Integer.valueOf(zzfs());
            case SFIXED64:
                return Long.valueOf(zzft());
            case SINT32:
                return Integer.valueOf(zzfu());
            case SINT64:
                return Long.valueOf(zzfv());
            case STRING:
                return zzfo();
            case UINT32:
                return Integer.valueOf(zzfq());
            case UINT64:
                return Long.valueOf(zzfi());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzz(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzgb.zzhw();
        }
    }

    private final void zzaa(int i) throws IOException {
        if (this.zztl.zzfy() != i) {
            throw zzgb.zzhp();
        }
    }
}
