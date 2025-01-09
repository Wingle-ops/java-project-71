package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Differ {

    public static void generate(String Filepath1, String Filepath2) throws IOException {
        String data1 = getFixture(Filepath1);
        String data2 = getFixture(Filepath2);
        Map<String, Object> dataOnMap1= getMap(data1);
        Map<String, Object> dataOnMap2= getMap(data2);
        getData(dataOnMap1, dataOnMap2).forEach(System.out::println);
    }

    public static String getFixture(String file) throws IOException {
        Path filepath = Paths.get(file).toAbsolutePath().normalize();
        return Files.readString(filepath);
    }

    public static List<String> getData(Map<String, Object> dataOnMap1, Map<String, Object> dataOnMap2) {
        List<String> result = new ArrayList<>();
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
        return result;
    }

    public static Map<String, Object> getMap(String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        try {
            map = objectMapper.readValue(data, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
