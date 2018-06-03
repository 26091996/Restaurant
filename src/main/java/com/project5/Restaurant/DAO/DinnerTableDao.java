package com.project5.Restaurant.DAO;

import com.project5.Restaurant.DAO.Base.GenericDao;
import com.project5.Restaurant.Model.DinnerTable;
import org.springframework.stereotype.Repository;

@Repository
public class DinnerTableDao extends GenericDao<DinnerTable, Integer> {
    public DinnerTableDao() {
        super(DinnerTable.class, Integer.class);
    }
}
