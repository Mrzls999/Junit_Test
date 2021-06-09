package javaSe.test_Lambda;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 3 ① 声明一个带两个泛型的函数式接口，泛型类型为<T,R> T 为参数，R为返回值
 * ② 接口中声明对应抽象方法
 * ③ 在 CaseThree 类中声明方法，使用接口作为参数，
 *  计算 N 个 long 类型参数的和
 * ④ 再计算 N 个 long 类型参数的乘积
 */
public class CaseThree {
    //计算 N 个 long 类型数据的乘积
    @Test
    public void test_multi() {
        Long[] longs = {1L, 2L, 3L, 4L};
        ArrayList<Long> multi = get_mix_Multi(nums -> {
            ArrayList<Long> longArrayList = new ArrayList<>();
            Long multi_nums = 1L;
            for (Long num : nums) {
                multi_nums *= num;
            }
            longArrayList.add(multi_nums);
            return longArrayList;
        },longs);
        System.out.println(multi);
    }



    //计算 N 个 long 类型数据的和，虽然，这个地方不需要使用  ArrayList<Long> mix 这个类型的，但是我这，只是为了让他复杂一点 😀😀
    @Test
    public void test_mix() {
        Long[] longs = {1L, 2L, 3L, 4L};
        ArrayList<Long> mix = get_mix_Multi(nums -> {
            ArrayList<Long> longArrayList = new ArrayList<>();
            Long mix_nums = 0L;
            for (Long num : nums) {
                mix_nums += num;
            }
            longArrayList.add(mix_nums);
            return longArrayList;
        },longs);
        System.out.println(mix);
    }

    /**
     * 输入多个数据，计算他们，并将每一个指标，放到 List 中
     *
     * @param am   接口
     * @param nums 输入的数据
     * @return 通过这个接口加工后的数据
     */
    public ArrayList<Long> get_mix_Multi(And_Multi<Long, ArrayList<Long>> am, Long [] nums) {
        return am.and_Multi(nums);
    }
}

@FunctionalInterface
interface And_Multi<T, R> {
    public R and_Multi(T... t);
}
