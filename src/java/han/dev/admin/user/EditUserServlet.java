/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package han.dev.admin.user;

import han.dev.admin.BaseAdminServlet;
import han.dev.data.dao.DatabaseDao;
import han.dev.data.dao.UserDao;
import han.dev.data.model.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 *
 * @author Asus
 */
public class EditUserServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(userId);

            request.setAttribute("user", user);
            request.getRequestDispatcher("admin/user/edit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
         UserDao userDao = DatabaseDao.getInstance().getUserDao();
         User user = userDao.find(userId);
        
         String email = request.getParameter("email");
         String password = request.getParameter("password");
        user.setEmail(email);
        user.setPassword(password);
        
        userDao.update(user);
        response.sendRedirect("IndexUserServlet");
    }

}
