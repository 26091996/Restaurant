package com.project5.Restaurant.DAO;

import com.project5.Restaurant.DAO.Base.GenericDao;
import com.project5.Restaurant.Model.Bill;
import org.springframework.stereotype.Repository;

@Repository
public class BillDao extends GenericDao<Bill, Integer> {
    public BillDao() {
        super(Bill.class, Integer.class);
    }
}
