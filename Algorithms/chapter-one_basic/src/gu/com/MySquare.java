package gu.com;

import org.junit.Test;

public class MySquare {
    public static void main(String[] args) {

        System.out.println(Math.sqrt(2));
        System.out.println(square(2));

    }


    public static double square(double c){
        if (c<0) return Double.NaN;
        //1e-15 :表示1乘以10的-15次方
        double err = 1e-15;
        double t = c;
        //abs(double a)该方法返回x的绝对值
        while (Math.abs(t - c/t) > err * t)
            t = (c/t + t) / 2.0;
        return t;

    }
}
