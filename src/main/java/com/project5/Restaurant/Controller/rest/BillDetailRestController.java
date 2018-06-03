package com.project5.Restaurant.Controller.rest;

import com.project5.Restaurant.Model.BillDetail;
import com.project5.Restaurant.Model.Product;
import com.project5.Restaurant.Service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@Controller
public class BillDetailRestController {

    @Autowired
    BillDetailService billDetailService;

    @ResponseBody
    @RequestMapping(value = "/getBillDetailAll")
    public List<BillDetail> getProductAllRest()
    {
        return billDetailService.getAllBillDetail();
    }

    @PostMapping(value = "/createBillDetail")
    public ResponseEntity<BillDetail> add(@RequestBody BillDetail billDetail)
    {
        billDetailService.insertBillDetail(billDetail);
        return new ResponseEntity<BillDetail>(billDetail, HttpStatus.OK);
    }

}
