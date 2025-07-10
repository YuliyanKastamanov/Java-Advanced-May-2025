package OOP.L05_Polymorphism.P02_VehiclesExtension;

public class Bus extends Vehicle{

    private double emptyBusFuelConsumption;
    private double nonEmptyBusFuelConsumption;

    private final static double ADDITIONAL_FUEL_CONSUMPTION_FOR_NON_EMPTY_BUS = 1.4;



    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.emptyBusFuelConsumption = fuelConsumption;
        this.nonEmptyBusFuelConsumption = fuelConsumption + ADDITIONAL_FUEL_CONSUMPTION_FOR_NON_EMPTY_BUS;
    }

    //Карам автобус с хора! -> не е Празен
    @Override
    public String drive(double distance) {
        //променяме стойността на fuelConsumption
        this.setFuelConsumption(nonEmptyBusFuelConsumption);
        //изпълняваме логиката в бащиния клас
        return super.drive(distance);
    }

    //Придвижвам се с празен автобус
    public String driveEmpty(double distance){
        this.setFuelConsumption(emptyBusFuelConsumption);
        return super.drive(distance);
    }
}
