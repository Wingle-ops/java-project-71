package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static final String ERROR = "Полученный ответ не соотвествует ожидаемому\n";

    @Test
    public void test1() throws IOException { // Тест файлов Json с форматом вывода stylish
        String format = "stylish";
        String answer = Files.readString(Paths.get("src/test/resources/testStylish.stylish")).trim();
        String result = Differ.generate("testFile1.json", "testFile2.json", format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test2() throws IOException { // Тест файлов Json с форматом вывода plain
        String format = "plain";
        String answer = Files.readString(Paths.get("src/test/resources/testPlain.plain")).trim();
        String result = Differ.generate("testFile1.json", "testFile2.json", format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test3() throws IOException { // Тест файлов Json с форматом вывода json
        String format = "json";
        String answer = Files.readString(Paths.get("src/test/resources/testJson.json")).trim();
        String result = Differ.generate("testFile1.json", "testFile2.json", format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test4() throws IOException { // Тест файлов Yml с форматом вывода stylish
        String format = "stylish";
        String answer = Files.readString(Paths.get("src/test/resources/testStylish.stylish")).trim();
        String result = Differ.generate("testFile1.yml", "testFile2.yml", format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test5() throws IOException { // Тест файлов Yml с форматом вывода plain
        String format = "plain";
        String answer = Files.readString(Paths.get("src/test/resources/testPlain.plain")).trim();
        String result = Differ.generate("testFile1.yml", "testFile2.yml", format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test6() throws IOException { // Тест файлов Yml с форматом вывода json
        String format = "json";
        String answer = Files.readString(Paths.get("src/test/resources/testJson.json")).trim();
        String result = Differ.generate("testFile1.yml", "testFile2.yml", format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test7() throws IOException { // Тест файлов Json и Yml с форматом вывода stylish
        String format = "stylish";
        String answer = Files.readString(Paths.get("src/test/resources/testStylish.stylish")).trim();
        String result = Differ.generate("testFile1.json", "testFile2.Yml", format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test8() throws IOException { // Тест файлов Json и Yml с форматом вывода plain
        String format = "stylish";
        String answer = Files.readString(Paths.get("src/test/resources/testPlain.plain")).trim();
        String result = Differ.generate("testFile1.json", "testFile2.Yml", format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test9() throws IOException { // Тест файлов Json и Yml с форматом вывода json
        String format = "stylish";
        String answer = Files.readString(Paths.get("src/test/resources/testJson.json")).trim();
        String result = Differ.generate("testFile1.json", "testFile2.Yml", format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test10() throws IOException { // Тест файлов Json с форматом вывода по умолчанию
        String answer = Files.readString(Paths.get("src/test/resources/testJson.json")).trim();
        String result = Differ.generate("testFile1.json", "testFile2.json");
        assertEquals(answer, result, ERROR);
    }
}
