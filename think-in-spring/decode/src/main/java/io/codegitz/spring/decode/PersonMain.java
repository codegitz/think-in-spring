package io.codegitz.spring.decode;

import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ModelFactory;

import java.lang.reflect.Method;

/**
 * @author 张观权
 * @date 2021/1/20 17:17
 **/
public class PersonMain {
    public static void main(String[] args) {
        HandlerMethod handlerMethod = new HandlerMethod(new Person(), getPersonSpecfyMethod());
        MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
        for (MethodParameter methodParameter : methodParameters) {
            Class<?> parameterType = methodParameter.getParameterType();
            String nameForParameter = ModelFactory.getNameForParameter(methodParameter);
            System.out.println("类型： " + parameterType.getName() + ", --->缺省的modelKey是：" + nameForParameter);
        }
    }

    private static Method getPersonSpecfyMethod() {
        for (Method method : Person.class.getMethods()) {
            if (method.getName().equals("demoMethod")) {
                return method;
            }
        }
        return null;
    }
}
