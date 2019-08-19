package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

public class zzgb extends IOException {
    private zzhb zzxx = null;

    public zzgb(String str) {
        super(str);
    }

    public final zzgb zzh(zzhb zzhb) {
        this.zzxx = zzhb;
        return this;
    }

    static zzgb zzhp() {
        return new zzgb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzgb zzhq() {
        return new zzgb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzgb zzhr() {
        return new zzgb("CodedInputStream encountered a malformed varint.");
    }

    static zzgb zzhs() {
        return new zzgb("Protocol message contained an invalid tag (zero).");
    }

    static zzgb zzht() {
        return new zzgb("Protocol message end-group tag did not match expected tag.");
    }

    static zzgc zzhu() {
        return new zzgc("Protocol message tag had invalid wire type.");
    }

    static zzgb zzhv() {
        return new zzgb("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzgb zzhw() {
        return new zzgb("Failed to parse the message.");
    }

    static zzgb zzhx() {
        return new zzgb("Protocol message had invalid UTF-8.");
    }
}
