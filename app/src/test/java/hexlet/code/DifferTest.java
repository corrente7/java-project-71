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

    private String absolutePath;
    private String expectedJson;
    private String expectedPlain;
    private String expectedStylish;


    @BeforeEach
    void initEach() throws IOException {
        String path = "src/test/resources";
        File file = new File(path);
        absolutePath = file.getAbsolutePath();
        expectedJson = absolutePath + "/test_json";
        expectedPlain = absolutePath + "/test_plain";
        expectedStylish = absolutePath + "/test_stylish";
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generatePlainTest(String extension) throws Exception {
        String filepathInput1 = absolutePath + "/test1." + extension;
        String filepathInput2 = absolutePath + "/test2." + extension;
        String expected = Files.readString(Paths.get(expectedPlain)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2, "plain"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateStylishTest(String extension) throws Exception {
        String filepathInput1 = absolutePath + "/test1." + extension;
        String filepathInput2 = absolutePath + "/test2." + extension;
        String expected = Files.readString(Paths.get(expectedStylish)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2, "stylish"));
        //assertThat(generate(filepathInput1, filepathInput2, format)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateJsonTest(String extension) throws Exception {
        String filepathInput1 = absolutePath + "/test1." + extension;
        String filepathInput2 = absolutePath + "/test2." + extension;
        String expected = Files.readString(Paths.get(expectedJson)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2, "json"));
        //assertThat(generate(filepathInput1, filepathInput2, format)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateDefaultTest(String extension) throws Exception {
        String filepathInput1 = absolutePath + "/test1." + extension;
        String filepathInput2 = absolutePath + "/test2." + extension;
        String expected = Files.readString(Paths.get(expectedStylish)).replaceAll("\r\n", "\n");

        assertEquals(expected, Differ.generate(filepathInput1, filepathInput2));
        //assertThat(generate(filepathInput1, filepathInput2, format)).isEqualTo(expected);
    }
}

