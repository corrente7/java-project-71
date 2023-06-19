package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class DifferTest {

    private String filepathInput1;
    private String filepathInput2;
    private String absolutePath;
    static final String EXPECTED_JSON = "/test_json";
    static final String EXPECTED_PLAIN = "/test_plain";
    static final String EXPECTED_STYLISH = "/test_stylish";

    @BeforeEach
    void initEach() throws IOException {
        String path = "src/test/resources";
        File file = new File(path);
        absolutePath = file.getAbsolutePath();
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateJsonPlainTest(String extension) throws Exception {
        filepathInput1 = absolutePath + "/test1." + extension;
        filepathInput2 = absolutePath + "/test2." + extension;
        String filepath3 = absolutePath + EXPECTED_PLAIN;
        String expected = Files.readString(Paths.get(filepath3)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2, "plain"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateStylishTest(String extension) throws Exception {
        filepathInput1 = absolutePath + "/test1." + extension;
        filepathInput2 = absolutePath + "/test2." + extension;
        String filepath3 = absolutePath + EXPECTED_STYLISH;
        String expected = Files.readString(Paths.get(filepath3)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2, "stylish"));
        //assertThat(generate(filepathInput1, filepathInput2, format)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateJsonTest(String extension) throws Exception {
        filepathInput1 = absolutePath + "/test1." + extension;
        filepathInput2 = absolutePath + "/test2." + extension;
        String filepath3 = absolutePath + EXPECTED_JSON;
        String expected = Files.readString(Paths.get(filepath3)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2, "json"));
        //assertThat(generate(filepathInput1, filepathInput2, format)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateDefaultTest(String extension) throws Exception {
        filepathInput1 = absolutePath + "/test1." + extension;
        filepathInput2 = absolutePath + "/test2." + extension;
        String filepath3 = absolutePath + EXPECTED_STYLISH;
        String expected = Files.readString(Paths.get(filepath3)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2));
        //assertThat(generate(filepathInput1, filepathInput2, format)).isEqualTo(expected);
    }
}

