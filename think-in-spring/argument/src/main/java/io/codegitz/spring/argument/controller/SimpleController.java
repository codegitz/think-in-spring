package io.codegitz.spring.argument.controller;

import io.codegitz.spring.argument.entity.User;
import io.codegitz.spring.argument.vo.UserVo;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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

    /**
     * map 参数接收
     * @param param
     * @return
     */
    @PostMapping("/map")
    public String map(Map<String,Object> param){
        System.out.println(param.get("name"));
        System.out.println(param.get("age"));
        return "success";
    }

    @PostMapping("/map2")
    public String map2(@RequestParam Map<String,Object> param){
        System.out.println(param.get("name"));
        System.out.println(param.get("age"));
        return "success";
    }

    /**
     * MultipartFile集合-批量文件上传
     */
    @PostMapping("/batch")
    public void batch(MultipartHttpServletRequest request){
        List<MultipartFile> files = request.getFiles("file");
        files.forEach(f ->{
            System.out.println(f.getOriginalFilename());
        });
    }

    @PostMapping("/batch2")
    public void batch2(@RequestParam(name = "file") List<MultipartFile> files){
        files.forEach(f ->{
            System.out.println(f.getOriginalFilename());
        });
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String encode = URLEncoder.encode("接驳点导入模板.xlsx", "UTF-8");
        //%E6%8E%A5%E9%A9%B3%E7%82%B9%E5%AF%BC%E5%85%A5%E6%A8%A1%E6%9D%BF.xlsx
        System.out.println(encode);
        String decode = URLDecoder.decode("%E6%8E%A5%E9%A9%B3%E7%82%B9%E5%AF%BC%E5%85%A5%E6%A8%A1%E6%9D%BF.xlsx", "UTF-8");
        System.out.println(decode);
    }


}
