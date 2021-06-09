package javaSe.test_Lambda;

import javaSe.little_case.Employee;
import javaSe.little_case.MyDate;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 1. 调用 Collections.sort()方法，通过定制排序比较两个Employee (先按年龄比，年龄相同按姓名比),使用lambda作为参数传递
 *      Collections.reverse()将 list 集合倒置
 */
public class CaseOne {
    public static void main(String[] args) {
        Employee employee1 = new Employee("zls", 19, new MyDate("12", "12", "1333"));
        Employee employee2 = new Employee("zrs", 18, new MyDate("12", "12", "12"));
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return e1.getAge() - e2.getAge();
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
