package Exercises;

import Stacks.ArrayStack;
import Stacks.Stack;

public class PosFixCalculator {
    private Stack<String> stack = new ArrayStack();
    
    public double solve(String string){
        String[] elements = string.split(" ");
        
        double temp;
        
        for(String e : elements){
            switch(e){
                case "+":
                    temp = Double.valueOf(stack.pop()) + Double.valueOf(stack.pop());
                    stack.push(String.valueOf(temp));
                    break;
                case "-":
                    temp = Double.valueOf(stack.pop()) - Double.valueOf(stack.pop());
                    stack.push(String.valueOf(temp));
                    break;
                case "*":
                    temp = Double.valueOf(stack.pop()) * Double.valueOf(stack.pop());
                    stack.push(String.valueOf(temp));
                    break;
                case "/":
                    temp = Double.valueOf(stack.pop()) / Double.valueOf(stack.pop());
                    stack.push(String.valueOf(temp));
                    break;
                default:
                    stack.push(e);
            }
        }
        
        return Double.valueOf(stack.peek());
    }
}
