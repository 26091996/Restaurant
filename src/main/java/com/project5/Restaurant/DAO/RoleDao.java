package com.project5.Restaurant.DAO;

import com.project5.Restaurant.DAO.Base.GenericDao;
import com.project5.Restaurant.Model.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao extends GenericDao<Role,Integer> {
    public RoleDao() {
        super(Role.class, Integer.class);
    }
}
