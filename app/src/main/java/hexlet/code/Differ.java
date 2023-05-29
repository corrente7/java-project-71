package hexlet.code;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;


import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;

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

    public static Set<String> sortKeys(Map<String, Object> file1, Map<String, Object> file2) {
        Set<String> unionKeys = new HashSet<>();
        unionKeys.addAll(file1.keySet());
        unionKeys.addAll(file2.keySet());
        return unionKeys.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
    public static Map<String, Object> mapDiff(Map<String, Object> file1, Map<String, Object> file2) {
        Map<String, Object> result = new LinkedHashMap<>();
        Set<String> unionKeys = Differ.sortKeys(file1, file2);
        for (String key : unionKeys) {
            if (file1.keySet().contains(key) && !Differ.isNotEqual(file1, file2, key)) {
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
    public static boolean isNotEqual(Map<String, Object> file1, Map<String, Object> file2, String key) {
        Object object1 = file1.get(key);
        Object object2 = file2.get(key);
        return (object1 == null || object2 == null ? object1 != object2 : !object1.equals(object2));
    }
}
