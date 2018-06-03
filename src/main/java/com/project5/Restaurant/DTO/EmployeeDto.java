package com.project5.Restaurant.DTO;

import lombok.Data;

import javax.persistence.Column;

@Data
public class EmployeeDto {

    int employeeId;
    String employeeName;
    String userName;
    String phone;
    String address;
    String roleName;
}
