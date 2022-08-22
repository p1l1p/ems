package com.ems.config;

import com.ems.model.Employee;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAOImpl implements DAO<Employee> {

    @Override
    public void save(Employee employee) {
        String query = "INSERT INTO employee (id, firstname, lastname) values (?, ?, ?)";
        DataSource ds = ConnectionFactory.getDataSource();
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Employee saved with id = " + employee.getId());
            } else {
                System.out.println("Employee save failed with id = " + employee.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getById(int id) {
        String query = "SELECT firstname, lastname FROM employee WHERE id = ?";
        DataSource ds = ConnectionFactory.getDataSource();
        Employee employee = null;
        ResultSet rs;
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                employee = new Employee();
                employee.setId(id);
                employee.setFirstName(rs.getString("firstname"));
                employee.setLastName(rs.getString("lastname"));
                System.out.println("Employee Found: " + employee);
            } else {
                System.out.println("No Employee found with id = " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void update(Employee employee) {
        String query = "update employee set firstname=?, lastname=? where id=?";
        DataSource ds = ConnectionFactory.getDataSource();
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);){
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getId());
            int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Employee updated with id = " + employee.getId());
            } else {
                System.out.println("No Employee found with id = " + employee.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String query = "delete from employee where id=?";
        DataSource ds = ConnectionFactory.getDataSource();
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);){
            ps.setInt(1, id);
            int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Employee deleted with id = " + id);
            } else System.out.println("No Employee found with id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAll() {
        String query = "select id, firstname, lastname from employee";
        List<Employee> empList = new ArrayList();
        ResultSet rs;
        DataSource ds = ConnectionFactory.getDataSource();
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);){
            rs = ps.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setFirstName(rs.getString("firstname"));
                emp.setLastName(rs.getString("lastname"));
                empList.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empList;
    }
}
