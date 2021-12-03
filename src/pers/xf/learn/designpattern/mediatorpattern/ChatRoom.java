package pers.xf.learn.designpattern.mediatorpattern;

import java.util.LinkedList;
import java.util.Queue;

public class ChatRoom {
    private final Queue<String> messageQueue = new LinkedList<>();
    private final Queue<User> userQueue = new LinkedList<>();

    public void receive(User user, String msg) {
        this.userQueue.offer(user);
        this.messageQueue.offer(msg);
    }

    public void flush(){
        User user = this.userQueue.poll();
        String msg = this.messageQueue.poll();
        System.out.println("["+user.getName()+"]: "+msg);
    }

    public boolean isEmpty(){
        return messageQueue.isEmpty();
    }
}
