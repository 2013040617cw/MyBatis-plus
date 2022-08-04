package com.cuiwei;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cuiwei.dao.UserDao;
import com.cuiwei.demain.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {

@Autowired
private  UserDao userDao;

    /**
     * 查询所有用户
     */
    @Test
    void testGetAll() {
        List<User> all = userDao.selectList(null);
        for (User user : all) {
            System.out.println(user);
        }
    }

    /*
     添加用户
     */
    @Test
    void TestSave(){
        User user = new User();
        user.setId(5L);
        user.setName("崔巍");
        user.setAge(20);
        user.setPassword("123456");
        user.setTel("888888");
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
     * 根据ID查询
     */

    @Test
    void testGetById(){
        User user = userDao.selectById(3L);
        System.out.println(user);
    }

    /**
     * 分页查询
     *
     */
    @Test
    void testSelectpage(){
        //1 创建IPage分页对象,设置分页参数,1为当前页码，2为每页显示的记录数
        IPage page = new Page(1,2);
        //2.执行分页查询
        userDao.selectPage(page ,null);
        System.out.println("当前页码值："+page.getCurrent());
        System.out.println("每页显示数："+page.getSize());
        System.out.println("一共多少页："+page.getPages());
        System.out.println("一共多少条数据："+page.getTotal());
        System.out.println("数据："+page.getRecords());
    }
}
