package cn.imusic.jconcurrent.p4;

class Account0 {
	private int balance;

	// 转账
	synchronized void transfer(Account0 target, int amt) {
		if (this.balance > amt) {
			this.balance -= amt;
			target.balance += amt;
		}
	}
}
