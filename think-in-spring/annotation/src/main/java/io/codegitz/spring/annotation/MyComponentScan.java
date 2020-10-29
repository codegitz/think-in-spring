package io.codegitz.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author 张观权
 * @date 2020/10/29 13:03
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@ComponentScan
public @interface MyComponentScan {
    @AliasFor(annotation = ComponentScan.class,attribute = "basePackages")
    String[] scanBasePackages() default {};

}
