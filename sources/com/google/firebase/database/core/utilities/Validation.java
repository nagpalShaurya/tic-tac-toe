package com.google.firebase.database.core.utilities;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.ServerValues;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class Validation {
    private static final Pattern INVALID_KEY_REGEX = Pattern.compile("[\\[\\]\\.#\\$\\/\\u0000-\\u001F\\u007F]");
    private static final Pattern INVALID_PATH_REGEX = Pattern.compile("[\\[\\]\\.#$]");

    private static boolean isValidPathString(String pathString) {
        return !INVALID_PATH_REGEX.matcher(pathString).find();
    }

    public static void validatePathString(String pathString) throws DatabaseException {
        if (!isValidPathString(pathString)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid Firebase Database path: ");
            sb.append(pathString);
            sb.append(". Firebase Database paths must not contain '.', '#', '$', '[', or ']'");
            throw new DatabaseException(sb.toString());
        }
    }

    public static void validateRootPathString(String pathString) throws DatabaseException {
        if (pathString.startsWith(".info")) {
            validatePathString(pathString.substring(5));
        } else if (pathString.startsWith("/.info")) {
            validatePathString(pathString.substring(6));
        } else {
            validatePathString(pathString);
        }
    }

    private static boolean isWritableKey(String key) {
        return key != null && key.length() > 0 && (key.equals(".value") || key.equals(".priority") || (!key.startsWith(".") && !INVALID_KEY_REGEX.matcher(key).find()));
    }

    private static boolean isValidKey(String key) {
        return key.equals(".info") || !INVALID_KEY_REGEX.matcher(key).find();
    }

    public static void validateNullableKey(String key) throws DatabaseException {
        if (key != null && !isValidKey(key)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid key: ");
            sb.append(key);
            sb.append(". Keys must not contain '/', '.', '#', '$', '[', or ']'");
            throw new DatabaseException(sb.toString());
        }
    }

    private static void validateDoubleValue(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new DatabaseException("Invalid value: Value cannot be NaN, Inf or -Inf.");
        }
    }

    private static boolean isWritablePath(Path path) {
        ChildKey front = path.getFront();
        return front == null || !front.asString().startsWith(".");
    }

    public static void validateWritableObject(Object object) {
        if (object instanceof Map) {
            Map<String, Object> map = (Map) object;
            if (!map.containsKey(ServerValues.NAME_SUBKEY_SERVERVALUE)) {
                for (Entry<String, Object> entry : map.entrySet()) {
                    validateWritableKey((String) entry.getKey());
                    validateWritableObject(entry.getValue());
                }
            }
        } else if (object instanceof List) {
            for (Object child : (List) object) {
                validateWritableObject(child);
            }
        } else if ((object instanceof Double) || (object instanceof Float)) {
            validateDoubleValue(((Double) object).doubleValue());
        }
    }

    public static void validateWritableKey(String key) throws DatabaseException {
        if (!isWritableKey(key)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid key: ");
            sb.append(key);
            sb.append(". Keys must not contain '/', '.', '#', '$', '[', or ']'");
            throw new DatabaseException(sb.toString());
        }
    }

    public static void validateWritablePath(Path path) throws DatabaseException {
        if (!isWritablePath(path)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid write location: ");
            sb.append(path.toString());
            throw new DatabaseException(sb.toString());
        }
    }

    public static Map<Path, Node> parseAndValidateUpdate(Path path, Map<String, Object> update) throws DatabaseException {
        String str;
        Path updatePath;
        String childName;
        Node parsedValue;
        SortedMap<Path, Node> parsedUpdate = new TreeMap<>();
        Iterator it = update.entrySet().iterator();
        while (true) {
            str = "Path '";
            if (it.hasNext()) {
                Entry<String, Object> entry = (Entry) it.next();
                updatePath = new Path((String) entry.getKey());
                Object newValue = entry.getValue();
                ValidationPath.validateWithObject(path.child(updatePath), newValue);
                childName = !updatePath.isEmpty() ? updatePath.getBack().asString() : "";
                if (childName.equals(ServerValues.NAME_SUBKEY_SERVERVALUE) || childName.equals(".value")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(updatePath);
                    sb.append("' contains disallowed child name: ");
                    sb.append(childName);
                } else {
                    if (childName.equals(".priority")) {
                        parsedValue = PriorityUtilities.parsePriority(updatePath, newValue);
                    } else {
                        parsedValue = NodeUtilities.NodeFromJSON(newValue);
                    }
                    validateWritableObject(newValue);
                    parsedUpdate.put(updatePath, parsedValue);
                }
            } else {
                Path prevPath = null;
                for (Path curPath : parsedUpdate.keySet()) {
                    Utilities.hardAssert(prevPath == null || prevPath.compareTo(curPath) < 0);
                    if (prevPath == null || !prevPath.contains(curPath)) {
                        prevPath = curPath;
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(prevPath);
                        sb2.append("' is an ancestor of '");
                        sb2.append(curPath);
                        sb2.append("' in an update.");
                        throw new DatabaseException(sb2.toString());
                    }
                }
                return parsedUpdate;
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(updatePath);
        sb3.append("' contains disallowed child name: ");
        sb3.append(childName);
        throw new DatabaseException(sb3.toString());
    }
}
