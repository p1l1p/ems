package com.ems.config;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

@Component
public class Initializer implements ServletContextListener {
    @Resource
    DataSource dataSource;


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionFactory.setDataSource(dataSource);
        System.out.println("App context initialized with DAO's");
    }
}
