package com.revature.model;

public class Ticket {
    // Primary Key
    private int ticketId;

    // Other relevant fields
    private int empId;
    private Boolean status;
    
    // Setter methods
    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    // Getter methods
    public int getTicketId() {
        return ticketId;
    }

    public int getEmpId() {
        return empId;
    }

    public Boolean getStatus() {
        return status;
    }
}
