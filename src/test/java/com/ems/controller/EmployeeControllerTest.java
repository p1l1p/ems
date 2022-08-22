package com.ems.controller;

import com.ems.config.EmployeeDAOImpl;
import com.ems.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        classes = {
                EmployeeController.class
        }
)
@AutoConfigureMockMvc
class EmployeeControllerTest {
    @MockBean
    EmployeeDAOImpl employeeDAO;

    @Resource
    private MockMvc mvc;

    @Test
    void view() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Test", "Test"));
        employeeList.add(new Employee(2, "Test", "Test"));

        Mockito.when(employeeDAO.getAll()).thenReturn(employeeList);
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/employee/view");

        MvcResult result = mvc.perform(req).andReturn();

        assert result.getResponse().getStatus() == HttpServletResponse.SC_OK;
        assert result.getModelAndView().getViewName() == "/employee/view";

        List<Employee> sentEmployeeList = (List<Employee>) result.getRequest().getAttribute("empList");
        assert sentEmployeeList != null && sentEmployeeList.size() == 2;
    }
}