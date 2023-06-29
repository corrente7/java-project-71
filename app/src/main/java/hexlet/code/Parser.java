package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.util.Map;

public class Parser {

    static Map getJsonData(String filepath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map
                = objectMapper.readValue(new File(filepath), new TypeReference<Map<String, Object>>() { });
        return map;
    }

    static Map getYamlData(String filepath) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        Map<String, Object> map
                = mapper.readValue(new File(filepath), new TypeReference<Map<String, Object>>() { });
        return map;
    }

    static Map parseData(String filepath, String extension) throws Exception {
        return switch (extension) {
            case ".json" -> Parser.getJsonData(filepath);
            case ".yaml" -> Parser.getYamlData(filepath);
            case ".yml" -> Parser.getYamlData(filepath);
            default -> throw new Error("Format is unsupported.");
        };
    }
}
