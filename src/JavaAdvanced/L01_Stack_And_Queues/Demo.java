package L01_Stack_And_Queues;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Stack
        //LIFO - last in - first out

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);





        System.out.println(stack.pop());
        System.out.println(stack.peek());

        //Queue
        //FIFO - first in - first out

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println(queue.poll());

        //IllegalStateException if add more than 3 elements
        ArrayBlockingQueue<Integer> newQueue = new ArrayBlockingQueue<>(3);

        newQueue.add(10);
        newQueue.add(20);
        newQueue.add(30);
        newQueue.add(40);




    }
}
