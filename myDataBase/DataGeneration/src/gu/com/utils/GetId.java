package gu.com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Auther: gu
 * @Date: 2019/5/5 15:57
 * @Description: TODO
 */
public class GetId {

    /**
     * 20位末尾的数字id
     */
    public static volatile int Guid=100;

    public static long getGuid() {

        GetId.Guid+=1;

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        //获取4位年份数字
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");
        //获取时间戳
        String time=dateFormat.format(date);
        String info=now+"";
        //获取三位随机数
        //int ran=(int) ((Math.random()*9+1)*100);
        //要是一段时间内的数据连过大会有重复的情况，所以做以下修改
        int ran=0;
        if(GetId.Guid>999){
            GetId.Guid=100;
        }
        ran=GetId.Guid;

        return Long.parseLong(time+info.substring(2, info.length())+ran);
    }


}
