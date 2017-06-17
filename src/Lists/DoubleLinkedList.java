package Lists;

public class DoubleLinkedList<E> implements List<E> {
	private Node<E> firstNode;
	private Node<E> lastNode;
	private int size = 0;
	
	@Override
	public void add(E e) {
		Node<E> newNode = new Node();
		newNode.element = e;
		
		if(this.size == 0){
			firstNode = newNode;
		}else{
			lastNode.next = newNode;
			newNode.previous = lastNode;
		}
		lastNode = newNode;
		
		this.size += 1;
	}

	@Override
	public void add(int index, E e) {
		Node<E> newNode = new Node();
		newNode.element = e;

	}

	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public E pop() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public E get(int index) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void set(int index, E e) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("[");
		
		Node<E> currentNode = this.firstNode;
		
		while(currentNode != null){
			string.append(currentNode.element.toString());
			string.append(",");
			
			currentNode = currentNode.next;
		}
		
		string.append("]");
		
		return string.toString();
	}
	
}
