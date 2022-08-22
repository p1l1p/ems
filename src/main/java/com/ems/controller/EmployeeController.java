package com.ems.controller;

import com.ems.config.EmployeeDAOImpl;
import com.ems.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller()
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/view")
    public String view(HttpServletRequest request) {
        ServletContext sc = request.getServletContext();
        EmployeeDAOImpl employeeDAO = (EmployeeDAOImpl) sc.getAttribute("employeeDAO");
        List<Employee> empList = employeeDAO.getAll();
        request.setAttribute("empList", empList);
        return "/employee/view";
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
