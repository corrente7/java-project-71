package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class BaseFormatter {
    public static String selectFormat(String format, List<Map<String, Object>> list)
            throws JsonProcessingException {
        return switch (format) {
            case "stylish" -> Stylish.formatToStylish(list);
            case "plain" -> Plain.formatToPlain(list);
            case "json" -> Json.formatToJson(list);
            default  ->  throw new Error(format + " is unsupported.");
        };
    }
}
