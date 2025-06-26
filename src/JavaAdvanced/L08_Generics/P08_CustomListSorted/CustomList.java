package JavaAdvanced.L08_Generics.P08_CustomListSorted;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList <T extends Comparable<T>>{

    private List<T> list;
    public int size;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
        this.size++;
    }

    public T remove(int index) {

        this.size--;
        return this.list.remove(index);

    }


    public boolean contains(T element) {
        return this.list.contains(element);

    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(this.list, firstIndex, secondIndex);
    }

    public int countGreaterThen(T elementToCompare) {
        int count = 0;
        for (T element : list){
            if(element.compareTo(elementToCompare) > 0){
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        T max = this.list.get(0);

        for (T currentElement : list){
            if(currentElement.compareTo(max) > 0){
                max = currentElement;
            }
        }
        return max;
    }

    public T getMin() {
        T min = this.list.get(0);

        for (T currentElement : list){
            if(currentElement.compareTo(min) < 0){
                min = currentElement;
            }
        }
        return min;
    }


    public T get(int index) {

        return this.list.get(index);
    }
}
