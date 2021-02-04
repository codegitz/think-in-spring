package io.codegitz.spring.mock.template;

import io.codegitz.spring.mock.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author 张观权
 * @date 2021/2/4 11:15
 **/
@RunWith(PowerMockRunner.class)
public class ChildrenTest {
    @Mock
    private UserService userService;

    @Mock
    private Children children;

    @Test
    public void test(){
        String methodInvokeSuper = children.childrenMethodInvokeSuper();
        System.out.println(methodInvokeSuper);
    }

}
