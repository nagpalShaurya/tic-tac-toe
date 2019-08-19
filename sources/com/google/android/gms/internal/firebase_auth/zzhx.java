package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzhx {
    private static final Class<?> zzaar = zzjb();
    private static final zzip<?, ?> zzaas = zzv(false);
    private static final zzip<?, ?> zzaat = zzv(true);
    private static final zzip<?, ?> zzaau = new zzir();

    public static void zzg(Class<?> cls) {
        if (!zzfs.class.isAssignableFrom(cls)) {
            Class<?> cls2 = zzaar;
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    public static void zza(int i, List<Double> list, zzjk zzjk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzjk zzjk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzjk zzjk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzjk zzjk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzjk zzjk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzjk zzjk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzjk zzjk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzjk zzjk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzjk zzjk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzjk zzjk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzjk zzjk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzjk zzjk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzjk zzjk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzjk zzjk, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzjk zzjk) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzeh> list, zzjk zzjk) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzjk zzjk, zzhv zzhv) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zza(i, list, zzhv);
        }
    }

    public static void zzb(int i, List<?> list, zzjk zzjk, zzhv zzhv) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjk.zzb(i, list, zzhv);
        }
    }

    static int zzt(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            i = 0;
            while (i2 < size) {
                i += zzez.zze(zzgp.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzez.zze(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzt(list) + (list.size() * zzez.zzaf(i));
    }

    static int zzu(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            i = 0;
            while (i2 < size) {
                i += zzez.zzf(zzgp.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzez.zzf(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzu(list) + (size * zzez.zzaf(i));
    }

    static int zzv(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgp) {
            zzgp zzgp = (zzgp) list;
            i = 0;
            while (i2 < size) {
                i += zzez.zzg(zzgp.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzez.zzg(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzez.zzaf(i));
    }

    static int zzw(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzft) {
            zzft zzft = (zzft) list;
            i = 0;
            while (i2 < size) {
                i += zzez.zzal(zzft.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzez.zzal(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzez.zzaf(i));
    }

    static int zzx(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzft) {
            zzft zzft = (zzft) list;
            i = 0;
            while (i2 < size) {
                i += zzez.zzag(zzft.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzez.zzag(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzx(list) + (size * zzez.zzaf(i));
    }

    static int zzy(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzft) {
            zzft zzft = (zzft) list;
            i = 0;
            while (i2 < size) {
                i += zzez.zzah(zzft.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzez.zzah(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzez.zzaf(i));
    }

    static int zzz(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzft) {
            zzft zzft = (zzft) list;
            i = 0;
            while (i2 < size) {
                i += zzez.zzai(zzft.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzez.zzai(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzz(list) + (size * zzez.zzaf(i));
    }

    static int zzaa(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzez.zzn(i, 0);
    }

    static int zzab(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzez.zzg(i, 0);
    }

    static int zzac(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzez.zzc(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzaf = zzez.zzaf(i) * size;
        if (list instanceof zzgk) {
            zzgk zzgk = (zzgk) list;
            while (i4 < size) {
                Object zzas = zzgk.zzas(i4);
                if (zzas instanceof zzeh) {
                    i3 = zzez.zzb((zzeh) zzas);
                } else {
                    i3 = zzez.zzda((String) zzas);
                }
                zzaf += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzeh) {
                    i2 = zzez.zzb((zzeh) obj);
                } else {
                    i2 = zzez.zzda((String) obj);
                }
                zzaf += i2;
                i4++;
            }
        }
        return zzaf;
    }

    static int zzc(int i, Object obj, zzhv zzhv) {
        if (obj instanceof zzgi) {
            return zzez.zza(i, (zzgi) obj);
        }
        return zzez.zzb(i, (zzhb) obj, zzhv);
    }

    static int zzc(int i, List<?> list, zzhv zzhv) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzaf = zzez.zzaf(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzgi) {
                i2 = zzez.zza((zzgi) obj);
            } else {
                i2 = zzez.zza((zzhb) obj, zzhv);
            }
            zzaf += i2;
        }
        return zzaf;
    }

    static int zzd(int i, List<zzeh> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzaf = size * zzez.zzaf(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzaf += zzez.zzb((zzeh) list.get(i2));
        }
        return zzaf;
    }

    static int zzd(int i, List<zzhb> list, zzhv zzhv) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzez.zzc(i, (zzhb) list.get(i3), zzhv);
        }
        return i2;
    }

    public static zzip<?, ?> zziy() {
        return zzaas;
    }

    public static zzip<?, ?> zziz() {
        return zzaat;
    }

    public static zzip<?, ?> zzja() {
        return zzaau;
    }

    private static zzip<?, ?> zzv(boolean z) {
        try {
            Class zzjc = zzjc();
            if (zzjc == null) {
                return null;
            }
            return (zzip) zzjc.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzjb() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzjc() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    static boolean zzd(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void zza(zzgw zzgw, T t, T t2, long j) {
        zziv.zza((Object) t, j, zzgw.zzb(zziv.zzp(t, j), zziv.zzp(t2, j)));
    }

    static <T, FT extends zzfl<FT>> void zza(zzfg<FT> zzfg, T t, T t2) {
        zzfj zzd = zzfg.zzd(t2);
        if (!zzd.isEmpty()) {
            zzfg.zze(t).zza(zzd);
        }
    }

    static <T, UT, UB> void zza(zzip<UT, UB> zzip, T t, T t2) {
        zzip.zze(t, zzip.zzg(zzip.zzs(t), zzip.zzs(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzfx zzfx, UB ub, zzip<UT, UB> zzip) {
        UB ub2;
        if (zzfx == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzfx.zzc(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub2 = zza(i, intValue, ub2, zzip);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            ub2 = ub;
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzfx.zzc(intValue2)) {
                    UB zza = zza(i, intValue2, ub2, zzip);
                    it.remove();
                    ub2 = zza;
                }
            }
        }
        return ub2;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzip<UT, UB> zzip) {
        if (ub == null) {
            ub = zzip.zzjm();
        }
        zzip.zza(ub, i, (long) i2);
        return ub;
    }
}
