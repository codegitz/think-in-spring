package io.codegitz.spring.resource;

import io.codegitz.spring.resource.util.ResourceUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 自定义{@link ResourcePatternResolver} 示例
 *
 * @author 张观权
 * @date 2020/9/30 13:20
 * @see ResourcePatternResolver
 * @see PathMatchingResourcePatternResolver
 * @see PathMatcher
 **/
public class CustomizedResourcePatternResolverDemo {
    public static void main(String[] args) throws IOException {

        // 读取当前 package 下所有的 .java 文件

        String currentPackagePath = "C:/my_study_project/spring-geek/think-in-spring/resource/src/main/java/io/codegitz/spring/resource/";

        String locationPattern = currentPackagePath + "*.java";

        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());

//        pathMatchingResourcePatternResolver.setPathMatcher(new AntPathMatcher());

        pathMatchingResourcePatternResolver.setPathMatcher(new JavaFilePathMatcher());

        Resource[] resource = pathMatchingResourcePatternResolver.getResources(locationPattern);

        Stream.of(resource).map(ResourceUtils::getContent).forEach(System.out::println);
    }

    static class JavaFilePathMatcher implements PathMatcher {
        @Override
        public boolean isPattern(String path) {
            return path.endsWith(".java");
        }

        @Override
        public boolean match(String pattern, String path) {
            return path.endsWith(".java");
        }

        @Override
        public boolean matchStart(String pattern, String path) {
            return false;
        }

        @Override
        public String extractPathWithinPattern(String pattern, String path) {
            return null;
        }

        @Override
        public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
            return null;
        }

        @Override
        public Comparator<String> getPatternComparator(String path) {
            return null;
        }

        @Override
        public String combine(String pattern1, String pattern2) {
            return null;
        }
    }
}
