package javaSe.test_Scanner;

import java.util.Scanner;

/**
 * 起码 idea 2020.3 不用使用这个方法也能接受 scanner
 * 在IDEA中点击help->Edit Custom Vm Options…，进入，在最后一行加入：-Deditable.java.test.console=true
 */
public class TestScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("how many would you want?");
        int num = sc.nextInt();
        System.out.println("the num is " + num);
        @SuppressWarnings("unused")
        int a = 10;
    }
}
