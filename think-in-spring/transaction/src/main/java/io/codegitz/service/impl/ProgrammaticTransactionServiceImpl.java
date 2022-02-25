package io.codegitz.service.impl;

import io.codegitz.entity.User;
import io.codegitz.service.ProgrammaticTransactionService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * @author Codegitz
 * @date 2022/2/24 11:15
 **/
public class ProgrammaticTransactionServiceImpl implements ProgrammaticTransactionService {

    private TransactionTemplate transactionTemplate;

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void insert(User user) {
        jdbcTemplate.update("insert into user(name,age,sex) values(?,?,?)"
                ,new Object[]{user.getName(),user.getAge(),user.getSex()}
                ,new int[]{Types.VARCHAR,Types.INTEGER,Types.VARCHAR});
        throw new RuntimeException("ex..");
    }

    @Override
    public User transactionInsert(User user) {
        return transactionTemplate.execute(new TransactionCallback<User>() {
            // the code in this method runs in a transactional context
            @Override
            public User doInTransaction(TransactionStatus status) {
                insert(user);
                return user;
            }
        });
    }
}
