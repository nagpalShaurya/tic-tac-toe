package com.google.firebase.auth;

import android.app.Activity;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdj;
import com.google.android.gms.internal.firebase_auth.zzjn;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import com.google.firebase.auth.api.internal.zzao;
import com.google.firebase.auth.api.internal.zzed;
import com.google.firebase.auth.api.internal.zzeg;
import com.google.firebase.auth.api.internal.zzem;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzad;
import com.google.firebase.auth.internal.zzae;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzah;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzk;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzv;
import com.google.firebase.auth.internal.zzw;
import com.google.firebase.auth.internal.zzz;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class FirebaseAuth implements InternalAuthProvider {
    /* access modifiers changed from: private */
    public FirebaseApp zzgm;
    /* access modifiers changed from: private */
    public final List<IdTokenListener> zzgn;
    /* access modifiers changed from: private */
    public final List<com.google.firebase.auth.internal.IdTokenListener> zzgo;
    /* access modifiers changed from: private */
    public List<AuthStateListener> zzgp;
    private zzao zzgq;
    /* access modifiers changed from: private */
    public FirebaseUser zzgr;
    /* access modifiers changed from: private */
    public zzk zzgs;
    private final Object zzgt;
    private String zzgu;
    private final Object zzgv;
    private String zzgw;
    private final zzad zzgx;
    private final zzz zzgy;
    private zzae zzgz;
    private zzag zzha;

    public interface AuthStateListener {
        void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    public interface IdTokenListener {
        void onIdTokenChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    @VisibleForTesting
    class zza implements com.google.firebase.auth.internal.zza {
        zza() {
        }

        public final void zza(@NonNull zzcz zzcz, @NonNull FirebaseUser firebaseUser) {
            Preconditions.checkNotNull(zzcz);
            Preconditions.checkNotNull(firebaseUser);
            firebaseUser.zza(zzcz);
            FirebaseAuth.this.zza(firebaseUser, zzcz, true);
        }
    }

    @VisibleForTesting
    class zzb extends zza implements com.google.firebase.auth.internal.zza, zzw {
        zzb() {
            super();
        }

        public final void zza(Status status) {
            if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005) {
                FirebaseAuth.this.signOut();
            }
        }
    }

    class zzc extends zza implements com.google.firebase.auth.internal.zza, zzw {
        zzc(FirebaseAuth firebaseAuth) {
            super();
        }

        public final void zza(Status status) {
        }
    }

    @Keep
    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    @Keep
    public static FirebaseAuth getInstance(@NonNull FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    public FirebaseAuth(FirebaseApp firebaseApp) {
        this(firebaseApp, zzed.zza(firebaseApp.getApplicationContext(), new zzeg(firebaseApp.getOptions().getApiKey()).zzdk()), new zzad(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey()), zzz.zzem());
    }

    @VisibleForTesting
    private FirebaseAuth(FirebaseApp firebaseApp, zzao zzao, zzad zzad, zzz zzz) {
        this.zzgt = new Object();
        this.zzgv = new Object();
        this.zzgm = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzgq = (zzao) Preconditions.checkNotNull(zzao);
        this.zzgx = (zzad) Preconditions.checkNotNull(zzad);
        this.zzgs = new zzk();
        this.zzgy = (zzz) Preconditions.checkNotNull(zzz);
        this.zzgn = new CopyOnWriteArrayList();
        this.zzgo = new CopyOnWriteArrayList();
        this.zzgp = new CopyOnWriteArrayList();
        this.zzha = zzag.zzeq();
        this.zzgr = this.zzgx.zzeo();
        FirebaseUser firebaseUser = this.zzgr;
        if (firebaseUser != null) {
            zzcz zzh = this.zzgx.zzh(firebaseUser);
            if (zzh != null) {
                zza(this.zzgr, zzh, false);
            }
        }
        this.zzgy.zzg(this);
    }

    @Nullable
    public FirebaseUser getCurrentUser() {
        return this.zzgr;
    }

    @Nullable
    public String getUid() {
        FirebaseUser firebaseUser = this.zzgr;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.getUid();
    }

    public final void zza(@NonNull FirebaseUser firebaseUser, @NonNull zzcz zzcz, boolean z) {
        boolean z2;
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzcz);
        FirebaseUser firebaseUser2 = this.zzgr;
        boolean z3 = true;
        if (firebaseUser2 == null) {
            z2 = true;
        } else {
            boolean z4 = !firebaseUser2.zzcg().zzdw().equals(zzcz.zzdw());
            boolean equals = this.zzgr.getUid().equals(firebaseUser.getUid());
            if (!equals || z4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (equals) {
                z3 = false;
            }
        }
        Preconditions.checkNotNull(firebaseUser);
        FirebaseUser firebaseUser3 = this.zzgr;
        if (firebaseUser3 == null) {
            this.zzgr = firebaseUser;
        } else {
            firebaseUser3.zza(firebaseUser.getProviderData());
            if (!firebaseUser.isAnonymous()) {
                this.zzgr.zzce();
            }
        }
        if (z) {
            this.zzgx.zzg(this.zzgr);
        }
        if (z2) {
            FirebaseUser firebaseUser4 = this.zzgr;
            if (firebaseUser4 != null) {
                firebaseUser4.zza(zzcz);
            }
            zzb(this.zzgr);
        }
        if (z3) {
            zzc(this.zzgr);
        }
        if (z) {
            this.zzgx.zza(firebaseUser, zzcz);
        }
        zzcb().zzc(this.zzgr.zzcg());
    }

    public final void zzca() {
        FirebaseUser firebaseUser = this.zzgr;
        if (firebaseUser != null) {
            zzad zzad = this.zzgx;
            Preconditions.checkNotNull(firebaseUser);
            zzad.clear(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}));
            this.zzgr = null;
        }
        this.zzgx.clear("com.google.firebase.auth.FIREBASE_USER");
        zzb((FirebaseUser) null);
        zzc((FirebaseUser) null);
    }

    @VisibleForTesting
    private final synchronized void zza(zzae zzae) {
        this.zzgz = zzae;
        this.zzgm.setIdTokenListenersCountChangedListener(zzae);
    }

    @VisibleForTesting
    private final synchronized zzae zzcb() {
        if (this.zzgz == null) {
            zza(new zzae(this.zzgm));
        }
        return this.zzgz;
    }

    public FirebaseApp getApp() {
        return this.zzgm;
    }

    public final FirebaseApp zzcc() {
        return this.zzgm;
    }

    public void addIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.zzgn.add(idTokenListener);
        this.zzha.execute(new zzi(this, idTokenListener));
    }

    @KeepForSdk
    public void addIdTokenListener(@NonNull com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzgo.add(idTokenListener);
        zzcb().zzf(this.zzgo.size());
    }

    public void removeIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.zzgn.remove(idTokenListener);
    }

    @KeepForSdk
    public void removeIdTokenListener(@NonNull com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzgo.remove(idTokenListener);
        zzcb().zzf(this.zzgo.size());
    }

    public void addAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.zzgp.add(authStateListener);
        this.zzha.execute(new zzj(this, authStateListener));
    }

    public void removeAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.zzgp.remove(authStateListener);
    }

    private final void zzb(@Nullable FirebaseUser firebaseUser) {
        String str = "FirebaseAuth";
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            StringBuilder sb = new StringBuilder(String.valueOf(uid).length() + 45);
            sb.append("Notifying id token listeners about user ( ");
            sb.append(uid);
            sb.append(" ).");
            Log.d(str, sb.toString());
        } else {
            Log.d(str, "Notifying id token listeners about a sign-out event.");
        }
        this.zzha.execute(new zzk(this, new InternalTokenResult(firebaseUser != null ? firebaseUser.zzci() : null)));
    }

    private final void zzc(@Nullable FirebaseUser firebaseUser) {
        String str = "FirebaseAuth";
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            StringBuilder sb = new StringBuilder(String.valueOf(uid).length() + 47);
            sb.append("Notifying auth state listeners about user ( ");
            sb.append(uid);
            sb.append(" ).");
            Log.d(str, sb.toString());
        } else {
            Log.d(str, "Notifying auth state listeners about a sign-out event.");
        }
        this.zzha.execute(new zzl(this));
    }

    @NonNull
    public Task<GetTokenResult> getAccessToken(boolean z) {
        return zza(this.zzgr, z);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.zzm, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0, types: [com.google.firebase.auth.zzm, com.google.firebase.auth.internal.zzah]
      assigns: [com.google.firebase.auth.zzm]
      uses: [com.google.firebase.auth.internal.zzah]
      mth insns count: 19
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<com.google.firebase.auth.GetTokenResult> zza(@android.support.annotation.Nullable com.google.firebase.auth.FirebaseUser r4, boolean r5) {
        /*
            r3 = this;
            if (r4 != 0) goto L_0x0012
            com.google.android.gms.common.api.Status r4 = new com.google.android.gms.common.api.Status
            r5 = 17495(0x4457, float:2.4516E-41)
            r4.<init>(r5)
            com.google.firebase.FirebaseException r4 = com.google.firebase.auth.api.internal.zzds.zzb(r4)
            com.google.android.gms.tasks.Task r4 = com.google.android.gms.tasks.Tasks.forException(r4)
            return r4
        L_0x0012:
            com.google.android.gms.internal.firebase_auth.zzcz r0 = r4.zzcg()
            boolean r1 = r0.isValid()
            if (r1 == 0) goto L_0x002c
            if (r5 != 0) goto L_0x002c
            java.lang.String r4 = r0.zzdw()
            com.google.firebase.auth.GetTokenResult r4 = com.google.firebase.auth.internal.zzaa.zzcu(r4)
            com.google.android.gms.tasks.Task r4 = com.google.android.gms.tasks.Tasks.forResult(r4)
            return r4
        L_0x002c:
            com.google.firebase.auth.api.internal.zzao r5 = r3.zzgq
            com.google.firebase.FirebaseApp r1 = r3.zzgm
            java.lang.String r0 = r0.zzr()
            com.google.firebase.auth.zzm r2 = new com.google.firebase.auth.zzm
            r2.<init>(r3)
            com.google.android.gms.tasks.Task r4 = r5.zza(r1, r4, r0, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.zza(com.google.firebase.auth.FirebaseUser, boolean):com.google.android.gms.tasks.Task");
    }

    @NonNull
    public Task<AuthResult> signInWithCredential(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzbz()) {
                return this.zzgq.zzb(this.zzgm, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), this.zzgw, (com.google.firebase.auth.internal.zza) new zza());
            }
            return this.zzgq.zza(this.zzgm, emailAuthCredential, (com.google.firebase.auth.internal.zza) new zza());
        } else if (!(authCredential instanceof PhoneAuthCredential)) {
            return this.zzgq.zza(this.zzgm, authCredential, this.zzgw, (com.google.firebase.auth.internal.zza) new zza());
        } else {
            return this.zzgq.zza(this.zzgm, (PhoneAuthCredential) authCredential, this.zzgw, (com.google.firebase.auth.internal.zza) new zza());
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: type inference failed for: r6v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: type inference failed for: r2v2, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: type inference failed for: r7v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah]
      assigns: [com.google.firebase.auth.FirebaseAuth$zzb]
      uses: [com.google.firebase.auth.internal.zzah]
      mth insns count: 44
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<java.lang.Void> zza(@android.support.annotation.NonNull com.google.firebase.auth.FirebaseUser r9, @android.support.annotation.NonNull com.google.firebase.auth.AuthCredential r10) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)
            java.lang.Class<com.google.firebase.auth.EmailAuthCredential> r0 = com.google.firebase.auth.EmailAuthCredential.class
            java.lang.Class r1 = r10.getClass()
            boolean r0 = r0.isAssignableFrom(r1)
            if (r0 == 0) goto L_0x004a
            com.google.firebase.auth.EmailAuthCredential r10 = (com.google.firebase.auth.EmailAuthCredential) r10
            java.lang.String r0 = r10.getSignInMethod()
            java.lang.String r1 = "password"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x003c
            com.google.firebase.auth.api.internal.zzao r1 = r8.zzgq
            com.google.firebase.FirebaseApp r2 = r8.zzgm
            java.lang.String r4 = r10.getEmail()
            java.lang.String r5 = r10.getPassword()
            java.lang.String r6 = r9.zzcf()
            com.google.firebase.auth.FirebaseAuth$zzb r7 = new com.google.firebase.auth.FirebaseAuth$zzb
            r7.<init>()
            r3 = r9
            com.google.android.gms.tasks.Task r9 = r1.zza(r2, r3, r4, r5, r6, r7)
            return r9
        L_0x003c:
            com.google.firebase.auth.api.internal.zzao r0 = r8.zzgq
            com.google.firebase.FirebaseApp r1 = r8.zzgm
            com.google.firebase.auth.FirebaseAuth$zzb r2 = new com.google.firebase.auth.FirebaseAuth$zzb
            r2.<init>()
            com.google.android.gms.tasks.Task r9 = r0.zza(r1, r9, r10, r2)
            return r9
        L_0x004a:
            boolean r0 = r10 instanceof com.google.firebase.auth.PhoneAuthCredential
            if (r0 == 0) goto L_0x0062
            com.google.firebase.auth.api.internal.zzao r1 = r8.zzgq
            com.google.firebase.FirebaseApp r2 = r8.zzgm
            r4 = r10
            com.google.firebase.auth.PhoneAuthCredential r4 = (com.google.firebase.auth.PhoneAuthCredential) r4
            java.lang.String r5 = r8.zzgw
            com.google.firebase.auth.FirebaseAuth$zzb r6 = new com.google.firebase.auth.FirebaseAuth$zzb
            r6.<init>()
            r3 = r9
            com.google.android.gms.tasks.Task r9 = r1.zza(r2, r3, r4, r5, r6)
            return r9
        L_0x0062:
            com.google.firebase.auth.api.internal.zzao r0 = r8.zzgq
            com.google.firebase.FirebaseApp r1 = r8.zzgm
            java.lang.String r4 = r9.zzcf()
            com.google.firebase.auth.FirebaseAuth$zzb r5 = new com.google.firebase.auth.FirebaseAuth$zzb
            r5.<init>()
            r2 = r9
            r3 = r10
            com.google.android.gms.tasks.Task r9 = r0.zza(r1, r2, r3, r4, r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.zza(com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.AuthCredential):com.google.android.gms.tasks.Task");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: type inference failed for: r6v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: type inference failed for: r2v2, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: type inference failed for: r7v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah]
      assigns: [com.google.firebase.auth.FirebaseAuth$zzb]
      uses: [com.google.firebase.auth.internal.zzah]
      mth insns count: 44
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 4 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult> zzb(@android.support.annotation.NonNull com.google.firebase.auth.FirebaseUser r9, @android.support.annotation.NonNull com.google.firebase.auth.AuthCredential r10) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)
            java.lang.Class<com.google.firebase.auth.EmailAuthCredential> r0 = com.google.firebase.auth.EmailAuthCredential.class
            java.lang.Class r1 = r10.getClass()
            boolean r0 = r0.isAssignableFrom(r1)
            if (r0 == 0) goto L_0x004a
            com.google.firebase.auth.EmailAuthCredential r10 = (com.google.firebase.auth.EmailAuthCredential) r10
            java.lang.String r0 = r10.getSignInMethod()
            java.lang.String r1 = "password"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x003c
            com.google.firebase.auth.api.internal.zzao r1 = r8.zzgq
            com.google.firebase.FirebaseApp r2 = r8.zzgm
            java.lang.String r4 = r10.getEmail()
            java.lang.String r5 = r10.getPassword()
            java.lang.String r6 = r9.zzcf()
            com.google.firebase.auth.FirebaseAuth$zzb r7 = new com.google.firebase.auth.FirebaseAuth$zzb
            r7.<init>()
            r3 = r9
            com.google.android.gms.tasks.Task r9 = r1.zzb(r2, r3, r4, r5, r6, r7)
            return r9
        L_0x003c:
            com.google.firebase.auth.api.internal.zzao r0 = r8.zzgq
            com.google.firebase.FirebaseApp r1 = r8.zzgm
            com.google.firebase.auth.FirebaseAuth$zzb r2 = new com.google.firebase.auth.FirebaseAuth$zzb
            r2.<init>()
            com.google.android.gms.tasks.Task r9 = r0.zzb(r1, r9, r10, r2)
            return r9
        L_0x004a:
            boolean r0 = r10 instanceof com.google.firebase.auth.PhoneAuthCredential
            if (r0 == 0) goto L_0x0062
            com.google.firebase.auth.api.internal.zzao r1 = r8.zzgq
            com.google.firebase.FirebaseApp r2 = r8.zzgm
            r4 = r10
            com.google.firebase.auth.PhoneAuthCredential r4 = (com.google.firebase.auth.PhoneAuthCredential) r4
            java.lang.String r5 = r8.zzgw
            com.google.firebase.auth.FirebaseAuth$zzb r6 = new com.google.firebase.auth.FirebaseAuth$zzb
            r6.<init>()
            r3 = r9
            com.google.android.gms.tasks.Task r9 = r1.zzb(r2, r3, r4, r5, r6)
            return r9
        L_0x0062:
            com.google.firebase.auth.api.internal.zzao r0 = r8.zzgq
            com.google.firebase.FirebaseApp r1 = r8.zzgm
            java.lang.String r4 = r9.zzcf()
            com.google.firebase.auth.FirebaseAuth$zzb r5 = new com.google.firebase.auth.FirebaseAuth$zzb
            r5.<init>()
            r2 = r9
            r3 = r10
            com.google.android.gms.tasks.Task r9 = r0.zzb(r1, r2, r3, r4, r5)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.zzb(com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.AuthCredential):com.google.android.gms.tasks.Task");
    }

    @NonNull
    public Task<AuthResult> signInWithCustomToken(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zza(this.zzgm, str, (com.google.firebase.auth.internal.zza) new zza());
    }

    @NonNull
    public Task<AuthResult> signInWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzgq.zzb(this.zzgm, str, str2, this.zzgw, (com.google.firebase.auth.internal.zza) new zza());
    }

    @NonNull
    public Task<AuthResult> signInWithEmailLink(@NonNull String str, @NonNull String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    @NonNull
    public Task<AuthResult> signInAnonymously() {
        FirebaseUser firebaseUser = this.zzgr;
        if (firebaseUser == null || !firebaseUser.isAnonymous()) {
            return this.zzgq.zza(this.zzgm, (com.google.firebase.auth.internal.zza) new zza(), this.zzgw);
        }
        zzl zzl = (zzl) this.zzgr;
        zzl.zzr(false);
        return Tasks.forResult(new zzf(zzl));
    }

    @NonNull
    public final void zza(@NonNull String str, long j, TimeUnit timeUnit, @NonNull OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, @NonNull Executor executor, boolean z) {
        OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks2;
        OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks3;
        long j2 = j;
        long convert = TimeUnit.SECONDS.convert(j, timeUnit);
        if (convert < 0 || convert > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        zzdj zzdj = new zzdj(str, convert, z, this.zzgu, this.zzgw);
        if (this.zzgs.zzee()) {
            String str2 = str;
            if (str.equals(this.zzgs.getPhoneNumber())) {
                onVerificationStateChangedCallbacks2 = new zzn(this, onVerificationStateChangedCallbacks);
                this.zzgq.zza(this.zzgm, zzdj, onVerificationStateChangedCallbacks2, activity, executor);
            }
            onVerificationStateChangedCallbacks3 = onVerificationStateChangedCallbacks;
        } else {
            onVerificationStateChangedCallbacks3 = onVerificationStateChangedCallbacks;
        }
        onVerificationStateChangedCallbacks2 = onVerificationStateChangedCallbacks3;
        this.zzgq.zza(this.zzgm, zzdj, onVerificationStateChangedCallbacks2, activity, executor);
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [com.google.firebase.auth.FirebaseAuth$zzc, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v5, types: [com.google.firebase.auth.FirebaseAuth$zzc, com.google.firebase.auth.internal.zzah]
      assigns: [com.google.firebase.auth.FirebaseAuth$zzc]
      uses: [com.google.firebase.auth.internal.zzah]
      mth insns count: 34
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.tasks.Task<java.lang.Void> updateCurrentUser(@android.support.annotation.NonNull com.google.firebase.auth.FirebaseUser r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x0066
            com.google.firebase.auth.FirebaseUser r0 = r3.zzgr
            if (r0 == 0) goto L_0x0022
            java.lang.String r0 = r4.zzcf()
            java.lang.String r1 = r3.zzgw
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0022
            com.google.android.gms.common.api.Status r4 = new com.google.android.gms.common.api.Status
            r0 = 17072(0x42b0, float:2.3923E-41)
            r4.<init>(r0)
            com.google.firebase.FirebaseException r4 = com.google.firebase.auth.api.internal.zzds.zzb(r4)
            com.google.android.gms.tasks.Task r4 = com.google.android.gms.tasks.Tasks.forException(r4)
            return r4
        L_0x0022:
            com.google.firebase.FirebaseApp r0 = r4.zzcc()
            com.google.firebase.FirebaseOptions r0 = r0.getOptions()
            java.lang.String r0 = r0.getApiKey()
            com.google.firebase.FirebaseApp r1 = r3.zzgm
            com.google.firebase.FirebaseOptions r1 = r1.getOptions()
            java.lang.String r1 = r1.getApiKey()
            com.google.android.gms.internal.firebase_auth.zzcz r2 = r4.zzcg()
            boolean r2 = r2.isValid()
            if (r2 == 0) goto L_0x005c
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x005c
            com.google.firebase.FirebaseApp r0 = r3.zzgm
            com.google.firebase.auth.FirebaseUser r0 = com.google.firebase.auth.internal.zzl.zza(r0, r4)
            com.google.android.gms.internal.firebase_auth.zzcz r4 = r4.zzcg()
            r1 = 1
            r3.zza(r0, r4, r1)
            r4 = 0
            com.google.android.gms.tasks.Task r4 = com.google.android.gms.tasks.Tasks.forResult(r4)
            return r4
        L_0x005c:
            com.google.firebase.auth.FirebaseAuth$zzc r0 = new com.google.firebase.auth.FirebaseAuth$zzc
            r0.<init>(r3)
            com.google.android.gms.tasks.Task r4 = r3.zza(r4, r0)
            return r4
        L_0x0066:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Cannot update current user with null user!"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.updateCurrentUser(com.google.firebase.auth.FirebaseUser):com.google.android.gms.tasks.Task");
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah]
      assigns: [com.google.firebase.auth.FirebaseAuth$zzb]
      uses: [com.google.firebase.auth.internal.zzah]
      mth insns count: 3
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<java.lang.Void> zzd(@android.support.annotation.NonNull com.google.firebase.auth.FirebaseUser r2) {
        /*
            r1 = this;
            com.google.firebase.auth.FirebaseAuth$zzb r0 = new com.google.firebase.auth.FirebaseAuth$zzb
            r0.<init>()
            com.google.android.gms.tasks.Task r2 = r1.zza(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.zzd(com.google.firebase.auth.FirebaseUser):com.google.android.gms.tasks.Task");
    }

    @NonNull
    private final Task<Void> zza(@NonNull FirebaseUser firebaseUser, zzah zzah) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zzgq.zza(this.zzgm, firebaseUser, zzah);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah]
      assigns: [com.google.firebase.auth.FirebaseAuth$zzb]
      uses: [com.google.firebase.auth.internal.zzah]
      mth insns count: 7
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult> zzc(@android.support.annotation.NonNull com.google.firebase.auth.FirebaseUser r4, @android.support.annotation.NonNull com.google.firebase.auth.AuthCredential r5) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            com.google.firebase.auth.api.internal.zzao r0 = r3.zzgq
            com.google.firebase.FirebaseApp r1 = r3.zzgm
            com.google.firebase.auth.FirebaseAuth$zzb r2 = new com.google.firebase.auth.FirebaseAuth$zzb
            r2.<init>()
            com.google.android.gms.tasks.Task r4 = r0.zza(r1, r4, r5, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.zzc(com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.AuthCredential):com.google.android.gms.tasks.Task");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah]
      assigns: [com.google.firebase.auth.FirebaseAuth$zzb]
      uses: [com.google.firebase.auth.internal.zzah]
      mth insns count: 7
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<com.google.firebase.auth.AuthResult> zza(@android.support.annotation.NonNull com.google.firebase.auth.FirebaseUser r4, @android.support.annotation.NonNull java.lang.String r5) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            com.google.firebase.auth.api.internal.zzao r0 = r3.zzgq
            com.google.firebase.FirebaseApp r1 = r3.zzgm
            com.google.firebase.auth.FirebaseAuth$zzb r2 = new com.google.firebase.auth.FirebaseAuth$zzb
            r2.<init>()
            com.google.android.gms.tasks.Task r4 = r0.zzd(r1, r4, r5, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.zza(com.google.firebase.auth.FirebaseUser, java.lang.String):com.google.android.gms.tasks.Task");
    }

    @NonNull
    public Task<AuthResult> createUserWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzgq.zza(this.zzgm, str, str2, this.zzgw, (com.google.firebase.auth.internal.zza) new zza());
    }

    @Deprecated
    @NonNull
    public Task<ProviderQueryResult> fetchProvidersForEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zza(this.zzgm, str, this.zzgw);
    }

    @NonNull
    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zzb(this.zzgm, str, this.zzgw);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah]
      assigns: [com.google.firebase.auth.FirebaseAuth$zzb]
      uses: [com.google.firebase.auth.internal.zzah]
      mth insns count: 7
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<java.lang.Void> zza(@android.support.annotation.NonNull com.google.firebase.auth.FirebaseUser r4, @android.support.annotation.NonNull com.google.firebase.auth.UserProfileChangeRequest r5) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            com.google.firebase.auth.api.internal.zzao r0 = r3.zzgq
            com.google.firebase.FirebaseApp r1 = r3.zzgm
            com.google.firebase.auth.FirebaseAuth$zzb r2 = new com.google.firebase.auth.FirebaseAuth$zzb
            r2.<init>()
            com.google.android.gms.tasks.Task r4 = r0.zza(r1, r4, r5, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.zza(com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserProfileChangeRequest):com.google.android.gms.tasks.Task");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah]
      assigns: [com.google.firebase.auth.FirebaseAuth$zzb]
      uses: [com.google.firebase.auth.internal.zzah]
      mth insns count: 7
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<java.lang.Void> zzb(@android.support.annotation.NonNull com.google.firebase.auth.FirebaseUser r4, @android.support.annotation.NonNull java.lang.String r5) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.firebase.auth.api.internal.zzao r0 = r3.zzgq
            com.google.firebase.FirebaseApp r1 = r3.zzgm
            com.google.firebase.auth.FirebaseAuth$zzb r2 = new com.google.firebase.auth.FirebaseAuth$zzb
            r2.<init>()
            com.google.android.gms.tasks.Task r4 = r0.zzb(r1, r4, r5, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.zzb(com.google.firebase.auth.FirebaseUser, java.lang.String):com.google.android.gms.tasks.Task");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah]
      assigns: [com.google.firebase.auth.FirebaseAuth$zzb]
      uses: [com.google.firebase.auth.internal.zzah]
      mth insns count: 7
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<java.lang.Void> zza(@android.support.annotation.NonNull com.google.firebase.auth.FirebaseUser r4, @android.support.annotation.NonNull com.google.firebase.auth.PhoneAuthCredential r5) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            com.google.firebase.auth.api.internal.zzao r0 = r3.zzgq
            com.google.firebase.FirebaseApp r1 = r3.zzgm
            com.google.firebase.auth.FirebaseAuth$zzb r2 = new com.google.firebase.auth.FirebaseAuth$zzb
            r2.<init>()
            com.google.android.gms.tasks.Task r4 = r0.zza(r1, r4, r5, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.zza(com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.PhoneAuthCredential):com.google.android.gms.tasks.Task");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah]
      assigns: [com.google.firebase.auth.FirebaseAuth$zzb]
      uses: [com.google.firebase.auth.internal.zzah]
      mth insns count: 7
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.tasks.Task<java.lang.Void> zzc(@android.support.annotation.NonNull com.google.firebase.auth.FirebaseUser r4, @android.support.annotation.NonNull java.lang.String r5) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.firebase.auth.api.internal.zzao r0 = r3.zzgq
            com.google.firebase.FirebaseApp r1 = r3.zzgm
            com.google.firebase.auth.FirebaseAuth$zzb r2 = new com.google.firebase.auth.FirebaseAuth$zzb
            r2.<init>()
            com.google.android.gms.tasks.Task r4 = r0.zzc(r1, r4, r5, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.FirebaseAuth.zzc(com.google.firebase.auth.FirebaseUser, java.lang.String):com.google.android.gms.tasks.Task");
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return sendPasswordResetEmail(str, null);
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str, @Nullable ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzbs();
        }
        String str2 = this.zzgu;
        if (str2 != null) {
            actionCodeSettings.zzbm(str2);
        }
        actionCodeSettings.zza(zzjn.PASSWORD_RESET);
        return this.zzgq.zza(this.zzgm, str, actionCodeSettings, this.zzgw);
    }

    public Task<Void> sendSignInLinkToEmail(@NonNull String str, @NonNull ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(actionCodeSettings);
        if (actionCodeSettings.canHandleCodeInApp()) {
            String str2 = this.zzgu;
            if (str2 != null) {
                actionCodeSettings.zzbm(str2);
            }
            return this.zzgq.zzb(this.zzgm, str, actionCodeSettings, this.zzgw);
        }
        throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
    }

    public boolean isSignInWithEmailLink(@NonNull String str) {
        return EmailAuthCredential.isSignInWithEmailLink(str);
    }

    @NonNull
    public final Task<Void> zza(@Nullable ActionCodeSettings actionCodeSettings, @NonNull String str) {
        Preconditions.checkNotEmpty(str);
        if (this.zzgu != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zzbs();
            }
            actionCodeSettings.zzbm(this.zzgu);
        }
        return this.zzgq.zza(this.zzgm, actionCodeSettings, str);
    }

    @NonNull
    public Task<ActionCodeResult> checkActionCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zzc(this.zzgm, str, this.zzgw);
    }

    @NonNull
    public Task<Void> applyActionCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zzd(this.zzgm, str, this.zzgw);
    }

    @NonNull
    public Task<String> verifyPasswordResetCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zze(this.zzgm, str, this.zzgw);
    }

    @NonNull
    public Task<Void> confirmPasswordReset(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzgq.zza(this.zzgm, str, str2, this.zzgw);
    }

    @NonNull
    public final Task<Void> zze(@NonNull FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zzgq.zza(firebaseUser, (zzv) new zzo(this, firebaseUser));
    }

    public void signOut() {
        zzca();
        zzae zzae = this.zzgz;
        if (zzae != null) {
            zzae.cancel();
        }
    }

    public void setLanguageCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzgt) {
            this.zzgu = str;
        }
    }

    @Nullable
    public String getLanguageCode() {
        String str;
        synchronized (this.zzgt) {
            str = this.zzgu;
        }
        return str;
    }

    public final void zzc(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzgv) {
            this.zzgw = str;
        }
    }

    public void useAppLanguage() {
        synchronized (this.zzgt) {
            this.zzgu = zzem.zzdo();
        }
    }

    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzgs;
    }

    public Task<Void> setFirebaseUIVersion(@Nullable String str) {
        return this.zzgq.setFirebaseUIVersion(str);
    }
}
