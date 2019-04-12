package cn.imusic.jconcurrent.p4;
class Account1 {
  private Object lock;
  private int balance;
  private Account1() {}
  // 创建 Account 时传入同一个 lock 对象
  public Account1(Object lock) {
    this.lock = lock;
  } 
  // 转账
  void transfer(Account1 target, int amt){
    // 此处检查所有对象共享的锁
    synchronized(lock) {
      if (this.balance > amt) {
        this.balance -= amt;
        target.balance += amt;
      }
    }
  }
}
