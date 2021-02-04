package io.codegitz.spring.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author 张观权
 * @date 2021/2/3 12:19
 **/
@RunWith(PowerMockRunner.class)
public class UserUtilsTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserUtils userUtils;

    @Test
    public void test(){

        Mockito.when(userService.getName()).thenReturn("bb");
        String aa = userUtils.getName("aa");
        System.out.println(aa);

    }
}
