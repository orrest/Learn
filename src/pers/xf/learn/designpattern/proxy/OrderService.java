package pers.xf.learn.designpattern.proxy;

/**
 * Service负责进行具体的操作，然后交由DAO操作数据库。
 */
public class OrderService implements IOrderService{
    private OrderDAO orderDAO;

    public OrderService(){
        orderDAO = new OrderDAO();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("[OrderService]\t call orderDAO to create order!");
        return orderDAO.insert(order);
    }
}
