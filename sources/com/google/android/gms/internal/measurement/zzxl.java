package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzxl {
    private static final Class<?> zzcbw = zzxu();
    private static final zzyb<?, ?> zzcbx = zzx(false);
    private static final zzyb<?, ?> zzcby = zzx(true);
    private static final zzyb<?, ?> zzcbz = new zzyd();

    public static void zzj(Class<?> cls) {
        if (!zzvm.class.isAssignableFrom(cls)) {
            Class<?> cls2 = zzcbw;
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    public static void zza(int i, List<Double> list, zzyw zzyw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzyw zzyw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzyw zzyw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzyw zzyw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzyw zzyw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzyw zzyw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzyw zzyw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzyw zzyw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzyw zzyw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzyw zzyw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzyw zzyw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzyw zzyw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzyw zzyw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzyw zzyw, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzyw zzyw) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzud> list, zzyw zzyw) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzyw zzyw, zzxj zzxj) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zza(i, list, zzxj);
        }
    }

    public static void zzb(int i, List<?> list, zzyw zzyw, zzxj zzxj) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzyw.zzb(i, list, zzxj);
        }
    }

    static int zzx(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzwh) {
            zzwh zzwh = (zzwh) list;
            i = 0;
            while (i2 < size) {
                i += zzut.zzay(zzwh.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzut.zzay(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzx(list) + (list.size() * zzut.zzbb(i));
    }

    static int zzy(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzwh) {
            zzwh zzwh = (zzwh) list;
            i = 0;
            while (i2 < size) {
                i += zzut.zzaz(zzwh.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzut.zzaz(((Long) list.get(i2)).longValue());
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
        return zzy(list) + (size * zzut.zzbb(i));
    }

    static int zzz(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzwh) {
            zzwh zzwh = (zzwh) list;
            i = 0;
            while (i2 < size) {
                i += zzut.zzba(zzwh.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzut.zzba(((Long) list.get(i2)).longValue());
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
        return zzz(list) + (size * zzut.zzbb(i));
    }

    static int zzaa(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvn) {
            zzvn zzvn = (zzvn) list;
            i = 0;
            while (i2 < size) {
                i += zzut.zzbh(zzvn.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzut.zzbh(((Integer) list.get(i2)).intValue());
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
        return zzaa(list) + (size * zzut.zzbb(i));
    }

    static int zzab(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvn) {
            zzvn zzvn = (zzvn) list;
            i = 0;
            while (i2 < size) {
                i += zzut.zzbc(zzvn.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzut.zzbc(((Integer) list.get(i2)).intValue());
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
        return zzab(list) + (size * zzut.zzbb(i));
    }

    static int zzac(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvn) {
            zzvn zzvn = (zzvn) list;
            i = 0;
            while (i2 < size) {
                i += zzut.zzbd(zzvn.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzut.zzbd(((Integer) list.get(i2)).intValue());
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
        return zzac(list) + (size * zzut.zzbb(i));
    }

    static int zzad(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzvn) {
            zzvn zzvn = (zzvn) list;
            i = 0;
            while (i2 < size) {
                i += zzut.zzbe(zzvn.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzut.zzbe(((Integer) list.get(i2)).intValue());
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
        return zzad(list) + (size * zzut.zzbb(i));
    }

    static int zzae(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzut.zzk(i, 0);
    }

    static int zzaf(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzut.zzg(i, 0);
    }

    static int zzag(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzut.zzc(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzbb = zzut.zzbb(i) * size;
        if (list instanceof zzwc) {
            zzwc zzwc = (zzwc) list;
            while (i4 < size) {
                Object raw = zzwc.getRaw(i4);
                if (raw instanceof zzud) {
                    i3 = zzut.zzb((zzud) raw);
                } else {
                    i3 = zzut.zzfx((String) raw);
                }
                zzbb += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzud) {
                    i2 = zzut.zzb((zzud) obj);
                } else {
                    i2 = zzut.zzfx((String) obj);
                }
                zzbb += i2;
                i4++;
            }
        }
        return zzbb;
    }

    static int zzc(int i, Object obj, zzxj zzxj) {
        if (obj instanceof zzwa) {
            return zzut.zza(i, (zzwa) obj);
        }
        return zzut.zzb(i, (zzwt) obj, zzxj);
    }

    static int zzc(int i, List<?> list, zzxj zzxj) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = zzut.zzbb(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzwa) {
                i2 = zzut.zza((zzwa) obj);
            } else {
                i2 = zzut.zzb((zzwt) obj, zzxj);
            }
            zzbb += i2;
        }
        return zzbb;
    }

    static int zzd(int i, List<zzud> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = size * zzut.zzbb(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzbb += zzut.zzb((zzud) list.get(i2));
        }
        return zzbb;
    }

    static int zzd(int i, List<zzwt> list, zzxj zzxj) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzut.zzc(i, (zzwt) list.get(i3), zzxj);
        }
        return i2;
    }

    public static zzyb<?, ?> zzxr() {
        return zzcbx;
    }

    public static zzyb<?, ?> zzxs() {
        return zzcby;
    }

    public static zzyb<?, ?> zzxt() {
        return zzcbz;
    }

    private static zzyb<?, ?> zzx(boolean z) {
        try {
            Class zzxv = zzxv();
            if (zzxv == null) {
                return null;
            }
            return (zzyb) zzxv.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzxu() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzxv() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    static boolean zze(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <T> void zza(zzwo zzwo, T t, T t2, long j) {
        zzyh.zza((Object) t, j, zzwo.zzc(zzyh.zzp(t, j), zzyh.zzp(t2, j)));
    }

    static <T, FT extends zzvf<FT>> void zza(zzva<FT> zzva, T t, T t2) {
        zzvd zzs = zzva.zzs(t2);
        if (!zzs.isEmpty()) {
            zzva.zzt(t).zza(zzs);
        }
    }

    static <T, UT, UB> void zza(zzyb<UT, UB> zzyb, T t, T t2) {
        zzyb.zzf(t, zzyb.zzh(zzyb.zzah(t), zzyb.zzah(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzvr zzvr, UB ub, zzyb<UT, UB> zzyb) {
        UB ub2;
        if (zzvr == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzvr.zzb(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub2 = zza(i, intValue, ub2, zzyb);
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
                if (!zzvr.zzb(intValue2)) {
                    UB zza = zza(i, intValue2, ub2, zzyb);
                    it.remove();
                    ub2 = zza;
                }
            }
        }
        return ub2;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzyb<UT, UB> zzyb) {
        if (ub == null) {
            ub = zzyb.zzye();
        }
        zzyb.zza(ub, i, (long) i2);
        return ub;
    }
}
