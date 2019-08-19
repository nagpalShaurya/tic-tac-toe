package com.google.android.gms.measurement.internal;

import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzfz;
import com.google.android.gms.internal.measurement.zzge;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzj extends zzez {
    zzj(zzfa zzfa) {
        super(zzfa);
    }

    /* access modifiers changed from: protected */
    public final boolean zzgt() {
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x038e  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0403  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0458  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0480  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0494  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x04a3  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x030c  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzgd[] zza(java.lang.String r52, com.google.android.gms.internal.measurement.zzgf[] r53, com.google.android.gms.internal.measurement.zzgl[] r54) {
        /*
            r51 = this;
            r7 = r51
            r15 = r52
            r13 = r53
            r14 = r54
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r52)
            java.util.HashSet r11 = new java.util.HashSet
            r11.<init>()
            android.support.v4.util.ArrayMap r12 = new android.support.v4.util.ArrayMap
            r12.<init>()
            android.support.v4.util.ArrayMap r10 = new android.support.v4.util.ArrayMap
            r10.<init>()
            android.support.v4.util.ArrayMap r9 = new android.support.v4.util.ArrayMap
            r9.<init>()
            android.support.v4.util.ArrayMap r8 = new android.support.v4.util.ArrayMap
            r8.<init>()
            android.support.v4.util.ArrayMap r6 = new android.support.v4.util.ArrayMap
            r6.<init>()
            com.google.android.gms.measurement.internal.zzn r0 = r51.zzgq()
            com.google.android.gms.measurement.internal.zzaf$zza<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzaf.zzakw
            boolean r23 = r0.zzd(r15, r1)
            com.google.android.gms.measurement.internal.zzq r0 = r51.zzjq()
            java.util.Map r0 = r0.zzbo(r15)
            r5 = 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r5)
            if (r0 == 0) goto L_0x01a4
            java.util.Set r1 = r0.keySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x004c:
            boolean r16 = r1.hasNext()
            if (r16 == 0) goto L_0x019b
            java.lang.Object r16 = r1.next()
            java.lang.Integer r16 = (java.lang.Integer) r16
            int r16 = r16.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r16)
            java.lang.Object r4 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzgj r4 = (com.google.android.gms.internal.measurement.zzgj) r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r16)
            java.lang.Object r5 = r10.get(r5)
            java.util.BitSet r5 = (java.util.BitSet) r5
            java.lang.Integer r2 = java.lang.Integer.valueOf(r16)
            java.lang.Object r2 = r9.get(r2)
            java.util.BitSet r2 = (java.util.BitSet) r2
            if (r23 == 0) goto L_0x00c7
            r20 = r0
            android.support.v4.util.ArrayMap r0 = new android.support.v4.util.ArrayMap
            r0.<init>()
            if (r4 == 0) goto L_0x00b6
            r21 = r1
            com.google.android.gms.internal.measurement.zzge[] r1 = r4.zzayg
            if (r1 != 0) goto L_0x0093
            r22 = r2
            r24 = r3
            goto L_0x00bc
        L_0x0093:
            com.google.android.gms.internal.measurement.zzge[] r1 = r4.zzayg
            r22 = r2
            int r2 = r1.length
            r24 = r3
            r3 = 0
        L_0x009b:
            if (r3 >= r2) goto L_0x00b5
            r25 = r2
            r2 = r1[r3]
            r26 = r1
            java.lang.Integer r1 = r2.zzawq
            if (r1 == 0) goto L_0x00ae
            java.lang.Integer r1 = r2.zzawq
            java.lang.Long r2 = r2.zzawr
            r0.put(r1, r2)
        L_0x00ae:
            int r3 = r3 + 1
            r2 = r25
            r1 = r26
            goto L_0x009b
        L_0x00b5:
            goto L_0x00bd
        L_0x00b6:
            r21 = r1
            r22 = r2
            r24 = r3
        L_0x00bc:
        L_0x00bd:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r16)
            r8.put(r1, r0)
            goto L_0x00d0
        L_0x00c7:
            r20 = r0
            r21 = r1
            r22 = r2
            r24 = r3
            r0 = 0
        L_0x00d0:
            if (r5 != 0) goto L_0x00eb
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r16)
            r10.put(r1, r5)
            java.util.BitSet r2 = new java.util.BitSet
            r2.<init>()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r16)
            r9.put(r1, r2)
            goto L_0x00ed
        L_0x00eb:
            r2 = r22
        L_0x00ed:
            r1 = 0
        L_0x00ee:
            long[] r3 = r4.zzaye
            int r3 = r3.length
            int r3 = r3 << 6
            if (r1 >= r3) goto L_0x0144
            long[] r3 = r4.zzaye
            boolean r3 = com.google.android.gms.measurement.internal.zzfg.zza(r3, r1)
            if (r3 == 0) goto L_0x0129
            com.google.android.gms.measurement.internal.zzap r3 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r3 = r3.zzjl()
            r22 = r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r16)
            r25 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r1)
            r26 = r10
            java.lang.String r10 = "Filter already evaluated. audience ID, filter ID"
            r3.zze(r10, r8, r9)
            r2.set(r1)
            long[] r3 = r4.zzayf
            boolean r3 = com.google.android.gms.measurement.internal.zzfg.zza(r3, r1)
            if (r3 == 0) goto L_0x012f
            r5.set(r1)
            r3 = 1
            goto L_0x0130
        L_0x0129:
            r22 = r8
            r25 = r9
            r26 = r10
        L_0x012f:
            r3 = 0
        L_0x0130:
            if (r0 == 0) goto L_0x013b
            if (r3 != 0) goto L_0x013b
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            r0.remove(r3)
        L_0x013b:
            int r1 = r1 + 1
            r8 = r22
            r9 = r25
            r10 = r26
            goto L_0x00ee
        L_0x0144:
            r22 = r8
            r25 = r9
            r26 = r10
            com.google.android.gms.internal.measurement.zzgd r1 = new com.google.android.gms.internal.measurement.zzgd
            r1.<init>()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            r12.put(r3, r1)
            r3 = 0
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r3)
            r1.zzawo = r8
            r1.zzawn = r4
            com.google.android.gms.internal.measurement.zzgj r3 = new com.google.android.gms.internal.measurement.zzgj
            r3.<init>()
            r1.zzawm = r3
            com.google.android.gms.internal.measurement.zzgj r3 = r1.zzawm
            long[] r4 = com.google.android.gms.measurement.internal.zzfg.zza(r5)
            r3.zzayf = r4
            com.google.android.gms.internal.measurement.zzgj r3 = r1.zzawm
            long[] r2 = com.google.android.gms.measurement.internal.zzfg.zza(r2)
            r3.zzaye = r2
            if (r23 == 0) goto L_0x018c
            com.google.android.gms.internal.measurement.zzgj r1 = r1.zzawm
            com.google.android.gms.internal.measurement.zzge[] r0 = zzd(r0)
            r1.zzayg = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r16)
            android.support.v4.util.ArrayMap r1 = new android.support.v4.util.ArrayMap
            r1.<init>()
            r6.put(r0, r1)
        L_0x018c:
            r0 = r20
            r1 = r21
            r8 = r22
            r3 = r24
            r9 = r25
            r10 = r26
            r5 = 1
            goto L_0x004c
        L_0x019b:
            r24 = r3
            r22 = r8
            r25 = r9
            r26 = r10
            goto L_0x01ac
        L_0x01a4:
            r24 = r3
            r22 = r8
            r25 = r9
            r26 = r10
        L_0x01ac:
            java.lang.String r9 = "Filter definition"
            java.lang.String r4 = "Skipping failed audience ID"
            java.lang.String r27 = "null"
            if (r13 == 0) goto L_0x0908
            android.support.v4.util.ArrayMap r5 = new android.support.v4.util.ArrayMap
            r5.<init>()
            int r3 = r13.length
            r28 = 0
            r20 = r28
            r0 = 0
            r1 = 0
            r2 = 0
        L_0x01c4:
            if (r2 >= r3) goto L_0x08f4
            r14 = r13[r2]
            java.lang.String r8 = r14.name
            com.google.android.gms.internal.measurement.zzgg[] r10 = r14.zzawt
            r30 = r2
            com.google.android.gms.measurement.internal.zzn r2 = r51.zzgq()
            r31 = r3
            com.google.android.gms.measurement.internal.zzaf$zza<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzaf.zzakq
            boolean r2 = r2.zzd(r15, r3)
            if (r2 == 0) goto L_0x03e2
            r51.zzjo()
            java.lang.String r2 = "_eid"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfg.zzb(r14, r2)
            java.lang.Long r3 = (java.lang.Long) r3
            if (r3 == 0) goto L_0x01ec
            r32 = 1
            goto L_0x01ee
        L_0x01ec:
            r32 = 0
        L_0x01ee:
            if (r32 == 0) goto L_0x01fc
            r33 = r4
            java.lang.String r4 = "_ep"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x01fe
            r4 = 1
            goto L_0x01ff
        L_0x01fc:
            r33 = r4
        L_0x01fe:
            r4 = 0
        L_0x01ff:
            if (r4 == 0) goto L_0x038e
            r51.zzjo()
            java.lang.String r4 = "_en"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfg.zzb(r14, r4)
            r8 = r4
            java.lang.String r8 = (java.lang.String) r8
            boolean r4 = android.text.TextUtils.isEmpty(r8)
            if (r4 == 0) goto L_0x0231
            com.google.android.gms.measurement.internal.zzap r2 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjd()
            java.lang.String r4 = "Extra parameter without an event name. eventId"
            r2.zzg(r4, r3)
            r34 = r0
            r39 = r5
            r41 = r6
            r38 = r24
            r24 = r31
            r40 = r33
            r31 = 1
            goto L_0x037d
        L_0x0231:
            if (r0 == 0) goto L_0x0246
            if (r1 == 0) goto L_0x0246
            long r34 = r3.longValue()
            long r36 = r1.longValue()
            int r4 = (r34 > r36 ? 1 : (r34 == r36 ? 0 : -1))
            if (r4 == 0) goto L_0x0242
            goto L_0x0246
        L_0x0242:
            r4 = r0
            r32 = r1
            goto L_0x027e
        L_0x0246:
            com.google.android.gms.measurement.internal.zzq r4 = r51.zzjq()
            android.util.Pair r4 = r4.zza(r15, r3)
            if (r4 == 0) goto L_0x0361
            r34 = r0
            java.lang.Object r0 = r4.first
            if (r0 != 0) goto L_0x0265
            r39 = r5
            r41 = r6
            r38 = r24
            r24 = r31
            r40 = r33
            r31 = 1
            goto L_0x036f
        L_0x0265:
            java.lang.Object r0 = r4.first
            com.google.android.gms.internal.measurement.zzgf r0 = (com.google.android.gms.internal.measurement.zzgf) r0
            java.lang.Object r1 = r4.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r20 = r1.longValue()
            r51.zzjo()
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzfg.zzb(r0, r2)
            java.lang.Long r1 = (java.lang.Long) r1
            r4 = r0
            r32 = r1
        L_0x027e:
            r0 = 1
            long r20 = r20 - r0
            int r0 = (r20 > r28 ? 1 : (r20 == r28 ? 0 : -1))
            if (r0 > 0) goto L_0x02dd
            com.google.android.gms.measurement.internal.zzq r1 = r51.zzjq()
            r1.zzaf()
            com.google.android.gms.measurement.internal.zzap r0 = r1.zzgo()
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjl()
            java.lang.String r2 = "Clearing complex main event info. appId"
            r0.zzg(r2, r15)
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch:{ SQLiteException -> 0x02bd }
            java.lang.String r2 = "delete from main_event_params where app_id=?"
            r18 = r4
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x02bb }
            r19 = 0
            r4[r19] = r15     // Catch:{ SQLiteException -> 0x02b9 }
            r0.execSQL(r2, r4)     // Catch:{ SQLiteException -> 0x02b9 }
            r39 = r5
            r41 = r6
            r38 = r24
            r24 = r31
            r40 = r33
            r31 = 1
            goto L_0x02fb
        L_0x02b9:
            r0 = move-exception
            goto L_0x02c3
        L_0x02bb:
            r0 = move-exception
            goto L_0x02c1
        L_0x02bd:
            r0 = move-exception
            r18 = r4
            r3 = 1
        L_0x02c1:
            r19 = 0
        L_0x02c3:
            com.google.android.gms.measurement.internal.zzap r1 = r1.zzgo()
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjd()
            java.lang.String r2 = "Error clearing complex main event"
            r1.zzg(r2, r0)
            r39 = r5
            r41 = r6
            r38 = r24
            r24 = r31
            r40 = r33
            r31 = 1
            goto L_0x02fb
        L_0x02dd:
            r18 = r4
            r4 = 1
            r19 = 0
            com.google.android.gms.measurement.internal.zzq r1 = r51.zzjq()
            r2 = r52
            r38 = r24
            r24 = r31
            r39 = r5
            r40 = r33
            r31 = 1
            r4 = r20
            r41 = r6
            r6 = r18
            r1.zza(r2, r3, r4, r6)
        L_0x02fb:
            r1 = r18
            com.google.android.gms.internal.measurement.zzgg[] r0 = r1.zzawt
            int r0 = r0.length
            int r2 = r10.length
            int r0 = r0 + r2
            com.google.android.gms.internal.measurement.zzgg[] r0 = new com.google.android.gms.internal.measurement.zzgg[r0]
            com.google.android.gms.internal.measurement.zzgg[] r2 = r1.zzawt
            int r3 = r2.length
            r4 = 0
            r5 = 0
        L_0x030a:
            if (r4 >= r3) goto L_0x0326
            r6 = r2[r4]
            r51.zzjo()
            r18 = r1
            java.lang.String r1 = r6.name
            com.google.android.gms.internal.measurement.zzgg r1 = com.google.android.gms.measurement.internal.zzfg.zza(r14, r1)
            if (r1 != 0) goto L_0x0321
            int r1 = r5 + 1
            r0[r5] = r6
            r5 = r1
        L_0x0321:
            int r4 = r4 + 1
            r1 = r18
            goto L_0x030a
        L_0x0326:
            r18 = r1
            if (r5 <= 0) goto L_0x034b
            int r1 = r10.length
            r2 = 0
        L_0x032c:
            if (r2 >= r1) goto L_0x0338
            r3 = r10[r2]
            int r4 = r5 + 1
            r0[r5] = r3
            int r2 = r2 + 1
            r5 = r4
            goto L_0x032c
        L_0x0338:
            int r1 = r0.length
            if (r5 != r1) goto L_0x033c
            goto L_0x0342
        L_0x033c:
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r5)
            com.google.android.gms.internal.measurement.zzgg[] r0 = (com.google.android.gms.internal.measurement.zzgg[]) r0
        L_0x0342:
            r33 = r0
            r0 = r8
            r34 = r18
            r35 = r20
            goto L_0x03f7
        L_0x034b:
            com.google.android.gms.measurement.internal.zzap r0 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjg()
            java.lang.String r1 = "No unique parameters in main event. eventName"
            r0.zzg(r1, r8)
            r0 = r8
            r33 = r10
            r34 = r18
            r35 = r20
            goto L_0x03f7
        L_0x0361:
            r34 = r0
            r39 = r5
            r41 = r6
            r38 = r24
            r24 = r31
            r40 = r33
            r31 = 1
        L_0x036f:
            com.google.android.gms.measurement.internal.zzap r0 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjd()
            java.lang.String r2 = "Extra parameter without existing main event. eventName, eventId"
            r0.zze(r2, r8, r3)
        L_0x037d:
            r45 = r9
            r14 = r11
            r50 = r12
            r43 = r22
            r44 = r25
            r46 = r26
            r0 = r34
            r49 = r38
            goto L_0x08d3
        L_0x038e:
            r34 = r0
            r39 = r5
            r41 = r6
            r38 = r24
            r24 = r31
            r40 = r33
            r31 = 1
            if (r32 == 0) goto L_0x03f0
            r51.zzjo()
            java.lang.Long r0 = java.lang.Long.valueOf(r28)
            java.lang.String r1 = "_epc"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzfg.zzb(r14, r1)
            if (r1 != 0) goto L_0x03b1
            goto L_0x03b2
        L_0x03b1:
            r0 = r1
        L_0x03b2:
            java.lang.Long r0 = (java.lang.Long) r0
            long r17 = r0.longValue()
            int r0 = (r17 > r28 ? 1 : (r17 == r28 ? 0 : -1))
            if (r0 > 0) goto L_0x03cb
            com.google.android.gms.measurement.internal.zzap r0 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjg()
            java.lang.String r1 = "Complex event with zero extra param count. eventName"
            r0.zzg(r1, r8)
            r0 = r3
            goto L_0x03d8
        L_0x03cb:
            com.google.android.gms.measurement.internal.zzq r1 = r51.zzjq()
            r2 = r52
            r0 = r3
            r4 = r17
            r6 = r14
            r1.zza(r2, r3, r4, r6)
        L_0x03d8:
            r32 = r0
            r0 = r8
            r33 = r10
            r34 = r14
            r35 = r17
            goto L_0x03f7
        L_0x03e2:
            r34 = r0
            r40 = r4
            r39 = r5
            r41 = r6
            r38 = r24
            r24 = r31
            r31 = 1
        L_0x03f0:
            r32 = r1
            r0 = r8
            r33 = r10
            r35 = r20
        L_0x03f7:
            com.google.android.gms.measurement.internal.zzq r1 = r51.zzjq()
            java.lang.String r2 = r14.name
            com.google.android.gms.measurement.internal.zzz r1 = r1.zzg(r15, r2)
            if (r1 != 0) goto L_0x0458
            com.google.android.gms.measurement.internal.zzap r1 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjg()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzap.zzbv(r52)
            com.google.android.gms.measurement.internal.zzan r3 = r51.zzgl()
            java.lang.String r3 = r3.zzbs(r0)
            java.lang.String r4 = "Event aggregate wasn't created during raw event logging. appId, event"
            r1.zze(r4, r2, r3)
            com.google.android.gms.measurement.internal.zzz r1 = new com.google.android.gms.measurement.internal.zzz
            java.lang.String r10 = r14.name
            r2 = 1
            r4 = 1
            java.lang.Long r6 = r14.zzawu
            long r17 = r6.longValue()
            r19 = 0
            r6 = 0
            r21 = 0
            r37 = 0
            r42 = 0
            r43 = r22
            r8 = r1
            r45 = r9
            r44 = r25
            r9 = r52
            r46 = r26
            r47 = r11
            r48 = r12
            r11 = r2
            r3 = r54
            r2 = r14
            r13 = r4
            r5 = r15
            r15 = r17
            r17 = r19
            r19 = r6
            r20 = r21
            r21 = r37
            r22 = r42
            r8.<init>(r9, r10, r11, r13, r15, r17, r19, r20, r21, r22)
            goto L_0x046c
        L_0x0458:
            r3 = r54
            r45 = r9
            r47 = r11
            r48 = r12
            r2 = r14
            r5 = r15
            r43 = r22
            r44 = r25
            r46 = r26
            com.google.android.gms.measurement.internal.zzz r1 = r1.zziu()
        L_0x046c:
            com.google.android.gms.measurement.internal.zzq r4 = r51.zzjq()
            r4.zza(r1)
            long r8 = r1.zzaie
            r10 = r39
            java.lang.Object r1 = r10.get(r0)
            java.util.Map r1 = (java.util.Map) r1
            if (r1 != 0) goto L_0x0494
            com.google.android.gms.measurement.internal.zzq r1 = r51.zzjq()
            java.util.Map r1 = r1.zzl(r5, r0)
            if (r1 != 0) goto L_0x048f
            android.support.v4.util.ArrayMap r1 = new android.support.v4.util.ArrayMap
            r1.<init>()
        L_0x048f:
            r10.put(r0, r1)
            r11 = r1
            goto L_0x0495
        L_0x0494:
            r11 = r1
        L_0x0495:
            java.util.Set r1 = r11.keySet()
            java.util.Iterator r12 = r1.iterator()
        L_0x049d:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x08c5
            java.lang.Object r1 = r12.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r13 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r14 = r47
            boolean r1 = r14.contains(r1)
            if (r1 == 0) goto L_0x04cd
            com.google.android.gms.measurement.internal.zzap r1 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjl()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
            r15 = r40
            r1.zzg(r15, r4)
            r47 = r14
            goto L_0x049d
        L_0x04cd:
            r15 = r40
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r6 = r48
            java.lang.Object r1 = r6.get(r1)
            com.google.android.gms.internal.measurement.zzgd r1 = (com.google.android.gms.internal.measurement.zzgd) r1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
            r39 = r10
            r10 = r46
            java.lang.Object r4 = r10.get(r4)
            java.util.BitSet r4 = (java.util.BitSet) r4
            r16 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r17 = r12
            r12 = r44
            java.lang.Object r2 = r12.get(r2)
            java.util.BitSet r2 = (java.util.BitSet) r2
            if (r23 == 0) goto L_0x051e
            r18 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r7 = r43
            java.lang.Object r2 = r7.get(r2)
            java.util.Map r2 = (java.util.Map) r2
            r19 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r40 = r15
            r15 = r41
            java.lang.Object r2 = r15.get(r2)
            java.util.Map r2 = (java.util.Map) r2
            goto L_0x0529
        L_0x051e:
            r18 = r2
            r40 = r15
            r15 = r41
            r7 = r43
            r2 = 0
            r19 = 0
        L_0x0529:
            if (r1 != 0) goto L_0x0594
            com.google.android.gms.internal.measurement.zzgd r1 = new com.google.android.gms.internal.measurement.zzgd
            r1.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
            r6.put(r4, r1)
            r4 = r38
            r1.zzawo = r4
            java.util.BitSet r1 = new java.util.BitSet
            r1.<init>()
            r20 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r10.put(r2, r1)
            java.util.BitSet r2 = new java.util.BitSet
            r2.<init>()
            r18 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r12.put(r1, r2)
            if (r23 == 0) goto L_0x0584
            android.support.v4.util.ArrayMap r1 = new android.support.v4.util.ArrayMap
            r1.<init>()
            r21 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            r7.put(r2, r1)
            android.support.v4.util.ArrayMap r2 = new android.support.v4.util.ArrayMap
            r2.<init>()
            r19 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r15.put(r1, r2)
            r43 = r7
            r41 = r15
            r15 = r19
            r1 = r21
            r7 = r2
            r2 = r4
            r4 = r18
            goto L_0x05a2
        L_0x0584:
            r21 = r2
            r2 = r4
            r43 = r7
            r41 = r15
            r4 = r18
            r15 = r19
            r7 = r20
            r1 = r21
            goto L_0x05a2
        L_0x0594:
            r20 = r2
            r2 = r38
            r43 = r7
            r41 = r15
            r1 = r18
            r15 = r19
            r7 = r20
        L_0x05a2:
            r18 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            java.lang.Object r1 = r11.get(r1)
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r19 = r1.iterator()
        L_0x05b2:
            boolean r1 = r19.hasNext()
            if (r1 == 0) goto L_0x08a2
            java.lang.Object r1 = r19.next()
            com.google.android.gms.internal.measurement.zzfv r1 = (com.google.android.gms.internal.measurement.zzfv) r1
            r38 = r2
            com.google.android.gms.measurement.internal.zzap r2 = r51.zzgo()
            r20 = r11
            r11 = 2
            boolean r2 = r2.isLoggable(r11)
            if (r2 == 0) goto L_0x0602
            com.google.android.gms.measurement.internal.zzap r2 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjl()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r13)
            java.lang.Integer r3 = r1.zzave
            com.google.android.gms.measurement.internal.zzan r5 = r51.zzgl()
            r48 = r6
            java.lang.String r6 = r1.zzavf
            java.lang.String r5 = r5.zzbs(r6)
            java.lang.String r6 = "Evaluating filter. audience, filter, event"
            r2.zzd(r6, r11, r3, r5)
            com.google.android.gms.measurement.internal.zzap r2 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjl()
            com.google.android.gms.measurement.internal.zzfg r3 = r51.zzjo()
            java.lang.String r3 = r3.zza(r1)
            r11 = r45
            r2.zzg(r11, r3)
            goto L_0x0606
        L_0x0602:
            r48 = r6
            r11 = r45
        L_0x0606:
            java.lang.Integer r2 = r1.zzave
            if (r2 == 0) goto L_0x085e
            java.lang.Integer r2 = r1.zzave
            int r2 = r2.intValue()
            r5 = 256(0x100, float:3.59E-43)
            if (r2 <= r5) goto L_0x062a
            r46 = r10
            r45 = r11
            r44 = r12
            r11 = r16
            r12 = r18
            r49 = r38
            r50 = r48
            r16 = r0
            r10 = r1
            r0 = r4
            r18 = r15
            goto L_0x0872
        L_0x062a:
            java.lang.String r6 = "Event filter result"
            if (r23 == 0) goto L_0x07a0
            if (r1 == 0) goto L_0x0640
            java.lang.Boolean r2 = r1.zzavb
            if (r2 == 0) goto L_0x0640
            java.lang.Boolean r2 = r1.zzavb
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0640
            r21 = 1
            goto L_0x0642
        L_0x0640:
            r21 = 0
        L_0x0642:
            if (r1 == 0) goto L_0x0655
            java.lang.Boolean r2 = r1.zzavc
            if (r2 == 0) goto L_0x0655
            java.lang.Boolean r2 = r1.zzavc
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0655
            r22 = 1
            goto L_0x0657
        L_0x0655:
            r22 = 0
        L_0x0657:
            java.lang.Integer r2 = r1.zzave
            int r2 = r2.intValue()
            boolean r2 = r4.get(r2)
            if (r2 == 0) goto L_0x0689
            if (r21 != 0) goto L_0x0689
            if (r22 != 0) goto L_0x0689
            com.google.android.gms.measurement.internal.zzap r2 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjl()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r13)
            java.lang.Integer r1 = r1.zzave
            java.lang.String r6 = "Event filter already evaluated true and it is not associated with a dynamic audience. audience ID, filter ID"
            r2.zze(r6, r3, r1)
            r5 = r52
            r3 = r54
            r45 = r11
            r11 = r20
            r2 = r38
            r6 = r48
            goto L_0x05b2
        L_0x0689:
            r3 = r1
            r2 = r18
            r1 = r51
            r45 = r11
            r44 = r12
            r11 = r16
            r49 = r38
            r12 = r2
            r2 = r3
            r46 = r10
            r10 = r3
            r3 = r0
            r16 = r0
            r0 = r4
            r4 = r33
            r18 = r15
            r50 = r48
            r15 = r6
            r5 = r8
            java.lang.Boolean r1 = r1.zza(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzap r2 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjl()
            if (r1 != 0) goto L_0x06b9
            r3 = r27
            goto L_0x06ba
        L_0x06b9:
            r3 = r1
        L_0x06ba:
            r2.zzg(r15, r3)
            if (r1 != 0) goto L_0x06df
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r14.add(r1)
            r5 = r52
            r3 = r54
            r4 = r0
            r0 = r16
            r15 = r18
            r10 = r46
            r2 = r49
            r6 = r50
            r16 = r11
            r18 = r12
            r11 = r20
            r12 = r44
            goto L_0x05b2
        L_0x06df:
            java.lang.Integer r2 = r10.zzave
            int r2 = r2.intValue()
            r12.set(r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0786
            java.lang.Integer r1 = r10.zzave
            int r1 = r1.intValue()
            r0.set(r1)
            if (r21 != 0) goto L_0x0715
            if (r22 == 0) goto L_0x06fc
            goto L_0x0715
        L_0x06fc:
            r5 = r52
            r3 = r54
            r4 = r0
            r0 = r16
            r15 = r18
            r10 = r46
            r2 = r49
            r6 = r50
            r16 = r11
            r18 = r12
            r11 = r20
            r12 = r44
            goto L_0x05b2
        L_0x0715:
            java.lang.Long r1 = r11.zzawu
            if (r1 == 0) goto L_0x076c
            if (r22 == 0) goto L_0x0743
            java.lang.Integer r1 = r10.zzave
            int r1 = r1.intValue()
            java.lang.Long r2 = r11.zzawu
            long r2 = r2.longValue()
            zzb(r7, r1, r2)
            r5 = r52
            r3 = r54
            r4 = r0
            r0 = r16
            r15 = r18
            r10 = r46
            r2 = r49
            r6 = r50
            r16 = r11
            r18 = r12
            r11 = r20
            r12 = r44
            goto L_0x05b2
        L_0x0743:
            java.lang.Integer r1 = r10.zzave
            int r1 = r1.intValue()
            java.lang.Long r2 = r11.zzawu
            long r2 = r2.longValue()
            r5 = r18
            zza(r5, r1, r2)
            r3 = r54
            r4 = r0
            r15 = r5
            r18 = r12
            r0 = r16
            r12 = r44
            r10 = r46
            r2 = r49
            r6 = r50
            r5 = r52
            r16 = r11
            r11 = r20
            goto L_0x05b2
        L_0x076c:
            r5 = r18
            r3 = r54
            r4 = r0
            r15 = r5
            r18 = r12
            r0 = r16
            r12 = r44
            r10 = r46
            r2 = r49
            r6 = r50
            r5 = r52
            r16 = r11
            r11 = r20
            goto L_0x05b2
        L_0x0786:
            r5 = r18
            r3 = r54
            r4 = r0
            r15 = r5
            r18 = r12
            r0 = r16
            r12 = r44
            r10 = r46
            r2 = r49
            r6 = r50
            r5 = r52
            r16 = r11
            r11 = r20
            goto L_0x05b2
        L_0x07a0:
            r46 = r10
            r45 = r11
            r44 = r12
            r5 = r15
            r11 = r16
            r12 = r18
            r49 = r38
            r50 = r48
            r16 = r0
            r10 = r1
            r0 = r4
            r15 = r6
            java.lang.Integer r1 = r10.zzave
            int r1 = r1.intValue()
            boolean r1 = r0.get(r1)
            if (r1 == 0) goto L_0x07eb
            com.google.android.gms.measurement.internal.zzap r1 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjl()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            java.lang.Integer r3 = r10.zzave
            java.lang.String r4 = "Event filter already evaluated true. audience ID, filter ID"
            r1.zze(r4, r2, r3)
            r3 = r54
            r4 = r0
            r15 = r5
            r18 = r12
            r0 = r16
            r12 = r44
            r10 = r46
            r2 = r49
            r6 = r50
            r5 = r52
            r16 = r11
            r11 = r20
            goto L_0x05b2
        L_0x07eb:
            r1 = r51
            r2 = r10
            r3 = r16
            r4 = r33
            r18 = r5
            r5 = r8
            java.lang.Boolean r1 = r1.zza(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzap r2 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjl()
            if (r1 != 0) goto L_0x0807
            r3 = r27
            goto L_0x0808
        L_0x0807:
            r3 = r1
        L_0x0808:
            r2.zzg(r15, r3)
            if (r1 != 0) goto L_0x082d
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            r14.add(r1)
            r5 = r52
            r3 = r54
            r4 = r0
            r0 = r16
            r15 = r18
            r10 = r46
            r2 = r49
            r6 = r50
            r16 = r11
            r18 = r12
            r11 = r20
            r12 = r44
            goto L_0x05b2
        L_0x082d:
            java.lang.Integer r2 = r10.zzave
            int r2 = r2.intValue()
            r12.set(r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0845
            java.lang.Integer r1 = r10.zzave
            int r1 = r1.intValue()
            r0.set(r1)
        L_0x0845:
            r5 = r52
            r3 = r54
            r4 = r0
            r0 = r16
            r15 = r18
            r10 = r46
            r2 = r49
            r6 = r50
            r16 = r11
            r18 = r12
            r11 = r20
            r12 = r44
            goto L_0x05b2
        L_0x085e:
            r46 = r10
            r45 = r11
            r44 = r12
            r11 = r16
            r12 = r18
            r49 = r38
            r50 = r48
            r16 = r0
            r10 = r1
            r0 = r4
            r18 = r15
        L_0x0872:
            com.google.android.gms.measurement.internal.zzap r1 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjg()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzap.zzbv(r52)
            java.lang.Integer r3 = r10.zzave
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Invalid event filter ID. appId, id"
            r1.zze(r4, r2, r3)
            r5 = r52
            r3 = r54
            r4 = r0
            r0 = r16
            r15 = r18
            r10 = r46
            r2 = r49
            r6 = r50
            r16 = r11
            r18 = r12
            r11 = r20
            r12 = r44
            goto L_0x05b2
        L_0x08a2:
            r49 = r2
            r50 = r6
            r46 = r10
            r20 = r11
            r44 = r12
            r11 = r16
            r16 = r0
            r7 = r51
            r5 = r52
            r3 = r54
            r2 = r11
            r47 = r14
            r12 = r17
            r11 = r20
            r10 = r39
            r38 = r49
            r48 = r50
            goto L_0x049d
        L_0x08c5:
            r39 = r10
            r49 = r38
            r14 = r47
            r50 = r48
            r1 = r32
            r0 = r34
            r20 = r35
        L_0x08d3:
            int r2 = r30 + 1
            r7 = r51
            r15 = r52
            r13 = r53
            r11 = r14
            r3 = r24
            r5 = r39
            r4 = r40
            r6 = r41
            r22 = r43
            r25 = r44
            r9 = r45
            r26 = r46
            r24 = r49
            r12 = r50
            r14 = r54
            goto L_0x01c4
        L_0x08f4:
            r40 = r4
            r41 = r6
            r45 = r9
            r14 = r11
            r50 = r12
            r43 = r22
            r49 = r24
            r44 = r25
            r46 = r26
            r31 = 1
            goto L_0x091b
        L_0x0908:
            r40 = r4
            r41 = r6
            r45 = r9
            r14 = r11
            r50 = r12
            r43 = r22
            r49 = r24
            r44 = r25
            r46 = r26
            r31 = 1
        L_0x091b:
            r1 = r54
            if (r1 == 0) goto L_0x0cce
            android.support.v4.util.ArrayMap r0 = new android.support.v4.util.ArrayMap
            r0.<init>()
            int r2 = r1.length
            r3 = 0
        L_0x0926:
            if (r3 >= r2) goto L_0x0cc7
            r4 = r1[r3]
            java.lang.String r5 = r4.name
            java.lang.Object r5 = r0.get(r5)
            java.util.Map r5 = (java.util.Map) r5
            if (r5 != 0) goto L_0x094d
            com.google.android.gms.measurement.internal.zzq r5 = r51.zzjq()
            java.lang.String r6 = r4.name
            r7 = r52
            java.util.Map r5 = r5.zzm(r7, r6)
            if (r5 != 0) goto L_0x0947
            android.support.v4.util.ArrayMap r5 = new android.support.v4.util.ArrayMap
            r5.<init>()
        L_0x0947:
            java.lang.String r6 = r4.name
            r0.put(r6, r5)
            goto L_0x094f
        L_0x094d:
            r7 = r52
        L_0x094f:
            java.util.Set r6 = r5.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0957:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0cb5
            java.lang.Object r8 = r6.next()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            boolean r9 = r14.contains(r9)
            if (r9 == 0) goto L_0x0983
            com.google.android.gms.measurement.internal.zzap r9 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r9 = r9.zzjl()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r10 = r40
            r9.zzg(r10, r8)
            goto L_0x0957
        L_0x0983:
            r10 = r40
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r11 = r50
            java.lang.Object r9 = r11.get(r9)
            com.google.android.gms.internal.measurement.zzgd r9 = (com.google.android.gms.internal.measurement.zzgd) r9
            java.lang.Integer r12 = java.lang.Integer.valueOf(r8)
            r13 = r46
            java.lang.Object r12 = r13.get(r12)
            java.util.BitSet r12 = (java.util.BitSet) r12
            java.lang.Integer r15 = java.lang.Integer.valueOf(r8)
            r1 = r44
            java.lang.Object r15 = r1.get(r15)
            java.util.BitSet r15 = (java.util.BitSet) r15
            if (r23 == 0) goto L_0x09d0
            r53 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            r16 = r2
            r2 = r43
            java.lang.Object r0 = r2.get(r0)
            java.util.Map r0 = (java.util.Map) r0
            r17 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            r18 = r6
            r6 = r41
            java.lang.Object r0 = r6.get(r0)
            java.util.Map r0 = (java.util.Map) r0
            goto L_0x09dd
        L_0x09d0:
            r53 = r0
            r16 = r2
            r18 = r6
            r6 = r41
            r2 = r43
            r0 = 0
            r17 = 0
        L_0x09dd:
            if (r9 != 0) goto L_0x0a3e
            com.google.android.gms.internal.measurement.zzgd r9 = new com.google.android.gms.internal.measurement.zzgd
            r9.<init>()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r8)
            r11.put(r12, r9)
            r12 = r49
            r9.zzawo = r12
            java.util.BitSet r9 = new java.util.BitSet
            r9.<init>()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r8)
            r13.put(r15, r9)
            java.util.BitSet r15 = new java.util.BitSet
            r15.<init>()
            r19 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            r1.put(r0, r15)
            if (r23 == 0) goto L_0x0a32
            android.support.v4.util.ArrayMap r0 = new android.support.v4.util.ArrayMap
            r0.<init>()
            r20 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            r2.put(r9, r0)
            android.support.v4.util.ArrayMap r9 = new android.support.v4.util.ArrayMap
            r9.<init>()
            r17 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            r6.put(r0, r9)
            r43 = r2
            r2 = r9
            r9 = r12
            r0 = r17
            r12 = r20
            goto L_0x0a48
        L_0x0a32:
            r20 = r9
            r43 = r2
            r9 = r12
            r0 = r17
            r2 = r19
            r12 = r20
            goto L_0x0a48
        L_0x0a3e:
            r19 = r0
            r9 = r49
            r43 = r2
            r0 = r17
            r2 = r19
        L_0x0a48:
            r38 = r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r8)
            java.lang.Object r9 = r5.get(r9)
            java.util.List r9 = (java.util.List) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0a58:
            boolean r17 = r9.hasNext()
            if (r17 == 0) goto L_0x0c97
            java.lang.Object r17 = r9.next()
            r19 = r5
            r5 = r17
            com.google.android.gms.internal.measurement.zzfy r5 = (com.google.android.gms.internal.measurement.zzfy) r5
            r17 = r9
            com.google.android.gms.measurement.internal.zzap r9 = r51.zzgo()
            r40 = r10
            r10 = 2
            boolean r9 = r9.isLoggable(r10)
            if (r9 == 0) goto L_0x0aae
            com.google.android.gms.measurement.internal.zzap r9 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r9 = r9.zzjl()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r8)
            java.lang.Integer r7 = r5.zzave
            r41 = r6
            com.google.android.gms.measurement.internal.zzan r6 = r51.zzgl()
            r44 = r1
            java.lang.String r1 = r5.zzavu
            java.lang.String r1 = r6.zzbu(r1)
            java.lang.String r6 = "Evaluating filter. audience, filter, property"
            r9.zzd(r6, r10, r7, r1)
            com.google.android.gms.measurement.internal.zzap r1 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjl()
            com.google.android.gms.measurement.internal.zzfg r6 = r51.zzjo()
            java.lang.String r6 = r6.zza(r5)
            r7 = r45
            r1.zzg(r7, r6)
            goto L_0x0ab4
        L_0x0aae:
            r44 = r1
            r41 = r6
            r7 = r45
        L_0x0ab4:
            java.lang.Integer r1 = r5.zzave
            if (r1 == 0) goto L_0x0c5f
            java.lang.Integer r1 = r5.zzave
            int r1 = r1.intValue()
            r6 = 256(0x100, float:3.59E-43)
            if (r1 <= r6) goto L_0x0aca
            r6 = r51
            r45 = r7
            r48 = r11
            goto L_0x0c65
        L_0x0aca:
            java.lang.String r1 = "Property filter result"
            if (r23 == 0) goto L_0x0bd4
            if (r5 == 0) goto L_0x0adf
            java.lang.Boolean r9 = r5.zzavb
            if (r9 == 0) goto L_0x0adf
            java.lang.Boolean r9 = r5.zzavb
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0adf
            r9 = 1
            goto L_0x0ae0
        L_0x0adf:
            r9 = 0
        L_0x0ae0:
            if (r5 == 0) goto L_0x0af2
            java.lang.Boolean r10 = r5.zzavc
            if (r10 == 0) goto L_0x0af2
            java.lang.Boolean r10 = r5.zzavc
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0af2
            r10 = 1
            goto L_0x0af3
        L_0x0af2:
            r10 = 0
        L_0x0af3:
            java.lang.Integer r6 = r5.zzave
            int r6 = r6.intValue()
            boolean r6 = r12.get(r6)
            if (r6 == 0) goto L_0x0b27
            if (r9 != 0) goto L_0x0b27
            if (r10 != 0) goto L_0x0b27
            com.google.android.gms.measurement.internal.zzap r1 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjl()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)
            java.lang.Integer r5 = r5.zzave
            java.lang.String r9 = "Property filter already evaluated true and it is not associated with a dynamic audience. audience ID, filter ID"
            r1.zze(r9, r6, r5)
            r45 = r7
            r9 = r17
            r5 = r19
            r10 = r40
            r6 = r41
            r1 = r44
            r7 = r52
            goto L_0x0a58
        L_0x0b27:
            r6 = r51
            r45 = r7
            r7 = r43
            java.lang.Boolean r20 = r6.zza(r5, r4)
            com.google.android.gms.measurement.internal.zzap r21 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r7 = r21.zzjl()
            if (r20 != 0) goto L_0x0b40
            r48 = r11
            r11 = r27
            goto L_0x0b44
        L_0x0b40:
            r48 = r11
            r11 = r20
        L_0x0b44:
            r7.zzg(r1, r11)
            if (r20 != 0) goto L_0x0b60
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r14.add(r1)
            r7 = r52
            r9 = r17
            r5 = r19
            r10 = r40
            r6 = r41
            r1 = r44
            r11 = r48
            goto L_0x0a58
        L_0x0b60:
            java.lang.Integer r1 = r5.zzave
            int r1 = r1.intValue()
            r15.set(r1)
            java.lang.Integer r1 = r5.zzave
            int r1 = r1.intValue()
            boolean r7 = r20.booleanValue()
            r12.set(r1, r7)
            boolean r1 = r20.booleanValue()
            if (r1 == 0) goto L_0x0bc4
            if (r9 != 0) goto L_0x0b80
            if (r10 == 0) goto L_0x0bc4
        L_0x0b80:
            java.lang.Long r1 = r4.zzayl
            if (r1 == 0) goto L_0x0bc4
            if (r10 == 0) goto L_0x0ba5
            java.lang.Integer r1 = r5.zzave
            int r1 = r1.intValue()
            java.lang.Long r5 = r4.zzayl
            long r9 = r5.longValue()
            zzb(r2, r1, r9)
            r7 = r52
            r9 = r17
            r5 = r19
            r10 = r40
            r6 = r41
            r1 = r44
            r11 = r48
            goto L_0x0a58
        L_0x0ba5:
            java.lang.Integer r1 = r5.zzave
            int r1 = r1.intValue()
            java.lang.Long r5 = r4.zzayl
            long r9 = r5.longValue()
            zza(r0, r1, r9)
            r7 = r52
            r9 = r17
            r5 = r19
            r10 = r40
            r6 = r41
            r1 = r44
            r11 = r48
            goto L_0x0a58
        L_0x0bc4:
            r7 = r52
            r9 = r17
            r5 = r19
            r10 = r40
            r6 = r41
            r1 = r44
            r11 = r48
            goto L_0x0a58
        L_0x0bd4:
            r6 = r51
            r45 = r7
            r48 = r11
            java.lang.Integer r7 = r5.zzave
            int r7 = r7.intValue()
            boolean r7 = r12.get(r7)
            if (r7 == 0) goto L_0x0c09
            com.google.android.gms.measurement.internal.zzap r1 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r1 = r1.zzjl()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            java.lang.Integer r5 = r5.zzave
            java.lang.String r9 = "Property filter already evaluated true. audience ID, filter ID"
            r1.zze(r9, r7, r5)
            r7 = r52
            r9 = r17
            r5 = r19
            r10 = r40
            r6 = r41
            r1 = r44
            r11 = r48
            goto L_0x0a58
        L_0x0c09:
            java.lang.Boolean r7 = r6.zza(r5, r4)
            com.google.android.gms.measurement.internal.zzap r9 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r9 = r9.zzjl()
            if (r7 != 0) goto L_0x0c1a
            r10 = r27
            goto L_0x0c1b
        L_0x0c1a:
            r10 = r7
        L_0x0c1b:
            r9.zzg(r1, r10)
            if (r7 != 0) goto L_0x0c37
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            r14.add(r1)
            r7 = r52
            r9 = r17
            r5 = r19
            r10 = r40
            r6 = r41
            r1 = r44
            r11 = r48
            goto L_0x0a58
        L_0x0c37:
            java.lang.Integer r1 = r5.zzave
            int r1 = r1.intValue()
            r15.set(r1)
            boolean r1 = r7.booleanValue()
            if (r1 == 0) goto L_0x0c4f
            java.lang.Integer r1 = r5.zzave
            int r1 = r1.intValue()
            r12.set(r1)
        L_0x0c4f:
            r7 = r52
            r9 = r17
            r5 = r19
            r10 = r40
            r6 = r41
            r1 = r44
            r11 = r48
            goto L_0x0a58
        L_0x0c5f:
            r6 = r51
            r45 = r7
            r48 = r11
        L_0x0c65:
            com.google.android.gms.measurement.internal.zzap r0 = r51.zzgo()
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjg()
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzap.zzbv(r52)
            java.lang.Integer r2 = r5.zzave
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r5 = "Invalid property filter ID. appId, id"
            r0.zze(r5, r1, r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)
            r14.add(r0)
            r7 = r52
            r0 = r53
            r1 = r54
            r46 = r13
            r2 = r16
            r6 = r18
            r5 = r19
            r49 = r38
            r50 = r48
            goto L_0x0957
        L_0x0c97:
            r44 = r1
            r19 = r5
            r41 = r6
            r40 = r10
            r48 = r11
            r6 = r51
            r7 = r52
            r0 = r53
            r1 = r54
            r46 = r13
            r2 = r16
            r6 = r18
            r49 = r38
            r50 = r48
            goto L_0x0957
        L_0x0cb5:
            r6 = r51
            r53 = r0
            r16 = r2
            r13 = r46
            r38 = r49
            r48 = r50
            int r3 = r3 + 1
            r1 = r54
            goto L_0x0926
        L_0x0cc7:
            r6 = r51
            r13 = r46
            r48 = r50
            goto L_0x0cd4
        L_0x0cce:
            r6 = r51
            r13 = r46
            r48 = r50
        L_0x0cd4:
            int r0 = r13.size()
            com.google.android.gms.internal.measurement.zzgd[] r1 = new com.google.android.gms.internal.measurement.zzgd[r0]
            java.util.Set r0 = r13.keySet()
            java.util.Iterator r2 = r0.iterator()
            r0 = 0
        L_0x0ce5:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0ea3
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            boolean r4 = r14.contains(r4)
            if (r4 != 0) goto L_0x0e95
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r5 = r48
            java.lang.Object r4 = r5.get(r4)
            com.google.android.gms.internal.measurement.zzgd r4 = (com.google.android.gms.internal.measurement.zzgd) r4
            if (r4 != 0) goto L_0x0d12
            com.google.android.gms.internal.measurement.zzgd r4 = new com.google.android.gms.internal.measurement.zzgd
            r4.<init>()
        L_0x0d12:
            int r7 = r0 + 1
            r1[r0] = r4
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            r4.zzauy = r0
            com.google.android.gms.internal.measurement.zzgj r0 = new com.google.android.gms.internal.measurement.zzgj
            r0.<init>()
            r4.zzawm = r0
            com.google.android.gms.internal.measurement.zzgj r0 = r4.zzawm
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            java.lang.Object r8 = r13.get(r8)
            java.util.BitSet r8 = (java.util.BitSet) r8
            long[] r8 = com.google.android.gms.measurement.internal.zzfg.zza(r8)
            r0.zzayf = r8
            com.google.android.gms.internal.measurement.zzgj r0 = r4.zzawm
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            r9 = r44
            java.lang.Object r8 = r9.get(r8)
            java.util.BitSet r8 = (java.util.BitSet) r8
            long[] r8 = com.google.android.gms.measurement.internal.zzfg.zza(r8)
            r0.zzaye = r8
            if (r23 == 0) goto L_0x0dec
            com.google.android.gms.internal.measurement.zzgj r0 = r4.zzawm
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            r10 = r43
            java.lang.Object r8 = r10.get(r8)
            java.util.Map r8 = (java.util.Map) r8
            com.google.android.gms.internal.measurement.zzge[] r8 = zzd(r8)
            r0.zzayg = r8
            com.google.android.gms.internal.measurement.zzgj r0 = r4.zzawm
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            r11 = r41
            java.lang.Object r8 = r11.get(r8)
            java.util.Map r8 = (java.util.Map) r8
            if (r8 != 0) goto L_0x0d7a
            r12 = 0
            com.google.android.gms.internal.measurement.zzgk[] r8 = new com.google.android.gms.internal.measurement.zzgk[r12]
            r53 = r2
            r48 = r5
            r15 = r8
            goto L_0x0de9
        L_0x0d7a:
            r12 = 0
            int r15 = r8.size()
            com.google.android.gms.internal.measurement.zzgk[] r15 = new com.google.android.gms.internal.measurement.zzgk[r15]
            java.util.Set r16 = r8.keySet()
            java.util.Iterator r16 = r16.iterator()
            r17 = 0
        L_0x0d8c:
            boolean r18 = r16.hasNext()
            if (r18 == 0) goto L_0x0de5
            java.lang.Object r18 = r16.next()
            r12 = r18
            java.lang.Integer r12 = (java.lang.Integer) r12
            r53 = r2
            com.google.android.gms.internal.measurement.zzgk r2 = new com.google.android.gms.internal.measurement.zzgk
            r2.<init>()
            r2.zzawq = r12
            java.lang.Object r12 = r8.get(r12)
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto L_0x0dd7
            java.util.Collections.sort(r12)
            r48 = r5
            int r5 = r12.size()
            long[] r5 = new long[r5]
            java.util.Iterator r12 = r12.iterator()
            r18 = 0
        L_0x0dbd:
            boolean r19 = r12.hasNext()
            if (r19 == 0) goto L_0x0dd4
            java.lang.Object r19 = r12.next()
            java.lang.Long r19 = (java.lang.Long) r19
            int r20 = r18 + 1
            long r21 = r19.longValue()
            r5[r18] = r21
            r18 = r20
            goto L_0x0dbd
        L_0x0dd4:
            r2.zzayj = r5
            goto L_0x0dd9
        L_0x0dd7:
            r48 = r5
        L_0x0dd9:
            int r5 = r17 + 1
            r15[r17] = r2
            r2 = r53
            r17 = r5
            r5 = r48
            r12 = 0
            goto L_0x0d8c
        L_0x0de5:
            r53 = r2
            r48 = r5
        L_0x0de9:
            r0.zzayh = r15
            goto L_0x0df4
        L_0x0dec:
            r53 = r2
            r48 = r5
            r11 = r41
            r10 = r43
        L_0x0df4:
            com.google.android.gms.measurement.internal.zzq r2 = r51.zzjq()
            com.google.android.gms.internal.measurement.zzgj r0 = r4.zzawm
            r2.zzcl()
            r2.zzaf()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r52)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            int r4 = r0.zzvu()     // Catch:{ IOException -> 0x0e73 }
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x0e73 }
            int r5 = r4.length     // Catch:{ IOException -> 0x0e73 }
            r8 = 0
            com.google.android.gms.internal.measurement.zzyy r5 = com.google.android.gms.internal.measurement.zzyy.zzk(r4, r8, r5)     // Catch:{ IOException -> 0x0e6f }
            r0.zza(r5)     // Catch:{ IOException -> 0x0e6f }
            r5.zzyt()     // Catch:{ IOException -> 0x0e6f }
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.String r5 = "app_id"
            r12 = r52
            r0.put(r5, r12)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r5 = "audience_id"
            r0.put(r5, r3)
            java.lang.String r3 = "current_results"
            r0.put(r3, r4)
            android.database.sqlite.SQLiteDatabase r3 = r2.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0e5b }
            java.lang.String r4 = "audience_filter_values"
            r5 = 5
            r15 = 0
            long r3 = r3.insertWithOnConflict(r4, r15, r0, r5)     // Catch:{ SQLiteException -> 0x0e59 }
            r16 = -1
            int r0 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x0e58
            com.google.android.gms.measurement.internal.zzap r0 = r2.zzgo()     // Catch:{ SQLiteException -> 0x0e59 }
            com.google.android.gms.measurement.internal.zzar r0 = r0.zzjd()     // Catch:{ SQLiteException -> 0x0e59 }
            java.lang.String r3 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzap.zzbv(r52)     // Catch:{ SQLiteException -> 0x0e59 }
            r0.zzg(r3, r4)     // Catch:{ SQLiteException -> 0x0e59 }
        L_0x0e58:
            goto L_0x0e8a
        L_0x0e59:
            r0 = move-exception
            goto L_0x0e5d
        L_0x0e5b:
            r0 = move-exception
            r15 = 0
        L_0x0e5d:
            com.google.android.gms.measurement.internal.zzap r2 = r2.zzgo()
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjd()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzap.zzbv(r52)
            java.lang.String r4 = "Error storing filter results. appId"
            r2.zze(r4, r3, r0)
            goto L_0x0e8a
        L_0x0e6f:
            r0 = move-exception
            r12 = r52
            goto L_0x0e77
        L_0x0e73:
            r0 = move-exception
            r12 = r52
            r8 = 0
        L_0x0e77:
            r15 = 0
            com.google.android.gms.measurement.internal.zzap r2 = r2.zzgo()
            com.google.android.gms.measurement.internal.zzar r2 = r2.zzjd()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzap.zzbv(r52)
            java.lang.String r4 = "Configuration loss. Failed to serialize filter results. appId"
            r2.zze(r4, r3, r0)
        L_0x0e8a:
            r2 = r53
            r0 = r7
            r44 = r9
            r43 = r10
            r41 = r11
            goto L_0x0ce5
        L_0x0e95:
            r12 = r52
            r53 = r2
            r11 = r41
            r10 = r43
            r9 = r44
            r8 = 0
            r15 = 0
            goto L_0x0ce5
        L_0x0ea3:
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r1, r0)
            com.google.android.gms.internal.measurement.zzgd[] r0 = (com.google.android.gms.internal.measurement.zzgd[]) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzj.zza(java.lang.String, com.google.android.gms.internal.measurement.zzgf[], com.google.android.gms.internal.measurement.zzgl[]):com.google.android.gms.internal.measurement.zzgd[]");
    }

    private final Boolean zza(zzfv zzfv, String str, zzgg[] zzggArr, long j) {
        zzfw[] zzfwArr;
        zzfw[] zzfwArr2;
        Boolean bool;
        zzfx zzfx = zzfv.zzavi;
        Boolean valueOf = Boolean.valueOf(false);
        if (zzfx != null) {
            Boolean zza = zza(j, zzfv.zzavi);
            if (zza == null) {
                return null;
            }
            if (!zza.booleanValue()) {
                return valueOf;
            }
        }
        HashSet hashSet = new HashSet();
        for (zzfw zzfw : zzfv.zzavg) {
            if (TextUtils.isEmpty(zzfw.zzavn)) {
                zzgo().zzjg().zzg("null or empty param name in filter. event", zzgl().zzbs(str));
                return null;
            }
            hashSet.add(zzfw.zzavn);
        }
        ArrayMap arrayMap = new ArrayMap();
        for (zzgg zzgg : zzggArr) {
            if (hashSet.contains(zzgg.name)) {
                if (zzgg.zzawx != null) {
                    arrayMap.put(zzgg.name, zzgg.zzawx);
                } else if (zzgg.zzauh != null) {
                    arrayMap.put(zzgg.name, zzgg.zzauh);
                } else if (zzgg.zzamp != null) {
                    arrayMap.put(zzgg.name, zzgg.zzamp);
                } else {
                    zzgo().zzjg().zze("Unknown value for param. event, param", zzgl().zzbs(str), zzgl().zzbt(zzgg.name));
                    return null;
                }
            }
        }
        for (zzfw zzfw2 : zzfv.zzavg) {
            boolean equals = Boolean.TRUE.equals(zzfw2.zzavm);
            String str2 = zzfw2.zzavn;
            if (TextUtils.isEmpty(str2)) {
                zzgo().zzjg().zzg("Event has empty param name. event", zzgl().zzbs(str));
                return null;
            }
            Object obj = arrayMap.get(str2);
            if (obj instanceof Long) {
                if (zzfw2.zzavl == null) {
                    zzgo().zzjg().zze("No number filter for long param. event, param", zzgl().zzbs(str), zzgl().zzbt(str2));
                    return null;
                }
                Boolean zza2 = zza(((Long) obj).longValue(), zzfw2.zzavl);
                if (zza2 == null) {
                    return null;
                }
                if ((true ^ zza2.booleanValue()) ^ equals) {
                    return valueOf;
                }
            } else if (obj instanceof Double) {
                if (zzfw2.zzavl == null) {
                    zzgo().zzjg().zze("No number filter for double param. event, param", zzgl().zzbs(str), zzgl().zzbt(str2));
                    return null;
                }
                Boolean zza3 = zza(((Double) obj).doubleValue(), zzfw2.zzavl);
                if (zza3 == null) {
                    return null;
                }
                if ((true ^ zza3.booleanValue()) ^ equals) {
                    return valueOf;
                }
            } else if (obj instanceof String) {
                if (zzfw2.zzavk != null) {
                    bool = zza((String) obj, zzfw2.zzavk);
                } else if (zzfw2.zzavl != null) {
                    String str3 = (String) obj;
                    if (zzfg.zzcp(str3)) {
                        bool = zza(str3, zzfw2.zzavl);
                    } else {
                        zzgo().zzjg().zze("Invalid param value for number filter. event, param", zzgl().zzbs(str), zzgl().zzbt(str2));
                        return null;
                    }
                } else {
                    zzgo().zzjg().zze("No filter for String param. event, param", zzgl().zzbs(str), zzgl().zzbt(str2));
                    return null;
                }
                if (bool == null) {
                    return null;
                }
                if ((true ^ bool.booleanValue()) ^ equals) {
                    return valueOf;
                }
            } else if (obj == null) {
                zzgo().zzjl().zze("Missing param for filter. event, param", zzgl().zzbs(str), zzgl().zzbt(str2));
                return valueOf;
            } else {
                zzgo().zzjg().zze("Unknown param type. event, param", zzgl().zzbs(str), zzgl().zzbt(str2));
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private final Boolean zza(zzfy zzfy, zzgl zzgl) {
        zzfw zzfw = zzfy.zzavv;
        if (zzfw == null) {
            zzgo().zzjg().zzg("Missing property filter. property", zzgl().zzbu(zzgl.name));
            return null;
        }
        boolean equals = Boolean.TRUE.equals(zzfw.zzavm);
        if (zzgl.zzawx != null) {
            if (zzfw.zzavl != null) {
                return zza(zza(zzgl.zzawx.longValue(), zzfw.zzavl), equals);
            }
            zzgo().zzjg().zzg("No number filter for long property. property", zzgl().zzbu(zzgl.name));
            return null;
        } else if (zzgl.zzauh != null) {
            if (zzfw.zzavl != null) {
                return zza(zza(zzgl.zzauh.doubleValue(), zzfw.zzavl), equals);
            }
            zzgo().zzjg().zzg("No number filter for double property. property", zzgl().zzbu(zzgl.name));
            return null;
        } else if (zzgl.zzamp == null) {
            zzgo().zzjg().zzg("User property has no value, property", zzgl().zzbu(zzgl.name));
            return null;
        } else if (zzfw.zzavk != null) {
            return zza(zza(zzgl.zzamp, zzfw.zzavk), equals);
        } else {
            if (zzfw.zzavl == null) {
                zzgo().zzjg().zzg("No string or number filter defined. property", zzgl().zzbu(zzgl.name));
            } else if (zzfg.zzcp(zzgl.zzamp)) {
                return zza(zza(zzgl.zzamp, zzfw.zzavl), equals);
            } else {
                zzgo().zzjg().zze("Invalid user property value for Numeric number filter. property, value", zzgl().zzbu(zzgl.name), zzgl.zzamp);
            }
            return null;
        }
    }

    @VisibleForTesting
    private static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    @VisibleForTesting
    private final Boolean zza(String str, zzfz zzfz) {
        String str2;
        List list;
        String str3;
        Preconditions.checkNotNull(zzfz);
        if (str == null || zzfz.zzavw == null || zzfz.zzavw.intValue() == 0) {
            return null;
        }
        if (zzfz.zzavw.intValue() == 6) {
            if (zzfz.zzavz == null || zzfz.zzavz.length == 0) {
                return null;
            }
        } else if (zzfz.zzavx == null) {
            return null;
        }
        int intValue = zzfz.zzavw.intValue();
        boolean z = zzfz.zzavy != null && zzfz.zzavy.booleanValue();
        if (z || intValue == 1 || intValue == 6) {
            str2 = zzfz.zzavx;
        } else {
            str2 = zzfz.zzavx.toUpperCase(Locale.ENGLISH);
        }
        if (zzfz.zzavz == null) {
            list = null;
        } else {
            String[] strArr = zzfz.zzavz;
            if (z) {
                list = Arrays.asList(strArr);
            } else {
                ArrayList arrayList = new ArrayList();
                for (String upperCase : strArr) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                list = arrayList;
            }
        }
        if (intValue == 1) {
            str3 = str2;
        } else {
            str3 = null;
        }
        return zza(str, intValue, z, str2, list, str3);
    }

    private final Boolean zza(String str, int i, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException e) {
                    zzgo().zzjg().zzg("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean zza(long j, zzfx zzfx) {
        try {
            return zza(new BigDecimal(j), zzfx, 0.0d);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private final Boolean zza(double d, zzfx zzfx) {
        try {
            return zza(new BigDecimal(d), zzfx, Math.ulp(d));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private final Boolean zza(String str, zzfx zzfx) {
        if (!zzfg.zzcp(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzfx, 0.0d);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0078, code lost:
        if (r3 != null) goto L_0x007a;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean zza(java.math.BigDecimal r10, com.google.android.gms.internal.measurement.zzfx r11, double r12) {
        /*
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)
            java.lang.Integer r0 = r11.zzavo
            r1 = 0
            if (r0 == 0) goto L_0x0101
            java.lang.Integer r0 = r11.zzavo
            int r0 = r0.intValue()
            if (r0 != 0) goto L_0x0012
            goto L_0x0101
        L_0x0012:
            java.lang.Integer r0 = r11.zzavo
            int r0 = r0.intValue()
            r2 = 4
            if (r0 != r2) goto L_0x0024
            java.lang.String r0 = r11.zzavr
            if (r0 == 0) goto L_0x0023
            java.lang.String r0 = r11.zzavs
            if (r0 != 0) goto L_0x0029
        L_0x0023:
            return r1
        L_0x0024:
            java.lang.String r0 = r11.zzavq
            if (r0 != 0) goto L_0x0029
            return r1
        L_0x0029:
            java.lang.Integer r0 = r11.zzavo
            int r0 = r0.intValue()
            java.lang.Integer r3 = r11.zzavo
            int r3 = r3.intValue()
            if (r3 != r2) goto L_0x005f
            java.lang.String r3 = r11.zzavr
            boolean r3 = com.google.android.gms.measurement.internal.zzfg.zzcp(r3)
            if (r3 == 0) goto L_0x005e
            java.lang.String r3 = r11.zzavs
            boolean r3 = com.google.android.gms.measurement.internal.zzfg.zzcp(r3)
            if (r3 != 0) goto L_0x004b
            goto L_0x005e
        L_0x004b:
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x005c }
            java.lang.String r4 = r11.zzavr     // Catch:{ NumberFormatException -> 0x005c }
            r3.<init>(r4)     // Catch:{ NumberFormatException -> 0x005c }
            java.math.BigDecimal r4 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x005c }
            java.lang.String r11 = r11.zzavs     // Catch:{ NumberFormatException -> 0x005c }
            r4.<init>(r11)     // Catch:{ NumberFormatException -> 0x005c }
            r11 = r3
            r3 = r1
            goto L_0x0071
        L_0x005c:
            r10 = move-exception
            return r1
        L_0x005e:
            return r1
        L_0x005f:
            java.lang.String r3 = r11.zzavq
            boolean r3 = com.google.android.gms.measurement.internal.zzfg.zzcp(r3)
            if (r3 != 0) goto L_0x0068
            return r1
        L_0x0068:
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.String r11 = r11.zzavq     // Catch:{ NumberFormatException -> 0x00ff }
            r3.<init>(r11)     // Catch:{ NumberFormatException -> 0x00ff }
            r11 = r1
            r4 = r11
        L_0x0071:
            if (r0 != r2) goto L_0x0078
            if (r11 != 0) goto L_0x007a
            return r1
        L_0x0078:
            if (r3 == 0) goto L_0x00fd
        L_0x007a:
            r5 = -1
            r6 = 0
            r7 = 1
            if (r0 == r7) goto L_0x00f1
            r8 = 2
            if (r0 == r8) goto L_0x00e5
            r9 = 3
            if (r0 == r9) goto L_0x009b
            if (r0 == r2) goto L_0x0089
            goto L_0x00fd
        L_0x0089:
            int r11 = r10.compareTo(r11)
            if (r11 == r5) goto L_0x0096
            int r10 = r10.compareTo(r4)
            if (r10 == r7) goto L_0x0096
            r6 = 1
        L_0x0096:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r6)
            return r10
        L_0x009b:
            r0 = 0
            int r11 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r11 == 0) goto L_0x00d9
            java.math.BigDecimal r11 = new java.math.BigDecimal
            r11.<init>(r12)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r8)
            java.math.BigDecimal r11 = r11.multiply(r0)
            java.math.BigDecimal r11 = r3.subtract(r11)
            int r11 = r10.compareTo(r11)
            if (r11 != r7) goto L_0x00d3
            java.math.BigDecimal r11 = new java.math.BigDecimal
            r11.<init>(r12)
            java.math.BigDecimal r12 = new java.math.BigDecimal
            r12.<init>(r8)
            java.math.BigDecimal r11 = r11.multiply(r12)
            java.math.BigDecimal r11 = r3.add(r11)
            int r10 = r10.compareTo(r11)
            if (r10 != r5) goto L_0x00d3
            r6 = 1
            goto L_0x00d4
        L_0x00d3:
        L_0x00d4:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r6)
            return r10
        L_0x00d9:
            int r10 = r10.compareTo(r3)
            if (r10 != 0) goto L_0x00e0
            r6 = 1
        L_0x00e0:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r6)
            return r10
        L_0x00e5:
            int r10 = r10.compareTo(r3)
            if (r10 != r7) goto L_0x00ec
            r6 = 1
        L_0x00ec:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r6)
            return r10
        L_0x00f1:
            int r10 = r10.compareTo(r3)
            if (r10 != r5) goto L_0x00f8
            r6 = 1
        L_0x00f8:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r6)
            return r10
        L_0x00fd:
            return r1
        L_0x00ff:
            r10 = move-exception
            return r1
        L_0x0101:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzj.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzfx, double):java.lang.Boolean");
    }

    private static zzge[] zzd(Map<Integer, Long> map) {
        if (map == null) {
            return null;
        }
        int i = 0;
        zzge[] zzgeArr = new zzge[map.size()];
        for (Integer num : map.keySet()) {
            zzge zzge = new zzge();
            zzge.zzawq = num;
            zzge.zzawr = (Long) map.get(num);
            int i2 = i + 1;
            zzgeArr[i] = zzge;
            i = i2;
        }
        return zzgeArr;
    }

    private static void zza(Map<Integer, Long> map, int i, long j) {
        Long l = (Long) map.get(Integer.valueOf(i));
        long j2 = j / 1000;
        if (l == null || j2 > l.longValue()) {
            map.put(Integer.valueOf(i), Long.valueOf(j2));
        }
    }

    private static void zzb(Map<Integer, List<Long>> map, int i, long j) {
        List list = (List) map.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList();
            map.put(Integer.valueOf(i), list);
        }
        list.add(Long.valueOf(j / 1000));
    }
}
