package com.cuiwei.domain;

import com.baomidou.mybatisplus.annotation.*;

@TableName("user")
    public class User {
    @TableId(type = IdType.AUTO)
        private Long id;
        private String name;
        @TableField(value="pwd",select=false)
        private String password;
        private Integer age;
        private String tel;
        @TableField(exist=false)
        private Integer online;
       /* @TableLogic(value = "0",delval = "1")
        private Integer delete;*/
        @Version
        private  Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", online=" + online +
                '}';
    }
}

