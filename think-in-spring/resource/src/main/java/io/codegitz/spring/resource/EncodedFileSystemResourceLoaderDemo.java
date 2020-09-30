package io.codegitz.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * 带有字符编码的 {@link FileSystemResourceLoader} 示例
 * @author 张观权
 * @date 2020/9/29 16:46
 *
 * @see FileSystemResourceLoader
 * @see FileSystemResource
 * @see EncodedResource
 **/
public class EncodedFileSystemResourceLoaderDemo {
    public static void main(String[] args) throws IOException {
        String contentPath = "C:\\my_study_project\\spring-geek\\think-in-spring\\resource\\src\\main\\java\\io\\codegitz\\spring\\resouce\\EncodedFileSystemResourceDemo.java";
        // FileSystemResource => WritableResource => Resource
        FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
        Resource resource = fileSystemResourceLoader.getResource(contentPath);
        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
        // 字符输入流
        try(Reader reader = encodedResource.getReader()){
            System.out.println(IOUtils.toString(reader));
        }

    }
}
