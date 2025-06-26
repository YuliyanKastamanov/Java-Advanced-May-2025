package L01_Stack_And_Queues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int numbersToPush = scanner.nextInt();
        int numbersToPop = scanner.nextInt();
        int numberToCheck = scanner.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= numbersToPush ; i++) {
            queue.offer(scanner.nextInt());

        }

        for (int i = 1; i <= numbersToPop ; i++) {
            queue.poll();
        }

        if(queue.contains(numberToCheck)){
            System.out.println("true");
        }else if(queue.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(Collections.min(queue));
        }

    }
}
