package javaSe.Test_Thread1;

import java.util.ArrayList;
import java.util.Random;

/**
 * 1. 编写程序，在main方法中创建一个线程。线程每隔一定时间（200ms以内的随机时间）产生一个0-100之间的随机整数，将该整数放到集合中；
 * 2. 共产生100个整数，全部产生后，睡眠30s，然后将集合内容输出；
 * 3. 在main线程中，唤醒上述睡眠的线程，使其尽快打印集合
 */
public class Test_sleep_interrupt {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            ArrayList<Integer> nums = new ArrayList<>();
            int count = 0;

            @Override
            public void run() {
                while (count < 100) {//产生100个整数后，就停止了
                    nums.add(new Random().nextInt(100));//产生一个0-100之间的随机整数，将该整数放到集合中
                    count++;
                    try {
                        Thread.sleep(new Random().nextInt(200));//线程每隔一定时间（200ms以内的随机时间）
                    } catch (InterruptedException ignored) {//捕获异常，但并不打印，因为是唤醒它
                    }
                }
                //产生100个整数后
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException ignored) {
                }
                for (Integer num : nums) {//循环打印
                    System.out.println(num);
                }
            }
        });
        thread1.start();//启动线程
        while (thread1.isAlive()) {//如果线程还活着，就尝试停止阻塞，唤醒它
            thread1.interrupt();
        }
    }
}
