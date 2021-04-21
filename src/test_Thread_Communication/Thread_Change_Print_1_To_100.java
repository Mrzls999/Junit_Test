package test_Thread_Communication;

//test1: 使用两个线程交替打印1-100
public class Thread_Change_Print_1_To_100 implements Runnable{
	static int i = 0;
	@Override
	public void run() {
		while(true) {
			synchronized(this) {
				this.notify();
				if(i <= 100) {
					System.out.println(Thread.currentThread()+""+i++);
				}
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
