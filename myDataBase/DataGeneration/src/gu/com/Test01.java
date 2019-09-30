package gu.com;

import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;

import gu.com.utils.RandomWord;


import java.io.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Ybt_dev009 on 2019/4/18.
 */
public class Test01 {
    public static void main(String[] args) throws IOException {


    }

    public static void testBufferedWriter( String path ) throws IOException{
        //"E:\\downloads\\333.txt"
        BufferedWriter writer = new BufferedWriter(new FileWriter(path,true));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\downloads\\3500.txt"), "gbk"));
        String string="";
        while ( (string=reader.readLine())!=null ){
            if (string.equals("")) continue;
            String[] split = string.trim().split("\\s");
            for (int i = 0;i<split.length;i++){
                if ( (!split[i].trim().isEmpty()) && (!"\r\n".equals(split[i])) ){
                    writer.write(split[i]);
                    writer.newLine();
                }
            }
        }
        writer.flush();
        writer.close();
        reader.close();

    }
}
