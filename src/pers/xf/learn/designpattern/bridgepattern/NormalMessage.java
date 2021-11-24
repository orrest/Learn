package pers.xf.learn.designpattern.bridgepattern;

public class NormalMessage extends AbstractMessage{
    public NormalMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        super.sendMessage(message, toUser);
    }
}
