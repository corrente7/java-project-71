package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Differ;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Json {
    public static String formatToJson(Map<String, Object> file1, Map<String, Object> file2)
            throws JsonProcessingException {
        Map<String, Object> result = new LinkedHashMap<>();
        Set<String> unionKeys = Differ.putSortedKeysToSet(file1, file2);
        for (String key : unionKeys) {
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
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(result);
    }
}
