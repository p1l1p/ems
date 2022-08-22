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

        ServletContext sc = sce.getServletContext();

        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        SalaryDAOImpl salaryDAO = new SalaryDAOImpl();

        sc.setAttribute("employeeDAO", employeeDAO);
        sc.setAttribute("salaryDAO", salaryDAO);

        System.out.println("App context initialized with DAO's");
    }
}
