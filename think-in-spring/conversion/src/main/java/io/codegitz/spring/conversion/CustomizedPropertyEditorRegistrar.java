package io.codegitz.spring.conversion;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.stereotype.Component;

/**
 * 自定义 {@link PropertyEditorRegistrar} 实现
 * @author 张观权
 * @date 2020/10/14 13:22
 **/
//@Component // 3.注册为 bean
public class CustomizedPropertyEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors(PropertyEditorRegistry registry) {

        // 1.通用类型转换
        // 2.Java Bean 属性类型转换
        registry.registerCustomEditor(User.class,"context",new StringToPropertiesPropertyEditor());

    }
}
