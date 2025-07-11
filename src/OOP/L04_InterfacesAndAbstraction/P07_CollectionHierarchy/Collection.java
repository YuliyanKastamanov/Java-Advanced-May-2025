package OOP.L04_InterfacesAndAbstraction.P07_CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection  {
    private final int MaxSize = 100;
    protected List<String> items;

    protected Collection()
    {
        this.items = new ArrayList<String>(MaxSize);
    }
}
