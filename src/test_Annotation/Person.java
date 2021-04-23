package test_Annotation;

import test_Annotation.MyTiger;

public class Person {

    public String name;
    public int age;

    @Override
    @MyTiger(value = "dafeige")
    public String toString() {
        return "test_Annotation.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
