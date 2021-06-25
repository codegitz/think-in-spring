package io.codegitz.spring.common.mistakes.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author 张观权
 * @date 2021/6/10 16:03
 **/
public class ConsumerTest2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
//        list.forEach(System.out::println);

        Consumer<Integer> consumer1 = System.out::println;
        Consumer<String> consumer2 = s -> System.out.println(s.toUpperCase());
        Consumer<String> consumer3 = s -> System.out.println(s.toLowerCase());
        consumer2.andThen(consumer3).accept("code");
        consumer1.accept(1);

        Supplier<String> supplier = () -> "aaa";
        System.out.println(supplier.get());

        Predicate<String> predicate = "nnn"::equals;
        System.out.println(predicate.test("nnn"));
        System.out.println(predicate.test("nnffn"));

        Function<Integer,String> function = String::valueOf;
        Function<String,Integer> function2 = x -> Integer.parseInt(x) + 2;
        System.out.println(function.apply(111));
        System.out.println(function.andThen(function2).apply(9));
        System.out.println(function.compose(function2).apply("1"));

        Function<Integer,String> myFunction = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        };
        myFunction.apply(456);

        MyFunction<Integer,String> myFunction1 = String::valueOf;
        System.out.println(myFunction1.myApply(123456));
    }
}
