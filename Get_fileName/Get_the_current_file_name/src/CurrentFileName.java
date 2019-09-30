import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.*;

public class CurrentFileName {
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * 考虑到可能输错，考虑到隐藏文件夹是否打印，
         */

        String filePath = "E:\\自制";
        test03(filePath);

    }



    public  void test_canExecute(){
        // create new file
        File f = new File("E:/text.txt");
        // true if the file is executable
        boolean bool = f.canExecute();
        // find the absolute path
        String a = f.getAbsolutePath();
        // prints absolute path
        System.out.print(a);
        // prints
        System.out.println(" is executable: " + bool);
    }

    //测试F.listFiles()方法
    @Test
    public void test02(){
        String filePath = "E:\\自制\\Test01.java";

        File files = new File(filePath);
        String name = files.getParentFile().getName();
        File name0 = files.getParentFile();
        System.out.println(name);
        System.out.println("----------");
        File[] files1 = name0.listFiles();
        for (File file : files1) {
            System.out.println(file.getName());
        }


    }

    public static void test03(String path){
        ArrayList<String> arrayList = new ArrayList();
        File file = new File(path);
        //分析文件路径，抽象路径，不存在路径
        if (file.exists()){
            //返回绝对路径数组
            File[] list = file.getAbsoluteFile().listFiles();
            for (File f : list) {
                //判断是否是目录
                if (!f.isDirectory()){
                    //输入文件中，应该一次输入，节省资源
                    arrayList.add(f.getName());
                }
            }
            input(file.getAbsoluteFile(),arrayList);
        }
        System.out.println(arrayList.toString());

    }

    private static void input(File path,List list) {
        //字符流，
        String aaapath=path.getAbsolutePath()+"\\aaa.txt";
        try {
            FileWriter writer = new FileWriter(aaapath,true);
            Iterator iterator = list.iterator();
            while (iterator.hasNext()){
                writer.write(iterator.next().toString());
                writer.write("\r\n");
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
