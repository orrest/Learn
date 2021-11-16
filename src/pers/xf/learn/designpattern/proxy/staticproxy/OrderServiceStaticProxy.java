package pers.xf.learn.designpattern.proxy.staticproxy;

import pers.xf.learn.designpattern.proxy.IOrderService;
import pers.xf.learn.designpattern.proxy.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

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
