package gu.com.until;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

import java.io.Serializable;
import java.util.Random;

public class  RandomGeneration implements Serializable{
    private static String firstNum = "1";
    private static String[] secondNumArray = {"3", "4", "5", "7", "8"};
    private long RANDOM_NUMBER;
    private String RANDOM_NAME;

    public long getPhone(){
        Random random = new Random();
        StringBuffer phone = new StringBuffer();
        String secondNum = secondNumArray[random.nextInt(secondNumArray.length)];
        phone.append(firstNum);
        phone.append(secondNum);

        for (int i = 0; i < 9; i++){
            int nextNum = random.nextInt(10);
            phone.append(nextNum);
        }
        RANDOM_NUMBER=Long.valueOf(phone.toString());
        return RANDOM_NUMBER;
    }


    public static int randomCommon(int min, int max){
        if ( max < min && min>0) {
            return 25;
        }
        return (int) (Math.random() * (max - min)) + min;
    }
}
