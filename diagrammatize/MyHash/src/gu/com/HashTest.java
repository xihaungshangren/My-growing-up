package gu.com;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTest {
    private int DEFAULT_DATE=10;
    private Object[] DEFAULT;
    private int LENGTH;

    /**
     * 构造方法，构造一个初始化数组，可以定义初始数量
     */
    public HashTest() {
        this.DEFAULT=new Object[DEFAULT_DATE];
    }

    public HashTest(int size) {

        this.DEFAULT = new Object[size];
    }
    //存数据的方法
    public boolean put(String key,Integer value){
        int length = DEFAULT.length;
        //计算key值
        int hash = key.hashCode();
        int index=(hash & 0x7FFFFFFF) %DEFAULT.length;

        return true;
    }



}
