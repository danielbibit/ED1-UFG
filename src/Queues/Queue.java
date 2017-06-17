package Queues;

public interface Queue <E> {
	public boolean enqueue(E e);
	
	public E dequeue();
	
	public E element();
	
	public int size();
	
	public boolean isEmpity();
	
}