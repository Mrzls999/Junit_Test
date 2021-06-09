package javaSe.test_Thread_Communication.testDeposit;

import java.math.BigDecimal;

public class Depositor1 implements Runnable {

	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Depositor1() {
	}

	public Depositor1(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			account.save(BigDecimal.valueOf(1));
		}
	}

}
