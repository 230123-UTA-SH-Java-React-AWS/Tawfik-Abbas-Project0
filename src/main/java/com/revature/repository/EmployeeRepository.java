package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.utils.ConnectionUtil;

public class EmployeeRepository {
    
    public void Save(Employee employee) {
        
        // Saves to the Employee table of our database
        String sql = "insert into employees (email, password) values (?,?)";

        // Use the jdbc api
        try (Connection con = ConnectionUtil.getConnection()) {

            PreparedStatement prpstmt = con.prepareStatement(sql);
    
            // Replace the '?' with actual values from the database
            prpstmt.setString(1, employee.getEmail());
            prpstmt.setString(2, employee.getPassword());

            // call the execute() method
            prpstmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        String empSelect = "select * from employees";
        List<Employee> listOfEmployees = new ArrayList<Employee>();

        try (Connection con = ConnectionUtil.getConnection()) {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(empSelect);

            // Map information from a table to a data structure
            while (rs.next()) {
                Employee newEmployee = new Employee();

                newEmployee.setEmpId(rs.getInt(1));
                newEmployee.setEmail(rs.getString(2));
                newEmployee.setPassword(rs.getString(3));

                listOfEmployees.add(newEmployee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listOfEmployees;
    }

}
