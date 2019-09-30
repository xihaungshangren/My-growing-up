package gu.com.utils;

import java.util.Arrays;

/**
 * @Auther: gu
 * @Date: 2019/5/5 16:44
 * @Description: TODO
 */
public class Phone {
    private static String[] telFirst={"134","135","136","137","138","139","150","151","152","157","158","159","130","131","132","155","156","133","153",};
    public static long getTel(int heard) {
        String first;
        if (heard!=0 &&  Arrays.toString(telFirst).contains(String.valueOf(heard))){
            first=String.valueOf(heard);
        }else {
            int index=getNum(0,telFirst.length-1);
            first=telFirst[index];
        }
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return Long.parseLong((first+second+third));
    }

    public static long getTel() {
        String first;
        int index=getNum(0,telFirst.length-1);
        first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return Long.parseLong((first+second+third));
    }


    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }

    public static void main(String[] args) {
        System.out.println(getTel());
        System.out.println(getTel(135));

    }
}
