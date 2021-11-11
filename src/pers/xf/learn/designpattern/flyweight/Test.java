package pers.xf.learn.designpattern.flyweight;

import pers.xf.learn.designpattern.flyweight.ticket.ITicket;
import pers.xf.learn.designpattern.flyweight.ticket.TicketFactory;

/**
 * 一个简陋的例子
 */
public class Test {
    public static void main(String[] args) {
        ITicket ticket = TicketFactory.queryTicket("北京南", "天津南");
        ticket.showInfo("硬座");

        ticket = TicketFactory.queryTicket("北京南", "天津南");
        ticket.showInfo("硬座");

        ticket = TicketFactory.queryTicket("北京南", "天津南");
        ticket.showInfo("硬座");

        ticket = TicketFactory.queryTicket("北京南", "天津南");
        ticket.showInfo("硬座");

        ticket = TicketFactory.queryTicket("北京南", "天津南");
        ticket.showInfo("硬座");
    }
}
