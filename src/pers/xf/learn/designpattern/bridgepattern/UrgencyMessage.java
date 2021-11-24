package pers.xf.learn.designpattern.bridgepattern;

public class UrgencyMessage extends AbstractMessage{
    public UrgencyMessage(IMessage message) {
        super(message);
    }

    @Override
    public void sendMessage(String message, String toUser) {
        message = "[URGENCY]"+message;
        super.sendMessage(message, toUser);
    }

    public Object watch(String messageId){
        // As an example:
        // watch the urgency message
        return null;
    }
}
