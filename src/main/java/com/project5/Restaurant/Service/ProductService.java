package com.project5.Restaurant.Service;

import com.project5.Restaurant.DAO.CategoryDao;
import com.project5.Restaurant.DAO.ProductDao;
import com.project5.Restaurant.DTO.ProductDto;
import com.project5.Restaurant.Model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    public List<Product> getProductAll() {
        return productDao.getAllProduct();
    }

    public List<ProductDto> getAllProduct() {

        List<Product> productModelList = productDao.getAllProduct();
        List<ProductDto> productDtoList = new ArrayList<>();
        ProductDto productDto = null;
        if (productModelList != null && !productModelList.isEmpty())
            for (int i = 0; i < productModelList.size(); i++) {
                productDto = new ProductDto();
                productDto.setProductId(productModelList.get(i).getProductId());
                productDto.setCategoryName(categoryDao.getCategoryById(productModelList.get(i).getCategoryId()).getCategoryName());
                if (productModelList.get(i).getProductStatus().equals("0")) {
                    productDto.setProductStatus("Hết hàng");
                } else {
                    productDto.setProductStatus("Còn hàng");
                }
                productDto.setProductName(productModelList.get(i).getProductName());
                productDto.setProductDetails(productModelList.get(i).getProductDetails());
                productDto.setProductPrice(productModelList.get(i).getProductPrice());
                productDto.setProductUnit(productModelList.get(i).getProductUnit());
                productDto.setProductImage(productModelList.get(i).getProductImage());
                productDto.setProductQuanity(productModelList.get(i).getProductQuantity());
                productDtoList.add(productDto);
            }
        return productDtoList;
    }


    public Map<Integer, String> getStatus() {
        Map<Integer, String> stattus = new HashMap<Integer, String>();
        stattus.put(0, "Hết hàng");
        stattus.put(1, "Còn hàng");
        return stattus;
    }

    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    public void updateOrInsert(Product product) {
        productDao.updateOrInsert(product);
    }

    public void deleteProduct(Product product)
    {
        productDao.delete(product);
    }
}
