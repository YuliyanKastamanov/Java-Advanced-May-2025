package competition.entities.car;

import competition.common.ExceptionMessages;

public class BaseCar implements Car{

    private String model;
    private int batteryCapacity;

    private int mileage;

    public BaseCar(String model, int batteryCapacity) {
        this.setModel(model);
        this.setBatteryCapacity(batteryCapacity);
        this.mileage = 0;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.CAR_MODEL_NULL_OR_EMPTY);
        }
        this.model = model;
    }

    @Override
    public int getBatteryCapacity() {
        return batteryCapacity;
    }



    public void setBatteryCapacity(int batteryCapacity) {
        if(batteryCapacity < 0){
            batteryCapacity = 0;
        }
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public int getMileage() {
        return mileage;
    }

    @Override
    public void drive() {
        this.setBatteryCapacity(getBatteryCapacity() - 15);
        this.setMileage(getMileage() + 25);
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
