package io.codegitz.spring.common.mistakes.entity;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * @author Codegitz
 * @date 2022/9/26 15:39
 **/
public class HasStatic{
    private static int x = 100;
    public static void main(String args[]){
//        HasStatic hs1= new HasStatic();
//        hs1.x++;
//        HasStatic  hs2= new HasStatic();
//        hs2.x++;
//        hs1=new HasStatic();
//        hs1.x++;
//        HasStatic.x--;
//        System.out.println("x="+x);
//        testComp2();
        System.out.println('a' - 'A');
    }
    private static void testComp2(){
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(1);
        list.add(5);
        list.add(11);
        list.add(5);
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(1);
        list.add(5);
        list.add(11);
        list.add(5);
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(1);
        list.add(5);
        list.add(11);
        list.add(5);
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(1);
        list.add(5);
        list.add(11);
        list.add(5);
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(5);
        list.add(1);
        list.add(5);
        list.add(11);
        list.add(5);
        System.out.println(list.size());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : -1;
            }
        });

        System.out.println(list);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return result;
        }
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            String key = sort(s);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(s);
            map.put(key,list);
        }
        map.forEach((k,v) -> {
            result.add(v);
        });
        return result;
    }
    public String sort(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        return sb.toString();
    }
}
