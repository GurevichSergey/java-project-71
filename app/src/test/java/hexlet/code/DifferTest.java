package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {

    private final String pathJson1 = "src/test/resources/filepath1.json";
    private final String pathJson2 = "src/test/resources/filepath2.json";
    private final String pathYaml1 = "src/test/resources/filepath1.yml";
    private final String pathYaml2 = "src/test/resources/filepath2.yml";
    private final Path expectedStylish =
            Paths.get("src/test/resources/expected/expectedStylish").toAbsolutePath().normalize();
    private final Path expectedJson =
            Paths.get("src/test/resources/expected/expectedJson").toAbsolutePath().normalize();
    private final Path expectedPlain =
            Paths.get("src/test/resources/expected/expectedPlain").toAbsolutePath().normalize();

    @Test
    public void testGenerateDefault1() throws Exception {
        String expected = Files.readString(expectedStylish);
        assertEquals(expected, Differ.generate(pathJson1, pathJson2));
    }
    @Test
    public void testGenerateDefault2() throws Exception {
        String expected = Files.readString(expectedStylish);
        assertEquals(expected, Differ.generate(pathYaml1, pathYaml2));
    }
    @Test
    public void testGenerateStylish1() throws Exception {
        String expected = Files.readString(expectedStylish);
        assertEquals(expected, Differ.generate(pathJson1, pathJson2, "stylish"));
    }
    @Test
    public void testGenerateStylish2() throws Exception {
        String expected = Files.readString(expectedStylish);
        assertEquals(expected, Differ.generate(pathYaml1, pathYaml2, "stylish"));
    }
    @Test
    public void testGenerateJson1() throws Exception {
        String expected = Files.readString(expectedJson);
        assertEquals(expected, Differ.generate(pathJson1, pathJson2, "json"));
    }
    @Test
    public void testGenerateJson2() throws Exception {
        String expected = Files.readString(expectedJson);
        assertEquals(expected, Differ.generate(pathYaml1, pathYaml2, "json"));
    }
    @Test
    public void testGeneratePlain1() throws Exception {
        String expected = Files.readString(expectedPlain);
        assertEquals(expected, Differ.generate(pathJson1, pathJson2, "plain"));
    }
    @Test
    public void testGeneratePlain2() throws Exception {
        String expected = Files.readString(expectedPlain);
        assertEquals(expected, Differ.generate(pathYaml1, pathYaml2, "plain"));
    }
}
