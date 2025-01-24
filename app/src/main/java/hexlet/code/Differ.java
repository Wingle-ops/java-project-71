package hexlet.code;

import static hexlet.code.SimileFiles.simile;

import java.io.IOException;
import java.util.Map;

public class Differ {

    public static String generate(String file1, String file2, String format) throws IOException {
        Map<String, Object> dataOnMap1 = Parser.getData(file1);
        Map<String, Object> dataOnMap2 = Parser.getData(file2);
        return Formatter.getFormat(simile(dataOnMap1, dataOnMap2), format);
    }

    public static String generate(String file1, String file2) throws IOException {
        return generate(file1, file2, "stylish");
    }
}
