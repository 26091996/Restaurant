package com.project5.Restaurant.Service;

import com.project5.Restaurant.DAO.CategoryDao;
import com.project5.Restaurant.DTO.CategoryDto;
import com.project5.Restaurant.DTO.ProductDto;
import com.project5.Restaurant.Model.Area;
import com.project5.Restaurant.Model.Category;
import com.project5.Restaurant.Model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public Map<Integer,String> getCategories() {

        Map<Integer,String> cate = new HashMap<Integer, String>();
        List<Category> categoryList = categoryDao.getAllCategory();
        List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();
        if (categoryList != null && !categoryList.isEmpty())
            for (Category obj : categoryList)
            {
                CategoryDto categoryDto = new CategoryDto();
                BeanUtils.copyProperties(obj,categoryDto);
                categoryDtoList.add(categoryDto);
            }
            for (int i = 0;i<categoryDtoList.size();i++)
            {
                cate.put(categoryDtoList.get(i).getCategoryId(),categoryDtoList.get(i).getCategoryName());
            }
        return cate;
    }

    public List<CategoryDto> getAllCategories() {

        List<CategoryDto> dtos = new ArrayList<>();
        List<Category> categoryList = categoryDao.getAllCategory();
        if (categoryList != null && !categoryList.isEmpty())
            for (Category obj : categoryList)
            {
                CategoryDto categoryDto = new CategoryDto();
                BeanUtils.copyProperties(obj,categoryDto);
                dtos.add(categoryDto);
            }
        return dtos;
    }

    public Category getCategoryById(int id)
    {
        return categoryDao.getCategoryById(id);
    }

    public void saveCategory(Category category) {
        categoryDao.insert(category);
    }

    public void updateCategory(Category category) {
        categoryDao.update(category);
    }

    public void deleteCategory(Category category)
    {
        categoryDao.delete(category);
    }


}
