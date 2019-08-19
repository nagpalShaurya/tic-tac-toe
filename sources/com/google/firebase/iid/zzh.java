package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.annotation.GuardedBy;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class zzh implements ServiceConnection {
    private final Queue<zzd> zzaa;
    private zzf zzab;
    @GuardedBy("this")
    private boolean zzac;
    private final Context zzx;
    private final Intent zzy;
    private final ScheduledExecutorService zzz;

    public zzh(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    @VisibleForTesting
    private zzh(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zzaa = new ArrayDeque();
        this.zzac = false;
        this.zzx = context.getApplicationContext();
        this.zzy = new Intent(str).setPackage(this.zzx.getPackageName());
        this.zzz = scheduledExecutorService;
    }

    public final synchronized void zza(Intent intent, PendingResult pendingResult) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
        }
        this.zzaa.add(new zzd(intent, pendingResult, this.zzz));
        zzc();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a9, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzc() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "EnhancedIntentService"
            r1 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ac }
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = "EnhancedIntentService"
            java.lang.String r2 = "flush queue called"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00ac }
        L_0x0011:
            java.util.Queue<com.google.firebase.iid.zzd> r0 = r6.zzaa     // Catch:{ all -> 0x00ac }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00ac }
            if (r0 != 0) goto L_0x00aa
            java.lang.String r0 = "EnhancedIntentService"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ac }
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = "EnhancedIntentService"
            java.lang.String r2 = "found intent to be delivered"
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00ac }
        L_0x0028:
            com.google.firebase.iid.zzf r0 = r6.zzab     // Catch:{ all -> 0x00ac }
            if (r0 == 0) goto L_0x0051
            com.google.firebase.iid.zzf r0 = r6.zzab     // Catch:{ all -> 0x00ac }
            boolean r0 = r0.isBinderAlive()     // Catch:{ all -> 0x00ac }
            if (r0 == 0) goto L_0x0051
            java.lang.String r0 = "EnhancedIntentService"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ac }
            if (r0 == 0) goto L_0x0043
            java.lang.String r0 = "EnhancedIntentService"
            java.lang.String r2 = "binder is alive, sending the intent."
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00ac }
        L_0x0043:
            java.util.Queue<com.google.firebase.iid.zzd> r0 = r6.zzaa     // Catch:{ all -> 0x00ac }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x00ac }
            com.google.firebase.iid.zzd r0 = (com.google.firebase.iid.zzd) r0     // Catch:{ all -> 0x00ac }
            com.google.firebase.iid.zzf r2 = r6.zzab     // Catch:{ all -> 0x00ac }
            r2.zza(r0)     // Catch:{ all -> 0x00ac }
            goto L_0x0011
        L_0x0051:
            java.lang.String r0 = "EnhancedIntentService"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00ac }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x007b
            java.lang.String r0 = "EnhancedIntentService"
            boolean r3 = r6.zzac     // Catch:{ all -> 0x00ac }
            if (r3 != 0) goto L_0x0064
            r3 = 1
            goto L_0x0065
        L_0x0064:
            r3 = 0
        L_0x0065:
            r4 = 39
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            r5.<init>(r4)     // Catch:{ all -> 0x00ac }
            java.lang.String r4 = "binder is dead. start connection? "
            r5.append(r4)     // Catch:{ all -> 0x00ac }
            r5.append(r3)     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x00ac }
            android.util.Log.d(r0, r3)     // Catch:{ all -> 0x00ac }
        L_0x007b:
            boolean r0 = r6.zzac     // Catch:{ all -> 0x00ac }
            if (r0 != 0) goto L_0x00a8
            r6.zzac = r2     // Catch:{ all -> 0x00ac }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ SecurityException -> 0x009b }
            android.content.Context r2 = r6.zzx     // Catch:{ SecurityException -> 0x009b }
            android.content.Intent r3 = r6.zzy     // Catch:{ SecurityException -> 0x009b }
            r4 = 65
            boolean r0 = r0.bindService(r2, r3, r6, r4)     // Catch:{ SecurityException -> 0x009b }
            if (r0 == 0) goto L_0x0093
            monitor-exit(r6)
            return
        L_0x0093:
            java.lang.String r0 = "EnhancedIntentService"
            java.lang.String r2 = "binding to the service failed"
            android.util.Log.e(r0, r2)     // Catch:{ SecurityException -> 0x009b }
            goto L_0x00a3
        L_0x009b:
            r0 = move-exception
            java.lang.String r2 = "EnhancedIntentService"
            java.lang.String r3 = "Exception while binding the service"
            android.util.Log.e(r2, r3, r0)     // Catch:{ all -> 0x00ac }
        L_0x00a3:
            r6.zzac = r1     // Catch:{ all -> 0x00ac }
            r6.zzd()     // Catch:{ all -> 0x00ac }
        L_0x00a8:
            monitor-exit(r6)
            return
        L_0x00aa:
            monitor-exit(r6)
            return
        L_0x00ac:
            r0 = move-exception
            monitor-exit(r6)
            goto L_0x00b0
        L_0x00af:
            throw r0
        L_0x00b0:
            goto L_0x00af
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzh.zzc():void");
    }

    @GuardedBy("this")
    private final void zzd() {
        while (!this.zzaa.isEmpty()) {
            ((zzd) this.zzaa.poll()).finish();
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            this.zzac = false;
            this.zzab = (zzf) iBinder;
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                String valueOf = String.valueOf(componentName);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
                sb.append("onServiceConnected: ");
                sb.append(valueOf);
                Log.d("EnhancedIntentService", sb.toString());
            }
            if (iBinder == null) {
                Log.e("EnhancedIntentService", "Null service connection");
                zzd();
            } else {
                zzc();
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        String str = "EnhancedIntentService";
        if (Log.isLoggable(str, 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
            Log.d(str, sb.toString());
        }
        zzc();
    }
}
