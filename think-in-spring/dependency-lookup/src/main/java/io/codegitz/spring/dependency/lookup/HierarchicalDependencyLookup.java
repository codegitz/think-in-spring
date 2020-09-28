package io.codegitz.spring.dependency.lookup;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 层次性依赖查找示例
 * @author 张观权
 * @date 2020/9/14 16:14
 **/
public class HierarchicalDependencyLookup {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);//默认配置类
        applicationContext.refresh();
        applicationContext.close();
    }
}
