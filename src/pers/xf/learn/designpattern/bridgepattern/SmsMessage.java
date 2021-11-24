package pers.xf.learn.designpattern.bridgepattern;

public class SmsMessage implements IMessage{
    @Override
    public void send(String message, String toUser) {
        System.out.println("[SMS]Send: " + message + " , to: " + toUser);
    }
}
