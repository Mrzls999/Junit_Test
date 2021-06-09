package javaSe.Test_Thread;

public class Test_Creat_Thread1_and_Thread2 {
    public static void main(String[] args) {
        Creat_Thread1 thread1 = new Creat_Thread1();
        thread1.start();
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
