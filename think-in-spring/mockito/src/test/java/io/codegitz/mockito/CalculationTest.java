package io.codegitz.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import static reactor.core.publisher.Mono.when;

/**
 * @author 张观权
 * @date 2020/10/19 15:22
 **/
public class CalculationTest {

    @Mock
    Calculation calculation;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAdd(){
//        Calculation calculation = Mockito.mock(Calculation.class);
//        when(calculation.getId()).thenReturn(10);
        Mockito.when(calculation.getId()).thenReturn(1);
        Mockito.when(calculation.add(1,2)).thenReturn(3);
        assertEquals(3,calculation.getSum());
    }

    /**
     * 验证
     * @throws Exception
     */
    @Test
    public void testVerify() throws Exception {
        //mock creation
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.add("two");
        mockedList.add("two");
        mockedList.clear();

        //verification
        //验证是否调用过一次 mockedList.add("one")方法，若不是（0次或者大于一次），测试将不通过
        verify(mockedList).add("one");
        //验证调用过2次 mockedList.add("two")方法，若不是，测试将不通过
        verify(mockedList, times(2)).add("two");
        //验证是否调用过一次 mockedList.clear()方法，若没有（0次或者大于一次），测试将不通过
        verify(mockedList).clear();
    }

    /**
     * 测试 stub
     * @throws Exception
     */
    @Test
    public void testStubbing() throws Exception {
        //你可以mock具体的类，而不仅仅是接口
        LinkedList mockedList = mock(LinkedList.class);

        //设置桩
//        when(mockedList.get(0)).thenReturn("first");
//        when(mockedList.get(1)).thenThrow(new RuntimeException());

        //打印 "first"
        System.out.println(mockedList.get(0));

        //这里会抛runtime exception
        System.out.println(mockedList.get(1));

        //这里会打印 "null" 因为 get(999) 没有设置
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList).get(0);
    }

    /**
     * 参数匹配
     * @throws Exception
     */
    @Test
    public void testArgumentMatcher() throws Exception {
        LinkedList mockedList = mock(LinkedList.class);
        //用内置的参数匹配器来stub
//        when(mockedList.get(anyInt())).thenReturn("element");

        //打印 "element"
        System.out.println(mockedList.get(999));

        //你也可以用参数匹配器来验证，此处测试通过
        verify(mockedList).get(anyInt());
        //此处测试将不通过，因为没调用get(33)
        verify(mockedList).get(eq(33));
    }

    /**
     * 验证mock对象没有产生过交互
     */
    @Test
    public void testInteractionNeverHappened() {
        List mockOne = mock(List.class);
        List mockTwo = mock(List.class);

        //测试通过
        verifyZeroInteractions(mockOne, mockTwo);

        mockOne.add("");
        //测试不通过，因为mockTwo已经发生过交互了
//        verifyZeroInteractions(mockOne, mockTwo);
    }



}
