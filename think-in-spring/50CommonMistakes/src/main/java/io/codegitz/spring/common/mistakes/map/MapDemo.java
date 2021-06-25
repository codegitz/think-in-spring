package io.codegitz.spring.common.mistakes.map;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 张观权
 * @date 2021/6/24 17:39
 **/
public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.merge("1","1",(v1, v2) -> v1+v2);
        map.merge("3","3",(v1, v2) -> v1+v2);
        map.merge("3","3",(v1, v2) -> v1+v2);
        System.out.println(map);

        Map<String,String> esg = new HashMap<>();
        esg.put("AA","oldMsg");
        esg.compute("AA", (k,v) -> v==null ? "newMsg" : v.concat("newMsg"));
        System.out.println(esg);

        Map<String,String> computeIfAbsent = new HashMap<>();
        computeIfAbsent.put("AA","AA");
        computeIfAbsent.computeIfAbsent("AA",v -> v);
        computeIfAbsent.computeIfAbsent("BB",v -> v);
        System.out.println(computeIfAbsent);

        Map<String,String> computeIfPresent = new HashMap<>();
        computeIfPresent.put("AA","BB");
        String aa = computeIfPresent.computeIfPresent("AA", (k, v) -> "lambada");
        System.out.println(aa);
//        computeIfPresent.computeIfPresent("AA",(k,v) -> k);
        System.out.println(computeIfPresent);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        Stream<String> stream = list.stream();
        List<String> distinct = stream.distinct().collect(Collectors.toList());
        System.out.println(distinct);
        System.out.println(list);

        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5));
        List<Integer> integers = listStream.flatMap(d -> d.stream()).collect(Collectors.toList());
        System.out.println(integers);

        // 使用Collectors.joining()拼接字符串
        Stream<String> stream2 = Stream.of("I", "love", "you");
        //String joined = stream.collect(Collectors.joining());// "Iloveyou"
        //String joined = stream.collect(Collectors.joining(","));// "I,love,you"
        String joined = stream2.collect(Collectors.joining(",", "{", "}"));// "{I,love,you}"
        System.out.println(joined);


    }
}
