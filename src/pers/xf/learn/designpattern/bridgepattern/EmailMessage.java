package pers.xf.learn.designpattern.bridgepattern;

public class EmailMessage implements IMessage{
    @Override
    public void send(String message, String toUser) {
        System.out.println("[EMAIL]Send: " + message + " , to: " + toUser);
    }
}
