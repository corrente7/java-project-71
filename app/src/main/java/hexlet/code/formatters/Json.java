package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.MapComparator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Json {

    public static String formatToJson(List<Map<String, Object>> list)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(list);
    }
}
