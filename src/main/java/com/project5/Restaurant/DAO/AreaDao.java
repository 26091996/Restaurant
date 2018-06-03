package com.project5.Restaurant.DAO;

import com.project5.Restaurant.DAO.Base.GenericDao;
import com.project5.Restaurant.Model.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AreaDao extends GenericDao<Area, Integer> {
    public AreaDao() {
        super(Area.class, Integer.class);
    }

    public List<Area> getAllArea()
    {
        List<Area> list = findAll();
        return list;
    }

    public void insertArea(Area area)
    {
        insert(area);
    }

    public void updateArea(Area area)
    {
        update(area);
    }

    public void deleteArea(Area area)
    {
        delete(area);
    }
}
