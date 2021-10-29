package com.controller;


import com.dao.CategoryDao;
import com.dao.KhachDao;
import com.entities.CategoryEntity;
import com.entities.KhachEntity;
import com.mvc.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginConTroller", urlPatterns = {"/Login", "/index"})
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String userN = request.getParameter("userName");
        String passW = request.getParameter("passWord");

        String url;
        KhachEntity user = new KhachEntity();
        KhachDao khachDao = new KhachDao();
        user = khachDao.getCheckUser(userN, passW);
        if (user != null)
        {
            request.setAttribute("signinTrue", true);
            url = "/index.jsp";
            request.getSession().setAttribute("user", user);
//            CategoryDao categoryDao = new CategoryDao();
//            List<CategoryEntity> product = categoryDao.getListCategory();
//            request.getSession().setAttribute("product", product);
        }
        else
        {
            request.setAttribute("signinFalse", true);
            url = "/login.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
        System.out.println(userN);
        System.out.println(passW);
    }

}
