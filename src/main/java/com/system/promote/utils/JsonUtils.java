package com.system.promote.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * @author xutao
 * created 2019/9/29 18:35
 */
public class JsonUtils {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final ObjectWriter WRITER ;

    static {
        WRITER = MAPPER.writerWithDefaultPrettyPrinter();
        MAPPER.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        MAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        MAPPER.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
        MAPPER.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
        MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static String toJson(Object obj) {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    public static String toJsonString(Object value) {
        try {
            return WRITER.writeValueAsString(value);
        } catch (Exception var2) {
            throw new IllegalStateException(var2);
        }
    }

    public static <T> T toBean(String json, Class<T> cls) {
        try {
            return MAPPER.readValue(json, cls);
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }

    public static <T> T toBean(String json, TypeReference<T> type) {
        try {
            return MAPPER.readValue(json, type);
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }

    public static <T> T toBean(Object object, Class<T> cls) {
        try {
            return MAPPER.readValue(toJson(object), cls);
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }

    public static <T> T toBean(Object object, TypeReference<T> type) {
        try {
            return MAPPER.readValue(toJson(object), type);
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }
}
