package io.codegitz.spring.decode;

import io.codegitz.spring.decode.dto.InfoDTO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 张观权
 * @date 2020/12/7 10:36
 **/
public class EmptyLam {
    public static void main(String[] args) {
        List<InfoDTO> list1 = new LinkedList<>();
        List<InfoDTO> list2 = new LinkedList<>();
        List<InfoDTO> list3 = new LinkedList<>();
        list1.add(new InfoDTO("1"));
        list1.add(new InfoDTO("2"));
        list1.add(new InfoDTO("3"));
        list2.add(new InfoDTO("4"));
        list2.add(new InfoDTO("5"));
        list2.add(new InfoDTO("6"));
        list2.add(new InfoDTO("6"));
        list2.get(1);
        Map<String, InfoDTO> collect = list2.stream().collect(Collectors.toMap(InfoDTO::getName, a -> a, (k1, k2) -> k1));
        collect.forEach((k,v) -> {
            System.out.println(k + ": "+v.getName());
        });
        list3.addAll(list1);
        list3.addAll(list2);
//        list3.stream().forEach(s -> System.out.println(s.getName()));
    }
}
