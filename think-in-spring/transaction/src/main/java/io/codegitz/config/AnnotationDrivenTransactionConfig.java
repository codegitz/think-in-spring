package io.codegitz.config;

import io.codegitz.service.UserService;
import io.codegitz.service.impl.UserServiceImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Codegitz
 * @date 2022/2/28 15:24
 **/
@EnableTransactionManagement
@Configuration
public class AnnotationDrivenTransactionConfig {

    @Bean
    public UserService userService(DataSource dataSource){
        UserServiceImpl userService = new UserServiceImpl();
        userService.setDataSource(dataSource);
        return userService;
    }

    @Bean
    public TransactionManager getTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public DataSource getDataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/transaction");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("123456");
        basicDataSource.setInitialSize(1);
        basicDataSource.setMaxActive(300);
        basicDataSource.setMaxIdle(2);
        basicDataSource.setMinEvictableIdleTimeMillis(1);
        return basicDataSource;
    }
}
