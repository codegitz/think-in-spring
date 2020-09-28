package io.codegitz.spring.dependency.lookup;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link org.springframework.beans.factory.NoUniqueBeanDefinitionException}示例
 * @author 张观权
 * @date 2020/9/15 11:20
 **/
public class NoUniqueBeanDefinitionExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);
        applicationContext.refresh();
        try {
            applicationContext.getBean(String.class);
        }catch (NoUniqueBeanDefinitionException e){
            System.err.printf(" spring上下文中存在 %d个 %s类型的bean，具体原因: %s%n",e.getNumberOfBeansFound(),String.class.getName(),e.getMessage());
        }
        applicationContext.close();
    }

    @Bean
    public String bean1(){
        return "bean1";
    }

    @Bean
    public String bean2(){
        return "bean2";
    }
}
