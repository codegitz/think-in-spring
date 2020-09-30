package sun.net.www.protocol.x;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author 张观权
 * @date 2020/9/30 15:26
 **/
public class XConnection extends URLConnection {

    private final ClassPathResource resource;

    protected XConnection(URL url) {
        super(url);
        this.resource = new ClassPathResource(url.getPath());
    }

    @Override
    public void connect() throws IOException {

    }

    @Override
    public InputStream getInputStream() throws IOException {
        return resource.getInputStream();
    }
}
