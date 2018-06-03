package com.project5.Restaurant.Service;

import com.project5.Restaurant.DAO.RoleDao;
import com.project5.Restaurant.DTO.CategoryDto;
import com.project5.Restaurant.DTO.RoleDto;
import com.project5.Restaurant.Model.Category;
import com.project5.Restaurant.Model.Employee;
import com.project5.Restaurant.Model.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    public List<Role> getAllRole()
    {
        List<Role> list = roleDao.findAll();
        return list;
    }

    public void insertRole(Role role)
    {
        roleDao.insert(role);
    }

    public void updateRole(Role role)
    {
        roleDao.update(role);
    }

    public void deleteRole(Role role)
    {
        roleDao.delete(role);
    }

    public void getRoleById(int id)
    {
        roleDao.findByPK(id);
    }


    public Map<Integer,String> getRoles() {

        Map<Integer,String> role = new HashMap<Integer, String>();
        List<Role> roleList = roleDao.findAll();
        List<RoleDto> dtos = new ArrayList<>();
        if (roleList != null && !roleList.isEmpty())
            for (Role obj : roleList)
            {
                RoleDto roleDto = new RoleDto();
                BeanUtils.copyProperties(obj,roleDto);
                dtos.add(roleDto);
            }
        for (int i = 0;i<dtos.size();i++)
        {
            role.put(dtos.get(i).getRoleId(),dtos.get(i).getRoleName());
        }
        return role;
    }
}
