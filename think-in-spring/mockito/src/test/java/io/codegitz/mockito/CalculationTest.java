package io.codegitz.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
}
