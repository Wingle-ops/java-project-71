package hexlet.code;

import hexlet.code.converter.YamlToJson;
import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class DifferTest {

    private final String error = "Полученный ответ не соотвествует ожидаемому";

    @Test
    public void test1() throws IOException {
        String filepathJson1 = "src/test/resources/file1.json";
        String filepathJson2 = "src/test/resources/file1.json";
        String result = Differ.generate(filepathJson1, filepathJson2);
        assertEquals(error, TestExpected.getTestFile(), result);
    }

    @Test
    public void test2() {
        String filepathJson1 = "src/test/resources/file1.json";
        String filepathYaml2 = "src/test/resources/file2.yaml";
        try {
            String filepathJson2 = YamlToJson.yamlToJson(filepathYaml2);
            String result = Differ.generate(filepathJson1, filepathJson2);
            assertEquals(error, TestExpected.getTestFile(), result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
