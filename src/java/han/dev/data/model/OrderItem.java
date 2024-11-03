package han.dev.data.model;

import han.dev.data.dao.DatabaseDao;
import java.sql.Timestamp;

public class OrderItem {

    public int id;
    public int orderId;
    public int productId;
    public double price;
    public int quantity;
    public Timestamp created_at;

    public OrderItem(int quantity, double price, int orderId, int productId) {
        this.quantity = quantity;
        this.price = price;
        this.orderId = orderId;
        this.productId = productId;
    }

    public OrderItem(int id, int quantity, double price, int orderId, int productId) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.orderId = orderId;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return DatabaseDao.getInstance().getProductDao().find(this.productId);
    }

    public Order getOrder() {
        return DatabaseDao.getInstance().getOrderDao().find(this.orderId);
    }
    
    
}
