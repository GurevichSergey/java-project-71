package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.*;

public class Differ {
    public static String generate(File filepath1, File filepath2 ) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        var map1 = objectMapper.readValue(filepath1, new TypeReference<Map<String,Object>>(){});
        var map2 = objectMapper.readValue(filepath2, new TypeReference<Map<String,Object>>(){});
        var mapResult = new LinkedHashMap<String, Object>();
        for (var key : getKey(map1, map2)) {
            if (!map1.containsKey(key)) {
                mapResult.put("+" + key, map2.get(key));
            } else if (!map2.containsKey(key)) {
                mapResult.put("-" + key, map1.get(key));
            } else if (!map1.get(key).equals(map2.get(key))) {
                mapResult.put("-" + key, map1.get(key));
                mapResult.put("+" + key, map2.get(key));
            } else {
                mapResult.put(" " + key, map1.get(key));
            }
        }
        return toString(mapResult);
    }
    private static Set<String> getKey (Map<String,Object> map1, Map<String,Object> map2 ) {
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
