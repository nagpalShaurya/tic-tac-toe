package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfq.zzb;
import java.io.IOException;

public final class zzgi extends zzza<zzgi> {
    private static volatile zzgi[] zzawz;
    public String zzafw;
    public String zzafx;
    public String zzafz;
    public String zzage;
    public String zzagv;
    public String zzaia;
    public String zzawj;
    public Integer zzaxa;
    public zzgf[] zzaxb;
    public zzgl[] zzaxc;
    public Long zzaxd;
    public Long zzaxe;
    public Long zzaxf;
    public Long zzaxg;
    public Long zzaxh;
    public String zzaxi;
    public String zzaxj;
    public String zzaxk;
    public Integer zzaxl;
    public Long zzaxm;
    public Long zzaxn;
    public String zzaxo;
    public Boolean zzaxp;
    public Long zzaxq;
    public Integer zzaxr;
    public Boolean zzaxs;
    public zzgd[] zzaxt;
    public Integer zzaxu;
    private Integer zzaxv;
    private Integer zzaxw;
    public String zzaxx;
    public Long zzaxy;
    public Long zzaxz;
    public String zzaya;
    private String zzayb;
    public Integer zzayc;
    private zzb zzayd;
    public String zzts;
    public String zztt;

    public static zzgi[] zzms() {
        if (zzawz == null) {
            synchronized (zzze.zzcfl) {
                if (zzawz == null) {
                    zzawz = new zzgi[0];
                }
            }
        }
        return zzawz;
    }

