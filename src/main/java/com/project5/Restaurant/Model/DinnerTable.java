package com.project5.Restaurant.Model;


import com.project5.Restaurant.Model.Base.EntityBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_dinnerTable")
public class DinnerTable implements EntityBase<Integer> {

    @Id
    @Column(name = "dinnerTableID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int dinnerTableID;

    @Column(name = "dinnerTableName")
    String dinnerTableName;

    @Column(name = "dinnerTableQuanity")
    int dinnerTableQuanity;

    @Column(name = "areaID")
    int areaID;

    @Override
    public Integer getId() {
        return dinnerTableID;
    }

    @Override
    public void setId(Integer dinnerTableID) {
        this.dinnerTableID = dinnerTableID;
    }
}
