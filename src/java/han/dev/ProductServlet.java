package han.dev;

import han.dev.data.dao.ProductDao;
import han.dev.data.dao.DatabaseDao;
import han.dev.data.model.Product;
import han.dev.util.Constants;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class ProductServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        Product product = productDao.find(productId);
        List<Product> newsProductList = productDao.news(Constants.NUMBER_LIMIT);

        request.setAttribute("newsProductList", newsProductList);
        request.setAttribute("product", product);
        request.getRequestDispatcher("product.jsp").include(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Implement or remove this method if not needed
    }
}
