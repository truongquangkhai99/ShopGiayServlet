package com.dao;

import com.entities.CategoryEntity;
import com.entities.KhachEntity;
import com.entities.ProductEntity;
import com.mvc.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.List;

public class ProductDao {
    private final static SessionFactory factory = HibernateUtility.getSessionFactory();

    public List<ProductEntity> getlistProduct() {
        try (Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ProductEntity> query = builder.createQuery(ProductEntity.class);
            Root<ProductEntity> root = query.from(ProductEntity.class);
            query.select(root);

            return  session.createQuery(query).getResultList();
        }
    }

    public void deleteProduct(Integer id) {
//        try (Session session = factory.openSession()) {
//            session.getTransaction().begin();
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaDelete<ProductEntity> criteriaDelete = builder.createCriteriaDelete(ProductEntity.class);
//            Root<ProductEntity> root = criteriaDelete.from(ProductEntity.class);
//            criteriaDelete.where(builder.equal(root.get("id"), id));
//
//            session.createQuery(criteriaDelete).executeUpdate();
//            session.getTransaction().commit();
//        }
        Session session = factory.openSession();
        try {
            session.getTransaction().begin();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<ProductEntity> delete = builder.createCriteriaDelete(ProductEntity.class);
            Root<ProductEntity> root = delete.from(ProductEntity.class);
            delete.where(builder.equal(root.get("id"), id));

            session.createQuery(delete).executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    public void insertProduct(ProductEntity product) {
        try (Session session = factory.openSession()) {
            try {
                session.getTransaction().begin();

                session.save(product);
                session.getTransaction().commit();

            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }

    }

    public void updateProduct(ProductEntity product) {
        Session session = factory.openSession();
        try {
            session.getTransaction().begin();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaUpdate<ProductEntity> update = builder.createCriteriaUpdate(ProductEntity.class);
            Root<ProductEntity> root = update.from(ProductEntity.class);
            update.set(root.get("name"), product.getName());
            update.set(root.get("image"), product.getImage());
            update.set(root.get("price"), product.getPrice());
            update.set(root.get("title"), product.getTitle());
            update.set(root.get("description"), product.getDescription());
            update.set(root.get("category"), product.getCategory());
            update.where(builder.equal(root.get("id"), product.getId()));

            session.createQuery(update).executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }
    public ProductEntity getProductById(String id) {
        Session session = factory.openSession();
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ProductEntity> query = builder.createQuery(ProductEntity.class);
            Root<ProductEntity> root = query.from(ProductEntity.class);
            query.select(root);

            query.where(builder.equal(root.get("id").as(Integer.class), id));

            ProductEntity products = session.createQuery(query).getSingleResult();
            return products;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }
    public ProductEntity getproduct(Integer id) {
        try (Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ProductEntity> query = builder.createQuery(ProductEntity.class);
            Root<ProductEntity> root = query.from(ProductEntity.class);
            query.select(root);
            query.where(builder.equal(root.get("id").as(Integer.class), id));
            ProductEntity product = session.createQuery(query).getSingleResult();
            return product;
        }
    }

}
