package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.*;
import java.util.stream.Collectors;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String extension1 = filepath1.substring(filepath1.indexOf('.'));
        String extension2 = filepath2.substring(filepath2.indexOf('.'));
        Map<String, Object> file1;
        Map<String, Object> file2;
        file1 = switch (extension1) {
            case ".json" -> Parser.getJsonData(filepath1);
            case ".yaml" -> Parser.getYamlData(filepath1);
            case ".yml" -> Parser.getYamlData(filepath1);
            default -> throw new Error("Format is unsupported.");
        };
        file2 = switch (extension2) {
            case ".json" -> Parser.getJsonData(filepath2);
            case ".yaml" -> Parser.getYamlData(filepath2);
            case ".yml" -> Parser.getYamlData(filepath2);
            default -> throw new Error("Format is unsupported.");
        };
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

    public static Map<String, Object> mapDiff(Map<String, Object> file1, Map<String, Object> file2) {
        Set<String> unionKeys = new HashSet<>();
        unionKeys.addAll(file1.keySet());
        unionKeys.addAll(file2.keySet());
        Set<String> unionKeys1 = unionKeys.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toCollection(TreeSet::new));
        Map<String, Object> result = new LinkedHashMap<>();
        for (String key : unionKeys1) {
            if (file1.keySet().contains(key) && Objects.equals(file1.get(key), file2.get(key))) {
                result.put("  " + key, file1.get(key));
            } else if (file1.keySet().contains(key) && !file2.keySet().contains(key)) {
                result.put("- " + key, file1.get(key));
            } else if (file2.keySet().contains(key) && !file1.keySet().contains(key)) {
                result.put("+ " + key, file2.get(key));
            } else if (file1.keySet().contains(key) && file2.keySet().contains(key)) {
                result.put("- " + key, file1.get(key));
                result.put("+ " + key, file2.get(key));
            }
        }
        return result;
    }
}
