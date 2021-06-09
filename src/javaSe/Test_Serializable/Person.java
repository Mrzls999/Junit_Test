package javaSe.Test_Serializable;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1928341823489L;
    private String name;
    private int age;
    private static String nation = "z1";

    public Person() {
    }

    public Person(String name, int age, String nation) {
        this.name = name;
        this.age = age;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getNation() {
        return nation;
    }

    public static void setNation(String nation) {
        Person.nation = nation;
    }

    @Override
    public String toString() {
        return "javaSe.test_Annotation.Person{" +
                "name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", nation=" + nation +
                '}';
    }
}
