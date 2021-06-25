package io.codegitz.spring.dmz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 张观权
 * @date 2021/2/5 16:29
 **/
public class App {
        public static void main(String[] args) {
            ClassPathXmlApplicationContext cc = new ClassPathXmlApplicationContext();
            cc.setConfigLocation("application.xml");
            cc.refresh();
            cc.getBean("dmzService");
            // 两次调用，用于测试缓存的方法及参数
            //  cc.getBean("dmzService");

    }
}
