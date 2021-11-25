package com.ControllerAdmin;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.entities.CategoryEntity;
import com.entities.ProductEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreatCategory", urlPatterns = {"/creatC"})
public class CreatCategory extends HttpServlet {

    protected void CreatCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        CategoryEntity category = new CategoryEntity();

        category.setName(request.getParameter("name"));

        CategoryDao categoryDao = new CategoryDao();
        categoryDao.insertCategory(category);
        RequestDispatcher rd = request.getRequestDispatcher("/insertC.jsp");

        rd.forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CreatCate(request,response);
    }
}
