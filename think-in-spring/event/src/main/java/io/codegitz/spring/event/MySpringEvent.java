package io.codegitz.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义 Spring 事件
 * @author 张观权
 * @date 2020/10/22 20:08
 **/
public class MySpringEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source 事件消息 the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MySpringEvent(Object source) {
        super(source);
    }

    @Override
    public String getSource() {
        return (String) super.getSource();
    }

    public String getMessage(){
        return getSource();
    }

}
