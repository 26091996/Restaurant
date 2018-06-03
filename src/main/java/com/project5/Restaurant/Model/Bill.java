package com.project5.Restaurant.Model;

import com.project5.Restaurant.Model.Base.EntityBase;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_bill")
public class Bill implements EntityBase<Integer> {

    @Id
    @Column(name = "billID")
    int billID;

    @Column(name = "dinnerTableID")
    int dinnerTableID;

    @Column(name = "billDate")
    String billDate;

    @Column(name = "grand_total")
    int grandTotal;

    @Column(name = "employeeID")
    int employeeID;

    @Override
    public Integer getId() {
        return billID;
    }

    @Override
    public void setId(Integer billID) {
        this.billID = billID;
    }
}
