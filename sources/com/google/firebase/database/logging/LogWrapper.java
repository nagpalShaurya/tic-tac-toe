package com.google.firebase.database.logging;

import com.google.firebase.database.logging.Logger.Level;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class LogWrapper {
    private final String component;
    private final Logger logger;
    private final String prefix;

    private static String exceptionStacktrace(Throwable e) {
        StringWriter writer = new StringWriter();
        e.printStackTrace(new PrintWriter(writer));
        return writer.toString();
    }

    public LogWrapper(Logger logger2, String component2) {
        this(logger2, component2, null);
    }

    public LogWrapper(Logger logger2, String component2, String prefix2) {
        this.logger = logger2;
        this.component = component2;
        this.prefix = prefix2;
    }

    public void error(String message, Throwable e) {
        StringBuilder sb = new StringBuilder();
        sb.append(toLog(message, new Object[0]));
        sb.append("\n");
        sb.append(exceptionStacktrace(e));
        this.logger.onLogMessage(Level.ERROR, this.component, sb.toString(), now());
    }

    public void warn(String message) {
        warn(message, null);
    }

    public void warn(String message, Throwable e) {
        String logMsg = toLog(message, new Object[0]);
        if (e != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(logMsg);
            sb.append("\n");
            sb.append(exceptionStacktrace(e));
            logMsg = sb.toString();
        }
        this.logger.onLogMessage(Level.WARN, this.component, logMsg, now());
    }

    public void info(String message) {
        this.logger.onLogMessage(Level.INFO, this.component, toLog(message, new Object[0]), now());
    }

    public void debug(String message, Object... args) {
        debug(message, null, args);
    }

    public boolean logsDebug() {
        return this.logger.getLogLevel().ordinal() <= Level.DEBUG.ordinal();
    }

    public void debug(String message, Throwable e, Object... args) {
        if (logsDebug()) {
            String logMsg = toLog(message, args);
            if (e != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(logMsg);
                sb.append("\n");
                sb.append(exceptionStacktrace(e));
                logMsg = sb.toString();
            }
            this.logger.onLogMessage(Level.DEBUG, this.component, logMsg, now());
        }
    }

    private long now() {
        return System.currentTimeMillis();
    }

    private String toLog(String message, Object... args) {
        String formatted = args.length > 0 ? String.format(message, args) : message;
        if (this.prefix == null) {
            return formatted;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.prefix);
        sb.append(" - ");
        sb.append(formatted);
        return sb.toString();
    }
}
