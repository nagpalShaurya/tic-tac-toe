package com.google.firebase.database.core.utilities.encoding;

import android.util.Log;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;
import com.google.firebase.database.ThrowOnExtraProperties;
import com.google.firebase.database.core.utilities.Utilities;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class CustomClassMapper {
    private static final String LOG_TAG = "ClassMapper";
    private static final ConcurrentMap<Class<?>, BeanMapper<?>> mappers = new ConcurrentHashMap();

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private static class BeanMapper<T> {
        /* access modifiers changed from: private */
        public final Class<T> clazz;
        private final Constructor<T> constructor;
        private final Map<String, Field> fields = new HashMap();
        private final Map<String, Method> getters = new HashMap();
        private final Map<String, String> properties = new HashMap();
        private final Map<String, Method> setters = new HashMap();
        private final boolean throwOnUnknownProperties;
        private final boolean warnOnUnknownProperties;

        public BeanMapper(Class<T> clazz2) {
            Constructor<T> constructor2;
            Method[] methods;
            Field[] fields2;
            Method[] declaredMethods;
            Field[] declaredFields;
            this.clazz = clazz2;
            this.throwOnUnknownProperties = clazz2.isAnnotationPresent(ThrowOnExtraProperties.class);
            this.warnOnUnknownProperties = !clazz2.isAnnotationPresent(IgnoreExtraProperties.class);
            try {
                constructor2 = clazz2.getDeclaredConstructor(new Class[0]);
                constructor2.setAccessible(true);
            } catch (NoSuchMethodException e) {
                constructor2 = null;
            }
            this.constructor = constructor2;
            for (Method method : clazz2.getMethods()) {
                if (shouldIncludeGetter(method)) {
                    String propertyName = propertyName(method);
                    addProperty(propertyName);
                    method.setAccessible(true);
                    if (!this.getters.containsKey(propertyName)) {
                        this.getters.put(propertyName, method);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Found conflicting getters for name: ");
                        sb.append(method.getName());
                        throw new DatabaseException(sb.toString());
                    }
                }
            }
            for (Field field : clazz2.getFields()) {
                if (shouldIncludeField(field)) {
                    addProperty(propertyName(field));
                }
            }
            Class<T> cls = clazz2;
            do {
                for (Method method2 : cls.getDeclaredMethods()) {
                    if (shouldIncludeSetter(method2)) {
                        String propertyName2 = propertyName(method2);
                        String existingPropertyName = (String) this.properties.get(propertyName2.toLowerCase());
                        if (existingPropertyName == null) {
                            continue;
                        } else if (existingPropertyName.equals(propertyName2)) {
                            Method existingSetter = (Method) this.setters.get(propertyName2);
                            if (existingSetter == null) {
                                method2.setAccessible(true);
                                this.setters.put(propertyName2, method2);
                            } else if (!isSetterOverride(method2, existingSetter)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Found a conflicting setters with name: ");
                                sb2.append(method2.getName());
                                sb2.append(" (conflicts with ");
                                sb2.append(existingSetter.getName());
                                sb2.append(" defined on ");
                                sb2.append(existingSetter.getDeclaringClass().getName());
                                sb2.append(")");
                                throw new DatabaseException(sb2.toString());
                            }
                        } else {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Found setter with invalid case-sensitive name: ");
                            sb3.append(method2.getName());
                            throw new DatabaseException(sb3.toString());
                        }
                    }
                }
                for (Field field2 : cls.getDeclaredFields()) {
                    String propertyName3 = propertyName(field2);
                    if (this.properties.containsKey(propertyName3.toLowerCase()) && !this.fields.containsKey(propertyName3)) {
                        field2.setAccessible(true);
                        this.fields.put(propertyName3, field2);
                    }
                }
                cls = cls.getSuperclass();
                if (cls == null) {
                    break;
                }
            } while (!cls.equals(Object.class));
            if (this.properties.isEmpty()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("No properties to serialize found on class ");
                sb4.append(clazz2.getName());
                throw new DatabaseException(sb4.toString());
            }
        }

        private void addProperty(String property) {
            String oldValue = (String) this.properties.put(property.toLowerCase(), property);
            if (oldValue != null && !property.equals(oldValue)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Found two getters or fields with conflicting case sensitivity for property: ");
                sb.append(property.toLowerCase());
                throw new DatabaseException(sb.toString());
            }
        }

        public T deserialize(Map<String, Object> values) {
            return deserialize(values, Collections.emptyMap());
        }

        public T deserialize(Map<String, Object> values, Map<TypeVariable<Class<T>>, Type> types) {
            Constructor<T> constructor2 = this.constructor;
            if (constructor2 != null) {
                try {
                    T instance = constructor2.newInstance(new Object[0]);
                    for (Entry<String, Object> entry : values.entrySet()) {
                        String propertyName = (String) entry.getKey();
                        if (this.setters.containsKey(propertyName)) {
                            Method setter = (Method) this.setters.get(propertyName);
                            Type[] params = setter.getGenericParameterTypes();
                            if (params.length == 1) {
                                try {
                                    setter.invoke(instance, new Object[]{CustomClassMapper.deserializeToType(entry.getValue(), resolveType(params[0], types))});
                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                } catch (InvocationTargetException e2) {
                                    throw new RuntimeException(e2);
                                }
                            } else {
                                throw new IllegalStateException("Setter does not have exactly one parameter");
                            }
                        } else if (this.fields.containsKey(propertyName)) {
                            Field field = (Field) this.fields.get(propertyName);
                            try {
                                field.set(instance, CustomClassMapper.deserializeToType(entry.getValue(), resolveType(field.getGenericType(), types)));
                            } catch (IllegalAccessException e3) {
                                throw new RuntimeException(e3);
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("No setter/field for ");
                            sb.append(propertyName);
                            sb.append(" found on class ");
                            sb.append(this.clazz.getName());
                            String message = sb.toString();
                            if (this.properties.containsKey(propertyName.toLowerCase())) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(message);
                                sb2.append(" (fields/setters are case sensitive!)");
                                message = sb2.toString();
                            }
                            if (this.throwOnUnknownProperties) {
                                throw new DatabaseException(message);
                            } else if (this.warnOnUnknownProperties) {
                                Log.w(CustomClassMapper.LOG_TAG, message);
                            }
                        }
                    }
                    return instance;
                } catch (InstantiationException e4) {
                    throw new RuntimeException(e4);
                } catch (IllegalAccessException e5) {
                    throw new RuntimeException(e5);
                } catch (InvocationTargetException e6) {
                    throw new RuntimeException(e6);
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Class ");
                sb3.append(this.clazz.getName());
                sb3.append(" does not define a no-argument constructor. If you are using ProGuard, make sure these constructors are not stripped.");
                throw new DatabaseException(sb3.toString());
            }
        }

        private Type resolveType(Type type, Map<TypeVariable<Class<T>>, Type> types) {
            if (!(type instanceof TypeVariable)) {
                return type;
            }
            Type resolvedType = (Type) types.get(type);
            if (resolvedType != null) {
                return resolvedType;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Could not resolve type ");
            sb.append(type);
            throw new IllegalStateException(sb.toString());
        }

        public Map<String, Object> serialize(T object) {
            Object propertyValue;
            if (this.clazz.isAssignableFrom(object.getClass())) {
                Map<String, Object> result = new HashMap<>();
                for (String property : this.properties.values()) {
                    if (this.getters.containsKey(property)) {
                        try {
                            propertyValue = ((Method) this.getters.get(property)).invoke(object, new Object[0]);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (InvocationTargetException e2) {
                            throw new RuntimeException(e2);
                        }
                    } else {
                        Field field = (Field) this.fields.get(property);
                        if (field != null) {
                            try {
                                propertyValue = field.get(object);
                            } catch (IllegalAccessException e3) {
                                throw new RuntimeException(e3);
                            }
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Bean property without field or getter:");
                            sb.append(property);
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    result.put(property, CustomClassMapper.serialize(propertyValue));
                }
                return result;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't serialize object of class ");
            sb2.append(object.getClass());
            sb2.append(" with BeanMapper for class ");
            sb2.append(this.clazz);
            throw new IllegalArgumentException(sb2.toString());
        }

        private static boolean shouldIncludeGetter(Method method) {
            if ((method.getName().startsWith("get") || method.getName().startsWith("is")) && !method.getDeclaringClass().equals(Object.class) && Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers()) && !method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 0 && !method.isAnnotationPresent(Exclude.class)) {
                return true;
            }
            return false;
        }

        private static boolean shouldIncludeSetter(Method method) {
            if (method.getName().startsWith("set") && !method.getDeclaringClass().equals(Object.class) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 1 && !method.isAnnotationPresent(Exclude.class)) {
                return true;
            }
            return false;
        }

        private static boolean shouldIncludeField(Field field) {
            if (!field.getDeclaringClass().equals(Object.class) && Modifier.isPublic(field.getModifiers()) && !Modifier.isStatic(field.getModifiers()) && !Modifier.isTransient(field.getModifiers()) && !field.isAnnotationPresent(Exclude.class)) {
                return true;
            }
            return false;
        }

        private static boolean isSetterOverride(Method base, Method override) {
            Utilities.hardAssert(base.getDeclaringClass().isAssignableFrom(override.getDeclaringClass()), "Expected override from a base class");
            String str = "Expected void return type";
            Utilities.hardAssert(base.getReturnType().equals(Void.TYPE), str);
            Utilities.hardAssert(override.getReturnType().equals(Void.TYPE), str);
            Type[] baseParameterTypes = base.getParameterTypes();
            Type[] overrideParameterTypes = override.getParameterTypes();
            String str2 = "Expected exactly one parameter";
            Utilities.hardAssert(baseParameterTypes.length == 1, str2);
            Utilities.hardAssert(overrideParameterTypes.length == 1, str2);
            if (!base.getName().equals(override.getName()) || !baseParameterTypes[0].equals(overrideParameterTypes[0])) {
                return false;
            }
            return true;
        }

        private static String propertyName(Field field) {
            String annotatedName = annotatedName(field);
            return annotatedName != null ? annotatedName : field.getName();
        }

        private static String propertyName(Method method) {
            String annotatedName = annotatedName(method);
            return annotatedName != null ? annotatedName : serializedName(method.getName());
        }

        private static String annotatedName(AccessibleObject obj) {
            if (obj.isAnnotationPresent(PropertyName.class)) {
                return ((PropertyName) obj.getAnnotation(PropertyName.class)).value();
            }
            return null;
        }

        private static String serializedName(String methodName) {
            String[] prefixes;
            String methodPrefix = null;
            for (String prefix : new String[]{"get", "set", "is"}) {
                if (methodName.startsWith(prefix)) {
                    methodPrefix = prefix;
                }
            }
            if (methodPrefix != null) {
                char[] chars = methodName.substring(methodPrefix.length()).toCharArray();
                int pos = 0;
                while (pos < chars.length && Character.isUpperCase(chars[pos])) {
                    chars[pos] = Character.toLowerCase(chars[pos]);
                    pos++;
                }
                return new String(chars);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown Bean prefix for method: ");
            sb.append(methodName);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static Object convertToPlainJavaTypes(Object object) {
        return serialize(object);
    }

    public static Map<String, Object> convertToPlainJavaTypes(Map<String, Object> update) {
        Object converted = serialize(update);
        Utilities.hardAssert(converted instanceof Map);
        return (Map) converted;
    }

    public static <T> T convertToCustomClass(Object object, Class<T> clazz) {
        return deserializeToClass(object, clazz);
    }

    public static <T> T convertToCustomClass(Object object, GenericTypeIndicator<T> typeIndicator) {
        Type genericTypeIndicatorType = typeIndicator.getClass().getGenericSuperclass();
        String str = "Not a direct subclass of GenericTypeIndicator: ";
        if (genericTypeIndicatorType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericTypeIndicatorType;
            if (parameterizedType.getRawType().equals(GenericTypeIndicator.class)) {
                return deserializeToType(object, parameterizedType.getActualTypeArguments()[0]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(genericTypeIndicatorType);
            throw new DatabaseException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(genericTypeIndicatorType);
        throw new DatabaseException(sb2.toString());
    }

    /* access modifiers changed from: private */
    public static <T> Object serialize(T o) {
        if (o == null) {
            return null;
        }
        if (o instanceof Number) {
            if ((o instanceof Float) || (o instanceof Double)) {
                double doubleValue = ((Number) o).doubleValue();
                if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d || Math.floor(doubleValue) != doubleValue) {
                    return Double.valueOf(doubleValue);
                }
                return Long.valueOf(((Number) o).longValue());
            } else if (o instanceof Short) {
                throw new DatabaseException("Shorts are not supported, please use int or long");
            } else if (!(o instanceof Byte)) {
                return o;
            } else {
                throw new DatabaseException("Bytes are not supported, please use int or long");
            }
        } else if ((o instanceof String) || (o instanceof Boolean)) {
            return o;
        } else {
            if (o instanceof Character) {
                throw new DatabaseException("Characters are not supported, please use Strings");
            } else if (o instanceof Map) {
                Map<String, Object> result = new HashMap<>();
                for (Entry<Object, Object> entry : ((Map) o).entrySet()) {
                    Object key = entry.getKey();
                    if (key instanceof String) {
                        result.put((String) key, serialize(entry.getValue()));
                    } else {
                        throw new DatabaseException("Maps with non-string keys are not supported");
                    }
                }
                return result;
            } else if (o instanceof Collection) {
                if (o instanceof List) {
                    List<Object> list = o;
                    List<Object> result2 = new ArrayList<>(list.size());
                    for (Object object : list) {
                        result2.add(serialize(object));
                    }
                    return result2;
                }
                throw new DatabaseException("Serializing Collections is not supported, please use Lists instead");
            } else if (o.getClass().isArray()) {
                throw new DatabaseException("Serializing Arrays is not supported, please use Lists instead");
            } else if (o instanceof Enum) {
                return ((Enum) o).name();
            } else {
                return loadOrCreateBeanMapperForClass(o.getClass()).serialize(o);
            }
        }
    }

    /* access modifiers changed from: private */
    public static <T> T deserializeToType(Object o, Type type) {
        if (o == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return deserializeToParameterizedType(o, (ParameterizedType) type);
        }
        if (type instanceof Class) {
            return deserializeToClass(o, (Class) type);
        }
        if (type instanceof WildcardType) {
            throw new DatabaseException("Generic wildcard types are not supported");
        } else if (type instanceof GenericArrayType) {
            throw new DatabaseException("Generic Arrays are not supported, please use Lists instead");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown type encountered: ");
            sb.append(type);
            throw new IllegalStateException(sb.toString());
        }
    }

    private static <T> T deserializeToClass(Object o, Class<T> clazz) {
        if (o == null) {
            return null;
        }
        if (clazz.isPrimitive() || Number.class.isAssignableFrom(clazz) || Boolean.class.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz)) {
            return deserializeToPrimitive(o, clazz);
        }
        if (String.class.isAssignableFrom(clazz)) {
            return convertString(o);
        }
        if (clazz.isArray()) {
            throw new DatabaseException("Converting to Arrays is not supported, please use Listsinstead");
        } else if (clazz.getTypeParameters().length > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Class ");
            sb.append(clazz.getName());
            sb.append(" has generic type parameters, please use GenericTypeIndicator instead");
            throw new DatabaseException(sb.toString());
        } else if (clazz.equals(Object.class)) {
            return o;
        } else {
            if (clazz.isEnum()) {
                return deserializeToEnum(o, clazz);
            }
            return convertBean(o, clazz);
        }
    }

    private static <T> T deserializeToParameterizedType(Object o, ParameterizedType type) {
        Class<?> rawType = (Class) type.getRawType();
        if (List.class.isAssignableFrom(rawType)) {
            Type genericType = type.getActualTypeArguments()[0];
            if (o instanceof List) {
                List<Object> list = (List) o;
                List<Object> result = new ArrayList<>(list.size());
                for (Object object : list) {
                    result.add(deserializeToType(object, genericType));
                }
                return result;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a List while deserializing, but got a ");
            sb.append(o.getClass());
            throw new DatabaseException(sb.toString());
        } else if (Map.class.isAssignableFrom(rawType)) {
            Type keyType = type.getActualTypeArguments()[0];
            Type valueType = type.getActualTypeArguments()[1];
            if (keyType.equals(String.class)) {
                Map<String, Object> map = expectMap(o);
                HashMap<String, Object> result2 = new HashMap<>();
                for (Entry<String, Object> entry : map.entrySet()) {
                    result2.put((String) entry.getKey(), deserializeToType(entry.getValue(), valueType));
                }
                return result2;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Only Maps with string keys are supported, but found Map with key type ");
            sb2.append(keyType);
            throw new DatabaseException(sb2.toString());
        } else if (!Collection.class.isAssignableFrom(rawType)) {
            Map<String, Object> map2 = expectMap(o);
            BeanMapper<T> mapper = loadOrCreateBeanMapperForClass(rawType);
            HashMap<TypeVariable<Class<T>>, Type> typeMapping = new HashMap<>();
            TypeVariable<Class<T>>[] typeVariables = mapper.clazz.getTypeParameters();
            Type[] types = type.getActualTypeArguments();
            if (types.length == typeVariables.length) {
                for (int i = 0; i < typeVariables.length; i++) {
                    typeMapping.put(typeVariables[i], types[i]);
                }
                return mapper.deserialize(map2, typeMapping);
            }
            throw new IllegalStateException("Mismatched lengths for type variables and actual types");
        } else {
            throw new DatabaseException("Collections are not supported, please use Lists instead");
        }
    }

    private static <T> T deserializeToPrimitive(Object o, Class<T> clazz) {
        if (Integer.class.isAssignableFrom(clazz) || Integer.TYPE.isAssignableFrom(clazz)) {
            return convertInteger(o);
        }
        if (Boolean.class.isAssignableFrom(clazz) || Boolean.TYPE.isAssignableFrom(clazz)) {
            return convertBoolean(o);
        }
        if (Double.class.isAssignableFrom(clazz) || Double.TYPE.isAssignableFrom(clazz)) {
            return convertDouble(o);
        }
        if (Long.class.isAssignableFrom(clazz) || Long.TYPE.isAssignableFrom(clazz)) {
            return convertLong(o);
        }
        if (Float.class.isAssignableFrom(clazz) || Float.TYPE.isAssignableFrom(clazz)) {
            return Float.valueOf(convertDouble(o).floatValue());
        }
        if (Short.class.isAssignableFrom(clazz) || Short.TYPE.isAssignableFrom(clazz)) {
            throw new DatabaseException("Deserializing to shorts is not supported");
        } else if (Byte.class.isAssignableFrom(clazz) || Byte.TYPE.isAssignableFrom(clazz)) {
            throw new DatabaseException("Deserializing to bytes is not supported");
        } else if (Character.class.isAssignableFrom(clazz) || Character.TYPE.isAssignableFrom(clazz)) {
            throw new DatabaseException("Deserializing to char is not supported");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown primitive type: ");
            sb.append(clazz);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private static <T> T deserializeToEnum(Object object, Class<T> clazz) {
        if (object instanceof String) {
            String value = (String) object;
            try {
                return Enum.valueOf(clazz, value);
            } catch (IllegalArgumentException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not find enum value of ");
                sb.append(clazz.getName());
                sb.append(" for value \"");
                sb.append(value);
                sb.append("\"");
                throw new DatabaseException(sb.toString());
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Expected a String while deserializing to enum ");
            sb2.append(clazz);
            sb2.append(" but got a ");
            sb2.append(object.getClass());
            throw new DatabaseException(sb2.toString());
        }
    }

    private static <T> BeanMapper<T> loadOrCreateBeanMapperForClass(Class<T> clazz) {
        BeanMapper<T> mapper = (BeanMapper) mappers.get(clazz);
        if (mapper != null) {
            return mapper;
        }
        BeanMapper beanMapper = new BeanMapper(clazz);
        mappers.put(clazz, beanMapper);
        return beanMapper;
    }

    private static Map<String, Object> expectMap(Object object) {
        if (object instanceof Map) {
            return (Map) object;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected a Map while deserializing, but got a ");
        sb.append(object.getClass());
        throw new DatabaseException(sb.toString());
    }

    private static Integer convertInteger(Object o) {
        if (o instanceof Integer) {
            return (Integer) o;
        }
        if ((o instanceof Long) || (o instanceof Double)) {
            double value = ((Number) o).doubleValue();
            if (value >= -2.147483648E9d && value <= 2.147483647E9d) {
                return Integer.valueOf(((Number) o).intValue());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Numeric value out of 32-bit integer range: ");
            sb.append(value);
            sb.append(". Did you mean to use a long or double instead of an int?");
            throw new DatabaseException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to convert a value of type ");
        sb2.append(o.getClass().getName());
        sb2.append(" to int");
        throw new DatabaseException(sb2.toString());
    }

    private static Long convertLong(Object o) {
        if (o instanceof Integer) {
            return Long.valueOf(((Integer) o).longValue());
        }
        if (o instanceof Long) {
            return (Long) o;
        }
        if (o instanceof Double) {
            Double value = (Double) o;
            if (value.doubleValue() >= -9.223372036854776E18d && value.doubleValue() <= 9.223372036854776E18d) {
                return Long.valueOf(value.longValue());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Numeric value out of 64-bit long range: ");
            sb.append(value);
            sb.append(". Did you mean to use a double instead of a long?");
            throw new DatabaseException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Failed to convert a value of type ");
        sb2.append(o.getClass().getName());
        sb2.append(" to long");
        throw new DatabaseException(sb2.toString());
    }

    private static Double convertDouble(Object o) {
        if (o instanceof Integer) {
            return Double.valueOf(((Integer) o).doubleValue());
        }
        if (o instanceof Long) {
            Long value = (Long) o;
            Double doubleValue = Double.valueOf(((Long) o).doubleValue());
            if (doubleValue.longValue() == value.longValue()) {
                return doubleValue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Loss of precision while converting number to double: ");
            sb.append(o);
            sb.append(". Did you mean to use a 64-bit long instead?");
            throw new DatabaseException(sb.toString());
        } else if (o instanceof Double) {
            return (Double) o;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to convert a value of type ");
            sb2.append(o.getClass().getName());
            sb2.append(" to double");
            throw new DatabaseException(sb2.toString());
        }
    }

    private static Boolean convertBoolean(Object o) {
        if (o instanceof Boolean) {
            return (Boolean) o;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to convert value of type ");
        sb.append(o.getClass().getName());
        sb.append(" to boolean");
        throw new DatabaseException(sb.toString());
    }

    private static String convertString(Object o) {
        if (o instanceof String) {
            return (String) o;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to convert value of type ");
        sb.append(o.getClass().getName());
        sb.append(" to String");
        throw new DatabaseException(sb.toString());
    }

    private static <T> T convertBean(Object o, Class<T> clazz) {
        BeanMapper<T> mapper = loadOrCreateBeanMapperForClass(clazz);
        if (o instanceof Map) {
            return mapper.deserialize(expectMap(o));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't convert object of type ");
        sb.append(o.getClass().getName());
        sb.append(" to type ");
        sb.append(clazz.getName());
        throw new DatabaseException(sb.toString());
    }
}
