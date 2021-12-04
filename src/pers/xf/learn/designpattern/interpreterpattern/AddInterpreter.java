package pers.xf.learn.designpattern.interpreterpattern;

public class AddInterpreter extends Interpreter {
    public AddInterpreter(IArithmeticInterpreter left, IArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return this.left.interpret() + this.right.interpret();
    }
}
