package com.ext.prep;

import com.ext.prep.annotations.IgnoreDuringScan;
import com.ext.prep.beans.AuditLogger;
import com.ext.prep.beans.FileService;
import com.ext.prep.xmldemo.XMLService;
import com.ext.prep.yamldemo.YMLConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
//https://github.com/eugenp/tutorials/blob/master/spring-boot-modules/spring-boot-properties-2/src/main/resources/application.yml
@SpringBootApplication
@ImportResource("classpath:xmldemo.xml")
//@ComponentScan(excludeFilters={@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, value=Employee.class)}) //1
@ComponentScan(excludeFilters = @ComponentScan.Filter(IgnoreDuringScan.class)) // 2

public class SpringPrepApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringPrepApplication.class, args);
		Arrays.stream(context.getBeanDefinitionNames()).forEach(bean->{
			System.out.println(bean);
		});

		XMLService service = context.getBean("xmldemo", XMLService.class);
		service.show();

		AuditLogger auditLogger = context.getBean(AuditLogger.class);
		auditLogger.log();

		FileService fileService = context.getBean(FileService.class);
		fileService.writeFile();

		YMLConfig ymlConfig  = context.getBean(YMLConfig.class);
		ymlConfig.show();

	}

}
