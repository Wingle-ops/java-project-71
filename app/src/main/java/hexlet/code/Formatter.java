package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Json;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String getFormat(List<Map<String, Object>> data, String format) {
        return switch (format) {
            case "stylish" -> Stylish.getData(data);
            case "plain" -> Plain.getData(data);
            case "json" -> Json.getData(data);
            default -> "stylish";
        };
    }
}
