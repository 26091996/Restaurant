package com.project5.Restaurant.Service;

import com.project5.Restaurant.DAO.AreaDao;
import com.project5.Restaurant.DAO.DinnerTableDao;
import com.project5.Restaurant.DTO.DinnerTableDto;
import com.project5.Restaurant.Model.DinnerTable;
import com.project5.Restaurant.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DinnerTableService {

    @Autowired
    DinnerTableDao dinnerTableDao;

    @Autowired
    AreaDao areaDao;

    public List<DinnerTable> getAllDinnerTable()
    {
        List<DinnerTable> list = dinnerTableDao.findAll();
        return list;
    }

    public void insertDinnerTable(DinnerTable dinnerTable)
    {
        dinnerTableDao.insert(dinnerTable);
    }

    public void updateDinnerTable(DinnerTable dinnerTable)
    {
        dinnerTableDao.update(dinnerTable);
    }

    public void deleteDinnerTable(DinnerTable dinnerTable)
    {
        dinnerTableDao.delete(dinnerTable);
    }

    public DinnerTable getDinnerTable(int id)
    {
        return dinnerTableDao.findByPK(id);
    }

    public List<DinnerTableDto> getDinnerTables()
    {
        List<DinnerTable> dinnerTables = dinnerTableDao.findAll();
        List<DinnerTableDto> dtos = new ArrayList<>();
        DinnerTableDto dinnerTableDto = null;
        if (dinnerTables != null && !dinnerTables.isEmpty())
            for(int i = 0;i<dinnerTables.size();i++)
            {
                dinnerTableDto = new DinnerTableDto();
                dinnerTableDto.setDinnerTableName(dinnerTables.get(i).getDinnerTableName());
                dinnerTableDto.setAreaName(areaDao.findByPK(dinnerTables.get(i).getAreaID()).getAreaName());
                dinnerTableDto.setDinnerTableID(dinnerTables.get(i).getDinnerTableID());
                dinnerTableDto.setDinnerTableQuanity(dinnerTables.get(i).getDinnerTableQuanity());
                dtos.add(dinnerTableDto);
            }
            return dtos;
    }

}
