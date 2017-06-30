package Heap;

public interface Heap <T extends Comparable, E> {
    public void insert(E e);
    public E remove();
}
