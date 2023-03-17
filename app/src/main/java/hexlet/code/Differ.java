package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {
        var fileType1 = getFileType(filepath1);
        var fileType2 = getFileType(filepath2);
        var data1 = getData(filepath1);
        var data2 = getData(filepath2);
        Map<String, Object> map1 = Parser.parse(data1, fileType1);
        Map<String, Object> map2 = Parser.parse(data2, fileType2);
        var result = Difference.differenceCalc(map1, map2);
        return Formatter.formatChange(result, formatName);
    }
    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
    private static String getFileType(String filepath) {
        return filepath.substring(filepath.indexOf(".") + 1);
    }
    private static String getData(String filepath) throws Exception {
        Path path = Paths.get(filepath.substring(filepath.indexOf("src")));
        return Files.readString(path);
    }
}
