package furnitureFactory.entities.workshops;

import furnitureFactory.entities.wood.Wood;

public abstract class BaseWorkshop implements Workshop{

    private int woodQuantity;
    private int producedFurnitureCount;
    private int woodQuantityReduceFactor;

    public BaseWorkshop(int woodQuantity, int woodQuantityReduceFactor) {
        this.setWoodQuantity(woodQuantity);
        this.woodQuantityReduceFactor = woodQuantityReduceFactor;
        this.producedFurnitureCount = 0;
    }

    public void setWoodQuantityReduceFactor(int woodQuantityReduceFactor) {
        this.woodQuantityReduceFactor = woodQuantityReduceFactor;
    }

    public void setProducedFurnitureCount(int producedFurnitureCount) {
        this.producedFurnitureCount = producedFurnitureCount;
    }

    public void setWoodQuantity(int woodQuantity) {
        if(woodQuantity <= 0){
            woodQuantity = 0;
        }
        this.woodQuantity = woodQuantity;
    }

    @Override
    public int getWoodQuantity() {
        return woodQuantity;
    }

    @Override
    public int getProducedFurnitureCount() {
        return producedFurnitureCount;
    }

    @Override
    public int getWoodQuantityReduceFactor() {
        return woodQuantityReduceFactor;
    }

    @Override
    public void addWood(Wood wood) {
        this.woodQuantity += wood.getWoodQuantity();
    }


}
