package io.codegitz.spring.decode;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张观权
 * @date 2020/11/25 16:27
 **/
public class Repeat {
    public static void main(String[] args) {
        List<String> old = new ArrayList<>();
        List<String> fresh = new ArrayList<>();
        old.add("A");
        old.add("K");
        old.add("C");
        old.add("C");
        old.add("C");
        old.add("C");
        old.add("D");
        old.add("D");
        old.add("D");
        old.add("D");
        old.add("A");
        old.add("A");
        old.add("A");
        old.add("A");
        old.add("A");
        old.add("C");
        old.add("C");
        old.add("D");
        old.add("D");
        old.add("B");
        old.add("D");
        old.add("D");
        old.add("K");
        old.add("K");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < old.size(); i++) {
            for (int j = i + 1; j < old.size(); j++) {
                if (old.get(i).equals(old.get(j))) {
                    fresh.add(old.get(j));
                    old.remove(j);
                    j--;
                }
            }
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(old);
    }
}
