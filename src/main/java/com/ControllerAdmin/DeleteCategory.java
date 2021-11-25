package com.ControllerAdmin;

import com.dao.CategoryDao;
import com.dao.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteCategory", value = "/deleteC")
public class DeleteCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("cid"));
        System.out.println(id);
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.deleteCate(id);

        response.sendRedirect("load");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
