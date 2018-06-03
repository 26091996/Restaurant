package com.project5.Restaurant.Controller.rest;

import com.project5.Restaurant.DTO.DinnerTableDto;
import com.project5.Restaurant.DTO.EmployeeDto;
import com.project5.Restaurant.Model.DinnerTable;
import com.project5.Restaurant.Model.Employee;
import com.project5.Restaurant.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmplyeeRestController {

    @Autowired
    EmployeeService employeeService;

    @ResponseBody
    @RequestMapping(value = "/getEmplyee")
    public List<EmployeeDto> getEmplyee()
    {
        return employeeService.getEmployees();
    }

    @RequestMapping(value = "/deleteEmployee/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable int id)
    {
      Employee employee = employeeService.getEmployeeById(id);
       employeeService.deleteEmployee(employee);
    }
}
