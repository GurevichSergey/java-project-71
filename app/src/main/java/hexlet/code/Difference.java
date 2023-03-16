package hexlet.code;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class Difference {
    public static LinkedList<Map<String, Object>> differenceCalc(Map<String, Object> map1, Map<String, Object> map2) {
        var keySet = new TreeSet<>(map1.keySet());
        var result = new LinkedList<Map<String, Object>>();
        keySet.addAll(map2.keySet());
        for (var key : keySet) {
            var map = new LinkedHashMap<String, Object>();
            if (!map1.containsKey(key)) {
                map.put("key", key);
                map.put("value", map2.get(key));
                map.put("status", "added");
            } else if (!map2.containsKey(key)) {
                map.put("key", key);
                map.put("value", map1.get(key));
                map.put("status", "removed");
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                map.put("key", key);
                map.put("oldValue", map1.get(key));
                map.put("newValue", map2.get(key));
                map.put("status", "changed");
            } else {
                map.put("key", key);
                map.put("value", map1.get(key));
                map.put("status", "unchanged");
            }
            result.add(map);
        }
        return result;
    }
}
