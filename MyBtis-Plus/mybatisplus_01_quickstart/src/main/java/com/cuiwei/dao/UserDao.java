package com.cuiwei.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cuiwei.demain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao extends BaseMapper<User> {
}
