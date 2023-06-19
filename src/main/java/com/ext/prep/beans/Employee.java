package com.ext.prep.beans;

import com.ext.prep.annotations.IgnoreDuringScan;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component("employee")
@IgnoreDuringScan
public class Employee {
    String name="Test Employee";
}
