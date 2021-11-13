package com.dao;

import com.entities.CategoryEntity;
import com.entities.KhachEntity;
import com.entities.ProductEntity;
import com.mvc.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public class ProductDao {
    private final static SessionFactory factory = HibernateUtility.getSessionFactory();

    public List<ProductEntity> getProduct() {
        try (Session session = factory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ProductEntity> query = builder.createQuery(ProductEntity.class);
            Root<ProductEntity> root = query.from(ProductEntity.class);
            query.select(root);

            return  session.createQuery(query).getResultList();
        }
    }

    public ProductEntity getC(Integer id) {
        System.out.printf("%d", id);
        try (Session session = factory.openSession()) {

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<ProductEntity> query = builder.createQuery(ProductEntity.class);
            Root<ProductEntity> root = query.from(ProductEntity.class);
            query.select(root);
            query.where(builder.equal(root.get("id").as(Integer.class), id));
            ProductEntity product = session.createQuery(query).getSingleResult();
            System.out.printf("%d", product);
            return product;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    protected SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
    public ProductEntity find(int id) {


        ProductEntity product = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query<ProductEntity> query = session.createQuery("FROM ProductEntity WHERE id=:id");
            query.setParameter("id", id);
            product = query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        System.out.printf("%d", product);
        return product;
    }

    public ProductEntity getP(int id) {
        System.out.printf("%d", id);
        Transaction transaction = null;
        ProductEntity product = null;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            product = session.get(ProductEntity.class, id);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return product;
    }

    public void deleteProduct(Integer id) {
        try (Session session = factory.openSession()) {
            session.getTransaction().begin();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaDelete<ProductEntity> criteriaDelete = builder.createCriteriaDelete(ProductEntity.class);
            Root<ProductEntity> root = criteriaDelete.from(ProductEntity.class);
            criteriaDelete.where(builder.equal(root.get("id"), id));

            session.createQuery(criteriaDelete).executeUpdate();
            session.getTransaction().commit();
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


    public List<ProductEntity> getListProduct()
    {
        Transaction transaction = null;
        List<ProductEntity> products = null;
        Session session = HibernateUtility.getSessionFactory().openSession();
        try
        {
            transaction = session.beginTransaction();
            Query<ProductEntity> query = session.createQuery("FROM ProductEntity ");
            products = query.list();
            return products;
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
        return products;
    }
}
