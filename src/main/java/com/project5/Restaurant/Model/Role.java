package com.project5.Restaurant.Model;

import com.project5.Restaurant.Model.Base.EntityBase;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tbl_role")
@Entity
public class Role implements EntityBase<Integer> {

    @Id
    @Column(name = "roleId")
    int roleId;

    @Column(name = "rolename")
    String rolename;

    @Column(name = "roleValue")
    int roleValue;


    @Override
    public Integer getId() {
        return roleId;
    }

    @Override
    public void setId(Integer roleId) {
        this.roleId = roleId;
    }
}
