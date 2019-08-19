package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.p000v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

public final class zzfk extends zzcp {
    private static final String[] zzaui = {"firebase_", "google_", "ga_"};
    private int zzaed;
    private SecureRandom zzauj;
    private final AtomicLong zzauk = new AtomicLong(0);
    private Integer zzaul = null;

    zzfk(zzbt zzbt) {
        super(zzbt);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgt() {
        return true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzgu() {
        zzaf();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzgo().zzjg().zzbx("Utils falling back to Random for random id");
            }
        }
        this.zzauk.set(nextLong);
    }

    public final long zzmc() {
        long andIncrement;
        long j;
        if (this.zzauk.get() == 0) {
            synchronized (this.zzauk) {
                long nextLong = new Random(System.nanoTime() ^ zzbx().currentTimeMillis()).nextLong();
                int i = this.zzaed + 1;
                this.zzaed = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.zzauk) {
            this.zzauk.compareAndSet(-1, 1);
            andIncrement = this.zzauk.getAndIncrement();
        }
        return andIncrement;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final SecureRandom zzmd() {
        zzaf();
        if (this.zzauj == null) {
            this.zzauj = new SecureRandom();
        }
        return this.zzauj;
    }

    static boolean zzcq(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    /* access modifiers changed from: 0000 */
    public final Bundle zza(@NonNull Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            String str5 = "gclid";
            if (uri.isHierarchical()) {
                str4 = uri.getQueryParameter("utm_campaign");
                str3 = uri.getQueryParameter("utm_source");
                str2 = uri.getQueryParameter("utm_medium");
                str = uri.getQueryParameter(str5);
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString(Param.CAMPAIGN, str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(Param.SOURCE, str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString(Param.MEDIUM, str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString(str5, str);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(Param.TERM, queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(Param.CONTENT, queryParameter2);
            }
            String str6 = Param.ACLID;
            String queryParameter3 = uri.getQueryParameter(str6);
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(str6, queryParameter3);
            }
            String str7 = Param.CP1;
            String queryParameter4 = uri.getQueryParameter(str7);
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(str7, queryParameter4);
            }
            String str8 = "anid";
            String queryParameter5 = uri.getQueryParameter(str8);
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString(str8, queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzgo().zzjg().zzg("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    static boolean zzd(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzr(String str, String str2) {
        if (str2 == null) {
            zzgo().zzjd().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzgo().zzjd().zzg("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                zzgo().zzjd().zze("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    zzgo().zzjd().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    private final boolean zzs(String str, String str2) {
        if (str2 == null) {
            zzgo().zzjd().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzgo().zzjd().zzg("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        zzgo().zzjd().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzgo().zzjd().zze("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(String str, String[] strArr, String str2) {
        boolean z;
        boolean z2;
        if (str2 == null) {
            zzgo().zzjd().zzg("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr2 = zzaui;
        int length = strArr2.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (str2.startsWith(strArr2[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            zzgo().zzjd().zze("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            Preconditions.checkNotNull(strArr);
            int length2 = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    z2 = false;
                    break;
                } else if (zzu(str2, strArr[i2])) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                zzgo().zzjd().zze("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public final boolean zza(String str, int i, String str2) {
        if (str2 == null) {
            zzgo().zzjd().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzgo().zzjd().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public final int zzcr(String str) {
        String str2 = NotificationCompat.CATEGORY_EVENT;
        if (!zzs(str2, str)) {
            return 2;
        }
        if (!zza(str2, Event.zzadk, str)) {
            return 13;
        }
        if (!zza(str2, 40, str)) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public final int zzcs(String str) {
        String str2 = "user property";
        if (!zzs(str2, str)) {
            return 6;
        }
        if (!zza(str2, UserProperty.zzado, str)) {
            return 15;
        }
        if (!zza(str2, 24, str)) {
            return 6;
        }
        return 0;
    }

    private final boolean zza(String str, String str2, int i, Object obj, boolean z) {
        Parcelable[] parcelableArr;
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) <= i) {
                return true;
            }
            zzgo().zzjg().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
            return false;
        } else if ((obj instanceof Bundle) && z) {
            return true;
        } else {
            if ((obj instanceof Parcelable[]) && z) {
                for (Parcelable parcelable : (Parcelable[]) obj) {
                    if (!(parcelable instanceof Bundle)) {
                        zzgo().zzjg().zze("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str2);
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof ArrayList) || !z) {
                return false;
            } else {
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    if (!(obj2 instanceof Bundle)) {
                        zzgo().zzjg().zze("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                        return false;
                    }
                }
                return true;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzt(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!zzct(str)) {
                if (this.zzadj.zzkj()) {
                    zzgo().zzjd().zzg("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzap.zzbv(str));
                }
                return false;
            }
        } else if (TextUtils.isEmpty(str2)) {
            if (this.zzadj.zzkj()) {
                zzgo().zzjd().zzbx("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        } else if (!zzct(str2)) {
            zzgo().zzjd().zzg("Invalid gma_app_id. Analytics disabled.", zzap.zzbv(str2));
            return false;
        }
        return true;
    }

    static boolean zza(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    @VisibleForTesting
    private static boolean zzct(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    private static Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            return null;
        }
    }

    public static String zza(String str, int i, boolean z) {
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final Object zzh(String str, Object obj) {
        int i = 256;
        if ("_ev".equals(str)) {
            return zza(256, obj, true);
        }
        if (!zzcv(str)) {
            i = 100;
        }
        return zza(i, obj, false);
    }

    static Bundle[] zze(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zza(java.lang.String r19, java.lang.String r20, android.os.Bundle r21, @android.support.annotation.Nullable java.util.List<java.lang.String> r22, boolean r23, boolean r24) {
        /*
            r18 = this;
            r6 = r18
            r7 = r21
            r8 = r22
            r9 = 0
            if (r7 == 0) goto L_0x018c
            android.os.Bundle r10 = new android.os.Bundle
            r10.<init>(r7)
            java.util.Set r0 = r21.keySet()
            java.util.Iterator r11 = r0.iterator()
            r13 = 0
        L_0x0018:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x018d
            java.lang.Object r0 = r11.next()
            r14 = r0
            java.lang.String r14 = (java.lang.String) r14
            r15 = 40
            r0 = 3
            if (r8 == 0) goto L_0x0034
            boolean r1 = r8.contains(r14)
            if (r1 != 0) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            r1 = 0
            goto L_0x0074
        L_0x0034:
            r1 = 14
            java.lang.String r2 = "event param"
            if (r23 == 0) goto L_0x0056
            boolean r3 = r6.zzr(r2, r14)
            if (r3 != 0) goto L_0x0043
            r3 = 3
            goto L_0x0055
        L_0x0043:
            boolean r3 = r6.zza(r2, r9, r14)
            if (r3 != 0) goto L_0x004c
            r3 = 14
            goto L_0x0055
        L_0x004c:
            boolean r3 = r6.zza(r2, r15, r14)
            if (r3 != 0) goto L_0x0054
            r3 = 3
            goto L_0x0055
        L_0x0054:
            r3 = 0
        L_0x0055:
            goto L_0x0057
        L_0x0056:
            r3 = 0
        L_0x0057:
            if (r3 != 0) goto L_0x0073
            boolean r3 = r6.zzs(r2, r14)
            if (r3 != 0) goto L_0x0062
            r1 = 3
            goto L_0x0072
        L_0x0062:
            boolean r3 = r6.zza(r2, r9, r14)
            if (r3 != 0) goto L_0x0069
            goto L_0x0072
        L_0x0069:
            boolean r1 = r6.zza(r2, r15, r14)
            if (r1 != 0) goto L_0x0071
            r1 = 3
            goto L_0x0072
        L_0x0071:
            r1 = 0
        L_0x0072:
            goto L_0x0074
        L_0x0073:
            r1 = r3
        L_0x0074:
            java.lang.String r5 = "_ev"
            r4 = 1
            if (r1 == 0) goto L_0x0091
            boolean r2 = zza(r10, r1)
            if (r2 == 0) goto L_0x008c
            java.lang.String r2 = zza(r14, r15, r4)
            r10.putString(r5, r2)
            if (r1 != r0) goto L_0x008c
            zza(r10, r14)
        L_0x008c:
            r10.remove(r14)
            goto L_0x013e
        L_0x0091:
            java.lang.Object r3 = r7.get(r14)
            r18.zzaf()
            if (r24 == 0) goto L_0x00d5
            boolean r0 = r3 instanceof android.os.Parcelable[]
            if (r0 == 0) goto L_0x00a7
            r0 = r3
            android.os.Parcelable[] r0 = (android.os.Parcelable[]) r0
            int r0 = r0.length
            goto L_0x00b2
        L_0x00a7:
            boolean r0 = r3 instanceof java.util.ArrayList
            if (r0 == 0) goto L_0x00cd
            r0 = r3
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r0 = r0.size()
        L_0x00b2:
            r1 = 1000(0x3e8, float:1.401E-42)
            if (r0 <= r1) goto L_0x00cb
            com.google.android.gms.measurement.internal.zzap r1 = r18.zzgo()
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjg()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = "param"
            java.lang.String r4 = "Parameter array is too long; discarded. Value kind, name, array length"
            r1.zzd(r4, r2, r14, r0)
            r0 = 0
            goto L_0x00ce
        L_0x00cb:
            r0 = 1
            goto L_0x00ce
        L_0x00cd:
            r0 = 1
        L_0x00ce:
            if (r0 != 0) goto L_0x00d5
            r0 = 17
            r12 = r5
            r9 = 1
            goto L_0x011c
        L_0x00d5:
            com.google.android.gms.measurement.internal.zzn r0 = r18.zzgq()
            r4 = r19
            boolean r0 = r0.zzay(r4)
            if (r0 == 0) goto L_0x00e7
            boolean r0 = zzcv(r20)
            if (r0 != 0) goto L_0x00ed
        L_0x00e7:
            boolean r0 = zzcv(r14)
            if (r0 == 0) goto L_0x0104
        L_0x00ed:
            r16 = 256(0x100, float:3.59E-43)
            java.lang.String r1 = "param"
            r0 = r18
            r2 = r14
            r17 = r3
            r3 = r16
            r9 = 1
            r4 = r17
            r12 = r5
            r5 = r24
            boolean r0 = r0.zza(r1, r2, r3, r4, r5)
            goto L_0x0117
        L_0x0104:
            r17 = r3
            r12 = r5
            r9 = 1
            r3 = 100
            java.lang.String r1 = "param"
            r0 = r18
            r2 = r14
            r4 = r17
            r5 = r24
            boolean r0 = r0.zza(r1, r2, r3, r4, r5)
        L_0x0117:
            if (r0 == 0) goto L_0x011b
            r0 = 0
            goto L_0x011c
        L_0x011b:
            r0 = 4
        L_0x011c:
            if (r0 == 0) goto L_0x0141
            boolean r1 = r12.equals(r14)
            if (r1 != 0) goto L_0x0141
            boolean r0 = zza(r10, r0)
            if (r0 == 0) goto L_0x013a
            java.lang.String r0 = zza(r14, r15, r9)
            r10.putString(r12, r0)
            java.lang.Object r0 = r7.get(r14)
            zza(r10, r0)
        L_0x013a:
            r10.remove(r14)
        L_0x013e:
            r9 = 0
            goto L_0x0018
        L_0x0141:
            boolean r0 = zzcq(r14)
            if (r0 == 0) goto L_0x0187
            int r13 = r13 + 1
            r0 = 25
            if (r13 <= r0) goto L_0x0184
            r0 = 48
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Event can't contain more than 25 params"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.measurement.internal.zzap r1 = r18.zzgo()
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()
            com.google.android.gms.measurement.internal.zzan r2 = r18.zzgl()
            r3 = r20
            java.lang.String r2 = r2.zzbs(r3)
            com.google.android.gms.measurement.internal.zzan r4 = r18.zzgl()
            java.lang.String r4 = r4.zzd(r7)
            r1.zze(r0, r2, r4)
            r0 = 5
            zza(r10, r0)
            r10.remove(r14)
            r9 = 0
            goto L_0x0018
        L_0x0184:
            r3 = r20
            goto L_0x0189
        L_0x0187:
            r3 = r20
        L_0x0189:
            r9 = 0
            goto L_0x0018
        L_0x018c:
            r10 = 0
        L_0x018d:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfk.zza(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean, boolean):android.os.Bundle");
    }

    private static boolean zza(Bundle bundle, int i) {
        String str = "_err";
        if (bundle.getLong(str) != 0) {
            return false;
        }
        bundle.putLong(str, (long) i);
        return true;
    }

    private static void zza(Bundle bundle, Object obj) {
        Preconditions.checkNotNull(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    private static int zzcu(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return 36;
    }

    /* access modifiers changed from: 0000 */
    public final int zzi(String str, Object obj) {
        boolean z;
        if ("_ldl".equals(str)) {
            z = zza("user property referrer", str, zzcu(str), obj, false);
        } else {
            z = zza("user property", str, zzcu(str), obj, false);
        }
        return z ? 0 : 7;
    }

    /* access modifiers changed from: 0000 */
    public final Object zzj(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zza(zzcu(str), obj, true);
        }
        return zza(zzcu(str), obj, false);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else {
                if (str != null) {
                    zzgo().zzji().zze("Not putting event parameter. Invalid value type. name, type", zzgl().zzbt(str), obj != null ? obj.getClass().getSimpleName() : null);
                }
            }
        }
    }

    public final void zza(int i, String str, String str2, int i2) {
        zza((String) null, i, str, str2, i2);
    }

    /* access modifiers changed from: 0000 */
    public final void zza(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zza(bundle, i);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.zzadj.zzgr();
        this.zzadj.zzge().logEvent("auto", "_err", bundle);
    }

    static MessageDigest getMessageDigest() {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    @VisibleForTesting
    static long zzc(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i = 0;
        Preconditions.checkState(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    static boolean zza(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        if (VERSION.SDK_INT >= 24) {
            return zzc(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return zzc(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    private static boolean zzc(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
        }
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final boolean zzx(String str) {
        zzaf();
        if (Wrappers.packageManager(getContext()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzgo().zzjk().zzg("Permission not granted", str);
        return false;
    }

    static boolean zzcv(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zzu(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    /* access modifiers changed from: 0000 */
    public final boolean zzcw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String zzhy = zzgq().zzhy();
        zzgr();
        return zzhy.equals(str);
    }

    /* access modifiers changed from: 0000 */
    public final Bundle zze(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzh = zzh(str, bundle.get(str));
                if (zzh == null) {
                    zzgo().zzjg().zzg("Param value can't be null", zzgl().zzbt(str));
                } else {
                    zza(bundle2, str, zzh);
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: 0000 */
    public final zzad zza(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzcr(str2) == 0) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            String str4 = "_o";
            bundle2.putString(str4, str3);
            zzad zzad = new zzad(str2, new zzaa(zze(zza(str, str2, bundle2, CollectionUtils.listOf(str4), false, false))), str3, j);
            return zzad;
        }
        zzgo().zzjd().zzg("Invalid conditional property event name", zzgl().zzbu(str2));
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final long zzd(Context context, String str) {
        zzaf();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest messageDigest = getMessageDigest();
        if (messageDigest == null) {
            zzgo().zzjd().zzbx("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (zze(context, str)) {
                    return 0;
                }
                PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(getContext().getPackageName(), 64);
                if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                    return zzc(messageDigest.digest(packageInfo.signatures[0].toByteArray()));
                }
                zzgo().zzjg().zzbx("Could not get signatures");
                return -1;
            } catch (NameNotFoundException e) {
                zzgo().zzjd().zzg("Package name not found", e);
            }
        }
        return 0;
    }

    @VisibleForTesting
    private final boolean zze(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
        } catch (CertificateException e) {
            zzgo().zzjd().zzg("Error obtaining certificate", e);
        } catch (NameNotFoundException e2) {
            zzgo().zzjd().zzg("Package name not found", e2);
        }
        return true;
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static Bundle zzf(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        if (parcelableArr[i] instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        return bundle2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039 A[Catch:{ IOException -> 0x003f, ClassNotFoundException -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0043 A[Catch:{ IOException -> 0x003f, ClassNotFoundException -> 0x003d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object zzf(java.lang.Object r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0034 }
            r1.<init>()     // Catch:{ all -> 0x0034 }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0034 }
            r2.<init>(r1)     // Catch:{ all -> 0x0034 }
            r2.writeObject(r4)     // Catch:{ all -> 0x0031 }
            r2.flush()     // Catch:{ all -> 0x0031 }
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch:{ all -> 0x0031 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0031 }
            byte[] r1 = r1.toByteArray()     // Catch:{ all -> 0x0031 }
            r3.<init>(r1)     // Catch:{ all -> 0x0031 }
            r4.<init>(r3)     // Catch:{ all -> 0x0031 }
            java.lang.Object r1 = r4.readObject()     // Catch:{ all -> 0x002f }
            r2.close()     // Catch:{ IOException -> 0x003f, ClassNotFoundException -> 0x003d }
            r4.close()     // Catch:{ IOException -> 0x003f, ClassNotFoundException -> 0x003d }
            return r1
        L_0x002f:
            r1 = move-exception
            goto L_0x0037
        L_0x0031:
            r1 = move-exception
            r4 = r0
            goto L_0x0037
        L_0x0034:
            r1 = move-exception
            r4 = r0
            r2 = r4
        L_0x0037:
            if (r2 == 0) goto L_0x0041
            r2.close()     // Catch:{ IOException -> 0x003f, ClassNotFoundException -> 0x003d }
            goto L_0x0041
        L_0x003d:
            r4 = move-exception
            goto L_0x0047
        L_0x003f:
            r4 = move-exception
            goto L_0x0047
        L_0x0041:
            if (r4 == 0) goto L_0x0046
            r4.close()     // Catch:{ IOException -> 0x003f, ClassNotFoundException -> 0x003d }
        L_0x0046:
            throw r1     // Catch:{ IOException -> 0x003f, ClassNotFoundException -> 0x003d }
        L_0x0047:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfk.zzf(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public static String zza(String str, String[] strArr, String[] strArr2) {
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            if (zzu(str, strArr[i])) {
                return strArr2[i];
            }
        }
        return null;
    }

    public final int zzme() {
        if (this.zzaul == null) {
            this.zzaul = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(getContext()) / 1000);
        }
        return this.zzaul.intValue();
    }

    public static long zzc(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final String zzmf() {
        byte[] bArr = new byte[16];
        zzmd().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
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
