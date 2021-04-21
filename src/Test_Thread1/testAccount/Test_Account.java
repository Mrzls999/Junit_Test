package Test_Thread1.testAccount;

import java.math.BigDecimal;

/**
 * 银行有一个账户。 有两个储户分别向同一账户存3000元，每次存1000，存3次。每次存完打印账户余额
 *
 * 问题：该程序是否有安全问题，如果有，如何解决？
 *
 * 【提示】 1，明确哪些代码是多线程运行代码，须写入run()方法 2，明确什么是共享数据。 3，明确多线程运行代码中哪些语句是操作共享数据的。
 *
 * 拓展问题：可否实现两个储户交替存钱的操作
 */
public class Test_Account {

	public static void main(String[] args) {
		Account account = new Account("a001", BigDecimal.valueOf(0),0);

		//三个储户，同时操作一个账户
		Depositor depositor1 = new Depositor(account);
		Depositor depositor2 = new Depositor(account);
		Depositor depositor3 = new Depositor(account);

		new Thread(depositor1, "11").start();
		new Thread(depositor2, "22").start();
		new Thread(depositor3, "33").start();
	}

}
