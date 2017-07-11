package Exercises;

import Lists.ArrayList;
import Queues.ListQueue;

import Queues.PriorityQueue;
import java.util.Scanner;

public class PqueueSpoj {

    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList();

        Scanner scan = new Scanner(System.in);

        int numberOfTimes = scan.nextInt();
        scan.nextLine();

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

                    if (myElement == 0)
                        break;
                    

                    myElement--;
                } else {
                    queue.enqueue(queue.dequeue());
                    if (myElement == 0)
                        myElement = queue.size() - 1;
                    else
                        myElement--;
                }
            }
            System.out.println(time);
        }
    }
}
