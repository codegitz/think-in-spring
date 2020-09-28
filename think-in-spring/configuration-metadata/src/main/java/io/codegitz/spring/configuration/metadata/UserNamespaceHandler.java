package io.codegitz.spring.configuration.metadata;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * "user.xsd" {@link org.springframework.beans.factory.xml.NamespaceHandler} 实现示例
 * @author 张观权
 * @date 2020/9/28 9:01
 **/
public class UserNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        // 将 user 元素 注册对应的 BeanDefinitionParser 实现
        registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
    }
}
