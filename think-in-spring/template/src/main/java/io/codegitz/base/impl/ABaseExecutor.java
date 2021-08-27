package io.codegitz.base.impl;

import io.codegitz.base.BaseExecutor;
import io.codegitz.base.common.CommonBaseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Codegitz
 * @date 2021/8/27 9:27
 **/
@Service("aBaseExecutorImpl")
@DependsOn("applicationUtils")
public class ABaseExecutor extends CommonBaseExecutor {

    @Autowired
    private Map<String, BaseExecutor> baseExecutorMap; //a b c d
    @Override
    public String particularMethod(String name) {
//        if xxx 判断
        BaseExecutor baseExecutor = baseExecutorMap.get(name);
        baseExecutor.particularMethod(name);
//        System.out.println(name + " invoke ABaseExecutorImpl#particularMethod()");
        return name + " invoke ABaseExecutorImpl#particularMethod()";
    }

    // 新开一个接受参数的处理
    public String handle(String name){
        if (isA(name)){ // 走原有
            submitAdAll(name);
        }else { // 走新增bcd
            BaseExecutor executor = baseExecutorMap.get("name");
            executor.submitAdAll(name);
        }
        return name;
    }

    private boolean isA(String name) {
        return false;
    }

    @Override
    public String submitAdAll(String name){
        //do something
        System.out.println(name);
        return name;
    }
}
