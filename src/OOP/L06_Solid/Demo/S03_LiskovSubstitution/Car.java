package OOP.L06_Solid.Demo.S03_LiskovSubstitution;

public class Car {

    public void startEngine(){
        System.out.println("Starting normal car.");
    }

    public void drive(){
        System.out.println("Driving normal car.");
    }
    public void stopEngine(){
        System.out.println("Stopping normal car.");
    }
}
