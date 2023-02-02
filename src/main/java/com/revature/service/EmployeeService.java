package com.revature.service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.revature.model.Employee;
import com.revature.repository.EmployeeRepository;

public class EmployeeService {
    
    // Register an employee in our database if they are not already in it
    public void register(String empJson) {

        EmployeeRepository empRepo = new EmployeeRepository();

        // We need to map the controller response with an ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();

        try {
            Employee newEmployee = mapper.readValue(empJson, Employee.class);
            empRepo.Save(newEmployee);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
