package com.google.firebase.iid;

final /* synthetic */ class zzag implements Runnable {
    private final zzad zzcc;

    zzag(zzad zzad) {
        this.zzcc = zzad;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        r3 = java.lang.String.valueOf(r1);
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r3).length() + 8);
        r5.append("Sending ");
        r5.append(r3);
        android.util.Log.d("MessengerIpcClient", r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
        r3 = r0.zzcb.zzx;
        r4 = r0.zzbx;
        r5 = android.os.Message.obtain();
        r5.what = r1.what;
        r5.arg1 = r1.zzcf;
        r5.replyTo = r4;
        r4 = new android.os.Bundle();
        r4.putBoolean("oneWay", r1.zzab());
        r4.putString("pkg", r3.getPackageName());
        r4.putBundle("data", r1.zzch);
        r5.setData(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.zzby.send(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a7, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a8, code lost:
        r0.zza(2, r1.getMessage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            com.google.firebase.iid.zzad r0 = r8.zzcc
        L_0x0002:
            monitor-enter(r0)
            int r1 = r0.state     // Catch:{ all -> 0x00b1 }
            r2 = 2
            if (r1 == r2) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x00b1 }
            return
        L_0x000a:
            java.util.Queue<com.google.firebase.iid.zzak<?>> r1 = r0.zzbz     // Catch:{ all -> 0x00b1 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x0017
            r0.zzz()     // Catch:{ all -> 0x00b1 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b1 }
            return
        L_0x0017:
            java.util.Queue<com.google.firebase.iid.zzak<?>> r1 = r0.zzbz     // Catch:{ all -> 0x00b1 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x00b1 }
            com.google.firebase.iid.zzak r1 = (com.google.firebase.iid.zzak) r1     // Catch:{ all -> 0x00b1 }
            android.util.SparseArray<com.google.firebase.iid.zzak<?>> r3 = r0.zzca     // Catch:{ all -> 0x00b1 }
            int r4 = r1.zzcf     // Catch:{ all -> 0x00b1 }
            r3.put(r4, r1)     // Catch:{ all -> 0x00b1 }
            com.google.firebase.iid.zzab r3 = r0.zzcb     // Catch:{ all -> 0x00b1 }
            java.util.concurrent.ScheduledExecutorService r3 = r3.zzbu     // Catch:{ all -> 0x00b1 }
            com.google.firebase.iid.zzah r4 = new com.google.firebase.iid.zzah     // Catch:{ all -> 0x00b1 }
            r4.<init>(r0, r1)     // Catch:{ all -> 0x00b1 }
            r5 = 30
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x00b1 }
            r3.schedule(r4, r5, r7)     // Catch:{ all -> 0x00b1 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b1 }
            r3 = 3
            java.lang.String r4 = "MessengerIpcClient"
            boolean r3 = android.util.Log.isLoggable(r4, r3)
            if (r3 == 0) goto L_0x0067
            java.lang.String r3 = java.lang.String.valueOf(r1)
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r4 = r4.length()
            int r4 = r4 + 8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "Sending "
            r5.append(r4)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            java.lang.String r4 = "MessengerIpcClient"
            android.util.Log.d(r4, r3)
        L_0x0067:
            com.google.firebase.iid.zzab r3 = r0.zzcb
            android.content.Context r3 = r3.zzx
            android.os.Messenger r4 = r0.zzbx
            android.os.Message r5 = android.os.Message.obtain()
            int r6 = r1.what
            r5.what = r6
            int r6 = r1.zzcf
            r5.arg1 = r6
            r5.replyTo = r4
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            boolean r6 = r1.zzab()
            java.lang.String r7 = "oneWay"
            r4.putBoolean(r7, r6)
            java.lang.String r3 = r3.getPackageName()
            java.lang.String r6 = "pkg"
            r4.putString(r6, r3)
            android.os.Bundle r1 = r1.zzch
            java.lang.String r3 = "data"
            r4.putBundle(r3, r1)
            r5.setData(r4)
            com.google.firebase.iid.zzai r1 = r0.zzby     // Catch:{ RemoteException -> 0x00a7 }
            r1.send(r5)     // Catch:{ RemoteException -> 0x00a7 }
            goto L_0x0002
        L_0x00a7:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            r0.zza(r2, r1)
            goto L_0x0002
        L_0x00b1:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b1 }
            goto L_0x00b5
        L_0x00b4:
            throw r1
        L_0x00b5:
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzag.run():void");
    }
}
