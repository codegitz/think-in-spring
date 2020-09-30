package io.codegitz.spring.resource.util;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.io.Reader;

/**
 * {@link org.springframework.core.io.Resource} 工具类
 * @author 张观权
 * @date 2020/9/30 13:25
 **/
public interface ResourceUtils {


    static String getContent(Resource resource) {
        try {
            return getContent(resource,"UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String getContent(Resource resource, @Nullable String encoding) throws IOException {
        EncodedResource encodedResource = new EncodedResource(resource,encoding);
        // 字符输入流
        try(Reader reader = encodedResource.getReader()){
            return IOUtils.toString(reader);
        }
    }
}
