package io.codegitz.mockito;

/**
 * @author 张观权
 * @date 2020/10/19 17:00
 **/
public class MockInterfaceImpl implements MockInterface{
    @Override
    public String print(String msg) {
        return msg;
    }
}
