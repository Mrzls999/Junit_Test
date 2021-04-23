package test_Annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyInterface {
    String name() default "zzz";
    int age();
}

@MyInterface(name = "zls",age = 18)//@test_Annotation.MyInterface(age = 18)
class Test_MyInterface{

    @MyInterface(age=20)
    public String xxx(){
        return "My name is lll";
    }

    public static void main(String[] args) {
        //获取类上的注解
        Annotation[] annotations = Test_MyInterface.class.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
            MyInterface mi = (MyInterface)annotation;
            System.out.println(mi.name());
            System.out.println(mi.age());
        }
        //获取方法上的注解
        //先通过反射获取方法，再获取方法上的值
        Method[] methods = Test_MyInterface.class.getMethods();
        for (Method method : methods) {
            Annotation[] annotations1 = method.getAnnotations();
            for (Annotation annotation : annotations1) {
                System.out.println(annotation);
                MyInterface mI = (MyInterface) annotation;
                System.out.println(mI.name());
                System.out.println(mI.age());
            }
        }
    }
}