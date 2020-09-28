package io.codegitz.spring.dependency.injection.annotation;

import java.lang.annotation.*;

/**
 * 自定义依赖注入注解
 * @author 张观权
 * @date 2020/9/17 11:25
 **/
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectedUser {
}
