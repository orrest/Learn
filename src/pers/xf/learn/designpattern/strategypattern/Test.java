package pers.xf.learn.designpattern.strategypattern;

public class Test {
    public static void main(String[] args) {
        Order order = new Order("1", "2021年11月27日-1", 3.5);
        System.out.println(order.pay(PayStrategy.ALI_PAY));

        order = new Order("1", "2021年11月27日-2", 5.0);
        System.out.println(order.pay(PayStrategy.WECHAT_PAY));

        order = new Order("1", "2021年11月27日-3", 15.5);
        System.out.println(order.pay());
    }
}
