package gu.com;


import org.junit.Test;

public class Test01 {
    public static void main(String[] args) {

    }

    @Test
    public void test010(){
        String str="我是谁水电费社我是舍我是谁饿哦水电费";
        System.out.println(str.indexOf("我是", 2));
        System.out.println(str.charAt(1));
        String s="0123re";
        System.out.println(s.charAt(4)>s.charAt(5));
    }
}
