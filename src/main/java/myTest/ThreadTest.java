package myTest;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

/**
 * @author Stephen Cai
 * @date 2018-04-14 21:23
 */
public class ThreadTest {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(5,
            new BasicThreadFactory.Builder().namingPattern("josActivityService-pool-%d").daemon(true).build());
        final int[] num = {0};
        for (int i = 0; i < 100000000 ; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + num[0]++);
            });
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ":" +num[0]++);
            });
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ":" +num[0]++);
            });
            executorService.submit(() -> {
                throw new Exception("你愁啥");
                //System.out.println(Thread.currentThread().getName() + ":" +num[0]++);
            });
        }

    }
}
