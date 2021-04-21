import java.util.LinkedList;

/**
 * use LinkedList mock Queue faction
 */
public class Test_Queue_P {
    private LinkedList<String> list = new LinkedList<>();

    /**
     * 向 LinkedList 第一个位置添加一个元素
     *
     * @param str
     */
    public void add(String str) {
        list.addFirst(str);
    }

    /**
     * 取出 LinkedList 最后位置的元素
     *
     * @return
     */
    public String get() {
        if (list.size() == 0) {

        }
        return list.removeLast();
    }
}
