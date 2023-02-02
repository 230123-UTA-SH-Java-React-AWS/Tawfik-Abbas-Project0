package com.revature.model;

public class Employee {
    
    // Primary key for class
    private int empId;

    // Other pertinant employee fields
    private String email;
    private String password;

    // Setter methods
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter methods
    public int getEmpId() {
        return empId;
    }
    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
}
