package io.codegitz.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * 带有字符编码的 {@link org.springframework.core.io.FileSystemResource} 示例
 * @author 张观权
 * @date 2020/9/29 16:46
 *
 * @see org.springframework.core.io.FileSystemResource
 * @see org.springframework.core.io.support.EncodedResource
 **/
public class EncodedFileSystemResourceDemo {
    public static void main(String[] args) throws IOException {
        String contentPath = "C:\\my_study_project\\spring-geek\\think-in-spring\\resource\\src\\main\\java\\io\\codegitz\\spring\\resouce\\EncodedFileSystemResourceDemo.java";
        File file = new File(contentPath);
        // FileSystemResource => WritableResource => Resource
        FileSystemResource fileSystemResource = new FileSystemResource(contentPath);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource,"UTF-8");
        // 字符输入流
        try(Reader reader = encodedResource.getReader()){
            System.out.println(IOUtils.toString(reader));
        }

    }
}
