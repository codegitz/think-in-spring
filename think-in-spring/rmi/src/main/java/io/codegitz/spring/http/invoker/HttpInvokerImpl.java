package io.codegitz.spring.http.invoker;

/**
 * @author 张观权
 * @date 2020/10/13 11:48
 **/
public class HttpInvokerImpl implements HttpInvoker {
    @Override
    public String getMessage(String msg) {
        return "getMessage: " + msg;
    }
}
