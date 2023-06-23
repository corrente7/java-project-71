package hexlet.code.formatters;

import hexlet.code.MapComparator;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Plain {

    public static String formatToPlain(Map<String, Object> file1, Map<String, Object> file2) {
        List<Map<String, Object>> list = MapComparator.mapDiff(file1, file2);
        List<String> result = new LinkedList<>();
        for (Map<String, Object> map: list) {
            if (map.get("status") == "updated") {
                result.add("Property '" + map.get("field") + "' was updated. "
                        + "From " + replaceValues(map.get("old value")) + " to "
                        + replaceValues(map.get("new value")));
            } else if (map.get("status") == "removed") {
                result.add("Property '" + map.get("field") + "' was removed");
            } else if (map.get("status") == "added") {
                result.add("Property '" + map.get("field")
                        + "' was added with value: " + replaceValues(map.get("new value")));
            }
        }
        String all = "";
        if (result.isEmpty()) {
            return "{}";
        }
        for (String item: result) {
            String str = item + '\n';
            all = all.concat(str);
        }
        return all.substring(0, all.length() - 1);
    }

    private static Object replaceValues(Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof String) {
            return "\'" + object + "\'";
        }
        if (object instanceof Map || object instanceof List) {
            return "[complex value]";
        }
        return object;
    }
}
