package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    public static String generate(String file1, String file2) throws IOException {
        String data1 = YamlToJson.checkFormat(file1);
        String data2 = YamlToJson.checkFormat(file2);
        Map<String, Object> dataOnMap1 = getMap(data1);
        Map<String, Object> dataOnMap2 = getMap(data2);
        List<String> diff = getData(dataOnMap1, dataOnMap2);
        return String.join("\n", diff);
    }

    public static List<String> getData(Map<String, Object> dataOnMap1, Map<String, Object> dataOnMap2) {
        List<String> result = new ArrayList<>();
        result.add("{");
        Set<String> keys = new TreeSet<>(dataOnMap1.keySet());
        keys.addAll(dataOnMap2.keySet());
        char[] sym = {'+', '-', ' '};

        for (String key : keys) {
            String string = " " + key + ": ";
            boolean inMap1 = dataOnMap1.containsKey(key);
            boolean inMap2 = dataOnMap2.containsKey(key);
            if (inMap1 && inMap2) {
                if (dataOnMap1.get(key).equals(dataOnMap2.get(key))) {
                    result.add(sym[2] + string + dataOnMap1.get(key));
                } else {
                    result.add(sym[1] + string + dataOnMap1.get(key));
                    result.add(sym[0] + string + dataOnMap2.get(key));
                }
            } else if (inMap2) {
                result.add(sym[0] + string + dataOnMap2.get(key));
            } else {
                result.add(sym[1] + string + dataOnMap1.get(key));
            }
        }
        result.add("}");
        return result;
    }

    public static Map<String, Object> getMap(String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map;
        try {
            map = objectMapper.readValue(data, new TypeReference<>() { });
        } catch (IOException e) {
            throw new RuntimeException("Произошла ошибка во время конвертации в Map");
        }
        return map;
    }
}
