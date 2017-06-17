package Stacks;

public interface Stack<E> {
	public void push(E e);
	
	public E pop();
	
	public E peek();
	
	public int size();
	
	public boolean isEmpity();
}
