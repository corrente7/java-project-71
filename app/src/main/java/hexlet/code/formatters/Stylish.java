package hexlet.code.formatters;

import hexlet.code.Differ;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Stylish {

    public static String formatToStylish(Map<String, Object> file1, Map<String, Object> file2) {
        Map<String, Object> result = new LinkedHashMap<>();
        Set<String> unionKeys = Differ.putSortedKeysToSet(file1, file2);
        for (String key: unionKeys) {
            if (file1.keySet().contains(key) && !Differ.isEqual(file1, file2, key)) {
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
        return toString(result);
}
    public static String toString(Map<String, Object> map) {
        String all = "";
        if (map.isEmpty()) {
            return "{}";
        }
        for (Map.Entry<String, Object> entry: map.entrySet()) {
            String str = "  " + entry.getKey() + ": "  +  entry.getValue() + '\n';
            all = all.concat(str);
        }
        return "{\n" + all + "}";
    }
}
