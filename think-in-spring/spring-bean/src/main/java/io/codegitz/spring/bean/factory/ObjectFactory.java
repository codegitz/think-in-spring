package io.codegitz.spring.bean.factory;

@FunctionalInterface
public interface ObjectFactory<T> {
    T getObject();
}
