package L07_Workshop;

public class Element {

   int value;
   Element prev;
   Element next;

    public Element(int value, Element prev, Element next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }



    @Override
    public String toString() {
        return String.valueOf(this.value);
    }


}
