package com.google.firebase.database.logging;

import android.util.Log;
import com.google.firebase.database.logging.Logger.Level;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class AndroidLogger extends DefaultLogger {
    public AndroidLogger(Level level, List<String> enabledComponents) {
        super(level, enabledComponents);
    }

    /* access modifiers changed from: protected */
    public String buildLogMessage(Level level, String tag, String message, long msTimestamp) {
        return message;
    }

    /* access modifiers changed from: protected */
    public void error(String tag, String toLog) {
        Log.e(tag, toLog);
    }

    /* access modifiers changed from: protected */
    public void warn(String tag, String toLog) {
        Log.w(tag, toLog);
    }

    /* access modifiers changed from: protected */
    public void info(String tag, String toLog) {
        Log.i(tag, toLog);
    }

    /* access modifiers changed from: protected */
    public void debug(String tag, String toLog) {
        Log.d(tag, toLog);
    }
}
