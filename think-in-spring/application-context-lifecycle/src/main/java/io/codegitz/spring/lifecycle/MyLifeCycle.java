package io.codegitz.spring.lifecycle;

import org.springframework.context.Lifecycle;

/**
 * @author 张观权
 * @date 2020/11/4 20:20
 **/
public class MyLifeCycle implements Lifecycle {

    private boolean isRunning = false;
    @Override
    public void start() {
        isRunning = true;
        System.out.println("MyLifeCycle 启动...");

    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println("MyLifeCycle 停止...");
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }
}
