package com.project5.Restaurant.Controller.rest;

import com.project5.Restaurant.DTO.ProductDto;
import com.project5.Restaurant.Model.Product;
import com.project5.Restaurant.Service.CategoryService;
import com.project5.Restaurant.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductRestController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @ResponseBody
    @RequestMapping(value = "/getProductAll")
    public List<Product> getProductAllRest()
    {
        return productService.getProductAll();
    }

    @ResponseBody
    @RequestMapping(value = "/getProduct")
    public List<ProductDto> getProductRest()
    {
        return productService.getAllProduct();
    }

    @RequestMapping(value = "/delete/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable int id)
    {
        Product product = productService.getProductById(id);
        productService.deleteProduct(product);
    }

}
