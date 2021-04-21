import org.junit.Test;

import java.util.LinkedList;

// 利用LinkedList 模仿 队列的 使用
// 因为 junit测试相当于static main方法，又因为静态 方法内部无法使用 外部 变量，所以将list变为static了，这样可以全局共享一个变量
public class Test_Queue {
    static LinkedList<String> list = new LinkedList<>();
    @Test
    public void test_Queue(){
        Test_Queue queue = new Test_Queue();
        queue.add("zls");
        queue.add("zrs");
        queue.add("zxs");
        System.out.println("取出前："+list);
        System.out.println("取出的元素为："+queue.poll());
        System.out.println("取出后："+list);
    }

    /**
     * 添加元素
     * @param str
     */
    public void add(String str){
        list.addFirst(str);
    }

    /**
     * 移除第一个元素，并返回
     */
    public String poll(){
        return list.pollLast();
    }
}
