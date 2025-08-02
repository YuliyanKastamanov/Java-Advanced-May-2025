package furnitureFactory.entities.workshops;

public class DeckingWorkshop extends BaseWorkshop{

    //It can be added only in AdvancedFactory!

    private static final int DECKING_WOOD_QUANTITY_REDUCE_FACTOR = 150;

    public DeckingWorkshop(int woodQuantity) {
        super(woodQuantity, DECKING_WOOD_QUANTITY_REDUCE_FACTOR);
    }


    @Override
    public void produce() {
        if(this.getWoodQuantity() >= DECKING_WOOD_QUANTITY_REDUCE_FACTOR){
            int producedDeckingCount = this.getProducedFurnitureCount();
            super.setProducedFurnitureCount(producedDeckingCount + 1);
            super.setWoodQuantity(this.getWoodQuantity() - DECKING_WOOD_QUANTITY_REDUCE_FACTOR);
        }
    }
}
