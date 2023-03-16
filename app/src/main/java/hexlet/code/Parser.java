package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filepath) throws Exception {
        Path path = Paths.get(filepath.substring(filepath.indexOf("src")));
        var file = Files.readString(path);
        ObjectMapper objectMapper = getType(filepath);
        return objectMapper.readValue(file, new TypeReference<>() { });
    }
    private static ObjectMapper getType(String filepath) {
        var fileType = filepath.substring(filepath.indexOf(".") + 1);
        System.out.println(fileType);
        return "json".equals(fileType) ? new ObjectMapper() : new ObjectMapper(new YAMLFactory());
    }
}
