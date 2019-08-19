package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj.zzl;
import com.google.android.gms.internal.firebase_auth.zzj.zzl.zza;
import com.google.firebase.auth.api.internal.zzff;
import java.util.Arrays;
import java.util.List;

public final class zzdl implements zzff<zzl> {
    private String zzgc;
    private String zzgh;
    private String zzgi;
    @Nullable
    private String zzgw;
    private String zzhw;
    private String zzhx;
    private zzdp zzpr = new zzdp();
    private zzdp zzps = new zzdp();
    private boolean zzpt = true;
    private String zzpu;

    public final boolean zzch(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzps.zzeb().contains(str);
    }

    @Nullable
    public final String getEmail() {
        return this.zzgh;
    }

    @Nullable
    public final String getPassword() {
        return this.zzgi;
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzhw;
    }

    @Nullable
    public final String zzal() {
        return this.zzhx;
    }

    @NonNull
    public final zzdl zzci(@NonNull String str) {
        this.zzgc = Preconditions.checkNotEmpty(str);
        return this;
    }

    @NonNull
    public final zzdl zzcj(@Nullable String str) {
        if (str == null) {
            this.zzps.zzeb().add("EMAIL");
        } else {
            this.zzgh = str;
        }
        return this;
    }

    @NonNull
    public final zzdl zzck(@Nullable String str) {
        if (str == null) {
            this.zzps.zzeb().add("PASSWORD");
        } else {
            this.zzgi = str;
        }
        return this;
    }

    @NonNull
    public final zzdl zzcl(@Nullable String str) {
        if (str == null) {
            this.zzps.zzeb().add("DISPLAY_NAME");
        } else {
            this.zzhw = str;
        }
        return this;
    }

    @NonNull
    public final zzdl zzcm(@Nullable String str) {
        if (str == null) {
            this.zzps.zzeb().add("PHOTO_URL");
        } else {
            this.zzhx = str;
        }
        return this;
    }

    @NonNull
    public final zzdl zzcn(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        this.zzpr.zzeb().add(str);
        return this;
    }

    @NonNull
    public final zzdl zzco(@NonNull String str) {
        this.zzpu = Preconditions.checkNotEmpty(str);
        return this;
    }

    @NonNull
    public final zzdl zzcp(@Nullable String str) {
        this.zzgw = str;
        return this;
    }

    public final /* synthetic */ zzhb zzds() {
        zzo zzo;
        zza zzd = zzl.zzai().zzf(this.zzpt).zzd(this.zzpr.zzeb());
        List zzeb = this.zzps.zzeb();
        zzo[] zzoArr = new zzo[zzeb.size()];
        for (int i = 0; i < zzeb.size(); i++) {
            String str = (String) zzeb.get(i);
            char c = 65535;
            switch (str.hashCode()) {
                case -333046776:
                    if (str.equals("DISPLAY_NAME")) {
                        c = 1;
                        break;
                    }
                    break;
                case 66081660:
                    if (str.equals("EMAIL")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1939891618:
                    if (str.equals("PHOTO_URL")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1999612571:
                    if (str.equals("PASSWORD")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                zzo = zzo.EMAIL;
            } else if (c == 1) {
                zzo = zzo.DISPLAY_NAME;
            } else if (c == 2) {
                zzo = zzo.PASSWORD;
            } else if (c != 3) {
                zzo = zzo.USER_ATTRIBUTE_NAME_UNSPECIFIED;
            } else {
                zzo = zzo.PHOTO_URL;
            }
            zzoArr[i] = zzo;
        }
        zza zzc = zzd.zzc(Arrays.asList(zzoArr));
        String str2 = this.zzgc;
        if (str2 != null) {
            zzc.zzan(str2);
        }
        String str3 = this.zzgh;
        if (str3 != null) {
            zzc.zzap(str3);
        }
        String str4 = this.zzgi;
        if (str4 != null) {
            zzc.zzaq(str4);
        }
        String str5 = this.zzhw;
        if (str5 != null) {
            zzc.zzao(str5);
        }
        String str6 = this.zzhx;
        if (str6 != null) {
            zzc.zzas(str6);
        }
        String str7 = this.zzpu;
        if (str7 != null) {
            zzc.zzar(str7);
        }
        String str8 = this.zzgw;
        if (str8 != null) {
            zzc.zzat(str8);
        }
        return (zzl) ((zzfs) zzc.zzhm());
    }
}
