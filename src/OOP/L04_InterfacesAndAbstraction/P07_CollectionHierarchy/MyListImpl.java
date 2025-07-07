package OOP.L04_InterfacesAndAbstraction.P07_CollectionHierarchy;

public class MyListImpl extends Collection implements MyList {
    public int getUsed(){
        return this.items.size();
    }

    public int add(String item)
    {
        this.items.add(0, item);
        return 0;
    }

    public String remove()
    {
        String itemToRemove = this.items.get(0);
        this.items.remove(0);
        return itemToRemove;
    }
}
