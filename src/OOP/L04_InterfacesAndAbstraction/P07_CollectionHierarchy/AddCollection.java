package OOP.L04_InterfacesAndAbstraction.P07_CollectionHierarchy;

public class AddCollection extends Collection implements Addable {
    public int add(String item) {
        this.items.add(item);
        return this.items.size() - 1;
    }
}
