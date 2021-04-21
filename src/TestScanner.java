import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Scanner;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

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
