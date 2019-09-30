package gu.com;

import javax.lang.model.element.VariableElement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordSpilt {

    //存储分词词典
    private Map<String, Integer> map = new HashMap<String, Integer>();
    //最大切词长度，设为5个汉字
    private int MAX_LENGTH = 5;

    /**
     * 构造方法存储词典在map里
     *
     * @throws FileNotFoundException
     */
    public WordSpilt() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\Mark_of_growth\\participles\\Bidirectional matching algorithm\\src\\dict.txt"));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            //去掉前后空白字符
            line = line.trim();
            map.put(line, 0);
        }
        bufferedReader.close();
    }

    /**
     * 设置最大切词长度 MAX_LENGTH的值
     */
    public void setMAX_LENGTH(int MAX_LENGTH) {
        this.MAX_LENGTH = MAX_LENGTH;
    }

    /**
     * 最大匹配分词算法
     *
     * @param spiltStr    待切分的词
     * @param leftToRight 切分方向，true为从左向右，false为从右向左
     * @return
     */
    public List<String> spilt(String spiltStr, boolean leftToRight) {
        if (spiltStr.isEmpty()) {
            return null;
        }
        //存储正向匹配的分割字符串
        ArrayList<String> leftWords = new ArrayList<String>();
        //存储逆向匹配的分割字符串
        ArrayList<String> rightWords = new ArrayList<String>();
        // 用于取切分的字串
        String word = null;
        // 取词的长度，初始化设置为最大值
        int wordLength = MAX_LENGTH;
        // 分词操作中处于字串当前位置
        int position = 0;
        // 已经处理字符串的长度
        int length = 0;
        //去掉字符串中多余的空格

        spiltStr = spiltStr.trim().replaceAll("\\s", "");

        ///当待切分字符串没有被切分完时循环切分
        while (length < spiltStr.length()) {
            // 如果输入的还没切分的字符串 长度小于 MAX_LENGTH最大切词长度，让取词词长等于该词本身长度
            if (spiltStr.length() - length < MAX_LENGTH) {
                wordLength = spiltStr.length() - length;
            } else {
                wordLength = MAX_LENGTH;
            }
            //如果是正向匹配，从spiltStr的position处开始切割
            if (leftToRight) {
                //位置等于处理字符的长度；也就是定义的length
                position = length;
                //获取切分的字符串，等于当前位置，加一截取字段长
                //substring()用法↓
                // "hamburger".substring(4, 8) returns "urge"
                word = spiltStr.substring(position, position + wordLength);

            } else { //如果是逆向匹配，从spiltStr末尾开始切割
                position = spiltStr.length() - length;
                word = spiltStr.substring(position - wordLength, position);
            }
            // 如果分词词典里面没有切割出来的字符串，舍去一个字符
            while (!map.containsKey(word)) {
                //如果截取的字符是单字，退出循环
                if (word.length() == 1) {
                    // 如果是字母或是数字要将连续的字母或者数字分在一起
                    //matches告知此字符串是否匹配给定的正则表达式。
                    //这里看截取的字符串是否符合正则表达式
                    if (word.matches("[a-zA-z0-9]")) {
                        if (leftToRight) {
                            //i的起始位置是，从当前位置，开始找word ，也就是截取的字符，索引位置+1
                            //i的长度，或者说结束，也就是spiltStr字符串长度
                            for (int i = spiltStr.indexOf(word, position) + 1; i < spiltStr.length(); i++) {
                                //charAt返回指定索引处的字符（Unicode 代码点）。根据索引值找到对应的字符
                                //这里是英文数字，所以是
                                //如果spiltStr字符串截取后的剩下的字符中，英文在a-zA-z0-9中
                                if ((spiltStr.charAt(i) >= '0' && spiltStr.charAt(i) <= 9) || (spiltStr.charAt(i) >= 'A' && spiltStr.charAt(i) <= 'Z') || (spiltStr.charAt(i) >= 'a' && spiltStr.charAt(i) <= 'z')) {
                                    //截取的字符=截取的字符+a-zA-z0-9
                                    word += spiltStr.charAt(i);

                                } else {
                                    break;
                                }
                            }


                        } else {
                            //如果是逆向匹配，从当前位置之前的连续数字、字母字符加起来并翻转
                            for (int i = spiltStr.indexOf(word, position - 1) - 1; i >= 0; i--) {
                                if ((spiltStr.charAt(i) >= '0' && spiltStr.charAt(i) <= '9') || (spiltStr.charAt(i) >= 'A' && spiltStr.charAt(i) <= 'Z') || (spiltStr.charAt(i) >= 'a' && spiltStr.charAt(i) <= 'z')) {
                                    word += spiltStr.charAt(i);
                                    if (i == 0) {
                                        StringBuffer sb = new StringBuffer(word);
                                        word = sb.reverse().toString();
                                    }
                                } else {
                                    // 翻转操作
                                    StringBuffer sb = new StringBuffer(word);
                                    word = sb.reverse().toString();
                                    break;
                                }
                            }


                        }


                    }
                    break;
                }
                //如果是正向匹配最大匹配，舍去最后一个字符
                //为什么要这样做？
                if (leftToRight) word = word.substring(0, word.length() - 1);
                    //逆向匹配去除第一个字符
                else word = word.substring(1);
            }
            // 将切分出来的字符串存到指定的表中
            if (leftToRight) leftWords.add(word);
            else rightWords.add(word);
            // 已处理字符串增加
            length += word.length();
        }
        // 如果是逆向最大匹配，要把表中的字符串调整为正向
        if (!leftToRight) {
            for (int i = rightWords.size() - 1; i >= 0; i--) {
                leftWords.add(rightWords.get(i));
            }
        }
        return leftWords;
    }


    /**
     * 判断两个集合是否相等
     * @param list1
     * @param list2
     * @return
     */
    public boolean isEqual(List<String> list1, List<String> list2){

        if (list1.isEmpty()&&list2.isEmpty()) return false;
        if (list1.size()!=list2.size()) return false;
        for (int i =0;i<list1.size();i++){
            if (!list1.get(i).equals(list2.get(i))) return false;
        }
           return true;

    }

    /**
     * 判别分词歧义函数
     * @param inputStr 待切分字符串
     * @return 分词结果
     */
    public List<String> resultWord(String inputStr){
        // 分词结果
        List<String> result = new ArrayList<String>();
        // “左贪吃蛇”分词结果
        List<String> resultLeft = new ArrayList<String>();
        // “中贪吃蛇”（分歧部分）分词结果
        List<String> resultMiddle = new ArrayList<String>();
        // “右贪吃蛇”分词结果
        List<String> resultRight = new ArrayList<String>();
        // 正向最大匹配分词结果
        List<String> left = new ArrayList<String>();
        // 逆向最大匹配分词结果
        List<String> right = new ArrayList<String>();
        left = spilt(inputStr, true);
        right = spilt(inputStr, false);
        // 判断两头的分词拼接，是否已经在输入字符串的中间交汇，只要没有交汇，就不停循环
        while (left.get(0).length()+right.get(right.size()-1).length() < inputStr.length()){
            // 如果正逆向分词结果相等，那么取正向结果跳出循环
            if (isEqual(left,right)){
                resultMiddle=left;
                break;
            }
            // 如果正反向分词结果不同，则取分词数量较少的那个，不用再循环
            if (left.size() != right.size()) {
                resultMiddle = left.size() < right.size() ? left : right;
                break;
            }
        }

        return left;//todo
    }

    public static void main(String[] args) {
        //String test = "欢迎来到脚本之家，这里提供大量的脚本素材提供读者下载，参考";
        //try {
        //    WordSpilt spilt1 = new WordSpilt();
        //    ;
        //    System.out.println(Arrays.toString(new List[]{spilt1.spilt(test, true)}));
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}


    }


}
