package Exercises;

import Lists.ArrayList;
import Lists.DoubleLinkedList;
import Lists.List;
import Lists.SingleLinkedList;

public class ListsTest {
	public static void main(String[] args) {
		List<Integer> intList = new SingleLinkedList();
		List<Integer> doubleList = new DoubleLinkedList();
		List<Integer> intArray = new ArrayList(3);
		
		Integer a = 23;
		Integer b = 12;
		Integer c = 1997;
		
		intList.add(a);
		intList.add(b);
		intList.add(c);

		doubleList.add(a);
		doubleList.add(b);
		doubleList.add(c);
		
		
		intArray.add(a);
		intArray.add(b);
		intArray.add(c);
		
	//	System.out.println(doubleList.toString());
		
	//	System.out.println(intList.toString());
		
	//	intList.add(0, 9);
	//	System.out.println(intList.toString());
	//	intList.remove(3);
	//	System.out.println(intList.toString());
		
	}
	
}
