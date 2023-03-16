package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.LinkedList;
import java.util.Map;

public class Formatter {
    public static String formatChange(LinkedList<Map<String, Object>> differenceList, String format) throws Exception {
        switch (format) {
            case "stylish":
                return Stylish.stylize(differenceList);
            case "plain":
                return Plain.stylize(differenceList);
            case "json":
                return Json.stylize(differenceList);
            default:
                System.out.println("Format " + format + " is not correct!");
                return Stylish.stylize(differenceList);
        }
    }
}
