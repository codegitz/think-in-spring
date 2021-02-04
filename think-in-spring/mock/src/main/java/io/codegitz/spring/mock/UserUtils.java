package io.codegitz.spring.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author 张观权
 * @date 2021/2/3 12:17
 **/
@Service
public class UserUtils {

    @Autowired
    private UserService userService;

    public String getName(String name){
        if (!StringUtils.isEmpty(name)){
            return userService.getName();
        }
        return name;
    }

    public static void main(String[] args) {
        final int[] count = {0};
        System.out.println(count[0]);
        count[0]++;
        System.out.println(count[0]);
        if (count[0] < 2){
            System.out.println("bingo");
        }
    }
}
