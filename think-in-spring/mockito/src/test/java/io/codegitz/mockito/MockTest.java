package io.codegitz.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @Mock 注解
 * @author 张观权
 * @date 2020/10/19 16:47
 **/
public class MockTest {

    @Mock
    List<String> mockedList;

    @Before
    public void initMocks() {
        //必须,否则注解无效
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMock() throws Exception {
        mockedList.add("one");
        verify(mockedList).add("one");
    }


    /**
     * 根据调用顺序设置不同的stubbing
     * @throws Exception
     */
    @Test
    public void testStubbingConsecutiveCalls() throws Exception {

        MockInterface mock = mock(MockInterface.class);
        when(mock.print("some arg")).thenThrow(new RuntimeException()).thenReturn("foo");

        //第一次调用，抛RuntimeException
        mock.print("some arg");

        //第二次调用返回foo
        System.out.println(mock.print("some arg"));

        //后续继续调用，返回“foo”，以最后一个stub为准
        System.out.println(mock.print("some arg"));

        //下面是一个更简洁的写法
        when(mock.print("some arg")).thenReturn("one", "two", "three");
    }


    /**
     * doReturn()|doThrow()| doAnswer()|doNothing()|doCallRealMethod()等用法
     * @throws Exception
     */
    @Test
    public void testDoXXX() throws Exception {
        List mockedList = mock(List.class);
        doThrow(new RuntimeException()).when(mockedList).clear();
        //以下会抛异常
        mockedList.clear();
    }


    /**
     * 参数捕捉
     * @throws Exception
     */
    @Test
    public void testCapturingArguments() throws Exception {
        List mockedList = mock(List.class);
        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        mockedList.add("John");
        //验证后再捕捉参数
        verify(mockedList).add(argument.capture());
        //验证参数
        assertEquals("John", argument.getValue());
    }


    /**
     * spy监视真正的对象
     * spy是创建一个拷贝，如果你保留原始的list，并用它来进行操作，那么spy并不能检测到其交互
     * spy一个真正的对象+试图stub一个final方法，这样是会有问题的
     * @throws Exception
     */
    @Test
    public void testSpy() throws Exception {
        List list = new LinkedList();
        List spy = spy(list);

        //可选的，你可以stub某些方法
        when(spy.size()).thenReturn(100);

        //调用"真正"的方法
        spy.add("one");
        spy.add("two");

        //打印one
        System.out.println(spy.get(0));

        //size()方法被stub了，打印100
        System.out.println(spy.size());

        //可选，验证spy对象的行为
        verify(spy).add("one");
        verify(spy).add("two");

        //下面写法有问题，spy.get(10)会抛IndexOutOfBoundsException异常
        when(spy.get(10)).thenReturn("foo");
        //可用以下方式
        doReturn("foo").when(spy).get(10);
    }


    /**
     * 为未stub的方法设置默认返回值
     * @throws Exception
     */
    @Test
    public void testDefaultValue() throws Exception {

        List listOne = mock(List.class, Mockito.RETURNS_SMART_NULLS);
        List listTwo = mock(List.class, new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                //  return default value here
                return null;
            }
        });
    }


    /**
     * 重置Mock
     * @throws Exception
     */
    @Test
    public void testReset() throws Exception {
        List mock = mock(List.class);
        when(mock.size()).thenReturn(10);
        mock.add(1);
        reset(mock);
        //从这开始，之前的交互和stub将全部失效
    }

    /**
     * 查看是否mock或者spy
     */
    public void isSpyOrMock(){
        Mockito.mockingDetails(new Object()).isMock();
        Mockito.mockingDetails(new Object()).isSpy();
    }
}
