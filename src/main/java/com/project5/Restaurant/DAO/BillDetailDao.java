package com.project5.Restaurant.DAO;

import com.project5.Restaurant.DAO.Base.GenericDao;
import com.project5.Restaurant.Model.BillDetail;
import org.springframework.stereotype.Repository;

@Repository
public class BillDetailDao extends GenericDao<BillDetail, Integer> {
    public BillDetailDao() {
        super(BillDetail.class, Integer.class);
    }
}
