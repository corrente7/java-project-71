package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


public final class DifferTest {

    private String filepathInput1;
    private String filepathInput2;
    private String absolutePath;

    @BeforeEach
    void initEach() throws IOException {
        String path = "src/test/resources";
        File file = new File(path);
        absolutePath = file.getAbsolutePath();
    }

    @Test
    public void generateJsonPlainTest() throws Exception {
        filepathInput1 = absolutePath + "/test1.json";
        filepathInput2 = absolutePath + "/test2.json";
        String filepath3 = absolutePath + "/test_json_plain";
        String expected = Files.readString(Paths.get(filepath3)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2, "plain"));

    }

    @Test
    public void generateJsonStylishTest() throws Exception {
        filepathInput1 = absolutePath + "/test1.json";
        filepathInput2 = absolutePath + "/test2.json";
        String filepath3 = absolutePath + "/test_json_stylish";
        String expected = Files.readString(Paths.get(filepath3)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2, "stylish"));
        //assertThat(generate(filepathInput1, filepathInput2, format)).isEqualTo(expected);
    }

    @Test
    public void generateJsonJsonTest() throws Exception {
        filepathInput1 = absolutePath + "/test1.json";
        filepathInput2 = absolutePath + "/test2.json";
        String filepath3 = absolutePath + "/test_json_json";
        String expected = Files.readString(Paths.get(filepath3)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2, "json"));
        //assertThat(generate(filepathInput1, filepathInput2, format)).isEqualTo(expected);
    }

    @Test
    public void generateJsonDefaultTest() throws Exception {
        filepathInput1 = absolutePath + "/test1.json";
        filepathInput2 = absolutePath + "/test2.json";
        String filepath3 = absolutePath + "/test_json_stylish";
        String expected = Files.readString(Paths.get(filepath3)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2));
        //assertThat(generate(filepathInput1, filepathInput2, format)).isEqualTo(expected);
    }

    @Test
    public void generateYamlPlainTest() throws Exception {
        filepathInput1 = absolutePath + "/test3.yml";
        filepathInput2 = absolutePath + "/test4.yml";
        String filepath3 = absolutePath + "/test_yml_plain";
        String expected = Files.readString(Paths.get(filepath3)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2, "plain"));
    }

    @Test
    public void generateYamlStylishTest() throws Exception {
        filepathInput1 = absolutePath + "/test3.yml";
        filepathInput2 = absolutePath + "/test4.yml";
        String filepath3 = absolutePath + "/test_yml_stylish";
        String expected = Files.readString(Paths.get(filepath3)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2, "stylish"));
    }

    @Test
    public void generateYamlJsonTest() throws Exception {
        filepathInput1 = absolutePath + "/test3.yml";
        filepathInput2 = absolutePath + "/test4.yml";
        String filepath3 = absolutePath + "/test_yml_json";
        String expected = Files.readString(Paths.get(filepath3)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2, "json"));
    }

    @Test
    public void generateYamlDefaultTest() throws Exception {
        filepathInput1 = absolutePath + "/test3.yml";
        filepathInput2 = absolutePath + "/test4.yml";
        String filepath3 = absolutePath + "/test_yml_stylish";
        String expected = Files.readString(Paths.get(filepath3)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2, "stylish"));
    }
}

