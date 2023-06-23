package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class BaseFormatter {
    public static String selectFormat(String format, Map<String, Object> file1, Map<String, Object> file2)
            throws JsonProcessingException {
        return switch (format) {
            case "stylish" -> Stylish.formatToStylish(file1, file2);
            case "plain" -> Plain.formatToPlain(file1, file2);
            case "json" -> Json.formatToJson(file1, file2);
            default  ->  throw new Error(format + " is unsupported.");
        };
    }
}
