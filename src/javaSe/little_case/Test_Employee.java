package javaSe.little_case;

import org.junit.Test;

import java.util.TreeSet;

//1.实现 Comparable 接口并按 name 排序
//2.创建 TreeSet 时传入 Comparator 对象 并按生日进行排序
public class Test_Employee {
    Employee zls = new Employee("zls", 12, new MyDate("10", "3", "12"));
    Employee zrs = new Employee("zrs", 12, new MyDate("10", "3", "13"));
    Employee zxs = new Employee("zxs", 12, new MyDate("10", "3", "13"));
    Employee zxs1 = new Employee("zxs", 13, new MyDate("10", "3", "13"));
    Employee zs = new Employee("zs", 12, new MyDate("10", "3", "14"));
    Employee ls = new Employee("ls", 12, new MyDate("10", "3", "11"));

    //1.实现 Comparable 接口并按 name 排序
    @Test
    public void test_Comparable() {
        TreeSet<Employee> employees = new TreeSet<>();
        employees.add(zls);
        employees.add(zrs);
        employees.add(zxs);
        employees.add(zxs1);
        employees.add(zs);
        employees.add(ls);
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    //2.创建 TreeSet 时传入 Comparator 对象
    @Test
    public void test_Comparator() {
        TreeSet<Employee> employees = new TreeSet<>(new Employee());
        employees.add(zls);
        employees.add(zrs);
        employees.add(zxs);
        employees.add(zxs1);
        employees.add(zs);
        employees.add(ls);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}