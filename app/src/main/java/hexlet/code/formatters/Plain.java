package hexlet.code.formatters;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Plain {

    public static String getData(Map<String, Object> dataOnMap1, Map<String, Object> dataOnMap2) {
        StringBuilder result = new StringBuilder();
        Set<String> keys = new TreeSet<>(dataOnMap1.keySet());
        keys.addAll(dataOnMap2.keySet());

        for (String key : keys) {
            boolean keyInMap1 = dataOnMap1.containsKey(key);
            boolean keyInMap2 = dataOnMap2.containsKey(key);
            Object valueInMap1 = keyInMap1 ? dataOnMap1.get(key) : null;
            Object valueInMap2 = keyInMap2 ? dataOnMap2.get(key) : null;

            if (keyInMap1 && keyInMap2) {
                if (!Objects.equals(valueInMap1, valueInMap2)) {
                    result.append("Property '" + key + "' was updated. ")
                          .append("From " + getValue(valueInMap1) + " to " + getValue(valueInMap2) + "\n");
                }
            } else if (keyInMap2) {
                result.append("Property '" + key + "' was added with value: " + getValue(valueInMap2) + "\n");
            } else {
                result.append("Property '" + key + "' was removed\n");
            }
        }
        return result.substring(0, result.length() - 1);
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
