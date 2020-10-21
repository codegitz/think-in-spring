package io.codegitz.spring.event;

import org.springframework.validation.ObjectError;

import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;

/**
 * {@link java.util.Observer} 实现
 *
 * @author 张观权
 * @date 2020/10/21 13:31
 **/
public class ObserverDemo {
    public static void main(String[] args) {
        EventObservable observable = new EventObservable();
        observable.addObserver(new EventObserver());
        observable.notifyObservers("hello,event");
        System.out.println(observable.countObservers());
        System.out.println(observable.hasChanged());
        observable.addObserver(new EventObserver());
        observable.notifyObservers("hello,one more time");
    }

    static class EventObservable extends Observable {

        public synchronized void setChanged() {
            super.setChanged();
        }

        @Override
        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(new EventObject(arg));
            clearChanged();
        }
    }

    static class EventObserver implements Observer {
        @Override
        public void update(Observable o, Object object) {
            EventObject eventObject = (EventObject) object;
            System.out.println("收到事件消息：" + eventObject);
        }
    }
}
