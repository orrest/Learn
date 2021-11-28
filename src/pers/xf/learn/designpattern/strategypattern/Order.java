package pers.xf.learn.designpattern.strategypattern;

public class Order {
    private final String uid;
    private final String orderId;
    private final double amount;

    public Order(String uid, String orderId, double amount){
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    /**
     * DEFAULT pay
     * @return pay(PayStrategy.DEFAULT_PAY)
     */
    public MsgResult pay(){
        System.out.println("默认策略");
        return pay(PayStrategy.DEFAULT_PAY);
    }

    public MsgResult pay(String payKey){
        Payment payment = PayStrategy.get(payKey);
        System.out.println("使用"+payment.getName());
        System.out.println("交易金额: " + this.amount);
        return payment.pay(uid, amount);
    }
}
