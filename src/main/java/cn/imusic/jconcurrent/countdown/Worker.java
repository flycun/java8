package cn.imusic.jconcurrent.countdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Worker implements Runnable {
    private List<String> outputScraper;
    private CountDownLatch countDownLatch;
 
    public Worker(List<String> outputScraper, CountDownLatch countDownLatch) {
        this.outputScraper = outputScraper;
        this.countDownLatch = countDownLatch;
    }
 
    @Override
    public void run() {
        doSomeWork();
        outputScraper.add("Counted down");
        countDownLatch.countDown();
    }

	private void doSomeWork() {
		// TODO Auto-generated method stub
		
	}
	
	public void whenParallelProcessing_thenMainThreadWillBlockUntilCompletion()
	  throws InterruptedException {
	 
	    List<String> outputScraper = Collections.synchronizedList(new ArrayList<>());
	    CountDownLatch countDownLatch = new CountDownLatch(5);
	    List<Thread> workers = Stream
	      .generate(() -> new Thread(new Worker(outputScraper, countDownLatch)))
	      .limit(5)
	      .collect(Collectors.toList());
	 
	      workers.forEach(Thread::start);
	      countDownLatch.await(); 
	      outputScraper.add("Latch released");
	 
	      outputScraper.forEach(System.out::printf);
	    }
	
	public static void main(String[] args) {
		
	}
}