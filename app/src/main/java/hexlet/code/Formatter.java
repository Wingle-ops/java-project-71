package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import hexlet.code.formatters.Json;

import java.util.Map;

public class Formatter {

    public static String getFormat(Map<String, Object> dataOnMap1, Map<String, Object> dataOnMap2, String format) {
        return switch (format) {
            case "stylish" -> Stylish.getData(dataOnMap1, dataOnMap2);
            case "plain" -> Plain.getData(dataOnMap1, dataOnMap2);
            case "json" -> Json.getData(dataOnMap1, dataOnMap2);
            default -> "stylish";
        };
    }
}
