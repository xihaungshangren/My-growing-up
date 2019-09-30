package gu.com;

import gu.com.utils.ChangCoding;
import gu.com.utils.GetId;
import gu.com.utils.Phone;
import gu.com.utils.RandomWord;

import java.io.*;
import java.lang.reflect.Field;

/**
 * @Auther: gu
 * @Date: 2019/5/5 15:28
 * @Description: TODO
 */
public class Start {
    public static void main(String[] args) throws IOException {
        //定义一个流，将字符输入
        BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\Mark_of_growth\\myDataBase\\DataGeneration\\src\\start.txt"));
        long tel ;
        String name ;
        long id;

        tel = Phone.getTel();
        name = RandomWord.randomNaming();
        id = GetId.getGuid();
        System.out.println("tel "+tel);
        System.out.println("name "+name);
        System.out.println("id "+id);
        String telB = ChangCoding.longToBinaryString(tel);
        String nameB=ChangCoding.stingToBinaryString(name);
        String idB = ChangCoding.longToBinaryString(id);
        writer.write(idB);
        writer.write(" ");
        writer.write(nameB);
        writer.write(" ");
        writer.write(telB);
        writer.close();
        test();
    }

    public static void test() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("E:\\Mark_of_growth\\myDataBase\\DataGeneration\\src\\start.txt"));
        String string = reader.readLine();
        String[] split = string.split("\\s");
        System.out.println(ChangCoding.binaryStringTolong(split[0]));
        System.out.println(ChangCoding.binaryStringToString(split[1]));
        System.out.println(ChangCoding.binaryStringTolong(split[2]));
        reader.close();
    }
}
