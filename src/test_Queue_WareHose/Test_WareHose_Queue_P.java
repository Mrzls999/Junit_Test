package test_Queue_WareHose;

import org.junit.Test;

public class Test_WareHose_Queue_P {
    /**
     * test 栈
     */
    @Test
    public void test_WareHose_P() {
        Test_WareHouse_P wareHouse_p = new Test_WareHouse_P();
        wareHouse_p.add("zls");
        wareHouse_p.add("zrs");
        wareHouse_p.add("zxs");
        int i = 0;
        while (i < 3) {
            System.out.println(wareHouse_p.get());
            i++;
        }
    }

    /**
     * test 队列
     */
    @Test
    public void test_Queue_P() {
        Test_Queue_P queue_P = new Test_Queue_P();
        queue_P.add("zls");
        queue_P.add("zrs");
        queue_P.add("zxs");
        int i = 0;
        while (i < 3) {
            System.out.println(queue_P.get());
            i++;
        }
    }
}
