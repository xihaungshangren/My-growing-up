package gu.com.itheima.dao;

import gu.com.itheima.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findByCondition();
}
