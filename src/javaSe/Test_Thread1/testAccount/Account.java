package javaSe.Test_Thread1.testAccount;

import java.math.BigDecimal;

/**
 * 银行 账户类
 */
public class Account {
	private String aid;// 账户 id
	private BigDecimal balance;// 账户余额
	private int count;

	public void save(BigDecimal money) {
		synchronized(this) {
			this.notify();
			while(count < 3) {
				this.setBalance(this.getBalance().add(money));
				count++;
				System.out.println(Thread.currentThread() + "余额：" + this.getBalance());
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Account() {
	}

	public Account(String aid, BigDecimal balance, int count) {
		this.aid = aid;
		this.balance = balance;
		this.count = count;
	}

	public String getId() {
		return aid;
	}

	public void setId(String aid) {
		this.aid = aid;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account{" + "aid='" + aid + '\'' + ", balance=" + balance +  '\'' + ", count=" + count +"}";
	}

}
