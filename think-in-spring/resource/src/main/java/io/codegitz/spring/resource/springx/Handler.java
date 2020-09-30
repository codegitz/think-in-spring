package io.codegitz.spring.resource.springx;

import org.springframework.util.StreamUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @author 张观权
 * @date 2020/9/30 15:51
 **/
public class Handler extends sun.net.www.protocol.x.Handler {

    // 需要配置以下启动参数
    // -Djava.protocol.handler.pkgs=io.codegitz.spring.resource
    public static void main(String[] args) throws IOException {
        // springx协议
        URL url = new URL("springx:///META-INF/default.properties"); // 类似于 classpath://META-INF/default.properties
        InputStream inputStream = url.openStream();
        System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("UTF-8")));
    }
}
