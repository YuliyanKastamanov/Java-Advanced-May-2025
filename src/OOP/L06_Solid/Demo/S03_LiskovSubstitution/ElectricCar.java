package OOP.L06_Solid.Demo.S03_LiskovSubstitution;

public class ElectricCar extends Car{

    @Override
    public void startEngine() {
        System.out.println("Starting electric car.");
    }

    @Override
    public void drive() {
        System.out.println("Driving electric car.");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping electric car.");
    }
}
