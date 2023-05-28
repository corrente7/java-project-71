package hexlet.code.formatters;

import hexlet.code.Differ;
import java.util.Map;

public class Stylish {

    public static String formatToStylish(Map<String, Object> file1, Map<String, Object> file2) {
        return toString(Differ.mapDiff(file1, file2));
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
