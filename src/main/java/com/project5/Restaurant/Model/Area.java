package com.project5.Restaurant.Model;

import com.project5.Restaurant.Model.Base.EntityBase;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_area")
public class Area implements EntityBase<Integer> {

    @Id
    @Column(name = "areaID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int areaId;

    @Column(name = "areaName")
    String areaName;

    @Override
    public Integer getId() {
        return areaId;
    }

    @Override
    public void setId(Integer areaId) {
        this.areaId = areaId;
    }
}
