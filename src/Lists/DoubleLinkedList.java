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
		Node<E> currentNode = this.firstNode;
		
		for(int i=0; i < index; i++){
			currentNode = currentNode.next;
		}
		
		currentNode.previous.next = newNode;
		newNode.next = currentNode.next;
		
		this.size += 1;
		
	}

	@Override
	public E remove(int index) {
		Node<E> currentNode = this.firstNode;
		
		for(int i = 0; i < index; i++){
			currentNode = currentNode.next;
		}
		
		currentNode.previous.next = currentNode.next;
		currentNode.next.previous = currentNode.previous;
		
		this.size -= 1;
		
		return currentNode.element;
	}

	@Override
	public E pop() {
		return this.remove(this.size-1);
	}

	@Override
	public E get(int index) {
		Node<E> currentNode = this.firstNode;
		
		for(int i = 0; i < index; i++){
			currentNode = currentNode.next;
		}
		
		return currentNode.element;
	}

	@Override
	public void set(int index, E e) {
		Node<E> currentNode = this.firstNode;
		
		for(int i = 0; i < index; i++){
			currentNode = currentNode.next;
		}
		
		currentNode.element = e;
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
