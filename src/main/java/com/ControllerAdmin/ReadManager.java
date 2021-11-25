package com.ControllerAdmin;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.entities.CategoryEntity;
import com.entities.ProductEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReadManager", urlPatterns = {"/load"})
public class ReadManager extends HttpServlet {

    protected void getManagerAd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        ProductDao productDao = new ProductDao();
        List<ProductEntity> pros = productDao.getlistProduct();
        request.setAttribute("products", pros);
        CategoryDao categoryDao = new CategoryDao();
        List<CategoryEntity> cate = categoryDao.getlistCategory();
        request.setAttribute("category", cate);

        RequestDispatcher rd = request.getRequestDispatcher("/ManaAdmin.jsp");
        rd.forward(request, response);


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getManagerAd(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
