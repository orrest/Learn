package pers.xf.learn.designpattern.commandpattern;

public class Test {
    public static void main(String[] args) {
        GPlayer player = new GPlayer();

        // execute
        Controller controller = new Controller();
        controller.execute(new PlayAction(player));

        // executeAll
        controller.addAction(new PauseAction(player));
        controller.executeAll();
    }
}
