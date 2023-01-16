package io.codegitz.mapper;

import io.codegitz.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Codegitz
 * @date 2022/1/28 17:38
 **/
public class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User person = new User();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        person.setSex(resultSet.getString("sex"));
        return person;
    }
}
