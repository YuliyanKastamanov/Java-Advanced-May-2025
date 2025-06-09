package L08_Generics.P01_06_Box;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {

    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T value){
        this.values.add(value);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (T value : this.values){
            //java.lang.String: value
            //{class full name}: value
            String formattedValue = String.format("%s: %s", value.getClass().getName(), value);
            builder.append(formattedValue).append(System.lineSeparator());
        }

        return builder.toString();
    }

    public void swap(int index1, int index2) {

        //Разменя местата на елементите от този списък на тези два индекса
        //Collections.swap(this.values, index1, index2);

        T firstValue = values.get(index1);
        T secondValue = values.get(index2);

        this.values.set(index1, secondValue);
        this.values.set(index2, firstValue);
    }

    public int countGreaterValues(T valueToCompare) {

        int count = 0;

        for (T value : values){
            //Сравняваме дали стойността от списъка е по-голяма от стойността, с която сравняваме
            // първото > второто = 1 или повече
            int comparingResult = value.compareTo(valueToCompare);
            if(comparingResult > 0){
                count++;
            }
        }
        return count;

    }
}
