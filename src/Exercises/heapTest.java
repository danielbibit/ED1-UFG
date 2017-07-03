package Exercises;

import Heap.GenericMaxHeap;
import Heap.MinHeap;

public class heapTest {
	public static void main(String[] args){
		GenericMaxHeap<Integer> heap = new GenericMaxHeap();
		
		heap.insert(40);
		System.out.println(heap.toString());
		heap.insert(20);
		System.out.println(heap.toString());
		heap.insert(60);
		System.out.println(heap.toString());
		heap.insert(80);
		System.out.println(heap.toString());
		heap.insert(10);
		System.out.println(heap.toString());
		heap.insert(30);
		heap.insert(90);
		heap.insert(70);
		heap.insert(50);
		System.out.println(heap.toString());
        //heap.remove();
        System.out.println(heap.remove());
        System.out.println(heap.toString());
        System.out.println();
        //heap.printTree();
	}
}
