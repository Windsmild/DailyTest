package multiThread;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

/**
 * @author Stephen Cai
 * @date 2018-05-12 18:26
 */
public class PrimeCount {
    private static ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(3,
        new BasicThreadFactory.Builder().namingPattern("primeCount-pool-%d").daemon(true).build());

    ////取一个数，不能重复，最大到100000
    //private int incrCurrentNum() {
    //    synchronized (this) {     //如果不用锁，必然会出错。
    //        if (currentNum > 100000) {
    //            return -1;
    //        } else {
    //            int result = currentNum;
    //            currentNum++;
    //            return result;
    //        }
    //    }
    //}
    //
    ////把某个线程找到的素数个数加上
    //private void accPrimeCount(int count) {
    //    synchronized (this) {
    //        totalPrimeCount += count;
    //    }
    //}

    //一直取数并判断是否为素数，取不到了就把找到的个数累加
    //public void run() {
    //    int primeCount = 0;
    //    int num;
    //    while ((num = incrCurrentNum()) != -1) {
    //        if (isPrime(num)) {
    //            primeCount++;
    //        }
    //    }
    //    accPrimeCount(primeCount);
    //}

    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        AtomicInteger currentNum = new AtomicInteger(2);  //从2开始找
        AtomicInteger totalPrimeCount = new AtomicInteger(0);  //从2开始找
        Set<Integer> set = Sets.newConcurrentHashSet();
        while (currentNum.intValue() < 100000) {
            executorService.execute(() -> {
                System.out.println("currentNum:" + currentNum + " totalPrimeCount:" +totalPrimeCount + "set size:"+set.size());
                if (isPrime(currentNum.intValue())) {
                    totalPrimeCount.getAndAdd(1);
                    set.add(currentNum.intValue());
                }
                currentNum.getAndAdd(1);
            });
        }
        long end = System.currentTimeMillis();
        System.out.println(("jos syncActivity end cost " + (end - start) / 60000 + "分"));
        System.out.println("WTF");
        //if (executorService.awaitTermination(2, TimeUnit.SECONDS)) {
        //    System.out.println("task completed");
        //} else {
        //    System.out.println("Forcing shutdown...");
        //    executorService.shutdownNow();
        //}



        Thread.sleep(10000000);
    }
}
