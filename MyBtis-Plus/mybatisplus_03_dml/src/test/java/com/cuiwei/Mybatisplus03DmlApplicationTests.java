package com.cuiwei;

import com.cuiwei.dao.UserDao;
import com.cuiwei.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
class Mybatisplus03DmlApplicationTests {

    @Autowired
    private UserDao userDao;
    /*
      添加用户
      */
    @Test
    void TestSave(){
        User user = new User();
        user.setName("胡斌");
        user.setAge(21);
        user.setPassword("123456");
        user.setTel("333333");
        userDao.insert(user);
    }

    /**
     * 根据ID删除用户
     */
    @Test
    void testDelete(){
        userDao.deleteById(1);
    }

    /**
     * 修改用户
     */
    @Test
    void testUpdate(){
        User user = new User();
        user.setId(2L);
        user.setName("大头");
        userDao.updateById(user);
    }

    /**
     * 批量删除
     */
    @Test
   void testDeletes(){
        List<Long> list = new LinkedList<>();
        list.add(444L);
        list.add(666L);
       userDao.deleteBatchIds(list);

    }

    /**
     * 根据ID批量查询
     */
    @Test
    void testSelects(){
        List<Long> list = new ArrayList<>();
        list.add(2L);
        list.add(4L);
        list.add(6L);
        List<User> users = userDao.selectBatchIds(list);
        for (User user : users) {
            System.out.println(user);
}
    }

    /**
     * 逻辑删除
     */
    @Test
    void Select(){
        userDao.deleteById(2L);
    }


    /**
     * 模拟两个用户抢一个东西  （乐观锁）
     */
    @Test
    void leguansuo(){
        User user1 = userDao.selectById(2L); //用户一
        User user2 = userDao.selectById(2L);//用户二

        user1.setName("崔永红");
        userDao.updateById(user1);

        user2.setName("王素琴");
        userDao.updateById(user2);

    }
}
