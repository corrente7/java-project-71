package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Differ;
import java.util.Map;

public class Json {

    public static String formatToJson(Map<String, Object> file1, Map<String, Object> file2)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(Submethods.mapDiff(file1, file2));
    }
}
