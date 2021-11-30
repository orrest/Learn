package pers.xf.learn.designpattern.commandpattern;

public class GPlayer {
    public void play(){
        System.out.println("Playing");
    }

    public void speed(){
        System.out.println("Speed * 1.5");
    }

    public void stop(){
        System.out.println("Stop");
    }

    public void pause(){
        System.out.println("Pause");
    }
}
