
 package hexlet.code;

//import org.junit.jupiter.api.Test;

//import java.io.File;
//import java.util.Map;
//
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;
import java.util.Set;

import static hexlet.code.Differ.*;
import static org.assertj.core.api.Assertions.assertThat;



public class DifferTest {

    @Test
    public void generateTest() throws Exception {
        String path = "src/test/resources";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        String filepath1 = absolutePath + "/test1.json";
        String filepath2 = absolutePath + "/test2.json";
        String expected = "\n" +
                "  Property 'barcode' was added with value: '3113097501031'\n"
                +
                "  Property 'chars2' was updated. From [complex value] to false\n"
                +
                "  Property 'checked' was updated. From false to true\n"
                +
                "  Property 'date_end' was removed\n"
                +
                "  Property 'default' was updated. From null to [complex value]\n"
                +
                "  Property 'description' was updated. From 'product1' to 'product2'\n"
                +
                "  Property 'id' was updated. From 11111 to null\n"
                +
                "  Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                +
                "  Property 'numbers3' was removed\n"
                +
                "  Property 'numbers4' was added with value: [complex value]\n"
                +
                "  Property 'obj1' was added with value: [complex value]\n"
                +
                "  Property 'price_is_from' was added with value: false\n";
        assertThat(generate(filepath1, filepath2, "plain")).isEqualTo(expected);
    }
    @Test
    public void sortKeysTest() {
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
        Set<String> expected = Set.of(
                "barcode",
                "date_end",
                "description",
                "discount_label",
                "id",
                "price_is_from"
        );
        assertThat(sortKeys(file1, file2)).isEqualTo(expected);
    }
    @Test
    public void mapDiffTest() {
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
        Map<String, Object> expected1 = Map.of(
                "  discount_label","1+1",
                "+ barcode", "3113097501031",
                "+ description", "product2",
                "+ price_is_from", false,
                "- date_end", "2020-06-10T23:59:59+03:00",
                "- description", "product1",
                "- id",11111
        );
        Map<String, Object> file3 = Map.of(
        );
        Map<String, Object> file4 = Map.of(
        );
        Map<String, Object> expected2 = Map.of(
        );
        assertThat(mapDiff(file1, file2)).isEqualTo(expected1);
        assertThat(mapDiff(file3, file4)).isEqualTo(expected2);
    }
    @Test
    public void isNotEqualTest() {
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
        assertThat(isNotEqual(file1, file2, "discount_label")).isFalse();
        assertThat(isNotEqual(file1, file2, "description")).isTrue();
    }
}

