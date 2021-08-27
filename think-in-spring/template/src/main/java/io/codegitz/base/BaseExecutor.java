package io.codegitz.base;

/**
 * @author Codegitz
 * @date 2021/8/26 18:59
 **/
public interface BaseExecutor {
    default void baseMethod(String name) {}
    default String particularMethod(String name) {
        return name;
    }
    default String submitAdAll(String name){return name;}
}
