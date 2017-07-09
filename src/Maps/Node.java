package Maps;

public class Node<K extends Comparable, E> implements Comparable{
    K key;
    E element;    

    @Override
    public int compareTo(Object t) {
        return this.key.compareTo(t);
    }
}
