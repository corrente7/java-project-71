package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {

    public static String formatToPlain(List<Map<String, Object>> list) {
        StringBuilder strResult = new StringBuilder();
        for (Map<String, Object> map: list) {
            switch ((String) (map.get("status"))) {
                case("updated"):
                    strResult.append("Property '" + map.get("field") + "' was updated. "
                        + "From " + convertObjectToString(map.get("old value")) + " to "
                        + convertObjectToString(map.get("new value")) + '\n');
                    break;
                case("removed"):
                    strResult.append("Property '" + map.get("field") + "' was removed" + '\n');
                    break;
                case("added"):
                    strResult.append("Property '" + map.get("field")
                        + "' was added with value: " + convertObjectToString(map.get("new value")) + '\n');
                    break;
                default:
                    break;
            }
        }
        return strResult.substring(0, strResult.length() - 1);
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
