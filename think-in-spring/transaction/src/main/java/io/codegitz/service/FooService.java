package io.codegitz.service;

import io.codegitz.entity.Foo;
import org.springframework.stereotype.Component;

/**
 * @author Codegitz
 * @date 2022/2/22 16:00
 **/
@Component
public interface FooService {

    Foo getFoo(String fooName);

    Foo getFoo(String fooName, String barName);

    void insertFoo(Foo foo);

    void updateFoo(Foo foo);

}
