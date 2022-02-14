package io.codegitz.spring.common.mistakes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

/**
 * @author 张观权
 * @date 2021/4/28 14:33
 **/
@EnableAerospikeRepositories
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("io.codegitz.spring.common.mistakes");
        ((AbstractApplicationContext)applicationContext).refresh();
        ((AbstractApplicationContext)applicationContext).close();
    }
}
