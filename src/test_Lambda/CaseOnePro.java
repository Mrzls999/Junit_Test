package test_Lambda;

import little_case.Employee;
import little_case.MyDate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * 1. 调用 Collections.sort()方法，通过定制排序比较两个Employee (先按年龄比，年龄相同按姓名比),使用lambda作为参数传递
 * 利用内置的函数式接口，去实现这个需求
 */
public class CaseOnePro {
    public static void main(String[] args) {
        Employee employee1 = new Employee("zls",18,new MyDate("12","12","1111"));
        Employee employee2 = new Employee("zrs",17,new MyDate("12","12","1111"));
        Employee employee3 = new Employee("zxs",18,new MyDate("12","12","1111"));
        Employee employee4 = new Employee("zxx",16,new MyDate("12","12","1111"));
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(employee1);
        employeeArrayList.add(employee2);
        employeeArrayList.add(employee3);
        employeeArrayList.add(employee4);
        List<Employee> employeeList = func(employeeArrayList, employees -> {
            for (int i = 0; i < employees.size() - 1; i++) {
                for (int j = i+1; j < employees.size(); j++){
                    if (employees.get(i).getAge().equals(employees.get(j).getAge())) {
                        if (employees.get(i).getName().compareTo(employees.get(j).getName()) != 0) {
                            if (employees.get(i).getName().compareTo(employees.get(j).getName()) > 0) {
                                Collections.swap(employees, i, j);//如果名字小，则放到前边
                            }
                        }
                    } else if (employees.get(i).getAge() > employees.get(j).getAge()) {
                        Collections.swap(employees, i, j);//如果年龄小，则放到前边
                    }
                }
            }
            return employees;
        });
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    /**
     * 实现排序
     */
    public static List<Employee> func(List<Employee> employeeList, Function<List<Employee>,List<Employee>> fun){
        return fun.apply(employeeList);
    }
}
