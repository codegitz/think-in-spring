package io.codegitz.spring.dependency.injection;

import io.codegitz.spring.dependency.injection.annotation.InjectedUser;
import io.codegitz.spring.dependency.injection.annotation.MyAutowired;
import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import javax.inject.Inject;
import javax.jws.soap.SOAPBinding;
import java.lang.annotation.Annotation;
import java.util.*;

import static java.util.Arrays.asList;
import static org.springframework.context.annotation.AnnotationConfigUtils.AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME;

/**
 * 注解驱动的依赖注入处理过程
 * @author 张观权
 * @date 2020/9/15 17:56
 * @see Qualifier
 * @since 2.5
 **/
public class AnnotationDependencyInjectionResolution {

    @Autowired
    private User user;  // DependencyDescriptor ->
                        // 实时注入 (required = true)
                        // 实时注入 (eager = true)
                        // 通过类 (User.class) 依赖查找（处理）
                        // 字段名称 ("user")
                        // 是否首要的 (primary = true)

    @Autowired
    private Map<String,User> users;  // 集合类型依赖注入

    @MyAutowired
    private Optional<User> optionalUsers;

    @Inject
    private User injectUser;

    @InjectedUser
    private User myInjectUser;

//    @Bean(name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
//    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor(){
//        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
//        Set<Class<? extends Annotation>> autowiredAnnotationTypes = new LinkedHashSet<>(asList(Autowired.class,Inject.class,InjectedUser.class));
//        // 注册自定义注解，把原有的也注册进去
//        beanPostProcessor.setAutowiredAnnotationTypes(autowiredAnnotationTypes);
//        return beanPostProcessor;
//    }
        @Bean
        @Order(Ordered.LOWEST_PRECEDENCE - 4)
        public static AutowiredAnnotationBeanPostProcessor beanPostProcessor(){
            AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
            beanPostProcessor.setAutowiredAnnotationType(InjectedUser.class);
            return beanPostProcessor;
        }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencyInjectionResolution.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String sourcesPath="classpath:/META-INF/dependency-lookup-context.xml";
        // 加载xml资源，生成BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(sourcesPath);

        applicationContext.refresh();

        // 依赖查找AnnotationDependencyFieldInjection Bean
        AnnotationDependencyInjectionResolution demo = applicationContext.getBean(AnnotationDependencyInjectionResolution.class);
        System.out.println("demo.user = " + demo.user);
        System.out.println("demo.users = " + demo.users);
        System.out.println("demo.injectUser = " + demo.injectUser);
        System.out.println("demo.optionalUsers = " + demo.optionalUsers);
        System.out.println("demo.myInjectUser = " + demo.myInjectUser);
        applicationContext.close();
    }
}
