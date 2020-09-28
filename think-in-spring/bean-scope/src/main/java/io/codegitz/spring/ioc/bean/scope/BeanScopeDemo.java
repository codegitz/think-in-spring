package io.codegitz.spring.ioc.bean.scope;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Collection;
import java.util.Map;

/**
 * bean的作用域示例
 * @author 张观权
 * @date 2020/9/17 12:57
 **/
public class BeanScopeDemo implements DisposableBean {

    @Bean
    // scope不用写，默认就是singleton
    public static User singletonUser(){
        return createUser();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static User prototypeUser(){
        return createUser();
    }

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser2;

    @Autowired
    private Map<String,User> users;

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;

    public static User createUser(){
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册configuration类 -> spring bean
        applicationContext.register(BeanScopeDemo.class);
        applicationContext.addBeanFactoryPostProcessor(beanFactory ->{
            beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
                @Override
                public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                    System.out.printf("%s Bean 名称:%s 在初始化后回调",bean.getClass().getName(),beanName);
                    return bean;
                }
            });
        });
        applicationContext.refresh();
        /**
         *  结论一
         *  Singleton bean 无论是依赖查找还是依赖注入，都是同一个对象
         *  Prototype bean 无论是依赖查找还是依赖注入，都是新建的对象
         *
         *  结论二
         *  如果依赖注入集合类型的对象，Singleton bean 和 Prototype bean 均会存在一个
         *  且 Prototype bean 有别于其他地方的 Prototype bean
         *
         *  结论三
         *  无论是Singleton bean 还是 Prototype bean 都会执行初始化方法回调
         *  不过只有 Singleton bean会执行销毁方法回调
         *  spring容器没有办法管理 prototype bean 完整的生命周期
         *  也没有办法记录实例的存在
         *  销毁回调方法将不会被执行，可以利用BeanPostProcessor进行清扫工作
         */
        scopeBeansByLookup(applicationContext);
        scopeBeansByInjection(applicationContext);
        applicationContext.close();
    }

    private static void scopeBeansByInjection(AnnotationConfigApplicationContext applicationContext) {

        BeanScopeDemo demo = applicationContext.getBean(BeanScopeDemo.class);
        System.out.println("demo.singletonUser == " + demo.singletonUser);
        System.out.println("demo.prototypeUser == " + demo.prototypeUser);
        System.out.println("demo.prototypeUser1 == " + demo.prototypeUser1);
        System.out.println("demo.prototypeUser2 == " + demo.prototypeUser2);
        System.out.println("demo.users == " + demo.users);
    }

    private static void scopeBeansByLookup(AnnotationConfigApplicationContext applicationContext) {
        for (int i = 0 ; i < 3 ; i++){
            User singletonUser = applicationContext.getBean("singletonUser", User.class);
            System.out.println("singletonUser == " + singletonUser);
            User prototypeUser = applicationContext.getBean("prototypeUser", User.class);
            System.out.println("prototypeUser == " + prototypeUser);
        }
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("当前 BeanScopeDemo bean 销毁中");
        this.prototypeUser.destroy();
        this.prototypeUser1.destroy();
        this.prototypeUser2.destroy();
        for (Map.Entry<String,User> entry: this.users.entrySet()){
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            if (beanDefinition.isPrototype()){
                User user = entry.getValue();
                user.destroy();
            }
        }
        System.out.println("当前 BeanScopeDemo bean 销毁完成");
    }
}
