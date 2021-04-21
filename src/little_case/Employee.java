package little_case;

import java.util.Comparator;
import java.util.Objects;

public class Employee implements Comparable<Employee>, Comparator<Employee> {
    private String name;
    private Integer age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, Integer age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return name.equals(employee.name) && age.equals(employee.age) && birthday.equals(employee.birthday);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age, birthday);
//    }

    @Override
    public int compareTo(Employee o) {
        int bg_name = this.getName().compareTo(o.getName());
        int bg_age = this.getAge().compareTo(o.getAge());
        if (bg_name == 0) {
            return bg_age;
        }
        return bg_name;
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        int o1_birthday = Integer.parseInt(o1.getBirthday().getYear() + o1.getBirthday().getMonth() + o1.getBirthday().getDay());
        int o2_birthday = Integer.parseInt(o2.getBirthday().getYear() + o2.getBirthday().getMonth() + o2.getBirthday().getDay());
        if (o1_birthday - o2_birthday != 0){
            return o1_birthday - o2_birthday;
        }else {
            return o1.compareTo(o2);
        }
    }
}
