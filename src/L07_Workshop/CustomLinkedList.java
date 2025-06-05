package L07_Workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomLinkedList {

    private Element head;
    private Element tail;
    private int size;


    public void addFirst(int elementValue){

        //имаме два сценария -> когато нямаме елементи
        if(this.isEmpty()){
            //изнасяме логиката в метод, за да я преизползваме
            addIfEmpty(elementValue);
        }else {
            Element newElement = new Element(elementValue, null, this.head);
            this.head.prev = newElement;
            this.head =  newElement;

        }
        this.size++;
    }

    public void addLast(int elementValue){
        if(this.isEmpty()){
            addIfEmpty(elementValue);
        }else {
            Element newElement = new Element(elementValue, this.tail, null);
            this.tail.next = newElement;
            this.tail = newElement;
        }
        this.size++;

    }


    public int get(int index){

        //проверяваме дали индексът е валидем
        if(!isValidIndex(index)){
            throw new IndexOutOfBoundsException("Provided index is invalid!");
        }

        Element currentElement = this.head;

        for (int position = 0; position < index; position++) {
            currentElement = currentElement.next;
        }
        return currentElement.value;
    }

    public int removeFirst(){
        if(this.isEmpty()){
            throw new NoSuchElementException("The collection is empty!");
        }


        int result = this.head.value;
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }else {
            this.head = this.head.next;
            this.head.prev = null;
        }

        this.size--;
        return result;
    }

    public int removeLast(){
        if(this.isEmpty()){
            throw new NoSuchElementException("The collection is empty!");
        }

        int result = this.tail.value;
        if(this.size == 1) {
            this.head = null;
            this.tail = null;
        }else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return result;

    }

    public void forEach(Consumer<Integer> consumer) {
        Element currentElement = this.head;

        while (currentElement != null) {
            consumer.accept(currentElement.value);
            currentElement = currentElement.next;

        }
    }

    public int[] toArray(){
        List<Integer> numbers = new ArrayList<>();
        this.forEach(value -> numbers.add(value));
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isValidIndex(int index) {

        return index >= 0 && index < this.size;
    }

    private void addIfEmpty(int elementValue) {
        Element newElement = new Element(elementValue, null, null);
        this.head = newElement;
        this.tail = newElement;
    }

    public boolean isEmpty(){

        return this.size == 0;
    }
}
