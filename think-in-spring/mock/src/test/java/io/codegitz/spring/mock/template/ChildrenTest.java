package io.codegitz.spring.mock.template;

import io.codegitz.spring.mock.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * @author 张观权
 * @date 2021/2/4 11:15
 **/
@RunWith(PowerMockRunner.class)
public class ChildrenTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private Children children;

    @Test
    public void test(){
        Whitebox.setInternalState(children,"userService",userService);
        Mockito.when(userService.getName()).thenReturn(" codegitz!");
        String methodInvokeSuper = children.childrenMethodInvokeSuper();
        Assert.assertEquals("hello,super codegitz!",methodInvokeSuper);
        System.out.println(methodInvokeSuper);
    }

    @Test
    public void getLianLuSmsConfigDTO(){
        Whitebox.setInternalState(children,"userService",userService);
        Mockito.when(userService.getName()).thenReturn(" codegitz!");
        String lianLuSmsConfigDTO = children.getLianLuSmsConfigDTO();
        System.out.println(lianLuSmsConfigDTO);
    }

}
