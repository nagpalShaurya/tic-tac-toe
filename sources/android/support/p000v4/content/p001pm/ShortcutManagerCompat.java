package android.support.p000v4.content.p001pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutManager;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.p000v4.content.ContextCompat;
import android.text.TextUtils;

/* renamed from: android.support.v4.content.pm.ShortcutManagerCompat */
public class ShortcutManagerCompat {
    @VisibleForTesting
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    @VisibleForTesting
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";

    private ShortcutManagerCompat() {
    }

    public static boolean isRequestPinShortcutSupported(@NonNull Context context) {
        if (VERSION.SDK_INT >= 26) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
        }
        String str = INSTALL_SHORTCUT_PERMISSION;
        if (ContextCompat.checkSelfPermission(context, str) != 0) {
            return false;
        }
        for (ResolveInfo info : context.getPackageManager().queryBroadcastReceivers(new Intent(ACTION_INSTALL_SHORTCUT), 0)) {
            String permission = info.activityInfo.permission;
            if (!TextUtils.isEmpty(permission)) {
                if (str.equals(permission)) {
                }
            }
            return true;
        }
        return false;
    }

    public static boolean requestPinShortcut(@NonNull Context context, @NonNull ShortcutInfoCompat shortcut, @Nullable final IntentSender callback) {
        if (VERSION.SDK_INT >= 26) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).requestPinShortcut(shortcut.toShortcutInfo(), callback);
        }
        if (!isRequestPinShortcutSupported(context)) {
            return false;
        }
        Intent intent = shortcut.addToIntent(new Intent(ACTION_INSTALL_SHORTCUT));
        if (callback == null) {
            context.sendBroadcast(intent);
            return true;
        }
        context.sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                try {
                    callback.sendIntent(context, 0, null, null, null);
                } catch (SendIntentException e) {
                }
            }
        }, null, -1, null, null);
        return true;
    }

    @NonNull
    public static Intent createShortcutResultIntent(@NonNull Context context, @NonNull ShortcutInfoCompat shortcut) {
        Intent result = null;
        if (VERSION.SDK_INT >= 26) {
            result = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).createShortcutResultIntent(shortcut.toShortcutInfo());
        }
        if (result == null) {
            result = new Intent();
        }
        return shortcut.addToIntent(result);
    }
}
