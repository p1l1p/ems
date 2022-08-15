package com.ems.controller;

import com.ems.config.EmployeeDAOImpl;
import com.ems.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller()
public class EmployeeController {
    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

    @GetMapping("/view")
    public String view(HttpServletRequest request) {
        List<Employee> empList = employeeDAO.getAll();
        request.setAttribute("empList", empList);
        return "view";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response) {

        return "view";
    }
}
