/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package han.dev.admin.order;

import han.dev.admin.BaseAdminServlet;
import han.dev.data.dao.CategoryDao;
import han.dev.data.dao.DatabaseDao;
import han.dev.data.dao.OrderDao;
import han.dev.data.model.Category;
import han.dev.data.model.Order;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;


/**
 *
 * @author Asus
 */
public class IndexOrderServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
            List<Order> OrderList = orderDao.findAll();
            request.setAttribute("categoryList", OrderList);
            request.getRequestDispatcher("admin/order/index.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }

}