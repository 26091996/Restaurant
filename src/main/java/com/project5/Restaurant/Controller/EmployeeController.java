package com.project5.Restaurant.Controller;

import com.project5.Restaurant.Model.Category;
import com.project5.Restaurant.Model.Employee;
import com.project5.Restaurant.Service.EmployeeService;
import com.project5.Restaurant.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @Autowired
    RoleService roleService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/showEmployeeManager")
    public String showEmplyeeManger()
    {
        return "EmployeeManager";
    }

    @RequestMapping(value = "/AddEmployee")
    public String addEmployee(Model model) {

        model.addAttribute("roleList", roleService.getRoles());
        model.addAttribute("addEmplyee", new Employee());
        return "AddEmployee";
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String createEmployee(@ModelAttribute Employee employee, Model model) {

        employeeService.insertEmployee(employee);
        model.addAttribute("employeeList", employeeService.getAllEmployee());
        return "EmployeeManager";
    }

    @RequestMapping(value = "/updateEmployee/{id}")
    public ModelAndView editEmployee(@PathVariable int id, Model model)
    {
        model.addAttribute("roleList", roleService.getRoles());
        Employee employee = employeeService.getEmployeeById(id);
        return new ModelAndView("EditEmployee","command", employee);
    }

    @RequestMapping(value = "/saveUpdateEmployee", method = RequestMethod.POST)
    public String saveUpdate(@ModelAttribute Employee employee, Model model) {

        employeeService.updateEmployee(employee);
        model.addAttribute("employeeList", employeeService.getAllEmployee());
        return "EmployeeManager";
    }

}
