public class Person {

    public String name;
    public int age;

    @Override
    @MyTiger(value = "dafeige")
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
