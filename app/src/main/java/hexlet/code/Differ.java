package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        Map<String, Object> map1 = Parser.parse(filepath1);
        Map<String, Object> map2 = Parser.parse(filepath2);
        var mapResult = new LinkedHashMap<String, Object>();
        for (var key : getAllKey(map1, map2)) {
            if (!map1.containsKey(key)) {
                mapResult.put("+ " + key, map2.get(key));
            } else if (!map2.containsKey(key)) {
                mapResult.put("- " + key, map1.get(key));
            } else if (!map1.get(key).equals(map2.get(key))) {
                mapResult.put("- " + key, map1.get(key));
                mapResult.put("+ " + key, map2.get(key));
            } else {
                mapResult.put("  " + key, map1.get(key));
            }
        }
        return toString(mapResult);
    }
    private static Set<String> getAllKey(Map<String, Object> map1, Map<String, Object> map2) {
        var allKey = new TreeSet<String>();
        allKey.addAll(map1.keySet());
        allKey.addAll(map2.keySet());
        return allKey;
    }
    public static String toString(LinkedHashMap<String, Object> maResult) {
        if (maResult.isEmpty()) {
            return "{}";
        }
        StringBuilder result = new StringBuilder("{\n");
        for (var word : maResult.keySet()) {
            result.append("  ").append(word).append(": ").append(maResult.get(word)).append("\n");
        }
        result.append("}");
        return result.toString();
    }
}
