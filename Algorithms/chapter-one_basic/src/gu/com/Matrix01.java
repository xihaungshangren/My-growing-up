package gu.com;

import java.util.Arrays;

public class Matrix01 {
    public static void main(String[] args) {
        double[][] a;
        a = new double[2][3];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 3; j++)
                a[i][j] = 0.0;

        for (double[] doubles : a) {
            System.out.println(Arrays.toString(doubles));
        }
    }
}
