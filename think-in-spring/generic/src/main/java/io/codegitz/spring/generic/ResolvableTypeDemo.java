package io.codegitz.spring.generic;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.springframework.core.ResolvableType;

import java.util.HashMap;
import java.util.List;

/**
 * {@link org.springframework.core.ResolvableType}　泛型实现
 * @author 张观权
 * @date 2020/10/20 13:19
 **/
public class ResolvableTypeDemo {

    private HashMap<Integer, List<String>> myMap;

    public void example() throws NoSuchFieldException {
        ResolvableType t = ResolvableType.forField(getClass().getDeclaredField("myMap"));
        t.getSuperType(); // AbstractMap<Integer, List<String>>
        t.asMap(); // Map<Integer, List<String>>
        t.getGeneric(0).resolve(); // Integer
        t.getGeneric(1).resolve(); // List
        t.getGeneric(1); // List<String>
        t.resolveGeneric(1, 0); // String
    }
    public static void main(String[] args) {
        ResolvableType resolvableType = ResolvableType.forClass(StringList.class);
    }
}
