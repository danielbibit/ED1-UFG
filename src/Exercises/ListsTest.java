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
		
		for(int i = 0; i < 100; i++){
			intList.add(i);
			doubleList.add(i);
			intArray.add(i);
		}
		
		System.out.println(intList.toString());
		System.out.println(doubleList.toString());
		System.out.println(intArray.toString());
		
		intList.remove(5);
		doubleList.remove(5);
		intArray.remove(5);
		
		System.out.println(intList.toString());
		System.out.println(doubleList.toString());
		System.out.println(intArray.toString());
		
	}
	
}
