package io.codegitz.spring.dependency.injection;

import io.codegitz.spring.dependency.injection.annotation.UserGroup;
import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.jws.soap.SOAPBinding;
import java.util.Collection;
import java.util.Set;

/**
 * {@link org.springframework.beans.factory.ObjectProvider} 延时依赖注入
 * @author 张观权
 * @date 2020/9/15 17:56
 * @see Qualifier
 * @since 2.5
 **/
public class LazyAnnotationDependencyInjection {

    @Autowired
    private User user;

    @Autowired
    private ObjectProvider<User> objectProvider;

    @Autowired
    private ObjectFactory<Set<User>> objectFactory;

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(LazyAnnotationDependencyInjection.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String sourcesPath="classpath:/META-INF/dependency-lookup-context.xml";
        // 加载xml资源，生成BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(sourcesPath);

        applicationContext.refresh();

        // 依赖查找AnnotationDependencyFieldInjection Bean
        LazyAnnotationDependencyInjection demo = applicationContext.getBean(LazyAnnotationDependencyInjection.class);
        System.out.println("demo.user = "+ demo.user);
        System.out.println("demo.objectProvider = "+ demo.objectProvider.getObject());
        System.out.println("demo.objectFactory = "+ demo.objectFactory.getObject());
        applicationContext.close();
    }
}
