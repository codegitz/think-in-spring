package io.codegitz.spring.annotation;

import org.springframework.util.StopWatch;

/**
 * {@link StopWatch} 示例
 * @author 张观权
 * @date 2020/10/29 14:47
 **/
public class TStopWatch {
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("task-1");
        Thread.currentThread().sleep(1000L);
        stopWatch.stop();
        stopWatch.start("task-2");
        Thread.currentThread().sleep(2000L);
        stopWatch.stop();
        stopWatch.start("task-3");
        Thread.currentThread().sleep(3000L);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        /**
         * 运行结果
         * StopWatch '': running time = 6005728000 ns
         * ---------------------------------------------
         * ns         %     Task name
         * ---------------------------------------------
         * 1000025400  017%  task-1
         * 2005936100  033%  task-2
         * 2999766500  050%  task-3
         */
    }
}
