package com.project5.Restaurant.Controller.rest;

import com.project5.Restaurant.DAO.CategoryDao;
import com.project5.Restaurant.DTO.CategoryDto;
import com.project5.Restaurant.DTO.ProductDto;
import com.project5.Restaurant.Model.Area;
import com.project5.Restaurant.Model.BillDetail;
import com.project5.Restaurant.Model.Category;
import com.project5.Restaurant.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping(value = "/getCategory")
    public List<CategoryDto> getCategoryRest()
    {
        return categoryService.getAllCategories();
    }

    @RequestMapping(value = "/deleteCategory/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable int id)
    {
        Category category = categoryService.getCategoryById(id);
        categoryService.deleteCategory(category);
    }

    @PostMapping(value = "/createCategory")
    public ResponseEntity<Category> add(@RequestBody Category category)
    {
        categoryService.saveCategory(category);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

}
