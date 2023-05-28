package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;

import static hexlet.code.Parser.getJsonData;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParserTest {

    @Test
    public void getJsonDataTest() throws Exception {
        String path = "src/test/resources";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        String filepath1 = absolutePath + "/test1.json";
        String filepath2 = absolutePath + "/test2.json";
        Map<String, Object> file1 = Map.of(
                "date_end", "2020-06-10T23:59:59+03:00",
                "description", "product1",
                "discount_label", "1+1",
                "id", 11111
        );
        Map<String, Object> file2 = Map.of(
                "barcode", "3113097501031",
                "description", "product2",
                "discount_label", "1+1",
                "price_is_from", false
        );
        assertThat(getJsonData(filepath1)).isEqualTo(file1);
        assertThat(getJsonData(filepath2)).isEqualTo(file2);
    }
}
