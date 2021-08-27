package io.codegitz.base.common;

import io.codegitz.base.BaseExecutor;
import io.codegitz.base.util.ApplicationUtils;
import io.codegitz.other.InvocationOtherClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Codegitz
 * @date 2021/8/26 19:00
 **/
public abstract class CommonBaseExecutor implements BaseExecutor {

    private InvocationOtherClass invocationOtherClass;

//    @Value("${otherBeanName:invocationOtherClass}")
    private String otherBeanName = "invocationOtherClass";

//    private BaseExecutor baseExecutor;

    public CommonBaseExecutor(){
        this.invocationOtherClass = (InvocationOtherClass) ApplicationUtils.getBean(otherBeanName);
    }

    @Override
    public void baseMethod(String name) {
        System.out.println("baseMethod start...");
        // do something
        invocationOtherClass.invocation(name);
        System.out.println("baseMethod stop...");
    }

//    @Override
//    public String particularMethod(String name) {
//        if (baseExecutor == null){
//            return "cannot find executor";
//        }
//        return baseExecutor.particularMethod(name);
//    }
//
//    public void setBaseExecutor(BaseExecutor baseExecutor) {
//        this.baseExecutor = baseExecutor;
//    }
}
