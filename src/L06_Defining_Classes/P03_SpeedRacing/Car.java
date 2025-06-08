package speedRacing;

//описваме как ще изглежда всяка една кола
public class Car {
    //полета -> характеристиките на колата
    private String model; //модел на колата
    private double fuel; //литри текущо налично гориво
    private double fuelCostPerKm; //цена на горивото за 1 км
    private int distanceTraveled; //изминати километри

    //конструктор
    public Car(String model, double fuel, double fuelCostPerKm) {
        //нова кола
        this.model = model;
        this.fuel = fuel;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = 0;
    }

    //методи -> описваме действията на колата
    public String getModel() {
        return this.model;
    }

    //действието каране
    public void drive(int kmToDrive) {
        //проверка дали ще ми стигне горивото в колата
        double neededFuel = kmToDrive * this.fuelCostPerKm;
        if (this.fuel >= neededFuel) {
            //имаме нужното гориво -> качваме се на колата и я караме
            this.distanceTraveled += kmToDrive;
            this.fuel -= neededFuel;
        } else {
            //this.fuel < neededFuel -> нямаме нужното гориво
            System.out.println("Insufficient fuel for the drive");
        }
    }

    //toString -> получаваме обекта под формата на текст
    @Override
    public String toString() {
        //"{Model} {fuelAmount} {distanceTraveled}"
        return String.format("%s %.2f %d", this.model, this.fuel, this.distanceTraveled);
    }

}
