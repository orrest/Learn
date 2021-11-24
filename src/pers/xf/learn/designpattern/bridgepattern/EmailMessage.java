package pers.xf.learn.designpattern.bridgepattern;

public class EmailMessage implements IMessage{
    private String what;
    private String to;
    public EmailMessage(String what, String to){
        this.what = what;
        this.to = to;
    }

    @Override
    public void send() {
        System.out.println("[SMS]Send: " + this.what + " , to: " + this.to);
    }

    @Override
    public void setFlag(String flag) {
        this.what = flag+this.what;
    }
}
