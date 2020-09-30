package io.codegitz.spring.i18n;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * spring boot messageSource bean
 *
 * @author 张观权
 * @date 2020/9/30 17:26
 * @see org.springframework.context.MessageSource
 * @see org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration
 * @see org.springframework.context.support.ReloadableResourceBundleMessageSource
 * @see org.springframework.context.support.ResourceBundleMessageSource
 **/
@EnableAutoConfiguration
public class CustomizedMessageSourceBeanDemo {

    @Bean(AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME)
    public MessageSource messageSource(){
        return new ReloadableResourceBundleMessageSource();
    }


    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(CustomizedMessageSourceBeanDemo.class)
                .web(WebApplicationType.NONE)
                .run(args);

        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        if (beanFactory.containsBean(AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME)){

            System.out.println(beanFactory.getBeanDefinition(AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME));
            MessageSource messageSource = applicationContext.getBean(AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME, MessageSource.class);
            System.out.println(messageSource);
        }
        applicationContext.close();

    }
}
