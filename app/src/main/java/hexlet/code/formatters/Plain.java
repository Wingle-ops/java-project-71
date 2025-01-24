package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {

    public static String getData(List<Map<String, Object>> data) {
        StringBuilder result = new StringBuilder();
        result.append("{");

        for (Map<String, Object> map : data) {
            String key = (String) map.get("key");
            Object value1 = getValue(map.get("value1"));
            Object value2 = getValue(map.get("value2"));
            String operation = (String) map.get("operation");

            switch (operation) {
                case "added" -> result.append("\n Property '").append(key)
                                      .append("' was added with value: ")
                                      .append(value2);

                case "removed" -> result.append("\n Property '").append(key).append("' was removed ");

                case "updated" -> result.append("\n Property '")
                                        .append(key).append("' was updated. From ").append(value1)
                                        .append(" to ").append(value2);

                default -> {
                }
            }
        }
        return String.valueOf(result.append("\n}"));
    }

    public static Object getValue(Object data) {
        if (data instanceof Boolean) {
            return data;
        } else if (data instanceof String) {
            return "'" + data + "'";
        } else if (data instanceof Number) {
            return data;
        } else if (data == null) {
            return null;
        }
        return "[complex value]";
    }
}
