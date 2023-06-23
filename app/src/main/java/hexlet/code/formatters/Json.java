package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.MapComparator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Json {

    public static String formatToJson(Map<String, Object> file1, Map<String, Object> file2)
            throws JsonProcessingException {
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
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(result);
    }
}
