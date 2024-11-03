/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package han.dev;

import han.dev.data.dao.DatabaseDao;
import han.dev.data.dao.OrderDao;
import han.dev.data.dao.OrderItemDao;
import han.dev.data.model.Order;
import han.dev.data.model.OrderItem;
import han.dev.data.model.User;
import han.dev.util.StringHelper;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CheckoutServlet extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("LoginServlet");
        } else {
            proccessCheckout(request, user);
            response.sendRedirect("CartServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void proccessCheckout(HttpServletRequest request, User user) {
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        String code = StringHelper.randomString(10);
        Order order = new Order(code, "pending", user.getId());
        orderDao.insert(order);

        order = orderDao.findByCode(code);
        HttpSession session = request.getSession();
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");

        OrderItemDao orderItemDao = DatabaseDao.getInstance().getOrderItemDao();

        if (cart != null && order != null) { // Kiểm tra order không null
    for (OrderItem orderItem : cart) {
        orderItem.setOrderId(order.getId());
        orderItemDao.insert(orderItem);
    }
} else {
    // Xử lý trường hợp order hoặc cart null nếu cần thiết
    if (order == null) {
        System.out.println("Order is null");
    }
    if (cart == null) {
        System.out.println("Cart is null");
    }
}


        session.setAttribute("message", "Checkout Success");
        session.removeAttribute("cart");
    }
}

