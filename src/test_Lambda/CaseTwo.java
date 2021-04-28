//package test_Lambda;
//
//import org.junit.Test;
//
///**
// * 2 ① 声明函数式接口，接口中声明抽象方法，public String getValue(String str);
// * ② 声明类 CaseTwo ，类中编写方法使用接口作为参数，将一个字符串转换成大写，并作为方法的返回值。
// * ③ 再将一个字符串的第2个和第4个索引位置进行截取字串。
// */
//public class CaseTwo {
//    public static void main(String[] args) {
//        TTLambda tl = null;
//        getV(tl,"0123456789");
//    }
//    public static String getV(TTLambda tl,String str1){
//        tl = (str)->{
//            String s = str.toUpperCase();
//            return s.substring(1,4);
//        };
//        String value = tl.getValue(str1);
//        System.out.println(value);
//        return value;
//    }
//}
//
//@FunctionalInterface
//interface TTLambda{
//    public String getValue(String str);
//}


package test_Lambda;

import org.junit.Test;

/**
 * 2 ① 声明函数式接口，接口中声明抽象方法，public String getValue(String str);
 * ② 声明类 CaseTwo ，类中编写方法使用接口作为参数
 *
 */
public class CaseTwo {
    //将一个字符串转换成大写，并作为方法的返回值。
   @Test
   public void test_upperCase(){
       System.out.println(getV("abcd", s -> s.toUpperCase()));
   }

   //③ 将另一个个字符串的第2个和第4个索引位置进行截取字串。
   @Test
   public void test_split(){
       System.out.println(getV("0123456",s->s.substring(1,4)));
   }

    /**
     * 对一个字符串加工，并输出一个加工好的字符串的 通用方法
     */
    public String getV(String str1,TTLambda tl){
        return tl.getValue(str1);
    };
}
@FunctionalInterface
interface TTLambda{
    public String getValue(String str);
}