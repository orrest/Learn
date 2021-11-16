package pers.xf.learn.designpattern.proxy.staticproxy;

import pers.xf.learn.designpattern.proxy.IOrderService;
import pers.xf.learn.designpattern.proxy.Order;
import pers.xf.learn.designpattern.proxy.OrderService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        try {
            Order order = new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2017/02/01");
            order.setCreateTime(date.getTime());

            IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
            orderService.createOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
