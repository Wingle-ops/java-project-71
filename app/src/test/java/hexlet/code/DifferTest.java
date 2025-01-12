package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private final String error = "Полученный ответ не соотвествует ожидаемому";

    @Test
    public void test1() throws IOException {
        String filepathJson1 = "testFile1.json";
        String filepathJson2 = "testFile2.json";
        String result = Differ.generate(filepathJson1, filepathJson2);
        assertEquals(TestExpected.getTestFile(), result, error);
    }

    @Test
    public void test2() throws IOException {
        String filepathYaml1 = "testFile1.yml";
        String filepathYaml2 = "testFile2.yml";
        String result = Differ.generate(filepathYaml1, filepathYaml2);
        assertEquals(TestExpected.getTestFile(), result, error);
    }

    @Test
    public void test3() throws IOException {
        String filepathYaml1 = "testFile1.yml";
        String filepathJson2 = "testFile2.json";
        String result = Differ.generate(filepathYaml1, filepathJson2);
        assertEquals(TestExpected.getTestFile(), result, error);
    }
}
