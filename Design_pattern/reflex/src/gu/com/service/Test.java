package gu.com.service;

import gu.com.domain.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId(123);
        student.setName("任天野");
        student.setAge(54);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        student.setList(list);
        Test test = new Test();
        System.out.println(int.class.getName());
        System.out.println("int--- "+test.getId(student));
    }
    public <T> Integer getId(T t){
        try {
            Class<?> tClass = t.getClass();
            Field[] declaredFields = tClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                String name = declaredField.getName();
                name = name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase());
                Method method = tClass.getMethod("get" + name);

                Type type = declaredField.getGenericType();
                System.out.println("****");
                System.out.print(type);
                System.out.println("--");
                if (type.equals("int")){
                    int aa =(int) method.invoke(t);
                    System.out.println("OK");
                    break;
                }
                System.out.println(type.toString());
                Object invoke = method.invoke(t);
                System.out.println(invoke);
                System.out.println("****");
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }
}
