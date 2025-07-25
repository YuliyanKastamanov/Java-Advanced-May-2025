import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import p04_BubbleSortTest.Bubble;

public class BubbleUserTest {


    @Test
    public void whenProvideUnsortedArrayOfNumber_thenOrderedArray(){

        int[] array = {9, 7, 8, 3, 4, 6, 2, 1, 5};

        Bubble.sort(array);

        //очаквам подреден масив
        int[] orderedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Assertions.assertArrayEquals(array, orderedArray);


    }
}
