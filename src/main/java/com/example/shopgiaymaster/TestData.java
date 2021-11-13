package com.example.shopgiaymaster;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.entities.CategoryEntity;
import com.entities.KhachEntity;
import com.entities.ProductEntity;
import com.fasterxml.classmate.AnnotationConfiguration;
import com.mvc.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public class TestData {

    private static final SessionFactory factory = HibernateUtility.getSessionFactory();

    public static void queryDemo() {
        try (Session session = factory.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();// tạo CriteriaBuilder. Dùng đối tượng session để lấy builder
            CriteriaQuery<ProductEntity> query = builder.createQuery(ProductEntity.class);
            Root<ProductEntity> root = query.from(ProductEntity.class);
            query.select(root);

            // lọc dữ liệu theo tên
//            Predicate p1 = builder.like(root.get("name").as(String.class), "%Zezy%");
//            Predicate p2 = builder.like(root.get("desciption").as(String.class), "%Black%");
//            Predicate p3 = builder.between(root.get("price").as(BigDecimal.class), new BigDecimal(25), new BigDecimal(35));
//            query.where(builder.and(builder.or(p1,p2), p3));


            Query<ProductEntity> q = session.createQuery(query);
            List<ProductEntity> products = q.getResultList();

            products.forEach(p->System.out.printf("%s: %.2f\n",
                    p.getName(), p.getPrice()));
        }
    }
    public static void main(String[] args) {
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {

//            CategoryEntity c = session.get(CategoryEntity.class, 1);
//            c.getProducts().forEach(p-> System.err.println(p.getName()));

//            Query<ProductEntity> query = session.createQuery("FROM CategoryEntity ");
//            List<ProductEntity> cats = query.list();
//            cats.forEach(c -> System.out.println(c.getName()));
//
//            ProductEntity product = session.get(ProductEntity.class, 4);

//            ProductDao productDao = new ProductDao();
//
//            Query<ProductEntity> query = session.createQuery("FROM ProductEntity ");
//            List<ProductEntity> cats = query.list();
//            cats.forEach(c -> System.out.println(c.getName()));



//            ProductEntity product = session.get(ProductEntity.class, 7);
//            System.out.println(product.getName());
            ProductEntity product = new ProductEntity();

            ProductDao productDao = new ProductDao();
            productDao.deleteProduct(5);



//            Session session = HibernateUtility.getSessionFactory().openSession();
//            session.beginTransaction();
//            CategoryEntity product = session.get(CategoryEntity.class, 1);
//            System.out.println(product.getName());
//            session.getTransaction().commit();
//            session.close();

//            session.getTransaction().begin();
//            CategoryEntity c = session.get(CategoryEntity.class, 1);

//            ProductEntity p =new ProductEntity();
//            p.setName("Iphone 13");
//            p.setDesciption("Next Generation");
////            p.setPrice(new BigDecimal(100));
//            p.setCategory(c);
//
//            session.save(p);
//            session.getTransaction().commit();
//
//        } catch (Exception e){
//
//        }
//        queryDemo();
        }
    }
}


