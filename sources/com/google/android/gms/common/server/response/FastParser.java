package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.util.Base64Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

@ShowFirstParty
@KeepForSdk
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaqf = {'u', 'l', 'l'};
    private static final char[] zaqg = {'r', 'u', 'e'};
    private static final char[] zaqh = {'r', 'u', 'e', '\"'};
    private static final char[] zaqi = {'a', 'l', 's', 'e'};
    private static final char[] zaqj = {'a', 'l', 's', 'e', '\"'};
    private static final char[] zaqk = {10};
    private static final zaa<Integer> zaqm = new zaa();
    private static final zaa<Long> zaqn = new zab();
    private static final zaa<Float> zaqo = new zac();
    private static final zaa<Double> zaqp = new zad();
    private static final zaa<Boolean> zaqq = new zae();
    private static final zaa<String> zaqr = new zaf();
    private static final zaa<BigInteger> zaqs = new zag();
    private static final zaa<BigDecimal> zaqt = new zah();
    private final char[] zaqa = new char[1];
    private final char[] zaqb = new char[32];
    private final char[] zaqc = new char[1024];
    private final StringBuilder zaqd = new StringBuilder(32);
    private final StringBuilder zaqe = new StringBuilder(1024);
    private final Stack<Integer> zaql = new Stack<>();

    @ShowFirstParty
    @KeepForSdk
    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super(str, th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    private interface zaa<O> {
        O zah(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException;
    }

    @KeepForSdk
    public void parse(InputStream inputStream, T t) throws ParseException {
        String str = "Failed to close reader while parsing.";
        String str2 = "FastParser";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            this.zaql.push(Integer.valueOf(0));
            char zaj = zaj(bufferedReader);
            if (zaj != 0) {
                if (zaj == '[') {
                    this.zaql.push(Integer.valueOf(5));
                    Map fieldMappings = t.getFieldMappings();
                    if (fieldMappings.size() == 1) {
                        Field field = (Field) ((Entry) fieldMappings.entrySet().iterator().next()).getValue();
                        t.addConcreteTypeArrayInternal(field, field.zapu, zaa(bufferedReader, field));
                    } else {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                } else if (zaj == '{') {
                    this.zaql.push(Integer.valueOf(1));
                    zaa(bufferedReader, (FastJsonResponse) t);
                } else {
                    StringBuilder sb = new StringBuilder(19);
                    sb.append("Unexpected token: ");
                    sb.append(zaj);
                    throw new ParseException(sb.toString());
                }
                zak(0);
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    Log.w(str2, str);
                }
            } else {
                throw new ParseException("No data to parse");
            }
        } catch (IOException e2) {
            throw new ParseException((Throwable) e2);
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                Log.w(str2, str);
            }
            throw th;
        }
    }

    private final boolean zaa(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        HashMap hashMap;
        BufferedReader bufferedReader2 = bufferedReader;
        FastJsonResponse fastJsonResponse2 = fastJsonResponse;
        String str = "Error instantiating inner object";
        Map fieldMappings = fastJsonResponse.getFieldMappings();
        String zaa2 = zaa(bufferedReader);
        Integer valueOf = Integer.valueOf(1);
        if (zaa2 == null) {
            zak(1);
            return false;
        }
        while (zaa2 != null) {
            Field field = (Field) fieldMappings.get(zaa2);
            if (field == null) {
                zaa2 = zab(bufferedReader);
            } else {
                this.zaql.push(Integer.valueOf(4));
                switch (field.zapq) {
                    case 0:
                        if (!field.zapr) {
                            fastJsonResponse2.zaa(field, zad(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse2.zaa(field, zaa(bufferedReader2, zaqm));
                            break;
                        }
                    case 1:
                        if (!field.zapr) {
                            fastJsonResponse2.zaa(field, zaf(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse2.zab(field, zaa(bufferedReader2, zaqs));
                            break;
                        }
                    case 2:
                        if (!field.zapr) {
                            fastJsonResponse2.zaa(field, zae(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse2.zac(field, zaa(bufferedReader2, zaqn));
                            break;
                        }
                    case 3:
                        if (!field.zapr) {
                            fastJsonResponse2.zaa(field, zag(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse2.zad(field, zaa(bufferedReader2, zaqo));
                            break;
                        }
                    case 4:
                        if (!field.zapr) {
                            fastJsonResponse2.zaa(field, zah(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse2.zae(field, zaa(bufferedReader2, zaqp));
                            break;
                        }
                    case 5:
                        if (!field.zapr) {
                            fastJsonResponse2.zaa(field, zai(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse2.zaf(field, zaa(bufferedReader2, zaqt));
                            break;
                        }
                    case 6:
                        if (!field.zapr) {
                            fastJsonResponse2.zaa(field, zaa(bufferedReader2, false));
                            break;
                        } else {
                            fastJsonResponse2.zag(field, zaa(bufferedReader2, zaqq));
                            break;
                        }
                    case 7:
                        if (!field.zapr) {
                            fastJsonResponse2.zaa(field, zac(bufferedReader));
                            break;
                        } else {
                            fastJsonResponse2.zah(field, zaa(bufferedReader2, zaqr));
                            break;
                        }
                    case 8:
                        fastJsonResponse2.zaa(field, Base64Utils.decode(zaa(bufferedReader2, this.zaqc, this.zaqe, zaqk)));
                        break;
                    case 9:
                        fastJsonResponse2.zaa(field, Base64Utils.decodeUrlSafe(zaa(bufferedReader2, this.zaqc, this.zaqe, zaqk)));
                        break;
                    case 10:
                        char zaj = zaj(bufferedReader);
                        if (zaj == 'n') {
                            zab(bufferedReader2, zaqf);
                            hashMap = null;
                        } else if (zaj == '{') {
                            this.zaql.push(valueOf);
                            hashMap = new HashMap();
                            while (true) {
                                char zaj2 = zaj(bufferedReader);
                                if (zaj2 == 0) {
                                    throw new ParseException("Unexpected EOF");
                                } else if (zaj2 == '\"') {
                                    String zab = zab(bufferedReader2, this.zaqb, this.zaqd, null);
                                    if (zaj(bufferedReader) != ':') {
                                        String str2 = "No map value found for key ";
                                        String valueOf2 = String.valueOf(zab);
                                        throw new ParseException(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
                                    } else if (zaj(bufferedReader) != '\"') {
                                        String str3 = "Expected String value for key ";
                                        String valueOf3 = String.valueOf(zab);
                                        throw new ParseException(valueOf3.length() != 0 ? str3.concat(valueOf3) : new String(str3));
                                    } else {
                                        hashMap.put(zab, zab(bufferedReader2, this.zaqb, this.zaqd, null));
                                        char zaj3 = zaj(bufferedReader);
                                        if (zaj3 != ',') {
                                            if (zaj3 == '}') {
                                                zak(1);
                                            } else {
                                                StringBuilder sb = new StringBuilder(48);
                                                sb.append("Unexpected character while parsing string map: ");
                                                sb.append(zaj3);
                                                throw new ParseException(sb.toString());
                                            }
                                        }
                                    }
                                } else if (zaj2 == '}') {
                                    zak(1);
                                }
                            }
                        } else {
                            throw new ParseException("Expected start of a map object");
                        }
                        fastJsonResponse2.zaa(field, (Map<String, String>) hashMap);
                        break;
                    case 11:
                        if (field.zapr) {
                            char zaj4 = zaj(bufferedReader);
                            if (zaj4 == 'n') {
                                zab(bufferedReader2, zaqf);
                                fastJsonResponse2.addConcreteTypeArrayInternal(field, field.zapu, null);
                                break;
                            } else {
                                this.zaql.push(Integer.valueOf(5));
                                if (zaj4 == '[') {
                                    fastJsonResponse2.addConcreteTypeArrayInternal(field, field.zapu, zaa(bufferedReader2, field));
                                    break;
                                } else {
                                    throw new ParseException("Expected array start");
                                }
                            }
                        } else {
                            char zaj5 = zaj(bufferedReader);
                            if (zaj5 == 'n') {
                                zab(bufferedReader2, zaqf);
                                fastJsonResponse2.addConcreteTypeInternal(field, field.zapu, null);
                                break;
                            } else {
                                this.zaql.push(valueOf);
                                if (zaj5 == '{') {
                                    try {
                                        FastJsonResponse zacp = field.zacp();
                                        zaa(bufferedReader2, zacp);
                                        fastJsonResponse2.addConcreteTypeInternal(field, field.zapu, zacp);
                                        break;
                                    } catch (InstantiationException e) {
                                        throw new ParseException(str, e);
                                    } catch (IllegalAccessException e2) {
                                        throw new ParseException(str, e2);
                                    }
                                } else {
                                    throw new ParseException("Expected start of object");
                                }
                            }
                        }
                    default:
                        int i = field.zapq;
                        StringBuilder sb2 = new StringBuilder(30);
                        sb2.append("Invalid field type ");
                        sb2.append(i);
                        throw new ParseException(sb2.toString());
                }
                zak(4);
                zak(2);
                char zaj6 = zaj(bufferedReader);
                if (zaj6 == ',') {
                    zaa2 = zaa(bufferedReader);
                } else if (zaj6 == '}') {
                    zaa2 = null;
                } else {
                    StringBuilder sb3 = new StringBuilder(55);
                    sb3.append("Expected end of object or field separator, but found: ");
                    sb3.append(zaj6);
                    throw new ParseException(sb3.toString());
                }
            }
        }
        zak(1);
        return true;
    }

    private final String zaa(BufferedReader bufferedReader) throws ParseException, IOException {
        this.zaql.push(Integer.valueOf(2));
        char zaj = zaj(bufferedReader);
        if (zaj == '\"') {
            this.zaql.push(Integer.valueOf(3));
            String zab = zab(bufferedReader, this.zaqb, this.zaqd, null);
            zak(3);
            if (zaj(bufferedReader) == ':') {
                return zab;
            }
            throw new ParseException("Expected key/value separator");
        } else if (zaj == ']') {
            zak(2);
            zak(1);
            zak(5);
            return null;
        } else if (zaj == '}') {
            zak(2);
            return null;
        } else {
            StringBuilder sb = new StringBuilder(19);
            sb.append("Unexpected token: ");
            sb.append(zaj);
            throw new ParseException(sb.toString());
        }
    }

    private final String zab(BufferedReader bufferedReader) throws ParseException, IOException {
        BufferedReader bufferedReader2 = bufferedReader;
        bufferedReader2.mark(1024);
        char zaj = zaj(bufferedReader);
        String str = "Unexpected token ";
        if (zaj == '\"') {
            String str2 = "Unexpected EOF while parsing string";
            if (bufferedReader2.read(this.zaqa) != -1) {
                char c = this.zaqa[0];
                boolean z = false;
                do {
                    if (c != '\"' || z) {
                        if (c == '\\') {
                            z = !z;
                        } else {
                            z = false;
                        }
                        if (bufferedReader2.read(this.zaqa) != -1) {
                            c = this.zaqa[0];
                        } else {
                            throw new ParseException(str2);
                        }
                    }
                } while (!Character.isISOControl(c));
                throw new ParseException("Unexpected control character while reading string");
            }
            throw new ParseException(str2);
        } else if (zaj != ',') {
            int i = 1;
            if (zaj == '[') {
                this.zaql.push(Integer.valueOf(5));
                bufferedReader2.mark(32);
                if (zaj(bufferedReader) == ']') {
                    zak(5);
                } else {
                    bufferedReader.reset();
                    boolean z2 = false;
                    boolean z3 = false;
                    while (i > 0) {
                        char zaj2 = zaj(bufferedReader);
                        if (zaj2 == 0) {
                            throw new ParseException("Unexpected EOF while parsing array");
                        } else if (!Character.isISOControl(zaj2)) {
                            if (zaj2 == '\"' && !z2) {
                                z3 = !z3;
                            }
                            if (zaj2 == '[' && !z3) {
                                i++;
                            }
                            if (zaj2 == ']' && !z3) {
                                i--;
                            }
                            if (zaj2 != '\\' || !z3) {
                                z2 = false;
                            } else {
                                z2 = !z2;
                            }
                        } else {
                            throw new ParseException("Unexpected control character while reading array");
                        }
                    }
                    zak(5);
                }
            } else if (zaj != '{') {
                bufferedReader.reset();
                zaa(bufferedReader2, this.zaqc);
            } else {
                this.zaql.push(Integer.valueOf(1));
                bufferedReader2.mark(32);
                char zaj3 = zaj(bufferedReader);
                if (zaj3 == '}') {
                    zak(1);
                } else if (zaj3 == '\"') {
                    bufferedReader.reset();
                    zaa(bufferedReader);
                    do {
                    } while (zab(bufferedReader) != null);
                    zak(1);
                } else {
                    StringBuilder sb = new StringBuilder(18);
                    sb.append(str);
                    sb.append(zaj3);
                    throw new ParseException(sb.toString());
                }
            }
        } else {
            throw new ParseException("Missing value");
        }
        char zaj4 = zaj(bufferedReader);
        if (zaj4 == ',') {
            zak(2);
            return zaa(bufferedReader);
        } else if (zaj4 == '}') {
            zak(2);
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder(18);
            sb2.append(str);
            sb2.append(zaj4);
            throw new ParseException(sb2.toString());
        }
    }

    /* access modifiers changed from: private */
    public final String zac(BufferedReader bufferedReader) throws ParseException, IOException {
        return zaa(bufferedReader, this.zaqb, this.zaqd, null);
    }

    private final <O> ArrayList<O> zaa(BufferedReader bufferedReader, zaa<O> zaa2) throws ParseException, IOException {
        char zaj = zaj(bufferedReader);
        if (zaj == 'n') {
            zab(bufferedReader, zaqf);
            return null;
        } else if (zaj == '[') {
            this.zaql.push(Integer.valueOf(5));
            ArrayList<O> arrayList = new ArrayList<>();
            while (true) {
                bufferedReader.mark(1024);
                char zaj2 = zaj(bufferedReader);
                if (zaj2 == 0) {
                    throw new ParseException("Unexpected EOF");
                } else if (zaj2 != ',') {
                    if (zaj2 != ']') {
                        bufferedReader.reset();
                        arrayList.add(zaa2.zah(this, bufferedReader));
                    } else {
                        zak(5);
                        return arrayList;
                    }
                }
            }
        } else {
            throw new ParseException("Expected start of array");
        }
    }

    private final String zaa(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        char zaj = zaj(bufferedReader);
        if (zaj == '\"') {
            return zab(bufferedReader, cArr, sb, cArr2);
        }
        if (zaj == 'n') {
            zab(bufferedReader, zaqf);
            return null;
        }
        throw new ParseException("Expected string");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0034 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zab(java.io.BufferedReader r9, char[] r10, java.lang.StringBuilder r11, char[] r12) throws com.google.android.gms.common.server.response.FastParser.ParseException, java.io.IOException {
        /*
            r0 = 0
            r11.setLength(r0)
            int r1 = r10.length
            r9.mark(r1)
            r1 = 0
            r2 = 0
        L_0x000c:
            int r3 = r9.read(r10)
            r4 = -1
            if (r3 == r4) goto L_0x0074
            r4 = r2
            r2 = r1
            r1 = 0
        L_0x0016:
            if (r1 >= r3) goto L_0x006a
            char r5 = r10[r1]
            boolean r6 = java.lang.Character.isISOControl(r5)
            r7 = 1
            if (r6 == 0) goto L_0x003c
            if (r12 == 0) goto L_0x0030
            r6 = 0
        L_0x0024:
            int r8 = r12.length
            if (r6 >= r8) goto L_0x0030
            char r8 = r12[r6]
            if (r8 != r5) goto L_0x002d
            r6 = 1
            goto L_0x0031
        L_0x002d:
            int r6 = r6 + 1
            goto L_0x0024
        L_0x0030:
            r6 = 0
        L_0x0031:
            if (r6 == 0) goto L_0x0034
            goto L_0x003c
        L_0x0034:
            com.google.android.gms.common.server.response.FastParser$ParseException r9 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r10 = "Unexpected control character while reading string"
            r9.<init>(r10)
            throw r9
        L_0x003c:
            r6 = 34
            if (r5 != r6) goto L_0x005d
            if (r2 != 0) goto L_0x005d
            r11.append(r10, r0, r1)
            r9.reset()
            int r1 = r1 + r7
            long r0 = (long) r1
            r9.skip(r0)
            if (r4 == 0) goto L_0x0058
            java.lang.String r9 = r11.toString()
            java.lang.String r9 = com.google.android.gms.common.util.JsonUtils.unescapeString(r9)
            return r9
        L_0x0058:
            java.lang.String r9 = r11.toString()
            return r9
        L_0x005d:
            r6 = 92
            if (r5 != r6) goto L_0x0066
            r2 = r2 ^ 1
            r4 = 1
            goto L_0x0067
        L_0x0066:
            r2 = 0
        L_0x0067:
            int r1 = r1 + 1
            goto L_0x0016
        L_0x006a:
            r11.append(r10, r0, r3)
            int r1 = r10.length
            r9.mark(r1)
            r1 = r2
            r2 = r4
            goto L_0x000c
        L_0x0074:
            com.google.android.gms.common.server.response.FastParser$ParseException r9 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r10 = "Unexpected EOF while parsing string"
            r9.<init>(r10)
            goto L_0x007d
        L_0x007c:
            throw r9
        L_0x007d:
            goto L_0x007c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.zab(java.io.BufferedReader, char[], java.lang.StringBuilder, char[]):java.lang.String");
    }

    /* access modifiers changed from: private */
    public final int zad(BufferedReader bufferedReader) throws ParseException, IOException {
        int i;
        boolean z;
        int i2;
        int i3;
        int i4;
        int zaa2 = zaa(bufferedReader, this.zaqc);
        if (zaa2 == 0) {
            return 0;
        }
        char[] cArr = this.zaqc;
        if (zaa2 > 0) {
            if (cArr[0] == '-') {
                i2 = 1;
                z = true;
                i = Integer.MIN_VALUE;
            } else {
                i2 = 0;
                z = false;
                i = -2147483647;
            }
            String str = "Unexpected non-digit character";
            if (i2 < zaa2) {
                i4 = i2 + 1;
                int digit = Character.digit(cArr[i2], 10);
                if (digit >= 0) {
                    i3 = -digit;
                } else {
                    throw new ParseException(str);
                }
            } else {
                i4 = i2;
                i3 = 0;
            }
            while (i4 < zaa2) {
                int i5 = i4 + 1;
                int digit2 = Character.digit(cArr[i4], 10);
                if (digit2 >= 0) {
                    String str2 = "Number too large";
                    if (i3 >= -214748364) {
                        int i6 = i3 * 10;
                        if (i6 >= i + digit2) {
                            i3 = i6 - digit2;
                            i4 = i5;
                        } else {
                            throw new ParseException(str2);
                        }
                    } else {
                        throw new ParseException(str2);
                    }
                } else {
                    throw new ParseException(str);
                }
            }
            if (!z) {
                return -i3;
            }
            if (i4 > 1) {
                return i3;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    /* access modifiers changed from: private */
    public final long zae(BufferedReader bufferedReader) throws ParseException, IOException {
        boolean z;
        long j;
        long j2;
        int i;
        int zaa2 = zaa(bufferedReader, this.zaqc);
        if (zaa2 == 0) {
            return 0;
        }
        char[] cArr = this.zaqc;
        if (zaa2 > 0) {
            int i2 = 0;
            if (cArr[0] == '-') {
                j = Long.MIN_VALUE;
                i2 = 1;
                z = true;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            String str = "Unexpected non-digit character";
            if (i2 < zaa2) {
                i = i2 + 1;
                int digit = Character.digit(cArr[i2], 10);
                if (digit >= 0) {
                    j2 = (long) (-digit);
                } else {
                    throw new ParseException(str);
                }
            } else {
                j2 = 0;
                i = i2;
            }
            while (i < zaa2) {
                int i3 = i + 1;
                int digit2 = Character.digit(cArr[i], 10);
                if (digit2 >= 0) {
                    String str2 = "Number too large";
                    if (j2 >= -922337203685477580L) {
                        long j3 = j2 * 10;
                        long j4 = (long) digit2;
                        if (j3 >= j + j4) {
                            j2 = j3 - j4;
                            i = i3;
                        } else {
                            throw new ParseException(str2);
                        }
                    } else {
                        throw new ParseException(str2);
                    }
                } else {
                    throw new ParseException(str);
                }
            }
            if (!z) {
                return -j2;
            }
            if (i > 1) {
                return j2;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    /* access modifiers changed from: private */
    public final BigInteger zaf(BufferedReader bufferedReader) throws ParseException, IOException {
        int zaa2 = zaa(bufferedReader, this.zaqc);
        if (zaa2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.zaqc, 0, zaa2));
    }

    /* access modifiers changed from: private */
    public final boolean zaa(BufferedReader bufferedReader, boolean z) throws ParseException, IOException {
        while (true) {
            char zaj = zaj(bufferedReader);
            if (zaj != '\"') {
                if (zaj == 'f') {
                    zab(bufferedReader, z ? zaqj : zaqi);
                    return false;
                } else if (zaj == 'n') {
                    zab(bufferedReader, zaqf);
                    return false;
                } else if (zaj == 't') {
                    zab(bufferedReader, z ? zaqh : zaqg);
                    return true;
                } else {
                    StringBuilder sb = new StringBuilder(19);
                    sb.append("Unexpected token: ");
                    sb.append(zaj);
                    throw new ParseException(sb.toString());
                }
            } else if (!z) {
                z = true;
            } else {
                throw new ParseException("No boolean value found in string");
            }
        }
    }

    /* access modifiers changed from: private */
    public final float zag(BufferedReader bufferedReader) throws ParseException, IOException {
        int zaa2 = zaa(bufferedReader, this.zaqc);
        if (zaa2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zaqc, 0, zaa2));
    }

    /* access modifiers changed from: private */
    public final double zah(BufferedReader bufferedReader) throws ParseException, IOException {
        int zaa2 = zaa(bufferedReader, this.zaqc);
        if (zaa2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zaqc, 0, zaa2));
    }

    /* access modifiers changed from: private */
    public final BigDecimal zai(BufferedReader bufferedReader) throws ParseException, IOException {
        int zaa2 = zaa(bufferedReader, this.zaqc);
        if (zaa2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zaqc, 0, zaa2));
    }

    private final <T extends FastJsonResponse> ArrayList<T> zaa(BufferedReader bufferedReader, Field<?, ?> field) throws ParseException, IOException {
        String str = "Error instantiating inner object";
        ArrayList<T> arrayList = new ArrayList<>();
        char zaj = zaj(bufferedReader);
        if (zaj == ']') {
            zak(5);
            return arrayList;
        } else if (zaj != 'n') {
            String str2 = "Unexpected token: ";
            if (zaj == '{') {
                this.zaql.push(Integer.valueOf(1));
                while (true) {
                    try {
                        FastJsonResponse zacp = field.zacp();
                        if (!zaa(bufferedReader, zacp)) {
                            return arrayList;
                        }
                        arrayList.add(zacp);
                        char zaj2 = zaj(bufferedReader);
                        if (zaj2 != ',') {
                            if (zaj2 == ']') {
                                zak(5);
                                return arrayList;
                            }
                            StringBuilder sb = new StringBuilder(19);
                            sb.append(str2);
                            sb.append(zaj2);
                            throw new ParseException(sb.toString());
                        } else if (zaj(bufferedReader) == '{') {
                            this.zaql.push(Integer.valueOf(1));
                        } else {
                            throw new ParseException("Expected start of next object in array");
                        }
                    } catch (InstantiationException e) {
                        throw new ParseException(str, e);
                    } catch (IllegalAccessException e2) {
                        throw new ParseException(str, e2);
                    }
                }
            } else {
                StringBuilder sb2 = new StringBuilder(19);
                sb2.append(str2);
                sb2.append(zaj);
                throw new ParseException(sb2.toString());
            }
        } else {
            zab(bufferedReader, zaqf);
            zak(5);
            return null;
        }
    }

    private final char zaj(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.zaqa) == -1) {
            return 0;
        }
        while (Character.isWhitespace(this.zaqa[0])) {
            if (bufferedReader.read(this.zaqa) == -1) {
                return 0;
            }
        }
        return this.zaqa[0];
    }

    private final int zaa(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i;
        char zaj = zaj(bufferedReader);
        String str = "Unexpected EOF";
        if (zaj == 0) {
            throw new ParseException(str);
        } else if (zaj == ',') {
            throw new ParseException("Missing value");
        } else if (zaj == 'n') {
            zab(bufferedReader, zaqf);
            return 0;
        } else {
            bufferedReader.mark(1024);
            if (zaj == '\"') {
                i = 0;
                boolean z = false;
                while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                    char c = cArr[i];
                    if (Character.isISOControl(c)) {
                        throw new ParseException("Unexpected control character while reading string");
                    } else if (c != '\"' || z) {
                        if (c == '\\') {
                            z = !z;
                        } else {
                            z = false;
                        }
                        i++;
                    } else {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i + 1));
                        return i;
                    }
                }
            } else {
                cArr[0] = zaj;
                int i2 = 1;
                while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                    if (cArr[i] == '}' || cArr[i] == ',' || Character.isWhitespace(cArr[i]) || cArr[i] == ']') {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i - 1));
                        cArr[i] = 0;
                        return i;
                    }
                    i2 = i + 1;
                }
            }
            if (i == cArr.length) {
                throw new ParseException("Absurdly long value");
            }
            throw new ParseException(str);
        }
    }

    private final void zab(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i = 0;
        while (i < cArr.length) {
            int read = bufferedReader.read(this.zaqb, 0, cArr.length - i);
            if (read != -1) {
                int i2 = 0;
                while (i2 < read) {
                    if (cArr[i2 + i] == this.zaqb[i2]) {
                        i2++;
                    } else {
                        throw new ParseException("Unexpected character");
                    }
                }
                i += read;
            } else {
                throw new ParseException("Unexpected EOF");
            }
        }
    }

    private final void zak(int i) throws ParseException {
        String str = "Expected state ";
        if (!this.zaql.isEmpty()) {
            int intValue = ((Integer) this.zaql.pop()).intValue();
            if (intValue != i) {
                StringBuilder sb = new StringBuilder(46);
                sb.append(str);
                sb.append(i);
                sb.append(" but had ");
                sb.append(intValue);
                throw new ParseException(sb.toString());
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append(str);
        sb2.append(i);
        sb2.append(" but had empty stack");
        throw new ParseException(sb2.toString());
    }
}
