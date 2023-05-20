package hexlet.code;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;


public class Differ {

    public static Map getData(String filename) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map
                = objectMapper.readValue(new File(filename), new TypeReference<Map<String, Object>>() { });
        return map;
    }

    public static Map<String, Object> generate(Map<String, Object> file1, Map<String, Object> file2) {
        Map<String, Object> result = new LinkedHashMap<>();

        Set<String> unionKeys = new HashSet<>();
        unionKeys.addAll(file1.keySet());
        unionKeys.addAll(file2.keySet());
        unionKeys = unionKeys.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (String key: unionKeys) {
            if (file1.keySet().contains(key) && file1.get(key).equals(file2.get(key))) {
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

    public static String toString(Map<String, Object> hmap) {
        String all = "";
        if (hmap.isEmpty()) {
            return "{}";
        }
        for (Map.Entry<String, Object> entry: hmap.entrySet()) {
            String str = "  " + entry.getKey() + ": "  +  entry.getValue() + '\n';
            all = all.concat(str);
        }
        return "{\n" + all + "}";
    }
}
