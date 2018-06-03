package com.project5.Restaurant.Service;

import com.project5.Restaurant.DAO.BillDao;
import com.project5.Restaurant.Model.Bill;
import com.project5.Restaurant.Model.DinnerTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    BillDao billDao;

    public List<Bill> getAllBill()
    {
        List<Bill> list = billDao.findAll();
        return list;
    }

    public void insertBill(Bill bill)
    {
        billDao.insert(bill);
    }

    public void updateBill(Bill bill)
    {
        billDao.update(bill);
    }

    public void deleteBill(Bill bill)
    {
        billDao.delete(bill);
    }
}
