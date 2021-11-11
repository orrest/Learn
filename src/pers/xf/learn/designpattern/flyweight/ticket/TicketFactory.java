package pers.xf.learn.designpattern.flyweight.ticket;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class TicketFactory {
    private static final Map<String, ITicket> ticketPool = new ConcurrentHashMap<>();

    public static ITicket queryTicket(String from, String to){
        String key = from + "->" + to;
        if (TicketFactory.ticketPool.containsKey(key)){
            System.out.println("使用缓存: " + key);
            return TicketFactory.ticketPool.get(key);
        } else {
            System.out.println("首次查询,创建对象: " + key);
            ITicket ticket = new TrainTicket(from, to);
            TicketFactory.ticketPool.put(key, ticket);
            return ticket;
        }
    }

    private static class TrainTicket implements ITicket {
        private final String from;
        private final String to;
        private int price;

        public TrainTicket(String from, String to){
            this.from = from;
            this.to = to;
        }

        @Override
        public void showInfo(String bunk) {
            this.price = new Random().nextInt(500);
            System.out.printf(
                    "%s->%s: %s 价格: %s 元%n",
                    this.from,
                    this.to,
                    bunk,
                    this.price
            );
        }
    }
}
