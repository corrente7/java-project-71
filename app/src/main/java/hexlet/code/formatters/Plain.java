package hexlet.code.formatters;

import hexlet.code.Differ;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Plain {

    public static String formatToPlain(Map<String, Object> file1, Map<String, Object> file2) {
        Map<String, Object> map = Differ.mapDiff(file1, file2);
        List<String> result = new LinkedList<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getKey().contains("-") && map.containsKey("+ " + entry.getKey().substring(2))) {
                result.add("Property '" + entry.getKey().substring(2) + "' was updated. "
                        + "From " + replaceValues(entry.getValue()) + " to "
                        + replaceValues(map.get("+ " + entry.getKey().substring(2))));
            } else if (entry.getKey().contains("-") && !map.containsKey("+ " + entry.getKey().substring(2))) {
                result.add("Property '" + entry.getKey().substring(2) + "' was removed");
            } else if (entry.getKey().contains("+") && !map.containsKey("- " + entry.getKey().substring(2))) {
                result.add("Property '" + entry.getKey().substring(2)
                        + "' was added with value: " + replaceValues(entry.getValue()));
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
