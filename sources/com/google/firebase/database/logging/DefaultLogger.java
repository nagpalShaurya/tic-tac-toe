package com.google.firebase.database.logging;

import com.google.firebase.database.logging.Logger.Level;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class DefaultLogger implements Logger {
    private final Set<String> enabledComponents;
    private final Level minLevel;

    /* renamed from: com.google.firebase.database.logging.DefaultLogger$1 */
    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    static /* synthetic */ class C05061 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$logging$Logger$Level = new int[Level.values().length];

        static {
            try {
                $SwitchMap$com$google$firebase$database$logging$Logger$Level[Level.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$firebase$database$logging$Logger$Level[Level.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$firebase$database$logging$Logger$Level[Level.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$firebase$database$logging$Logger$Level[Level.DEBUG.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public DefaultLogger(Level level, List<String> enabledComponents2) {
        if (enabledComponents2 != null) {
            this.enabledComponents = new HashSet(enabledComponents2);
        } else {
            this.enabledComponents = null;
        }
        this.minLevel = level;
    }

    public Level getLogLevel() {
        return this.minLevel;
    }

    public void onLogMessage(Level level, String tag, String message, long msTimestamp) {
        if (shouldLog(level, tag)) {
            String toLog = buildLogMessage(level, tag, message, msTimestamp);
            int i = C05061.$SwitchMap$com$google$firebase$database$logging$Logger$Level[level.ordinal()];
            if (i == 1) {
                error(tag, toLog);
            } else if (i == 2) {
                warn(tag, toLog);
            } else if (i == 3) {
                info(tag, toLog);
            } else if (i == 4) {
                debug(tag, toLog);
            } else {
                throw new RuntimeException("Should not reach here!");
            }
        }
    }

    /* access modifiers changed from: protected */
    public String buildLogMessage(Level level, String tag, String message, long msTimestamp) {
        Date now = new Date(msTimestamp);
        StringBuilder sb = new StringBuilder();
        sb.append(now.toString());
        sb.append(" [");
        sb.append(level);
        sb.append("] ");
        sb.append(tag);
        sb.append(": ");
        sb.append(message);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void error(String tag, String toLog) {
        System.err.println(toLog);
    }

    /* access modifiers changed from: protected */
    public void warn(String tag, String toLog) {
        System.out.println(toLog);
    }

    /* access modifiers changed from: protected */
    public void info(String tag, String toLog) {
        System.out.println(toLog);
    }

    /* access modifiers changed from: protected */
    public void debug(String tag, String toLog) {
        System.out.println(toLog);
    }

    /* access modifiers changed from: protected */
    public boolean shouldLog(Level level, String tag) {
        return level.ordinal() >= this.minLevel.ordinal() && (this.enabledComponents == null || level.ordinal() > Level.DEBUG.ordinal() || this.enabledComponents.contains(tag));
    }
}
