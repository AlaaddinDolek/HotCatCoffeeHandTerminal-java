package com.HandTerminal.HotCatCafe.DTOs;

public class SaleDTO extends BaseEntity{
    
    private OrderDTO orderDTO;
    private String employeeFullName;
    
    public OrderDTO getOrderDTO() {
        return orderDTO;
    }
    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }
    public String getEmployeeFullName() {
        return employeeFullName;
    }
    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }
}
