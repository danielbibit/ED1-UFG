package Stacks;

import Lists.List;
import Lists.SingleLinkedList;

public class ListStack<E> implements Stack<E> {
	List<E> list = new SingleLinkedList();
	
	@Override
	public void push(E e) {
		list.add(e);
	}

	@Override
	public E pop() {
		return list.pop();
	}

	@Override
	public E peek() {
		return list.get(list.size()-1);
	}

	@Override
	public boolean isEmpity() {
		return list.size()==0;
	}
	
	@Override
	public int size() {
		return list.size();
	}
	
}
