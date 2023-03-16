package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedList;
import java.util.Map;

public class Json {
    public static String stylize(LinkedList<Map<String, Object>> differenceList) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(differenceList);
    }
}
