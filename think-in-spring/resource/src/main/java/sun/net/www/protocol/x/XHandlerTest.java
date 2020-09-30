package sun.net.www.protocol.x;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.stream.Stream;

/**
 * X handler test
 * @author 张观权
 * @date 2020/9/30 15:33
 **/
public class XHandlerTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("x:///META-INF/default.properties"); // 类似于 classpath://META-INF/default.properties
         InputStream inputStream = url.openStream();
        System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("UTF-8")));
    }
}
