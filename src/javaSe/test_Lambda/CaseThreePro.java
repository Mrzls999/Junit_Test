package javaSe.test_Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 *3
 * 计算 N 个 long 类型参数的和
 * 计算 N 个 long 类型参数的乘积
 */
public class CaseThreePro {

    @Test
    public void test1(){
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(1L);
        arrayList.add(2L);
        arrayList.add(3L);
        arrayList.add(4L);
        //得到和
        Long mixNums = getWant(arrayList, nums -> {
            Long mix = 0L;
            for (Long num : nums) {
                mix += num;
            }
            return mix;
        });
        System.out.println(mixNums);

        //得到积
        Long multiNums = getWant(arrayList, nums -> {
            Long multi = 1L;
            for (Long num : nums) {
                multi *= num;
            }
            return multi;
        });
        System.out.println(multiNums);
    }

    public Long getWant(ArrayList<Long> nums,Function<List<Long>,Long> fun){
        return fun.apply(nums);

    }
}
