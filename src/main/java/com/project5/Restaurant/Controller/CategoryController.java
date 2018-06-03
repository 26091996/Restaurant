package com.project5.Restaurant.Controller;

import com.project5.Restaurant.Model.Category;
import com.project5.Restaurant.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/showCategoryManager")
    public String showCategoryManger() {
        return "CategoryManager";
    }

    @RequestMapping(value = "/AddCategory")
    public String addCategory(Model model) {
        model.addAttribute("AddCategory", new Category());
        return "AddCategory";
    }

    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
    public String createCategory(@ModelAttribute Category category, Model model) {

        categoryService.saveCategory(category);
        model.addAttribute("categoryList", categoryService.getCategories());
        return "CategoryManager";
    }

    @RequestMapping(value = "/updateCategory/{id}")
    public ModelAndView editCategory(@PathVariable int id, Model model) {
        Category category = categoryService.getCategoryById(id);
        return new ModelAndView("EditCategory", "command", category);
    }

    @RequestMapping(value = "/saveUpdateCategory", method = RequestMethod.POST)
    public String saveUpdate(@ModelAttribute Category category, Model model) {

        categoryService.updateCategory(category);
        model.addAttribute("CategoryList", categoryService.getCategories());
        return "CategoryManager";
    }
}
