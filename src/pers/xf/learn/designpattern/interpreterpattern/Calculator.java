package pers.xf.learn.designpattern.interpreterpattern;

import java.util.LinkedList;

/**
 * Only support +
 */
public class Calculator {
    private final LinkedList<IArithmeticInterpreter> stack = new LinkedList<>();

    public Calculator(String expression) {
        parse(expression);
    }

    public int calculate(){
        return this.stack.pop().interpret();
    }

    private void parse(String ex){
        String[] elements = ex.split(" ");
        IArithmeticInterpreter left, right;

        for (int i = 0; i < elements.length; i++){
            String operator = elements[i];
            if (operator.equals("+")){
                System.out.println("Meet an operator +.");

                left = stack.pop();
                right = new NumInterpreter(Integer.parseInt(elements[++i]));
                System.out.println("Poll a num from stack: " + left.interpret());

                stack.push(new AddInterpreter(left, right));
                System.out.println("Add to: " + right.interpret());
            } else {
                stack.push(new NumInterpreter(Integer.parseInt(elements[i])));
                System.out.println("Put a num to stack: " + Integer.parseInt(elements[i]));
            }
        }
    }
}
