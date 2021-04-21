package Test_Thread1.testAccount;

import java.math.BigDecimal;

/**
 * 银行 储户类
 */
public class Depositor implements Runnable {
	private Account account;

	/**
	 *
	 */
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			account.save(BigDecimal.valueOf(1000));
		}
	}

	public Depositor() {
		super();
	}

	public Depositor(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
