package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {

    public static String formatToStylish(List<Map<String, Object>> list) {
        StringBuilder strResult = new StringBuilder();
        for (Map<String, Object> map: list) {
            switch ((String) (map.get("status"))) {
                case ("same"):
                    strResult.append("  " + "  " + map.get("field") + ": " + map.get("old value") + '\n');
                    break;
                case ("removed"):
                    strResult.append("  " + "- " + map.get("field") + ": " + map.get("old value") + '\n');
                    break;
                case ("added"):
                    strResult.append("  " + "+ " + map.get("field") + ": " + map.get("new value") + '\n');
                    break;
                case ("updated"):
                    strResult.append("  " + "- " + map.get("field") + ": " + map.get("old value") + '\n');
                    strResult.append("  " + "+ " + map.get("field") + ": " + map.get("new value") + '\n');
                    break;
                default:
                    break;
            }
        }
        return "{\n" + strResult + "}";
    }
}
