package com.admin;

import com.dao.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDelete", urlPatterns ={"/ServletDelete"} )
public class ServletDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("pid"));
        System.out.println(id);

        ProductDao productDao = new ProductDao();
        productDao.deleteProduct(id);

        response.sendRedirect("load");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
