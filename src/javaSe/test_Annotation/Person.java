package javaSe.test_Annotation;

public class Person {

    public String name;
    public int age;

    @Override
    @MyTiger(value = "dafeige")
    public String toString() {
        return "javaSe.test_Annotation.Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
