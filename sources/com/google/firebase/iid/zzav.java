package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import android.support.p000v4.util.SimpleArrayMap;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

public final class zzav {
    private static zzav zzcx;
    @GuardedBy("serviceClassNames")
    private final SimpleArrayMap<String, String> zzcy = new SimpleArrayMap<>();
    private Boolean zzcz = null;
    @VisibleForTesting
    final Queue<Intent> zzda = new ArrayDeque();
    @VisibleForTesting
    private final Queue<Intent> zzdb = new ArrayDeque();

    public static synchronized zzav zzai() {
        zzav zzav;
        synchronized (zzav.class) {
            if (zzcx == null) {
                zzcx = new zzav();
            }
            zzav = zzcx;
        }
        return zzav;
    }

    private zzav() {
    }

    public static PendingIntent zza(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getBroadcast(context, i, zza(context, "com.google.firebase.MESSAGING_EVENT", intent), 1073741824);
    }

    public static void zzb(Context context, Intent intent) {
        context.sendBroadcast(zza(context, "com.google.firebase.INSTANCE_ID_EVENT", intent));
    }

    public static void zzc(Context context, Intent intent) {
        context.sendBroadcast(zza(context, "com.google.firebase.MESSAGING_EVENT", intent));
    }

    private static Intent zza(Context context, String str, Intent intent) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdReceiver.class);
        intent2.setAction(str);
        intent2.putExtra("wrapped_intent", intent);
        return intent2;
    }

    public final Intent zzaj() {
        return (Intent) this.zzdb.poll();
    }

    public final int zzb(Context context, String str, Intent intent) {
        String str2 = "FirebaseInstanceId";
        if (Log.isLoggable(str2, 3)) {
            String str3 = "Starting service: ";
            String valueOf = String.valueOf(str);
            Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -842411455) {
            if (hashCode == 41532704 && str.equals("com.google.firebase.MESSAGING_EVENT")) {
                c = 1;
            }
        } else if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
            c = 0;
        }
        if (c == 0) {
            this.zzda.offer(intent);
        } else if (c != 1) {
            String str4 = "Unknown service action: ";
            String valueOf2 = String.valueOf(str);
            Log.w(str2, valueOf2.length() != 0 ? str4.concat(valueOf2) : new String(str4));
            return 500;
        } else {
            this.zzdb.offer(intent);
        }
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        return zzd(context, intent2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00dd A[Catch:{ SecurityException -> 0x013a, IllegalStateException -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f4 A[Catch:{ SecurityException -> 0x013a, IllegalStateException -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f9 A[Catch:{ SecurityException -> 0x013a, IllegalStateException -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0106 A[Catch:{ SecurityException -> 0x013a, IllegalStateException -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzd(android.content.Context r6, android.content.Intent r7) {
        /*
            r5 = this;
            android.support.v4.util.SimpleArrayMap<java.lang.String, java.lang.String> r0 = r5.zzcy
            monitor-enter(r0)
            android.support.v4.util.SimpleArrayMap<java.lang.String, java.lang.String> r1 = r5.zzcy     // Catch:{ all -> 0x0145 }
            java.lang.String r2 = r7.getAction()     // Catch:{ all -> 0x0145 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0145 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0145 }
            monitor-exit(r0)     // Catch:{ all -> 0x0145 }
            r0 = 0
            if (r1 != 0) goto L_0x00ac
            android.content.pm.PackageManager r1 = r6.getPackageManager()
            android.content.pm.ResolveInfo r1 = r1.resolveService(r7, r0)
            if (r1 == 0) goto L_0x00a4
            android.content.pm.ServiceInfo r2 = r1.serviceInfo
            if (r2 != 0) goto L_0x0024
            goto L_0x00a4
        L_0x0024:
            android.content.pm.ServiceInfo r1 = r1.serviceInfo
            java.lang.String r2 = r6.getPackageName()
            java.lang.String r3 = r1.packageName
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x006e
            java.lang.String r2 = r1.name
            if (r2 != 0) goto L_0x0037
            goto L_0x006e
        L_0x0037:
            java.lang.String r1 = r1.name
            java.lang.String r2 = "."
            boolean r2 = r1.startsWith(r2)
            if (r2 == 0) goto L_0x005d
            java.lang.String r2 = r6.getPackageName()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r3 = r1.length()
            if (r3 == 0) goto L_0x0058
            java.lang.String r1 = r2.concat(r1)
            goto L_0x005d
        L_0x0058:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r2)
        L_0x005d:
            android.support.v4.util.SimpleArrayMap<java.lang.String, java.lang.String> r2 = r5.zzcy
            monitor-enter(r2)
            android.support.v4.util.SimpleArrayMap<java.lang.String, java.lang.String> r3 = r5.zzcy     // Catch:{ all -> 0x006b }
            java.lang.String r4 = r7.getAction()     // Catch:{ all -> 0x006b }
            r3.put(r4, r1)     // Catch:{ all -> 0x006b }
            monitor-exit(r2)     // Catch:{ all -> 0x006b }
            goto L_0x00ac
        L_0x006b:
            r6 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x006b }
            throw r6
        L_0x006e:
            java.lang.String r2 = r1.packageName
            java.lang.String r1 = r1.name
            java.lang.String r3 = java.lang.String.valueOf(r2)
            int r3 = r3.length()
            int r3 = r3 + 94
            java.lang.String r4 = java.lang.String.valueOf(r1)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Error resolving target intent service, skipping classname enforcement. Resolved service was: "
            r4.append(r3)
            r4.append(r2)
            java.lang.String r2 = "/"
            r4.append(r2)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            java.lang.String r2 = "FirebaseInstanceId"
            android.util.Log.e(r2, r1)
            goto L_0x00d8
        L_0x00a4:
            java.lang.String r1 = "FirebaseInstanceId"
            java.lang.String r2 = "Failed to resolve target intent service, skipping classname enforcement"
            android.util.Log.e(r1, r2)
            goto L_0x00d8
        L_0x00ac:
            r2 = 3
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r2 = android.util.Log.isLoggable(r3, r2)
            if (r2 == 0) goto L_0x00d1
            java.lang.String r2 = "Restricting intent to a specific service: "
            java.lang.String r3 = java.lang.String.valueOf(r1)
            int r4 = r3.length()
            if (r4 == 0) goto L_0x00c6
            java.lang.String r2 = r2.concat(r3)
            goto L_0x00cc
        L_0x00c6:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r2)
            r2 = r3
        L_0x00cc:
            java.lang.String r3 = "FirebaseInstanceId"
            android.util.Log.d(r3, r2)
        L_0x00d1:
            java.lang.String r2 = r6.getPackageName()
            r7.setClassName(r2, r1)
        L_0x00d8:
            java.lang.Boolean r1 = r5.zzcz     // Catch:{ SecurityException -> 0x013a, IllegalStateException -> 0x0112 }
            if (r1 != 0) goto L_0x00ec
            java.lang.String r1 = "android.permission.WAKE_LOCK"
            int r1 = r6.checkCallingOrSelfPermission(r1)     // Catch:{ SecurityException -> 0x013a, IllegalStateException -> 0x0112 }
            if (r1 != 0) goto L_0x00e6
            r0 = 1
        L_0x00e6:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ SecurityException -> 0x013a, IllegalStateException -> 0x0112 }
            r5.zzcz = r0     // Catch:{ SecurityException -> 0x013a, IllegalStateException -> 0x0112 }
        L_0x00ec:
            java.lang.Boolean r0 = r5.zzcz     // Catch:{ SecurityException -> 0x013a, IllegalStateException -> 0x0112 }
            boolean r0 = r0.booleanValue()     // Catch:{ SecurityException -> 0x013a, IllegalStateException -> 0x0112 }
            if (r0 == 0) goto L_0x00f9
            android.content.ComponentName r6 = android.support.p000v4.content.WakefulBroadcastReceiver.startWakefulService(r6, r7)     // Catch:{ SecurityException -> 0x013a, IllegalStateException -> 0x0112 }
            goto L_0x0104
        L_0x00f9:
            android.content.ComponentName r6 = r6.startService(r7)     // Catch:{ SecurityException -> 0x013a, IllegalStateException -> 0x0112 }
            java.lang.String r7 = "FirebaseInstanceId"
            java.lang.String r0 = "Missing wake lock permission, service start may be delayed"
            android.util.Log.d(r7, r0)     // Catch:{ SecurityException -> 0x013a, IllegalStateException -> 0x0112 }
        L_0x0104:
            if (r6 != 0) goto L_0x0110
            java.lang.String r6 = "FirebaseInstanceId"
            java.lang.String r7 = "Error while delivering the message: ServiceIntent not found."
            android.util.Log.e(r6, r7)     // Catch:{ SecurityException -> 0x013a, IllegalStateException -> 0x0112 }
            r6 = 404(0x194, float:5.66E-43)
            return r6
        L_0x0110:
            r6 = -1
            return r6
        L_0x0112:
            r6 = move-exception
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r7 = java.lang.String.valueOf(r6)
            int r7 = r7.length()
            int r7 = r7 + 45
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r7)
            java.lang.String r7 = "Failed to start service while in background: "
            r0.append(r7)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r7 = "FirebaseInstanceId"
            android.util.Log.e(r7, r6)
            r6 = 402(0x192, float:5.63E-43)
            return r6
        L_0x013a:
            r6 = move-exception
            java.lang.String r7 = "FirebaseInstanceId"
            java.lang.String r0 = "Error while delivering the message to the serviceIntent"
            android.util.Log.e(r7, r0, r6)
            r6 = 401(0x191, float:5.62E-43)
            return r6
        L_0x0145:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0145 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzav.zzd(android.content.Context, android.content.Intent):int");
    }
}
