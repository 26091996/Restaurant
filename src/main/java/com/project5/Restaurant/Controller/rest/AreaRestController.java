package com.project5.Restaurant.Controller.rest;

import com.project5.Restaurant.Model.Area;
import com.project5.Restaurant.Model.Product;
import com.project5.Restaurant.Service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AreaRestController {

    @Autowired
    AreaService areaService;

    @ResponseBody
    @RequestMapping(value = "/getArea")
    public List<Area> getAreaRest()
    {
       return areaService.getAllArea();
    }

    @RequestMapping(value = "/deleteArea/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable int id)
    {
        Area area = areaService.getAreaById(id);
        areaService.deleteArea(area);
    }
}
