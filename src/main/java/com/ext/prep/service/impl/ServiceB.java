package com.ext.prep.service.impl;

import com.ext.prep.service.inter.ServiceIntr;
import org.springframework.stereotype.Service;

@Service("service_b")
public class ServiceB implements ServiceIntr {
    @Override
    public void serve() {
        System.out.println("Service B");
    }
}
