package cn.imusic.jconcurrent.p4;

class Account2 {
	private int balance;

	// 转账
	void transfer(Account2 target, int amt) {
		synchronized (Account2.class) {
			if (this.balance > amt) {
				this.balance -= amt;
				target.balance += amt;
			}
		}
	}
}
