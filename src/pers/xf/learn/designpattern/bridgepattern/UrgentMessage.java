package pers.xf.learn.designpattern.bridgepattern;

public class UrgentMessage extends AbstractMessage{
    public UrgentMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage() {
        this.message.setFlag("[URGENT]");
        super.sendMessage();
    }

    public Object watch(String messageId){
        // As an example:
        // watch the urgency message
        return null;
    }
}
