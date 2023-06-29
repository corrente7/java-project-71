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
    private static String EXPECTED_JSON;
    private static String EXPECTED_PLAIN;
    private static String EXPECTED_STYLISH;
    @BeforeAll
    public static void beforeAll() throws IOException {
        EXPECTED_JSON = readFile("src/test/resources/test_json");
        EXPECTED_PLAIN = readFile("src/test/resources/test_plain");
        EXPECTED_STYLISH = readFile("src/test/resources/test_stylish");
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
        assertEquals(EXPECTED_PLAIN, Differ.generate(filepathInput1, filepathInput2, "plain"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateStylishTest(String extension) throws Exception {
        String filepathInput1 = absolutePath + "/test1." + extension;
        String filepathInput2 = absolutePath + "/test2." + extension;

        assertEquals(EXPECTED_STYLISH, Differ.generate(filepathInput1, filepathInput2, "stylish"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateJsonTest(String extension) throws Exception {
        String filepathInput1 = absolutePath + "/test1." + extension;
        String filepathInput2 = absolutePath + "/test2." + extension;

        assertEquals(EXPECTED_JSON, Differ.generate(filepathInput1, filepathInput2, "json"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void generateDefaultTest(String extension) throws Exception {
        String filepathInput1 = absolutePath + "/test1." + extension;
        String filepathInput2 = absolutePath + "/test2." + extension;

        assertEquals(EXPECTED_STYLISH, Differ.generate(filepathInput1, filepathInput2));
    }
}
