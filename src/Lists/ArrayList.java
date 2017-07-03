package Lists;

public class ArrayList<E> implements List<E>{
	private Object array[];
	private int size = 0;
	
	public ArrayList(){
		this(100);
	}
	
	public ArrayList(int size){
		this.array = new Object[size];
	}
	
	private void ensureSpace(){
		if(this.size == this.array.length - 1){
			Object newArray[] = new Object[this.size+100];
			
            System.arraycopy(this.array, 0, newArray, 0, this.size);
			
			this.array = newArray;
		}
	}
        
	@Override
	public void add(E e) {
		this.ensureSpace();
		
		this.array[size] = e;
		this.size += 1;
	}

	@Override
	public void add(int index, E e) {
		this.ensureSpace();
		
		for(int i = this.size; i >= index; i--){
			this.array[i] = this.array[i-1];
		}
		
		this.array[index] = e;
		
		this.size += 1;
	}

	@Override
	public E remove(int index) {
		E temp = (E)array[index];
		
		for(int i = index; i < this.size; i++){
			this.array[i] = this.array[i + 1];
		}
		
		this.size -= 1;
		
		return temp;
	}

	@Override
	public E pop() {
		return this.remove(this.size - 1);
	}

	@Override
	public E get(int index) {
		return (E) this.array[index];
	}

	@Override
	public void set(int index, E e) {
		this.array[index] = e;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder("[");
		
		for(int i = 0; i < this.size; i++){
			string.append(this.array[i].toString());
			string.append(',');
		}
		
		string.append("]");
		
		return string.toString();
	}

    @Override
    public int indexOf(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}
