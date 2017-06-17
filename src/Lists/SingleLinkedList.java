package Lists;

public class SingleLinkedList <E> implements List<E>  {
	private Node<E> firstNode;
	private Node<E> lastNode;
	private int size;
	
	@Override
	public void add(E e) {
		Node<E> newNode = new Node();
		newNode.element = e;
		
		if(firstNode==null){
			firstNode = newNode;
		}else{
			lastNode.next = newNode;
		}
		
		lastNode = newNode;
		
		this.size += 1;
	}

	@Override
	public void add(int index, E e) {
		if(index < 0 || index > this.size-1)
			throw new IndexOutOfBoundsException();
		
		Node<E> currentNode = this.firstNode;
		
		Node<E> newNode = new Node();
		newNode.element =  e;
		
		if(index == 0){
			newNode.next = this.firstNode;
			this.firstNode = newNode;
		}else{
			for(int i=0; i<index-1; i++){
				currentNode = currentNode.next;
			}
			
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
		
		this.size += 1;
	}	
			
	@Override
	public E remove(int index) {
		if(index < 0 || index > this.size-1)
			throw new IndexOutOfBoundsException();
		
		Node<E> tempNode;
		Node<E> currentNode = this.firstNode;
		
		this.size -= 1;
		
		if(index == 0){
			tempNode = this.firstNode;
			this.firstNode = firstNode.next;
			
			return tempNode.element;
		}else{
			for(int i=0; i<index-1; i++){
				currentNode = currentNode.next;
			}
			
			tempNode = currentNode.next;
			currentNode.next = currentNode.next.next;
			
			return tempNode.element;	
		}
	}
	
	@Override
	public E pop() {
		return this.remove(size-1);
	}

	@Override
	public E get(int index) {
		if(index < 0 || index > this.size-1)
			throw new IndexOutOfBoundsException();
		
		Node<E> currentNode = this.firstNode;
		
		for(int i=0; i<index; i++){
			currentNode = currentNode.next;
		}
		
		return currentNode.element;
	}

	@Override
	public void set(int index, E e) {
		if(index < 0 || index > this.size-1)
			throw new IndexOutOfBoundsException();
		
		Node<E> currentNode = this.firstNode;
		
		for(int i=0; i<index; i++){
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
		Node<E> currentNode = firstNode;
		
		while(currentNode != null){
			string.append(currentNode.element.toString());
			string.append(',');
			
			currentNode = currentNode.next;
		}
		
		string.append("]");
		
		return string.toString();
	}
	
}
