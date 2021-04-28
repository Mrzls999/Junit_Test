package test_Lambda;

/**
 * 介绍 lambda 的语法
 */
public class CaseZero {
    /**
     * 左侧：Lambda 表达式实现函数式接口中抽象方法的参数列表
     * 右侧：Lambda 表达式实现函数式接口中抽象方法的方法体，即 lambda 体
     * 因此，lambda 表达式需要函数式接口的支持
     *
     * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口，函数式接口可以使用@FunctionalInterface 修饰，
     *          使用该注释修饰的接口，必须是函数式接口
     *
     * 语法方式一：无参数，无返回值
     *           () -> sout("My love");
     * 语法方式二：有一个参数，无返回值
     *           (x) -> sout(x);
     * 语法方式三：若参数列表只有一个参数时，小括号可以不写
     *           x -> sout(x);
     * 语法方式四：若两个以上的参数，抽象方法有返回值，并且有多条语句
     *          Comparator<Integer> com = (x,y) -> {
     *              sout("lambda体中多条语句用大括号");
     *              return Integer.compare(x,y);
     *          }
     * 语法方式五：若 Lambda 体中只有一条语句，大括号和 return 都可以省略不写
     *          Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
     * 语法方式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为java编译器默认通过上下文推断出数据类型，即“类型推断”
     *          Comparator<Integer> com = (Integer x,Integer y) -> Integer.compare(x,y);
     */
}
