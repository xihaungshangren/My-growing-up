package gu.com.mapper;

import java.io.Serializable;

public class DataFormatDO implements Serializable {
    //手机号码：^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$
    private long phone;
    //名字
    private String name;
    //年龄
    private short age;
    //性别
    private String sex;


    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataFormatDO() {
    }

    public short getAge() {

        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
