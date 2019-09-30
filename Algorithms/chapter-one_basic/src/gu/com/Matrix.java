package gu.com;

import org.junit.Test;

import java.security.PublicKey;
import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {

    }

    @Test
    public void test01() {
        int A[][] = { { 1, 2, 0 }, { 3, 4, 0 }, { 5, 6, 0 } };
        int B[][] = { { 1, 2, 3, 1 }, { 3, 2 }, {} };
        try {
            int C[][] = multiplication(A, B);// 矩阵乘法
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C[0].length; j++) {
                    System.out.print(C[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("**********************");
            int CT[][] = transposed(C);// 矩阵转置
            for (int i = 0; i < CT.length; i++) {
                for (int j = 0; j < CT[0].length; j++) {
                    System.out.print(CT[i][j] + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public static int[][] fillMatrix(int[][] M) {
        int ml = 0;// 最长行
        for (int i = 0; i < M.length; i++) {
            ml = ml < M[i].length ? M[i].length : ml;
        }
        int Nm[][] = new int[M.length][ml];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                Nm[i][j] = M[i][j];
            }
        }
        return Nm;
    }



    public static int[][] multiplication(int[][] A, int[][] B) throws Exception {
        // 先判断A矩阵的列是否等于B矩阵的行，A矩阵与B矩阵可以进行乘法运算的条件就是A的列数等于B的行数
        A = fillMatrix(A);
        B = fillMatrix(B);
        if (A[0].length != B.length) {
            throw new Exception("矩阵A的列不等于矩阵B的行！");
        }
        int C[][] = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                for (int k = 0; k < A[i].length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static int[][] transposed(int[][] A) {
        A = fillMatrix(A);
        int[][] AT = new int[A[0].length][A.length];
        for (int i = 0; i < AT.length; i++) {
            for (int j = 0; j < AT[0].length; j++) {
                AT[i][j] = A[j][i];
            }
        }
        return AT;
    }



}
