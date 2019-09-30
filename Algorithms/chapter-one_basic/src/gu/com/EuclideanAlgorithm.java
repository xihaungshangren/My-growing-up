package gu.com;
import java.lang.Math;
import java.util.ArrayList;

public class EuclideanAlgorithm {
    public static void main(String[] args) {

        System.out.println(gcd(3, 5));
    }

    /**
     * 欧几里得算法，算最大公约数。
     *
     */
    public static int gcd(int p,int q){

        if (q==0) return p;
        int r =p%q;
        return gcd(q,r);
    }


    public static int rank(int key, int[] a, int lo, int hi) {
        //如果key存在于a[]中， 它的索引不会小于lo且不会大于hi
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else return mid;
    }
}
