package com.project5.Restaurant.Controller;

import com.project5.Restaurant.Model.Area;
import com.project5.Restaurant.Model.Category;
import com.project5.Restaurant.Service.AreaService;
import com.project5.Restaurant.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/showArea")
    public String showCategoryManger()
    {
        return "AreaManager";
    }

    @RequestMapping(value = "/AddArea")
    public String addArea(Model model) {
        model.addAttribute("AddArea", new Area());
        return "AddArea";
    }

    @RequestMapping(value = "/saveArea", method = RequestMethod.POST)
    public String createArea(@ModelAttribute Area category, Model model) {

        areaService.insertArea(category);
        model.addAttribute("areaList", areaService.getAllArea());
        return "AreaManager";
    }

    @RequestMapping(value = "/updateArea/{id}")
    public ModelAndView editArea(@PathVariable int id, Model model)
    {
        Area area = areaService.getAreaById(id);
        return new ModelAndView("EditArea","command", area);
    }

    @RequestMapping(value = "/saveUpdateArea", method = RequestMethod.POST)
    public String saveUpdate(@ModelAttribute Area area, Model model) {

        areaService.updateArea(area);
        model.addAttribute("areaList", areaService.getAllArea());
        return "AreaManager";
    }
}
