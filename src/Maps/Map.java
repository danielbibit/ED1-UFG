package Maps;

public interface Map<K extends Comparable, E> {
    public void add(K k, E e);
    public E get(K k);
    public boolean containsKey(K k);
    public E remove(K k);
    public int size();
}
