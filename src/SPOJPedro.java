import java.util.Scanner;
 
class SPOJPedro {
 
    interface List<T> {
 
        public void insert(int i, T object);
 
        public void insert(T object);
 
        public T remove(int i);
 
        public boolean isEmpty();
 
        public int getSize();
 
        public T get(int i);
 
        public void set(int i, T object);
 
    }
 
    static class ListArray<T> implements List<T> {
 
        private Object[] objects = new Object[5];
        private int size = 0;
 
        @Override
        public void insert(int i, T object) {
 
            if (size == (objects.length - 1)) {
                increaseSize();
            }
 
            for (int j = size; j > i; j--) {
                objects[j] = objects[j - 1];
            }
 
            objects[i] = object;
 
            size++;
        }
 
        @Override
        public T remove(int i) {
 
            Object buffer = objects[i];
 
            for (int j = i; j < size; j++) {
                objects[j] = objects[j + 1];
            }
            objects[size] = null;
            size--;
 
            return (T) buffer;
        }
 
        @Override
        public boolean isEmpty() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
 
        @Override
        public int getSize() {
            return size;
        }
 
        @Override
        public T get(int i) {
            return (T) objects[i];
        }
 
        @Override
        public void set(int i, T object) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
 
        private void increaseSize() {
 
            Object[] x = new Object[objects.length + 5];
 
            for (int i = 0; i < objects.length; i++) {
 
                x[i] = objects[i];
            }
 
            objects = x;
        }
 
        @Override
        public void insert(T object) {
            if (size == (objects.length - 1)) {
                increaseSize();
            }
 
            objects[size] = object;
 
            size++;
        }
 
        @Override
        public String toString() {
            StringBuilder string = new StringBuilder("{");
            try {
                for (int j = 0; j < size; j++) {
                    string.append((objects[j].toString()));
                    if (!(j == size - 1)) {
                        string.append(", ");
                    }
                }
                string.append("}");
            } catch (Exception e) {
            }
            return string.toString();
        }
 
    }
 
    interface Queue<T> {
 
        public boolean add(T object); // 
 
        public T element();
 
        //public boolean offer(T object);
        //public T peek();
        //public T pool();
        public T remove();
 
    }
 
    static class QueueList<T> implements Queue<T> {
 
        private ListArray<T> objects = new ListArray();
        private int size = 0;
 
        @Override
        public boolean add(T object) {
            objects.insert(object);
            size++;
            return true;
        }
 
        @Override
        public T element() {
            return objects.get(0);
        }
 
        @Override
        public T remove() {
            size--;
            return objects.remove(0);
        }
 
        @Override
        public String toString() {
            return objects.toString();
        }
 
        public int getSize() {
            return size;
        }
 
        public boolean isEmpty() {
            return size == 0;
        }
    }
 
    static class HeapBinary {
 
        public int getSize() {
            return size - 1;
        }
 
        //40 20 60 80 10 30 90 70 50
        private int values[] = new int[100];
        private int size = 1;
 
        public void insert(int value) {
 
            checkSpace();
 
            values[size] = value;
            size++;
 
            this.increaseKeyValue(size - 1);
        }
 
        public int remove() {
 
            checkSpace();
 
            int buff = -1;
            
            if (size > 1) {
                buff = values[1];
                values[1] = values[size - 1];
                size--;
                this.maxHeapfy(1);
            }
 
            return buff;
        }
 
        public void maxHeapfy(int i) {
            int large = i;
            int l = 2 * i;
            int r = (2 * i) + 1;
 
            if ((values[l] > values[large]) && (l < size)) {
                large = l;
            }
            if (values[r] > values[large] && (r < size)) {
                large = r;
            }
            if (i != size - 1 && large != i) {
                int buff = values[large];
                values[large] = values[i];
                values[i] = buff;
                maxHeapfy(large);
            }
 
        }
 
        public void increaseKeyValue(int i) {
 
            int parent = i / 2;
 
            if ((i != 1) && (values[parent] < values[i])) {
                int buff = values[parent];
                values[parent] = values[i];
                values[i] = buff;
                increaseKeyValue(parent);
            }
        }
 
        public int element() {
            return values[1];
        }
 
        @Override
        public String toString() {
            StringBuilder string = new StringBuilder();
            for (int j = 1; j < size; j++) {
                string.append((String.valueOf(values[j])));
                string.append(" ");
            }

            return string.toString();
        }
 
        public void printTree() {
            int cont = 1;
            int layers = size / 2 - 1;
 
            for (int i = 0; i < layers; i++) {
 
                for (int j = 0; j < Math.pow(2, i); j++) {
 
                    for (int k = 0; k < layers / (i + 1); k++) {
                        System.out.print(" ");
                    }
 
                    System.out.print(values[cont] + " ");
                    cont++;
                }
                System.out.println();
            }
 
        }
 
        public void checkSpace() {
            if (values.length < size * 2 + 1) {
                int x[] = new int[size * 3];
 
                System.arraycopy(values, 0, x, 0, values.length);
 
                values = x;
 
            }
        }
    }
 
    static class QueuePriority {
 
        public HeapBinary heap = new HeapBinary();
 
        public boolean add(int i) {
            heap.insert(i);
            return true;
        }
 
        public int element() {
            return heap.element();
        }
 
        public int remove() {
            return heap.remove();
        }
 
        public int size() {
            return heap.getSize();
        }
 
        public boolean isEmpty() {
            return size() == 0;
        }
        
        @Override
        public String toString(){
            return this.heap.toString();
        }
    }
     
    public static void main(String[] args) {
 
        ListArray<String> test = new ListArray();
 
        Scanner scan = new Scanner(System.in);
 
        int numberOfTimes = scan.nextInt();
        scan.nextLine();
 
        for (int k = 0; k < numberOfTimes; k++) {
            test.insert(scan.nextLine());
            test.insert(scan.nextLine());
        }
 
        while (test.getSize() != 0) {
            QueuePriority heapQueue = new QueuePriority();
            QueueList<Integer> queue = new QueueList();
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
                queue.add(Integer.valueOf(e));
                heapQueue.add(Integer.valueOf(e));
            }
 
            while (!queue.isEmpty()) {
                if (heapQueue.element() <= queue.element()) {
                    heapQueue.remove();
                    queue.remove();
                    time++;
 
                    if (myElement == 0) {
                        break;
                    }
 
                    myElement--;
                } else {
                    queue.add(queue.remove());
                    if (myElement == 0) {
                        myElement = queue.getSize() - 1;
                    } else {
                        myElement--;
                    }
                }
            }
            System.out.println(time);
        }
    }
}