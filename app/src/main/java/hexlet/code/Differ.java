package hexlet.code;

import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String formatName) throws Exception {
        Map<String, Object> map1 = Parser.parse(filepath1);
        Map<String, Object> map2 = Parser.parse(filepath2);
        var result = Difference.differenceCalc(map1, map2);
        return Formatter.formatChange(result, formatName);
    }
    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
