package io.codegitz.spring.common.mistakes.consumer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Codegitz
 * @date 2022/4/2 17:40
 **/
public class PutMapNull {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put(null,"a");
        map.put(null,"b");
    }
}
