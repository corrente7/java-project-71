package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import static hexlet.code.Parser.getJsonData;
import static hexlet.code.Parser.getYamlData;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParserTest {

    @Test
    public void getJsonDataTest() throws Exception {
        String path = "src/test/resources";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        String filepath1 = absolutePath + "/test1.json";
        String filepath2 = absolutePath + "/test2.json";
        Map<String, Object> expected1 = new LinkedHashMap<>();
        expected1.put("chars1", new String[] {"a", "b", "c"});
        expected1.put("chars2", new String[] {"d", "e", "f"});
        expected1.put("checked", false);
        expected1.put("date_end","2020-06-10T23:59:59+03:00");
        expected1.put("default", null);
        expected1.put("description", "product1");
        expected1.put("discount_label","1+1");
        expected1.put("id", 11111);
        expected1.put("numbers1", new int[] {1, 2, 3, 4});
        expected1.put("numbers2", new int[] {2, 3, 4, 5});
        expected1.put("numbers3", new int[] {3, 4, 5});
        Map<String, Object> expected2 = Map.of(
                "date_end", "2020-06-10T23:59:59+03:00",
                "description", "product1",
                "discount_label", "1+1",
                "id", 11111
        );
        assertThat(getJsonData(filepath1)).isEqualTo(expected1);
        //assertThat(getJsonData(filepath2)).isEqualTo(expected2);
    }
    @Test
    public void getYamlDataTest() throws Exception {
        String path = "src/test/resources";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        String filepath1 = absolutePath + "/test3.yaml";
        String filepath2 = absolutePath + "/test4.yaml";
        Map<String, Object> expected1 = Map.of(
                "id", 11,
                "name", "Liverpool",
                "numbers1", new int[]{1, 2, 3, 4},
                "to_id", 1,
                "to_name","LONDON"
        );
        Map<String, Object> expected2 = Map.of(
                "id", 11,
                "name", "Liverpool",
                "numbers1", new int[]{1, 2, 3, 4},
                "to_id", 1,
                "to_name","LONDON"
        );
        assertThat(getYamlData(filepath1)).isEqualTo(expected1);
        //assertThat(getJsonData(filepath2)).isEqualTo(expected2);
    }
}
