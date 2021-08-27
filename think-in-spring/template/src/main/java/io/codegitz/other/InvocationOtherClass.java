package io.codegitz.other;

import org.springframework.stereotype.Component;

/**
 * @author Codegitz
 * @date 2021/8/27 9:24
 **/
@Component("invocationOtherClass")
public class InvocationOtherClass {
    public void invocation(String name){
        System.out.println(name + " invoke InvocationOtherClass's method...");
    }
}
