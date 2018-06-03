package com.project5.Restaurant.DAO;

import com.project5.Restaurant.DAO.Base.GenericDao;
import com.project5.Restaurant.Model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao extends GenericDao<Employee, Integer> {
    public EmployeeDao() {
        super(Employee.class, Integer.class);
    }
}
