package sun.net.www.protocol.x;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * x 协议 {@link java.net.URLStreamHandler} 实现
 * 简易实现 : 实现 URLStreamHandler 并放置在sun.net.www.protocol.${protocol}.Handler下
 *
 * @author 张观权
 * @date 2020/9/30 15:25
 **/
public class Handler extends URLStreamHandler {
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return new XConnection(u);
    }
}
