package io.codegitz.spring.bean.definition;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 注解 BeanDefinition示例
 * @author 张观权
 * @date 2020/9/11 12:53
 **/
@Import(AnnotationBeanDefinitionDemo.Config.class) //通过@Import导入
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 注册configuration class （配置类）
        annotationConfigApplicationContext.register(AnnotationBeanDefinitionDemo.class);

        annotationConfigApplicationContext.refresh();
        // 1.通过@Bean方式定义
        // 2.通过@Component方式
        // 3.通过@Import导入
        // 4.通过BeanDefinition注册API实现
        // 命名方式
        registerBeanDefinition(annotationConfigApplicationContext,"register-user",User.class);
        // 非命名方式
        registerBeanDefinition(annotationConfigApplicationContext);

        System.out.println("Config类型的所有beans: "+annotationConfigApplicationContext.getBeansOfType(Config.class));
        System.out.println("User  类型的所有beans: "+annotationConfigApplicationContext.getBeansOfType(User.class));
        //显式关闭上下文
        annotationConfigApplicationContext.close();

    }

    /**
     * 命名bean的注册方式
     * @param registry
     * @param beanName
     * @param beanClass
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry,String beanName , Class<?> beanClass){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        beanDefinitionBuilder
                .addPropertyValue("id",1l)
                .addPropertyValue("name","codegitz");
        if (StringUtils.hasText(beanName)){
            // 注册BeanDefinition
            registry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
        }else {
            // 非命名的方式
            String generateBeanName = BeanDefinitionReaderUtils.generateBeanName(beanDefinitionBuilder.getBeanDefinition(), registry);
            registry.registerBeanDefinition(generateBeanName,beanDefinitionBuilder.getBeanDefinition());
        }
    }

    /**
     * 非命名的方式
     * @param registry
     */
    public static void registerBeanDefinition(BeanDefinitionRegistry registry){
        registerBeanDefinition(registry,null,User.class);
    }

    @Component //定义当前类作为spring bean组件 通过@Component方式
    public static class Config{
        @Bean(name ={ "user" , "codegitz-user"} ) //通过@Bean方式定义
        public User user(){
            User user = new User();
            user.setName("innerName");
            user.setId(2l);
            return user;
        }
    }

}
