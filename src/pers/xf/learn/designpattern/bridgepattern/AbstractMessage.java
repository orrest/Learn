package pers.xf.learn.designpattern.bridgepattern;

public abstract class AbstractMessage {
    IMessage message;

    public AbstractMessage(IMessage message){
        this.message = message;
    }

    public void sendMessage(){
        this.message.send();
    }
}
