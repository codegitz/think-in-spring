package io.codegitz.spring.dependency.injection.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * 用户注解，扩展 {@link Qualifier } @Qualifier
 * @author 张观权
 * @date 2020/9/15 18:16
 **/
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier
public @interface UserGroup {
}
