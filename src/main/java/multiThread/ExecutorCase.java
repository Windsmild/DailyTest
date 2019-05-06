package multiThread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 深入分析java线程池的实现原理
 * http://www.jianshu.com/p/87bff5cc8d8c
 * Created by Stephen Cai on 2017-07-28 17:01.
 */
public class ExecutorCase {
	private static Executor executor = Executors.newFixedThreadPool(10);

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			executor.execute(new Task());
		}
	}

	static class Task implements Runnable {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
	}

}
