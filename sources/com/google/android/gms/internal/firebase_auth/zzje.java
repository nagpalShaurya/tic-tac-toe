package com.google.android.gms.internal.firebase_auth;

public enum zzje {
    DOUBLE(zzjj.DOUBLE, 1),
    FLOAT(zzjj.FLOAT, 5),
    INT64(zzjj.LONG, 0),
    UINT64(zzjj.LONG, 0),
    INT32(zzjj.INT, 0),
    FIXED64(zzjj.LONG, 1),
    FIXED32(zzjj.INT, 5),
    BOOL(zzjj.BOOLEAN, 0),
    STRING(zzjj.STRING, 2),
    GROUP(zzjj.MESSAGE, 3),
    MESSAGE(zzjj.MESSAGE, 2),
    BYTES(zzjj.BYTE_STRING, 2),
    UINT32(zzjj.INT, 0),
    ENUM(zzjj.ENUM, 0),
    SFIXED32(zzjj.INT, 5),
    SFIXED64(zzjj.LONG, 1),
    SINT32(zzjj.INT, 0),
    SINT64(zzjj.LONG, 0);
    
    private final zzjj zzadg;
    private final int zzadh;

    private zzje(zzjj zzjj, int i) {
        this.zzadg = zzjj;
        this.zzadh = i;
    }

    public final zzjj zzjw() {
        return this.zzadg;
    }

    public final int zzjx() {
        return this.zzadh;
    }
}
