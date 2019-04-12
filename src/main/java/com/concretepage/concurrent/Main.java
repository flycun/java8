package com.concretepage.concurrent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
	public static void main(String[] args) {
		final int threadCount = 5;
		final ExecutorService service = Executors.newFixedThreadPool(threadCount);
//		final Task task = new LockUnlockDemo();
//		final Task task = new TryLockDemo();
		final Task task = new LockInterruptiblyDemo();
		for (int i=0; i< threadCount; i++) {
			service.execute(new Worker(task));
		}
		service.shutdown();
	}
} 