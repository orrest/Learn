package pers.xf.learn.designpattern.proxy;

/**
 * Data Access Object.
 * 理论上应操作数据库
 */
public class OrderDAO {
    public int insert(Order order){
        System.out.println("[OrderDAO]\t create Order successfully!");
        return 1;
    }
}
