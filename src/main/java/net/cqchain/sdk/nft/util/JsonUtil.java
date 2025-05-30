package net.cqchain.sdk.nft.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.lang.reflect.Field;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 通用方法：将任意对象按指定字段顺序序列化为 JSON 字符串（用于签名）
     *
     * @param obj           任意对象（POJO）
     * @param orderedFields 要保留的字段名（按顺序）
     * @return JSON 字符串
     */
    public static String toOrderedJson(Object obj, String[] orderedFields) {
        if (obj == null) {
            throw new IllegalArgumentException("对象不能为空");
        }

        ObjectNode node = objectMapper.createObjectNode();
        Class<?> clazz = obj.getClass();

        for (String fieldName : orderedFields) {
            try {
                Field field = getField(clazz, fieldName);
                if (field == null) {
                    continue; // 可选：字段不存在时跳过
                }
                field.setAccessible(true);
                Object value = field.get(obj);
                node.set(fieldName, objectMapper.valueToTree(value));
            } catch (Exception e) {
                throw new RuntimeException("序列化字段失败: " + fieldName, e);
            }
        }

        return node.toString(); // 输出标准 JSON 字符串
    }

    /**
     * 支持继承结构的字段查找
     */
    private static Field getField(Class<?> clazz, String fieldName) {
        while (clazz != null && clazz != Object.class) {
            try {
                return clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException ignored) {
                clazz = clazz.getSuperclass();
            }
        }
        return null;
    }
}
