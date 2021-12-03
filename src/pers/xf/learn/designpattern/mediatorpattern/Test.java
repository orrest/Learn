package pers.xf.learn.designpattern.mediatorpattern;

public class Test {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();

        User tom = new User("Tom", room);
        User jerry = new User("Jerry", room);

        // while(true)... 一个while循环监听接入, 然后接入的user不断send,
        //      send的信息被加入ChatRoom的消息队列和用户队列,
        //      然后不断刷新, 同步消息.
        tom.sendMessage("Hi! Iam Tom.");
        jerry.sendMessage("Hello, my name is Jerry");

        while (!room.isEmpty()) {
            room.flush();
        }
    }
}
