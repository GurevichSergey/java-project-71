package hexlet.code.formatters;

import java.util.LinkedList;
import java.util.Map;

public class Stylish {
    public static String stylize(LinkedList<Map<String, Object>> differenceList) {
        if (differenceList.isEmpty()) {
            return "{}";
        }
        var result = new StringBuilder("{\n");
        for (Map<String, Object> difference : differenceList) {
            switch (difference.get("status").toString()) {
                case "unchanged" -> result
                        .append("    ")
                        .append(difference.get("key"))
                        .append(": ")
                        .append(difference.get("value"))
                        .append("\n");
                case "removed" -> result
                        .append("  - ")
                        .append(difference.get("key"))
                        .append(": ")
                        .append(difference.get("value"))
                        .append("\n");
                case "added" -> result
                        .append("  + ")
                        .append(difference.get("key"))
                        .append(": ")
                        .append(difference.get("value"))
                        .append("\n");
                default -> result
                        .append("  - ")
                        .append(difference.get("key"))
                        .append(": ")
                        .append(difference.get("oldValue"))
                        .append("\n")
                        .append("  + ")
                        .append(difference.get("key"))
                        .append(": ")
                        .append(difference.get("newValue"))
                        .append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
