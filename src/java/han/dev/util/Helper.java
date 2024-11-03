/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package han.dev.util;

import han.dev.data.model.OrderItem;
import jakarta.servlet.http.HttpServlet;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Helper extends HttpServlet {
    public static double total(List<OrderItem> orderItemList) {
        double total = 0;
        for (int i = 0; i < orderItemList.size(); i++) {
            OrderItem ord = orderItemList.get(0);
            total += ord.getPrice() * ord.getQuantity();
    }
    return total;
}
}