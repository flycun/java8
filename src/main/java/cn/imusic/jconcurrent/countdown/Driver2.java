package cn.imusic.jconcurrent.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Driver2 { // ...
	void main() throws InterruptedException {
		CountDownLatch doneSignal = new CountDownLatch(10);
		Executor e = Executors.newFixedThreadPool(15);

		for (int i = 0; i < 10; ++i) // create and start threads
			e.execute(new WorkerRunnable(doneSignal, i));

		doneSignal.await(); // wait for all to finish
		System.out.println("end");
	}

	public static void main(String[] args) throws InterruptedException {
		Driver2 driver2 = new Driver2();
		driver2.main();
	}
}

class WorkerRunnable implements Runnable {
	private final CountDownLatch doneSignal;
	private final int i;

	WorkerRunnable(CountDownLatch doneSignal, int i) {
		this.doneSignal = doneSignal;
		this.i = i;
	}

	public void run() {
		doWork(i);
		doneSignal.countDown();
	}

	void doWork(int i) {
		System.out.println("do " + i);
	}
}