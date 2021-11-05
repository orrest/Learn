package pers.xf.learn.jlang.multithread.lambda;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VariableScope extends JFrame{

    public void repeatMessage(String text, int delay){
        ActionListener listener = e -> {
            System.out.println(this);
        };
        new Timer(delay, listener).start();
    }

    public static void main(String[] args) {
        VariableScope v = new VariableScope();
        while (true)
            v.repeatMessage("Hello", 1000);
    }
}
