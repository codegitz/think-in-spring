package io.codegitz.spring.dependency.lookup;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * {@link org.springframework.beans.factory.BeanCreationException}示例
 * @author 张观权
 * @date 2020/9/15 11:20
 **/
public class BeanCreationExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册POJO类
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(POJO.class);
        applicationContext.registerBeanDefinition("errorBean",beanDefinitionBuilder.getBeanDefinition());
        applicationContext.refresh();
        applicationContext.close();
    }

    static class POJO implements InitializingBean{

        @PostConstruct //CommonAnnotationBeanPostProcessor
        public void init() throws Throwable {
            throw new Throwable("init(): for purposes...");
        }
        @Override
        public void afterPropertiesSet() throws Exception {
            throw new Exception("afterPropertiesSet(): for purposes...");
        }
    }

}
