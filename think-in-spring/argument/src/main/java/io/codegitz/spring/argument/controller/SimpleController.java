package io.codegitz.spring.argument.controller;

import io.codegitz.spring.argument.entity.User;
import io.codegitz.spring.argument.vo.UserVo;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;

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

    @GetMapping(value = "/user/{name}/{age}")
    public User findUser(@PathVariable("name") String name,@PathVariable("age") Integer age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        System.out.println(user.toString());
        return user;
    }

    @GetMapping(value = "/sex/{sex:[MF]}")
    public void find(@PathVariable("sex") String sex){
        System.out.println(sex);
    }

    @PostMapping("/file")
    public void file(@RequestPart(name = "file") MultipartFile multipartFile) throws IOException {
        InputStream inputStream = multipartFile.getInputStream();
        String path = "C:\\my_study_project\\spring-geek\\think-in-spring\\argument\\src\\main\\java\\io\\codegitz\\spring\\argument\\controller";
        Assert.notNull(multipartFile,"file can not be null!");
        File tmp = new File(path, multipartFile.getOriginalFilename());
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        OutputStream outputStream = new FileOutputStream(tmp);
        outputStream.write(buffer);
        inputStream.close();
        outputStream.close();
        System.out.println("multipartFile.getOriginalFilename(): "+multipartFile.getOriginalFilename()+" ,multipartFile.getSize()： "+multipartFile.getSize()+" ,multipartFile.getContentType(): "+multipartFile.getContentType());
    }

    @GetMapping("/download")
    public String download(HttpServletResponse response) throws IOException {
        File dFile = new File("C:\\my_study_project\\spring-geek\\think-in-spring\\argument\\src\\main\\java\\io\\codegitz\\spring\\argument\\controller\\winmine.exe");
        InputStream inputStream = new FileInputStream(dFile);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(dFile.getName().getBytes()));
        response.addHeader("Content-Length", "" + dFile.length());
        response.getOutputStream().write(buffer);
        response.setContentType("application/octet-stream");
        return "success";
    }

}
