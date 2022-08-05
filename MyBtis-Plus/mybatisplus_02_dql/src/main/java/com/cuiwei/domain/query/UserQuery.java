package com.cuiwei.domain.query;

import com.cuiwei.domain.User;
import lombok.Data;

@Data
public class UserQuery extends User {
    private Integer age2;

    public Integer getAge2() {
        return age2;
    }

    public void setAge2(Integer age2) {
        this.age2 = age2;
    }

    @Override
    public String toString() {
        return "UserQuery{" +
                "age2=" + age2 +
                '}';
    }
}
