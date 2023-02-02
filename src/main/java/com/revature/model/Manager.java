package com.revature.model;

public class Manager {
    // Primary Key
    private int mgrId;

    // Other pertinent fields
    private String email;
    private String password;

    // Setter methods
    public void setManagerId(int mgrId) {
        this.mgrId = mgrId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter methods
    public int getManagerId() {
        return mgrId;
    }

    public String getManagerEmail() {
        return email;
    }

    public String getManagerPassword() {
        return password;
    }
}
