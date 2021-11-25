package com.ControllerAdmin;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.entities.CategoryEntity;
import com.entities.ProductEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateProduct", urlPatterns = {"/updateP"})
public class UpdateProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("pid");
        ProductDao dao = new ProductDao();
        System.out.println(id);
        ProductEntity product = dao.getproduct(Integer.parseInt(id));
        request.setAttribute("product", product);
        request.getRequestDispatcher("updateProd.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        CategoryEntity category = (new CategoryDao()).getcategory(Integer.parseInt(request.getParameter("cid")));

        ProductEntity product = new ProductEntity();
        product.setId(Integer.parseInt(request.getParameter("pid")));
        product.setName(request.getParameter("name"));
        product.setDescription(request.getParameter("description"));
        product.setPrice(Double.parseDouble(request.getParameter("price")));
        product.setImage(request.getParameter("image"));
        product.setTitle(request.getParameter("title"));
        product.setCategory(category);

        ProductDao pro = new ProductDao();
        pro.updateProduct(product);
        response.sendRedirect("load");
    }
}
