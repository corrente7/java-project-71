package hexlet.code.formatters;

import hexlet.code.Differ;

import java.util.Map;

public class Stylish {

    public static String formatToStylish(Map<String, Object> file1, Map<String, Object> file2) {
        Map<String, Object> map = Differ.mapDiff(file1, file2);
        String all = "";
        for (Map.Entry<String, Object> entry: map.entrySet()) {
            String str = "  " + entry.getKey() + ": "  +  entry.getValue() + '\n';
            all = all.concat(str);
        }
        return "{\n" + all + "}";
    }
}
