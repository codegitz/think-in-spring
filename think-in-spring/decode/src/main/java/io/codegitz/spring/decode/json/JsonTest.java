package io.codegitz.spring.decode.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.List;

/**
 * @author 张观权
 * @date 2021/3/29 16:21
 **/
public class JsonTest {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "[{\n" +
                "  \"info\": \"processing\",\n" +
                "  \"data\": {\n" +
                "    \"id\": \"123\",\n" +
                "    \"cars\": [\n" +
                "      {\n" +
                "        \"id\": \"1\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"2\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}]";
        ObjectMapper mapper = new ObjectMapper();
//        Process process = mapper.readValue(json, Process.class);
        List list = mapper.readValue(json, (JavaType) new TypeReference<List<Process>>() {
        }.getType());
        System.out.println(list);
    }
}
