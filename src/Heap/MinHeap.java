package Heap;

public class MinHeap {

    private int[] array = new int[100];
    private int size = 1;

    private void ensureSpace() {
        if (this.array.length < this.size * 2 + 1) {
            int[] newArray = new int[this.size * 3];

            System.arraycopy(this.array, 0, newArray, 0, this.array.length);

            this.array = newArray;
        }
    }

    private void maxHeapify(int i) {
        int smaller = i;
        int leftChildren = 2 * i;
        int rightChildren = 2 * i + 1;

        if (this.array[leftChildren] < this.array[smaller] && leftChildren < this.size) {
            smaller = leftChildren;
        }

        if (this.array[rightChildren] < this.array[smaller] && rightChildren < this.size) {
            smaller = rightChildren;
        }

        if (i != this.size - 1 && smaller != i) {
            int buffer = this.array[smaller];
            this.array[smaller] = this.array[i];
            this.array[i] = buffer;
            this.maxHeapify(smaller);
        }
    }

    private void increaseKeyValue(int i) {
        int parent = i / 2;

        if (i != 1 && (this.array[parent] > this.array[i])) {
            int buffer = this.array[parent];

            this.array[parent] = this.array[i];
            this.array[i] = buffer;

            this.increaseKeyValue(parent);
        }
    }

    public void insert(int n) {
        this.ensureSpace();

        this.array[size] = n;
        this.size += 1;

        this.increaseKeyValue(size - 1);
    }

    public int remove() {
        if (this.size > 1) {
            int buffer = this.array[1];
            this.array[1] = this.array[size - 1];
            this.size -= 1;

            this.maxHeapify(1);

            return buffer;
        }

        return -1;
    }

    public int peek() {
        return this.array[1];
    }

    public int size() {
        return this.size - 1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < this.size; i++) {
            builder.append(String.valueOf(this.array[i]));
            builder.append(' ');
        }

        return builder.toString();
    }
}
