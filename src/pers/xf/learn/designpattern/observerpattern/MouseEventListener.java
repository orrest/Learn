package pers.xf.learn.designpattern.observerpattern;

public class MouseEventListener implements EventListener{
    public void onClick(Event e){
        System.out.println("---Listened the event: onClick---");
        System.out.println("Do something a Listener will do.");
    }

    public void onDoubleClick(Event e){
        System.out.println("---Listened the event: onDoubleClick---");
        System.out.println("Do something a Listener will do.");
    }
}

