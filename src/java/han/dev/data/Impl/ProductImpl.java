package han.dev.data.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import han.dev.data.dao.ProductDao;
import han.dev.data.driver.MySQLDriver;
import han.dev.data.model.Product;
import han.dev.util.Constants;

public class ProductImpl implements ProductDao {

    Connection conn = MySQLDriver.getInstance().getConnection();

    @Override
    public boolean insert(Product product) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO PRODUCTS(ID, NAME, DESCRIPTION, THUMBNAIL, PRICE, QUANTITY, CATEGORY_ID) VALUES(NULL, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, product.name);
            stmt.setString(2, product.description);
            stmt.setString(3, product.thumbnail);
            stmt.setDouble(4, product.price);
            stmt.setInt(5, product.quantity);
            stmt.setInt(6, product.categoryId);

            stmt.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        // TODO Auto-generated method stub
        String sql = "UPDATE PRODUCTS SET name = ?, description = ?, thumbnail=?, price = ?, quantity = ?, category_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.name);
            stmt.setString(2, product.description);
            stmt.setString(3, product.thumbnail);
            stmt.setDouble(4, product.price);
            stmt.setInt(5, product.quantity);
            stmt.setInt(6, product.categoryId);
            stmt.setInt(7, product.id);

            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub

        String sql = "DELETE FROM PRODUCTS WHERE ID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product find(int id) {
        String sql = "SELECT * FROM PRODUCTS WHERE ID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Retrieve product details from the result set
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String thumbnail = rs.getString("thumbnail");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    int view = rs.getInt("view");
                    int categoryId = rs.getInt("category_id");
                    Timestamp createdAt = rs.getTimestamp("created_at");

                    // Create and return a Product object
                    return new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logger instead
        }
        return null; // Return null if no product is found or if an exception occurs
    }

    @Override
    public List<Product> findByCategory(int categoryId) {
        // TODO Auto-generated method stub
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE category_id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> hot(int limit) {
        // TODO Auto-generated method stub
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS ORDER BY VIEW DESC LIMIT ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, limit);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> news(int limit) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS ORDER BY VIEW DESC LIMIT ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, limit);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> findByName(String key) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE NAME LIKE ? ORDER BY VIEW DESC ";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + key + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> findByCategoryName(int categoryId, String key) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY_ID = ? AND NAME LIKE ? ORDER BY VIEW DESC";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            stmt.setString(2, "%" + key + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> relatedProductList(Product product) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY_ID = ? LIMIT ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, product.getCategoryId());
            stmt.setInt(2, Constants.RELATED_NUMBER);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public boolean updateView(Product product) {
        String sql = "UPDATE PRODUCTS SET view = ? WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, product.getView() + 1);
            stmt.setInt(2, product.getId());

            return stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> filter(int categoryId, String propertyName, String order) {
        List<Product> proList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS WHERE category_id = ? ORDER BY ? ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            stmt.setString(2, propertyName);
            stmt.setString(3, order);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                Timestamp createdAt = rs.getTimestamp("created_at");

                proList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proList;
    }

    @Override
    public List<Product> getProducts(int from, int amount) {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS LIMIT ?, ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, from);
            stmt.setInt(2, amount);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String thumbnail = rs.getString("thumbnail");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int view = rs.getInt("view");
                int categoryId = rs.getInt("category_id");
                Timestamp createdAt = rs.getTimestamp("created_at");
                productList.add(new Product(id, name, description, thumbnail, price, quantity, view, categoryId, createdAt));

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
