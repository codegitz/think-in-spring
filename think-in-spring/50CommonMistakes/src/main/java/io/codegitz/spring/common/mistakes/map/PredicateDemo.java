package io.codegitz.spring.common.mistakes.map;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author 张观权
 * @date 2021/7/8 13:05
 **/
public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> integerPredicate = x -> x > 5 ;
        Predicate<String> stringPredicate = s -> s.startsWith("_");
        boolean test = integerPredicate.test(6);
        System.out.println(test);
        boolean a = stringPredicate.test("_a");
        System.out.println(a);

        BinaryOperator<Long> longBinaryOperator = (x,y) -> x + y;
        Long apply = longBinaryOperator.apply(1L, 1L);
        System.out.println(apply);

        Runnable helloWorld = () -> System.out.println("helloWorld");
        helloWorld.run();
//        check(x -> x > 5);

        Function<String,String> function = (x) -> x;
        BiFunction<String,String,String> biFunction = (x,y) -> x + y;
        String apply1 = biFunction.apply("a", "b");
        System.out.println(apply1);

        List<String> max = new ArrayList<>();
        max.add("a");
        max.add("bb");
        max.add("ccc");
        max.add("aa");
        Optional<String> maxS = max.stream().max(Comparator.comparing(s -> s.length()));
        System.out.println(maxS.get());
        List<String> min = new ArrayList<>();
        min.add("1");
        Optional<String> minS = min.stream().min(Comparator.comparing(s -> s.length()));
        System.out.println(minS.get());

        long count = max.stream().filter(s -> s.contains("a")).count();
        System.out.println(count);

        Integer reduce = Stream.of(1, 2, 3).reduce(0, (e, sum) -> e + sum);
        System.out.println(reduce);

        Stream<Integer> integerStream = Stream.of(1,2,3);
        System.out.println(addUp(integerStream));

        Object o = new HashMap<>();
        if (o instanceof Map){
            System.out.println("map");
        }
    }

    private static int addUp(Stream<Integer> stream){
        return stream.reduce(0, Integer::sum);
    }

    private static <T> Stream<T> reduceFilter(Stream<T> stream){
        Stream<T> result = Stream.empty();
        return result;
    }

    interface IntPred {
        boolean test(Integer value);
    }
    boolean check(Predicate<Integer> predicate){
        return true;
    }
    boolean check(IntPred predicate){
        return false;
    }

}
