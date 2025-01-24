package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> getData(String pathToFile) throws IOException {
        return pathToFile.endsWith(".json") ? getMapJson(pathToFile) : getMapYml(pathToFile);
    }

    public static Map<String, Object> getMapJson(String data) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(data), Map.class);
    }

    public static Map<String, Object> getMapYml(String data) throws IOException {
        ObjectMapper objectMapper = new YAMLMapper();
        return objectMapper.readValue(new File(data), Map.class);
    }
}
