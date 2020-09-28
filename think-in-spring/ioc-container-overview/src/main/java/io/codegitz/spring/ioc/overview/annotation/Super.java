package io.codegitz.spring.ioc.overview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 超级
 * @author 张观权
 * @date 2020/9/9 18:39
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
