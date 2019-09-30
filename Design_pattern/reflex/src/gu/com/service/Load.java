package gu.com.service;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Load {
    private static Load load = new Load();
    {
        System.out.println("非静态代码块1");
    };
    static{
        System.out.println("静态代码块");
    }

    public Load() {
        System.out.println("构造函数");
    }
    {
        System.out.println("非静态代码块2");
    };

    public static void main(String[] args) {
        Load load = new Load();
    }
}
