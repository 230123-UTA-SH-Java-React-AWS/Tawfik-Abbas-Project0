package com.revature.service;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.revature.model.Employee;
import com.revature.repository.EmployeeRepository;

public class EmployeeService {
    
    private final EmployeeRepository repo = new EmployeeRepository();
    private final ObjectMapper mapper = new ObjectMapper();

    //================ Dependency Injection ========================

    // Create a constructor and add in the parameters the class dependency
    
    // Register an employee in our database (later desired feature: if they are not already in it)
    public void register(String empJson) {

    try {
            Employee newEmployee = mapper.readValue(empJson, Employee.class);
            repo.Save(newEmployee);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Convert a List into a Json String
    public String getAllEmps() {

        List<Employee> listofEmps = repo.getAllEmployees();
        String jsonString = "";

        try {
            jsonString = mapper.writeValueAsString(listofEmps);
        
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}
