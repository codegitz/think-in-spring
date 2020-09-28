package io.codegitz.spring.dependency.injection;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 基于java 注解的 方法 注入示例
 * @author 张观权
 * @date 2020/9/15 12:54
 **/
public class AnnotationDependencyMethodInjection {

    private UserHolder userHolder;

    private UserHolder userHolder2;

    @Autowired
    public void init1(UserHolder userHolder){
        this.userHolder = userHolder;
    }

    @Resource
    public void init2(UserHolder userHolder2){
        this.userHolder2 = userHolder2;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencyMethodInjection.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String sourcesPath="classpath:/META-INF/dependency-lookup-context.xml";
        // 加载xml资源，生成BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(sourcesPath);

        applicationContext.refresh();

        // 依赖查找AnnotationDependencyFieldInjection Bean
        AnnotationDependencyMethodInjection demo = applicationContext.getBean(AnnotationDependencyMethodInjection.class);
        UserHolder userHolder = demo.userHolder;
        System.out.println(userHolder);
        System.out.println(demo.userHolder2);
        System.out.println(userHolder == demo.userHolder2);
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user){
        return new UserHolder(user);
    }
}
