package com.dao;

import com.entities.CategoryEntity;
import com.mvc.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CategoryDao {
    private final static SessionFactory factory = HibernateUtility.getSessionFactory();
    public List<CategoryEntity> getListCategory()
    {
        Transaction transaction = null;
        List<CategoryEntity> categorys = null;
        Session session = HibernateUtility.getSessionFactory().openSession();
        try
        {
            transaction = session.beginTransaction();
            Query<CategoryEntity> query = session.createQuery("FROM CategoryEntity ");
            categorys = query.list();
            return categorys;
        }
        catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return categorys;
    }
    public CategoryEntity getcategory(Integer id) {
        try (Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<CategoryEntity> query = builder.createQuery(CategoryEntity.class);
            Root<CategoryEntity> root = query.from(CategoryEntity.class);
            query.select(root);
            query.where(builder.equal(root.get("id").as(Integer.class), id));
            CategoryEntity category = session.createQuery(query).getSingleResult();
            System.out.printf("%d", id);
            return category;
        }
    }
}
