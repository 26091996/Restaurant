package com.project5.Restaurant.Model;


import com.project5.Restaurant.Model.Base.EntityBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_employee")
public class Employee implements EntityBase<Integer> {

    public Employee() {
    }

    public Employee(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    @Id
        @Column(name = "employeeID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int employeeId;

        @Column(name = "employeeName")
        String employeeName;

        @Column(name = "userName")
        String userName;

        @Column(name = "passWord")
        String passWord;

        @Column(name = "phone")
        String phone;

    @Column(name = "Address")
    String address;

        @Column(name = "roleId")
        int roleId;

    @Override
    public Integer getId() {
        return employeeId;
    }

    @Override
    public void setId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
