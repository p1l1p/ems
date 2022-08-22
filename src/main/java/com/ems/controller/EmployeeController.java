package com.ems.controller;

import com.ems.config.EmployeeDAOImpl;
import com.ems.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller()
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    EmployeeDAOImpl employeeDAO;

    @GetMapping("/view")
    public String view(HttpServletRequest request) {
        List<Employee> empList = employeeDAO.getAll();
        request.setAttribute("empList", empList);
        return "/employee/view";
    }

    @GetMapping("/add")
    public String add() {
        return "/employee/add";
    }

    @PostMapping("/add")
    public String add(@RequestParam(name="id") int id,
                      @RequestParam(name="firstname") String firstName,
                      @RequestParam(name="lastname") String lastName,
                      HttpServletRequest request, HttpServletResponse response) {
        employeeDAO.save(new Employee(id, firstName, lastName));
        return "redirect:/employee/view";
    }
}
