package pers.xf.learn.designpattern.observerpattern;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class EventContext {
    protected Map<String, Event> events = new HashMap<>();

    /**
     * 在addListener中, 解析eventType, 然后通过反射获取到listener中的方法, 创建Event对象.
     * put到事件队列中。
     * 当事件发生的时候, trigger这个事件(从事件队列中获取）.
     */
    public void addListener(String eventType, EventListener target, Method callback){
        events.put(eventType, new Event(target, callback));
    }

    public void addListener(String eventType, EventListener target){
        try {
            this.addListener(eventType, target,
                    target.getClass().getMethod("on"+toUpperFirstCase(eventType), Event.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private String toUpperFirstCase(String eventType){
        char[] chars = eventType.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    private void trigger(Event event){
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        try {
            event.getCallback().invoke(event.getTarget(), event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void trigger(String trigger){
        if (!this.events.containsKey(trigger))
            return;

        trigger(this.events.get(trigger).setName(trigger));
    }
}
