package OOP.L05_Polymorphism.P02_VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {

    protected double fuelQuantity;
    protected double fuelConsumption;

    protected double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public String drive(double distance){
        //Car, Truck, Bus
        double fuelNeeded = distance * fuelConsumption;

        //проверяваме дали имаме достатъчно гориво
        if(fuelNeeded > this.fuelQuantity){
            //принтираме, че нямаме достатъчно гориво
            return  String.format("%s needs refueling", this.getClass().getSimpleName());
        }

        //изминаваме разстоянието -> трябва да намалим горивото
        this.setFuelQuantity(this.fuelQuantity - fuelNeeded);
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(distance));
    }

    public void refuel(double liters){

        //проверяваме дали литрите гориво са отрицателно число или 0
        if(liters <= 0){
            System.out.println("Fuel must be a positive number");
            return;
        }
        //дали имаме място в резорвоара
        else if(this.getFuelQuantity() + liters > this.getTankCapacity()){
            System.out.println("Cannot fit fuel in tank");
            return;
        }
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
