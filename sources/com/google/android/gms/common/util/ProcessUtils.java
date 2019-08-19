package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

@KeepForSdk
public class ProcessUtils {
    private static String zzhe = null;
    private static int zzhf = 0;

    private ProcessUtils() {
    }

    @KeepForSdk
    @Nullable
    public static String getMyProcessName() {
        if (zzhe == null) {
            if (zzhf == 0) {
                zzhf = Process.myPid();
            }
            zzhe = zzd(zzhf);
        }
        return zzhe;
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zzd(int r4) {
        /*
            r0 = 0
            if (r4 > 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 25
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x003a, all -> 0x0035 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x003a, all -> 0x0035 }
            java.lang.String r1 = "/proc/"
            r2.append(r1)     // Catch:{ IOException -> 0x003a, all -> 0x0035 }
            r2.append(r4)     // Catch:{ IOException -> 0x003a, all -> 0x0035 }
            java.lang.String r4 = "/cmdline"
            r2.append(r4)     // Catch:{ IOException -> 0x003a, all -> 0x0035 }
            java.lang.String r4 = r2.toString()     // Catch:{ IOException -> 0x003a, all -> 0x0035 }
            java.io.BufferedReader r4 = zzj(r4)     // Catch:{ IOException -> 0x003a, all -> 0x0035 }
            java.lang.String r1 = r4.readLine()     // Catch:{ IOException -> 0x0033, all -> 0x002e }
            java.lang.String r0 = r1.trim()     // Catch:{ IOException -> 0x0033, all -> 0x002e }
            com.google.android.gms.common.util.IOUtils.closeQuietly(r4)
            goto L_0x0040
        L_0x002e:
            r0 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L_0x0036
        L_0x0033:
            r1 = move-exception
            goto L_0x003c
        L_0x0035:
            r4 = move-exception
        L_0x0036:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r0)
            throw r4
        L_0x003a:
            r4 = move-exception
            r4 = r0
        L_0x003c:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r4)
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.ProcessUtils.zzd(int):java.lang.String");
    }

    private static BufferedReader zzj(String str) throws IOException {
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
