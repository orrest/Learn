package pers.xf.learn.designpattern.observerpattern;

import java.lang.reflect.Method;

public class Event {
    private Object source;
    private EventListener target;
    private Method callback;
    private String name;
    private long time;

    public Event(EventListener target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource(){
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public Event setName(String name) {
        this.name = name;
        return this;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public EventListener getTarget() {
        return target;
    }

    public Method getCallback() {
        return callback;
    }
}
