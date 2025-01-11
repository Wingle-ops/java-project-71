package hexlet.code;

public class TestExpected {

    public static String getTestFile() {
        return """
                  {
                  - host: wingle.ops
                  + host: wingle.aps
                    ip: 192.168.0.1
                    ipIsTrue: true
                  - number": 88888888
                  + timeout: 20
                  + linux: true
                  + years: 22
                }""";
    }
}
