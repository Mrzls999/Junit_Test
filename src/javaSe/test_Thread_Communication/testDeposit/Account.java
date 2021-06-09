package javaSe.test_Thread_Communication.testDeposit;

import java.math.BigDecimal;

public class Account {
	private BigDecimal balance = BigDecimal.valueOf(0);

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Account(BigDecimal balance) {
		this.balance = balance;
	}

	public Account() {

	}

	// 存钱方法
	public synchronized void save(BigDecimal money) {
		while (balance.compareTo(BigDecimal.valueOf(1)) == 0) {
			System.out.println("余额已满");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.balance = this.balance.add(money);
		this.notifyAll();
		System.out.println(Thread.currentThread() + "已存钱，余额：" + this.balance);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 取钱方法
	public synchronized void withDrawMoney(BigDecimal money) {
		while (balance.compareTo(BigDecimal.valueOf(0)) == 0 || balance.compareTo(BigDecimal.valueOf(0)) == -1) {
			System.out.println("余额不足");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.balance = this.balance.subtract(money);
		this.notifyAll();
		System.out.println(Thread.currentThread() + "已取钱，余额" + this.balance);

	}

}
