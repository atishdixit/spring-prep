package com.ext.prep.beans;

import com.ext.prep.annotations.IgnoreDuringScan;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component("user-01")
@IgnoreDuringScan
public class User {
    String name="Test User";

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
