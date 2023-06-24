package hexlet.code;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class MapComparator {

    public static List<Map<String, Object>> mapDiff(Map<String, Object> file1, Map<String, Object> file2) {
        List<Map<String, Object>> result = new ArrayList<>();
        Set<String> unionKeys = new TreeSet<>();
        unionKeys.addAll(file1.keySet());
        unionKeys.addAll(file2.keySet());
        for (String key : unionKeys) {
            if (file1.keySet().contains(key) && Objects.equals(file1.get(key), file2.get(key))) {
                Map<String, Object> map = new HashMap<>();
                map.put("field", key);
                map.put("status", "same");
                map.put("old value", file1.get(key));
                result.add(map);
            } else if (file1.keySet().contains(key) && !file2.keySet().contains(key)) {
                Map<String, Object> map = new HashMap<>();
                map.put("field", key);
                map.put("status", "removed");
                map.put("old value", file1.get(key));
                result.add(map);
            } else if (file2.keySet().contains(key) && !file1.keySet().contains(key)) {
                Map<String, Object> map = new HashMap<>();
                map.put("field", key);
                map.put("status", "added");
                map.put("new value", file2.get(key));
                result.add(map);
            } else if (file1.keySet().contains(key) && file2.keySet().contains(key)) {
                Map<String, Object> map = new HashMap<>();
                map.put("field", key);
                map.put("status", "updated");
                map.put("old value", file1.get(key));
                map.put("new value", file2.get(key));
                result.add(map);
            }
        }
        return result;
    }
}
