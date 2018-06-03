package com.project5.Restaurant.Controller.rest;

import com.project5.Restaurant.DTO.CategoryDto;
import com.project5.Restaurant.DTO.DinnerTableDto;
import com.project5.Restaurant.Model.Category;
import com.project5.Restaurant.Model.DinnerTable;
import com.project5.Restaurant.Service.DinnerTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DinnerTableRestController {

    @Autowired
    DinnerTableService dinnerTableService;

    @ResponseBody
    @RequestMapping(value = "/getDinnerTable")
    public List<DinnerTableDto> getDinnerTablet()
    {
        return dinnerTableService.getDinnerTables();
    }

    @ResponseBody
    @RequestMapping(value = "/getALLDinnerTable")
    public List<DinnerTable> getAllDinnerTablet()
    {
        return dinnerTableService.getAllDinnerTable();
    }

    @RequestMapping(value = "/deleteDinnerTable/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable int id)
    {
        DinnerTable dinnerTable = dinnerTableService.getDinnerTable(id);
        dinnerTableService.deleteDinnerTable(dinnerTable);
    }

}
