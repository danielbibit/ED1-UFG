package Lists;

public interface List <E> {
	public void add(E e);
	
	public void add(int index, E e);
	
	public E remove(int index);
	
	public E pop();
	
	public E get(int index);
	
	public void set(int index, E e);
	
	public int size();	
	
	@Override
	public String toString();
}
