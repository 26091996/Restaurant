package com.project5.Restaurant.Controller;

import com.project5.Restaurant.Model.Product;
import com.project5.Restaurant.Service.CategoryService;
import com.project5.Restaurant.Service.ProductService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ServletContext context;
//    @Autowired
//    private CategoryServoce categoryServoce;

    @RequestMapping(value = "/index")
    public String home(Model model) {
        model.addAttribute("productList", productService.getProductAll());
        return "Index";
    }

    @RequestMapping(value = "/ProductManager")
    public String productManager() {
        return "ProductManager";
    }

    @RequestMapping(value = "/addProduct")
    public String addProduct(Model model) {

        model.addAttribute("cateList", categoryService.getCategories());
        model.addAttribute("statusList", productService.getStatus());
        model.addAttribute("addProduct", new Product());
        return "AddProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String createProduct(@Valid @ModelAttribute Product product, BindingResult result1, Model model, @RequestParam(value = "image") MultipartFile file, BindingResult result) {

        if (result1.hasErrors()) {
            model.addAttribute("addProduct", new Product());
            model.addAttribute("result1",result1);
            return "AddProduct";
        }
        try {
            if (!file.isEmpty()) {
                String path = context.getRealPath("/WEB-INF/img") + File.separator + file.getOriginalFilename();
                FileUtils.forceMkdir(new File(path));
                File deFile = new File(path);
                file.transferTo(deFile);
                product.setProductImage(deFile.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        productService.saveProduct(product);
        model.addAttribute("productList", productService.getAllProduct());

        return "ProductManager";
    }

    @RequestMapping(value = "/updateProduct/{id}")
    public ModelAndView editProduct(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("cateList", categoryService.getCategories());
        model.addAttribute("statusList", productService.getStatus());
        return new ModelAndView("EditProduct", "command", product);
    }

    @RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
    public String saveUpdate(@ModelAttribute Product product, Model model, @RequestParam(value = "image") MultipartFile file, BindingResult result) {
        try {
            if (!file.isEmpty()) {
                String path = context.getRealPath("/WEB-INF/img") + File.separator + file.getOriginalFilename();
                FileUtils.forceMkdir(new File(path));
                File deFile = new File(path);
                file.transferTo(deFile);
                product.setProductImage(deFile.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        productService.updateProduct(product);
        return "ProductManager";
    }

}
