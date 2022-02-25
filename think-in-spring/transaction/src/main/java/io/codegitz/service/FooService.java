package io.codegitz.service;

import io.codegitz.entity.Foo;

/**
 * @author Codegitz
 * @date 2022/2/22 16:00
 **/
public interface FooService {

    Foo getFoo(String fooName);

    Foo getFoo(String fooName, String barName);

    void insertFoo(Foo foo);

    void updateFoo(Foo foo);

}
