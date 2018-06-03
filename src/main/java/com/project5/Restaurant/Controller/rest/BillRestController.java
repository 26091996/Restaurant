package com.project5.Restaurant.Controller.rest;

import com.project5.Restaurant.Model.Bill;
import com.project5.Restaurant.Model.BillDetail;
import com.project5.Restaurant.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BillRestController {

    @Autowired
    BillService billService;

    @ResponseBody
    @RequestMapping(value = "/getBillAll")
    public List<Bill> getProductAllRest()
    {
        return billService.getAllBill();
    }

    @PostMapping(value = "/createBill")
    public ResponseEntity<Bill> add(@RequestBody Bill bill)
    {
        billService.insertBill(bill);
        return new ResponseEntity<Bill>(bill, HttpStatus.OK);
    }
}
