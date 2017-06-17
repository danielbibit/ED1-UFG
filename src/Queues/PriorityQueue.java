package Queues;
import Heap.MaxHeap;

public class PriorityQueue{
    private MaxHeap heap = new MaxHeap();
    
    public boolean enqueue(int i) {
        this.heap.insert(i);
        
        return true;
    }

    public int dequeue() {
        return this.heap.remove();
    }

    public int element() {
        return this.heap.peek();
    }

    public int size() {
        return this.heap.size();
    }

    public boolean isEmpity() {
        return this.size() == 0;
    }
	
    @Override
    public String toString(){
        return this.heap.toString();
    }
}
    