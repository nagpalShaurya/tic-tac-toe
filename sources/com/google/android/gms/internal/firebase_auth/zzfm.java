package com.google.android.gms.internal.firebase_auth;

import java.lang.reflect.Type;

public enum zzfm {
    DOUBLE(0, zzfo.SCALAR, zzgd.DOUBLE),
    FLOAT(1, zzfo.SCALAR, zzgd.FLOAT),
    INT64(2, zzfo.SCALAR, zzgd.LONG),
    UINT64(3, zzfo.SCALAR, zzgd.LONG),
    INT32(4, zzfo.SCALAR, zzgd.INT),
    FIXED64(5, zzfo.SCALAR, zzgd.LONG),
    FIXED32(6, zzfo.SCALAR, zzgd.INT),
    BOOL(7, zzfo.SCALAR, zzgd.BOOLEAN),
    STRING(8, zzfo.SCALAR, zzgd.STRING),
    MESSAGE(9, zzfo.SCALAR, zzgd.MESSAGE),
    BYTES(10, zzfo.SCALAR, zzgd.BYTE_STRING),
    UINT32(11, zzfo.SCALAR, zzgd.INT),
    ENUM(12, zzfo.SCALAR, zzgd.ENUM),
    SFIXED32(13, zzfo.SCALAR, zzgd.INT),
    SFIXED64(14, zzfo.SCALAR, zzgd.LONG),
    SINT32(15, zzfo.SCALAR, zzgd.INT),
    SINT64(16, zzfo.SCALAR, zzgd.LONG),
    GROUP(17, zzfo.SCALAR, zzgd.MESSAGE),
    DOUBLE_LIST(18, zzfo.VECTOR, zzgd.DOUBLE),
    FLOAT_LIST(19, zzfo.VECTOR, zzgd.FLOAT),
    INT64_LIST(20, zzfo.VECTOR, zzgd.LONG),
    UINT64_LIST(21, zzfo.VECTOR, zzgd.LONG),
    INT32_LIST(22, zzfo.VECTOR, zzgd.INT),
    FIXED64_LIST(23, zzfo.VECTOR, zzgd.LONG),
    FIXED32_LIST(24, zzfo.VECTOR, zzgd.INT),
    BOOL_LIST(25, zzfo.VECTOR, zzgd.BOOLEAN),
    STRING_LIST(26, zzfo.VECTOR, zzgd.STRING),
    MESSAGE_LIST(27, zzfo.VECTOR, zzgd.MESSAGE),
    BYTES_LIST(28, zzfo.VECTOR, zzgd.BYTE_STRING),
    UINT32_LIST(29, zzfo.VECTOR, zzgd.INT),
    ENUM_LIST(30, zzfo.VECTOR, zzgd.ENUM),
    SFIXED32_LIST(31, zzfo.VECTOR, zzgd.INT),
    SFIXED64_LIST(32, zzfo.VECTOR, zzgd.LONG),
    SINT32_LIST(33, zzfo.VECTOR, zzgd.INT),
    SINT64_LIST(34, zzfo.VECTOR, zzgd.LONG),
    DOUBLE_LIST_PACKED(35, zzfo.PACKED_VECTOR, zzgd.DOUBLE),
    FLOAT_LIST_PACKED(36, zzfo.PACKED_VECTOR, zzgd.FLOAT),
    INT64_LIST_PACKED(37, zzfo.PACKED_VECTOR, zzgd.LONG),
    UINT64_LIST_PACKED(38, zzfo.PACKED_VECTOR, zzgd.LONG),
    INT32_LIST_PACKED(39, zzfo.PACKED_VECTOR, zzgd.INT),
    FIXED64_LIST_PACKED(40, zzfo.PACKED_VECTOR, zzgd.LONG),
    FIXED32_LIST_PACKED(41, zzfo.PACKED_VECTOR, zzgd.INT),
    BOOL_LIST_PACKED(42, zzfo.PACKED_VECTOR, zzgd.BOOLEAN),
    UINT32_LIST_PACKED(43, zzfo.PACKED_VECTOR, zzgd.INT),
    ENUM_LIST_PACKED(44, zzfo.PACKED_VECTOR, zzgd.ENUM),
    SFIXED32_LIST_PACKED(45, zzfo.PACKED_VECTOR, zzgd.INT),
    SFIXED64_LIST_PACKED(46, zzfo.PACKED_VECTOR, zzgd.LONG),
    SINT32_LIST_PACKED(47, zzfo.PACKED_VECTOR, zzgd.INT),
    SINT64_LIST_PACKED(48, zzfo.PACKED_VECTOR, zzgd.LONG),
    GROUP_LIST(49, zzfo.VECTOR, zzgd.MESSAGE),
    MAP(50, zzfo.MAP, zzgd.VOID);
    
    private static final zzfm[] zzwj = null;
    private static final Type[] zzwk = null;

    /* renamed from: id */
    private final int f41id;
    private final zzgd zzwf;
    private final zzfo zzwg;
    private final Class<?> zzwh;
    private final boolean zzwi;

    private zzfm(int i, zzfo zzfo, zzgd zzgd) {
        this.f41id = i;
        this.zzwg = zzfo;
        this.zzwf = zzgd;
        int i2 = zzfn.zzwm[zzfo.ordinal()];
        if (i2 == 1) {
            this.zzwh = zzgd.zzhy();
        } else if (i2 != 2) {
            this.zzwh = null;
        } else {
            this.zzwh = zzgd.zzhy();
        }
        boolean z = false;
        if (zzfo == zzfo.SCALAR) {
            int i3 = zzfn.zzwn[zzgd.ordinal()];
            if (!(i3 == 1 || i3 == 2 || i3 == 3)) {
                z = true;
            }
        }
        this.zzwi = z;
    }

    /* renamed from: id */
    public final int mo8538id() {
        return this.f41id;
    }

    static {
        int i;
        zzwk = new Type[0];
        zzfm[] values = values();
        zzwj = new zzfm[values.length];
        for (zzfm zzfm : values) {
            zzwj[zzfm.f41id] = zzfm;
        }
    }
}
