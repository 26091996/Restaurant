package com.project5.Restaurant.DAO;

import com.project5.Restaurant.DAO.Base.GenericDao;
import com.project5.Restaurant.Model.Category;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao extends GenericDao<Category, Integer> {
    @Autowired
    SessionFactory sessionFactory;

    public CategoryDao() {
        super(Category.class, Integer.class);
    }

    public List<Category> getAllCategory() {
       List<Category> result = findAll();
        return result;
    }
    public Category getCategoryById(int id)
    {
       return findByPK(id);
    }

}
