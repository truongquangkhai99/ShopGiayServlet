package com.example.shopgiaymaster;

import com.dao.CategoryDao;
import com.entities.CategoryEntity;
import com.entities.KhachEntity;
import com.entities.ProductEntity;
import com.mvc.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TestData {
    public static void main(String[] args){
        try {
            Session session = HibernateUtility.getSessionFactory().openSession();

            Query<ProductEntity> query = session.createQuery("FROM ProductEntity ");
            List<ProductEntity> cats = query.list();
            cats.forEach(c -> System.out.println(c.getName()));
//            CategoryDao categoryDao = new CategoryDao();
//            List<CategoryEntity> cats = categoryDao.getListCategory();
//            cats.forEach(c -> System.out.println(c.getName()));
        } catch (Exception e){

        }
    }
}
