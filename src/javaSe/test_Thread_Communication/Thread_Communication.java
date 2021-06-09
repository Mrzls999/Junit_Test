package javaSe.test_Thread_Communication;

import org.junit.Test;

import javaSe.test_Thread_Communication.testDeposit.Account;
import javaSe.test_Thread_Communication.testDeposit.Depositor1;
import javaSe.test_Thread_Communication.testDeposit.Depositor2;

/**
 * 测试线程通信
 * 
 * @author zls
 */
public class Thread_Communication {

//	@Test//如果使用junit不能正常运行到结束的话，那么使用main方法
//	Thread_Change_Print_1_To_100
//	public void test1() {
//		Thread_Change_Print_1_To_100 tcp = new Thread_Change_Print_1_To_100();
//		new Thread(tcp,"11").start();
//		new Thread(tcp,"22").start();
//	}

//	public static void main(String[] args) {
//		Thread_Change_Print_1_To_100 tcp = new Thread_Change_Print_1_To_100();
//		new Thread(tcp,"11").start();
//		new Thread(tcp,"22").start();
//	}

	/*
	 * testCommunication: 测试 testDeposit 包下的东西
	 * 模拟银行账户，用户A 不断往该账户存钱，最多存款10000元，若账户已满，需要通知 用户B 取钱。
	 * 用户B 不断从该账户中取钱，当余额不足时，需要通知用户A 存钱。
	 */
//	@Test
//	public void testCommunication() {
//		Account account = new Account();
//		new Thread(new Depositor1(account),"11").start();
//		new Thread(new Depositor2(account),"22").start();
//	}
	
	public static void main(String[] args) {
		Account account = new Account();
		new Thread(new Depositor1(account),"11").start();
		new Thread(new Depositor2(account),"22").start();
		new Thread(new Depositor1(account),"33").start();
		new Thread(new Depositor2(account),"44").start();
	}

}
