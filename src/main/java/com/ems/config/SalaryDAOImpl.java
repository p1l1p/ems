package com.ems.config;

import com.ems.model.Salary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class SalaryDAOImpl implements DAO<Salary> {

    @Override
    public void save(Salary object) {

    }

    @Override
    public Salary getById(int id) {
        String query = "SELECT amount FROM salary WHERE employeeId = ?";
        Salary salary = null;
        DataSource ds = ConnectionFactory.getDataSource();
        ResultSet rs;
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);){
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()){
                salary = new Salary();
                salary.setEmployeeId(id);
                salary.setAmount(rs.getDouble("amount"));
                System.out.println("Salary Found: " + salary);
            } else {
                System.out.println("No Salary found with id = " + id);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return salary;
    }

    @Override
    public void update(Salary object) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Salary> getAll() {
        return null;
    }
}
