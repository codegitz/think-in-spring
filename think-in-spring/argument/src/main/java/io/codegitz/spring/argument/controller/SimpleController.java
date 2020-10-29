package io.codegitz.spring.argument.controller;

import io.codegitz.spring.argument.entity.User;
import io.codegitz.spring.argument.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * GET方法请求参数处理
 *
 * @author 张观权
 * @date 2020/10/29 17:15
 **/
@RestController
public class SimpleController {

    @GetMapping("/get1")
    public void get1(@RequestParam("name") String name, @RequestParam("age") String age) {
        System.out.println("name: " + name + ",age: " + age);
    }

    @GetMapping("/get2")
    public void get2(UserVo userVo) {
        System.out.println(userVo.toString());
    }

    @GetMapping("/get3")
    public void get3(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name: " + name + ",age: " + age);
    }

    @PostMapping("/post")
    public void post(@RequestParam("name") String name, @RequestParam("age") String age) {
        System.out.println("name: " + name + ",age: " + age);
    }

    @PostMapping(value = "/user")
    public User saveUser(User user) {
        System.out.println(user.toString());
        return user;
    }

    @PostMapping(value = "/user2")
    public User saveUser2(@RequestBody User user) {
        System.out.println(user.toString());
        return user;
    }

}
