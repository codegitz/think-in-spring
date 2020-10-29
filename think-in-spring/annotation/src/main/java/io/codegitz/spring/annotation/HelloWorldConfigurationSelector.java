package io.codegitz.spring.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ImpotSelector 实现
 * @author 张观权
 * @date 2020/10/29 20:42
 * @see ImportSelector
 **/
public class HelloWorldConfigurationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"io.codegitz.spring.annotation.HelloWorldConfiguration"};
    }
}
