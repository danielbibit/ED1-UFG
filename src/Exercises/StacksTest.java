package Exercises;

import Lists.SingleLinkedList;
import Stacks.ListStack;
import Stacks.Stack;

public class StacksTest {
	public static void main(String[] args) {
		SingleLinkedList<Stack> stackList = new SingleLinkedList();
		
//		Stack<Integer> stack = new ArrayStack(10);
		
		String string = "(1+((5+4))-2))";
		
		System.out.println(string.charAt(0));
		
		for(int i = 0; i < string.length(); i++){
			char current = string.charAt(i);
			System.out.println(current);
			
			if(current == '('){
				stackList.add(new ListStack());
				
			}else if(current == ')'){
				
				
			}else if(current == '+'){
				
			}else{
				
			}
		}

//        PosFixCalculator calculator = new PosFixCalculator();
        
//        System.out.println(calculator.solve("2 2 + 3 *"));
	}
}
