package gu.com.itheima;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import gu.com.itheima.dao.UserDao;
import gu.com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class service {
    public static void main(String[] args) throws IOException {
        // 1.读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 2.根据配置文件构建SqlSessionFactory
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
        // 3.使用SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 4.使用SqlSession构建Dao的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 5.执行dao的findAll方法


        List<User> list =new ArrayList<User>();
        User user1 = new User();
        user1.setAge(12);
        user1.setName("sdf");
        user1.setSex("男");
        User user2 = new User();
        list.add(user2);
        user2.setAge(13);
        user2.setName("sdf");
        user2.setSex("男");
        list.add(user2);

        // 5.执行dao的findAll方法
        List<User> userList = userDao.findByCondition();
        // 第4，第5步骤可以写成
        // List<User> list = sqlSession.selectList("com.itheima.dao.UserDao.findAll");
        for(User user:list){
            System.out.println(user);
        }
        // 5.关闭资源
        sqlSession.close();
        in.close();

    }

}
