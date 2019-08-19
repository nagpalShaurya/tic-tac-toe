package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzfz;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgj;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzyy;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.BitSet;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class zzfg extends zzez {
    zzfg(zzfa zzfa) {
        super(zzfa);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgt() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzgl zzgl, Object obj) {
        Preconditions.checkNotNull(obj);
        zzgl.zzamp = null;
        zzgl.zzawx = null;
        zzgl.zzauh = null;
        if (obj instanceof String) {
            zzgl.zzamp = (String) obj;
        } else if (obj instanceof Long) {
            zzgl.zzawx = (Long) obj;
        } else if (obj instanceof Double) {
            zzgl.zzauh = (Double) obj;
        } else {
            zzgo().zzjd().zzg("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void zza(zzgg zzgg, Object obj) {
        Preconditions.checkNotNull(obj);
        zzgg.zzamp = null;
        zzgg.zzawx = null;
        zzgg.zzauh = null;
        if (obj instanceof String) {
            zzgg.zzamp = (String) obj;
        } else if (obj instanceof Long) {
            zzgg.zzawx = (Long) obj;
        } else if (obj instanceof Double) {
            zzgg.zzauh = (Double) obj;
        } else {
            zzgo().zzjd().zzg("Ignoring invalid (type) event param value", obj);
        }
    }

    /* access modifiers changed from: 0000 */
    public final byte[] zza(zzgh zzgh) {
        try {
            byte[] bArr = new byte[zzgh.zzvu()];
            zzyy zzk = zzyy.zzk(bArr, 0, bArr.length);
            zzgh.zza(zzk);
            zzk.zzyt();
            return bArr;
        } catch (IOException e) {
            zzgo().zzjd().zzg("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    static zzgg zza(zzgf zzgf, String str) {
        zzgg[] zzggArr;
        for (zzgg zzgg : zzgf.zzawt) {
            if (zzgg.name.equals(str)) {
                return zzgg;
            }
        }
        return null;
    }

    static Object zzb(zzgf zzgf, String str) {
        zzgg zza = zza(zzgf, str);
        if (zza != null) {
            if (zza.zzamp != null) {
                return zza.zzamp;
            }
            if (zza.zzawx != null) {
                return zza.zzawx;
            }
            if (zza.zzauh != null) {
                return zza.zzauh;
            }
        }
        return null;
    }

    static zzgg[] zza(zzgg[] zzggArr, String str, Object obj) {
        for (zzgg zzgg : zzggArr) {
            if (str.equals(zzgg.name)) {
                zzgg.zzawx = null;
                zzgg.zzamp = null;
                zzgg.zzauh = null;
                if (obj instanceof Long) {
                    zzgg.zzawx = (Long) obj;
                } else if (obj instanceof String) {
                    zzgg.zzamp = (String) obj;
                } else if (obj instanceof Double) {
                    zzgg.zzauh = (Double) obj;
                }
                return zzggArr;
            }
        }
        zzgg[] zzggArr2 = new zzgg[(zzggArr.length + 1)];
        System.arraycopy(zzggArr, 0, zzggArr2, 0, zzggArr.length);
        zzgg zzgg2 = new zzgg();
        zzgg2.name = str;
        if (obj instanceof Long) {
            zzgg2.zzawx = (Long) obj;
        } else if (obj instanceof String) {
            zzgg2.zzamp = (String) obj;
        } else if (obj instanceof Double) {
            zzgg2.zzauh = (Double) obj;
        }
        zzggArr2[zzggArr.length] = zzgg2;
        return zzggArr2;
    }

    /* access modifiers changed from: 0000 */
    public final String zzb(zzgh zzgh) {
        zzgi[] zzgiArr;
        zzgf[] zzgfArr;
        zzgf[] zzgfArr2;
        zzgi[] zzgiArr2;
        zzgh zzgh2 = zzgh;
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        String str = "}\n";
        if (zzgh2.zzawy != null) {
            zzgi[] zzgiArr3 = zzgh2.zzawy;
            int length = zzgiArr3.length;
            int i = 0;
            while (i < length) {
                zzgi zzgi = zzgiArr3[i];
                if (zzgi == null) {
                    zzgiArr = zzgiArr3;
                } else if (zzgi != null) {
                    zza(sb, 1);
                    sb.append("bundle {\n");
                    zza(sb, 1, "protocol_version", (Object) zzgi.zzaxa);
                    zza(sb, 1, "platform", (Object) zzgi.zzaxi);
                    zza(sb, 1, "gmp_version", (Object) zzgi.zzaxm);
                    zza(sb, 1, "uploading_gmp_version", (Object) zzgi.zzaxn);
                    zza(sb, 1, "config_version", (Object) zzgi.zzaxy);
                    zza(sb, 1, "gmp_app_id", (Object) zzgi.zzafx);
                    zza(sb, 1, "admob_app_id", (Object) zzgi.zzawj);
                    zza(sb, 1, "app_id", (Object) zzgi.zztt);
                    zza(sb, 1, "app_version", (Object) zzgi.zzts);
                    zza(sb, 1, "app_version_major", (Object) zzgi.zzaxu);
                    zza(sb, 1, "firebase_instance_id", (Object) zzgi.zzafz);
                    zza(sb, 1, "dev_cert_hash", (Object) zzgi.zzaxq);
                    zza(sb, 1, "app_store", (Object) zzgi.zzage);
                    zza(sb, 1, "upload_timestamp_millis", (Object) zzgi.zzaxd);
                    zza(sb, 1, "start_timestamp_millis", (Object) zzgi.zzaxe);
                    zza(sb, 1, "end_timestamp_millis", (Object) zzgi.zzaxf);
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", (Object) zzgi.zzaxg);
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", (Object) zzgi.zzaxh);
                    zza(sb, 1, "app_instance_id", (Object) zzgi.zzafw);
                    zza(sb, 1, "resettable_device_id", (Object) zzgi.zzaxo);
                    zza(sb, 1, "device_id", (Object) zzgi.zzaxx);
                    zza(sb, 1, "ds_id", (Object) zzgi.zzaya);
                    zza(sb, 1, "limited_ad_tracking", (Object) zzgi.zzaxp);
                    zza(sb, 1, "os_version", (Object) zzgi.zzaxj);
                    zza(sb, 1, "device_model", (Object) zzgi.zzaxk);
                    zza(sb, 1, "user_default_language", (Object) zzgi.zzaia);
                    zza(sb, 1, "time_zone_offset_minutes", (Object) zzgi.zzaxl);
                    zza(sb, 1, "bundle_sequential_index", (Object) zzgi.zzaxr);
                    zza(sb, 1, "service_upload", (Object) zzgi.zzaxs);
                    zza(sb, 1, "health_monitor", (Object) zzgi.zzagv);
                    if (!(zzgi.zzaxz == null || zzgi.zzaxz.longValue() == 0)) {
                        zza(sb, 1, "android_id", (Object) zzgi.zzaxz);
                    }
                    if (zzgi.zzayc != null) {
                        zza(sb, 1, "retry_counter", (Object) zzgi.zzayc);
                    }
                    zzgl[] zzglArr = zzgi.zzaxc;
                    String str2 = "double_value";
                    String str3 = "int_value";
                    String str4 = "string_value";
                    String str5 = "name";
                    int i2 = 2;
                    if (zzglArr != null) {
                        int length2 = zzglArr.length;
                        int i3 = 0;
                        while (i3 < length2) {
                            zzgl zzgl = zzglArr[i3];
                            if (zzgl != null) {
                                zza(sb, 2);
                                sb.append("user_property {\n");
                                zzgiArr2 = zzgiArr3;
                                zza(sb, 2, "set_timestamp_millis", (Object) zzgl.zzayl);
                                zza(sb, 2, str5, (Object) zzgl().zzbu(zzgl.name));
                                zza(sb, 2, str4, (Object) zzgl.zzamp);
                                zza(sb, 2, str3, (Object) zzgl.zzawx);
                                zza(sb, 2, str2, (Object) zzgl.zzauh);
                                zza(sb, 2);
                                sb.append(str);
                            } else {
                                zzgiArr2 = zzgiArr3;
                            }
                            i3++;
                            zzgiArr3 = zzgiArr2;
                        }
                        zzgiArr = zzgiArr3;
                    } else {
                        zzgiArr = zzgiArr3;
                    }
                    zzgd[] zzgdArr = zzgi.zzaxt;
                    if (zzgdArr != null) {
                        for (zzgd zzgd : zzgdArr) {
                            if (zzgd != null) {
                                zza(sb, 2);
                                sb.append("audience_membership {\n");
                                zza(sb, 2, "audience_id", (Object) zzgd.zzauy);
                                zza(sb, 2, "new_audience", (Object) zzgd.zzawo);
                                zza(sb, 2, "current_data", zzgd.zzawm);
                                zza(sb, 2, "previous_data", zzgd.zzawn);
                                zza(sb, 2);
                                sb.append(str);
                            }
                        }
                    }
                    zzgf[] zzgfArr3 = zzgi.zzaxb;
                    if (zzgfArr3 != null) {
                        int length3 = zzgfArr3.length;
                        int i4 = 0;
                        while (i4 < length3) {
                            zzgf zzgf = zzgfArr3[i4];
                            if (zzgf != null) {
                                zza(sb, i2);
                                sb.append("event {\n");
                                zza(sb, i2, str5, (Object) zzgl().zzbs(zzgf.name));
                                zza(sb, i2, "timestamp_millis", (Object) zzgf.zzawu);
                                zza(sb, i2, "previous_timestamp_millis", (Object) zzgf.zzawv);
                                zza(sb, i2, "count", (Object) zzgf.count);
                                zzgg[] zzggArr = zzgf.zzawt;
                                if (zzggArr != null) {
                                    int length4 = zzggArr.length;
                                    int i5 = 0;
                                    while (i5 < length4) {
                                        zzgg zzgg = zzggArr[i5];
                                        if (zzgg != null) {
                                            zza(sb, 3);
                                            sb.append("param {\n");
                                            zzgfArr2 = zzgfArr3;
                                            zza(sb, 3, str5, (Object) zzgl().zzbt(zzgg.name));
                                            zza(sb, 3, str4, (Object) zzgg.zzamp);
                                            zza(sb, 3, str3, (Object) zzgg.zzawx);
                                            zza(sb, 3, str2, (Object) zzgg.zzauh);
                                            zza(sb, 3);
                                            sb.append(str);
                                        } else {
                                            zzgfArr2 = zzgfArr3;
                                        }
                                        i5++;
                                        zzgfArr3 = zzgfArr2;
                                    }
                                    zzgfArr = zzgfArr3;
                                } else {
                                    zzgfArr = zzgfArr3;
                                }
                                zza(sb, 2);
                                sb.append(str);
                            } else {
                                zzgfArr = zzgfArr3;
                            }
                            i4++;
                            zzgfArr3 = zzgfArr;
                            i2 = 2;
                        }
                    }
                    zza(sb, 1);
                    sb.append(str);
                } else {
                    zzgiArr = zzgiArr3;
                }
                i++;
                zzgiArr3 = zzgiArr;
            }
        }
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public final String zza(zzfv zzfv) {
        if (zzfv == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        zza(sb, 0, "filter_id", (Object) zzfv.zzave);
        zza(sb, 0, "event_name", (Object) zzgl().zzbs(zzfv.zzavf));
        zza(sb, 1, "event_count_filter", zzfv.zzavi);
        sb.append("  filters {\n");
        for (zzfw zza : zzfv.zzavg) {
            zza(sb, 2, zza);
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public final String zza(zzfy zzfy) {
        if (zzfy == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        zza(sb, 0, "filter_id", (Object) zzfy.zzave);
        zza(sb, 0, "property_name", (Object) zzgl().zzbu(zzfy.zzavu));
        zza(sb, 1, zzfy.zzavv);
        sb.append("}\n");
        return sb.toString();
    }

    private static void zza(StringBuilder sb, int i, String str, zzgj zzgj) {
        if (zzgj != null) {
            zza(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            String str2 = ", ";
            int i2 = 0;
            if (zzgj.zzayf != null) {
                zza(sb, 4);
                sb.append("results: ");
                long[] jArr = zzgj.zzayf;
                int length = jArr.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    Long valueOf = Long.valueOf(jArr[i3]);
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(str2);
                    }
                    sb.append(valueOf);
                    i3++;
                    i4 = i5;
                }
                sb.append(10);
            }
            if (zzgj.zzaye != null) {
                zza(sb, 4);
                sb.append("status: ");
                long[] jArr2 = zzgj.zzaye;
                int length2 = jArr2.length;
                int i6 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(str2);
                    }
                    sb.append(valueOf2);
                    i2++;
                    i6 = i7;
                }
                sb.append(10);
            }
            zza(sb, 3);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, String str, zzfx zzfx) {
        String str2;
        if (zzfx != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzfx.zzavo != null) {
                int intValue = zzfx.zzavo.intValue();
                if (intValue == 1) {
                    str2 = "LESS_THAN";
                } else if (intValue == 2) {
                    str2 = "GREATER_THAN";
                } else if (intValue == 3) {
                    str2 = "EQUAL";
                } else if (intValue != 4) {
                    str2 = "UNKNOWN_COMPARISON_TYPE";
                } else {
                    str2 = "BETWEEN";
                }
                zza(sb, i, "comparison_type", (Object) str2);
            }
            zza(sb, i, "match_as_float", (Object) zzfx.zzavp);
            zza(sb, i, "comparison_value", (Object) zzfx.zzavq);
            zza(sb, i, "min_comparison_value", (Object) zzfx.zzavr);
            zza(sb, i, "max_comparison_value", (Object) zzfx.zzavs);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, zzfw zzfw) {
        String[] strArr;
        String str;
        if (zzfw != null) {
            zza(sb, i);
            sb.append("filter {\n");
            zza(sb, i, "complement", (Object) zzfw.zzavm);
            zza(sb, i, "param_name", (Object) zzgl().zzbt(zzfw.zzavn));
            int i2 = i + 1;
            zzfz zzfz = zzfw.zzavk;
            String str2 = "}\n";
            if (zzfz != null) {
                zza(sb, i2);
                sb.append("string_filter");
                sb.append(" {\n");
                if (zzfz.zzavw != null) {
                    switch (zzfz.zzavw.intValue()) {
                        case 1:
                            str = "REGEXP";
                            break;
                        case 2:
                            str = "BEGINS_WITH";
                            break;
                        case 3:
                            str = "ENDS_WITH";
                            break;
                        case 4:
                            str = "PARTIAL";
                            break;
                        case 5:
                            str = "EXACT";
                            break;
                        case 6:
                            str = "IN_LIST";
                            break;
                        default:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                    }
                    zza(sb, i2, "match_type", (Object) str);
                }
                zza(sb, i2, "expression", (Object) zzfz.zzavx);
                zza(sb, i2, "case_sensitive", (Object) zzfz.zzavy);
                if (zzfz.zzavz.length > 0) {
                    zza(sb, i2 + 1);
                    sb.append("expression_list {\n");
                    for (String str3 : zzfz.zzavz) {
                        zza(sb, i2 + 2);
                        sb.append(str3);
                        sb.append("\n");
                    }
                    sb.append(str2);
                }
                zza(sb, i2);
                sb.append(str2);
            }
            zza(sb, i2, "number_filter", zzfw.zzavl);
            zza(sb, i);
            sb.append(str2);
        }
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    /* access modifiers changed from: 0000 */
    public final <T extends Parcelable> T zza(byte[] bArr, Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(obtain);
        } catch (ParseException e) {
            zzgo().zzjd().zzbx("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zze(zzad zzad, zzh zzh) {
        Preconditions.checkNotNull(zzad);
        Preconditions.checkNotNull(zzh);
        if (!TextUtils.isEmpty(zzh.zzafx) || !TextUtils.isEmpty(zzh.zzagk)) {
            return true;
        }
        zzgr();
        return false;
    }

    static boolean zzcp(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean zza(long[] jArr, int i) {
        if (i >= (jArr.length << 6)) {
            return false;
        }
        if (((1 << (i % 64)) & jArr[i / 64]) != 0) {
            return true;
        }
        return false;
    }

    static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
            }
        }
        return jArr;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzb(long j, long j2) {
        if (j == 0 || j2 <= 0 || Math.abs(zzbx().currentTimeMillis() - j) > j2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    public final byte[] zza(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzgo().zzjd().zzg("Failed to ungzip content", e);
            throw e;
        }
    }

    /* access modifiers changed from: 0000 */
    public final byte[] zzb(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzgo().zzjd().zzg("Failed to gzip content", e);
            throw e;
        }
    }

    public final /* bridge */ /* synthetic */ zzfg zzjo() {
        return super.zzjo();
    }

    public final /* bridge */ /* synthetic */ zzj zzjp() {
        return super.zzjp();
    }

    public final /* bridge */ /* synthetic */ zzq zzjq() {
        return super.zzjq();
    }

    public final /* bridge */ /* synthetic */ void zzga() {
        super.zzga();
    }

    public final /* bridge */ /* synthetic */ void zzgb() {
        super.zzgb();
    }

    public final /* bridge */ /* synthetic */ void zzgc() {
        super.zzgc();
    }

    public final /* bridge */ /* synthetic */ void zzaf() {
        super.zzaf();
    }

    public final /* bridge */ /* synthetic */ zzx zzgk() {
        return super.zzgk();
    }

    public final /* bridge */ /* synthetic */ Clock zzbx() {
        return super.zzbx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzan zzgl() {
        return super.zzgl();
    }

    public final /* bridge */ /* synthetic */ zzfk zzgm() {
        return super.zzgm();
    }

    public final /* bridge */ /* synthetic */ zzbo zzgn() {
        return super.zzgn();
    }

    public final /* bridge */ /* synthetic */ zzap zzgo() {
        return super.zzgo();
    }

    public final /* bridge */ /* synthetic */ zzba zzgp() {
        return super.zzgp();
    }

    public final /* bridge */ /* synthetic */ zzn zzgq() {
        return super.zzgq();
    }

    public final /* bridge */ /* synthetic */ zzk zzgr() {
        return super.zzgr();
    }
}
