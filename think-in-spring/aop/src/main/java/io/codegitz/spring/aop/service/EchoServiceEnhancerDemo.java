package io.codegitz.spring.aop.service;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 张观权
 * @date 2021/4/8 13:15
 **/
public class EchoServiceEnhancerDemo {
    public static void main(final String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DefaultEchoService.class);
        enhancer.setInterfaces(new Class[]{EchoService.class});
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long start = System.currentTimeMillis();
                Object invoke = methodProxy.invokeSuper(o, args);
                if (methodProxy.getSuperName().contains("echo")){
                    System.out.println("methodProxy.getSuperName().contains(\"echo\") == true");
                }
                long end = System.currentTimeMillis() - start;
                System.out.println("total time:"+ end);
                return invoke;
            }
        });

        EchoService echoService = (EchoService)enhancer.create();
        echoService.echo();
        echoService.study();
    }
}
