package gu.com.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ybt_dev009 on 2019/4/18.
 */
public class ChangCoding {

    //将二进制字符串转换成int数组
    public static int[] BinstrToIntArray(String binStr) {
        char[] temp=binStr.toCharArray();
        int[] result=new int[temp.length];
        for(int i=0;i<temp.length;i++) {
            result[i]=temp[i]-48;
        }
        return result;
    }


    //将二进制转换成字符
    public static char BinstrToChar(String binStr){
        int[] temp=BinstrToIntArray(binStr);
        int sum=0;
        for(int i=0; i<temp.length;i++){
            sum +=temp[temp.length-1-i]<<i;
        }
        return (char)sum;
    }

    /**
     * 将一个long数字转换为8个byte数组组成的数组.
     */
    public static byte[] longToByte8(long sum) {
        byte[] arr = new byte[8];
        arr[0] = (byte) (sum >> 56);
        arr[1] = (byte) (sum >> 48);
        arr[2] = (byte) (sum >> 40);
        arr[3] = (byte) (sum >> 32);
        arr[4] = (byte) (sum >> 24);
        arr[5] = (byte) (sum >> 16);
        arr[6] = (byte) (sum >> 8);
        arr[7] = (byte) (sum & 0xff);//取这个数低8位的值。
        return arr;
    }

    /**
     * 将long类型转换为64个 以0 or 1组成的byte数组
     * @param sum
     * @return
     */
    public static byte[] longToByte64(long sum) {
        byte[] arr = new byte[64];
        for (int i = 63; i >= 0; i--) {
            arr[i] = (byte) (sum & 1);
            sum >>= 1;
        }
        return arr;
    }

    /**
     * 将长度为64的byte数组转换为一个long类型值.
     *  每一个8位byte都只存储了0或1的数字.
     * @param arr
     * @return
     */
    public static long byte64ToLong(byte[] arr) {
        if (arr == null || arr.length != 64) {
            throw new IllegalArgumentException("byte数组必须不为空,并且长度是64!");
        }
        long sum = 0L;
        for (int i = 0; i < 64; ++i) {
            //每次位移后，造成 00...00100..00 的结果，
            //或运算 | 会不相同的成为 1，而其他位又是0
            sum |= ((long) arr[i] << (63 - i));
        }
        return sum;
    }



    /**
     * char 字符类型转换为 byte[] 类型
     * @param c
     * @return
     */
    public static byte[] charsToBytes(char c){
        byte[] arr = new byte[2];
        arr[0] = (byte) (c >> 8);
        arr[1] = (byte) (c & 0xff);
        return arr;
    }

    /**
     * 字符数组，转换为byte数组
     * @param chars
     * @return
     */
    public static byte[] charsToBytes(char[] chars){
        int length =0;
        length = chars.length*2;
        int index=0;
        byte[] bytes;
        byte[] result = new byte[length];
        //遍历char数组，
        for (char aChar : chars) {
            //将每个char转换为byte[] 数组
            //并且添加到 result[] 中
            bytes = charsToBytes(aChar);
            for (int i = 0; i < bytes.length; i++) {
                result[index] =bytes[i];
                index++;
            }
        }
        return result;
    }

    /**
     * 合并byte[]数组，
     * @param small
     * @param big
     * @param index
     * @return
     */
    private static byte[] mergeBytes(byte[] small,byte[] big,int index){
        for (int i = 0; i < small.length; i++) {
            byte b = small[i];
        }
        return null;
    }

    //byte转换为 二进制 并且以字符串的形式输出
    private static String byteToBinaryString(byte sum){

        byte[] bytes = new byte[8];
        for (int i = 7; i >= 0; i--) {
            bytes[i] = (byte) (sum & 1);
            sum >>= 1;
        }
        String string ="";
        for (int i = 0; i < bytes.length; i++) {
            string +=bytes[i];
        }
        return string;
    }

    public static String longToBinaryString(long n){
        byte[] bytes = longToByte8(n);
        StringBuffer buffer=new StringBuffer();
        for (byte aByte : bytes) {
            buffer.append(byteToBinaryString(aByte));
        }
        return buffer.toString();
    }

    public static String stingToBinaryString(String str){
        char[] chars = str.toCharArray();
        byte[] bytes = charsToBytes(chars);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte aByte : bytes) {
            stringBuilder.append(byteToBinaryString(aByte));
        }
        return stringBuilder.toString();
    }

    public static boolean isPower(int i) {
        if (i==1)return false;
        return (i & (i - 1)) == 0;
    }

    public static String binaryStringToString(String binaryString){
        int length = 0;
        int size =0;
        length = binaryString.length();
        if (length==0 && length%16 !=0){return "二进制字符串不完整";}
        size=length/16;
        char[] chars = new char[size];
        for (int i = 0; i < size; i++) {
            chars[i] = BinstrToChar(binaryString.substring(i * 16, (i + 1) * 16));
        }
        return new String(chars);
    }

    public static long binaryStringTolong(String string){
        if (string == null && string.length()!=64){
            System.out.println("二进制字符串有问题");
            return 0;
        }
        char[] chars = string.toCharArray();
        byte[] bytes = new byte[64];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] =Byte.valueOf( String.valueOf(chars[i]));
        }
        return byte64ToLong(bytes);
    }

    public static byte binaryStringToBytes(String binaryString){
        return 0;
    }
    public static void main(String[] args) throws Exception {
        long n=7l;
        String string = longToBinaryString(n);
        System.out.println(longToBinaryString(n));
        //00000000 00000000 00000000 00000000 00000000 00000000 00000000 00000111
//        System.out.println(binaryStringTolong(string));

    }



}
