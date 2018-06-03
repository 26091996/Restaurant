package com.project5.Restaurant.DAO;

import com.project5.Restaurant.DAO.Base.GenericDao;
import com.project5.Restaurant.DTO.ProductDto;
import com.project5.Restaurant.Model.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao extends GenericDao<Product, Integer> {

@Autowired
    SessionFactory sessionFactory;

    public ProductDao() {
        super(Product.class, Integer.class);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getAllProduct() {
        List<Product> result = findAll();
        return result;
    }
    public void saveProduct(Product product)
    {
//        sessionFactory.getCurrentSession().save(product);
        insert(product);
    }

    public Product getProductById(int id)
    {
       return findByPK(id);
    }

    public void updateProduct(Product product)
    {
        update(product);
    }

    public void updateOrInsert(Product product)
    {
        insertOrUpdate(product);
    }
}
