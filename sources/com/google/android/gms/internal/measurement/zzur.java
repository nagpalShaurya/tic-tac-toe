package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzur implements zzxi {
    private int tag;
    private final zzuo zzbur;
    private int zzbus;
    private int zzbut = 0;

    public static zzur zza(zzuo zzuo) {
        if (zzuo.zzbuk != null) {
            return zzuo.zzbuk;
        }
        return new zzur(zzuo);
    }

    private zzur(zzuo zzuo) {
        this.zzbur = (zzuo) zzvo.zza(zzuo, "input");
        this.zzbur.zzbuk = this;
    }

    public final int zzve() throws IOException {
        int i = this.zzbut;
        if (i != 0) {
            this.tag = i;
            this.zzbut = 0;
        } else {
            this.tag = this.zzbur.zzug();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzbus) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final int getTag() {
        return this.tag;
    }

    public final boolean zzvf() throws IOException {
        if (!this.zzbur.zzuw()) {
            int i = this.tag;
            if (i != this.zzbus) {
                return this.zzbur.zzao(i);
            }
        }
        return false;
    }

    private final void zzat(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzvt.zzwo();
        }
    }

    public final double readDouble() throws IOException {
        zzat(1);
        return this.zzbur.readDouble();
    }

    public final float readFloat() throws IOException {
        zzat(5);
        return this.zzbur.readFloat();
    }

    public final long zzuh() throws IOException {
        zzat(0);
        return this.zzbur.zzuh();
    }

    public final long zzui() throws IOException {
        zzat(0);
        return this.zzbur.zzui();
    }

    public final int zzuj() throws IOException {
        zzat(0);
        return this.zzbur.zzuj();
    }

    public final long zzuk() throws IOException {
        zzat(1);
        return this.zzbur.zzuk();
    }

    public final int zzul() throws IOException {
        zzat(5);
        return this.zzbur.zzul();
    }

    public final boolean zzum() throws IOException {
        zzat(0);
        return this.zzbur.zzum();
    }

    public final String readString() throws IOException {
        zzat(2);
        return this.zzbur.readString();
    }

    public final String zzun() throws IOException {
        zzat(2);
        return this.zzbur.zzun();
    }

    public final <T> T zza(zzxj<T> zzxj, zzuz zzuz) throws IOException {
        zzat(2);
        return zzc(zzxj, zzuz);
    }

    public final <T> T zzb(zzxj<T> zzxj, zzuz zzuz) throws IOException {
        zzat(3);
        return zzd(zzxj, zzuz);
    }

    private final <T> T zzc(zzxj<T> zzxj, zzuz zzuz) throws IOException {
        int zzup = this.zzbur.zzup();
        if (this.zzbur.zzbuh < this.zzbur.zzbui) {
            int zzaq = this.zzbur.zzaq(zzup);
            T newInstance = zzxj.newInstance();
            this.zzbur.zzbuh++;
            zzxj.zza(newInstance, this, zzuz);
            zzxj.zzu(newInstance);
            this.zzbur.zzan(0);
            this.zzbur.zzbuh--;
            this.zzbur.zzar(zzaq);
            return newInstance;
        }
        throw zzvt.zzwp();
    }

    private final <T> T zzd(zzxj<T> zzxj, zzuz zzuz) throws IOException {
        int i = this.zzbus;
        this.zzbus = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzxj.newInstance();
            zzxj.zza(newInstance, this, zzuz);
            zzxj.zzu(newInstance);
            if (this.tag == this.zzbus) {
                return newInstance;
            }
            throw zzvt.zzwq();
        } finally {
            this.zzbus = i;
        }
    }

    public final zzud zzuo() throws IOException {
        zzat(2);
        return this.zzbur.zzuo();
    }

    public final int zzup() throws IOException {
        zzat(0);
        return this.zzbur.zzup();
    }

    public final int zzuq() throws IOException {
        zzat(0);
        return this.zzbur.zzuq();
    }

    public final int zzur() throws IOException {
        zzat(5);
        return this.zzbur.zzur();
    }

    public final long zzus() throws IOException {
        zzat(1);
        return this.zzbur.zzus();
    }

    public final int zzut() throws IOException {
        zzat(0);
        return this.zzbur.zzut();
    }

    public final long zzuu() throws IOException {
        zzat(0);
        return this.zzbur.zzuu();
    }

    public final void zzh(List<Double> list) throws IOException {
        int zzug;
        int zzug2;
        if (list instanceof zzuw) {
            zzuw zzuw = (zzuw) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzuw.zzd(this.zzbur.readDouble());
                    if (!this.zzbur.zzuw()) {
                        zzug2 = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug2 == this.tag);
                this.zzbut = zzug2;
            } else if (i == 2) {
                int zzup = this.zzbur.zzup();
                zzau(zzup);
                int zzux = this.zzbur.zzux() + zzup;
                do {
                    zzuw.zzd(this.zzbur.readDouble());
                } while (this.zzbur.zzux() < zzux);
            } else {
                throw zzvt.zzwo();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zzbur.readDouble()));
                    if (!this.zzbur.zzuw()) {
                        zzug = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug == this.tag);
                this.zzbut = zzug;
            } else if (i2 == 2) {
                int zzup2 = this.zzbur.zzup();
                zzau(zzup2);
                int zzux2 = this.zzbur.zzux() + zzup2;
                do {
                    list.add(Double.valueOf(this.zzbur.readDouble()));
                } while (this.zzbur.zzux() < zzux2);
            } else {
                throw zzvt.zzwo();
            }
        }
    }

    public final void zzi(List<Float> list) throws IOException {
        int zzug;
        int zzug2;
        if (list instanceof zzvj) {
            zzvj zzvj = (zzvj) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzup = this.zzbur.zzup();
                zzav(zzup);
                int zzux = this.zzbur.zzux() + zzup;
                do {
                    zzvj.zzc(this.zzbur.readFloat());
                } while (this.zzbur.zzux() < zzux);
            } else if (i == 5) {
                do {
                    zzvj.zzc(this.zzbur.readFloat());
                    if (!this.zzbur.zzuw()) {
                        zzug2 = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug2 == this.tag);
                this.zzbut = zzug2;
            } else {
                throw zzvt.zzwo();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzup2 = this.zzbur.zzup();
                zzav(zzup2);
                int zzux2 = this.zzbur.zzux() + zzup2;
                do {
                    list.add(Float.valueOf(this.zzbur.readFloat()));
                } while (this.zzbur.zzux() < zzux2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzbur.readFloat()));
                    if (!this.zzbur.zzuw()) {
                        zzug = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug == this.tag);
                this.zzbut = zzug;
            } else {
                throw zzvt.zzwo();
            }
        }
    }

    public final void zzj(List<Long> list) throws IOException {
        int zzug;
        int zzug2;
        if (list instanceof zzwh) {
            zzwh zzwh = (zzwh) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzwh.zzbg(this.zzbur.zzuh());
                    if (!this.zzbur.zzuw()) {
                        zzug2 = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug2 == this.tag);
                this.zzbut = zzug2;
            } else if (i == 2) {
                int zzux = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    zzwh.zzbg(this.zzbur.zzuh());
                } while (this.zzbur.zzux() < zzux);
                zzaw(zzux);
            } else {
                throw zzvt.zzwo();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzbur.zzuh()));
                    if (!this.zzbur.zzuw()) {
                        zzug = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug == this.tag);
                this.zzbut = zzug;
            } else if (i2 == 2) {
                int zzux2 = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    list.add(Long.valueOf(this.zzbur.zzuh()));
                } while (this.zzbur.zzux() < zzux2);
                zzaw(zzux2);
            } else {
                throw zzvt.zzwo();
            }
        }
    }

    public final void zzk(List<Long> list) throws IOException {
        int zzug;
        int zzug2;
        if (list instanceof zzwh) {
            zzwh zzwh = (zzwh) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzwh.zzbg(this.zzbur.zzui());
                    if (!this.zzbur.zzuw()) {
                        zzug2 = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug2 == this.tag);
                this.zzbut = zzug2;
            } else if (i == 2) {
                int zzux = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    zzwh.zzbg(this.zzbur.zzui());
                } while (this.zzbur.zzux() < zzux);
                zzaw(zzux);
            } else {
                throw zzvt.zzwo();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzbur.zzui()));
                    if (!this.zzbur.zzuw()) {
                        zzug = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug == this.tag);
                this.zzbut = zzug;
            } else if (i2 == 2) {
                int zzux2 = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    list.add(Long.valueOf(this.zzbur.zzui()));
                } while (this.zzbur.zzux() < zzux2);
                zzaw(zzux2);
            } else {
                throw zzvt.zzwo();
            }
        }
    }

    public final void zzl(List<Integer> list) throws IOException {
        int zzug;
        int zzug2;
        if (list instanceof zzvn) {
            zzvn zzvn = (zzvn) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzvn.zzbm(this.zzbur.zzuj());
                    if (!this.zzbur.zzuw()) {
                        zzug2 = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug2 == this.tag);
                this.zzbut = zzug2;
            } else if (i == 2) {
                int zzux = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    zzvn.zzbm(this.zzbur.zzuj());
                } while (this.zzbur.zzux() < zzux);
                zzaw(zzux);
            } else {
                throw zzvt.zzwo();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzbur.zzuj()));
                    if (!this.zzbur.zzuw()) {
                        zzug = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug == this.tag);
                this.zzbut = zzug;
            } else if (i2 == 2) {
                int zzux2 = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    list.add(Integer.valueOf(this.zzbur.zzuj()));
                } while (this.zzbur.zzux() < zzux2);
                zzaw(zzux2);
            } else {
                throw zzvt.zzwo();
            }
        }
    }

    public final void zzm(List<Long> list) throws IOException {
        int zzug;
        int zzug2;
        if (list instanceof zzwh) {
            zzwh zzwh = (zzwh) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzwh.zzbg(this.zzbur.zzuk());
                    if (!this.zzbur.zzuw()) {
                        zzug2 = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug2 == this.tag);
                this.zzbut = zzug2;
            } else if (i == 2) {
                int zzup = this.zzbur.zzup();
                zzau(zzup);
                int zzux = this.zzbur.zzux() + zzup;
                do {
                    zzwh.zzbg(this.zzbur.zzuk());
                } while (this.zzbur.zzux() < zzux);
            } else {
                throw zzvt.zzwo();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzbur.zzuk()));
                    if (!this.zzbur.zzuw()) {
                        zzug = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug == this.tag);
                this.zzbut = zzug;
            } else if (i2 == 2) {
                int zzup2 = this.zzbur.zzup();
                zzau(zzup2);
                int zzux2 = this.zzbur.zzux() + zzup2;
                do {
                    list.add(Long.valueOf(this.zzbur.zzuk()));
                } while (this.zzbur.zzux() < zzux2);
            } else {
                throw zzvt.zzwo();
            }
        }
    }

    public final void zzn(List<Integer> list) throws IOException {
        int zzug;
        int zzug2;
        if (list instanceof zzvn) {
            zzvn zzvn = (zzvn) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzup = this.zzbur.zzup();
                zzav(zzup);
                int zzux = this.zzbur.zzux() + zzup;
                do {
                    zzvn.zzbm(this.zzbur.zzul());
                } while (this.zzbur.zzux() < zzux);
            } else if (i == 5) {
                do {
                    zzvn.zzbm(this.zzbur.zzul());
                    if (!this.zzbur.zzuw()) {
                        zzug2 = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug2 == this.tag);
                this.zzbut = zzug2;
            } else {
                throw zzvt.zzwo();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzup2 = this.zzbur.zzup();
                zzav(zzup2);
                int zzux2 = this.zzbur.zzux() + zzup2;
                do {
                    list.add(Integer.valueOf(this.zzbur.zzul()));
                } while (this.zzbur.zzux() < zzux2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzbur.zzul()));
                    if (!this.zzbur.zzuw()) {
                        zzug = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug == this.tag);
                this.zzbut = zzug;
            } else {
                throw zzvt.zzwo();
            }
        }
    }

    public final void zzo(List<Boolean> list) throws IOException {
        int zzug;
        int zzug2;
        if (list instanceof zzub) {
            zzub zzub = (zzub) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzub.addBoolean(this.zzbur.zzum());
                    if (!this.zzbur.zzuw()) {
                        zzug2 = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug2 == this.tag);
                this.zzbut = zzug2;
            } else if (i == 2) {
                int zzux = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    zzub.addBoolean(this.zzbur.zzum());
                } while (this.zzbur.zzux() < zzux);
                zzaw(zzux);
            } else {
                throw zzvt.zzwo();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzbur.zzum()));
                    if (!this.zzbur.zzuw()) {
                        zzug = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug == this.tag);
                this.zzbut = zzug;
            } else if (i2 == 2) {
                int zzux2 = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    list.add(Boolean.valueOf(this.zzbur.zzum()));
                } while (this.zzbur.zzux() < zzux2);
                zzaw(zzux2);
            } else {
                throw zzvt.zzwo();
            }
        }
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzp(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzug;
        int zzug2;
        if ((this.tag & 7) != 2) {
            throw zzvt.zzwo();
        } else if (!(list instanceof zzwc) || z) {
            do {
                list.add(z ? zzun() : readString());
                if (!this.zzbur.zzuw()) {
                    zzug = this.zzbur.zzug();
                } else {
                    return;
                }
            } while (zzug == this.tag);
            this.zzbut = zzug;
        } else {
            zzwc zzwc = (zzwc) list;
            do {
                zzwc.zzc(zzuo());
                if (!this.zzbur.zzuw()) {
                    zzug2 = this.zzbur.zzug();
                } else {
                    return;
                }
            } while (zzug2 == this.tag);
            this.zzbut = zzug2;
        }
    }

    public final <T> void zza(List<T> list, zzxj<T> zzxj, zzuz zzuz) throws IOException {
        int zzug;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzxj, zzuz));
                if (!this.zzbur.zzuw() && this.zzbut == 0) {
                    zzug = this.zzbur.zzug();
                } else {
                    return;
                }
            } while (zzug == i);
            this.zzbut = zzug;
            return;
        }
        throw zzvt.zzwo();
    }

    public final <T> void zzb(List<T> list, zzxj<T> zzxj, zzuz zzuz) throws IOException {
        int zzug;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzxj, zzuz));
                if (!this.zzbur.zzuw() && this.zzbut == 0) {
                    zzug = this.zzbur.zzug();
                } else {
                    return;
                }
            } while (zzug == i);
            this.zzbut = zzug;
            return;
        }
        throw zzvt.zzwo();
    }

    public final void zzq(List<zzud> list) throws IOException {
        int zzug;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzuo());
                if (!this.zzbur.zzuw()) {
                    zzug = this.zzbur.zzug();
                } else {
                    return;
                }
            } while (zzug == this.tag);
            this.zzbut = zzug;
            return;
        }
        throw zzvt.zzwo();
    }

    public final void zzr(List<Integer> list) throws IOException {
        int zzug;
        int zzug2;
        if (list instanceof zzvn) {
            zzvn zzvn = (zzvn) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzvn.zzbm(this.zzbur.zzup());
                    if (!this.zzbur.zzuw()) {
                        zzug2 = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug2 == this.tag);
                this.zzbut = zzug2;
            } else if (i == 2) {
                int zzux = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    zzvn.zzbm(this.zzbur.zzup());
                } while (this.zzbur.zzux() < zzux);
                zzaw(zzux);
            } else {
                throw zzvt.zzwo();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzbur.zzup()));
                    if (!this.zzbur.zzuw()) {
                        zzug = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug == this.tag);
                this.zzbut = zzug;
            } else if (i2 == 2) {
                int zzux2 = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    list.add(Integer.valueOf(this.zzbur.zzup()));
                } while (this.zzbur.zzux() < zzux2);
                zzaw(zzux2);
            } else {
                throw zzvt.zzwo();
            }
        }
    }

    public final void zzs(List<Integer> list) throws IOException {
        int zzug;
        int zzug2;
        if (list instanceof zzvn) {
            zzvn zzvn = (zzvn) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzvn.zzbm(this.zzbur.zzuq());
                    if (!this.zzbur.zzuw()) {
                        zzug2 = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug2 == this.tag);
                this.zzbut = zzug2;
            } else if (i == 2) {
                int zzux = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    zzvn.zzbm(this.zzbur.zzuq());
                } while (this.zzbur.zzux() < zzux);
                zzaw(zzux);
            } else {
                throw zzvt.zzwo();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzbur.zzuq()));
                    if (!this.zzbur.zzuw()) {
                        zzug = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug == this.tag);
                this.zzbut = zzug;
            } else if (i2 == 2) {
                int zzux2 = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    list.add(Integer.valueOf(this.zzbur.zzuq()));
                } while (this.zzbur.zzux() < zzux2);
                zzaw(zzux2);
            } else {
                throw zzvt.zzwo();
            }
        }
    }

    public final void zzt(List<Integer> list) throws IOException {
        int zzug;
        int zzug2;
        if (list instanceof zzvn) {
            zzvn zzvn = (zzvn) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzup = this.zzbur.zzup();
                zzav(zzup);
                int zzux = this.zzbur.zzux() + zzup;
                do {
                    zzvn.zzbm(this.zzbur.zzur());
                } while (this.zzbur.zzux() < zzux);
            } else if (i == 5) {
                do {
                    zzvn.zzbm(this.zzbur.zzur());
                    if (!this.zzbur.zzuw()) {
                        zzug2 = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug2 == this.tag);
                this.zzbut = zzug2;
            } else {
                throw zzvt.zzwo();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzup2 = this.zzbur.zzup();
                zzav(zzup2);
                int zzux2 = this.zzbur.zzux() + zzup2;
                do {
                    list.add(Integer.valueOf(this.zzbur.zzur()));
                } while (this.zzbur.zzux() < zzux2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzbur.zzur()));
                    if (!this.zzbur.zzuw()) {
                        zzug = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug == this.tag);
                this.zzbut = zzug;
            } else {
                throw zzvt.zzwo();
            }
        }
    }

    public final void zzu(List<Long> list) throws IOException {
        int zzug;
        int zzug2;
        if (list instanceof zzwh) {
            zzwh zzwh = (zzwh) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzwh.zzbg(this.zzbur.zzus());
                    if (!this.zzbur.zzuw()) {
                        zzug2 = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug2 == this.tag);
                this.zzbut = zzug2;
            } else if (i == 2) {
                int zzup = this.zzbur.zzup();
                zzau(zzup);
                int zzux = this.zzbur.zzux() + zzup;
                do {
                    zzwh.zzbg(this.zzbur.zzus());
                } while (this.zzbur.zzux() < zzux);
            } else {
                throw zzvt.zzwo();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzbur.zzus()));
                    if (!this.zzbur.zzuw()) {
                        zzug = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug == this.tag);
                this.zzbut = zzug;
            } else if (i2 == 2) {
                int zzup2 = this.zzbur.zzup();
                zzau(zzup2);
                int zzux2 = this.zzbur.zzux() + zzup2;
                do {
                    list.add(Long.valueOf(this.zzbur.zzus()));
                } while (this.zzbur.zzux() < zzux2);
            } else {
                throw zzvt.zzwo();
            }
        }
    }

    public final void zzv(List<Integer> list) throws IOException {
        int zzug;
        int zzug2;
        if (list instanceof zzvn) {
            zzvn zzvn = (zzvn) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzvn.zzbm(this.zzbur.zzut());
                    if (!this.zzbur.zzuw()) {
                        zzug2 = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug2 == this.tag);
                this.zzbut = zzug2;
            } else if (i == 2) {
                int zzux = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    zzvn.zzbm(this.zzbur.zzut());
                } while (this.zzbur.zzux() < zzux);
                zzaw(zzux);
            } else {
                throw zzvt.zzwo();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzbur.zzut()));
                    if (!this.zzbur.zzuw()) {
                        zzug = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug == this.tag);
                this.zzbut = zzug;
            } else if (i2 == 2) {
                int zzux2 = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    list.add(Integer.valueOf(this.zzbur.zzut()));
                } while (this.zzbur.zzux() < zzux2);
                zzaw(zzux2);
            } else {
                throw zzvt.zzwo();
            }
        }
    }

    public final void zzw(List<Long> list) throws IOException {
        int zzug;
        int zzug2;
        if (list instanceof zzwh) {
            zzwh zzwh = (zzwh) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzwh.zzbg(this.zzbur.zzuu());
                    if (!this.zzbur.zzuw()) {
                        zzug2 = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug2 == this.tag);
                this.zzbut = zzug2;
            } else if (i == 2) {
                int zzux = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    zzwh.zzbg(this.zzbur.zzuu());
                } while (this.zzbur.zzux() < zzux);
                zzaw(zzux);
            } else {
                throw zzvt.zzwo();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzbur.zzuu()));
                    if (!this.zzbur.zzuw()) {
                        zzug = this.zzbur.zzug();
                    } else {
                        return;
                    }
                } while (zzug == this.tag);
                this.zzbut = zzug;
            } else if (i2 == 2) {
                int zzux2 = this.zzbur.zzux() + this.zzbur.zzup();
                do {
                    list.add(Long.valueOf(this.zzbur.zzuu()));
                } while (this.zzbur.zzux() < zzux2);
                zzaw(zzux2);
            } else {
                throw zzvt.zzwo();
            }
        }
    }

    private static void zzau(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzvt.zzwq();
        }
    }

    public final <K, V> void zza(Map<K, V> map, zzwm<K, V> zzwm, zzuz zzuz) throws IOException {
        String str;
        zzat(2);
        int zzaq = this.zzbur.zzaq(this.zzbur.zzup());
        K k = zzwm.zzcas;
        V v = zzwm.zzbre;
        while (true) {
            try {
                int zzve = zzve();
                if (zzve == Integer.MAX_VALUE || this.zzbur.zzuw()) {
                    map.put(k, v);
                } else {
                    str = "Unable to parse map entry.";
                    if (zzve == 1) {
                        k = zza(zzwm.zzcar, null, (zzuz) null);
                    } else if (zzve == 2) {
                        v = zza(zzwm.zzcat, zzwm.zzbre.getClass(), zzuz);
                    } else if (!zzvf()) {
                        throw new zzvt(str);
                    }
                }
            } catch (zzvu e) {
                if (!zzvf()) {
                    throw new zzvt(str);
                }
            } catch (Throwable th) {
                this.zzbur.zzar(zzaq);
                throw th;
            }
        }
        map.put(k, v);
        this.zzbur.zzar(zzaq);
    }

    private final Object zza(zzyq zzyq, Class<?> cls, zzuz zzuz) throws IOException {
        switch (zzyq) {
            case BOOL:
                return Boolean.valueOf(zzum());
            case BYTES:
                return zzuo();
            case DOUBLE:
                return Double.valueOf(readDouble());
            case ENUM:
                return Integer.valueOf(zzuq());
            case FIXED32:
                return Integer.valueOf(zzul());
            case FIXED64:
                return Long.valueOf(zzuk());
            case FLOAT:
                return Float.valueOf(readFloat());
            case INT32:
                return Integer.valueOf(zzuj());
            case INT64:
                return Long.valueOf(zzui());
            case MESSAGE:
                zzat(2);
                return zzc(zzxf.zzxn().zzi(cls), zzuz);
            case SFIXED32:
                return Integer.valueOf(zzur());
            case SFIXED64:
                return Long.valueOf(zzus());
            case SINT32:
                return Integer.valueOf(zzut());
            case SINT64:
                return Long.valueOf(zzuu());
            case STRING:
                return zzun();
            case UINT32:
                return Integer.valueOf(zzup());
            case UINT64:
                return Long.valueOf(zzuh());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzav(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzvt.zzwq();
        }
    }

    private final void zzaw(int i) throws IOException {
        if (this.zzbur.zzux() != i) {
            throw zzvt.zzwk();
        }
    }
}
