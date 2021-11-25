package com.ControllerAdmin;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.entities.CategoryEntity;
import com.entities.ProductEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateCategory", urlPatterns = {"/updateC"})
public class UpdateCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("cid");
        CategoryDao dao = new CategoryDao();
        System.out.println(id);
        CategoryEntity category = dao.getcategory(Integer.parseInt(id));
        request.setAttribute("category", category);
        request.getRequestDispatcher("updateCate.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        CategoryEntity category = new CategoryEntity();
        category.setId(Integer.parseInt(request.getParameter("cid")));
        category.setName(request.getParameter("name"));


        CategoryDao categoryDao = new CategoryDao();
        categoryDao.updateCate(category);
        response.sendRedirect("load");
    }
}

