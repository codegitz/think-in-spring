package io.codegitz.service.impl;

import io.codegitz.entity.User;
import io.codegitz.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * @author Codegitz
 * @date 2022/2/18 10:31
 **/
@Component
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) throws Exception {
        jdbcTemplate.update(
                "insert into user(name,age,sex) values (?,?,?)",
                new Object[]{user.getName(),user.getAge(),user.getSex()},
                new int[]{Types.VARCHAR,Types.INTEGER,Types.VARCHAR});
        // 抛出异常
        throw new RuntimeException("throws new exception manual");
    }
}
