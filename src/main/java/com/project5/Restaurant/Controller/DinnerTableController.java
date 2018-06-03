package com.project5.Restaurant.Controller;

import com.project5.Restaurant.Model.Category;
import com.project5.Restaurant.Model.DinnerTable;
import com.project5.Restaurant.Service.DinnerTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DinnerTableController {

    @Autowired
    DinnerTableService dinnerTableService;

    @RequestMapping(value = "/showDinnerTableManager")
    public String showDinnerTableManger()
    {
        return "DinnerTableManager";
    }

    @RequestMapping(value = "/AddDinnerTable")
    public String addDinnerTable(Model model) {
        model.addAttribute("AddDinnerTable", new DinnerTable());
        return "AddDinnerTable";
    }

    @RequestMapping(value = "/saveDinnertable", method = RequestMethod.POST)
    public String createDinnerTable(@ModelAttribute DinnerTable dinnerTable, Model model) {

        dinnerTableService.insertDinnerTable(dinnerTable);
        model.addAttribute("dinnerTableList", dinnerTableService.getAllDinnerTable());
        return "DinnerTableManager";
    }

    @RequestMapping(value = "/updateDinnerTable/{id}")
    public ModelAndView editDinnerTable(@PathVariable int id, Model model)
    {
        DinnerTable dinnerTable = dinnerTableService.getDinnerTable(id);
        return new ModelAndView("EditDinnerTable","command", dinnerTable);
    }

    @RequestMapping(value = "/saveUpdateDinnerTable", method = RequestMethod.POST)
    public String saveUpdate(@ModelAttribute DinnerTable dinnerTable, Model model) {

        dinnerTableService.updateDinnerTable(dinnerTable);
        model.addAttribute("dinnerTableList", dinnerTableService.getAllDinnerTable());
        return "DinnerTableManager";
    }
}
