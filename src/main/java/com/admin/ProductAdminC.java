package com.admin;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.entities.CategoryEntity;
import com.entities.ProductEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductAdminC", urlPatterns = {"/Login1"})
public class ProductAdminC extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");


        CategoryDao categoryDao = new CategoryDao();
        ProductEntity product = new ProductEntity();

        product.setName(request.getParameter("name"));
        product.setDesciption(request.getParameter("description"));
        product.setPrice(Float.parseFloat(request.getParameter("price")));
        product.setImage(request.getParameter("image"));
        product.setCategory(categoryDao.getcategory(Integer.parseInt(request.getParameter("cid"))));
        System.out.printf("%s", product.getName());

        ProductDao productDao = new ProductDao();
        productDao.insertProduct(product);
        RequestDispatcher rd = request.getRequestDispatcher("/insertP.jsp");

        rd.forward(request,response);

    }

    protected void getlistRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");


        ProductDao productDao = new ProductDao();
        List<ProductEntity> pros = productDao.getProduct();
        request.setAttribute("products", pros);
        pros.forEach(c -> System.out.println(c.getName()));

        RequestDispatcher rd = request.getRequestDispatcher("/managerProduct.jsp");
        rd.forward(request, response);


    }

    protected void deleteRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");


//        ProductEntity product = new ProductEntity();

        ProductDao productDao = new ProductDao();
        productDao.deleteProduct(9);

        RequestDispatcher rd = request.getRequestDispatcher("/managerProduct.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);
        getlistRequest(request,response);
        deleteRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);
        getlistRequest(request,response);
        String iAction = request.getParameter("action");

        if (iAction != null && !iAction.equals("")) {
            if (iAction.equals("delete")) {
                deleteRequest(request,response);
            } else if (iAction.equals("Update")) {
//                updateCart(request);
            } else if (iAction.equals("Delete")) {
//                deleteCart(request);
            }
        }
        response.sendRedirect("managerProduct.jsp");
    }
}
