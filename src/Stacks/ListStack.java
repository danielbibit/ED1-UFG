package Stacks;

import Lists.List;
import Lists.SingleLinkedList;

public class ListStack<E> implements Stack<E> {
	List<E> list = new SingleLinkedList();
	
	@Override
	public void push(E e) {
		this.list.add(e);
	}

	@Override
	public E pop() {
		return this.list.pop();
	}

	@Override
	public E peek() {
		return this.list.get(this.list.size()-1);
	}

	@Override
	public boolean isEmpity() {
		return this.list.size()==0;
	}
	
	@Override
	public int size() {
		return this.list.size();
	}	
}
