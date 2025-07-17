package OOP.L06_Solid.Demo.S03_LiskovSubstitution;

public class Person {


    public void driveCar(Car car){
        car.startEngine();
        car.drive();
        car.stopEngine();
    }
}
