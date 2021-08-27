package io.codegitz.service;

import io.codegitz.manager.ExecutorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Codegitz
 * @date 2021/8/27 10:27
 **/
@Service
public class DemoServiceSrv {

    @Value("${executorName:bBaseExecutorImpl}")
    public String EXECUTOR_NAME;

    @Autowired
    private ExecutorManager executorManager;

    public String invokeCommon(String name){
        return executorManager.execute(name,EXECUTOR_NAME);
    }

}
