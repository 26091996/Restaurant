package com.project5.Restaurant.Model;

import com.project5.Restaurant.Model.Base.EntityBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_category")
public class Category implements EntityBase<Integer> {

    @Id
    @Column(name = "categoryID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int categoryId;

    @Column(name = "categoryName")
    public String categoryName;

    @Column(name = "categoryImage")
    public String categoryImage;

    public Integer getId() {
        return categoryId;
    }

    public void setId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
