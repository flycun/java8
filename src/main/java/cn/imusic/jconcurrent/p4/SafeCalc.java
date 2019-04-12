package cn.imusic.jconcurrent.p4;

class SafeCalc {
	long value = 0L;

	long get() {
		synchronized (new Object()) {
			return value;
		}
	}

	void addOne() {
		synchronized (new Object()) {
			value += 1;
		}
	}
}
