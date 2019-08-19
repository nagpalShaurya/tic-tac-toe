package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import java.util.Arrays;
import java.util.List;

public final class zzq {
    @NonNull
    public static Status zzct(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return new Status(FirebaseError.ERROR_INTERNAL_ERROR);
        }
        String[] split = str.split(":", 2);
        split[0] = split[0].trim();
        if (split.length > 1 && split[1] != null) {
            split[1] = split[1].trim();
        }
        List asList = Arrays.asList(split);
        if (asList.size() > 1) {
            return zzc((String) asList.get(0), (String) asList.get(1));
        }
        return zzc((String) asList.get(0), null);
    }

    @android.support.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.common.api.Status zzc(@android.support.annotation.NonNull java.lang.String r4, @android.support.annotation.Nullable java.lang.String r5) {
        /*
            int r0 = r4.hashCode()
            r1 = 1
            switch(r0) {
                case -2065866930: goto L_0x0247;
                case -2014808264: goto L_0x023c;
                case -2001169389: goto L_0x0232;
                case -1944433728: goto L_0x0227;
                case -1800638118: goto L_0x021c;
                case -1774756919: goto L_0x0211;
                case -1587614300: goto L_0x0206;
                case -1583894766: goto L_0x01fb;
                case -1458751677: goto L_0x01f0;
                case -1421414571: goto L_0x01e4;
                case -1345867105: goto L_0x01d8;
                case -1232010689: goto L_0x01cc;
                case -1112393964: goto L_0x01c1;
                case -863830559: goto L_0x01b5;
                case -828507413: goto L_0x01aa;
                case -736207500: goto L_0x019e;
                case -646022241: goto L_0x0192;
                case -333672188: goto L_0x0186;
                case -294485423: goto L_0x017a;
                case -75433118: goto L_0x016e;
                case -40686718: goto L_0x0162;
                case 15352275: goto L_0x0157;
                case 269327773: goto L_0x014b;
                case 278802867: goto L_0x013f;
                case 408411681: goto L_0x0133;
                case 483847807: goto L_0x0127;
                case 491979549: goto L_0x011b;
                case 492072102: goto L_0x010f;
                case 542728406: goto L_0x0103;
                case 605031096: goto L_0x00f7;
                case 786916712: goto L_0x00eb;
                case 799258561: goto L_0x00df;
                case 819646646: goto L_0x00d4;
                case 844240628: goto L_0x00c8;
                case 922685102: goto L_0x00bc;
                case 989000548: goto L_0x00b0;
                case 1072360691: goto L_0x00a5;
                case 1094975491: goto L_0x0099;
                case 1107081238: goto L_0x008d;
                case 1141576252: goto L_0x0081;
                case 1199811910: goto L_0x0075;
                case 1226505451: goto L_0x0069;
                case 1388786705: goto L_0x005e;
                case 1433767024: goto L_0x0053;
                case 1442968770: goto L_0x0047;
                case 1494923453: goto L_0x003b;
                case 1497901284: goto L_0x002f;
                case 1803454477: goto L_0x0023;
                case 1898790704: goto L_0x0017;
                case 2082564316: goto L_0x000b;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x0252
        L_0x000b:
            java.lang.String r0 = "UNSUPPORTED_TENANT_OPERATION"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 47
            goto L_0x0253
        L_0x0017:
            java.lang.String r0 = "MISSING_SESSION_INFO"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 33
            goto L_0x0253
        L_0x0023:
            java.lang.String r0 = "MISSING_CONTINUE_URI"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 42
            goto L_0x0253
        L_0x002f:
            java.lang.String r0 = "TOO_MANY_ATTEMPTS_TRY_LATER"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 19
            goto L_0x0253
        L_0x003b:
            java.lang.String r0 = "INVALID_APP_CREDENTIAL"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 17
            goto L_0x0253
        L_0x0047:
            java.lang.String r0 = "INVALID_PHONE_NUMBER"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 30
            goto L_0x0253
        L_0x0053:
            java.lang.String r0 = "USER_DISABLED"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 4
            goto L_0x0253
        L_0x005e:
            java.lang.String r0 = "INVALID_IDENTIFIER"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 5
            goto L_0x0253
        L_0x0069:
            java.lang.String r0 = "FEDERATED_USER_ID_ALREADY_LINKED"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 11
            goto L_0x0253
        L_0x0075:
            java.lang.String r0 = "MISSING_CODE"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 31
            goto L_0x0253
        L_0x0081:
            java.lang.String r0 = "SESSION_EXPIRED"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 36
            goto L_0x0253
        L_0x008d:
            java.lang.String r0 = "<<Network Error>>"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 13
            goto L_0x0253
        L_0x0099:
            java.lang.String r0 = "INVALID_PASSWORD"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 10
            goto L_0x0253
        L_0x00a5:
            java.lang.String r0 = "INVALID_CUSTOM_TOKEN"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 2
            goto L_0x0253
        L_0x00b0:
            java.lang.String r0 = "RESET_PASSWORD_EXCEED_LIMIT"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 20
            goto L_0x0253
        L_0x00bc:
            java.lang.String r0 = "INVALID_MESSAGE_PAYLOAD"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 24
            goto L_0x0253
        L_0x00c8:
            java.lang.String r0 = "WEB_CONTEXT_CANCELED"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 46
            goto L_0x0253
        L_0x00d4:
            java.lang.String r0 = "CREDENTIAL_MISMATCH"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 1
            goto L_0x0253
        L_0x00df:
            java.lang.String r0 = "INVALID_PROVIDER_ID"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 44
            goto L_0x0253
        L_0x00eb:
            java.lang.String r0 = "INVALID_VERIFICATION_PROOF"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 35
            goto L_0x0253
        L_0x00f7:
            java.lang.String r0 = "REJECTED_CREDENTIAL"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 49
            goto L_0x0253
        L_0x0103:
            java.lang.String r0 = "PASSWORD_LOGIN_DISABLED"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 16
            goto L_0x0253
        L_0x010f:
            java.lang.String r0 = "WEB_STORAGE_UNSUPPORTED"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 41
            goto L_0x0253
        L_0x011b:
            java.lang.String r0 = "INVALID_ID_TOKEN"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 12
            goto L_0x0253
        L_0x0127:
            java.lang.String r0 = "EMAIL_EXISTS"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 9
            goto L_0x0253
        L_0x0133:
            java.lang.String r0 = "INVALID_DYNAMIC_LINK_DOMAIN"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 48
            goto L_0x0253
        L_0x013f:
            java.lang.String r0 = "MISSING_PHONE_NUMBER"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 29
            goto L_0x0253
        L_0x014b:
            java.lang.String r0 = "INVALID_SENDER"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 25
            goto L_0x0253
        L_0x0157:
            java.lang.String r0 = "EMAIL_NOT_FOUND"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 7
            goto L_0x0253
        L_0x0162:
            java.lang.String r0 = "WEAK_PASSWORD"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 14
            goto L_0x0253
        L_0x016e:
            java.lang.String r0 = "USER_NOT_FOUND"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 8
            goto L_0x0253
        L_0x017a:
            java.lang.String r0 = "WEB_INTERNAL_ERROR"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 40
            goto L_0x0253
        L_0x0186:
            java.lang.String r0 = "OPERATION_NOT_ALLOWED"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 15
            goto L_0x0253
        L_0x0192:
            java.lang.String r0 = "CREDENTIAL_TOO_OLD_LOGIN_AGAIN"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 18
            goto L_0x0253
        L_0x019e:
            java.lang.String r0 = "MISSING_PASSWORD"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 28
            goto L_0x0253
        L_0x01aa:
            java.lang.String r0 = "NO_SUCH_PROVIDER"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 0
            goto L_0x0253
        L_0x01b5:
            java.lang.String r0 = "INVALID_CERT_HASH"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 38
            goto L_0x0253
        L_0x01c1:
            java.lang.String r0 = "INVALID_EMAIL"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 6
            goto L_0x0253
        L_0x01cc:
            java.lang.String r0 = "INVALID_SESSION_INFO"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 34
            goto L_0x0253
        L_0x01d8:
            java.lang.String r0 = "TOKEN_EXPIRED"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 21
            goto L_0x0253
        L_0x01e4:
            java.lang.String r0 = "INVALID_CODE"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 32
            goto L_0x0253
        L_0x01f0:
            java.lang.String r0 = "MISSING_EMAIL"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 27
            goto L_0x0253
        L_0x01fb:
            java.lang.String r0 = "INVALID_OOB_CODE"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 22
            goto L_0x0253
        L_0x0206:
            java.lang.String r0 = "EXPIRED_OOB_CODE"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 23
            goto L_0x0253
        L_0x0211:
            java.lang.String r0 = "WEB_NETWORK_REQUEST_FAILED"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 39
            goto L_0x0253
        L_0x021c:
            java.lang.String r0 = "QUOTA_EXCEEDED"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 37
            goto L_0x0253
        L_0x0227:
            java.lang.String r0 = "DYNAMIC_LINK_NOT_ACTIVATED"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 43
            goto L_0x0253
        L_0x0232:
            java.lang.String r0 = "INVALID_IDP_RESPONSE"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 3
            goto L_0x0253
        L_0x023c:
            java.lang.String r0 = "WEB_CONTEXT_ALREADY_PRESENTED"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 45
            goto L_0x0253
        L_0x0247:
            java.lang.String r0 = "INVALID_RECIPIENT_EMAIL"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 26
            goto L_0x0253
        L_0x0252:
            r0 = -1
        L_0x0253:
            r2 = 17499(0x445b, float:2.4521E-41)
            switch(r0) {
                case 0: goto L_0x02f7;
                case 1: goto L_0x02f4;
                case 2: goto L_0x02f1;
                case 3: goto L_0x02ee;
                case 4: goto L_0x02eb;
                case 5: goto L_0x02e8;
                case 6: goto L_0x02e8;
                case 7: goto L_0x02e5;
                case 8: goto L_0x02e5;
                case 9: goto L_0x02e2;
                case 10: goto L_0x02df;
                case 11: goto L_0x02dc;
                case 12: goto L_0x02d9;
                case 13: goto L_0x02d6;
                case 14: goto L_0x02d3;
                case 15: goto L_0x02d0;
                case 16: goto L_0x02d0;
                case 17: goto L_0x02cd;
                case 18: goto L_0x02ca;
                case 19: goto L_0x02c7;
                case 20: goto L_0x02c7;
                case 21: goto L_0x02c4;
                case 22: goto L_0x02c1;
                case 23: goto L_0x02be;
                case 24: goto L_0x02bb;
                case 25: goto L_0x02b8;
                case 26: goto L_0x02b5;
                case 27: goto L_0x02b2;
                case 28: goto L_0x02af;
                case 29: goto L_0x02ac;
                case 30: goto L_0x02a8;
                case 31: goto L_0x02a4;
                case 32: goto L_0x02a0;
                case 33: goto L_0x029c;
                case 34: goto L_0x0298;
                case 35: goto L_0x0294;
                case 36: goto L_0x0290;
                case 37: goto L_0x028c;
                case 38: goto L_0x0288;
                case 39: goto L_0x0284;
                case 40: goto L_0x0280;
                case 41: goto L_0x027c;
                case 42: goto L_0x0278;
                case 43: goto L_0x0274;
                case 44: goto L_0x0270;
                case 45: goto L_0x026c;
                case 46: goto L_0x0268;
                case 47: goto L_0x0264;
                case 48: goto L_0x0260;
                case 49: goto L_0x025c;
                default: goto L_0x0258;
            }
        L_0x0258:
            r0 = 17499(0x445b, float:2.4521E-41)
            goto L_0x02f9
        L_0x025c:
            r0 = 17075(0x42b3, float:2.3927E-41)
            goto L_0x02f9
        L_0x0260:
            r0 = 17074(0x42b2, float:2.3926E-41)
            goto L_0x02f9
        L_0x0264:
            r0 = 17073(0x42b1, float:2.3924E-41)
            goto L_0x02f9
        L_0x0268:
            r0 = 17058(0x42a2, float:2.3903E-41)
            goto L_0x02f9
        L_0x026c:
            r0 = 17057(0x42a1, float:2.3902E-41)
            goto L_0x02f9
        L_0x0270:
            r0 = 17071(0x42af, float:2.3922E-41)
            goto L_0x02f9
        L_0x0274:
            r0 = 17068(0x42ac, float:2.3917E-41)
            goto L_0x02f9
        L_0x0278:
            r0 = 17040(0x4290, float:2.3878E-41)
            goto L_0x02f9
        L_0x027c:
            r0 = 17065(0x42a9, float:2.3913E-41)
            goto L_0x02f9
        L_0x0280:
            r0 = 17062(0x42a6, float:2.3909E-41)
            goto L_0x02f9
        L_0x0284:
            r0 = 17061(0x42a5, float:2.3908E-41)
            goto L_0x02f9
        L_0x0288:
            r0 = 17064(0x42a8, float:2.3912E-41)
            goto L_0x02f9
        L_0x028c:
            r0 = 17052(0x429c, float:2.3895E-41)
            goto L_0x02f9
        L_0x0290:
            r0 = 17051(0x429b, float:2.3894E-41)
            goto L_0x02f9
        L_0x0294:
            r0 = 17049(0x4299, float:2.3891E-41)
            goto L_0x02f9
        L_0x0298:
            r0 = 17046(0x4296, float:2.3887E-41)
            goto L_0x02f9
        L_0x029c:
            r0 = 17045(0x4295, float:2.3885E-41)
            goto L_0x02f9
        L_0x02a0:
            r0 = 17044(0x4294, float:2.3884E-41)
            goto L_0x02f9
        L_0x02a4:
            r0 = 17043(0x4293, float:2.3882E-41)
            goto L_0x02f9
        L_0x02a8:
            r0 = 17042(0x4292, float:2.3881E-41)
            goto L_0x02f9
        L_0x02ac:
            r0 = 17041(0x4291, float:2.388E-41)
            goto L_0x02f9
        L_0x02af:
            r0 = 17035(0x428b, float:2.3871E-41)
            goto L_0x02f9
        L_0x02b2:
            r0 = 17034(0x428a, float:2.387E-41)
            goto L_0x02f9
        L_0x02b5:
            r0 = 17033(0x4289, float:2.3868E-41)
            goto L_0x02f9
        L_0x02b8:
            r0 = 17032(0x4288, float:2.3867E-41)
            goto L_0x02f9
        L_0x02bb:
            r0 = 17031(0x4287, float:2.3866E-41)
            goto L_0x02f9
        L_0x02be:
            r0 = 17029(0x4285, float:2.3863E-41)
            goto L_0x02f9
        L_0x02c1:
            r0 = 17030(0x4286, float:2.3864E-41)
            goto L_0x02f9
        L_0x02c4:
            r0 = 17021(0x427d, float:2.3852E-41)
            goto L_0x02f9
        L_0x02c7:
            r0 = 17010(0x4272, float:2.3836E-41)
            goto L_0x02f9
        L_0x02ca:
            r0 = 17014(0x4276, float:2.3842E-41)
            goto L_0x02f9
        L_0x02cd:
            r0 = 17028(0x4284, float:2.3861E-41)
            goto L_0x02f9
        L_0x02d0:
            r0 = 17006(0x426e, float:2.383E-41)
            goto L_0x02f9
        L_0x02d3:
            r0 = 17026(0x4282, float:2.3859E-41)
            goto L_0x02f9
        L_0x02d6:
            r0 = 17020(0x427c, float:2.385E-41)
            goto L_0x02f9
        L_0x02d9:
            r0 = 17017(0x4279, float:2.3846E-41)
            goto L_0x02f9
        L_0x02dc:
            r0 = 17025(0x4281, float:2.3857E-41)
            goto L_0x02f9
        L_0x02df:
            r0 = 17009(0x4271, float:2.3835E-41)
            goto L_0x02f9
        L_0x02e2:
            r0 = 17007(0x426f, float:2.3832E-41)
            goto L_0x02f9
        L_0x02e5:
            r0 = 17011(0x4273, float:2.3837E-41)
            goto L_0x02f9
        L_0x02e8:
            r0 = 17008(0x4270, float:2.3833E-41)
            goto L_0x02f9
        L_0x02eb:
            r0 = 17005(0x426d, float:2.3829E-41)
            goto L_0x02f9
        L_0x02ee:
            r0 = 17004(0x426c, float:2.3828E-41)
            goto L_0x02f9
        L_0x02f1:
            r0 = 17000(0x4268, float:2.3822E-41)
            goto L_0x02f9
        L_0x02f4:
            r0 = 17002(0x426a, float:2.3825E-41)
            goto L_0x02f9
        L_0x02f7:
            r0 = 17016(0x4278, float:2.3844E-41)
        L_0x02f9:
            if (r0 != r2) goto L_0x0330
            if (r5 == 0) goto L_0x032a
            com.google.android.gms.common.api.Status r2 = new com.google.android.gms.common.api.Status
            java.lang.String r3 = java.lang.String.valueOf(r4)
            int r3 = r3.length()
            int r3 = r3 + r1
            java.lang.String r1 = java.lang.String.valueOf(r5)
            int r1 = r1.length()
            int r3 = r3 + r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            r1.append(r4)
            java.lang.String r4 = ":"
            r1.append(r4)
            r1.append(r5)
            java.lang.String r4 = r1.toString()
            r2.<init>(r0, r4)
            return r2
        L_0x032a:
            com.google.android.gms.common.api.Status r5 = new com.google.android.gms.common.api.Status
            r5.<init>(r0, r4)
            return r5
        L_0x0330:
            com.google.android.gms.common.api.Status r4 = new com.google.android.gms.common.api.Status
            r4.<init>(r0, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzq.zzc(java.lang.String, java.lang.String):com.google.android.gms.common.api.Status");
    }
}
