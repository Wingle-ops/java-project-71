package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Differ {

    public static String generate(String file1, String file2, String format) throws IOException {
        String data1 = checkFormat(file1);
        String data2 = checkFormat(file2);
        Map<String, Object> dataOnMap1 = getMap(data1);
        Map<String, Object> dataOnMap2 = getMap(data2);
        return Formatter.getFormat(dataOnMap1, dataOnMap2, format);
    }

    public static String generate(String file1, String file2) throws IOException {
        return generate(file1, file2, "stylish");
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

    public static String checkFormat(String file) throws IOException {
        if (file.endsWith(".yml")) {
            String convert = Parser.getFixture(file);
            return yamlToJson(convert);
        }
        return Parser.getFixture(file);
    }

    public static String yamlToJson(String file) throws JsonProcessingException {
        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Object obj = yamlReader.readValue(file, Object.class);
        ObjectMapper jsonWriter = new ObjectMapper();
        return jsonWriter.writeValueAsString(obj);
    }
}
