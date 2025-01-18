package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Json {

    public static String getData(Map<String, Object> dataOnMap1, Map<String, Object> dataOnMap2) {
        ObjectMapper objectMapper = new ObjectMapper();
        StringBuilder result = new StringBuilder();
        try {
            result.append(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataOnMap1));
            result.append("\n");
            result.append(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataOnMap2));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
        return result.toString();
    }
}
