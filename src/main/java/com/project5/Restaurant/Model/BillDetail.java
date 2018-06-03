package com.project5.Restaurant.Model;

import com.project5.Restaurant.Model.Base.EntityBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_billDetail")
public class BillDetail implements EntityBase<Integer> {

    @Id
    @Column(name = "billDetailID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int billDetailID;

    @Column(name = "billID")
    int billID;

    @Column(name = "productID")
    int productID;

    @Column(name = "billDetailPrice")
    int billDetailPrice;

    @Column(name = "billDetailQuanity")
    int billDetailQuanity;

    @Column(name = "billDetailNote")
    String billDetailNote;

    public BillDetail(int billDetailID, int billID, int productID, int billDetailPrice, int billDetailQuanity, String billDetailNote) {

    }

    public BillDetail() {
    }

    @Override
    public Integer getId() {
        return billDetailID;
    }

    @Override
    public void setId(Integer billDetailID) {
        this.billDetailID = billDetailID;
    }


}
