package io.codegitz.spring.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 自定义 @Enable 注解
 * @author 张观权
 * @date 2020/10/29 20:36
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
// 1.通过@Import configuration class 实现
//@Import(HelloWorldConfiguration.class)
// 2.通过ImportSelector实现
//@Import(HelloWorldConfigurationSelector.class)
// 3.通过ImportBeanDefinitionRegistrar 实现
@Import(HelloWorldImportBeanDefinitionRegistrar.class)
public @interface EnableHelloWorld {
}
