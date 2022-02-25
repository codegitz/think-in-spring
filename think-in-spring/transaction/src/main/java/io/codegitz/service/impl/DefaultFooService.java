package io.codegitz.service.impl;

import io.codegitz.entity.Foo;
import io.codegitz.service.FooService;

/**
 * @author Codegitz
 * @date 2022/2/22 16:01
 **/
public class DefaultFooService implements FooService {

    @Override
    public Foo getFoo(String fooName) {
        // ...
        return new Foo();
    }

    @Override
    public Foo getFoo(String fooName, String barName) {
        // ...
        return new Foo();
    }

    @Override
    public void insertFoo(Foo foo) {
        // ...
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateFoo(Foo foo) {
        // ...
    }
}
