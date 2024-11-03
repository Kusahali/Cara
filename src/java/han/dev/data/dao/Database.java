package han.dev.data.dao;

import han.dev.data.Impl.CategoryImpl;
import han.dev.data.Impl.OrderImpl;
import han.dev.data.Impl.OrderItemImpl;
import han.dev.data.Impl.ProductImpl;
import han.dev.data.Impl.UserImpl;

public class Database extends DatabaseDao {
	@Override
    public ProductDao getProductDao() {
        // TODO Auto-generated method stub
        return new ProductImpl();
    }

    @Override
    public CategoryDao getCategoryDao() {
        // TODO Auto-generated method stub
        return new CategoryImpl();
    }

    @Override
    public OrderItemDao getOrderItemDao() {
        // TODO Auto-generated method stub
        return new OrderItemImpl();
    }

    @Override
    public OrderDao getOrderDao() {
        // TODO Auto-generated method stub
        return new OrderImpl();
    }

    @Override
    public UserDao getUserDao() {
        // TODO Auto-generated method stub
        return new UserImpl();
    }
}
