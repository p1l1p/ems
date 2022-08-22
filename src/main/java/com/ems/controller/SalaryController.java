package com.ems.controller;

import com.ems.config.EmployeeDAOImpl;
import com.ems.config.SalaryDAOImpl;
import com.ems.model.Employee;
import com.ems.model.Salary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller()
@RequestMapping("/salary")
public class SalaryController {
    @Resource
    SalaryDAOImpl salaryDAO;
    @Resource
    EmployeeDAOImpl employeeDAO;

    @GetMapping("/employee/{employeeIdRaw}")
    public String viewEmployeeAndSalary(HttpServletRequest request, @PathVariable String employeeIdRaw) {
        ServletContext sc = request.getServletContext();
        int employeeId = Integer.valueOf(employeeIdRaw);
        Salary salary = salaryDAO.getById(employeeId);
        Employee employee = employeeDAO.getById(employeeId);
        request.setAttribute("salary", salary);
        request.setAttribute("employee", employee);
        return "/salary/view-employee-and-salary";
    }
}
