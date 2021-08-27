package io.codegitz.base.impl;

import io.codegitz.base.common.CommonBaseExecutor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 * @author Codegitz
 * @date 2021/8/27 9:27
 **/
@Service("dBaseExecutorImpl")
@DependsOn("applicationUtils")
public class DBaseExecutor extends CommonBaseExecutor {
    @Override
    public String particularMethod(String name) {
        System.out.println(name + " invoke DBaseExecutorImpl#particularMethod()");
        return name + " invoke DBaseExecutorImpl#particularMethod()";
    }
}
