package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DifferTest {

    private final String path1 = "src/test/resources/filepath1.json";
    private final String path2 = "src/test/resources/filepath2.json";
    private final Path expectedJson =
            Paths.get("src/test/resources/expected/expectedJson").toAbsolutePath().normalize();

    @Test
    public void testGenerate() throws Exception {
        String expected = Files.readString(expectedJson);
        assertEquals(expected, Differ.generate(path1, path2));
    }
}
