package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Parser {

    public static String getFixture(String file) throws IOException {
        Path filepath = getFixturePath(file);
        if (!Files.exists(filepath)) {
            throw new IOException("Файл не найден: " + filepath);
        }
        return Files.readString(filepath);
    }

    public static Path getFixturePath(String file) {
        String path = "src/main/resources/";
        if (file.startsWith("test")) {
            path = "src/test/resources/";
        }
        return Paths.get(path, file);
    }
}
