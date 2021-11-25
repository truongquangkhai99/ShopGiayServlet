package com.dao;

import com.entities.CategoryEntity;
import com.entities.ProductEntity;
import com.mvc.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.util.List;

public class CategoryDao {
    private final static SessionFactory factory = HibernateUtility.getSessionFactory();

    public void insertCategory(CategoryEntity category) {
        try (Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();
                session.save(category);
                session.getTransaction().commit();

            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
    }

    public void deleteCate(Integer id) {
        try (Session session = factory.openSession()) {
            session.getTransaction().begin();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<CategoryEntity> criteriaDelete = builder.createCriteriaDelete(CategoryEntity.class);
            Root<CategoryEntity> root = criteriaDelete.from(CategoryEntity.class);
            criteriaDelete.where(builder.equal(root.get("id"), id));

            session.createQuery(criteriaDelete).executeUpdate();
            session.getTransaction().commit();
        }
    }

    public void updateCate(CategoryEntity category) {
        Session session = factory.openSession();
        try {
            session.getTransaction().begin();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaUpdate<CategoryEntity> update = builder.createCriteriaUpdate(CategoryEntity.class);
            Root<CategoryEntity> root = update.from(CategoryEntity.class);
            update.set(root.get("name"), category.getName());
            update.where(builder.equal(root.get("id"), category.getId()));

            session.createQuery(update).executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public CategoryEntity getcategory(Integer id) {
        try (Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<CategoryEntity> query = builder.createQuery(CategoryEntity.class);
            Root<CategoryEntity> root = query.from(CategoryEntity.class);
            query.select(root);
            query.where(builder.equal(root.get("id").as(Integer.class), id));
            CategoryEntity category = session.createQuery(query).getSingleResult();
            return category;
        }
    }

    public List<CategoryEntity> getlistCategory() {
        try (Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<CategoryEntity> query = builder.createQuery(CategoryEntity.class);
            Root<CategoryEntity> root = query.from(CategoryEntity.class);
            query.select(root);

            return  session.createQuery(query).getResultList();
        }
    }
}
