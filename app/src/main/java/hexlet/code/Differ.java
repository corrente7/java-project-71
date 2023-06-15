package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> file1 = Parser.detectTypeFile(filepath1);
        Map<String, Object> file2 = Parser.detectTypeFile(filepath2);
        return switch (format) {
            case "stylish" -> Stylish.formatToStylish(file1, file2);
            case "plain" -> Plain.formatToPlain(file1, file2);
            case "json" -> Json.formatToJson(file1, file2);
            default  ->  throw new Error(format + " is unsupported.");
        };
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }


}
