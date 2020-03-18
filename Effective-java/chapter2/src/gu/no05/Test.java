package gu.no05;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        test03();

    }

    /**
     * 发生内存泄漏，过期引用
     */
    private static void test01() {
        Stack stack = new Stack(1);
        for (int i = 0; i < 50000000; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 50000000; i++) {
            stack.pop();
        }
    }

    private static void test02() {
        Stack02 stack = new Stack02(1);
        for (int i = 0; i < 10000000; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 10000000; i++) {
            stack.pop();
        }
    }

    private static void test03() {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            integers.add(i);
        }
        for (int i = 100000000; i < 1; --i) {
            integers.remove(i);
        }
    }
}
