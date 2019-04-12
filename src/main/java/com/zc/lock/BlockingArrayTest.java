package com.zc.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class BlockingArrayTest {
	public static void main(String[] args) {
//		 final BlockingArray<Integer> blockingArray = new BlockingArray<Integer>(2);

		final BlockingArrayWithCondition<Integer> blockingArray = new BlockingArrayWithCondition<Integer>(2);

		final AtomicInteger count = new AtomicInteger(-1);

		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				try {
					blockingArray.put(count.incrementAndGet());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
			;

		}

		for (int i = 0; i < 10; i++) {

			new Thread(() -> {
				try {
					blockingArray.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}).start();
			;
		}

	}
}