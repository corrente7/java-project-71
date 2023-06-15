package hexlet.code.formatters;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;

public class Submethods {

    static Set<String> sortKeys(Map<String, Object> file1, Map<String, Object> file2) {
        Set<String> unionKeys = new HashSet<>();
        unionKeys.addAll(file1.keySet());
        unionKeys.addAll(file2.keySet());
        return unionKeys.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    static Map<String, Object> mapDiff(Map<String, Object> file1, Map<String, Object> file2) {
        Map<String, Object> result = new LinkedHashMap<>();
        Set<String> unionKeys = sortKeys(file1, file2);
        for (String key : unionKeys) {
            if (file1.keySet().contains(key) && !isNotEqual(file1, file2, key)) {
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

    static boolean isNotEqual(Map<String, Object> file1, Map<String, Object> file2, String key) {
        Object object1 = file1.get(key);
        Object object2 = file2.get(key);
        return (object1 == null || object2 == null ? object1 != object2 : !object1.equals(object2));
    }
}
