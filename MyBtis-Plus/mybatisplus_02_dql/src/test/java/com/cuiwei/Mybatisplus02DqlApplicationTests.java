package com.cuiwei;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cuiwei.dao.UserDao;
import com.cuiwei.domain.User;
import com.cuiwei.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Mybatisplus02DqlApplicationTests {

    @Autowired
    private UserDao userDao;

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
    /**
     * 条件查询方式一
     */
    @Test
    void GetAll1(){
        QueryWrapper<User> w = new QueryWrapper<User>();
        w.lt("age",18);
        List<User> all = userDao.selectList(w);
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 多条件查询方式二
     */
    @Test
    void GetAll2(){
        QueryWrapper<User> w = new QueryWrapper<User>();
      w.lambda().lt(User::getAge,18);
        List<User> all = userDao.selectList(w);
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 多条件查询方式三
     */
    @Test
    void GetAll3(){
        LambdaQueryWrapper<User> w = new LambdaQueryWrapper<>();
        w.lt(User::getAge, 10);
        List<User> userList = userDao.selectList(w);
        System.out.println(userList);

    }

    /**
     * null值的判定
     */
    @Test
    void GetAll4(){
        UserQuery uq  = new UserQuery();
        //uq.setAge(10);
        uq.setAge2(30);
        LambdaQueryWrapper<User> w = new LambdaQueryWrapper<>();
        //先判定第一个参数是否为true,如果为true连接当前条件
        w.lt(null!=uq.getAge2(),User::getAge,uq.getAge2());
        w.gt(null!=uq.getAge(),User::getAge,uq.getAge());
        List<User> userList = userDao.selectList(w);
        System.out.println(userList);
    }

    /**
     * 查询投影
     */

    @Test
void GetAll5(){
        LambdaQueryWrapper<User> w = new LambdaQueryWrapper<>();
        w.select(User::getId,User::getAge,User::getName,User::getTel);
        List<User> userList = userDao.selectList(w);
        for (User user : userList) {
            System.out.println(user);
        }
}

/**
 * 查询投影 普通方式
 */
@Test
void GetAll6(){
   QueryWrapper<User> w = new QueryWrapper<>();
    w.select("id","name","age","tel");
    List<User> userList = userDao.selectList(w);
    for (User user : userList) {
        System.out.println(user);
    }
}

/**
 * 查询投影的聚合查询
 */
@Test
void GetAll7(){
    QueryWrapper<User> w = new QueryWrapper<>();
    w.select("count(*) as account");
    List<Map<String, Object>> maps = userDao.selectMaps(w);
    for (Map<String, Object> map : maps) {
        System.out.println(map);
    }
}

/**
 * 查询投影的分组查询
 */
@Test
void GetAll8(){
    QueryWrapper<User> w = new QueryWrapper<>();
    w.select("count(*) as account","tel");
    w.groupBy("tel");
    List<Map<String, Object>> maps = userDao.selectMaps(w);
    for (Map<String, Object> map : maps) {
        System.out.println(map);
    }
  }
    /**
     * 等值查询 + 范围查询
     *
     */
    @Test
    void GetAll9(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        /*lqw.eq(User::getName,"大头").eq(User::getPassword,"jerry");
        User user = userDao.selectOne(lqw);*/
        lqw.between(User::getAge,10,30);
        List<User> users = userDao.selectList(lqw);
        System.out.println(users);
    }

    /**
     * 模糊查询
     */
    @Test
    void GetAll10(){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
       lqw.like(User::getName,"j");
        List<User> users = userDao.selectList(lqw);
        System.out.println(users);
    }


}
