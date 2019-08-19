package com.google.android.gms.measurement.internal;

final class zzaq implements Runnable {
    private final /* synthetic */ int zzamh;
    private final /* synthetic */ String zzami;
    private final /* synthetic */ Object zzamj;
    private final /* synthetic */ Object zzamk;
    private final /* synthetic */ Object zzaml;
    private final /* synthetic */ zzap zzamm;

    zzaq(zzap zzap, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzamm = zzap;
        this.zzamh = i;
        this.zzami = str;
        this.zzamj = obj;
        this.zzamk = obj2;
        this.zzaml = obj3;
    }

    public final void run() {
        zzba zzgp = this.zzamm.zzadj.zzgp();
        if (!zzgp.isInitialized()) {
            this.zzamm.zza(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        if (this.zzamm.zzalw == 0) {
            if (this.zzamm.zzgq().zzdw()) {
                zzap zzap = this.zzamm;
                zzap.zzgr();
                zzap.zzalw = 'C';
            } else {
                zzap zzap2 = this.zzamm;
                zzap2.zzgr();
                zzap2.zzalw = 'c';
            }
        }
        if (this.zzamm.zzadt < 0) {
            zzap zzap3 = this.zzamm;
            zzap3.zzadt = zzap3.zzgq().zzhc();
        }
        char charAt = "01VDIWEA?".charAt(this.zzamh);
        char zza = this.zzamm.zzalw;
        long zzb = this.zzamm.zzadt;
        String zza2 = zzap.zza(true, this.zzami, this.zzamj, this.zzamk, this.zzaml);
        StringBuilder sb = new StringBuilder(String.valueOf(zza2).length() + 24);
        sb.append("2");
        sb.append(charAt);
        sb.append(zza);
        sb.append(zzb);
        sb.append(":");
        sb.append(zza2);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.zzami.substring(0, 1024);
        }
        zzgp.zzand.zzc(sb2, 1);
    }
}
