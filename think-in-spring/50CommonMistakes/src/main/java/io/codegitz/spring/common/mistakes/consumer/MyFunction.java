package io.codegitz.spring.common.mistakes.consumer;

/**
 * @author 张观权
 * @date 2021/6/11 11:20
 **/
@FunctionalInterface
public interface MyFunction<T,R> {
    /**
     * 返回 R
     * @param t
     * @return R
     */
    R myApply(T t);
}
