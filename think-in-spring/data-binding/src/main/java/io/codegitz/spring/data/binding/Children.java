package io.codegitz.spring.data.binding;

import java.util.List;

/**
 * @author 张观权
 * @date 2020/10/13 11:11
 **/
public class Children  extends Parent {
    private String money;
    private String company;

    @Override
    public String toString() {
        return "Children{" +
                "money='" + money + '\'' +
                ", company='" + company + '\'' +
                "} " + super.toString();
    }

    public static void main(String... args) {
        System.out.println(list().toString());
    }

    public static Children list() {
        return new Children();
    }
}
