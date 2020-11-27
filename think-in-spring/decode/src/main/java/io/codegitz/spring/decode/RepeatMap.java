package io.codegitz.spring.decode;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 张观权
 * @date 2020/11/25 16:27
 **/
public class RepeatMap {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1",null);
        map.put("2","2");
        map.put("3",null);
        map.put("4","4");
        map.put("5",null);
        map.put("6","6");
        map.put("7",null);
        Map<String, String> collect = map.entrySet().stream().filter(a -> a.getValue() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        System.out.println(collect);
        map.entrySet().forEach(b ->{
            System.out.println(map.values());
        });
    }
}
