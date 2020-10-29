package io.codegitz.spring.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 *  {@link Component} 派生性
 * @author 张观权
 * @date 2020/10/28 13:07
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MyComponent1
public @interface MyComponent2 {
}
