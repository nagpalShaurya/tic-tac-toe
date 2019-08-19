package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public abstract class zzeh implements Serializable, Iterable<Byte> {
    public static final zzeh zzso = new zzeq(zzfu.EMPTY_BYTE_ARRAY);
    private static final zzem zzsp = (zzee.zzex() ? new zzer(null) : new zzek(null));
    private static final Comparator<zzeh> zzsr = new zzej();
    private int zzsq = 0;

    zzeh() {
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: 0000 */
    public abstract void zza(zzeg zzeg) throws IOException;

    /* access modifiers changed from: protected */
    public abstract int zzb(int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract void zzb(byte[] bArr, int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract int zzc(int i, int i2, int i3);

    public abstract zzeh zzd(int i, int i2);

    public abstract boolean zzfa();

    /* access modifiers changed from: protected */
    public abstract int zzfb();

    /* access modifiers changed from: protected */
    public abstract boolean zzfc();

    public abstract byte zzk(int i);

    /* access modifiers changed from: private */
    public static int zza(byte b) {
        return b & 255;
    }

    public static zzeh zzb(byte[] bArr, int i, int i2) {
        zzd(i, i + i2, bArr.length);
        return new zzeq(zzsp.zzc(bArr, i, i2));
    }

    static zzeh zza(byte[] bArr) {
        return new zzeq(bArr);
    }

    public static zzeh zzcy(String str) {
        return new zzeq(str.getBytes(zzfu.UTF_8));
    }

    public static zzeh zze(Iterable<zzeh> iterable) {
        int size = ((Collection) iterable).size();
        if (size == 0) {
            return zzso;
        }
        return zza(iterable.iterator(), size);
    }

    private static zzeh zza(Iterator<zzeh> it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i)}));
        } else if (i == 1) {
            return (zzeh) it.next();
        } else {
            int i2 = i >>> 1;
            zzeh zza = zza(it, i2);
            zzeh zza2 = zza(it, i - i2);
            if (Integer.MAX_VALUE - zza.size() >= zza2.size()) {
                return zzhr.zza(zza, zza2);
            }
            int size = zza.size();
            int size2 = zza2.size();
            StringBuilder sb = new StringBuilder(53);
            sb.append("ByteString would be too long: ");
            sb.append(size);
            sb.append("+");
            sb.append(size2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Deprecated
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        zzd(0, i3 + 0, size());
        zzd(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zzb(bArr, 0, i2, i3);
        }
    }

    public final String zzez() {
        return size() == 0 ? "" : zza(zzfu.UTF_8);
    }

    public final int hashCode() {
        int i = this.zzsq;
        if (i == 0) {
            int size = size();
            i = zzc(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzsq = i;
        }
        return i;
    }

    static zzeo zzl(int i) {
        return new zzeo(i, null);
    }

    /* access modifiers changed from: protected */
    public final int zzfd() {
        return this.zzsq;
    }

    static void zze(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    static int zzd(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public /* synthetic */ Iterator iterator() {
        return new zzei(this);
    }
}
