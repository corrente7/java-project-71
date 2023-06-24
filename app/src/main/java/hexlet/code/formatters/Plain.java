package hexlet.code.formatters;

import hexlet.code.MapComparator;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Plain {

    public static String formatToPlain(List<Map<String, Object>> list) {
        List<String> result = new LinkedList<>();
        for (Map<String, Object> map: list) {
            if (map.get("status") == "updated") {
                result.add("Property '" + map.get("field") + "' was updated. "
                        + "From " + convertObjectToString(map.get("old value")) + " to "
                        + convertObjectToString(map.get("new value")));
            } else if (map.get("status") == "removed") {
                result.add("Property '" + map.get("field") + "' was removed");
            } else if (map.get("status") == "added") {
                result.add("Property '" + map.get("field")
                        + "' was added with value: " + convertObjectToString(map.get("new value")));
            }
        }
        String all = "";
        for (String item: result) {
            String str = item + '\n';
            all = all.concat(str);
        }
        return all.substring(0, all.length() - 1);
    }

    private static String convertObjectToString(Object object) {
        if (object == null) {
            return "null";
        }
        if (object instanceof String) {
            return "\'" + object + "\'";
        }
        if (object instanceof Map || object instanceof List) {
            return "[complex value]";
        }
        return object.toString();
    }
}
