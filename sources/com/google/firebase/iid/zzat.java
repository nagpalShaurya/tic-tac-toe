package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.support.p000v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzl.zza;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

final class zzat {
    private static int zzcf = 0;
    private static PendingIntent zzcr;
    private final zzan zzan;
    @GuardedBy("responseCallbacks")
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zzcs = new SimpleArrayMap<>();
    private Messenger zzct;
    private Messenger zzcu;
    private zzl zzcv;
    private final Context zzx;

    public zzat(Context context, zzan zzan2) {
        this.zzx = context;
        this.zzan = zzan2;
        this.zzct = new Messenger(new zzau(this, Looper.getMainLooper()));
    }

    /* access modifiers changed from: private */
    public final void zzb(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("FirebaseInstanceId", "Dropping invalid message");
        } else {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(new zza());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof zzl) {
                    this.zzcv = (zzl) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    this.zzcu = (Messenger) parcelableExtra;
                }
            }
            Intent intent2 = (Intent) message.obj;
            String action = intent2.getAction();
            if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String str = "Unexpected response action: ";
                    String valueOf = String.valueOf(action);
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                }
                return;
            }
            String stringExtra = intent2.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent2.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String valueOf2 = String.valueOf(intent2.getExtras());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 49);
                    sb.append("Unexpected response, no error or registration id ");
                    sb.append(valueOf2);
                    Log.w("FirebaseInstanceId", sb.toString());
                } else {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String str2 = "Received InstanceID error ";
                        String valueOf3 = String.valueOf(stringExtra2);
                        Log.d("FirebaseInstanceId", valueOf3.length() != 0 ? str2.concat(valueOf3) : new String(str2));
                    }
                    if (stringExtra2.startsWith("|")) {
                        String[] split = stringExtra2.split("\\|");
                        if (split.length > 2) {
                            if ("ID".equals(split[1])) {
                                String str3 = split[2];
                                String str4 = split[3];
                                if (str4.startsWith(":")) {
                                    str4 = str4.substring(1);
                                }
                                zza(str3, intent2.putExtra("error", str4).getExtras());
                            }
                        }
                        String str5 = "Unexpected structured response ";
                        String valueOf4 = String.valueOf(stringExtra2);
                        Log.w("FirebaseInstanceId", valueOf4.length() != 0 ? str5.concat(valueOf4) : new String(str5));
                    } else {
                        synchronized (this.zzcs) {
                            for (int i = 0; i < this.zzcs.size(); i++) {
                                zza((String) this.zzcs.keyAt(i), intent2.getExtras());
                            }
                        }
                    }
                }
            } else {
                Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                if (!matcher.matches()) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String str6 = "Unexpected response string: ";
                        String valueOf5 = String.valueOf(stringExtra);
                        Log.d("FirebaseInstanceId", valueOf5.length() != 0 ? str6.concat(valueOf5) : new String(str6));
                    }
                    return;
                }
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                Bundle extras = intent2.getExtras();
                extras.putString("registration_id", group2);
                zza(group, extras);
            }
        }
    }

    private static synchronized void zza(Context context, Intent intent) {
        synchronized (zzat.class) {
            if (zzcr == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzcr = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", zzcr);
        }
    }

    private final void zza(String str, Bundle bundle) {
        synchronized (this.zzcs) {
            TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.zzcs.remove(str);
            if (taskCompletionSource == null) {
                String str2 = "FirebaseInstanceId";
                String str3 = "Missing callback for ";
                String valueOf = String.valueOf(str);
                Log.w(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                return;
            }
            taskCompletionSource.setResult(bundle);
        }
    }

    /* access modifiers changed from: 0000 */
    public final Bundle zzc(Bundle bundle) throws IOException {
        if (this.zzan.zzaf() < 12000000) {
            return zzd(bundle);
        }
        try {
            return (Bundle) Tasks.await(zzab.zzc(this.zzx).zzb(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            String str = "FirebaseInstanceId";
            if (Log.isLoggable(str, 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                sb.append("Error making request: ");
                sb.append(valueOf);
                Log.d(str, sb.toString());
            }
            if (!(e.getCause() instanceof zzal) || ((zzal) e.getCause()).getErrorCode() != 4) {
                return null;
            }
            return zzd(bundle);
        }
    }

    private final Bundle zzd(Bundle bundle) throws IOException {
        Bundle zze = zze(bundle);
        if (zze == null) {
            return zze;
        }
        String str = "google.messenger";
        if (!zze.containsKey(str)) {
            return zze;
        }
        Bundle zze2 = zze(bundle);
        if (zze2 == null || !zze2.containsKey(str)) {
            return zze2;
        }
        return null;
    }

    private static synchronized String zzah() {
        String num;
        synchronized (zzat.class) {
            int i = zzcf;
            zzcf = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.os.Bundle zze(android.os.Bundle r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = zzah()
            com.google.android.gms.tasks.TaskCompletionSource r1 = new com.google.android.gms.tasks.TaskCompletionSource
            r1.<init>()
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r7.zzcs
            monitor-enter(r2)
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r3 = r7.zzcs     // Catch:{ all -> 0x012b }
            r3.put(r0, r1)     // Catch:{ all -> 0x012b }
            monitor-exit(r2)     // Catch:{ all -> 0x012b }
            com.google.firebase.iid.zzan r2 = r7.zzan
            int r2 = r2.zzac()
            if (r2 == 0) goto L_0x0123
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "com.google.android.gms"
            r2.setPackage(r3)
            com.google.firebase.iid.zzan r3 = r7.zzan
            int r3 = r3.zzac()
            r4 = 2
            if (r3 != r4) goto L_0x0034
            java.lang.String r3 = "com.google.iid.TOKEN_REQUEST"
            r2.setAction(r3)
            goto L_0x0039
        L_0x0034:
            java.lang.String r3 = "com.google.android.c2dm.intent.REGISTER"
            r2.setAction(r3)
        L_0x0039:
            r2.putExtras(r8)
            android.content.Context r8 = r7.zzx
            zza(r8, r2)
            java.lang.String r8 = java.lang.String.valueOf(r0)
            int r8 = r8.length()
            int r8 = r8 + 5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r8)
            java.lang.String r8 = "|ID|"
            r3.append(r8)
            r3.append(r0)
            java.lang.String r8 = "|"
            r3.append(r8)
            java.lang.String r8 = r3.toString()
            java.lang.String r3 = "kid"
            r2.putExtra(r3, r8)
            r8 = 3
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r3 = android.util.Log.isLoggable(r3, r8)
            if (r3 == 0) goto L_0x0098
            android.os.Bundle r3 = r2.getExtras()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = java.lang.String.valueOf(r3)
            int r5 = r5.length()
            int r5 = r5 + 8
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Sending "
            r6.append(r5)
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            java.lang.String r5 = "FirebaseInstanceId"
            android.util.Log.d(r5, r3)
        L_0x0098:
            android.os.Messenger r3 = r7.zzct
            java.lang.String r5 = "google.messenger"
            r2.putExtra(r5, r3)
            android.os.Messenger r3 = r7.zzcu
            if (r3 != 0) goto L_0x00a7
            com.google.firebase.iid.zzl r3 = r7.zzcv
            if (r3 == 0) goto L_0x00cd
        L_0x00a7:
            android.os.Message r3 = android.os.Message.obtain()
            r3.obj = r2
            android.os.Messenger r5 = r7.zzcu     // Catch:{ RemoteException -> 0x00bd }
            if (r5 == 0) goto L_0x00b7
            android.os.Messenger r5 = r7.zzcu     // Catch:{ RemoteException -> 0x00bd }
            r5.send(r3)     // Catch:{ RemoteException -> 0x00bd }
            goto L_0x00e0
        L_0x00b7:
            com.google.firebase.iid.zzl r5 = r7.zzcv     // Catch:{ RemoteException -> 0x00bd }
            r5.send(r3)     // Catch:{ RemoteException -> 0x00bd }
            goto L_0x00e0
        L_0x00bd:
            r3 = move-exception
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r8 = android.util.Log.isLoggable(r3, r8)
            if (r8 == 0) goto L_0x00cd
            java.lang.String r8 = "FirebaseInstanceId"
            java.lang.String r3 = "Messenger failed, fallback to startService"
            android.util.Log.d(r8, r3)
        L_0x00cd:
            com.google.firebase.iid.zzan r8 = r7.zzan
            int r8 = r8.zzac()
            if (r8 != r4) goto L_0x00db
            android.content.Context r8 = r7.zzx
            r8.sendBroadcast(r2)
            goto L_0x00e0
        L_0x00db:
            android.content.Context r8 = r7.zzx
            r8.startService(r2)
        L_0x00e0:
            com.google.android.gms.tasks.Task r8 = r1.getTask()     // Catch:{ InterruptedException -> 0x0106, TimeoutException -> 0x0104, ExecutionException -> 0x00fd }
            r1 = 30000(0x7530, double:1.4822E-319)
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0106, TimeoutException -> 0x0104, ExecutionException -> 0x00fd }
            java.lang.Object r8 = com.google.android.gms.tasks.Tasks.await(r8, r1, r3)     // Catch:{ InterruptedException -> 0x0106, TimeoutException -> 0x0104, ExecutionException -> 0x00fd }
            android.os.Bundle r8 = (android.os.Bundle) r8     // Catch:{ InterruptedException -> 0x0106, TimeoutException -> 0x0104, ExecutionException -> 0x00fd }
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r7.zzcs
            monitor-enter(r1)
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r7.zzcs     // Catch:{ all -> 0x00f8 }
            r2.remove(r0)     // Catch:{ all -> 0x00f8 }
            monitor-exit(r1)     // Catch:{ all -> 0x00f8 }
            return r8
        L_0x00f8:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f8 }
            throw r8
        L_0x00fb:
            r8 = move-exception
            goto L_0x0116
        L_0x00fd:
            r8 = move-exception
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x00fb }
            r1.<init>(r8)     // Catch:{ all -> 0x00fb }
            throw r1     // Catch:{ all -> 0x00fb }
        L_0x0104:
            r8 = move-exception
            goto L_0x0107
        L_0x0106:
            r8 = move-exception
        L_0x0107:
            java.lang.String r8 = "FirebaseInstanceId"
            java.lang.String r1 = "No response"
            android.util.Log.w(r8, r1)     // Catch:{ all -> 0x00fb }
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "TIMEOUT"
            r8.<init>(r1)     // Catch:{ all -> 0x00fb }
            throw r8     // Catch:{ all -> 0x00fb }
        L_0x0116:
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r1 = r7.zzcs
            monitor-enter(r1)
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r7.zzcs     // Catch:{ all -> 0x0120 }
            r2.remove(r0)     // Catch:{ all -> 0x0120 }
            monitor-exit(r1)     // Catch:{ all -> 0x0120 }
            throw r8
        L_0x0120:
            r8 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0120 }
            throw r8
        L_0x0123:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r0 = "MISSING_INSTANCEID_SERVICE"
            r8.<init>(r0)
            throw r8
        L_0x012b:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x012b }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzat.zze(android.os.Bundle):android.os.Bundle");
    }
}
