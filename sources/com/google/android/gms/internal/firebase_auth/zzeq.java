package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.nio.charset.Charset;

class zzeq extends zzep {
    protected final byte[] zzsw;

    zzeq(byte[] bArr) {
        if (bArr != null) {
            this.zzsw = bArr;
            return;
        }
        throw new NullPointerException();
    }

    public byte zzk(int i) {
        return this.zzsw[i];
    }

    public int size() {
        return this.zzsw.length;
    }

    public final zzeh zzd(int i, int i2) {
        int zzd = zzd(i, i2, size());
        if (zzd == 0) {
            return zzeh.zzso;
        }
        return new zzel(this.zzsw, zzfe() + i, zzd);
    }

    /* access modifiers changed from: protected */
    public void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzsw, i, bArr, i2, i3);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzeg zzeg) throws IOException {
        zzeg.zza(this.zzsw, zzfe(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzsw, zzfe(), size(), charset);
    }

    public final boolean zzfa() {
        int zzfe = zzfe();
        return zzix.zze(this.zzsw, zzfe, size() + zzfe);
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i, int i2, int i3) {
        int zzfe = zzfe() + i2;
        return zzix.zzb(i, this.zzsw, zzfe, i3 + zzfe);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeh) || size() != ((zzeh) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzeq)) {
            return obj.equals(this);
        }
        zzeq zzeq = (zzeq) obj;
        int zzfd = zzfd();
        int zzfd2 = zzeq.zzfd();
        if (zzfd == 0 || zzfd2 == 0 || zzfd == zzfd2) {
            return zza(zzeq, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(zzeh zzeh, int i, int i2) {
        if (i2 <= zzeh.size()) {
            int i3 = i + i2;
            if (i3 > zzeh.size()) {
                int size = zzeh.size();
                StringBuilder sb = new StringBuilder(59);
                sb.append("Ran off end of other: ");
                sb.append(i);
                String str = ", ";
                sb.append(str);
                sb.append(i2);
                sb.append(str);
                sb.append(size);
                throw new IllegalArgumentException(sb.toString());
            } else if (!(zzeh instanceof zzeq)) {
                return zzeh.zzd(i, i3).equals(zzd(0, i2));
            } else {
                zzeq zzeq = (zzeq) zzeh;
                byte[] bArr = this.zzsw;
                byte[] bArr2 = zzeq.zzsw;
                int zzfe = zzfe() + i2;
                int zzfe2 = zzfe();
                int zzfe3 = zzeq.zzfe() + i;
                while (zzfe2 < zzfe) {
                    if (bArr[zzfe2] != bArr2[zzfe3]) {
                        return false;
                    }
                    zzfe2++;
                    zzfe3++;
                }
                return true;
            }
        } else {
            int size2 = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i2);
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public final int zzc(int i, int i2, int i3) {
        return zzfu.zza(i, this.zzsw, zzfe() + i2, i3);
    }

    /* access modifiers changed from: protected */
    public int zzfe() {
        return 0;
    }
}
