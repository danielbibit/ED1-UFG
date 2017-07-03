package Heap;

public class GenericMaxHeap<E extends Comparable<E>> implements Heap<E> {
    
    private Object[] array = new Object[100];
    private int size = 0;
    
    private void ensureSpace() {
        if (this.array.length < this.size * 2 + 1) {
            Object[] newArray = new Object[this.size * 3];

            System.arraycopy(this.array, 0, newArray, 0, this.array.length);

            this.array = newArray;
        }
    }
    
    private void maxHeapify(int i) {
        int bigger = i;
        int leftChildren = 2 * i + 1;
        int rightChildren = 2 * i + 2;
        
        if(((E)this.array[leftChildren]).compareTo((E)this.array[bigger]) > 0 && leftChildren < this.size - 1){
            bigger = leftChildren;
        }
        
        if(((E)this.array[rightChildren]).compareTo((E)this.array[bigger]) > 0 && leftChildren < this.size - 1){
            bigger = rightChildren;
        }

        if (i != this.size - 1 && bigger != i) {
            Object buffer = this.array[bigger];
            this.array[bigger] = this.array[i];
            this.array[i] = buffer;
            this.maxHeapify(bigger);
        }
    }
    
    private void increaseKeyValue(int i) {
        int parent = i / 2;
        
        if(i != 0 && ((E)this.array[parent]).compareTo((E)this.array[i]) < 0){
            Object buffer = this.array[parent];

            this.array[parent] = this.array[i];
            this.array[i] = buffer;

            this.increaseKeyValue(parent);
        }
    }
    
    @Override
    public void insert(E e) {
        this.ensureSpace();

        this.array[size] = e;
        this.size += 1;

        this.increaseKeyValue(size - 1);
    }

    @Override
    public E remove() {
        if (this.size > 0) {
            Object buffer = this.array[0];
            this.array[0] = this.array[size - 1];
            this.size -= 1;

            this.maxHeapify(0);

            return (E)buffer;
        }

        return null;
    }

    @Override
    public E peek() {
        return (E) this.array[0];
    }

    @Override
    public int size() {
        return this.size - 1;
    }

    @Override
    public String toString() {
         StringBuilder builder = new StringBuilder();

        for (int i = 0; i < this.size; i++) {
            builder.append((E)this.array[i].toString());
            builder.append(' ');
        }

        return builder.toString();
    }
}
