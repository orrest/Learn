package pers.xf.learn.designpattern.interpreterpattern;

public class NumInterpreter implements IArithmeticInterpreter {
    private int value;

    public NumInterpreter(int value){
        this.value = value;
    }

    public int interpret(){
        return this.value;
    }
}
