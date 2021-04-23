package test_Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 测试 Collection 工具类
 */
public class Test_Collections {
    @Test
    public void testCollections(){
        List<String> list = new ArrayList<>();
        list.add("zls");
        list.add("zxs");
        list.add("zrs");
        Object[] objects = new Object[list.size()];
        List<Object> list1 = Arrays.asList(objects);
        Collections.copy(list1,list);
        for (Object s : list1) {
            System.out.println(s);
        }
    }
}
