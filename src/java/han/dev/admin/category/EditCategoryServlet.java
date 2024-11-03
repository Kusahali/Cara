/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package han.dev.admin.category;

import han.dev.admin.BaseAdminServlet;
import han.dev.data.dao.CategoryDao;
import han.dev.data.dao.DatabaseDao;
import han.dev.data.model.Category;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 *
 * @author Asus
 */
public class EditCategoryServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        Category category = categoryDao.find(categoryId);

            request.setAttribute("category", category);
            request.getRequestDispatcher("admin/category/edit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int categoryId = Integer.parseInt(request.getParameter("categoryId"));
         
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        Category category = categoryDao.find(categoryId);
        
         String name = request.getParameter("name");
         String thumbnail = request.getParameter("thumbnail");
        category.setName(name);
        category.setThumbnail(thumbnail);
        
        categoryDao.update(category);
        response.sendRedirect("IndexCategoryServlet");
    }

}
