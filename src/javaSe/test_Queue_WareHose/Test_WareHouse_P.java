package javaSe.test_Queue_WareHose;

import java.util.LinkedList;

/**
 * use LinkedList mock 栈功能
 */
public class Test_WareHouse_P {

    private LinkedList<String> list = new LinkedList<>();

    /**
     * 向 LinkedList 第一个位置添加元素
     */
    public void add(String str) {
        list.addFirst(str);
    }

    /**
     * 删除并得到 LinkedList 第一个位置的元素
     */
    public String get() {
        if (list.size() == 0) {
            return null;
        }
        return list.removeFirst();
    }
}
