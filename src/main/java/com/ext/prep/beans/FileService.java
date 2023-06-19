package com.ext.prep.beans;

import com.ext.prep.service.inter.ServiceIntr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Qualifier("service_b")
    @Autowired
    private ServiceIntr serviceIntr;

    public void writeFile(){
        serviceIntr.serve();
    }
}
