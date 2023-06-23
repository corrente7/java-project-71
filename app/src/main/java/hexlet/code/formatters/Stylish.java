package hexlet.code.formatters;

import hexlet.code.MapComparator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Stylish {

    public static String formatToStylish(Map<String, Object> file1, Map<String, Object> file2) {
        List<Map<String, Object>> list = MapComparator.mapDiff(file1, file2);
        Map<String, Object> result = new LinkedHashMap<>();
        for (Map<String, Object> map: list) {
            if (map.get("status") == "same") {
                result.put("  " + map.get("field"), map.get("old value"));
            }
            if (map.get("status") == "removed") {
                result.put("- " + map.get("field"), map.get("old value"));
            }
            if (map.get("status") == "added") {
                result.put("+ " + map.get("field"), map.get("new value"));
            }
            if (map.get("status") == "updated") {
                result.put("- " + map.get("field"), map.get("old value"));
                result.put("+ " + map.get("field"), map.get("new value"));
            }
        }
        String all = "";
        for (Map.Entry<String, Object> entry: result.entrySet()) {
            String str = "  " + entry.getKey() + ": "  +  entry.getValue() + '\n';
            all = all.concat(str);
        }
        return "{\n" + all + "}";
    }
}
