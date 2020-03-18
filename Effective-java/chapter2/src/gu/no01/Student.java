package gu.no01;

import com.sun.org.apache.xalan.internal.xsltc.dom.SingletonIterator;
import gu.no01.Foo;

public class Student {
    String name;
    int age;
    public static void test(){
        Foo sd = Foo.getInstance("sd");
        System.out.println(sd);
    }

    public static void main(String[] args) {
        test();
        SingletonIterator singletonIterator;
    }
}
