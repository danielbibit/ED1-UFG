package Stacks;

public class ArrayStack<E> implements Stack<E> {
	
	private Object array[];
	private int size = 0;
	
	public ArrayStack(int size){
		array = new Object[size];
	}
	
    public ArrayStack(){
		this(100);
	}
	
	private void ensureSpace(){
		if(this.array.length == this.size){
			Object newArray[] = new Object[this.array.length+100];
			
			System.arraycopy(this.array, 0, newArray, 0, this.size);
			
			array = newArray;
		}
	}
	
	@Override
	public void push(E e) {
		this.ensureSpace();
		
		array[size] = e;
		
		size += 1;	
	}

	@Override
	public E pop() {
		if(this.size  == 0){
			
		}
		
		this.size -= 1;
		return (E)array[size];
	}

	@Override
	public E peek() {
		if(this.size  == 0){
			
		}
		
		return (E)array[size-1];
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpity() {
		return (this.size == 0);
	}
	
	@Override
	public String toString(){
		StringBuilder string = new StringBuilder("[");
		
		for(int i = 0; i<this.size; i++){
			string.append(array[i].toString());
			string.append(",");
		}
		
		string.append("]");
		
		return string.toString();
	}
}
