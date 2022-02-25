package io.codegitz;

import io.codegitz.entity.Foo;
import io.codegitz.service.FooService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Codegitz
 * @date 2022/2/22 16:04
 **/
public final class Boot {
    public static void main(final String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("contexts.xml");
        FooService fooService = ctx.getBean(FooService.class);
        fooService.insertFoo(new Foo());
    }
}
