package io.codegitz.controller;

import io.codegitz.service.DemoServiceSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Codegitz
 * @date 2021/8/27 9:51
 **/
@RestController
public class DemoManageController {

    @Autowired
    private DemoServiceSrv demoServiceSrv;

    @RequestMapping("/demo")
    public String demo(@RequestParam("name") String name){
        return demoServiceSrv.invokeCommon(name);
    }

}
