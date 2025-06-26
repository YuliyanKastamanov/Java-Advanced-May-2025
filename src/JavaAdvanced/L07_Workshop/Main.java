package L07_Workshop;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {



        CustomLinkedList customLinkedList = new CustomLinkedList();

        customLinkedList.addFirst(10);
        customLinkedList.addFirst(20);
        customLinkedList.removeFirst();
        customLinkedList.removeLast();

        LinkedList<Integer> numbers = new LinkedList<>();


        System.out.println(customLinkedList);

    }
}
