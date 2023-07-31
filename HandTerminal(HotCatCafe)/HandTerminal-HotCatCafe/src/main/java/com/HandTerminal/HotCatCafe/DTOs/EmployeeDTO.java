package com.HandTerminal.HotCatCafe.DTOs;

public class EmployeeDTO extends BaseEntity{
    
    private String employeeFullName;

    private String jobDefinition;

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public String getJobDefinition() {
        return jobDefinition;
    }

    public void setJobDefinition(String jobDefinition) {
        this.jobDefinition = jobDefinition;
    }
}
