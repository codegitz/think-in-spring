package io.codegitz.spring.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 基于 API 资源的 Constructor 方法注入示例
 * @author 张观权
 * @date 2020/9/15 12:54
 **/
public class ApiDependencyConstructorInjection {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 生成UserHolder的BeanDefinition
        BeanDefinition userHolderDefinition = createUserHolderBeanDefinition();
        // 注册UserHolder的BeanDefinition
        applicationContext.registerBeanDefinition("userHolder",userHolderDefinition);
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String sourcesPath="classpath:/META-INF/dependency-lookup-context.xml";
        // 加载xml资源，生成BeanDefinition
        xmlBeanDefinitionReader.loadBeanDefinitions(sourcesPath);

        applicationContext.refresh();

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);
        applicationContext.close();
    }

    /**
     * 为{@link UserHolder} 生成 {@link BeanDefinition}
     * @return
     */
    static BeanDefinition createUserHolderBeanDefinition(){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        beanDefinitionBuilder.addConstructorArgReference("superUser");
        return beanDefinitionBuilder.getBeanDefinition();
    }
}
