package L01_Stack_And_Queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       // String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(stack::push);




/*
        for (String number : tokens){
            stack.push(number);
        }*/

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }





    }
}
