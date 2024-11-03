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
import java.util.List;


/**
 *
 * @author Asus
 */
public class IndexUserServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            UserDao userDao = DatabaseDao.getInstance().getUserDao();
            List<User> userList = userDao.findAll();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("admin/user/index.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }

}
