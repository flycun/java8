package com.zc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一个内置锁只能对应一个条件队列，这有个缺陷，就是当一个锁对应多个条件谓词时，多个条件谓词只能公用一个条件队列，这时候唤醒等待线程时有可能出现唤醒丢失的情况。比如上面有界队列的情况，有两个条件谓词
 * isFull 和
 * isEmpty，当对两个条件谓词都进行wait()时，如果使用notify()方法来唤醒的话，只是会从条件队列中选取一个线程，并不知道这个线程是在哪个条件谓词上等待，这就出现了所谓的唤醒丢失的情况。所以使用内置条件队列时，最好使用notifyAll()方法来唤醒所有的线程，避免出现唤醒丢失这个活跃性问题。但是notifyAll是一个重的方法，它会带来大量的上下文切换和锁竞争。
 * 显式锁和显式条件队列避免了这个问题，一个显示锁可以对应多个条件Condition,一个Condition维护一个条件队列，这样对于多个条件谓词，比如isFull和isEmpty,可以使用两个Condition，对每个条件谓词单独await，唤醒时可以单独signal，效率更高。
 * 原文：https://blog.csdn.net/ITer_ZC/article/details/40651971
 *
 * @param <T>
 */
public class BlockingArrayWithCondition<T> {
	private final T[] array;

	private int head;

	private int tail;

	private int count;

	private java.util.concurrent.locks.Lock lock = new ReentrantLock();

	private Condition isFull = lock.newCondition();

	private Condition isEmpty = lock.newCondition();

	public BlockingArrayWithCondition(int size) {
		array = (T[]) new Object[size];
	}

	public void put(T item) throws InterruptedException {
		lock.lock();
		try {
			while (count == array.length) {
				System.out.println(Thread.currentThread().getName()+" isFull.await before");
				isFull.await();
			}

			array[tail] = item;
			if (++tail == array.length) {
				tail = 0;
			}
			count++;
			System.out.println(Thread.currentThread().getName()+" Add item: " + item);
			// 通知isEmpty条件队列有元素进入
			isEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public T take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0) {
				isEmpty.await();
			}

			T item = array[head];
			if (++head == array.length) {
				head = 0;
			}
			count--;
			System.out.println("Take item: " + item);
			// 通知isFull条件队列有元素出去
			isFull.signal();
			return item;
		} finally {
			lock.unlock();
		}
	}
}