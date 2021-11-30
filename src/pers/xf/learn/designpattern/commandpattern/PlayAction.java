package pers.xf.learn.designpattern.commandpattern;

public class PlayAction implements IAction{
    private GPlayer gPlayer;

    public PlayAction(GPlayer gPlayer) {
        this.gPlayer = gPlayer;
    }

    @Override
    public void execute() {
        gPlayer.play();
    }
}
