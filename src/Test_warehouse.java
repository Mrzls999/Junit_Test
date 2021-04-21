import org.junit.Test;

import java.util.*;
// 测试栈功能  先进后出
public class Test_warehouse{

    static LinkedList<String> list = new LinkedList<>();
    @Test
    public void test_WareHouse() {
        Test_warehouse tt = new Test_warehouse();
        System.out.println(list);
        tt.add("zls");
        tt.add("zrs");
        tt.add("zxs");
        //取出元素之前
        System.out.println(list);
        //取出一个元素
        String first_Element = tt.poll();
        //取出元素之后
        System.out.println(list);
        //取出的元素为
        System.out.println(first_Element);
    }

    // 向链表中的第一个位置添加元素
    public void add(String str) {
        list.addFirst(str);
    }

    // 取出链表中的第一个元素
    public String poll(){
        String first_Element = list.removeFirst();
        return first_Element;
    }
}
