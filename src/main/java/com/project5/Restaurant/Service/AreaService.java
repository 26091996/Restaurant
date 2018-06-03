package com.project5.Restaurant.Service;

import com.project5.Restaurant.DAO.AreaDao;
import com.project5.Restaurant.Model.Area;
import com.project5.Restaurant.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    @Autowired
    AreaDao areaDao;

    public List<Area> getAllArea()
    {
        List<Area> list = areaDao.getAllArea();
        return list;
    }

    public void insertArea(Area area)
    {
        areaDao.insertArea(area);
    }

    public void updateArea(Area area)
    {
        areaDao.updateArea(area);
    }

    public void deleteArea(Area area)
    {
        areaDao.deleteArea(area);
    }

    public Area getAreaById(int id)
    {
        return areaDao.findByPK(id);
    }
}
