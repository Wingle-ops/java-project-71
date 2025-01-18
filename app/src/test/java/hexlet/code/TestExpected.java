package hexlet.code;

public class TestExpected {

    public static String getTestStylish() {
        return """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
    }

    public static String getTestPlain() {
        return """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";
    }

    public static String getTestJson() {
        return """
                {
                  "setting1" : "Some value",
                  "setting2" : 200,
                  "setting3" : true,
                  "key1" : "value1",
                  "numbers1" : [ 1, 2, 3, 4 ],
                  "numbers2" : [ 2, 3, 4, 5 ],
                  "id" : 45,
                  "default" : null,
                  "checked" : false,
                  "numbers3" : [ 3, 4, 5 ],
                  "chars1" : [ "a", "b", "c" ],
                  "chars2" : [ "d", "e", "f" ]
                }
                {
                  "setting1" : "Another value",
                  "setting2" : 300,
                  "setting3" : "none",
                  "key2" : "value2",
                  "numbers1" : [ 1, 2, 3, 4 ],
                  "numbers2" : [ 22, 33, 44, 55 ],
                  "id" : null,
                  "default" : [ "value1", "value2" ],
                  "checked" : true,
                  "numbers4" : [ 4, 5, 6 ],
                  "chars1" : [ "a", "b", "c" ],
                  "chars2" : false,
                  "obj1" : {
                    "nestedKey" : "value",
                    "isNested" : true
                  }
                }""";
    }
}
