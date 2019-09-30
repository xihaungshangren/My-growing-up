package gu.com.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: gu
 * @Date: 2019/5/5 15:09
 * @Description: TODO
 */
public class RandomWord {
    private static volatile Random random;
    public static Random getRandom(){
        if (random==null){
            synchronized (Random.class){
                if (random==null){
                    random=new Random();
                }
            }
        }
        return random;
    }

    /**
     * 随机生成一个中文字符
     * @return
     */
    public static String getRandomChinaChar() {

        String str = "";
        int highCode;
        int lowCode;

        highCode = (176 + Math.abs(getRandom().nextInt(39))); //B0 + 0~39(16~55) 一级汉字所占区
        lowCode = (161 + Math.abs(getRandom().nextInt(93))); //A1 + 0~93 每区有94个汉字

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(highCode)).byteValue();
        b[1] = (Integer.valueOf(lowCode)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 指定生成中文字数
     * @param num
     * @return
     */
    public static String getRandomChinaString(int num){
        String longString="";
        for (int i=0;i<num;i++){
            longString+=getRandomChinaChar();
        }
        return longString;
    }

    /**
     *  对百家姓.TXT进行整理，获取一个新的整理后的文本。
     * @param nowPath 要整理的文本路径,暂时写死了
     * @param beforePath 新文本路径，自己想要的路径
     * @throws IOException
     */
    public static void bufferedWriter( String beforePath,String nowPath ) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(nowPath,true));
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\downloads\\百家姓.txt"), "gbk"));
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


    //随机生成名字
    public static String randomNaming()throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\Mark_of_growth\\myDataBase\\DataGeneration\\src\\百家姓-整理后.txt")));
        String line="";
        String name="";
        //姓氏集合的长度
        int listLength;
        //姓氏索引
        int lastNameIndex;
        //创建姓氏的容器
        ArrayList<String> nameList = new ArrayList<>();
        String empty = "";
        while ( (line = reader.readLine())!=null ){
            if ( line!=""  && (empty=replaceSpecialStr(line))!=null ) nameList.add(empty);
        }
        reader.close();
        listLength = nameList.size();
        lastNameIndex = getRandom().nextInt(listLength);
        name = nameList.get(lastNameIndex) + getRandomChinaString(getRandom().nextInt(2)+1);
        return name;
    }


    /**
     * 去除空格，转行符。
     * @param word
     * @return
     */
    public static String replaceSpecialStr(String word){
        String result = "";
        if (word!=null) {
            Pattern compile = Pattern.compile("\\s*|\t|\r|\n");
            Matcher matcher = compile.matcher(word);
            result = matcher.replaceAll("");
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(randomNaming());
    }

}
