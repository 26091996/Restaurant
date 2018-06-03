package com.project5.Restaurant.Model;

import com.project5.Restaurant.Model.Base.EntityBase;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "tbl_product")
public class Product implements EntityBase<Integer> {

    @Id
    @Column(name = "productID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int productId;


    @Column(name = "categoryID")
    int categoryId;


    @Column(name = "productName")
    String productName;


    @Column(name = "productPrice")
    int productPrice;

    @Column(name = "productUnit")
    String productUnit;

    @Column(name = "productQuantity")
    int productQuantity;

    @Column(name = "productDetails")
    String productDetails;

    @Column(name = "productImage")
    String productImage;

    @Column(name = "productStatus")
    String productStatus;

    public Integer getId() {
        return this.productId;
    }

    public void setId(Integer pk) {
        this.productId = pk;
    }
}
