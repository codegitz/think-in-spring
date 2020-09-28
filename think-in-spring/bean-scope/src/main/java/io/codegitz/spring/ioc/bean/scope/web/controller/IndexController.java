package io.codegitz.spring.ioc.bean.scope.web.controller;

import io.codegitz.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author 张观权
 * @date 2020/9/18 11:27
 **/
@Controller
public class IndexController {

    @Autowired
    private User user;

    @GetMapping("/index.html")
    public String index(Model model){
        // JSP EL 变量搜索路径 page -> request -> session -> application(servletContext)
        // userObject -> 渲染上下文
        // user对象存在servletContext，上下文名称:user
        model.addAttribute("userObject",user);
        return "index";
    }
}
