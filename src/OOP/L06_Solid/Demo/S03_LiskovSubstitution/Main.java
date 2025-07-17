package OOP.L06_Solid.Demo.S03_LiskovSubstitution;

public class Main {
    public static void main(String[] args) {

        Car car = new Car();

        ElectricCar electricCar = new ElectricCar();

        Karuchka karuchka = new Karuchka();

        Person person = new Person();

        person.driveCar(car);
        person.driveCar(electricCar);

        person.driveCar(karuchka);


    }
}
