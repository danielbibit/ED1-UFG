package Heap;

public interface Heap <E extends Comparable> {
    public void insert(E e);
    public E remove();
    public E peek();
    public int size();
    @Override
    public String toString();
}
