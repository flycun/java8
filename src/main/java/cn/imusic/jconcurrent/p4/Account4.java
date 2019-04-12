package cn.imusic.jconcurrent.p4;

class Account4 {
	private int id;
	private int balance;

	// 转账
	void transfer(Account4 target, int amt) {
		Account4 left = this;
		Account4 right = target;
		if (this.id > target.id) {
			left = target;
			right = this;
		}
		// 锁定序号小的账户
		synchronized (left) {
			// 锁定序号大的账户
			synchronized (right) {
				if (this.balance > amt) {
					this.balance -= amt;
					target.balance += amt;
				}
			}
		}
	}
}
