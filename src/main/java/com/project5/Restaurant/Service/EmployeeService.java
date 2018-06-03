package com.project5.Restaurant.Service;

import com.project5.Restaurant.DAO.EmployeeDao;
import com.project5.Restaurant.DAO.RoleDao;
import com.project5.Restaurant.DTO.DinnerTableDto;
import com.project5.Restaurant.DTO.EmployeeDto;
import com.project5.Restaurant.Model.Area;
import com.project5.Restaurant.Model.DinnerTable;
import com.project5.Restaurant.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    RoleDao roleDao;

    public List<Employee> getAllEmployee()
    {
        List<Employee> list = employeeDao.findAll();
        return list;
    }

    public void insertEmployee(Employee employee)
    {
        employeeDao.insert(employee);
    }

    public void updateEmployee(Employee employee)
    {
        employeeDao.update(employee);
    }

    public void deleteEmployee(Employee employee)
    {
        employeeDao.delete(employee);
    }

    public Employee getEmployeeById(int id)
    {
       return employeeDao.findByPK(id);
    }

    public List<EmployeeDto> getEmployees()
    {
        List<Employee> employees = employeeDao.findAll();
        List<EmployeeDto> dtos = new ArrayList<>();
        EmployeeDto employeeDto = null;
        if (employees != null && !employees.isEmpty())
            for(int i = 0;i<employees.size();i++)
            {
                employeeDto = new EmployeeDto();
                employeeDto.setEmployeeId(employees.get(i).getEmployeeId());
                employeeDto.setRoleName(roleDao.findByPK(employees.get(i).getRoleId()).getRolename());
                employeeDto.setEmployeeName(employees.get(i).getEmployeeName());
                employeeDto.setPhone(employees.get(i).getPhone());
                employeeDto.setUserName(employees.get(i).getUserName());
                employeeDto.setAddress(employees.get(i).getAddress());

                dtos.add(employeeDto);
            }
        return dtos;
    }

}
