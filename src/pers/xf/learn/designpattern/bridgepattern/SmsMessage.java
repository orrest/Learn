package pers.xf.learn.designpattern.bridgepattern;

public class SmsMessage implements IMessage{
    private String what;
    private String to;
    public SmsMessage(String what, String to){
        this.what = what;
        this.to = to;
    }

    @Override
    public void setFlag(String flag) {
        // just sms
    }

    @Override
    public void send() {
        System.out.println("[SMS]Send: " + this.what + " , to: " + this.to);
    }
}
