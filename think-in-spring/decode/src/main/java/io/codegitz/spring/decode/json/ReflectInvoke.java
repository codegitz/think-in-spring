package io.codegitz.spring.decode.json;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

/**
 * @author 张观权
 * @date 2021/4/1 9:47
 **/
public class ReflectInvoke {
    public static void main(String[] args) {
        Object reflect = new Reflect();
        Method method = ReflectionUtils.findMethod(Reflect.class,"getString");
        Object string = ReflectionUtils.invokeMethod(method,reflect);
        System.out.println(string);
    }

}

class Reflect{
    public String getString(){
        return "String";
    }
}