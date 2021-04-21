import Test_Serializable.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//将List转为数组时推荐使用第二种方法

public class Test_Collection {
    @Test
    public void test_toArray() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(4);
        //方法1 Object[] array = arrayList.toArray();
        //方法2 begin
        Integer[] array = new Integer[arrayList.size()];
        arrayList.toArray(array);
        for (Integer arr : array) {
            System.out.println(arr);
        }
        //方法2 end
    }
}
