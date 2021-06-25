package io.codegitz.spring.common.mistakes.manger;

import io.codegitz.spring.common.mistakes.service.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author 张观权
 * @date 2021/4/28 14:34
 **/
@Component
public class LightMgrService {

    @Autowired
    private LightService lightService;

    public LightMgrService(LightService lightService){
        this.lightService = lightService;
        lightService.check();
    }
}
