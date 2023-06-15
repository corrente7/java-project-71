package hexlet.code.formatters;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Plain {

    public static String formatToPlain(Map<String, Object> file1, Map<String, Object> file2) {
        List<String> result = new LinkedList<>();
        Set<String> unionKeys = Submethods.sortKeys(file1, file2);
        for (String key: unionKeys) {
            if (file1.keySet().contains(key) && !file2.keySet().contains(key)) {
                result.add("Property '" + key + "' was removed");
            } else if (file2.keySet().contains(key) && !file1.keySet().contains(key)) {
                result.add("Property '" + key + "' was added with value: " + replaceValues(file2.get(key)));
            } else if (file1.keySet().contains(key)
                            && file2.keySet().contains(key) && Submethods.isNotEqual(file1, file2, key)) {
                result.add("Property '" + key + "' was updated. "
                                + "From " + replaceValues(file1.get(key)) + " to " + replaceValues(file2.get(key)));
            }
        }
        return toString(result);
    }

    public static String toString(List<String> list) {
        String all = "";
        if (list.isEmpty()) {
            return "{}";
        }
        for (String item: list) {
            String str = item + '\n';
            all = all.concat(str);
        }
        return all.substring(0, all.length() - 1);
    }

    public static Object replaceValues(Object object) {
        if (object instanceof String) {
            return "\'" + object + "\'";
        } else if (object == null) {
            return null;
        } else if (object instanceof Integer || object instanceof Boolean) {
            return object;
        }
        return "[complex value]";
    }
}
