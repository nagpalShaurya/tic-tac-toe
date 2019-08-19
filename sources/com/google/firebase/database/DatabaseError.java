package com.google.firebase.database;

import android.support.annotation.NonNull;
import com.google.firebase.annotations.PublicApi;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@PublicApi
/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class DatabaseError {
    @PublicApi
    public static final int DATA_STALE = -1;
    @PublicApi
    public static final int DISCONNECTED = -4;
    @PublicApi
    public static final int EXPIRED_TOKEN = -6;
    @PublicApi
    public static final int INVALID_TOKEN = -7;
    @PublicApi
    public static final int MAX_RETRIES = -8;
    @PublicApi
    public static final int NETWORK_ERROR = -24;
    @PublicApi
    public static final int OPERATION_FAILED = -2;
    @PublicApi
    public static final int OVERRIDDEN_BY_SET = -9;
    @PublicApi
    public static final int PERMISSION_DENIED = -3;
    @PublicApi
    public static final int UNAVAILABLE = -10;
    @PublicApi
    public static final int UNKNOWN_ERROR = -999;
    @PublicApi
    public static final int USER_CODE_EXCEPTION = -11;
    @PublicApi
    public static final int WRITE_CANCELED = -25;
    private static final Map<String, Integer> errorCodes = new HashMap();
    private static final Map<Integer, String> errorReasons = new HashMap();
    private final int code;
    private final String details;
    private final String message;

    static {
        Map<Integer, String> map = errorReasons;
        Integer valueOf = Integer.valueOf(-1);
        map.put(valueOf, "The transaction needs to be run again with current data");
        Map<Integer, String> map2 = errorReasons;
        Integer valueOf2 = Integer.valueOf(-2);
        map2.put(valueOf2, "The server indicated that this operation failed");
        Map<Integer, String> map3 = errorReasons;
        Integer valueOf3 = Integer.valueOf(-3);
        map3.put(valueOf3, "This client does not have permission to perform this operation");
        Map<Integer, String> map4 = errorReasons;
        Integer valueOf4 = Integer.valueOf(-4);
        map4.put(valueOf4, "The operation had to be aborted due to a network disconnect");
        Map<Integer, String> map5 = errorReasons;
        Integer valueOf5 = Integer.valueOf(-6);
        map5.put(valueOf5, "The supplied auth token has expired");
        Map<Integer, String> map6 = errorReasons;
        Integer valueOf6 = Integer.valueOf(-7);
        map6.put(valueOf6, "The supplied auth token was invalid");
        Map<Integer, String> map7 = errorReasons;
        Integer valueOf7 = Integer.valueOf(-8);
        map7.put(valueOf7, "The transaction had too many retries");
        errorReasons.put(Integer.valueOf(-9), "The transaction was overridden by a subsequent set");
        errorReasons.put(Integer.valueOf(-10), "The service is unavailable");
        errorReasons.put(Integer.valueOf(-11), "User code called from the Firebase Database runloop threw an exception:\n");
        errorReasons.put(Integer.valueOf(-24), "The operation could not be performed due to a network error");
        errorReasons.put(Integer.valueOf(-25), "The write was canceled by the user.");
        errorReasons.put(Integer.valueOf(UNKNOWN_ERROR), "An unknown error occurred");
        errorCodes.put("datastale", valueOf);
        errorCodes.put("failure", valueOf2);
        errorCodes.put("permission_denied", valueOf3);
        errorCodes.put("disconnected", valueOf4);
        errorCodes.put("expired_token", valueOf5);
        errorCodes.put("invalid_token", valueOf6);
        errorCodes.put("maxretries", valueOf7);
        errorCodes.put("overriddenbyset", Integer.valueOf(-9));
        errorCodes.put("unavailable", Integer.valueOf(-10));
        errorCodes.put("network_error", Integer.valueOf(-24));
        errorCodes.put("write_canceled", Integer.valueOf(-25));
    }

    public static DatabaseError fromStatus(String status) {
        return fromStatus(status, null);
    }

    public static DatabaseError fromStatus(String status, String reason) {
        return fromStatus(status, reason, null);
    }

    public static DatabaseError fromCode(int code2) {
        if (errorReasons.containsKey(Integer.valueOf(code2))) {
            return new DatabaseError(code2, (String) errorReasons.get(Integer.valueOf(code2)), null);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid Firebase Database error code: ");
        sb.append(code2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static DatabaseError fromStatus(String status, String reason, String details2) {
        Integer code2 = (Integer) errorCodes.get(status.toLowerCase());
        if (code2 == null) {
            code2 = Integer.valueOf(UNKNOWN_ERROR);
        }
        return new DatabaseError(code2.intValue(), reason == null ? (String) errorReasons.get(code2) : reason, details2);
    }

    @PublicApi
    public static DatabaseError fromException(Throwable e) {
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        StringBuilder sb = new StringBuilder();
        sb.append((String) errorReasons.get(Integer.valueOf(-11)));
        sb.append(stringWriter.toString());
        return new DatabaseError(-11, sb.toString());
    }

    private DatabaseError(int code2, String message2) {
        this(code2, message2, null);
    }

    private DatabaseError(int code2, String message2, String details2) {
        this.code = code2;
        this.message = message2;
        this.details = details2 == null ? "" : details2;
    }

    @PublicApi
    public int getCode() {
        return this.code;
    }

    @PublicApi
    @NonNull
    public String getMessage() {
        return this.message;
    }

    @PublicApi
    @NonNull
    public String getDetails() {
        return this.details;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DatabaseError: ");
        sb.append(this.message);
        return sb.toString();
    }

    @PublicApi
    public DatabaseException toException() {
        StringBuilder sb = new StringBuilder();
        sb.append("Firebase Database error: ");
        sb.append(this.message);
        return new DatabaseException(sb.toString());
    }
}
