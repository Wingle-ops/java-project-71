package hexlet.code.formatters;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Stylish {

    public static String getData(Map<String, Object> dataOnMap1, Map<String, Object> dataOnMap2) {
        StringBuilder result = new StringBuilder();
        result.append("{");
        Set<String> keys = new TreeSet<>(dataOnMap1.keySet());
        keys.addAll(dataOnMap2.keySet());

        for (String key : keys) {
            boolean keyInMap1 = dataOnMap1.containsKey(key);
            boolean keyInMap2 = dataOnMap2.containsKey(key);
            String string = " " + key + ": ";
            Object valueInMap1 = keyInMap1 ? dataOnMap1.get(key) : null;
            Object valueInMap2 = keyInMap2 ? dataOnMap2.get(key) : null;

            if (keyInMap1 && keyInMap2) {
                if (Objects.equals(valueInMap1, valueInMap2)) {
                    result.append("\n  ").append(" ").append(string).append(valueInMap1 == null ? "null" : valueInMap1);
                } else {
                    result.append("\n  ").append("-").append(string).append(valueInMap1 == null ? "null" : valueInMap1);
                    result.append("\n  ").append("+").append(string).append(valueInMap2 == null ? "null" : valueInMap2);
                }
            } else if (keyInMap2) {
                result.append("\n  ").append("+").append(string).append(valueInMap2 == null ? "null" : valueInMap2);
            } else {
                result.append("\n  ").append("-").append(string).append(valueInMap1 == null ? "null" : valueInMap1);
            }
        }
        return result.append("\n}").toString();
    }
}
