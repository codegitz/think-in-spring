package io.codegitz.spring.aop.service;

import org.aopalliance.aop.Advice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.IntroductionInfo;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

import java.lang.reflect.Method;

/**
 * @author 张观权
 * @date 2021/5/13 13:23
 **/
public class IntroductionAdvisorDemo implements EchoService,Comparable{

    public static void main(String[] args) {
        IntroductionAdvisorDemo introductionAdvisorDemo = new IntroductionAdvisorDemo();
        ProxyFactory proxyFactory = new ProxyFactory(introductionAdvisorDemo);
        proxyFactory.addAdvice((Advice) new DefaultIntroductionAdvisor(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                System.out.println("BeforeAdvice: " + method);
            }
        }, new IntroductionInfo() {
            public Class<?>[] getInterfaces() {
                return new Class[]{EchoService.class};
            }
        }));
        EchoService echoService = (EchoService) proxyFactory.getProxy();
        echoService.study();
    }

    public String echo() {
        return "echo";
    }

    public String study() {
        return "study";
    }

    public int compareTo(Object o) {
        return 0;
    }
}
