package pers.xf.learn.designpattern.bridgepattern;

public class NormalMessage extends AbstractMessage{
    public NormalMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage() {
        super.sendMessage();
    }
}
