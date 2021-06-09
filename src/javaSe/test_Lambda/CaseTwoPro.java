package javaSe.test_Lambda;

import org.junit.Test;

import java.util.function.Function;

/**
 * ①将一个字符串转换成大写，并作为方法的返回值。
 * ②将另一个个字符串的第2个和第4个索引位置进行截取字串。
 * ③对一个字符串加工，并输出一个加工好的字符串的 通用方法
 */
public class CaseTwoPro {
    /**
     * ①将一个字符串转换成大写，并作为方法的返回值。
     */
    @Test
    public void test1() {
        System.out.println(strHandler("my love is you", String::toUpperCase));//s->s.toUpperCase();lambda可以替换为方法引用
    }

    /**
     * ②将另一个个字符串的第2个和第4个索引位置进行截取字串。
     */
    @Test
    public void test2() {
        System.out.println(strHandler("0123456",s->s.substring(1,4)));
    }

    /**
     * ③对一个字符串加工，并输出一个加工好的字符串的 通用方法
     * @param str
     * @param fun
     * @return
     */
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }
}
