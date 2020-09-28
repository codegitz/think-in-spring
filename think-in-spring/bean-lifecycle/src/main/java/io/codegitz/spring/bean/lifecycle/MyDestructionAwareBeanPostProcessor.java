package io.codegitz.spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

/**
 * {@link org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor} 实现示例
 * @author 张观权
 * @date 2020/9/23 19:43
 **/
public class MyDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
    }
}
