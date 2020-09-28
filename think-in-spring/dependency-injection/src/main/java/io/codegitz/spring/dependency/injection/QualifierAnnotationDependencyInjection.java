package io.codegitz.spring.dependency.injection;

import io.codegitz.spring.dependency.injection.annotation.UserGroup;
import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.jws.soap.SOAPBinding;
import java.util.Collection;

/**
 * {@link Qualifier} 注解依赖注入
 * @author 张观权
 * @date 2020/9/15 17:56
 * @see Qualifier
 * @since 2.5
 **/
public class QualifierAnnotationDependencyInjection {

    @Autowired //superUser -> primary = true
    private User user;

    @Autowired //user
    @Qualifier("user")
    private User namedUser;

    @Autowired
    private Collection<User> allUsers; // 2 Beans = user + superUser

    @Autowired
    @Qualifier
    private Collection<User> qualifiedUsers;  // 2 Beans = user1 + user2 -> 4 Beans = user1 + user2 + user3 + user4

    @Autowired
    @UserGroup
    private Collection<User> userGroup;   // 2 Beans = user3 + user4

    @Bean
    @Qualifier //进行逻辑划分
    public User user1(){
        return createUser(7L);
    }
    @Bean
    @Qualifier  //进行逻辑划分
    public User user2(){
        return createUser(8L);
    }
    @Bean
    @UserGroup  //进行逻辑划分
    public User user3(){
        return createUser(9L);
    }
    @Bean
    @UserGroup  //进行逻辑划分
    public User user4(){
        return createUser(10L);
    }

    public static User createUser(Long id){
        User user = new User();
        user.setId(id);
        return user;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualifierAnnotationDependencyInjection.class);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String sourcesPath="classpath:/META-INF/dependency-lookup-context.xml";
        // 加载xml资源，生成BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(sourcesPath);

        applicationContext.refresh();

        // 依赖查找AnnotationDependencyFieldInjection Bean
        QualifierAnnotationDependencyInjection demo = applicationContext.getBean(QualifierAnnotationDependencyInjection.class);
        System.out.println("demo.user = "+ demo.user);
        System.out.println("demo.namedUser = "+ demo.namedUser);
        System.out.println("demo.allUsers = "+ demo.allUsers);
        System.out.println("demo.qualifiedUsers = "+ demo.qualifiedUsers);
        System.out.println("demo.userGroup = "+ demo.userGroup);
        applicationContext.close();
    }
}
