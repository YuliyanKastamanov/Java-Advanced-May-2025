package L08_Generics.P08_CustomListSorted;

public class Sorted {


    public static <T extends Comparable<T>> void  sort(CustomList<T> customList) {

        for (int i = 0; i < customList.size; i++) {
            T currentElement = customList.get(i);

            for (int j = i + 1; j < customList.size; j++) {
                T target = customList.get(j);
                if(currentElement.compareTo(target) > 0){
                    customList.swap(i, j);
                }


            }

        }
    }
}
