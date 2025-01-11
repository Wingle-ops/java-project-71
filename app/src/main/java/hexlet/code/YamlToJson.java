package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;

public class YamlToJson {

    public static String checkFormat(String filePath) throws IOException {
        if (filePath.endsWith(".yaml") || filePath.endsWith(".yml")) {
            return yamlToJson(filePath);
        }
        return Differ.getFixture(filePath);
    }

    public static String yamlToJson(String file) throws JsonProcessingException {
        ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
        Object obj = yamlReader.readValue(file, Object.class);

        ObjectMapper jsonWriter = new ObjectMapper();
        return jsonWriter.writeValueAsString(obj);
    }
}
