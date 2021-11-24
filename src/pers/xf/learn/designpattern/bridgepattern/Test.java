package pers.xf.learn.designpattern.bridgepattern;

public class Test {
    public static void main(String[] args) {
        IMessage message = new SmsMessage();
        AbstractMessage abstractMessage = new NormalMessage(message);
        abstractMessage.sendMessage("Fire in the hole!!!!", "team member");

        message = new EmailMessage();
        abstractMessage = new UrgencyMessage(message);
        abstractMessage.sendMessage("Fire in the hole!!!!", "team member");
    }
}
