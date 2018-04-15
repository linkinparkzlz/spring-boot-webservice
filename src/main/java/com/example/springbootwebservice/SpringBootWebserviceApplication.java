package com.example.springbootwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class SpringBootWebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebserviceApplication.class, args);
    }
}


//编译命令  xjc -d src/main/java -p com.example.springbootwebservice.domain src/main/resources/META-INFO/schemas/user.xsd
