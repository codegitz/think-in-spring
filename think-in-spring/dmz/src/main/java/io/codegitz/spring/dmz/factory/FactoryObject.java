package io.codegitz.spring.dmz.factory;

import io.codegitz.spring.dmz.service.DmzService;
import io.codegitz.spring.dmz.service.IndexService;
import io.codegitz.spring.dmz.service.OrderService;

import java.util.Date;

/**
 * @author 张观权
 * @date 2021/2/5 15:53
 **/
public class FactoryObject {
    public DmzService getDmz(String name, int age, Date birthDay, OrderService orderService) {
        System.out.println("getDmz with "+"name,age,birthDay and orderService");
        return new DmzService();
    }

    public DmzService getDmz(String name, int age, Date birthDay) {
        System.out.println("getDmz with "+"name,age,birthDay");
        return new DmzService();
    }

    public DmzService getDmz(String name, int age) {
        System.out.println("getDmz with "+"name,age");
        return new DmzService();
    }

    public DmzService getDmz() {
        System.out.println("getDmz with empty arg");
        return new DmzService();
    }

    public static IndexService staticGetIndex() {
        return new IndexService();
    }
}
