package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static final String ERROR = "Полученный ответ не соотвествует ожидаемому\n";

    public static String patGeN(String string) {
        return "src/test/resources/fixtures/" + string;
    }

    @Test
    public void test1() throws IOException { // Тест файлов Json с форматом вывода stylish
        String format = "stylish";
        String file1 = patGeN("testFile1.json");
        String file2 = patGeN("testFile2.json");
        String fileTest = patGeN("testStylish.stylish");
        String answer = Files.readString(Paths.get(fileTest)).trim();
        String result = Differ.generate(file1, file2, format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test2() throws IOException { // Тест файлов Json с форматом вывода plain
        String format = "plain";
        String file1 = patGeN("testFile1.json");
        String file2 = patGeN("testFile2.json");
        String fileTest = patGeN("testPlain.plain");
        String answer = Files.readString(Paths.get(fileTest)).trim();
        String result = Differ.generate(file1, file2, format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test3() throws IOException { // Тест файлов Json с форматом вывода json
        String format = "json";
        String file1 = patGeN("testFile1.json");
        String file2 = patGeN("testFile2.json");
        String fileTest = patGeN("testJson.json");
        String answer = Files.readString(Paths.get(fileTest)).trim();
        String result = Differ.generate(file1, file2, format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test4() throws IOException { // Тест файлов Yml с форматом вывода stylish
        String format = "stylish";
        String file1 = patGeN("testFile1.json");
        String file2 = patGeN("testFile2.yml");
        String fileTest = patGeN("testStylish.stylish");
        String answer = Files.readString(Paths.get(fileTest)).trim();
        String result = Differ.generate(file1, file2, format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test5() throws IOException { // Тест файлов Yml с форматом вывода plain
        String format = "plain";
        String file1 = patGeN("testFile1.yml");
        String file2 = patGeN("testFile2.yml");
        String fileTest = patGeN("testPlain.plain");
        String answer = Files.readString(Paths.get(fileTest)).trim();
        String result = Differ.generate(file1, file2, format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test6() throws IOException { // Тест файлов Yml с форматом вывода json
        String format = "json";
        String file1 = patGeN("testFile1.yml");
        String file2 = patGeN("testFile2.yml");
        String fileTest = patGeN("testJson.json");
        String answer = Files.readString(Paths.get(fileTest)).trim();
        String result = Differ.generate(file1, file2, format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test7() throws IOException { // Тест файлов Json и Yml с форматом вывода stylish
        String format = "stylish";
        String file1 = patGeN("testFile1.json");
        String file2 = patGeN("testFile2.yml");
        String fileTest = patGeN("testStylish.stylish");
        String answer = Files.readString(Paths.get(fileTest)).trim();
        String result = Differ.generate(file1, file2, format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test8() throws IOException { // Тест файлов Json и Yml с форматом вывода plain
        String format = "plain";
        String file1 = patGeN("testFile1.json");
        String file2 = patGeN("testFile2.yml");
        String fileTest = patGeN("testPlain.plain");
        String answer = Files.readString(Paths.get(fileTest)).trim();
        String result = Differ.generate(file1, file2, format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test9() throws IOException { // Тест файлов Json и Yml с форматом вывода json
        String format = "json";
        String file1 = patGeN("testFile1.json");
        String file2 = patGeN("testFile2.yml");
        String fileTest = patGeN("testJson.json");
        String answer = Files.readString(Paths.get(fileTest)).trim();
        String result = Differ.generate(file1, file2, format);
        assertEquals(answer, result, ERROR);
    }

    @Test
    public void test10() throws IOException { // Тест файлов Json с форматом вывода по умолчанию
        String file1 = patGeN("testFile1.json");
        String file2 = patGeN("testFile2.json");
        String fileTest = patGeN("testStylish.stylish");
        String answer = Files.readString(Paths.get(fileTest)).trim();
        String result = Differ.generate(file1, file2);
        assertEquals(answer, result, ERROR);
    }
}
