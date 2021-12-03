package pers.xf.learn.designpattern.mediatorpattern;

public class User {
    private final String name;
    private final ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom){
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public void sendMessage(String msg){
        this.chatRoom.receive(this, msg);
    }

    public String getName(){
        return name;
    }
}
