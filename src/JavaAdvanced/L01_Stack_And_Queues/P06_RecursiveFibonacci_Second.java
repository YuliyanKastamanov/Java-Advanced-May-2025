package L01_Stack_And_Queues;

import java.util.Scanner;

public class P06_RecursiveFibonacci_Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int position = Integer.parseInt(scanner.nextLine());

        long first = 0;
        long second = 1;
        long third = first + second;

        //F0	F1	F2	F3	F4	F5	F6	F7	F8	F9	F10	F11	F12	F13	F14	F15  F16	 F17	F18		F19
        //0	    1	1	2	3	5	8	13	21	34	55	89	144	233	377	610  987	 1597	2584	4181

        for (int i = 1; i <= position ; i++) {
            first = second;
            second = third;
            third = first + second;
        }

        System.out.println(first);


    }
}
