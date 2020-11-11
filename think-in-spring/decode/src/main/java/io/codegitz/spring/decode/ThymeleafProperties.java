package io.codegitz.spring.decode;

/**
 * @author 张观权
 * @date 2020/11/11 11:55
 **/

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.MimeType;

import java.nio.charset.Charset;

@Configuration
public class ThymeleafProperties{

    private static final Charset DEFAULT_ENCODING = Charset.forName("UTF-8");

    private static final MimeType DEFAULT_CONTENT_TYPE = MimeType.valueOf("text/html");
    //规定了要thymeleaf所在的文件路径前缀是classpath:/templates/
    public static final String DEFAULT_PREFIX = "classpath:/templates/";
    //规定了thymeleaf所在文件的后缀名是  .html
    public static final String DEFAULT_SUFFIX = ".html";
    //就是说只要我们把HTML页面放在classpath:/templates/，thymeleaf就能自动渲染；

}