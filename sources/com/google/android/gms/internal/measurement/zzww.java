package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzvm.zzc;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

final class zzww {
    static String zza(zzwt zzwt, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zza(zzwt, sb, 0);
        return sb.toString();
    }

    private static void zza(zzwt zzwt, StringBuilder sb, int i) {
        String str;
        zzwt zzwt2 = zzwt;
        StringBuilder sb2 = sb;
        int i2 = i;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        Method[] declaredMethods = zzwt.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            str = "get";
            if (i3 >= length) {
                break;
            }
            Method method = declaredMethods[i3];
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith(str)) {
                    treeSet.add(method.getName());
                }
            }
            i3++;
        }
        for (String str2 : treeSet) {
            String str3 = "";
            String replaceFirst = str2.replaceFirst(str, str3);
            String str4 = "List";
            boolean z = true;
            if (replaceFirst.endsWith(str4) && !replaceFirst.endsWith("OrBuilderList") && !replaceFirst.equals(str4)) {
                String valueOf = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str2);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb2, i2, zzga(concat), zzvm.zza(method2, (Object) zzwt2, new Object[0]));
                }
            }
            String str5 = "Map";
            if (replaceFirst.endsWith(str5) && !replaceFirst.equals(str5)) {
                String valueOf3 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb2, i2, zzga(concat2), zzvm.zza(method3, (Object) zzwt2, new Object[0]));
                }
            }
            String str6 = "set";
            String valueOf5 = String.valueOf(replaceFirst);
            if (((Method) hashMap2.get(valueOf5.length() != 0 ? str6.concat(valueOf5) : new String(str6))) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    String valueOf6 = String.valueOf(replaceFirst.substring(0, replaceFirst.length() - 5));
                    if (hashMap.containsKey(valueOf6.length() != 0 ? str.concat(valueOf6) : new String(str))) {
                    }
                }
                String valueOf7 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                String valueOf8 = String.valueOf(replaceFirst.substring(1));
                String concat3 = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
                String valueOf9 = String.valueOf(replaceFirst);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? str.concat(valueOf9) : new String(str));
                String str7 = "has";
                String valueOf10 = String.valueOf(replaceFirst);
                Method method5 = (Method) hashMap.get(valueOf10.length() != 0 ? str7.concat(valueOf10) : new String(str7));
                if (method4 != null) {
                    Object zza = zzvm.zza(method4, (Object) zzwt2, new Object[0]);
                    if (method5 == null) {
                        boolean z2 = zza instanceof Boolean ? !((Boolean) zza).booleanValue() : zza instanceof Integer ? ((Integer) zza).intValue() == 0 : zza instanceof Float ? ((Float) zza).floatValue() == 0.0f : zza instanceof Double ? ((Double) zza).doubleValue() == 0.0d : zza instanceof String ? zza.equals(str3) : zza instanceof zzud ? zza.equals(zzud.zzbtz) : zza instanceof zzwt ? zza == ((zzwt) zza).zzwf() : zza instanceof Enum ? ((Enum) zza).ordinal() == 0 : false;
                        if (z2) {
                            z = false;
                        }
                    } else {
                        z = ((Boolean) zzvm.zza(method5, (Object) zzwt2, new Object[0])).booleanValue();
                    }
                    if (z) {
                        zzb(sb2, i2, zzga(concat3), zza);
                    }
                }
            }
        }
        if (zzwt2 instanceof zzc) {
            Iterator it = ((zzc) zzwt2).zzbys.iterator();
            if (it.hasNext()) {
                ((Entry) it.next()).getKey();
                throw new NoSuchMethodError();
            }
        }
        zzvm zzvm = (zzvm) zzwt2;
        if (zzvm.zzbym != null) {
            zzvm.zzbym.zzb(sb2, i2);
        }
    }

    static final void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb, i, str, zzb2);
            }
        } else {
            sb.append(10);
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            String str2 = ": \"";
            if (obj instanceof String) {
                sb.append(str2);
                sb.append(zzxx.zzd(zzud.zzfv((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzud) {
                sb.append(str2);
                sb.append(zzxx.zzd((zzud) obj));
                sb.append('\"');
            } else {
                String str3 = "}";
                String str4 = "\n";
                String str5 = " {";
                if (obj instanceof zzvm) {
                    sb.append(str5);
                    zza((zzvm) obj, sb, i + 2);
                    sb.append(str4);
                    while (i2 < i) {
                        sb.append(' ');
                        i2++;
                    }
                    sb.append(str3);
                } else if (obj instanceof Entry) {
                    sb.append(str5);
                    Entry entry = (Entry) obj;
                    int i4 = i + 2;
                    zzb(sb, i4, "key", entry.getKey());
                    zzb(sb, i4, Param.VALUE, entry.getValue());
                    sb.append(str4);
                    while (i2 < i) {
                        sb.append(' ');
                        i2++;
                    }
                    sb.append(str3);
                } else {
                    sb.append(": ");
                    sb.append(obj.toString());
                }
            }
        }
    }

    private static final String zzga(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
