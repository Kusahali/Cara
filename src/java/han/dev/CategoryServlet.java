/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package han.dev;

import han.dev.data.dao.CategoryDao;
import han.dev.data.dao.DatabaseDao;
import han.dev.data.dao.ProductDao;
import han.dev.data.model.Category;
import han.dev.data.model.Product;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class CategoryServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        
        String categoryIdParam = request.getParameter("categoryId");
int categoryId = 0; // Khởi tạo với giá trị mặc định
if (categoryIdParam != null && !categoryIdParam.isEmpty()) {
    try {
        categoryId = Integer.parseInt(categoryIdParam);
    } catch (NumberFormatException e) {
        // Xử lý lỗi nếu không thể chuyển đổi
        System.out.println("Invalid categoryId: " + categoryIdParam);
        // Bạn có thể đặt categoryId về một giá trị mặc định hoặc thông báo lỗi
    }
}

ProductDao productDao = DatabaseDao.getInstance().getProductDao();
List<Product> productList = new ArrayList<>();

if (request.getParameter("property") != null && request.getParameter("order") != null) {
    String property = request.getParameter("property");
    String order = request.getParameter("order");
    // Xử lý logic với property và order ở đây
} else {
    productList = productDao.findByCategory(categoryId);
}

CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
Category category = categoryDao.find(categoryId);

request.setAttribute("productList", productList);
request.setAttribute("category", category);

request.getRequestDispatcher("category.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
