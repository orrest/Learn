package pers.xf.learn.designpattern.bridgepattern;

public abstract class AbstractMessage {
    IMessage message;

    public AbstractMessage(IMessage message){
        this.message = message;
    }

    public void sendMessage(String message, String toUser){
        this.message.send(message, toUser);
    }
}
