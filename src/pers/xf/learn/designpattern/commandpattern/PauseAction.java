package pers.xf.learn.designpattern.commandpattern;

public class PauseAction implements IAction {
    private GPlayer gPlayer;

    public PauseAction(GPlayer gPlayer) {
        this.gPlayer = gPlayer;
    }

    @Override
    public void execute() {
        this.gPlayer.pause();
    }
}
