package Test_Thread;

/**
 * 创建线程的第一种方式
 */
public class Creat_Thread1 extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
