package Maps;

public interface Map<T extends Comparable, E> {
    public void add(T t, E e);
    public E get(T t);
    public T contains(E e);
    public E remove(T t);
}
