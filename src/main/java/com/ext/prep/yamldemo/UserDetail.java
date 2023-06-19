package com.ext.prep.yamldemo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class UserDetail {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "UserDetail{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
