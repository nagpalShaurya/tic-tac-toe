package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzfj<FieldDescriptorType extends zzfl<FieldDescriptorType>> {
    private static final zzfj zzue = new zzfj(true);
    private final zzhy<FieldDescriptorType, Object> zzub = zzhy.zzba(16);
    private boolean zzuc;
    private boolean zzud = false;

    private zzfj() {
    }

    private zzfj(boolean z) {
        zzev();
    }

    public static <T extends zzfl<T>> zzfj<T> zzgu() {
        return zzue;
    }

    /* access modifiers changed from: 0000 */
    public final boolean isEmpty() {
        return this.zzub.isEmpty();
    }

    public final void zzev() {
        if (!this.zzuc) {
            this.zzub.zzev();
            this.zzuc = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzuc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfj)) {
            return false;
        }
        return this.zzub.equals(((zzfj) obj).zzub);
    }

    public final int hashCode() {
        return this.zzub.hashCode();
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzud) {
            return new zzgh(this.zzub.entrySet().iterator());
        }
        return this.zzub.entrySet().iterator();
    }

    /* access modifiers changed from: 0000 */
    public final Iterator<Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzud) {
            return new zzgh(this.zzub.zzjf().iterator());
        }
        return this.zzub.zzjf().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzub.get(fielddescriptortype);
        if (obj instanceof zzge) {
            return zzge.zzhz();
        }
        return obj;
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzgz()) {
            zza(fielddescriptortype.zzgx(), obj);
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
                zza(fielddescriptortype.zzgx(), obj2);
            }
            r7 = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (r7 instanceof zzge) {
            this.zzud = true;
        }
        this.zzub.put(fielddescriptortype, r7);
    }

    private static void zza(zzje zzje, Object obj) {
        zzfu.checkNotNull(obj);
        boolean z = false;
        switch (zzfk.zzuf[zzje.zzjw().ordinal()]) {
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
                if ((obj instanceof zzeh) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzfv)) {
                    z = true;
                    break;
                }
            case 9:
                if ((obj instanceof zzhb) || (obj instanceof zzge)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzub.zzjd(); i++) {
            if (!zzb(this.zzub.zzbb(i))) {
                return false;
            }
        }
        for (Entry zzb : this.zzub.zzje()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzb(Entry<FieldDescriptorType, Object> entry) {
        zzfl zzfl = (zzfl) entry.getKey();
        if (zzfl.zzgy() == zzjj.MESSAGE) {
            if (zzfl.zzgz()) {
                for (zzhb isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzhb) {
                    if (!((zzhb) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzge) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzfj<FieldDescriptorType> zzfj) {
        for (int i = 0; i < zzfj.zzub.zzjd(); i++) {
            zzc(zzfj.zzub.zzbb(i));
        }
        for (Entry zzc : zzfj.zzub.zzje()) {
            zzc(zzc);
        }
    }

    private static Object zzg(Object obj) {
        if (obj instanceof zzhh) {
            return ((zzhh) obj).zzip();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzc(Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzfl zzfl = (zzfl) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzge) {
            value = zzge.zzhz();
        }
        if (zzfl.zzgz()) {
            Object zza = zza((FieldDescriptorType) zzfl);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzg : (List) value) {
                ((List) zza).add(zzg(zzg));
            }
            this.zzub.put(zzfl, zza);
        } else if (zzfl.zzgy() == zzjj.MESSAGE) {
            Object zza2 = zza((FieldDescriptorType) zzfl);
            if (zza2 == null) {
                this.zzub.put(zzfl, zzg(value));
                return;
            }
            if (zza2 instanceof zzhh) {
                obj = zzfl.zza((zzhh) zza2, (zzhh) value);
            } else {
                obj = zzfl.zza(((zzhb) zza2).zzhf(), (zzhb) value).zzhm();
            }
            this.zzub.put(zzfl, obj);
        } else {
            this.zzub.put(zzfl, zzg(value));
        }
    }

    static void zza(zzez zzez, zzje zzje, int i, Object obj) throws IOException {
        if (zzje == zzje.GROUP) {
            zzhb zzhb = (zzhb) obj;
            zzfu.zzg(zzhb);
            zzez.zzf(i, 3);
            zzhb.zzb(zzez);
            zzez.zzf(i, 4);
            return;
        }
        zzez.zzf(i, zzje.zzjx());
        switch (zzfk.zzto[zzje.ordinal()]) {
            case 1:
                zzez.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzez.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzez.zzb(((Long) obj).longValue());
                return;
            case 4:
                zzez.zzb(((Long) obj).longValue());
                return;
            case 5:
                zzez.zzab(((Integer) obj).intValue());
                return;
            case 6:
                zzez.zzd(((Long) obj).longValue());
                return;
            case 7:
                zzez.zzae(((Integer) obj).intValue());
                return;
            case 8:
                zzez.zzs(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzhb) obj).zzb(zzez);
                return;
            case 10:
                zzez.zzc((zzhb) obj);
                return;
            case 11:
                if (obj instanceof zzeh) {
                    zzez.zza((zzeh) obj);
                    return;
                } else {
                    zzez.zzcz((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzeh) {
                    zzez.zza((zzeh) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzez.zzd(bArr, 0, bArr.length);
                return;
            case 13:
                zzez.zzac(((Integer) obj).intValue());
                return;
            case 14:
                zzez.zzae(((Integer) obj).intValue());
                return;
            case 15:
                zzez.zzd(((Long) obj).longValue());
                return;
            case 16:
                zzez.zzad(((Integer) obj).intValue());
                return;
            case 17:
                zzez.zzc(((Long) obj).longValue());
                return;
            case 18:
                if (!(obj instanceof zzfv)) {
                    zzez.zzab(((Integer) obj).intValue());
                    break;
                } else {
                    zzez.zzab(((zzfv) obj).zzbi());
                    return;
                }
        }
    }

    public final int zzgv() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzub.zzjd(); i2++) {
            Entry zzbb = this.zzub.zzbb(i2);
            i += zzb((zzfl) zzbb.getKey(), zzbb.getValue());
        }
        for (Entry entry : this.zzub.zzje()) {
            i += zzb((zzfl) entry.getKey(), entry.getValue());
        }
        return i;
    }

    public final int zzgw() {
        int i = 0;
        for (int i2 = 0; i2 < this.zzub.zzjd(); i2++) {
            i += zzd(this.zzub.zzbb(i2));
        }
        for (Entry zzd : this.zzub.zzje()) {
            i += zzd(zzd);
        }
        return i;
    }

    private static int zzd(Entry<FieldDescriptorType, Object> entry) {
        zzfl zzfl = (zzfl) entry.getKey();
        Object value = entry.getValue();
        if (zzfl.zzgy() != zzjj.MESSAGE || zzfl.zzgz() || zzfl.zzha()) {
            return zzb(zzfl, value);
        }
        if (value instanceof zzge) {
            return zzez.zzb(((zzfl) entry.getKey()).zzbi(), (zzgi) (zzge) value);
        }
        return zzez.zzb(((zzfl) entry.getKey()).zzbi(), (zzhb) value);
    }

    static int zza(zzje zzje, int i, Object obj) {
        int zzaf = zzez.zzaf(i);
        if (zzje == zzje.GROUP) {
            zzfu.zzg((zzhb) obj);
            zzaf <<= 1;
        }
        return zzaf + zzb(zzje, obj);
    }

    private static int zzb(zzje zzje, Object obj) {
        switch (zzfk.zzto[zzje.ordinal()]) {
            case 1:
                return zzez.zzb(((Double) obj).doubleValue());
            case 2:
                return zzez.zzb(((Float) obj).floatValue());
            case 3:
                return zzez.zze(((Long) obj).longValue());
            case 4:
                return zzez.zzf(((Long) obj).longValue());
            case 5:
                return zzez.zzag(((Integer) obj).intValue());
            case 6:
                return zzez.zzh(((Long) obj).longValue());
            case 7:
                return zzez.zzaj(((Integer) obj).intValue());
            case 8:
                return zzez.zzt(((Boolean) obj).booleanValue());
            case 9:
                return zzez.zze((zzhb) obj);
            case 10:
                if (obj instanceof zzge) {
                    return zzez.zza((zzgi) (zzge) obj);
                }
                return zzez.zzd((zzhb) obj);
            case 11:
                if (obj instanceof zzeh) {
                    return zzez.zzb((zzeh) obj);
                }
                return zzez.zzda((String) obj);
            case 12:
                if (obj instanceof zzeh) {
                    return zzez.zzb((zzeh) obj);
                }
                return zzez.zzc((byte[]) obj);
            case 13:
                return zzez.zzah(((Integer) obj).intValue());
            case 14:
                return zzez.zzak(((Integer) obj).intValue());
            case 15:
                return zzez.zzi(((Long) obj).longValue());
            case 16:
                return zzez.zzai(((Integer) obj).intValue());
            case 17:
                return zzez.zzg(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfv) {
                    return zzez.zzal(((zzfv) obj).zzbi());
                }
                return zzez.zzal(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int zzb(zzfl<?> zzfl, Object obj) {
        zzje zzgx = zzfl.zzgx();
        int zzbi = zzfl.zzbi();
        if (!zzfl.zzgz()) {
            return zza(zzgx, zzbi, obj);
        }
        int i = 0;
        if (zzfl.zzha()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzgx, zzb);
            }
            return zzez.zzaf(zzbi) + i + zzez.zzan(i);
        }
        for (Object zza : (List) obj) {
            i += zza(zzgx, zzbi, zza);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzfj zzfj = new zzfj();
        for (int i = 0; i < this.zzub.zzjd(); i++) {
            Entry zzbb = this.zzub.zzbb(i);
            zzfj.zza((FieldDescriptorType) (zzfl) zzbb.getKey(), zzbb.getValue());
        }
        for (Entry entry : this.zzub.zzje()) {
            zzfj.zza((FieldDescriptorType) (zzfl) entry.getKey(), entry.getValue());
        }
        zzfj.zzud = this.zzud;
        return zzfj;
    }
}
