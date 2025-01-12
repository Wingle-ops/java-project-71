package hexlet.code;

public class TestExpected {

    public static String getTestFile() {
        return """
                {
                - follow: false
                  host: hexlet.io
                - proxy: 123.234.53.22
                - timeout: 50
                + timeout: 20
                + verbose: true
                }""";
    }
}
