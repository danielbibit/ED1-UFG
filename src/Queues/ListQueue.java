package Queues;

import Lists.*;

public class ListQueue<E> implements Queue<E> {

	private final ArrayList<E> list = new ArrayList(); 
	
	@Override
	public boolean enqueue(E e) {
		this.list.add(e);
	
		return true;
	}
	
	/*modify this !*/
	@Override
	public E dequeue(){
		if(this.size()>0){
			return this.list.remove(0);
		}else{
			return null;
		}
	}

	@Override
	public E element() {
		return list.get(0);
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public boolean isEmpity() {
		return this.list.size() == 0;
	}
    
    @Override
    public String toString(){
        return this.list.toString();
    }
	
}
