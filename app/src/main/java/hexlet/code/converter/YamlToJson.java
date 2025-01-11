package hexlet.code.converter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;

import hexlet.code.Differ;
import org.yaml.snakeyaml.Yaml;

public class YamlToJson {

    public static String checkFormat(String filepath) throws IOException {
        if (filepath.endsWith(".yaml")) {
            String result = yamlToJson(filepath);
            return Differ.getFixture(result);
        }
        return Differ.getFixture(filepath);
    }

    public static String yamlToJson(String filepath) {
        Yaml yaml = new Yaml();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Object data = yaml.load(Files.newInputStream(Path.of(filepath)));
            return objectMapper.writeValueAsString(data);
        } catch (IOException e) {
            throw new RuntimeException("Конвертирование файла в Json не удалось");
        }
    }
}
