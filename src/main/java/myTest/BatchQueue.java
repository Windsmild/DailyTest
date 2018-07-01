package myTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Stephen Cai
 * @date 2018-06-24 17:01
 */
public class BatchQueue {

    public static void blockQueue() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
        final int[] i = {1};
        BlockingQueue<String> queue = new ArrayBlockingQueue(10);
        //for (int i = 0; i < 1000; i++) {
        //   queue.put("" + i) ;
        //}
        Thread t1 = new Thread(() -> {
            try {
                queue.put("" + i[0]) ;
                System.out.println("queue put:"+i[0]);
                i[0]++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("queue take:"+queue.take());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        while (true) {
            service.submit(t1);
            //service.submit(t2);
        }

        //Thread.sleep(100000000);
        //System.out.println(queue.poll());
        //List<String> temp = Lists.newArrayList();
        //queue.drainTo(temp);
    }
    public static void main(String[] args) throws InterruptedException {
        blockQueue();
    }
}
