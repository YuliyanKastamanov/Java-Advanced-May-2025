package furnitureFactory.entities.workshops;

public class TableWorkshop extends BaseWorkshop{

    //It can be added only in OrdinaryFactory!

    private static final int TABLE_WOOD_QUANTITY_REDUCE_FACTOR = 50;

    public TableWorkshop(int woodQuantity) {
        super(woodQuantity, TABLE_WOOD_QUANTITY_REDUCE_FACTOR);
    }

    @Override
    public void produce() {
        if(this.getWoodQuantity() >= TABLE_WOOD_QUANTITY_REDUCE_FACTOR){
            int producedTablesCount = this.getProducedFurnitureCount();
            super.setProducedFurnitureCount(producedTablesCount + 1);
            super.setWoodQuantity(this.getWoodQuantity() - TABLE_WOOD_QUANTITY_REDUCE_FACTOR);
        }

    }
}