    public zzgi() {
        this.zzaxa = null;
        this.zzaxb = zzgf.zzmq();
        this.zzaxc = zzgl.zzmu();
        this.zzaxd = null;
        this.zzaxe = null;
        this.zzaxf = null;
        this.zzaxg = null;
        this.zzaxh = null;
        this.zzaxi = null;
        this.zzaxj = null;
        this.zzaxk = null;
        this.zzaia = null;
        this.zzaxl = null;
        this.zzage = null;
        this.zztt = null;
        this.zzts = null;
        this.zzaxm = null;
        this.zzaxn = null;
        this.zzaxo = null;
        this.zzaxp = null;
        this.zzafw = null;
        this.zzaxq = null;
        this.zzaxr = null;
        this.zzagv = null;
        this.zzafx = null;
        this.zzaxs = null;
        this.zzaxt = zzgd.zzmo();
        this.zzafz = null;
        this.zzaxu = null;
        this.zzaxv = null;
        this.zzaxw = null;
        this.zzaxx = null;
        this.zzaxy = null;
        this.zzaxz = null;
        this.zzaya = null;
        this.zzayb = null;
        this.zzayc = null;
        this.zzawj = null;
        this.zzayd = null;
        this.zzcfc = null;
        this.zzcfm = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgi)) {
            return false;
        }
        zzgi zzgi = (zzgi) obj;
        Integer num = this.zzaxa;
        if (num == null) {
            if (zzgi.zzaxa != null) {
                return false;
            }
        } else if (!num.equals(zzgi.zzaxa)) {
            return false;
        }
        if (!zzze.equals((Object[]) this.zzaxb, (Object[]) zzgi.zzaxb) || !zzze.equals((Object[]) this.zzaxc, (Object[]) zzgi.zzaxc)) {
            return false;
        }
        Long l = this.zzaxd;
        if (l == null) {
            if (zzgi.zzaxd != null) {
                return false;
            }
        } else if (!l.equals(zzgi.zzaxd)) {
            return false;
        }
        Long l2 = this.zzaxe;
        if (l2 == null) {
            if (zzgi.zzaxe != null) {
                return false;
            }
        } else if (!l2.equals(zzgi.zzaxe)) {
            return false;
        }
        Long l3 = this.zzaxf;
        if (l3 == null) {
            if (zzgi.zzaxf != null) {
                return false;
            }
        } else if (!l3.equals(zzgi.zzaxf)) {
            return false;
        }
        Long l4 = this.zzaxg;
        if (l4 == null) {
            if (zzgi.zzaxg != null) {
                return false;
            }
        } else if (!l4.equals(zzgi.zzaxg)) {
            return false;
        }
        Long l5 = this.zzaxh;
        if (l5 == null) {
            if (zzgi.zzaxh != null) {
                return false;
            }
        } else if (!l5.equals(zzgi.zzaxh)) {
            return false;
        }
        String str = this.zzaxi;
        if (str == null) {
            if (zzgi.zzaxi != null) {
                return false;
            }
        } else if (!str.equals(zzgi.zzaxi)) {
            return false;
        }
        String str2 = this.zzaxj;
        if (str2 == null) {
            if (zzgi.zzaxj != null) {
                return false;
            }
        } else if (!str2.equals(zzgi.zzaxj)) {
            return false;
        }
        String str3 = this.zzaxk;
        if (str3 == null) {
            if (zzgi.zzaxk != null) {
                return false;
            }
        } else if (!str3.equals(zzgi.zzaxk)) {
            return false;
        }
        String str4 = this.zzaia;
        if (str4 == null) {
            if (zzgi.zzaia != null) {
                return false;
            }
        } else if (!str4.equals(zzgi.zzaia)) {
            return false;
        }
        Integer num2 = this.zzaxl;
        if (num2 == null) {
            if (zzgi.zzaxl != null) {
                return false;
            }
        } else if (!num2.equals(zzgi.zzaxl)) {
            return false;
        }
        String str5 = this.zzage;
        if (str5 == null) {
            if (zzgi.zzage != null) {
                return false;
            }
        } else if (!str5.equals(zzgi.zzage)) {
            return false;
        }
        String str6 = this.zztt;
        if (str6 == null) {
            if (zzgi.zztt != null) {
                return false;
            }
        } else if (!str6.equals(zzgi.zztt)) {
            return false;
        }
        String str7 = this.zzts;
        if (str7 == null) {
            if (zzgi.zzts != null) {
                return false;
            }
        } else if (!str7.equals(zzgi.zzts)) {
            return false;
        }
        Long l6 = this.zzaxm;
        if (l6 == null) {
            if (zzgi.zzaxm != null) {
                return false;
            }
        } else if (!l6.equals(zzgi.zzaxm)) {
            return false;
        }
        Long l7 = this.zzaxn;
        if (l7 == null) {
            if (zzgi.zzaxn != null) {
                return false;
            }
        } else if (!l7.equals(zzgi.zzaxn)) {
            return false;
        }
        String str8 = this.zzaxo;
        if (str8 == null) {
            if (zzgi.zzaxo != null) {
                return false;
            }
        } else if (!str8.equals(zzgi.zzaxo)) {
            return false;
        }
        Boolean bool = this.zzaxp;
        if (bool == null) {
            if (zzgi.zzaxp != null) {
                return false;
            }
        } else if (!bool.equals(zzgi.zzaxp)) {
            return false;
        }
        String str9 = this.zzafw;
        if (str9 == null) {
            if (zzgi.zzafw != null) {
                return false;
            }
        } else if (!str9.equals(zzgi.zzafw)) {
            return false;
        }
        Long l8 = this.zzaxq;
        if (l8 == null) {
            if (zzgi.zzaxq != null) {
                return false;
            }
        } else if (!l8.equals(zzgi.zzaxq)) {
            return false;
        }
        Integer num3 = this.zzaxr;
        if (num3 == null) {
            if (zzgi.zzaxr != null) {
                return false;
            }
        } else if (!num3.equals(zzgi.zzaxr)) {
            return false;
        }
        String str10 = this.zzagv;
        if (str10 == null) {
            if (zzgi.zzagv != null) {
                return false;
            }
        } else if (!str10.equals(zzgi.zzagv)) {
            return false;
        }
        String str11 = this.zzafx;
        if (str11 == null) {
            if (zzgi.zzafx != null) {
                return false;
            }
        } else if (!str11.equals(zzgi.zzafx)) {
            return false;
        }
        Boolean bool2 = this.zzaxs;
        if (bool2 == null) {
            if (zzgi.zzaxs != null) {
                return false;
            }
        } else if (!bool2.equals(zzgi.zzaxs)) {
            return false;
        }
        if (!zzze.equals((Object[]) this.zzaxt, (Object[]) zzgi.zzaxt)) {
            return false;
        }
        String str12 = this.zzafz;
        if (str12 == null) {
            if (zzgi.zzafz != null) {
                return false;
            }
        } else if (!str12.equals(zzgi.zzafz)) {
            return false;
        }
        Integer num4 = this.zzaxu;
        if (num4 == null) {
            if (zzgi.zzaxu != null) {
                return false;
            }
        } else if (!num4.equals(zzgi.zzaxu)) {
            return false;
        }
        Integer num5 = this.zzaxv;
        if (num5 == null) {
            if (zzgi.zzaxv != null) {
                return false;
            }
        } else if (!num5.equals(zzgi.zzaxv)) {
            return false;
        }
        Integer num6 = this.zzaxw;
        if (num6 == null) {
            if (zzgi.zzaxw != null) {
                return false;
            }
        } else if (!num6.equals(zzgi.zzaxw)) {
            return false;
        }
        String str13 = this.zzaxx;
        if (str13 == null) {
            if (zzgi.zzaxx != null) {
                return false;
            }
        } else if (!str13.equals(zzgi.zzaxx)) {
            return false;
        }
        Long l9 = this.zzaxy;
        if (l9 == null) {
            if (zzgi.zzaxy != null) {
                return false;
            }
        } else if (!l9.equals(zzgi.zzaxy)) {
            return false;
        }
        Long l10 = this.zzaxz;
        if (l10 == null) {
            if (zzgi.zzaxz != null) {
                return false;
            }
        } else if (!l10.equals(zzgi.zzaxz)) {
            return false;
        }
        String str14 = this.zzaya;
        if (str14 == null) {
            if (zzgi.zzaya != null) {
                return false;
            }
        } else if (!str14.equals(zzgi.zzaya)) {
            return false;
        }
        String str15 = this.zzayb;
        if (str15 == null) {
            if (zzgi.zzayb != null) {
                return false;
            }
        } else if (!str15.equals(zzgi.zzayb)) {
            return false;
        }
        Integer num7 = this.zzayc;
        if (num7 == null) {
            if (zzgi.zzayc != null) {
                return false;
            }
        } else if (!num7.equals(zzgi.zzayc)) {
            return false;
        }
        String str16 = this.zzawj;
        if (str16 == null) {
            if (zzgi.zzawj != null) {
                return false;
            }
        } else if (!str16.equals(zzgi.zzawj)) {
            return false;
        }
        zzb zzb = this.zzayd;
        if (zzb == null) {
            if (zzgi.zzayd != null) {
                return false;
            }
        } else if (!zzb.equals(zzgi.zzayd)) {
            return false;
        }
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            return this.zzcfc.equals(zzgi.zzcfc);
        }
        if (zzgi.zzcfc == null || zzgi.zzcfc.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        Integer num = this.zzaxa;
        int i = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + zzze.hashCode((Object[]) this.zzaxb)) * 31) + zzze.hashCode((Object[]) this.zzaxc)) * 31;
        Long l = this.zzaxd;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.zzaxe;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.zzaxf;
        int hashCode5 = (hashCode4 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.zzaxg;
        int hashCode6 = (hashCode5 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.zzaxh;
        int hashCode7 = (hashCode6 + (l5 == null ? 0 : l5.hashCode())) * 31;
        String str = this.zzaxi;
        int hashCode8 = (hashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.zzaxj;
        int hashCode9 = (hashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.zzaxk;
        int hashCode10 = (hashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.zzaia;
        int hashCode11 = (hashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num2 = this.zzaxl;
        int hashCode12 = (hashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.zzage;
        int hashCode13 = (hashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.zztt;
        int hashCode14 = (hashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.zzts;
        int hashCode15 = (hashCode14 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l6 = this.zzaxm;
        int hashCode16 = (hashCode15 + (l6 == null ? 0 : l6.hashCode())) * 31;
        Long l7 = this.zzaxn;
        int hashCode17 = (hashCode16 + (l7 == null ? 0 : l7.hashCode())) * 31;
        String str8 = this.zzaxo;
        int hashCode18 = (hashCode17 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool = this.zzaxp;
        int hashCode19 = (hashCode18 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str9 = this.zzafw;
        int hashCode20 = (hashCode19 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Long l8 = this.zzaxq;
        int hashCode21 = (hashCode20 + (l8 == null ? 0 : l8.hashCode())) * 31;
        Integer num3 = this.zzaxr;
        int hashCode22 = (hashCode21 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str10 = this.zzagv;
        int hashCode23 = (hashCode22 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.zzafx;
        int hashCode24 = (hashCode23 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Boolean bool2 = this.zzaxs;
        int hashCode25 = (((hashCode24 + (bool2 == null ? 0 : bool2.hashCode())) * 31) + zzze.hashCode((Object[]) this.zzaxt)) * 31;
        String str12 = this.zzafz;
        int hashCode26 = (hashCode25 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Integer num4 = this.zzaxu;
        int hashCode27 = (hashCode26 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.zzaxv;
        int hashCode28 = (hashCode27 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.zzaxw;
        int hashCode29 = (hashCode28 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str13 = this.zzaxx;
        int hashCode30 = (hashCode29 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Long l9 = this.zzaxy;
        int hashCode31 = (hashCode30 + (l9 == null ? 0 : l9.hashCode())) * 31;
        Long l10 = this.zzaxz;
        int hashCode32 = (hashCode31 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str14 = this.zzaya;
        int hashCode33 = (hashCode32 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.zzayb;
        int hashCode34 = (hashCode33 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Integer num7 = this.zzayc;
        int hashCode35 = (hashCode34 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str16 = this.zzawj;
        int hashCode36 = hashCode35 + (str16 == null ? 0 : str16.hashCode());
        zzb zzb = this.zzayd;
        int hashCode37 = ((hashCode36 * 31) + (zzb == null ? 0 : zzb.hashCode())) * 31;
        if (this.zzcfc != null && !this.zzcfc.isEmpty()) {
            i = this.zzcfc.hashCode();
        }
        return hashCode37 + i;
    }

    public final void zza(zzyy zzyy) throws IOException {
        Integer num = this.zzaxa;
        if (num != null) {
            zzyy.zzd(1, num.intValue());
        }
        zzgf[] zzgfArr = this.zzaxb;
        int i = 0;
        if (zzgfArr != null && zzgfArr.length > 0) {
            int i2 = 0;
            while (true) {
                zzgf[] zzgfArr2 = this.zzaxb;
                if (i2 >= zzgfArr2.length) {
                    break;
                }
                zzgf zzgf = zzgfArr2[i2];
                if (zzgf != null) {
                    zzyy.zza(2, (zzzg) zzgf);
                }
                i2++;
            }
        }
        zzgl[] zzglArr = this.zzaxc;
        if (zzglArr != null && zzglArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzgl[] zzglArr2 = this.zzaxc;
                if (i3 >= zzglArr2.length) {
                    break;
                }
                zzgl zzgl = zzglArr2[i3];
                if (zzgl != null) {
                    zzyy.zza(3, (zzzg) zzgl);
                }
                i3++;
            }
        }
        Long l = this.zzaxd;
        if (l != null) {
            zzyy.zzi(4, l.longValue());
        }
        Long l2 = this.zzaxe;
        if (l2 != null) {
            zzyy.zzi(5, l2.longValue());
        }
        Long l3 = this.zzaxf;
        if (l3 != null) {
            zzyy.zzi(6, l3.longValue());
        }
        Long l4 = this.zzaxh;
        if (l4 != null) {
            zzyy.zzi(7, l4.longValue());
        }
        String str = this.zzaxi;
        if (str != null) {
            zzyy.zzb(8, str);
        }
        String str2 = this.zzaxj;
        if (str2 != null) {
            zzyy.zzb(9, str2);
        }
        String str3 = this.zzaxk;
        if (str3 != null) {
            zzyy.zzb(10, str3);
        }
        String str4 = this.zzaia;
        if (str4 != null) {
            zzyy.zzb(11, str4);
        }
        Integer num2 = this.zzaxl;
        if (num2 != null) {
            zzyy.zzd(12, num2.intValue());
        }
        String str5 = this.zzage;
        if (str5 != null) {
            zzyy.zzb(13, str5);
        }
        String str6 = this.zztt;
        if (str6 != null) {
            zzyy.zzb(14, str6);
        }
        String str7 = this.zzts;
        if (str7 != null) {
            zzyy.zzb(16, str7);
        }
        Long l5 = this.zzaxm;
        if (l5 != null) {
            zzyy.zzi(17, l5.longValue());
        }
        Long l6 = this.zzaxn;
        if (l6 != null) {
            zzyy.zzi(18, l6.longValue());
        }
        String str8 = this.zzaxo;
        if (str8 != null) {
            zzyy.zzb(19, str8);
        }
        Boolean bool = this.zzaxp;
        if (bool != null) {
            zzyy.zzb(20, bool.booleanValue());
        }
        String str9 = this.zzafw;
        if (str9 != null) {
            zzyy.zzb(21, str9);
        }
        Long l7 = this.zzaxq;
        if (l7 != null) {
            zzyy.zzi(22, l7.longValue());
        }
        Integer num3 = this.zzaxr;
        if (num3 != null) {
            zzyy.zzd(23, num3.intValue());
        }
        String str10 = this.zzagv;
        if (str10 != null) {
            zzyy.zzb(24, str10);
        }
        String str11 = this.zzafx;
        if (str11 != null) {
            zzyy.zzb(25, str11);
        }
        Long l8 = this.zzaxg;
        if (l8 != null) {
            zzyy.zzi(26, l8.longValue());
        }
        Boolean bool2 = this.zzaxs;
        if (bool2 != null) {
            zzyy.zzb(28, bool2.booleanValue());
        }
        zzgd[] zzgdArr = this.zzaxt;
        if (zzgdArr != null && zzgdArr.length > 0) {
            while (true) {
                zzgd[] zzgdArr2 = this.zzaxt;
                if (i >= zzgdArr2.length) {
                    break;
                }
                zzgd zzgd = zzgdArr2[i];
                if (zzgd != null) {
                    zzyy.zza(29, (zzzg) zzgd);
                }
                i++;
            }
        }
        String str12 = this.zzafz;
        if (str12 != null) {
            zzyy.zzb(30, str12);
        }
        Integer num4 = this.zzaxu;
        if (num4 != null) {
            zzyy.zzd(31, num4.intValue());
        }
        Integer num5 = this.zzaxv;
        if (num5 != null) {
            zzyy.zzd(32, num5.intValue());
        }
        Integer num6 = this.zzaxw;
        if (num6 != null) {
            zzyy.zzd(33, num6.intValue());
        }
        String str13 = this.zzaxx;
        if (str13 != null) {
            zzyy.zzb(34, str13);
        }
        Long l9 = this.zzaxy;
        if (l9 != null) {
            zzyy.zzi(35, l9.longValue());
        }
        Long l10 = this.zzaxz;
        if (l10 != null) {
            zzyy.zzi(36, l10.longValue());
        }
        String str14 = this.zzaya;
        if (str14 != null) {
            zzyy.zzb(37, str14);
        }
        String str15 = this.zzayb;
        if (str15 != null) {
            zzyy.zzb(38, str15);
        }
        Integer num7 = this.zzayc;
        if (num7 != null) {
            zzyy.zzd(39, num7.intValue());
        }
        String str16 = this.zzawj;
        if (str16 != null) {
            zzyy.zzb(41, str16);
        }
        zzb zzb = this.zzayd;
        if (zzb != null) {
            zzyy.zze(44, zzb);
        }
        super.zza(zzyy);
    }

    /* access modifiers changed from: protected */
    public final int zzf() {
        int zzf = super.zzf();
        Integer num = this.zzaxa;
        if (num != null) {
            zzf += zzyy.zzh(1, num.intValue());
        }
        zzgf[] zzgfArr = this.zzaxb;
        int i = 0;
        if (zzgfArr != null && zzgfArr.length > 0) {
            int i2 = zzf;
            int i3 = 0;
            while (true) {
                zzgf[] zzgfArr2 = this.zzaxb;
                if (i3 >= zzgfArr2.length) {
                    break;
                }
                zzgf zzgf = zzgfArr2[i3];
                if (zzgf != null) {
                    i2 += zzyy.zzb(2, (zzzg) zzgf);
                }
                i3++;
            }
            zzf = i2;
        }
        zzgl[] zzglArr = this.zzaxc;
        if (zzglArr != null && zzglArr.length > 0) {
            int i4 = zzf;
            int i5 = 0;
            while (true) {
                zzgl[] zzglArr2 = this.zzaxc;
                if (i5 >= zzglArr2.length) {
                    break;
                }
                zzgl zzgl = zzglArr2[i5];
                if (zzgl != null) {
                    i4 += zzyy.zzb(3, (zzzg) zzgl);
                }
                i5++;
            }
            zzf = i4;
        }
        Long l = this.zzaxd;
        if (l != null) {
            zzf += zzyy.zzd(4, l.longValue());
        }
        Long l2 = this.zzaxe;
        if (l2 != null) {
            zzf += zzyy.zzd(5, l2.longValue());
        }
        Long l3 = this.zzaxf;
        if (l3 != null) {
            zzf += zzyy.zzd(6, l3.longValue());
        }
        Long l4 = this.zzaxh;
        if (l4 != null) {
            zzf += zzyy.zzd(7, l4.longValue());
        }
        String str = this.zzaxi;
        if (str != null) {
            zzf += zzyy.zzc(8, str);
        }
        String str2 = this.zzaxj;
        if (str2 != null) {
            zzf += zzyy.zzc(9, str2);
        }
        String str3 = this.zzaxk;
        if (str3 != null) {
            zzf += zzyy.zzc(10, str3);
        }
        String str4 = this.zzaia;
        if (str4 != null) {
            zzf += zzyy.zzc(11, str4);
        }
        Integer num2 = this.zzaxl;
        if (num2 != null) {
            zzf += zzyy.zzh(12, num2.intValue());
        }
        String str5 = this.zzage;
        if (str5 != null) {
            zzf += zzyy.zzc(13, str5);
        }
        String str6 = this.zztt;
        if (str6 != null) {
            zzf += zzyy.zzc(14, str6);
        }
        String str7 = this.zzts;
        if (str7 != null) {
            zzf += zzyy.zzc(16, str7);
        }
        Long l5 = this.zzaxm;
        if (l5 != null) {
            zzf += zzyy.zzd(17, l5.longValue());
        }
        Long l6 = this.zzaxn;
        if (l6 != null) {
            zzf += zzyy.zzd(18, l6.longValue());
        }
        String str8 = this.zzaxo;
        if (str8 != null) {
            zzf += zzyy.zzc(19, str8);
        }
        Boolean bool = this.zzaxp;
        if (bool != null) {
            bool.booleanValue();
            zzf += zzyy.zzbb(20) + 1;
        }
        String str9 = this.zzafw;
        if (str9 != null) {
            zzf += zzyy.zzc(21, str9);
        }
        Long l7 = this.zzaxq;
        if (l7 != null) {
            zzf += zzyy.zzd(22, l7.longValue());
        }
        Integer num3 = this.zzaxr;
        if (num3 != null) {
            zzf += zzyy.zzh(23, num3.intValue());
        }
        String str10 = this.zzagv;
        if (str10 != null) {
            zzf += zzyy.zzc(24, str10);
        }
        String str11 = this.zzafx;
        if (str11 != null) {
            zzf += zzyy.zzc(25, str11);
        }
        Long l8 = this.zzaxg;
        if (l8 != null) {
            zzf += zzyy.zzd(26, l8.longValue());
        }
        Boolean bool2 = this.zzaxs;
        if (bool2 != null) {
            bool2.booleanValue();
            zzf += zzyy.zzbb(28) + 1;
        }
        zzgd[] zzgdArr = this.zzaxt;
        if (zzgdArr != null && zzgdArr.length > 0) {
            while (true) {
                zzgd[] zzgdArr2 = this.zzaxt;
                if (i >= zzgdArr2.length) {
                    break;
                }
                zzgd zzgd = zzgdArr2[i];
                if (zzgd != null) {
                    zzf += zzyy.zzb(29, (zzzg) zzgd);
                }
                i++;
            }
        }
        String str12 = this.zzafz;
        if (str12 != null) {
            zzf += zzyy.zzc(30, str12);
        }
        Integer num4 = this.zzaxu;
        if (num4 != null) {
            zzf += zzyy.zzh(31, num4.intValue());
        }
        Integer num5 = this.zzaxv;
        if (num5 != null) {
            zzf += zzyy.zzh(32, num5.intValue());
        }
        Integer num6 = this.zzaxw;
        if (num6 != null) {
            zzf += zzyy.zzh(33, num6.intValue());
        }
        String str13 = this.zzaxx;
        if (str13 != null) {
            zzf += zzyy.zzc(34, str13);
        }
        Long l9 = this.zzaxy;
        if (l9 != null) {
            zzf += zzyy.zzd(35, l9.longValue());
        }
        Long l10 = this.zzaxz;
        if (l10 != null) {
            zzf += zzyy.zzd(36, l10.longValue());
        }
        String str14 = this.zzaya;
        if (str14 != null) {
            zzf += zzyy.zzc(37, str14);
        }
        String str15 = this.zzayb;
        if (str15 != null) {
            zzf += zzyy.zzc(38, str15);
        }
        Integer num7 = this.zzayc;
        if (num7 != null) {
            zzf += zzyy.zzh(39, num7.intValue());
        }
        String str16 = this.zzawj;
        if (str16 != null) {
            zzf += zzyy.zzc(41, str16);
        }
        zzb zzb = this.zzayd;
        if (zzb != null) {
            return zzf + zzut.zzc(44, (zzwt) zzb);
        }
        return zzf;
    }

    public final /* synthetic */ zzzg zza(zzyx zzyx) throws IOException {
        while (true) {
            int zzug = zzyx.zzug();
            switch (zzug) {
                case 0:
                    return this;
                case 8:
                    this.zzaxa = Integer.valueOf(zzyx.zzuy());
                    break;
                case 18:
                    int zzb = zzzj.zzb(zzyx, 18);
                    zzgf[] zzgfArr = this.zzaxb;
                    int length = zzgfArr == null ? 0 : zzgfArr.length;
                    zzgf[] zzgfArr2 = new zzgf[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzaxb, 0, zzgfArr2, 0, length);
                    }
                    while (length < zzgfArr2.length - 1) {
                        zzgfArr2[length] = new zzgf();
                        zzyx.zza((zzzg) zzgfArr2[length]);
                        zzyx.zzug();
                        length++;
                    }
                    zzgfArr2[length] = new zzgf();
                    zzyx.zza((zzzg) zzgfArr2[length]);
                    this.zzaxb = zzgfArr2;
                    break;
                case 26:
                    int zzb2 = zzzj.zzb(zzyx, 26);
                    zzgl[] zzglArr = this.zzaxc;
                    int length2 = zzglArr == null ? 0 : zzglArr.length;
                    zzgl[] zzglArr2 = new zzgl[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzaxc, 0, zzglArr2, 0, length2);
                    }
                    while (length2 < zzglArr2.length - 1) {
                        zzglArr2[length2] = new zzgl();
                        zzyx.zza((zzzg) zzglArr2[length2]);
                        zzyx.zzug();
                        length2++;
                    }
                    zzglArr2[length2] = new zzgl();
                    zzyx.zza((zzzg) zzglArr2[length2]);
                    this.zzaxc = zzglArr2;
                    break;
                case 32:
                    this.zzaxd = Long.valueOf(zzyx.zzuz());
                    break;
                case 40:
                    this.zzaxe = Long.valueOf(zzyx.zzuz());
                    break;
                case 48:
                    this.zzaxf = Long.valueOf(zzyx.zzuz());
                    break;
                case 56:
                    this.zzaxh = Long.valueOf(zzyx.zzuz());
                    break;
                case 66:
                    this.zzaxi = zzyx.readString();
                    break;
                case 74:
                    this.zzaxj = zzyx.readString();
                    break;
                case 82:
                    this.zzaxk = zzyx.readString();
                    break;
                case 90:
                    this.zzaia = zzyx.readString();
                    break;
                case 96:
                    this.zzaxl = Integer.valueOf(zzyx.zzuy());
                    break;
                case 106:
                    this.zzage = zzyx.readString();
                    break;
                case 114:
                    this.zztt = zzyx.readString();
                    break;
                case 130:
                    this.zzts = zzyx.readString();
                    break;
                case 136:
                    this.zzaxm = Long.valueOf(zzyx.zzuz());
                    break;
                case 144:
                    this.zzaxn = Long.valueOf(zzyx.zzuz());
                    break;
                case 154:
                    this.zzaxo = zzyx.readString();
                    break;
                case 160:
                    this.zzaxp = Boolean.valueOf(zzyx.zzum());
                    break;
                case 170:
                    this.zzafw = zzyx.readString();
                    break;
                case 176:
                    this.zzaxq = Long.valueOf(zzyx.zzuz());
                    break;
                case 184:
                    this.zzaxr = Integer.valueOf(zzyx.zzuy());
                    break;
                case 194:
                    this.zzagv = zzyx.readString();
                    break;
                case 202:
                    this.zzafx = zzyx.readString();
                    break;
                case 208:
                    this.zzaxg = Long.valueOf(zzyx.zzuz());
                    break;
                case 224:
                    this.zzaxs = Boolean.valueOf(zzyx.zzum());
                    break;
                case 234:
                    int zzb3 = zzzj.zzb(zzyx, 234);
                    zzgd[] zzgdArr = this.zzaxt;
                    int length3 = zzgdArr == null ? 0 : zzgdArr.length;
                    zzgd[] zzgdArr2 = new zzgd[(zzb3 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzaxt, 0, zzgdArr2, 0, length3);
                    }
                    while (length3 < zzgdArr2.length - 1) {
                        zzgdArr2[length3] = new zzgd();
                        zzyx.zza((zzzg) zzgdArr2[length3]);
                        zzyx.zzug();
                        length3++;
                    }
                    zzgdArr2[length3] = new zzgd();
                    zzyx.zza((zzzg) zzgdArr2[length3]);
                    this.zzaxt = zzgdArr2;
                    break;
                case 242:
                    this.zzafz = zzyx.readString();
                    break;
                case 248:
                    this.zzaxu = Integer.valueOf(zzyx.zzuy());
                    break;
                case 256:
                    this.zzaxv = Integer.valueOf(zzyx.zzuy());
                    break;
                case 264:
                    this.zzaxw = Integer.valueOf(zzyx.zzuy());
                    break;
                case 274:
                    this.zzaxx = zzyx.readString();
                    break;
                case 280:
                    this.zzaxy = Long.valueOf(zzyx.zzuz());
                    break;
                case 288:
                    this.zzaxz = Long.valueOf(zzyx.zzuz());
                    break;
                case 298:
                    this.zzaya = zzyx.readString();
                    break;
                case 306:
                    this.zzayb = zzyx.readString();
                    break;
                case 312:
                    this.zzayc = Integer.valueOf(zzyx.zzuy());
                    break;
                case 330:
                    this.zzawj = zzyx.readString();
                    break;
                case 354:
                    this.zzayd = (zzb) zzyx.zza(zzb.zza());
                    break;
                default:
                    if (super.zza(zzyx, zzug)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }
}
