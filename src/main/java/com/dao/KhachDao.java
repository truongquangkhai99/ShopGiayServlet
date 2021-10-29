package com.dao;

import com.entities.KhachEntity;
import com.mvc.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class KhachDao {
    public boolean saveUser(KhachEntity user,boolean isManager)
    {
        Transaction transaction = null;
        Session session = HibernateUtility.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            System.out.println("Save user successfully");
            return true;
        } catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
    }
    public  boolean updateUser(KhachEntity user)
    {
        Transaction transaction = null;
        Session session = HibernateUtility.getSessionFactory().openSession();
        try
        {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            System.out.println("Update user successfully");
            return true;
        }
        catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        finally
        {
            session.close();
        }
    }
    public boolean deleteUser(String userID)
    {
        Transaction transaction = null;
        Session session = HibernateUtility.getSessionFactory().openSession();
        try
        {
            transaction = session.beginTransaction();
            KhachEntity user = session.get(KhachEntity.class, userID);
            if (user != null)
            {
                session.delete(user);
                System.out.println("Delete user successfully");
            }
            transaction.commit();
            return true;
        }
        catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        finally
        {
            session.close();
        }
    }


    public KhachEntity getUserByEmail(String userName)
    {
        Transaction transaction = null;
        KhachEntity user = null;
        Session session = HibernateUtility.getSessionFactory().openSession();
        try
        {
            transaction = session.beginTransaction();
            Query<KhachEntity> query = session.createQuery("FROM KhachEntity WHERE userName=:userName");
            query.setParameter("userName", userName);
            user = query.uniqueResult();
            transaction.commit();
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
        return user;
    }

    public KhachEntity getCheckUser(String userName, String passWord)
    {
        Transaction transaction = null;
        KhachEntity user = null;
        Session session = HibernateUtility.getSessionFactory().openSession();
        try
        {
            transaction = session.beginTransaction();
            Query<KhachEntity> query = session.createQuery("FROM KhachEntity WHERE userName=:userName and passWord=:passWord");
            query.setParameter("userName", userName);
            query.setParameter("passWord", passWord);
            user = query.uniqueResult();
            transaction.commit();
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
        return user;
    }
}
