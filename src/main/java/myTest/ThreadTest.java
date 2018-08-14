package myTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

/**
 * @author Stephen Cai
 * @date 2018-04-14 21:23
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor= new ScheduledThreadPoolExecutor(5,
            new BasicThreadFactory.Builder().namingPattern("josActivityService-pool-%d").daemon(true).build());
        //final int[] num = {0};
        //for (int i = 0; i < 100000000 ; i++) {
        //    executor.submit(() -> {
        //        System.out.println(Thread.currentThread().getName() + ":" + num[0]++);
        //    });
        //    executor.submit(() -> {
        //        System.out.println(Thread.currentThread().getName() + ":" +num[0]++);
        //    });
        //    executor.submit(() -> {
        //        System.out.println(Thread.currentThread().getName() + ":" +num[0]++);
        //    });
        //    executor.submit(() -> {
        //        throw new Exception("你愁啥");
        //        //System.out.println(Thread.currentThread().getName() + ":" +num[0]++);
        //    });
        //}

        Task task = new Task();
        Future<Integer> future = executor.submit(task);
        //executor.shutdown();

        try {
            //取得结果，同时设置超时执行时间为8分钟。同样可以用future.get()，不设置执行超时时间取得结果
            System.out.println("get"+future.get(8, TimeUnit.SECONDS));
        } catch (Exception e) {
            future.cancel(true);
        }

        future = executor.submit(task);
        try {
            //取得结果，同时设置超时执行时间为8分钟。同样可以用future.get()，不设置执行超时时间取得结果
            System.out.println("get"+future.get(8, TimeUnit.SECONDS));
        } catch (Exception e) {
            future.cancel(true);
        }


        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕\n------------------------");

        FutureTask<?> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                for(int i=0;i<10000&&!Thread.currentThread().isInterrupted();i++){
                    //Thread.sleep(1);
                    System.out.println(i);
                }
                return null;
            }
        });
        executor.execute(futureTask);
        System.out.println("futureTask start");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        futureTask.cancel(true);
        System.out.println("futureTask cancel");
        Thread.sleep(1000);

    }

}

class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        int i = 0;
        for (i = 0; i <2; i++) {
            System.out.println("第" + i + "秒");
            Thread.sleep(1000);
        }
        return i;
    }
}
