package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashMap;
import java.util.Objects;

public class SimileFiles {

    public static List<Map<String, Object>> simile(Map<String, Object> dataOnMap1, Map<String, Object> dataOnMap2) {
        List<Map<String, Object>> result = new ArrayList<>();
        Set<String> keys = new TreeSet<>(dataOnMap1.keySet());
        keys.addAll(dataOnMap2.keySet());

        for (String key : keys) {
            Object value1 = dataOnMap1.get(key);
            Object value2 = dataOnMap2.get(key);
            Map<String, Object> map = new LinkedHashMap<>();

            if (!dataOnMap1.containsKey(key)) {
                map.put("key", key);
                map.put("value2", value2);
                map.put("operation", "added");
                result.add(map);
            } else if (!dataOnMap2.containsKey(key)) {
                map.put("key", key);
                map.put("value1", value1);
                map.put("operation", "removed");
                result.add(map);
            } else if (!Objects.equals(value1, value2)) {
                map.put("key", key);
                map.put("value1", value1);
                map.put("value2", value2);
                map.put("operation", "updated");
                result.add(map);
            } else {
                map.put("key", key);
                map.put("value2", value2);
                map.put("operation", "constant");
                result.add(map);
            }
        }
        return result;
    }
}
