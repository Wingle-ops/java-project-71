package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static String error;
    private static String filepathJson1;
    private static String filepathJson2;
    private static String filepathYml1;
    private static String filepathYml2;

    @BeforeAll
    public static void beforeAll() {
        error = "Полученный ответ не соотвествует ожидаемому\n";
        filepathJson1 = "testFile1.json";
        filepathJson2 = "testFile2.json";
        filepathYml1 = "testFile1.yml";
        filepathYml2 = "testFile2.yml";
    }

    @Test
    public void test1() throws IOException { // Тест файлов Json с форматом вывода stylish
        String format = "stylish";
        String result = Differ.generate(filepathJson1, filepathJson2, format);
        assertEquals(TestExpected.getTestStylish(), result, error);
    }

    @Test
    public void test2() throws IOException { // Тест файлов Yml с форматом вывода stylish
        String format = "stylish";
        String result = Differ.generate(filepathYml1, filepathYml2, format);
        assertEquals(TestExpected.getTestStylish(), result, error);
    }

    @Test
    public void test3() throws IOException { // Тест различных файлов Json и Yml с форматом вывода stylish
        String format = "stylish";
        String result = Differ.generate(filepathJson1, filepathYml2, format);
        assertEquals(TestExpected.getTestStylish(), result, error);
    }

    @Test
    public void test4() throws IOException { // Тест без указания формата вывода
        String result = Differ.generate(filepathJson1, filepathJson2);
        assertEquals(TestExpected.getTestStylish(), result, error);
    }

    @Test
    public void test5() throws IOException { // Тест файлов Json с форматом вывода plain
        String format = "plain";
        String result = Differ.generate(filepathJson1, filepathJson2, format);
        assertEquals(TestExpected.getTestPlain(), result, error);
    }

    @Test
    public void test6() throws IOException { // Тест файлов Yml с форматом вывода plain
        String format = "plain";
        String result = Differ.generate(filepathYml1, filepathYml2, format);
        assertEquals(TestExpected.getTestPlain(), result, error);
    }

    @Test
    public void test7() throws IOException { // Тест различных файлов Json и Yml с форматом вывода plain
        String format = "plain";
        String result = Differ.generate(filepathJson1, filepathYml2, format);
        assertEquals(TestExpected.getTestPlain(), result, error);
    }

    @Test
    public void test8() throws IOException { // Тест файлов Json с форматом вывода json
        String format = "json";
        String result = Differ.generate(filepathJson1, filepathJson2, format);
        assertEquals(TestExpected.getTestJson(), result, error);
    }

    @Test
    public void test9() throws IOException { // Тест файлов Yml с форматом вывода json
        String format = "json";
        String result = Differ.generate(filepathYml1, filepathYml2, format);
        assertEquals(TestExpected.getTestJson(), result, error);
    }

    @Test
    public void test10() throws IOException { // Тест различных файлов Json и Yml с форматом вывода json
        String format = "json";
        String result = Differ.generate(filepathJson1, filepathYml2, format);
        assertEquals(TestExpected.getTestJson(), result, error);
    }
}
