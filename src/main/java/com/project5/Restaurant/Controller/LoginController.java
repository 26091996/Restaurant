package com.project5.Restaurant.Controller;

import com.project5.Restaurant.Model.Employee;
import com.project5.Restaurant.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/")
    public String showLogin(Model model) {

        model.addAttribute("showLogin", new Employee());
        return "PageLogin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login(@ModelAttribute Employee employee, Model model) {
        System.out.println("dsfsdfsdfsfsdfsd");
        List<Employee> employeeList = employeeService.getAllEmployee();
        for (int i = 0; i < employeeList.size(); i++)
            if (employeeList.get(i).getUserName().equals(employee.getUserName()) && employeeList.get(i).getPassWord().equals(employee.getPassWord())) {
                return "Index";
            }
        model.addAttribute("showLogin", new Employee());
        return "PageLogin";
    }
}
