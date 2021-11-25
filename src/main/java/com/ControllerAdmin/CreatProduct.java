package com.ControllerAdmin;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.entities.ProductEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CreatProduct", urlPatterns = {"/creatP"})
public class CreatProduct extends HttpServlet {

    protected void CreatProd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");


        CategoryDao categoryDao = new CategoryDao();
        ProductEntity product = new ProductEntity();

        product.setName(request.getParameter("name"));
        product.setDescription(request.getParameter("description"));
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setImage(request.getParameter("image"));
        product.setCategory(categoryDao.getcategory(Integer.parseInt(request.getParameter("cid"))));
        System.out.printf("%s", product.getName());

        ProductDao productDao = new ProductDao();
        productDao.insertProduct(product);
        RequestDispatcher rd = request.getRequestDispatcher("/insertP.jsp");

        rd.forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CreatProd(request,response);
    }
}
