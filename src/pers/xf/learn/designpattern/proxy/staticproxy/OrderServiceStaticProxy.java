package pers.xf.learn.designpattern.proxy.staticproxy;

import pers.xf.learn.designpattern.proxy.DynamicDataSourceEntry;
import pers.xf.learn.designpattern.proxy.IOrderService;
import pers.xf.learn.designpattern.proxy.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将OrderService包裹起来，createOrder前进行数据源处理，
 * 对于OrderService来说是多了一层；
 * 而对于使用来说，
 * 只不过是由调用      OrderService.createOrder，
 * 变成调用           OrderServiceStaticProxy.createOrder。
 */
public class OrderServiceStaticProxy implements IOrderService {
    private final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private final IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before(order);
        orderService.createOrder(order);
        return after();
    }

    /**
     * 根据订单时间动态切换数据源
     * @param order
     */
    private void before(Order order){
        Long time = order.getCreateTime();
        int dbRouter = Integer.parseInt(yearFormat.format(new Date(time)));
        System.out.println("静态代理分配到【DB_"+dbRouter+"】数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
        System.out.println("----Proxy before method.----");
    }

    private int after(){
        System.out.println("----Proxy after method.----");
        return 0;
    }
}
