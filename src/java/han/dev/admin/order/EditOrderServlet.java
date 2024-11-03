/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package han.dev.admin.category;

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


/**
 *
 * @author Asus
 */
public class EditOrderServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        Order order = orderDao.find(orderId);

            request.setAttribute("order", order);
            request.getRequestDispatcher("admin/order/edit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int orderId = Integer.parseInt(request.getParameter("orderId"));
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        Order order = orderDao.find(orderId);
        
         String status = request.getParameter("status");
        order.setStatus(status);

        orderDao.update(order);
        response.sendRedirect("IndexOrderServlet");
    }

}
