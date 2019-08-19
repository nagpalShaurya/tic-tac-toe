package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzvf;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzvd<FieldDescriptorType extends zzvf<FieldDescriptorType>> {
    private static final zzvd zzbvs = new zzvd(true);
    private boolean zzbpo;
    private final zzxm<FieldDescriptorType, Object> zzbvq = zzxm.zzbt(16);
    private boolean zzbvr = false;

    private zzvd() {
    }

    private zzvd(boolean z) {
        zzsm();
    }

    public static <T extends zzvf<T>> zzvd<T> zzvt() {
        return zzbvs;
    }

    /* access modifiers changed from: 0000 */
    public final boolean isEmpty() {
        return this.zzbvq.isEmpty();
    }

    public final void zzsm() {
        if (!this.zzbpo) {
            this.zzbvq.zzsm();
            this.zzbpo = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzbpo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzvd)) {
            return false;
        }
        return this.zzbvq.equals(((zzvd) obj).zzbvq);
    }

    public final int hashCode() {
        return this.zzbvq.hashCode();
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzbvr) {
            return new zzvz(this.zzbvq.entrySet().iterator());
        }
        return this.zzbvq.entrySet().iterator();
    }

    /* access modifiers changed from: 0000 */
    public final Iterator<Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzbvr) {
            return new zzvz(this.zzbvq.zzxy().iterator());
        }
        return this.zzbvq.zzxy().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzbvq.get(fielddescriptortype);
        if (obj instanceof zzvw) {
            return zzvw.zzwt();
        }
        return obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzvy()) {
            zza(fielddescriptortype.zzvw(), obj);
            r7 = obj;
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzvw(), obj2);
            }
            r7 = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (r7 instanceof zzvw) {
            this.zzbvr = true;
        }
        this.zzbvq.put(fielddescriptortype, r7);
    }

    private static void zza(zzyq zzyq, Object obj) {
        zzvo.checkNotNull(obj);
        boolean z = false;
        switch (zzve.zzbvt[zzyq.zzyp().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof zzud) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzvp)) {
                    z = true;
                    break;
                }
            case 9:
                if ((obj instanceof zzwt) || (obj instanceof zzvw)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzbvq.zzxw(); i++) {
            if (!zzc(this.zzbvq.zzbu(i))) {
                return false;
            }
        }
        for (Entry zzc : this.zzbvq.zzxx()) {
            if (!zzc(zzc)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzc(Entry<FieldDescriptorType, Object> entry) {
        zzvf zzvf = (zzvf) entry.getKey();
        if (zzvf.zzvx() == zzyv.MESSAGE) {
            if (zzvf.zzvy()) {
                for (zzwt isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzwt) {
                    if (!((zzwt) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzvw) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzvd<FieldDescriptorType> zzvd) {
        for (int i = 0; i < zzvd.zzbvq.zzxw(); i++) {
            zzd(zzvd.zzbvq.zzbu(i));
        }
        for (Entry zzd : zzvd.zzbvq.zzxx()) {
            zzd(zzd);
        }
    }

    private static Object zzv(Object obj) {
        if (obj instanceof zzwz) {
            return ((zzwz) obj).zzxj();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzd(Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzvf zzvf = (zzvf) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzvw) {
            value = zzvw.zzwt();
        }
        if (zzvf.zzvy()) {
            Object zza = zza((FieldDescriptorType) zzvf);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzv : (List) value) {
                ((List) zza).add(zzv(zzv));
            }
            this.zzbvq.put(zzvf, zza);
        } else if (zzvf.zzvx() == zzyv.MESSAGE) {
            Object zza2 = zza((FieldDescriptorType) zzvf);
            if (zza2 == null) {
                this.zzbvq.put(zzvf, zzv(value));
                return;
            }
            if (zza2 instanceof zzwz) {
                obj = zzvf.zza((zzwz) zza2, (zzwz) value);
            } else {
                obj = zzvf.zza(((zzwt) zza2).zzwd(), (zzwt) value).zzwj();
            }
            this.zzbvq.put(zzvf, obj);
        } else {
            this.zzbvq.put(zzvf, zzv(value));
        }
    }

    static void zza(zzut zzut, zzyq zzyq, int i, Object obj) throws IOException {
        if (zzyq == zzyq.GROUP) {
            zzwt zzwt = (zzwt) obj;
            zzvo.zzf(zzwt);
            zzut.zzc(i, 3);
            zzwt.zzb(zzut);
            zzut.zzc(i, 4);
            return;
        }
        zzut.zzc(i, zzyq.zzyq());
        switch (zzve.zzbuu[zzyq.ordinal()]) {
            case 1:
                zzut.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzut.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzut.zzav(((Long) obj).longValue());
                return;
            case 4:
                zzut.zzav(((Long) obj).longValue());
                return;
            case 5:
                zzut.zzax(((Integer) obj).intValue());
                return;
            case 6:
                zzut.zzax(((Long) obj).longValue());
                return;
            case 7:
                zzut.zzba(((Integer) obj).intValue());
                return;
            case 8:
                zzut.zzu(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzwt) obj).zzb(zzut);
                return;
            case 10:
                zzut.zzb((zzwt) obj);
                return;
            case 11:
                if (obj instanceof zzud) {
                    zzut.zza((zzud) obj);
                    return;
                } else {
                    zzut.zzfw((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzud) {
                    zzut.zza((zzud) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzut.zze(bArr, 0, bArr.length);
                return;
            case 13:
                zzut.zzay(((Integer) obj).intValue());
                return;
            case 14:
                zzut.zzba(((Integer) obj).intValue());
                return;
            case 15:
                zzut.zzax(((Long) obj).longValue());
                return;
            case 16:
                zzut.zzaz(((Integer) obj).intValue());
                return;
            case 17:
                zzut.zzaw(((Long) obj).longValue());
                return;
            case 18:
                if (!(obj instanceof zzvp)) {
                    zzut.zzax(((Integer) obj).intValue());
                    break;
                } else {
                    zzut.zzax(((zzvp) obj).zzc());
                    return;
                }
        }
    }

    public final int zzvu() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzbvq.zzxw(); i2++) {
            Entry zzbu = this.zzbvq.zzbu(i2);
            i += zzb((zzvf) zzbu.getKey(), zzbu.getValue());
        }
        for (Entry entry : this.zzbvq.zzxx()) {
            i += zzb((zzvf) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public final int zzvv() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzbvq.zzxw(); i2++) {
            i += zze(this.zzbvq.zzbu(i2));
        }
        for (Entry zze : this.zzbvq.zzxx()) {
            i += zze(zze);
        }
        return i;
    }

    private static int zze(Entry<FieldDescriptorType, Object> entry) {
        zzvf zzvf = (zzvf) entry.getKey();
        Object value = entry.getValue();
        if (zzvf.zzvx() != zzyv.MESSAGE || zzvf.zzvy() || zzvf.zzvz()) {
            return zzb(zzvf, value);
        }
        if (value instanceof zzvw) {
            return zzut.zzb(((zzvf) entry.getKey()).zzc(), (zzwa) (zzvw) value);
        }
        return zzut.zzd(((zzvf) entry.getKey()).zzc(), (zzwt) value);
    }

    static int zza(zzyq zzyq, int i, Object obj) {
        int zzbb = zzut.zzbb(i);
        if (zzyq == zzyq.GROUP) {
            zzvo.zzf((zzwt) obj);
            zzbb <<= 1;
        }
        return zzbb + zzb(zzyq, obj);
    }

    private static int zzb(zzyq zzyq, Object obj) {
        switch (zzve.zzbuu[zzyq.ordinal()]) {
            case 1:
                return zzut.zzc(((Double) obj).doubleValue());
            case 2:
                return zzut.zzb(((Float) obj).floatValue());
            case 3:
                return zzut.zzay(((Long) obj).longValue());
            case 4:
                return zzut.zzaz(((Long) obj).longValue());
            case 5:
                return zzut.zzbc(((Integer) obj).intValue());
            case 6:
                return zzut.zzbb(((Long) obj).longValue());
            case 7:
                return zzut.zzbf(((Integer) obj).intValue());
            case 8:
                return zzut.zzv(((Boolean) obj).booleanValue());
            case 9:
                return zzut.zzd((zzwt) obj);
            case 10:
                if (obj instanceof zzvw) {
                    return zzut.zza((zzwa) (zzvw) obj);
                }
                return zzut.zzc((zzwt) obj);
            case 11:
                if (obj instanceof zzud) {
                    return zzut.zzb((zzud) obj);
                }
                return zzut.zzfx((String) obj);
            case 12:
                if (obj instanceof zzud) {
                    return zzut.zzb((zzud) obj);
                }
                return zzut.zzk((byte[]) obj);
            case 13:
                return zzut.zzbd(((Integer) obj).intValue());
            case 14:
                return zzut.zzbg(((Integer) obj).intValue());
            case 15:
                return zzut.zzbc(((Long) obj).longValue());
            case 16:
                return zzut.zzbe(((Integer) obj).intValue());
            case 17:
                return zzut.zzba(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzvp) {
                    return zzut.zzbh(((zzvp) obj).zzc());
                }
                return zzut.zzbh(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int zzb(zzvf<?> zzvf, Object obj) {
        zzyq zzvw = zzvf.zzvw();
        int zzc = zzvf.zzc();
        if (!zzvf.zzvy()) {
            return zza(zzvw, zzc, obj);
        }
        int i = 0;
        if (zzvf.zzvz()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzvw, zzb);
            }
            return zzut.zzbb(zzc) + i + zzut.zzbj(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzvw, zzc, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzvd zzvd = new zzvd();
        for (int i = 0; i < this.zzbvq.zzxw(); i++) {
            Entry zzbu = this.zzbvq.zzbu(i);
            zzvd.zza((FieldDescriptorType) (zzvf) zzbu.getKey(), zzbu.getValue());
        }
        for (Entry entry : this.zzbvq.zzxx()) {
            zzvd.zza((FieldDescriptorType) (zzvf) entry.getKey(), entry.getValue());
        }
        zzvd.zzbvr = this.zzbvr;
        return zzvd;
    }
}
