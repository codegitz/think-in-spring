package io.codegitz.spring.validation;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.Locale;

/**
 * 错误文案示例
 *
 * @author 张观权
 * @date 2020/10/9 12:54
 * @see org.springframework.validation.Errors
 **/
public class ErrorsMessageDemo {
    public static void main(String[] args) {

        // 0.创建User对象
        User user = new User();
        user.setName("Codegitz");
        // 1.选择 Errors -> BeanPropertyBindingResult
        Errors errors = new BeanPropertyBindingResult(user, "user");

        // 2.调用 reject 或者rejectValue
        // reject 生成 ObjectError
        // rejectValue 生成 FieldError
        errors.reject("user.properties.not.null");
        // user.name = user.getName()
        errors.rejectValue("name", "name.required");

        // 3.获取 Errors 中的 ObjectError 和 FieldError
        // FieldError extends ObjectError
        List<ObjectError> objectErrors = errors.getGlobalErrors();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        List<ObjectError> allErrors = errors.getAllErrors();

        // 4.通过 ObjectError 和 FieldError 中的 code 和 args 来关联 MessageSource 实现
        MessageSource messageSource = createMessageSource();

        for (ObjectError objectError : allErrors) {
            String message = messageSource.getMessage(objectError.getCode(), objectError.getArguments(), Locale.getDefault());
            System.out.println(message);
        }

    }

     static MessageSource createMessageSource() {
        StaticMessageSource staticMessageSource = new StaticMessageSource();
        staticMessageSource.addMessage("id.required", Locale.getDefault(), "the id of user must not be null");
        staticMessageSource.addMessage("name.required", Locale.getDefault(), "the name of user must not be null");
        staticMessageSource.addMessage("user.properties.not.null", Locale.getDefault(), "User 的所有属性不能为空");
        return staticMessageSource;
    }
}
