package com.ems.config;

import com.ems.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    @Override
    public void save(Employee employee) {
        String query = "INSERT INTO employee (id, firstname, lastname, birthdate) values (?, ?, ?)";
        Connection connection = null;
        PreparedStatement ps = null;
        try{
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            //ps.setString(4, employee.getBirthDate().toString());
            int out = ps.executeUpdate();
            if (out != 0) {
                System.out.println("Employee saved with id = " + employee.getId());
            } else {
                System.out.println("Employee save failed with id = " + employee.getId());
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public Employee getById(int id) {
        String query = "select firstname, lastname, birthdate from employee where id = ?";
        Employee employee = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()){
                employee = new Employee();
                employee.setId(id);
                employee.setFirstName(rs.getString("firstname"));
                employee.setLastName(rs.getString("lastname"));
                //employee.setBirthDate(new Date(rs.getString("birthdate")));
                System.out.println("Employee Found: " + employee);
            }else{
                System.out.println("No Employee found with id = " + id);
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            try {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }

    @Override
    public void update(Employee employee) {
        String query = "update employee set firstname=?, lastname=? where id=?";
        Connection connection = null;
        PreparedStatement ps = null;
        try{
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setInt(3, employee.getId());
            int out = ps.executeUpdate();
            if (out !=0){
                System.out.println("Employee updated with id = " + employee.getId());
            } else {
                System.out.println("No Employee found with id = " + employee.getId());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteById(int id) {
        String query = "delete from employee where id=?";
        Connection connection = null;
        PreparedStatement ps = null;
        try{
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            int out = ps.executeUpdate();
            if(out !=0){
                System.out.println("Employee deleted with id = " + id);
            }else System.out.println("No Employee found with id = " + id);
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Employee> getAll() {
        String query = "select id, firstname, lastname from employee";
        List<Employee> empList = new ArrayList<Employee>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setFirstName(rs.getString("firstname"));
                emp.setLastName(rs.getString("lastname"));
                empList.add(emp);
            }
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            try {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return empList;
    }
}
