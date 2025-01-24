package hexlet.code.formatters;

import java.util.Map;
import java.util.List;

public class Stylish {

    public static String getData(List<Map<String, Object>> data) {
        StringBuilder result = new StringBuilder();
        result.append("{");

        for (Map<String, Object> map : data) {
            String key = (String) map.get("key");
            Object value1 = map.get("value1");
            Object value2 = map.get("value2");
            String operation = (String) map.get("operation");

            switch (operation) {
                case "added" -> result.append("\n  + ").append(key).append(": ").append(value2);

                case "removed" -> result.append("\n  - ").append(key).append(": ").append(value1);

                case "updated" -> result.append("\n  - ").append(key).append(": ").append(value1)
                                        .append("\n  + ").append(key).append(": ").append(value2);

                default -> result.append("\n    ").append(key).append(": ").append(value2);
            }
        }

        return String.valueOf(result.append("\n}"));
    }
}
