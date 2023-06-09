package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
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
    private static String expectedJson;
    private static String expectedPlain;
    private static String expectedStylish;
    @BeforeAll
    public static void beforeAll() throws IOException {
        expectedJson = readFile("src/test/resources/test_json");
        expectedPlain = readFile("src/test/resources/test_plain");
        expectedStylish = readFile("src/test/resources/test_stylish");
    }


    @BeforeEach
    void initEach() throws IOException {
        String path = "src/test/resources";
        File file = new File(path);
        absolutePath = file.getAbsolutePath();

    }
    private static String readFile(String path) throws IOException {
        return Files.readString(Paths.get(path)).replaceAll("\r\n", "\n");
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generatePlainTest(String extension) throws Exception {
        String filepathInput1 = absolutePath + "/test1." + extension;
        String filepathInput2 = absolutePath + "/test2." + extension;
        assertEquals(expectedPlain, Differ.generate(filepathInput1, filepathInput2, "plain"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateStylishTest(String extension) throws Exception {
        String filepathInput1 = absolutePath + "/test1." + extension;
        String filepathInput2 = absolutePath + "/test2." + extension;

        assertEquals(expectedStylish, Differ.generate(filepathInput1, filepathInput2, "stylish"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateJsonTest(String extension) throws Exception {
        String filepathInput1 = absolutePath + "/test1." + extension;
        String filepathInput2 = absolutePath + "/test2." + extension;

        assertEquals(expectedJson, Differ.generate(filepathInput1, filepathInput2, "json"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateDefaultTest(String extension) throws Exception {
        String filepathInput1 = absolutePath + "/test1." + extension;
        String filepathInput2 = absolutePath + "/test2." + extension;

        assertEquals(expectedStylish, Differ.generate(filepathInput1, filepathInput2));
    }
}
