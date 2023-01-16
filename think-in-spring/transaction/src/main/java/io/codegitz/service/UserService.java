package io.codegitz.service;

import io.codegitz.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Codegitz
<<<<<<< Updated upstream
 * @date 2022/2/18 10:28
 **/
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
public interface UserService {
    /**
     * 保存用户信息
     * @param user 用户信息
     */
    void save(User user) throws Exception;
=======
 * @date 2022/1/28 17:40
 **/
@Transactional(propagation = Propagation.REQUIRED)
public interface UserService {
    public void save(User user) throws Exception;
>>>>>>> Stashed changes
}
