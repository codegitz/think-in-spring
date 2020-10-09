package io.codegitz.spring.validation;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.context.MessageSource;
import org.springframework.validation.*;

import java.util.Locale;

import static io.codegitz.spring.validation.ErrorsMessageDemo.createMessageSource;

/**
 * 自定义 Spring {@link org.springframework.validation.Validator} 实现
 *
 * @author 张观权
 * @date 2020/10/9 13:23
 * @see org.springframework.validation.Validator
 **/
public class ValidatorDemo {

    public static void main(String[] args) {
        // 1.创建validator
        Validator validator = new UserValidator();
        // 2.创建 user 对象
        User user = new User();
        System.out.println("user 对象是否被 UserValidator 支持： " + validator.supports(user.getClass()));

        // 3.创建 Error 对象
        Errors errors = new BeanPropertyBindingResult(user, "user");

        // 4.获取 MessageResource 对象
        MessageSource messageSource = createMessageSource();

        // 5.输出所有错误文案
        for (ObjectError objectError : errors.getAllErrors()) {
            String message = messageSource.getMessage(objectError.getCode(), objectError.getArguments(), Locale.getDefault());
            System.out.println(message);
        }

    }

    static class UserValidator implements Validator {
        @Override
        public boolean supports(Class<?> clazz) {
            return User.class.isAssignableFrom(clazz);
        }

        @Override
        public void validate(Object target, Errors errors) {
            User user = (User) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
            String userName = user.getName();
            // ....
        }
    }
}
