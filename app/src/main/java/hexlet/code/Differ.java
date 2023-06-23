package hexlet.code;

import java.util.Map;

public class Differ {

    private static String getExtension(String filepath) {
        return filepath.substring(filepath.indexOf('.'));
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String extension1 = getExtension(filepath1);
        String extension2 = getExtension(filepath2);
        Map<String, Object> file1 = Parser.detectTypeFile(filepath1, extension1);
        Map<String, Object> file2 = Parser.detectTypeFile(filepath2, extension2);
        return BaseFormatter.selectFormat(format, file1, file2);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
