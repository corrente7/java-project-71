package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;

import static hexlet.code.Differ.generate;
import static org.assertj.core.api.Assertions.assertThat;

import static hexlet.code.Differ.getData;


public class DifferTest {

    @Test
    public void getDataTest() throws Exception {
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
        assertThat(getData(filepath1)).isEqualTo(file1);
        assertThat(getData(filepath2)).isEqualTo(file2);
    }
    @Test
    public void generateTest() {
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
        String expected = "{\n" +
                "  + barcode: 3113097501031\n" +
                "  - date_end: 2020-06-10T23:59:59+03:00\n" +
                "  - description: product1\n" +
                "  + description: product2\n" +
                "    discount_label: 1+1\n" +
                "  - id: 11111\n" +
                "  + price_is_from: false\n" +
                "}";
        assertThat(generate(file1, file2)).isEqualTo(expected);
}


}
