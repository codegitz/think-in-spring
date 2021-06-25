package io.codegitz.spring.common.mistakes.consumer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * @author 张观权
 * @date 2021/6/10 16:03
 **/
public class ConsumerTest {
    private static final Map<Integer, Consumer<String>> QUEUE = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        resolve(1, s -> System.out.println(s.toUpperCase()));
        resolve(1, s -> System.out.println(s.toLowerCase()));
        resolve(1, s -> System.out.println(s.substring(0, 2)));
        QUEUE.get(1).accept("Hello World");
    }

    public static void resolve(Integer id, Consumer<String> callback) {
        final Consumer<String> existing = QUEUE.get(id);
        if (callback == null) callback = i -> {};
        if (existing != null && callback != existing) {
            callback = existing.andThen(callback);
        }
        QUEUE.put(id, callback);
    }
}
