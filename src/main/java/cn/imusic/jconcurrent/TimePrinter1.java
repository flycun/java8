package cn.imusic.jconcurrent;

import java.util.*;

class TimePrinter1 extends Thread {
	int pauseTime;
	String name;

	public TimePrinter1(int x, String n) {
		pauseTime = x;
		name = n;
	}

	public void run() {
		while (true) {
			try {
				System.out.println(name + ":" + new Date(System.currentTimeMillis()));
				Thread.sleep(pauseTime);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	static public void main(String args[]) {
		TimePrinter1 tp1 = new TimePrinter1(1000, "Fast Guy");
		tp1.start();
		TimePrinter1 tp2 = new TimePrinter1(3000, "Slow Guy");
		tp2.start();

	}
}