package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zzzd implements Cloneable {
    private Object value;
    private zzzb<?, ?> zzcfj;
    private List<zzzi> zzcfk = new ArrayList();

    zzzd() {
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzzi zzzi) throws IOException {
        Object obj;
        List<zzzi> list = this.zzcfk;
        if (list != null) {
            list.add(zzzi);
            return;
        }
        Object obj2 = this.value;
        if (obj2 instanceof zzzg) {
            byte[] bArr = zzzi.zzbug;
            zzyx zzj = zzyx.zzj(bArr, 0, bArr.length);
            int zzuy = zzj.zzuy();
            if (zzuy == bArr.length - zzyy.zzbc(zzuy)) {
                obj = ((zzzg) this.value).zza(zzj);
            } else {
                throw zzzf.zzyw();
            }
        } else if (obj2 instanceof zzzg[]) {
            zzzg[] zzzgArr = (zzzg[]) this.zzcfj.zzah(Collections.singletonList(zzzi));
            zzzg[] zzzgArr2 = (zzzg[]) this.value;
            Object obj3 = (zzzg[]) Arrays.copyOf(zzzgArr2, zzzgArr2.length + zzzgArr.length);
            System.arraycopy(zzzgArr, 0, obj3, zzzgArr2.length, zzzgArr.length);
            obj = obj3;
        } else {
            obj = this.zzcfj.zzah(Collections.singletonList(zzzi));
        }
        this.zzcfj = this.zzcfj;
        this.value = obj;
        this.zzcfk = null;
    }

    /* access modifiers changed from: 0000 */
    public final <T> T zzb(zzzb<?, T> zzzb) {
        if (this.value == null) {
            this.zzcfj = zzzb;
            this.value = zzzb.zzah(this.zzcfk);
            this.zzcfk = null;
        } else if (!this.zzcfj.equals(zzzb)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.value;
    }

    /* access modifiers changed from: 0000 */
    public final int zzf() {
        Object obj = this.value;
        if (obj != null) {
            zzzb<?, ?> zzzb = this.zzcfj;
            if (!zzzb.zzcfe) {
                return zzzb.zzak(obj);
            }
            int length = Array.getLength(obj);
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (Array.get(obj, i2) != null) {
                    i += zzzb.zzak(Array.get(obj, i2));
                }
            }
            return i;
        }
        int i3 = 0;
        for (zzzi zzzi : this.zzcfk) {
            i3 += zzyy.zzbj(zzzi.tag) + 0 + zzzi.zzbug.length;
        }
        return i3;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzyy zzyy) throws IOException {
        Object obj = this.value;
        if (obj != null) {
            zzzb<?, ?> zzzb = this.zzcfj;
            if (zzzb.zzcfe) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzzb.zza(obj2, zzyy);
                    }
                }
                return;
            }
            zzzb.zza(obj, zzyy);
            return;
        }
        for (zzzi zzzi : this.zzcfk) {
            zzyy.zzca(zzzi.tag);
            zzyy.zzp(zzzi.zzbug);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzzd)) {
            return false;
        }
        zzzd zzzd = (zzzd) obj;
        if (this.value == null || zzzd.value == null) {
            List<zzzi> list = this.zzcfk;
            if (list != null) {
                List<zzzi> list2 = zzzd.zzcfk;
                if (list2 != null) {
                    return list.equals(list2);
                }
            }
            try {
                return Arrays.equals(toByteArray(), zzzd.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            zzzb<?, ?> zzzb = this.zzcfj;
            if (zzzb != zzzd.zzcfj) {
                return false;
            }
            if (!zzzb.zzcfd.isArray()) {
                return this.value.equals(zzzd.value);
            }
            Object obj2 = this.value;
            if (obj2 instanceof byte[]) {
                return Arrays.equals((byte[]) obj2, (byte[]) zzzd.value);
            }
            if (obj2 instanceof int[]) {
                return Arrays.equals((int[]) obj2, (int[]) zzzd.value);
            }
            if (obj2 instanceof long[]) {
                return Arrays.equals((long[]) obj2, (long[]) zzzd.value);
            }
            if (obj2 instanceof float[]) {
                return Arrays.equals((float[]) obj2, (float[]) zzzd.value);
            }
            if (obj2 instanceof double[]) {
                return Arrays.equals((double[]) obj2, (double[]) zzzd.value);
            }
            if (obj2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) obj2, (boolean[]) zzzd.value);
            }
            return Arrays.deepEquals((Object[]) obj2, (Object[]) zzzd.value);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzf()];
        zza(zzyy.zzo(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzyv */
    public final zzzd clone() {
        zzzd zzzd = new zzzd();
        try {
            zzzd.zzcfj = this.zzcfj;
            if (this.zzcfk == null) {
                zzzd.zzcfk = null;
            } else {
                zzzd.zzcfk.addAll(this.zzcfk);
            }
            if (this.value != null) {
                if (this.value instanceof zzzg) {
                    zzzd.value = (zzzg) ((zzzg) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzzd.value = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzzd.value = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        zzzd.value = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        zzzd.value = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        zzzd.value = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        zzzd.value = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        zzzd.value = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzzg[]) {
                        zzzg[] zzzgArr = (zzzg[]) this.value;
                        zzzg[] zzzgArr2 = new zzzg[zzzgArr.length];
                        zzzd.value = zzzgArr2;
                        while (i < zzzgArr.length) {
                            zzzgArr2[i] = (zzzg) zzzgArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return zzzd;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
