package com.google.firebase.database.core.utilities;

import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.RepoInfo;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class Utilities {
    private static final char[] HEX_CHARACTERS = "0123456789abcdef".toCharArray();

    public static ParsedUrl parseUrl(String url) throws DatabaseException {
        String str = "/";
        String original = url;
        try {
            int schemeOffset = original.indexOf("//");
            if (schemeOffset != -1) {
                int pathOffset = original.substring(schemeOffset + 2).indexOf(str);
                if (pathOffset != -1) {
                    int pathOffset2 = pathOffset + schemeOffset + 2;
                    String[] pathSegments = original.substring(pathOffset2).split(str, -1);
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < pathSegments.length; i++) {
                        if (!pathSegments[i].equals("")) {
                            builder.append(str);
                            builder.append(URLEncoder.encode(pathSegments[i], "UTF-8"));
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(original.substring(0, pathOffset2));
                    sb.append(builder.toString());
                    original = sb.toString();
                }
                URI uri = new URI(original);
                String pathString = uri.getPath().replace("+", " ");
                Validation.validateRootPathString(pathString);
                Path path = new Path(pathString);
                String scheme = uri.getScheme();
                RepoInfo repoInfo = new RepoInfo();
                repoInfo.host = uri.getHost().toLowerCase();
                int port = uri.getPort();
                if (port != -1) {
                    repoInfo.secure = scheme.equals("https");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(repoInfo.host);
                    sb2.append(":");
                    sb2.append(port);
                    repoInfo.host = sb2.toString();
                } else {
                    repoInfo.secure = true;
                }
                repoInfo.namespace = repoInfo.host.split("\\.", -1)[0].toLowerCase();
                repoInfo.internalHost = repoInfo.host;
                ParsedUrl parsedUrl = new ParsedUrl();
                parsedUrl.path = path;
                parsedUrl.repoInfo = repoInfo;
                return parsedUrl;
            }
            throw new URISyntaxException(original, "Invalid scheme specified");
        } catch (URISyntaxException e) {
            throw new DatabaseException("Invalid Firebase Database url specified", e);
        } catch (UnsupportedEncodingException e2) {
            throw new DatabaseException("Failed to URLEncode the path", e2);
        }
    }

    public static String[] splitIntoFrames(String src, int maxFrameSize) {
        if (src.length() <= maxFrameSize) {
            return new String[]{src};
        }
        ArrayList<String> segs = new ArrayList<>();
        int i = 0;
        while (i < src.length()) {
            segs.add(src.substring(i, Math.min(i + maxFrameSize, src.length())));
            i += maxFrameSize;
        }
        return (String[]) segs.toArray(new String[segs.size()]);
    }

    public static String sha1HexDigest(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(input.getBytes("UTF-8"));
            return Base64.encodeToString(md.digest(), 2);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Missing SHA-1 MessageDigest provider.", e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 encoding is required for Firebase Database to run!");
        }
    }

    public static String stringHashV2Representation(String value) {
        String escaped = value;
        if (value.indexOf(92) != -1) {
            escaped = escaped.replace("\\", "\\\\");
        }
        if (value.indexOf(34) != -1) {
            escaped = escaped.replace("\"", "\\\"");
        }
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        sb.append(escaped);
        sb.append('\"');
        return sb.toString();
    }

    public static String doubleToHashString(double value) {
        StringBuilder sb = new StringBuilder(16);
        long bits = Double.doubleToLongBits(value);
        for (int i = 7; i >= 0; i--) {
            int byteValue = (int) ((bits >>> (i * 8)) & 255);
            int low = byteValue & 15;
            sb.append(HEX_CHARACTERS[(byteValue >> 4) & 15]);
            sb.append(HEX_CHARACTERS[low]);
        }
        return sb.toString();
    }

    public static Integer tryParseInt(String num) {
        if (num.length() > 11 || num.length() == 0) {
            return null;
        }
        int i = 0;
        boolean negative = false;
        if (num.charAt(0) == '-') {
            if (num.length() == 1) {
                return null;
            }
            negative = true;
            i = 1;
        }
        long number = 0;
        while (i < num.length()) {
            char c = num.charAt(i);
            if (c < '0' || c > '9') {
                return null;
            }
            number = (10 * number) + ((long) (c - '0'));
            i++;
        }
        if (negative) {
            if ((-number) < -2147483648L) {
                return null;
            }
            return Integer.valueOf((int) (-number));
        } else if (number > 2147483647L) {
            return null;
        } else {
            return Integer.valueOf((int) number);
        }
    }

    public static int compareInts(int i, int j) {
        if (i < j) {
            return -1;
        }
        if (i == j) {
            return 0;
        }
        return 1;
    }

    public static int compareLongs(long i, long j) {
        if (i < j) {
            return -1;
        }
        if (i == j) {
            return 0;
        }
        return 1;
    }

    public static <C> C castOrNull(Object o, Class<C> clazz) {
        if (clazz.isAssignableFrom(o.getClass())) {
            return o;
        }
        return null;
    }

    public static <C> C getOrNull(Object o, String key, Class<C> clazz) {
        if (o == null) {
            return null;
        }
        Object result = ((Map) castOrNull(o, Map.class)).get(key);
        if (result != null) {
            return castOrNull(result, clazz);
        }
        return null;
    }

    public static void hardAssert(boolean condition) {
        hardAssert(condition, "");
    }

    public static void hardAssert(boolean condition, String message) {
        if (!condition) {
            StringBuilder sb = new StringBuilder();
            sb.append("hardAssert failed: ");
            sb.append(message);
            throw new AssertionError(sb.toString());
        }
    }

    public static Pair<Task<Void>, CompletionListener> wrapOnComplete(CompletionListener optListener) {
        if (optListener != null) {
            return new Pair<>(null, optListener);
        }
        final TaskCompletionSource<Void> source = new TaskCompletionSource<>();
        return new Pair<>(source.getTask(), new CompletionListener() {
            public void onComplete(DatabaseError error, DatabaseReference ref) {
                if (error != null) {
                    TaskCompletionSource.this.setException(error.toException());
                } else {
                    TaskCompletionSource.this.setResult(null);
                }
            }
        });
    }
}
