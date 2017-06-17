//import java.util.ArrayList;
import java.util.Scanner;

class SpojGeneric {

    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList();

        Scanner scan = new Scanner(System.in);

        int numberOfTimes = 0;
        
        try{
            numberOfTimes = scan.nextInt();
            scan.nextLine();
        }catch(Exception e){
            
        }
        
        for (int k = 0; k < numberOfTimes; k++) {
            test.add(scan.nextLine());
            test.add(scan.nextLine());
        }

        while (test.size() != 0) {
            PriorityQueue heapQueue = new PriorityQueue();
            ListQueue<Integer> queue = new ListQueue();

            String l1 = test.remove(0);
            String l2 = test.remove(0);
            int time = 0;
            int myElement = 0;

            String[] numbersTemp;
            String[] parametersTemp;

            parametersTemp = l1.split(" ");
            numbersTemp = l2.split(" ");

            myElement = Integer.valueOf(parametersTemp[1]);

            for (String e : numbersTemp) {
                queue.enqueue(Integer.valueOf(e));
                heapQueue.enqueue(Integer.valueOf(e));
            }

            while (!queue.isEmpity()) {
                if (heapQueue.element() <= queue.element()) {
                    heapQueue.dequeue();
                    queue.dequeue();
                    time++;

                    if (myElement == 0) {
                        break;
                    }

                    myElement--;
                } else {
                    queue.enqueue(queue.dequeue());
                    if (myElement == 0) {
                        myElement = queue.size() - 1;
                    } else {
                        myElement--;
                    }
                }
            }
            System.out.println(time);
        }

    }
    
    static class MaxHeap {

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
            int bigger = i;
            int leftChildren = 2 * i;
            int rightChildren = 2 * i + 1;

            if (this.array[leftChildren] > this.array[bigger] && leftChildren < this.size) {
                bigger = leftChildren;
            }

            if (this.array[rightChildren] > this.array[bigger] && rightChildren < this.size) {
                bigger = rightChildren;
            }

            if (i != this.size - 1 && bigger != i) {
                int buffer = this.array[bigger];
                this.array[bigger] = this.array[i];
                this.array[i] = buffer;
                this.maxHeapify(bigger);
            }
        }

        private void increaseKeyValue(int i) {
            int parent = i / 2;

            if (i != 1 && (this.array[parent] < this.array[i])) {
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
            int buffer = -1;
            
            if (this.size > 1) {
                buffer = this.array[1];
                this.array[1] = this.array[size - 1];
                //this.array[size - 1] = 0;
                this.size -= 1;

                this.maxHeapify(1);
            }

            return buffer;
        }

        public int peek() {
            return this.array[1];
        }

        public int size() {
            return this.size - 1;
        }

        public void printTree() {
            int number = 1;
            int treeLayers = this.size / 2 - 1;

            for (int i = 0; i < treeLayers; i++) {
                for (int j = 0; j < Math.pow(2, i); j++) {
                    for (int k = 0; k < treeLayers / (i + 1); k++) {
                        System.out.print(" ");
                    }
                    System.out.print(this.array[number]);
                    number += 1;
                }
                System.out.println();
            }
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

    static class PriorityQueue {

        private MaxHeap heap = new MaxHeap();

        public boolean enqueue(int i) {
            heap.insert(i);

            return true;
        }

        public int dequeue() {
            return heap.remove();
        }

        public int element() {
            return heap.peek();
        }

        public int size() {
            return this.heap.size();
        }

        public boolean isEmpity() {
            return this.size() == 0;
        }

        @Override
        public String toString() {
            return heap.toString();
        }
    }

    interface Queue<E> {

        public boolean enqueue(E e);

        public E dequeue();

        public E element();

        public int size();

        public boolean isEmpity();

    }

    static class ListQueue<E> implements Queue<E> {

        private final ArrayList<E> list = new ArrayList();

        @Override
        public boolean enqueue(E e) {
            this.list.add(e);

            return true;
        }

        /*modify this !*/
        @Override
        public E dequeue() {
            if (this.size() > 0) {
                return this.list.remove(0);
            } else {
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
        public String toString() {
            return this.list.toString();
        }
        

    }
   
    interface List<E> {

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

    static class ArrayList<E> implements List<E> {

        private Object array[];
        private int size = 0;

        public ArrayList() {
            this(200);
        }

        public ArrayList(int size) {
            this.array = new Object[size];
        }

        private void ensureSpace() {
            if (this.size == this.array.length - 1) {
                Object newArray[] = new Object[this.size + 100];

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

            for (int i = this.size; i >= index; i--) {
                this.array[i] = this.array[i - 1];
            }

            this.array[index] = e;

            this.size += 1;
        }

        @Override
        public E remove(int index) {
            E temp = (E) array[index];

            for (int i = index; i < this.size; i++) {
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

            for (int i = 0; i < this.size; i++) {
                string.append(this.array[i].toString());
                string.append(',');
            }

            string.append("]");

            return string.toString();
        }

    }

}
