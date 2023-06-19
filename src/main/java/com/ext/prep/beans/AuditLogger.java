package com.ext.prep.beans;

import com.ext.prep.service.inter.ServiceIntr;
import com.ext.prep.xmldemo.XMLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
//@ConditionalOnProperty(
//        value="audit.logs",//property in pro file
//        havingValue = "true",//its valye
//        matchIfMissing = true) //is
@ConditionalOnExpression("${audit.logs:true}")
public class AuditLogger {
    @Autowired
    private XMLService xmlService;

    @Qualifier("service_a")
    @Autowired
    private ServiceIntr serviceIntr;

    public void log(){
        xmlService.show();
        serviceIntr.serve();
    }
}
