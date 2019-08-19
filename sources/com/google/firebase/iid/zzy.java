package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.p000v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.firebase_messaging.zzc;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

final class zzy {
    zzy() {
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final zzz zzb(Context context, String str) throws zzaa {
        zzz zzd = zzd(context, str);
        if (zzd != null) {
            return zzd;
        }
        return zzc(context, str);
    }

    /* access modifiers changed from: 0000 */
    @WorkerThread
    public final zzz zzc(Context context, String str) {
        zzz zzz = new zzz(zza.zzb(), System.currentTimeMillis());
        zzz zza = zza(context, str, zzz, true);
        String str2 = "FirebaseInstanceId";
        if (zza == null || zza.equals(zzz)) {
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "Generated new key");
            }
            zza(context, str, zzz);
            return zzz;
        }
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, "Loaded key after generating new one, using loaded one");
        }
        return zza;
    }

    static void zza(Context context) {
        File[] listFiles;
        for (File file : zzb(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    @Nullable
    private final zzz zzd(Context context, String str) throws zzaa {
        try {
            zzz zze = zze(context, str);
            if (zze != null) {
                zza(context, str, zze);
                return zze;
            }
            e = null;
            try {
                zzz zza = zza(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (zza != null) {
                    zza(context, str, zza, false);
                    return zza;
                }
            } catch (zzaa e) {
                e = e;
            }
            if (e == null) {
                return null;
            }
            throw e;
        } catch (zzaa e2) {
            e = e2;
        }
    }

    private static KeyPair zzc(String str, String str2) throws zzaa {
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance("RSA");
                return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
                sb.append("Invalid key stored ");
                sb.append(valueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                throw new zzaa((Exception) e);
            }
        } catch (IllegalArgumentException e2) {
            throw new zzaa((Exception) e2);
        }
    }

    @Nullable
    private final zzz zze(Context context, String str) throws zzaa {
        File zzf = zzf(context, str);
        if (!zzf.exists()) {
            return null;
        }
        try {
            return zza(zzf);
        } catch (zzaa | IOException e) {
            String str2 = "FirebaseInstanceId";
            if (Log.isLoggable(str2, 3)) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 40);
                sb.append("Failed to read key from file, retrying: ");
                sb.append(valueOf);
                Log.d(str2, sb.toString());
            }
            try {
                return zza(zzf);
            } catch (IOException e2) {
                String valueOf2 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 45);
                sb2.append("IID file exists, but failed to read from it: ");
                sb2.append(valueOf2);
                Log.w(str2, sb2.toString());
                throw new zzaa((Exception) e2);
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x00a0=Splitter:B:31:0x00a0, B:19:0x0061=Splitter:B:19:0x0061, B:52:0x00bc=Splitter:B:52:0x00bc} */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.firebase.iid.zzz zza(android.content.Context r10, java.lang.String r11, com.google.firebase.iid.zzz r12, boolean r13) {
        /*
            r9 = this;
            r0 = 3
            java.lang.String r1 = "FirebaseInstanceId"
            boolean r2 = android.util.Log.isLoggable(r1, r0)
            if (r2 == 0) goto L_0x000e
            java.lang.String r2 = "Writing key to properties file"
            android.util.Log.d(r1, r2)
        L_0x000e:
            java.util.Properties r2 = new java.util.Properties
            r2.<init>()
            java.lang.String r3 = r12.zzv()
            java.lang.String r4 = "pub"
            r2.setProperty(r4, r3)
            java.lang.String r3 = r12.zzw()
            java.lang.String r4 = "pri"
            r2.setProperty(r4, r3)
            long r3 = r12.zzbs
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "cre"
            r2.setProperty(r4, r3)
            java.io.File r10 = zzf(r10, r11)
            r11 = 0
            r10.createNewFile()     // Catch:{ IOException -> 0x00c0 }
            java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x00c0 }
            java.lang.String r4 = "rw"
            r3.<init>(r10, r4)     // Catch:{ IOException -> 0x00c0 }
            java.nio.channels.FileChannel r10 = r3.getChannel()     // Catch:{ Throwable -> 0x00b6, all -> 0x00b3 }
            r10.lock()     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
            r4 = 0
            if (r13 == 0) goto L_0x0090
            long r6 = r10.size()     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
            int r13 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r13 <= 0) goto L_0x0090
            r10.position(r4)     // Catch:{ IOException -> 0x0067, zzaa -> 0x0065 }
            com.google.firebase.iid.zzz r12 = zza(r10)     // Catch:{ IOException -> 0x0067, zzaa -> 0x0065 }
            if (r10 == 0) goto L_0x0061
            zza(r11, r10)     // Catch:{ Throwable -> 0x00b6, all -> 0x00b3 }
        L_0x0061:
            zza(r11, r3)     // Catch:{ IOException -> 0x00c0 }
            return r12
        L_0x0065:
            r13 = move-exception
            goto L_0x0068
        L_0x0067:
            r13 = move-exception
        L_0x0068:
            boolean r0 = android.util.Log.isLoggable(r1, r0)     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
            if (r0 == 0) goto L_0x0090
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
            java.lang.String r0 = java.lang.String.valueOf(r13)     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
            int r0 = r0.length()     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
            int r0 = r0 + 64
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
            r6.<init>(r0)     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
            java.lang.String r0 = "Tried reading key pair before writing new one, but failed with: "
            r6.append(r0)     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
            r6.append(r13)     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
            java.lang.String r13 = r6.toString()     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
            android.util.Log.d(r1, r13)     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
        L_0x0090:
            r10.position(r4)     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
            java.io.OutputStream r13 = java.nio.channels.Channels.newOutputStream(r10)     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
            r2.store(r13, r11)     // Catch:{ Throwable -> 0x00a7, all -> 0x00a4 }
            if (r10 == 0) goto L_0x00a0
            zza(r11, r10)     // Catch:{ Throwable -> 0x00b6, all -> 0x00b3 }
        L_0x00a0:
            zza(r11, r3)     // Catch:{ IOException -> 0x00c0 }
            return r12
        L_0x00a4:
            r12 = move-exception
            r13 = r11
            goto L_0x00ad
        L_0x00a7:
            r12 = move-exception
            throw r12     // Catch:{ all -> 0x00a9 }
        L_0x00a9:
            r13 = move-exception
            r8 = r13
            r13 = r12
            r12 = r8
        L_0x00ad:
            if (r10 == 0) goto L_0x00b2
            zza(r13, r10)     // Catch:{ Throwable -> 0x00b6, all -> 0x00b3 }
        L_0x00b2:
            throw r12     // Catch:{ Throwable -> 0x00b6, all -> 0x00b3 }
        L_0x00b3:
            r10 = move-exception
            r12 = r11
            goto L_0x00bc
        L_0x00b6:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x00b8 }
        L_0x00b8:
            r12 = move-exception
            r8 = r12
            r12 = r10
            r10 = r8
        L_0x00bc:
            zza(r12, r3)     // Catch:{ IOException -> 0x00c0 }
            throw r10     // Catch:{ IOException -> 0x00c0 }
        L_0x00c0:
            r10 = move-exception
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.String r12 = java.lang.String.valueOf(r10)
            int r12 = r12.length()
            int r12 = r12 + 21
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r12)
            java.lang.String r12 = "Failed to write key: "
            r13.append(r12)
            r13.append(r10)
            java.lang.String r10 = r13.toString()
            android.util.Log.w(r1, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzy.zza(android.content.Context, java.lang.String, com.google.firebase.iid.zzz, boolean):com.google.firebase.iid.zzz");
    }

    private static File zzb(Context context) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(context);
        if (noBackupFilesDir != null && noBackupFilesDir.isDirectory()) {
            return noBackupFilesDir;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private static File zzf(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb.append("com.google.InstanceId_");
                sb.append(encodeToString);
                sb.append(".properties");
                str2 = sb.toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(zzb(context), str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0033, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0037, code lost:
        zza(r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003a, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.firebase.iid.zzz zza(java.io.File r10) throws com.google.firebase.iid.zzaa, java.io.IOException {
        /*
            r9 = this;
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r10)
            r10 = 0
            java.nio.channels.FileChannel r7 = r0.getChannel()     // Catch:{ Throwable -> 0x0035 }
            r2 = 0
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6 = 1
            r1 = r7
            r1.lock(r2, r4, r6)     // Catch:{ Throwable -> 0x0027, all -> 0x0024 }
            com.google.firebase.iid.zzz r1 = zza(r7)     // Catch:{ Throwable -> 0x0027, all -> 0x0024 }
            if (r7 == 0) goto L_0x0020
            zza(r10, r7)     // Catch:{ Throwable -> 0x0035 }
        L_0x0020:
            zza(r10, r0)
            return r1
        L_0x0024:
            r1 = move-exception
            r2 = r10
            goto L_0x002d
        L_0x0027:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0029 }
        L_0x0029:
            r2 = move-exception
            r8 = r2
            r2 = r1
            r1 = r8
        L_0x002d:
            if (r7 == 0) goto L_0x0032
            zza(r2, r7)     // Catch:{ Throwable -> 0x0035 }
        L_0x0032:
            throw r1     // Catch:{ Throwable -> 0x0035 }
        L_0x0033:
            r1 = move-exception
            goto L_0x0037
        L_0x0035:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x0033 }
        L_0x0037:
            zza(r10, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzy.zza(java.io.File):com.google.firebase.iid.zzz");
    }

    private static zzz zza(FileChannel fileChannel) throws zzaa, IOException {
        Properties properties = new Properties();
        properties.load(Channels.newInputStream(fileChannel));
        String property = properties.getProperty("pub");
        String property2 = properties.getProperty("pri");
        if (property == null || property2 == null) {
            throw new zzaa("Invalid properties file");
        }
        try {
            return new zzz(zzc(property, property2), Long.parseLong(properties.getProperty("cre")));
        } catch (NumberFormatException e) {
            throw new zzaa((Exception) e);
        }
    }

    @Nullable
    private static zzz zza(SharedPreferences sharedPreferences, String str) throws zzaa {
        String string = sharedPreferences.getString(zzaw.zzd(str, "|P|"), null);
        String string2 = sharedPreferences.getString(zzaw.zzd(str, "|K|"), null);
        if (string == null || string2 == null) {
            return null;
        }
        return new zzz(zzc(string, string2), zzb(sharedPreferences, str));
    }

    private final void zza(Context context, String str, zzz zzz) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzz.equals(zza(sharedPreferences, str))) {
                return;
            }
        } catch (zzaa e) {
        }
        String str2 = "FirebaseInstanceId";
        if (Log.isLoggable(str2, 3)) {
            Log.d(str2, "Writing key to shared preferences");
        }
        Editor edit = sharedPreferences.edit();
        edit.putString(zzaw.zzd(str, "|P|"), zzz.zzv());
        edit.putString(zzaw.zzd(str, "|K|"), zzz.zzw());
        edit.putString(zzaw.zzd(str, "cre"), String.valueOf(zzz.zzbs));
        edit.commit();
    }

    private static long zzb(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(zzaw.zzd(str, "cre"), null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException e) {
            }
        }
        return 0;
    }

    private static /* synthetic */ void zza(Throwable th, FileChannel fileChannel) {
        if (th != null) {
            try {
                fileChannel.close();
            } catch (Throwable th2) {
                zzc.zza(th, th2);
            }
        } else {
            fileChannel.close();
        }
    }

    private static /* synthetic */ void zza(Throwable th, RandomAccessFile randomAccessFile) {
        if (th != null) {
            try {
                randomAccessFile.close();
            } catch (Throwable th2) {
                zzc.zza(th, th2);
            }
        } else {
            randomAccessFile.close();
        }
    }

    private static /* synthetic */ void zza(Throwable th, FileInputStream fileInputStream) {
        if (th != null) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                zzc.zza(th, th2);
            }
        } else {
            fileInputStream.close();
        }
    }
}
