package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {

    private final String pathJson1 = "src/test/resources/filepath1.json";
    private final String pathJson2 = "src/test/resources/filepath2.json";
    private final String pathYaml1 = "src/test/resources/filepath1.json";
    private final String pathYaml2 = "src/test/resources/filepath2.json";
    private final Path expectedResult =
            Paths.get("src/test/resources/expected/expected").toAbsolutePath().normalize();

    @Test
    public void testGenerateJson() throws Exception {
        String expected = Files.readString(expectedResult);
        assertEquals(expected, Differ.generate(pathJson1, pathJson2));
    }
    @Test
    public void testGenerateYaml() throws Exception {
        String expected = Files.readString(expectedResult);
        assertEquals(expected, Differ.generate(pathYaml1, pathYaml2));
    }
}
