package io.codegitz.manager;

import io.codegitz.base.BaseExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Codegitz
 * @date 2021/8/26 19:00
 **/
@Component
public class ExecutorManager {

    public static final String BASE_EXECUTOR_NAME = "commonBaseExecutorImpl";

    @Autowired
    private Map<String, BaseExecutor> baseExecutorMap;

    public String execute(String name,String executorExp){
        BaseExecutor baseExecutor = this.baseExecutorMap.get(executorExp);
        if (baseExecutorMap == null){
            return "cannot find baseExecutor";
        }
        // invoke baseMethod
        baseExecutor.baseMethod(name);
        // invoke subClass's particular method
//        baseExecutor.setBaseExecutor(baseExecutor.get(executorExp));
        return baseExecutor.particularMethod(name);
    }

}
