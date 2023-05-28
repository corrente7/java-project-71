package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.util.Map;

public class Parser {

    public static Map getJsonData(String filepath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map
                = objectMapper.readValue(new File(filepath), new TypeReference<Map<String, Object>>() { });
        return map;
    }

    public static Map getYamlData(String filepath) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        Map<String, Object> map
                = mapper.readValue(new File(filepath), new TypeReference<Map<String, Object>>() { });
        return map;
    }
    public static Map detectTypeFile(String filepath) throws Exception {
        Map<String, Object> map = null;
        if (filepath.endsWith(".json")) {
            map = getJsonData(filepath);
        } else if (filepath.endsWith(".yaml")) {
            map = getYamlData(filepath);
        }
        return map;
    }

}