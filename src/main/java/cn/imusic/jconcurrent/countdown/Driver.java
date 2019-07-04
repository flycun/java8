package cn.imusic.jconcurrent.countdown;

import java.util.concurrent.CountDownLatch;

import com.sun.org.apache.bcel.internal.generic.DREM;

public class Driver { // ...
	void main() throws InterruptedException {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(10);

		for (int i = 0; i < 10; ++i) // create and start threads
			new Thread(new Worker2(startSignal, doneSignal)).start();

		doSomethingElse(); // don't let run yet
		startSignal.countDown(); // let all threads proceed
		doSomethingElse();
		doneSignal.await(); // wait for all to finish
	}

	private void doSomethingElse() {
		System.out.println("do some thing else");

	}
	
	public static void main(String[] args) throws InterruptedException {
		Driver driver=new Driver();
		driver.main();
	}
}

class Worker2 implements Runnable {
	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;

	Worker2(CountDownLatch startSignal, CountDownLatch doneSignal) {
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
	}

	public void run() {
		try {
			startSignal.await();
			doWork();
			doneSignal.countDown();
		} catch (InterruptedException ex) {
		} // return;
	}

	void doWork() {
		System.out.println("do work ...");
	}
}