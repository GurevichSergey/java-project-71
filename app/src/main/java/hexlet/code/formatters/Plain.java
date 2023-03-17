package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;

public class Plain {
    public static String stylize(LinkedList<Map<String, Object>> differenceList) {
        var result = new StringBuilder();
        for (Map<String, Object> difference : complexValue(differenceList)) {
            switch (difference.get("status").toString()) {
                case "removed" -> result
                        .append("Property '")
                        .append(difference.get("key"))
                        .append("' was removed")
                        .append("\n");
                case "added" -> result
                        .append("Property '")
                        .append(difference.get("key"))
                        .append("' was added with value: ")
                        .append(difference.get("value"))
                        .append("\n");
                case "changed" -> result
                        .append("Property '")
                        .append(difference.get("key"))
                        .append("' was updated. From ")
                        .append(difference.get("oldValue"))
                        .append(" to ").append(difference.get("newValue"))
                        .append("\n");
                default -> {
                    break;
                }
            }
        }
        return result.toString().trim();
    }
    public static LinkedList<Map<String, Object>> complexValue(LinkedList<Map<String, Object>> differenceList) {
        for (var map : differenceList) {
            for (var pair :map.entrySet()) {
                if (pair.getValue() instanceof Object[] || pair.getValue() instanceof Collections
                        || pair.getValue() instanceof Map || pair.getValue() instanceof ArrayList<?>) {
                    pair.setValue("[complex value]");
                } else if (pair.getKey().equals("newValue") || pair.getKey().equals("value")
                        || pair.getKey().equals("oldValue")) {
                    if (pair.getValue() instanceof String) {
                        pair.setValue("'" + pair.getValue() + "'");
                    }
                }
            }
        }
        return differenceList;
    }
}
