package com.project5.Restaurant.Service;

import com.project5.Restaurant.DAO.BillDetailDao;
import com.project5.Restaurant.Model.Bill;
import com.project5.Restaurant.Model.BillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillDetailService  {

    @Autowired
    BillDetailDao billDetailDao;

    public List<BillDetail> getAllBillDetail()
    {
        List<BillDetail> list = billDetailDao.findAll();
        return list;
    }

    public void insertBillDetail(BillDetail billDetail)
    {
        billDetailDao.insert(billDetail);
    }

    public void updateBillDetail(BillDetail billDetail)
    {
        billDetailDao.update(billDetail);
    }

    public void deleteBillDetail(BillDetail billDetail)
    {
        billDetailDao.delete(billDetail);
    }
}
