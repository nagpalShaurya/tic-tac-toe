package android.support.p000v4.content;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;

/* renamed from: android.support.v4.content.MimeTypeFilter */
public final class MimeTypeFilter {
    private MimeTypeFilter() {
    }

    private static boolean mimeTypeAgainstFilter(@NonNull String[] mimeTypeParts, @NonNull String[] filterParts) {
        if (filterParts.length != 2) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
        } else if (filterParts[0].isEmpty() || filterParts[1].isEmpty()) {
            throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
        } else if (mimeTypeParts.length != 2) {
            return false;
        } else {
            String str = "*";
            if (str.equals(filterParts[0]) || filterParts[0].equals(mimeTypeParts[0])) {
                return str.equals(filterParts[1]) || filterParts[1].equals(mimeTypeParts[1]);
            }
            return false;
        }
    }

    public static boolean matches(@Nullable String mimeType, @NonNull String filter) {
        if (mimeType == null) {
            return false;
        }
        String str = "/";
        return mimeTypeAgainstFilter(mimeType.split(str), filter.split(str));
    }

    @Nullable
    public static String matches(@Nullable String mimeType, @NonNull String[] filters) {
        if (mimeType == null) {
            return null;
        }
        String str = "/";
        String[] mimeTypeParts = mimeType.split(str);
        for (String filter : filters) {
            if (mimeTypeAgainstFilter(mimeTypeParts, filter.split(str))) {
                return filter;
            }
        }
        return null;
    }

    @Nullable
    public static String matches(@Nullable String[] mimeTypes, @NonNull String filter) {
        if (mimeTypes == null) {
            return null;
        }
        String str = "/";
        String[] filterParts = filter.split(str);
        for (String mimeType : mimeTypes) {
            if (mimeTypeAgainstFilter(mimeType.split(str), filterParts)) {
                return mimeType;
            }
        }
        return null;
    }

    @NonNull
    public static String[] matchesMany(@Nullable String[] mimeTypes, @NonNull String filter) {
        if (mimeTypes == null) {
            return new String[0];
        }
        ArrayList<String> list = new ArrayList<>();
        String str = "/";
        String[] filterParts = filter.split(str);
        for (String mimeType : mimeTypes) {
            if (mimeTypeAgainstFilter(mimeType.split(str), filterParts)) {
                list.add(mimeType);
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }
}
